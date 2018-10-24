package com.example.user.testalarm;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import static com.example.user.testalarm.MainActivity.adapter;

import java.util.Calendar;



public class AlarmAdd extends AppCompatActivity {
    public static AlarmManager mAlarmManager;
    public static PendingIntent[] mPendingIntentList;
    public static int[] week;
    public static int index = 0;
    public static int[] mode;

    Toast mToast;
    Intent mAlarmIntent;
    Calendar mCalendar;
    TimePicker timePicker;
    int hour,minute;
    int tmp_vibrate,tmp_sound;
    DBHelper dbHelper;
    ListViewItem tmp_item = new ListViewItem();

    EditText editText;
    String s;
    String repeat;
    String setTime;
    String setName;
    String[] ListItems;
    Button mBtn;
    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        mode = new int[3];

        mBtn = findViewById(R.id.b1);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListItems = new String[]{"기본","사칙연산","흔들기"};
                AlertDialog.Builder mBuilder =new AlertDialog.Builder(AlarmAdd.this);
                mBuilder.setTitle("choose");
                mBuilder.setIcon(R.drawable.alarm_icon);
                mBuilder.setSingleChoiceItems(ListItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if ( i == 0 ) {
                            mode[0] = 1;
                        }
                        if ( i == 1 ) {
                            mode[1] = 1;
                        }
                        if ( i == 2 ) {
                            mode[2] = 1;
                        }
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });



        tmp_vibrate = 0;
        tmp_sound = 0;

        repeat = new String();
        setTime = new String();
        setName = new String();
        mPendingIntentList = new PendingIntent[100];
        mCalendar = Calendar.getInstance();
        timePicker = (TimePicker) findViewById(R.id.tp);
        editText = (EditText) findViewById(R.id.edit_name);

        mAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        mAlarmIntent = new Intent(this,AlarmReceiver.class);

        findViewById(R.id.add_press).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        registAlarm();

                        //알람 설정이 다되었다면 처음 화면으로 다시 넘어가는 코드
                        adapter.addItem(getResources().getDrawable(R.drawable.ic_add_alarm_black_24dp),
                                setName, "반복 : " + repeat + "// 시간 : "+ setTime, tmp_item);
                        adapter.notifyDataSetChanged();
                        AlarmAdd.this.finish();
                    }
                }
        );
        findViewById(R.id.delete_press).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        AlarmAdd.this.finish();
                    }
                }
        );
    }

    private void registAlarm()
    {
        CheckBox check_mon = (CheckBox) findViewById(R.id.check_monday);
        CheckBox check_tue = (CheckBox) findViewById(R.id.check_tuesday);
        CheckBox check_wed = (CheckBox) findViewById(R.id.check_wednesday);
        CheckBox check_thu = (CheckBox) findViewById(R.id.check_thursday);
        CheckBox check_fri = (CheckBox) findViewById(R.id.check_friday);
        CheckBox check_sat = (CheckBox) findViewById(R.id.check_staurday);
        CheckBox check_sun = (CheckBox) findViewById(R.id.check_sunday);
        Switch mvibrate = (Switch) findViewById(R.id.vibrate);
        Switch msound = (Switch) findViewById(R.id.sound);



        week = new int[7];


        boolean mon = false,tue = false,wed = false,thu = false,fri = false,sat = false,sun = false;

        if ( check_mon.isChecked() == true ) { week[0] = 1; mon = true; repeat += "월 ";}
        if ( check_tue.isChecked() == true ) { week[1] = 1; tue = true; repeat += "화 ";}
        if ( check_wed.isChecked() == true ) { week[2] = 1; wed = true; repeat += "수 ";}
        if ( check_thu.isChecked() == true ) { week[3] = 1; thu = true; repeat += "목 ";}
        if ( check_fri.isChecked() == true ) { week[4] = 1; fri = true; repeat += "금 ";}
        if ( check_sat.isChecked() == true ) { week[5] = 1; sat = true; repeat += "토 ";}
        if ( check_sun.isChecked() == true ) { week[6] = 1; sun = true; repeat += "일 ";}
        if ( mvibrate.isChecked())
            tmp_vibrate = 1;
        if (msound.isChecked())
            tmp_sound = 1;

        int temp = week[0] + week[1] + week[2] + week[3] + week[4] + week[5] + week[6];
        if ( temp == 0 ) repeat = "없음";

        hour = timePicker.getHour();
        minute = timePicker.getMinute();
        setTime = ""+ hour+"시 "+minute+"분";
        Editable str = editText.getText();
        setName = str.toString();

        if(hour<12)
            s = "AM";
        else
            s = "PM";

        mPendingIntentList[index] = PendingIntent.getBroadcast(this, index, mAlarmIntent,0);

        mToast =Toast.makeText(getApplicationContext(),"Select time : "+hour+":"+minute+s,Toast.LENGTH_LONG);
        mToast.show();

        mCalendar.setTimeInMillis(System.currentTimeMillis());
        // 입력받은시간으로 알람을 설정
        mCalendar.set(Calendar.HOUR_OF_DAY, hour);
        mCalendar.set(Calendar.MINUTE, minute);
        //mCalendar.set(Calendar.SECOND, 0);
        mCalendar.add(Calendar.SECOND,10);

        if (Build.VERSION.SDK_INT >= 23)
            mAlarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), mPendingIntentList[index]);
        else
        {
            if ( Build.VERSION.SDK_INT >= 19)
                mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), mPendingIntentList[index]);
            else
                mAlarmManager.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), mPendingIntentList[index]);
        }

        tmp_item = null;
        tmp_item = new ListViewItem();
        tmp_item.set_id(index);
        tmp_item.setHour(hour);
        tmp_item.setMinute(minute);
        tmp_item.setWeek(week);
        tmp_item.setVibrate(tmp_vibrate);
        tmp_item.setSound(tmp_sound);
        tmp_item.setName(setName);
        tmp_item.setMode(mode);

        if( dbHelper == null ) {
            dbHelper = new DBHelper(AlarmAdd.this, "ALARM_TABLE", null, 1);
        }
        //dbHelper.deleteAll();
        dbHelper.addTuple(tmp_item); //////////////////등록시 에러발생
        index++;

        mToast =Toast.makeText(getApplicationContext(),"알람등록 완료 "+hour+" : "+minute+s,Toast.LENGTH_LONG);
        mToast.show();
    }
}
