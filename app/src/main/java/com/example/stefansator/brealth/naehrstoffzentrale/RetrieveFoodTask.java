package com.example.stefansator.brealth.naehrstoffzentrale;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.stefansator.brealth.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrieveFoodTask extends AsyncTask<String, Void, String> {
    private List<Hint> hintList;
    private String url = "https://api.edamam.com/api/food-database/";
    private NahrungsMittelFragment fragment;
    private String foodName;
    private ProgressBar progressBar;

    public RetrieveFoodTask(List<Hint> hintList, String foodName, NahrungsMittelFragment fragment) {
        this.hintList = hintList;
        this.fragment = fragment;
        this.foodName = foodName;
    }

    @Override
    protected String doInBackground(String... strings) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        final FoodSearchAPI service = retrofit.create(FoodSearchAPI.class);
        Call<Model> call = service.getJsonObjectData(foodName, "bfe5aa37", "c9cc3f70b3bf3964b7f583de92b22f10", 1);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                hintList = response.body().getHints();

                if(!hintList.isEmpty()) {
                    fragment.setListView(hintList);
                    fragment.setHintList(hintList);
                } else {
                    Log.d("mainAct", "test - empty");
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("mainActivity", "error" + t.toString());
            }
        });

        return "executed";
    }

    public List<Hint> getHintList() {
        return hintList;
    }
}