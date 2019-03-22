package org.techtown.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sub1Activity extends AppCompatActivity {

    private static MediaPlayer alarmsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        alarmsound = MediaPlayer.create(this, R.raw.alarmsound42);
        alarmsound.setLooping(true);
        alarmsound.start();
    }
    @Override
    protected void onUserLeaveHint() {
        alarmsound.pause();
        super.onUserLeaveHint();
    }
    @Override
    public void onResume() {
        alarmsound.start();
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        alarmsound.stop();
        super.onBackPressed();
    }
    @Override
    public void onDestroy() {
        alarmsound.stop();
        super.onDestroy();
    }

}
