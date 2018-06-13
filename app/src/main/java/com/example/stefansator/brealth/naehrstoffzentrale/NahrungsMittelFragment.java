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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NahrungsMittelFragment extends Fragment {
    private String url = "https://api.edamam.com/api/food-database/";
    private List<Hint> hintList = null;
    private RecyclerView recyclerView;
//    private NahrungAdapter adapter;
    private ArrayList<String> foodItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter = null;
    private View contentView;

    public List<Food> getData() {
        List<Food> data = new ArrayList<>();
        for(int i = 0; i < hintList.size(); i++) {
            Food current = new Food();
            current.setLabel(hintList.get(i).getFood().getLabel());
            data.add(current);
        }
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_nahrungsmittel, null);
//        recyclerView = (RecyclerView)layout.findViewById(R.id.nahrungsmittel_list);
//        adapter = new NahrungAdapter(getActivity(), getData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contentView = layout;
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
        Call<Model> call = service.getJsonObjectData(getFoodName(), "bfe5aa37", "c9cc3f70b3bf3964b7f583de92b22f10", 1);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                hintList = response.body().getHints();
                if(!hintList.isEmpty()) {
                    setFatText();
                    setProteinText();
                    setCarbsText();
                } else {
                    Log.d("mainAct", "test - empty");
                }

                ListView listView = (ListView) getView().findViewById(R.id.foodList);
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, foodItems);
                for(int i = 0; i < hintList.size(); i++) {
                    adapter.add(hintList.get(i).getFood().getLabel());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("mainActivity", "error" + t.toString());
            }
        });
    }

    private void setFatText() {
        TextView fatView = (TextView) getView().findViewById(R.id.textViewFat);
        Double fat = hintList.get(0).getFood().getNutrients().getFat();

        if (fat == null) {
            fatView.setText("N.A.");
        } else {
            fatView.setText(fat.toString());
        }
    }

    private void setProteinText() {
        TextView fatView = (TextView) getView().findViewById(R.id.textViewProtein);
        Double protein = hintList.get(0).getFood().getNutrients().getProtein();

        if (protein == null) {
            fatView.setText("N.A.");
        } else {
            fatView.setText(protein.toString());
        }
    }

    private void setCarbsText() {
        TextView fatView = (TextView) getView().findViewById(R.id.textViewCarbs);
        Double carbs = hintList.get(0).getFood().getNutrients().getCarbohydrates();

        if (carbs == null) {
            fatView.setText("N.A.");
        } else {
            fatView.setText(carbs.toString());
        }
    }
}
