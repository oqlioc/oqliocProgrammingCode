package com.example.user.testalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    DBHelper dbHelper;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            dbHelper = new DBHelper(context, "ALARM_TABLE", null, 1);
        }
        dbHelper.dropTable();
    }

}