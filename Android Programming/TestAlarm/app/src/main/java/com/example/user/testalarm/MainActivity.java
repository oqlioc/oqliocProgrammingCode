package com.example.user.testalarm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static int pos;
    ListView listview ;
    Intent intent;
    public static ListViewAdapter adapter;
    ArrayList<ListViewItem> item_list;
    public static int index = 0;
    String setName,repeat,setTime;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_list = new ArrayList<ListViewItem>();
        listview = (ListView) findViewById(R.id.listview1);
        // Adapter 생성
        adapter = new ListViewAdapter(this, R.layout.listview_item, item_list);

        listview.setAdapter(adapter);

        ///SQLiteHelper(getApplicationContext());
        //item_list = new ArrayList<ListViewItem>();
        //listview = (ListView) findViewById(R.id.listview1);
        // Adapter 생성
        //adapter = new ListViewAdapter(this, R.layout.listview_item, item_list);
        // 리스트뷰 참조 및 Adapter달기
        //listview.setAdapter(adapter);

        intent = new Intent(MainActivity.this, AlarmAdd.class);

        if( dbHelper == null ) {
            dbHelper = new DBHelper(MainActivity.this, "ALARM_TABLE", null, 1);
        }
        //dbHelper.dropTable();

        ArrayList<ListViewItem> alarmDatas = dbHelper.getAllAlarmData();
        findViewById(R.id.add_press).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AlarmAdd.class);
                        startActivity(intent);
                    }
                }
        );
        findViewById(R.id.delete_press).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        adapter.delItem(pos);
                    }
                }
        );
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }
        });

        for ( int i = 0; i < alarmDatas.size(); i++) {
            ListViewItem temp = alarmDatas.get(i);
            String str = temp.getName();
            setName = ""+str;
            repeat = "";
            if ( temp.getMon() == 1){ repeat += "월 "; }
            if ( temp.getTue() == 1){ repeat += "화 "; }
            if ( temp.getWed() == 1){ repeat += "수 "; }
            if ( temp.getThu() == 1){ repeat += "목 "; }
            if ( temp.getFri() == 1){ repeat += "금 "; }
            if ( temp.getSat() == 1){ repeat += "토 "; }
            if ( temp.getSun() == 1){ repeat += "일 "; }

//            if ( temp.getBa() == 1){repeat += "BA";}
//            if ( temp.getShake() == 1){repeat += "SHAKE";}
//            if ( temp.getOp() == 1){repeat += "OP";}


            int temp_num = temp.getMon() + temp.getTue() + temp.getWed()  + temp.getThu() + temp.getFri() + temp.getSat() + temp.getSun();// + temp.getBa() + temp.getShake() + temp.getOp();
            if ( temp_num == 0 ) repeat = "없음";
            setTime = ""+ temp.getHour()+"시 "+temp.getMinute()+"분";


            adapter.addItem(getResources().getDrawable(R.drawable.ic_add_alarm_black_24dp),
                    setName, "반복 : " + repeat + "// 시간 : "+ setTime, temp);
            adapter.notifyDataSetChanged();
        }
    }
}
