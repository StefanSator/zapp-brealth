package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodSearchAPI {
    @GET("parser?")
    Call<FoodModel> getJsonObjectData(
            @Query("ingr") String ingredient,
            @Query("app_id") String app_id,
            @Query("app_key") String app_key,
            @Query("page") int page
    );
}
