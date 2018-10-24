package com.example.user.testalarm;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmService extends AppCompatActivity {

    Toast mToast;
    int id;
    int flag;
    int vib,sou;
    String name;
    AlarmManager malarmManager;
    Calendar mCalendar;
    int interval = 24 * 60 * 60 * 1000;
    SeekBar sb;
    Vibrator vibrator;
    MediaPlayer mediaPlayer;
    TextView textView;
    ListViewItem temp;

    private static PowerManager.WakeLock sCpuWakeLock;
    private static KeyguardManager.KeyguardLock mKeyguardLock;
    private static boolean isScreenLock;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acquireCpuWakeLock(this);
        setContentView(R.layout.lockoff);

        sb = (SeekBar) findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(20);
            }
            public void onStartTrackingTouch(SeekBar seekBar) { }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if ( progress >= 150) {
                    if ( vib == 1) {
                        vibrator.cancel();
                    }
                    if ( sou == 1) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                    AlarmService.this.finish(); //알람 꺼짐
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class); // 메인으로 돌아감
                    startActivity(intent);
                    //Intent mainIntent = new Intent(Intent.ACTION_MAIN);
                    //mainIntent.addCategory(Intent.CATEGORY_HOME);
                    //mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //startActivity(mainIntent);
                }
            }
        });



        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(AlarmService.this,R.raw.test);
        mediaPlayer.setLooping(true);
        malarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        id = getIntent().getIntExtra("ID",-1);
        flag = getIntent().getIntExtra("FLAG",-1);
        vib = getIntent().getIntExtra("VIBRATE",-1);
        sou = getIntent().getIntExtra("SOUND",-1);
        name = getIntent().getStringExtra("NAME");
        mCalendar = Calendar.getInstance();



        textView = (TextView) findViewById(R.id.alarmtitle);
        if ( name == "")
            textView.setText("설정하신 시간이 되었습니다.");
        else
            textView.setText(name+" 시간이 되었습니다.");

        //mToast = Toast.makeText(getApplicationContext(),"AlarmService 도착",Toast.LENGTH_LONG);
        //mToast.show();

        if ( flag >  0)
        {
            //mToast = Toast.makeText(getApplicationContext(),"알람이 재등록 되었습니다.",Toast.LENGTH_LONG);
            //mToast.show();
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent sender = PendingIntent.getBroadcast(this, id, intent,0);

            malarmManager.cancel(sender);

            if (Build.VERSION.SDK_INT >= 23)
                malarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis()+interval, sender);
            else
            {
                if ( Build.VERSION.SDK_INT >= 19)
                    malarmManager.setExact(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis()+interval, sender);
                else
                    malarmManager.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis()+interval, sender);
            }

            sender.cancel();
        }

        if ( flag == 0 || flag == 1)
        {
            ///알람이 울리는 부분 진동과 사운드를 설정!
            if ( vib == 1) {
                long[] pattern = {100, 300, 100, 700, 300, 2000};
                vibrator.vibrate(pattern, 0);
            }
            if ( sou == 1) {
                mediaPlayer.start();
            }
            mToast = Toast.makeText(getApplicationContext(),"지정하신 시간입니다. 준비하세요.",Toast.LENGTH_LONG);
            mToast.show();

        }



    }
    static void acquireCpuWakeLock(Context context) {

        if (sCpuWakeLock != null) {
            return;
        }
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        sCpuWakeLock = pm.newWakeLock(
                PowerManager.SCREEN_BRIGHT_WAKE_LOCK |
                        PowerManager.ACQUIRE_CAUSES_WAKEUP |
                        PowerManager.ON_AFTER_RELEASE, "hello");

        sCpuWakeLock.acquire();
    }


}
