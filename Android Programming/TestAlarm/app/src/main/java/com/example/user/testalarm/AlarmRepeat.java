package com.example.user.testalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmRepeat extends AppCompatActivity {
    Toast mToast;
    int id;
    int flag;
    int vibrate,sound;
    AlarmManager malarmManager;
    Calendar mCalendar;
    int interval = 24 * 60 * 60 * 1000;
    SeekBar sb;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        malarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        id = getIntent().getIntExtra("ID",-1);
        flag = getIntent().getIntExtra("FLAG",-1);
        vibrate = getIntent().getIntExtra("VIBRATE",-1);
        sound = getIntent().getIntExtra("SOUND",-1);
        mCalendar = Calendar.getInstance();

        if ( flag == 2)
        {
            mToast = Toast.makeText(getApplicationContext(),"알람이 재등록 되었습니다.",Toast.LENGTH_LONG);
            mToast.show();
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
        AlarmRepeat.this.finish();
    }
}
