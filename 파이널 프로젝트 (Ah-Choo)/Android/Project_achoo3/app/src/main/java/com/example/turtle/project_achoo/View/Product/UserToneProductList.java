package com.example.turtle.project_achoo.View.Product;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.turtle.project_achoo.Function.Adapter.ListviewAdapter;
import com.example.turtle.project_achoo.Function.Model.ProductDTO;
import com.example.turtle.project_achoo.Function.Model.ProductDTO_info;
import com.example.turtle.project_achoo.Function.Service.ProductService;
import com.example.turtle.project_achoo.Function.Service.RetrofitInstance;
import com.example.turtle.project_achoo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserToneProductList extends AppCompatActivity {

    private Button back;
    private ListView listView;
    private String id;
    private String selfT;

    private ArrayList<ProductDTO> result = null;
    private ListviewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tone_product_list);

        SharedPreferences appData = getSharedPreferences("appData", MODE_PRIVATE);
        if (appData.contains("login_status")) {

            id = appData.getString("login_id", "defValue"); // 로그인한 아이디 가져오기
            selfT=appData.getString("selfT","defValue");
        }

        listView = findViewById(R.id.listview);
        back = findViewById(R.id.back);

        back.setOnClickListener(v -> {
            finish();
        });

        // 상품 리스트 서버에 요청
        getUserToneProductList(this);

    } // onCreate

    public void getUserToneProductList(UserToneProductList userToneProductList){


        ProductService productService = RetrofitInstance.getProductService();
        Call<ProductDTO_info> call = productService.getUserToneProductList(selfT);


        call.enqueue(new Callback<ProductDTO_info>() {


            @Override
            public void onResponse(Call<ProductDTO_info> call, Response<ProductDTO_info> response) {

                ProductDTO_info productDTO_info = response.body();


                if (productDTO_info != null && productDTO_info.getProductDTO() != null) {

                    result = (ArrayList<ProductDTO>) productDTO_info.getProductDTO();
                    adapter = new ListviewAdapter(userToneProductList, R.layout.product, result);
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ProductDTO_info> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Data load failed.", Toast.LENGTH_LONG)
                        .show();


            }
        });
    } // getUserToneProductList

}
