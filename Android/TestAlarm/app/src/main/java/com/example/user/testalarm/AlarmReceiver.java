package com.example.user.testalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.user.testalarm.MainActivity.index;
/*
 * Created by user on 2018-03-15.
 */

public class AlarmReceiver extends BroadcastReceiver {
    public Toast mToast;
    public int tmp_index;
    ListViewItem temp;
    public int hour,minute,aWeekday;
    public Calendar mCalendar;
    int interval = 24 * 60 * 60 * 1000;
    DBHelper dbHelper;

    public void onReceive(Context context, Intent intent) {

        //mToast = Toast.makeText(context,"지정된 시간이 되어 알람이 울립니다.",Toast.LENGTH_LONG);
        //mToast.show();

        tmp_index = -1;
        mCalendar = Calendar.getInstance();
        hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        minute = mCalendar.get(Calendar.MINUTE);
        aWeekday = mCalendar.get(Calendar.DAY_OF_WEEK);
        if ( aWeekday == 1)
            aWeekday = 7;
        else
            aWeekday--;


        if ( dbHelper == null) {
            dbHelper = new DBHelper(context,"ALARM_TABLE",null,1);
        }
        ArrayList<ListViewItem> alarmDatas = dbHelper.getAllAlarmData();


        for ( int i = 0; i < alarmDatas.size(); i++)
        {
            temp = alarmDatas.get(i);

            if ( temp.getHour() == hour &&  temp.getMinute() == minute ) {
                Intent intent2 = new Intent(context, AlarmService.class);
                intent2.putExtra("ID", temp.get_id());
                intent2.putExtra("FLAG", 0);
                intent2.putExtra("VIBRATE", temp.getVibrate());
                intent2.putExtra("SOUND", temp.getSound());
                intent2.putExtra("NAME", temp.getName());

                if (((temp.getMon() + temp.getTue() + temp.getWed() + temp.getThu() + temp.getFri() + temp.getSat() + temp.getSun()) == 0)) // 요일 반복이 설정되지 않은경우
                {
                    mToast = Toast.makeText(context, "요일 선택 안함", Toast.LENGTH_LONG);
                    mToast.show();

                    PendingIntent pi = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_ONE_SHOT);

                    try {
                        if(temp.getShake() == 1) {
                            pi.send();
                            Intent a = new Intent(context, ShakeDialogActivity.class);
                            context.startActivity(a);
                        }
                        if(temp.getBa() == 1) {
                            pi.send();
                            Intent a = new Intent(context, ShakeDialogActivity.class);
                            context.startActivity(a);
                        }
                        if(temp.getOp() == 1){
                            pi.send();
                            Intent a = new Intent(context, ShakeDialogActivity.class);
                            context.startActivity(a);
                        }
                        // pi.send();
                    } catch (PendingIntent.CanceledException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    if ((aWeekday == 1 && temp.getMon() == 1) || (aWeekday == 2 && temp.getTue() == 1) || (aWeekday == 3 && temp.getWed() == 1) || (aWeekday == 4 && temp.getThu() == 1) || (aWeekday == 5 && temp.getFri() == 1) || (aWeekday == 6 && temp.getSat() == 1) || (aWeekday == 7 && temp.getSun() == 1))
                    {
                        mToast = Toast.makeText(context, "해당 요일 반복 선택", Toast.LENGTH_LONG);
                        mToast.show();

                        PendingIntent pi = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_ONE_SHOT);

                        try {
                            if(temp.getShake() == 1) {
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                            if(temp.getBa() == 1) {
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                            if(temp.getOp() == 1){
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                           // pi.send();
                        } catch (PendingIntent.CanceledException e) {
                            e.printStackTrace();
                        }
                    } else {
                        mToast = Toast.makeText(context, "해당 요일 아님 ", Toast.LENGTH_LONG);
                        mToast.show();

                        PendingIntent pi = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_ONE_SHOT);
                        try {
                            if(temp.getShake() == 1) {
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                            if(temp.getBa() == 1) {
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                            if(temp.getOp() == 1){
                                pi.send();
                                Intent a = new Intent(context, ShakeDialogActivity.class);
                                context.startActivity(a);
                            }
                            // pi.send();
                        } catch (PendingIntent.CanceledException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}