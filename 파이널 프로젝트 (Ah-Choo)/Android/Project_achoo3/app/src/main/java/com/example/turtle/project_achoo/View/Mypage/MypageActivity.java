package com.example.turtle.project_achoo.View.Mypage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.turtle.project_achoo.Function.Model.MemberDTO;
import com.example.turtle.project_achoo.Function.Service.MemberService;
import com.example.turtle.project_achoo.Function.Service.RetrofitInstance;
import com.example.turtle.project_achoo.R;
import com.example.turtle.project_achoo.View.Login.MainActivity;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MypageActivity extends AppCompatActivity {

    TextView info_nickname, info_selftext, info_other;  // 마이페이지 내정보
    ImageButton info_back;   // 뒤로가기 버튼
    Button info_update, info_write;     // 마이페이지 내정보
    Button info_selftest, info_detailtest;  // 마이페이지 진단결과
    Button info_product, info_brand, info_warm, info_cool;  // 마이페이지 관심상품
    Button info_mywebpage;  // 웹페이지 호출
    ImageButton logout_button;  // 마이페이지 로그아웃 버튼

    UIThread U;
    UIHandler u;
    String state;
    private String id;

    int RGB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton home , product, detail, community, mypage, logout_button;
        TextView home_text;

        u = new UIHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 로그인 유지
        SharedPreferences appData = getSharedPreferences("appData", MODE_PRIVATE); // SharedPreferences 객체 가져오기

        if (appData.contains("login_status")) {

            id = appData.getString("login_id", "defValue"); // 로그인한 아이디 가져오기

        }

        info_back = (ImageButton) findViewById(R.id.info_back);
        logout_button = (ImageButton) findViewById(R.id.logout_button);

        info_product = (Button) findViewById(R.id.info_product);
        info_brand = (Button) findViewById(R.id.info_brand);
        info_warm = (Button) findViewById(R.id.info_warm);
        info_cool = (Button) findViewById(R.id.info_cool);
        info_mywebpage = (Button) findViewById(R.id.info_mywebgage);
        info_write = (Button) findViewById(R.id.info_write);
        info_update = (Button) findViewById(R.id.info_update);
        info_selftest = (Button) findViewById(R.id.info_selftest);
        info_detailtest = (Button) findViewById(R.id.info_detailtest);

        state = "Active";
        U = new UIThread();
        U.start();

        // 로그아웃
        logout_button.setOnClickListener(v -> {

            SharedPreferences.Editor editor = appData.edit();
            editor.putBoolean("login_status", false);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        AlertDialogs_Product();     // 마이페이지 관심 제품 클릭 이벤트
        AlertDialogs_Webpage();     // 마이페이지 웹 페이지 클릭 이벤트
        AlertDialogs_Write();       // 마이페이지 글쓰기 클릭 이벤트
        AlertDialogs_Back();        // 마이페이지 뒤로가기 클릭 이벤트

        MemberDataUpdateActivity();           // 마이페이지 내 정보 수정 클릭 이벤트
        ResultActivity();                     // 마이페이지 진단결과 클릭 이벤트

    }   // onCreate

    private void MemberDataUpdateActivity() {

//        info_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MypageActivity.this, MbModifyActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//            }
//        });

    }   // MemberDataUpdateActivity

    private void ResultActivity() {

        info_selftest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this, SelfResultActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        info_detailtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //===========================================Detail
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        if(msg.what == 0){   // Message id 가 0 이면
                            Intent intent = new Intent(MypageActivity.this, DetailResultActivity.class);
                            intent.putExtra("RGB", RGB);
                            Log.d("aaa", RGB + "    !=======111111111111111");
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    }
                };

                DetailTestHandlerThread detailTestHandlerThread=new DetailTestHandlerThread(handler);  // 동기화

                MemberDTO memberDTO = new MemberDTO(id);

                Gson gson = new Gson();
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), gson.toJson(memberDTO));

                MemberService memberService = RetrofitInstance.getMemberService();
                Call<Integer> call = memberService.info_detailtest(requestBody); // memberDTO 객체를 @RequestBody로 넘겨주기

                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {

                        RGB = response.body();

                        if(RGB != 0){
                            detailTestHandlerThread.run();
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                    }
                });
                //===========================================Detail
            }
        });

    }   // ResultActivity

    private void AlertDialogs_Product() {

        info_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("추후 구현할 기능 입니다.")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });

        info_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("추후 구현할 기능 입니다.")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });

        info_warm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("추후 구현할 기능 입니다.")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });

        info_cool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("추후 구현할 기능 입니다.")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });

    }   // AlertDialogs_Product

    private void AlertDialogs_Webpage() {
        info_mywebpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("팀 소개 페이지 입니다.\nhttp://kelobelos.com")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });
    }       // AlertDialogs_Webpage

    private void AlertDialogs_Write() {

        info_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MypageActivity.this)
                        .setTitle("아름다움을 추천하다")
                        .setMessage("추후 구현할 기능 입니다.")
                        .setNegativeButton("확인", null)
                        .show();
            }
        });

    }       // AlertDialogs_Write

    private void AlertDialogs_Back() {
        info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }   // AlertDialogs_Back

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}

