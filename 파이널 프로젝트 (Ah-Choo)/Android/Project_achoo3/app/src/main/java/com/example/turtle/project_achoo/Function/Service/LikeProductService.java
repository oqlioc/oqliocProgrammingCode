package com.example.turtle.project_achoo.Function.Service;

import com.example.turtle.project_achoo.Function.Model.LikeProductDTO_info;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LikeProductService {

    @POST("addToCart")
    Call<Integer> addToCart(@Body RequestBody likeProductDTO);

    @GET("likeProductList")
    Call<LikeProductDTO_info> likeProductList(@Query("id") String id);

    @POST("deleteLikeProduct")
    Call<Integer> deleteLikeProduct(@Query("id") String id);
}
