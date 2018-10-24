package com.example.user.testalarm;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    int _id = -1;
    private int minute;
    int mon,tue,wed,thu,fri,sat,sun;
    private Drawable iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private int hour;
    int vibrate;
    int sound;
    String name;
    int ba;
    int shake;
    int op;

    public int getBa() {
        return ba;
    }

    public int getShake() {
        return shake;
    }

    public int getOp() {
        return op;
    }

    public void setBa(int ba){
        this.ba = ba;
    }

    public void setShake(int shake){
        this.shake = shake;
    }

    public void setOp(int op){
        this.op = op;
    }

    public void setMode(int mode[]){
        if ( mode[0] == 1) { ba = 1; }
        if ( mode[1] == 1) { shake= 1; }
        if ( mode[2] == 1) { op= 1; }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getVibrate() { return vibrate; }
    public void setVibrate(int vibrate) { this.vibrate = vibrate; }

    public int getSound() { return sound; }
    public void setSound(int sound) { this.sound = sound; }


    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getMon() {
        return mon;
    }
    public int getTue() {
        return tue;
    }
    public int getWed() {
        return wed;
    }
    public int getThu() {
        return thu;
    }
    public int getFri() {
        return fri;
    }
    public int getSat() {
        return sat;
    }
    public int getSun() {
        return sun;
    }
    public void setMon(int mon) {
        this.mon = mon;
    }
    public void setTue(int tue) {
        this.tue = tue;
    }
    public void setWed(int wed) {
        this.wed = wed;
    }
    public void setThu(int thu) {
        this.thu = thu;
    }
    public void setFri(int fri) {
        this.fri = fri;
    }
    public void setSat(int sat) {
        this.sat = sat;
    }
    public void setSun(int sun) {
        this.sun = sun;
    }

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public void setWeek(int week[])
    {
        if ( week[0] == 1) { mon = 1; }
        if ( week[1] == 1) { tue = 1; }
        if ( week[2] == 1) { wed = 1; }
        if ( week[3] == 1) { thu = 1; }
        if ( week[4] == 1) { fri = 1; }
        if ( week[5] == 1) { sat = 1; }
        if ( week[6] == 1) { sun = 1; }
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}