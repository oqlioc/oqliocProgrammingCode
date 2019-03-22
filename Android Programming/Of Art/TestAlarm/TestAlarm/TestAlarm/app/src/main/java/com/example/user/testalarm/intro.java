package com.example.user.testalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class intro extends AppCompatActivity {

    Handler h;
    Runnable mrun = new Runnable() {
        public void run() {
            startActivity(new Intent(intro.this, MainActivity.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);
        h = new Handler();
        h.postDelayed(mrun, 4000);
    }

    public void onBackPressed() {
        super.onBackPressed();
        h.removeCallbacks(mrun);
    }
}