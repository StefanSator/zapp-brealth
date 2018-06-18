package com.example.stefansator.brealth.naehrstoffzentrale;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.naehrstoffzentrale.apiobjects.ResponseObject;

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
    private ArrayList<String> foodItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter = null;
    private View contentView;
    private ResponseObject responseObject = null;
    private Bundle foodBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_nahrungsmittel, null);
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
                RetrieveFoodTask rft = null;

                rft = new RetrieveFoodTask(hintList, getFoodName(), NahrungsMittelFragment.this);
                rft.execute();
            }
        });
    }

    private String getFoodName() {
        EditText foodName = (EditText) getView().findViewById(R.id.nahrungText);
        return foodName.getText().toString();
    }

    // set a list view, which displays the results from the api calls
    public void setListView(List<Hint> hintList) {
        ListView listView = (ListView) getView().findViewById(R.id.foodList);

        // set adapter
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, foodItems);
        adapter.clear();
        for(int i = 0; i < hintList.size(); i++) {
            adapter.add(hintList.get(i).getFood().getLabel());
        }
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                buildPostRequest(position);
                Log.d("blabla", adapter.getItem(position).toString());
            }
        });
    }

    private void buildPostRequest(int position) {

        String measureURI = "http://www.edamam.com/ontologies/edamam.owl#Measure_gram";
        String foodURI = hintList.get(position).getFood().getUri();
        Ingredient ingredient = new Ingredient(100.0, measureURI, foodURI);
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        ingredientList.add(ingredient);
        NutrientPostDetails postData = new NutrientPostDetails(1, ingredientList);
        
        sendPostRequest(postData, position);
    }

    private void sendPostRequest(NutrientPostDetails postData, final int position) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        NutrientsAccessAPI client = retrofit.create(NutrientsAccessAPI.class);
        Call<ResponseObject> call = client.createPostData("bfe5aa37", "c9cc3f70b3bf3964b7f583de92b22f10", postData);

        call.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                responseObject = response.body();
                foodBundle = getFoodBundle(position);
                Intent nahrungDetailsIntent = new Intent(getActivity(), NahrungDetails.class);
                nahrungDetailsIntent.putExtras(foodBundle);
                startActivity(nahrungDetailsIntent);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Log.d("ERROR", "Something went wrong" + t);
            }
        });
    }

    public void setHintList(List<Hint> hintList) {
        this.hintList = hintList;
    }

    private Bundle getFoodBundle(int position) {
        foodBundle = new Bundle();
        foodBundle.putString("title", responseObject.getIngredients().get(position).getParsed().get(0).getFood());
        foodBundle.putInt("amount", responseObject.getTotalWeight());
        foodBundle.putString("unit", "grams");

        //build string of nutrient + unit
        //TODO: catch null objects
        foodBundle.putString("calories", responseObject.getTotalNutrients().getENERCKCAL().getQuantity() + " " + responseObject.getTotalNutrients().getENERCKCAL().getUnit());
        foodBundle.putString("protein", responseObject.getTotalNutrients().getPROCNT().getQuantity() + " " + responseObject.getTotalNutrients().getPROCNT().getUnit());
        foodBundle.putString("carbs", responseObject.getTotalNutrients().getCHOCDF().getQuantity() + " " + responseObject.getTotalNutrients().getCHOCDF().getUnit());
        foodBundle.putString("fat", responseObject.getTotalNutrients().getFAT().getQuantity() + " " + responseObject.getTotalNutrients().getFAT().getUnit());
        return foodBundle;
    }

}
