package com.example.user.testalarm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import static com.example.user.testalarm.AlarmAdd.mAlarmManager;
import static com.example.user.testalarm.AlarmAdd.mPendingIntentList;

public class ListViewAdapter extends BaseAdapter {
    int index = 1;
    LayoutInflater inflater;
    Context context;
    int layout;
    DBHelper dbHelper;
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList;

    // ListViewAdapter의 생성자
    public ListViewAdapter(Context context, int layout, ArrayList<ListViewItem> alist ) {
        this.context = context;
        this.layout = layout;
        listViewItemList = alist;
        inflater = LayoutInflater.from(context);
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);


        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon, String title, String desc, ListViewItem tmp_item) {
        ListViewItem item = new ListViewItem();
        item.set_id(tmp_item.get_id());
        item.setIcon(icon);
        item.setTitle(" "+index+"번째  "+title);
        item.setDesc(" "+desc);

        listViewItemList.add(item);
        index++;
    }
    public void delItem(int pos) {
        ListViewItem listViewItem = listViewItemList.get(pos); ///////////////// 항목이 선택된후 delitem이 되도록 이벤트핸들러 추가해야함

        //mAlarmManager.cancel(mPendingIntentList[listViewItem.get_id()]);
        dbHelper = new DBHelper(this.context, "ALARM_TABLE", null, 1);
        dbHelper.deleteTuple(listViewItem);
        listViewItemList.remove(pos);
        MainActivity.adapter.notifyDataSetChanged();
    }
}