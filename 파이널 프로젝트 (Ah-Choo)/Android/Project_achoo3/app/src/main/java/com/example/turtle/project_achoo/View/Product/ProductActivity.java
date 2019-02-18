package com.example.turtle.project_achoo.View.Product;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.turtle.project_achoo.R;
import com.example.turtle.project_achoo.View.Detail.DetailActivity;
import com.example.turtle.project_achoo.View.Home.HomeActivity;
import com.example.turtle.project_achoo.View.Mypage.MypageActivity;
import com.example.turtle.project_achoo.View.Recommend.RecommendActivity;

public class ProductActivity extends AppCompatActivity {

    UIThread U;
    UIHandler u;
    String state;

    private SectionsPagerAdapter mSectionspagerAdapter;
    private ViewPager mViewPager;

    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton home , product, detail, community, mypage, logout_button;
        TextView home_text;

        u = new UIHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        home = (ImageButton) findViewById(R.id.home);
        product = (ImageButton) findViewById(R.id.product);
        detail = (ImageButton) findViewById(R.id.detail);
        community = (ImageButton) findViewById(R.id.community);
        mypage = (ImageButton) findViewById(R.id.mypage);
        logout_button = (ImageButton) findViewById(R.id.logout_button);
        home_text = (TextView)findViewById(R.id.home_text);

        SharedPreferences appData = getSharedPreferences("appData", MODE_PRIVATE); // SharedPreferences 객체 가져오기

        if (appData.contains("login_status")) {

            id = appData.getString("login_id", "defValue"); // 로그인한 아이디 가져오기

        }

        mSectionspagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionspagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        state = "Active";
        U = new UIThread();
        U.start();

    } // onCreate

    // 탭 레이아웃 어뎁터
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    AllFragment allFragment = new AllFragment();
                    return allFragment;
                case 1:
                    WarmFragment warmFragment = new WarmFragment();
                    return warmFragment;
                case 2:
                    CoolFragment coolFragment = new CoolFragment();
                    return coolFragment;
                case 3:
                    CountFragment countFragment = new CountFragment();
                    return countFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "productall";
                case 1:
                    return "productwarm";
                case 2:
                    return "productcool";
                case 3:
                    return "productcount";
            }

            return null;
        }
    } // FragmentPagerAdapter

    public void onclick(View view){

        Intent intent = null;

        switch (view.getId()){

            case R.id.home : intent = new Intent(this,HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.product: intent = new Intent(this, ProductActivity.class);
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.detail: intent = new Intent(this, DetailActivity.class);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
