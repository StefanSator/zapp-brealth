package com.example.stefansator.brealth.naehrstoffzentrale;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NahrungsMittelFragment extends Fragment {
    String url = "https://api.edamam.com/api/food-database/";
//    private RecyclerView recyclerView;
//    private NahrungAdapter adapter;

//    public static List<NahrungItem> getData() {
//        List<NahrungItem> data = new ArrayList<>();
//        int[] icons = {R.drawable.broccoli, R.drawable.ic_home_black_24dp};
//        String[] titles = {"Brokkoli", "Spargel"};
//        for(int i = 0; i < titles.length && i < icons.length; i++) {
//            NahrungItem current = new NahrungItem();
//            current.iconId = icons[i];
//            current.title = titles[i];
//            data.add(current);
//        }
//
//        return data;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_nahrungsmittel, null);
//        recyclerView = (RecyclerView)layout.findViewById(R.id.nahrungsmittel_list);
//        adapter = new NahrungAdapter(getActivity(), getData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button submitButton = (Button) getView().findViewById(R.id.nahrungSubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = getFoodName();
                getRetrofitObject();

            }
        });
        // or  (ImageView) view.findViewById(R.id.foo);
    }

    private String getFoodName() {
        EditText foodName = (EditText) getView().findViewById(R.id.nahrungText);
        return foodName.getText().toString();
    }

    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<Model> call = service.getJsonObjectData(getFoodName(), "bfe5aa37", "c9cc3f70b3bf3964b7f583de92b22f10", 0);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                List<Hint> hintList = null;
                hintList = response.body().getHints();
                if(!hintList.isEmpty()) {
                    Log.d("TEST", "FAT: " + hintList.get(0).getFood().getNutrients().getFat().toString());
                    Log.d("TEST", "PROTEIN: " + hintList.get(0).getFood().getNutrients().getProtein().toString());
                    Log.d("TEST", "CARBS: " + hintList.get(0).getFood().getNutrients().getFat().toString());

                    TextView fatView = (TextView) getView().findViewById(R.id.textViewFat);
                    fatView.setText(hintList.get(0).getFood().getNutrients().getFat().toString());

                    TextView proteinView = (TextView) getView().findViewById(R.id.textViewProtein);
                    proteinView.setText(hintList.get(0).getFood().getNutrients().getProtein().toString());

                    TextView carbsView = (TextView) getView().findViewById(R.id.textViewCarbs);
                    carbsView.setText(hintList.get(0).getFood().getNutrients().getCarbohydrates().toString());
                } else {
                    Log.d("mainAct", "test - empty");
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("mainActivity", "error" + t.toString());
            }
        });
    }
}
