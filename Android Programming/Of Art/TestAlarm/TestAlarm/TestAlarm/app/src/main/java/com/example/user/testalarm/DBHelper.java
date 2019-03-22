package com.example.user.testalarm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    /**
     * Database가 존재하지 않을 때, 딱 한번 실행된다. * DB를 만드는 역할을 한다. * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // String 보다 StringBuffer가 Query 만들기 편하다.
        StringBuffer sb = new StringBuffer();
        sb.append(" CREATE TABLE ALARM_TABLE ( ");
        sb.append(" _ID INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" HOUR INTEGER, ");
        sb.append(" MINUTE INTEGER, ");
        sb.append(" MON INTEGER, ");
        sb.append(" TUE INTEGER, ");
        sb.append(" WED INTEGER, ");
        sb.append(" THU INTEGER, ");
        sb.append(" FRI INTEGER, ");
        sb.append(" SAT INTEGER, ");
        sb.append(" SUN INTEGER, ");
        sb.append(" VIBRATE INTEGER, ");
        sb.append(" SOUND INTEGER, ");
        sb.append(" NAME TEXT, ");
        sb.append(" BA INTEGER, ");
        sb.append(" SHAKE INTEGER,");
        sb.append(" OP INTEGER ) ");




        // SQLite Database로 쿼리 실행
        db.execSQL(sb.toString());
        Toast.makeText(context, "Table 생성완료", Toast.LENGTH_SHORT).show();
    }

    /**
     * Application의 버전이 올라가서 * Table 구조가 변경되었을 때 실행된다.
     * * @param db * @param oldVersion * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "버전이 올라갔습니다.", Toast.LENGTH_SHORT).show();
    }

    public void addTuple(ListViewItem item) {

        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" INSERT INTO ALARM_TABLE ( ");
        sb.append(" HOUR, MINUTE, MON, TUE, WED, THU, FRI, SAT, SUN, VIBRATE, SOUND, NAME, BA, SHAKE, OP ) ");
        sb.append(" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");

        db.execSQL(sb.toString(), new Object[]{
                item.getHour(),
                item.getMinute(),
                item.getMon(),
                item.getTue(),
                item.getWed(),
                item.getThu(),
                item.getFri(),
                item.getSat(),
                item.getSun(),
                item.getVibrate(),
                item.getSound(),
                item.getName(),
                item.getBa(),
                item.getShake(),
                item.getOp()});
    }
    public void dropTable()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS ALARM_TABLE");
        onCreate(db);
    }

    public void deleteTuple(ListViewItem item) {
        SQLiteDatabase  db = getWritableDatabase();
        db.execSQL(String.format("DELETE FROM %s WHERE %s = %d", "ALARM_TABLE", "_ID" , item.get_id()));
    }

    /** * */
    public ArrayList<ListViewItem> getAllAlarmData()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT _ID, HOUR, MINUTE, MON, TUE, WED, THU, FRI, SAT, SUN, VIBRATE, SOUND, NAME, BA, SHAKE, OP FROM ALARM_TABLE ");
        // 읽기 전용 DB 객체를 만든다.
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(),null);
        ArrayList<ListViewItem> alarmData = new ArrayList<ListViewItem>();
        ListViewItem alarm = null;

        // moveToNext 다음에 데이터가 있으면 true 없으면 false
        while( cursor.moveToNext() )
        {
            alarm = new ListViewItem();
            alarm.set_id(cursor.getInt(0));
            alarm.setHour(cursor.getInt(1));
            alarm.setMinute(cursor.getInt(2));
            alarm.setMon(cursor.getInt(3));
            alarm.setTue(cursor.getInt(4));
            alarm.setWed(cursor.getInt(5));
            alarm.setThu(cursor.getInt(6));
            alarm.setFri(cursor.getInt(7));
            alarm.setSat(cursor.getInt(8));
            alarm.setSun(cursor.getInt(9));
            alarm.setVibrate(cursor.getInt(10));
            alarm.setSound(cursor.getInt(11));
            alarm.setName(cursor.getString(12));
            alarm.setBa(cursor.getInt(13));
            alarm.setShake(cursor.getInt(14));
            alarm.setOp(cursor.getInt(15));

            alarmData.add(alarm);
        }
        return alarmData;
    }
    public ListViewItem getAlarmData() {
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT _ID, HOUR, MINUTE, MON, TUE, WED, THU, FRI, SAT, SUN, VIBRATE, SOUND, NAME , BA, SHAKE, OP FROM ALARM_TABLE ");
        // 읽기 전용 DB 객체를 만든다.
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(),null);

        ListViewItem alarm = new ListViewItem();
        alarm.set_id(cursor.getInt(0));
        alarm.setHour(cursor.getInt(1));
        alarm.setMinute(cursor.getInt(2));
        alarm.setMon(cursor.getInt(3));
        alarm.setTue(cursor.getInt(4));
        alarm.setWed(cursor.getInt(5));
        alarm.setThu(cursor.getInt(6));
        alarm.setFri(cursor.getInt(7));
        alarm.setSat(cursor.getInt(8));
        alarm.setSun(cursor.getInt(9));
        alarm.setVibrate(cursor.getInt(10));
        alarm.setSound(cursor.getInt(11));
        alarm.setName(cursor.getString(12));
        alarm.setBa(cursor.getInt(13));
        alarm.setShake(cursor.getInt(14));
        alarm.setOp(cursor.getInt(15));

        return alarm;
    }
    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM ALARM_TABLE ";

        db.execSQL(sql);
    }
}
