package com.example.turtle.project_achoo.Function.Service;

import android.util.Log;

import com.example.turtle.project_achoo.View.Login.MainActivity;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

// Singleton
//addConverterFactory(GsonConverterFactory.create()) : 통신 완료 된 후 ,어떤 Converter를 이용하여 데이터를 파싱할 것인가
public class RetrofitInstance {


    private static String BASE_URL = "http://172.22.202.79:4000/";
    private static Retrofit retrofit = null;


    private RetrofitInstance() {

    }

    public static MemberService getMemberService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            Log.d(MainActivity.TAG,"getMemberService");
        }
        return retrofit.create(MemberService.class);
    }

    public static ProductService getProductService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            Log.d(MainActivity.TAG,"getProductService");
        }
        return retrofit.create(ProductService.class);

    }

    public static LikeProductService getLikeProductService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            Log.d(MainActivity.TAG,"getLikeProductService");
        }
        return retrofit.create(LikeProductService.class);
    }
}
