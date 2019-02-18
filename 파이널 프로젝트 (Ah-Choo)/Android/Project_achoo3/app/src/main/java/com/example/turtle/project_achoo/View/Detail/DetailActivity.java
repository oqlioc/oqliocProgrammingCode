package com.example.turtle.project_achoo.View.Detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.turtle.project_achoo.R;
import com.example.turtle.project_achoo.View.Detail.Photo.PhotoViewerActivity;
import com.example.turtle.project_achoo.View.Detail.Photo.PhotoViewerFaceActivity;
import com.example.turtle.project_achoo.View.Home.HomeActivity;
import com.example.turtle.project_achoo.View.Mypage.MypageActivity;
import com.example.turtle.project_achoo.View.Product.ProductActivity;
import com.example.turtle.project_achoo.View.Recommend.RecommendActivity;

public class DetailActivity extends AppCompatActivity {

    ImageButton home, product, detail, mypage, community;
    Button detail_btn, detail_btn_face;

    UIThread U;
    UIHandler u;
    String state;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        u = new UIHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 로그인 유지
        SharedPreferences appData = getSharedPreferences("appData", MODE_PRIVATE); // SharedPreferences 객체 가져오기

        if (appData.contains("login_status")) {

            id = appData.getString("login_id", "defValue"); // 로그인한 아이디 가져오기

        }

        home = (ImageButton)findViewById(R.id.home);
        product = (ImageButton)findViewById(R.id.product);
        detail = (ImageButton)findViewById(R.id.detail);
        mypage = (ImageButton)findViewById(R.id.mypage);
        community = (ImageButton)findViewById(R.id.community);
        detail_btn = (Button) findViewById(R.id.detail_btn);
        detail_btn_face = (Button) findViewById(R.id.detail_btn_face);

        state = "Active";
        U = new UIThread();
        U.start();

        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, PhotoViewerActivity.class);
                startActivity(intent);
            }
        });

        detail_btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, PhotoViewerFaceActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onclick(View view){

        Intent intent = null;

        switch (view.getId()){
            case R.id.home : intent = new Intent(this,HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.product: intent = new Intent(this, ProductActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.detail: intent = new Intent(this, DetailActivity.class);
                finish();
                overridePendingTransition(0, 0);
                break;
            case  R.id.community: intent = new Intent(this, RecommendActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case  R.id.mypage: intent = new Intent(this, MypageActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case  R.id.home_text: intent = new Intent(this, HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
        }

        startActivity(intent);
    }

    private class UIThread extends Thread {
        Message msg;
        boolean loop = true;

        public void run() {
            try {
                while (loop) {
                    Thread.sleep(100);

                    if (Thread.interrupted()) { // 인터럽트가 들어오면 루프를 탈출
                        loop = false;
                        break;
                    }

                    msg = u.obtainMessage();
                    msg.arg1 = 1;

                    u.sendMessage(msg);
                }
            } catch (InterruptedException e) {
                // 슬립 상태에서 인터럽트가 들어오면 익셉션 발생
                loop = false;
            }
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 1:
                    if (state.equals("DeActive"))   // Fragment가 숨겨진 상태일 때
                        break;
                    // Fragment의 UI를 변경하는 작업을 수행합니다.
            }
        }
    }

    public void onStop() {
        super.onStop();
        state = "DeActive";
        U.interrupt();
    }

    public void onResume(){
        super.onResume();
        state = "Active";
    }

    //액티비티 애니메이션 없에기
    @Override
    protected void onPause() {
        super.onPause();
//        overridePendingTransition(0,0);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("아름다움을 추천하다")
                .setMessage("정말로 앱을 종료하시겠습니까?")
                .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("취소", null)
                .show();
    }

}
