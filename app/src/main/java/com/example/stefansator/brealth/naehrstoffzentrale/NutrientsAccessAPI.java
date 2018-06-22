package com.example.stefansator.brealth.naehrstoffzentrale;

import com.example.stefansator.brealth.naehrstoffzentrale.apiobjects.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NutrientsAccessAPI {
    @POST("nutrients?")
    Call<ResponseObject> createPostData(
            @Query("app_id") String app_id,
            @Query("app_key") String app_key,
            @Body NutrientPostDetails postDetails
    );
}
