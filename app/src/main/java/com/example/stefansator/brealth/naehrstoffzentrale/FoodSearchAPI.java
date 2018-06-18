package com.example.stefansator.brealth.naehrstoffzentrale;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodSearchAPI {
    @GET("parser?")
    Call<Model> getJsonObjectData(
            @Query("ingr") String ingredient,
            @Query("app_id") String app_id,
            @Query("app_key") String app_key,
            @Query("page") int page
    );
}
