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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
    private MyBaseAdapter myBaseAdapter;
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
                Toast.makeText(getContext(), "Waiting for response...", Toast.LENGTH_SHORT);
                String foodName = getFoodViewContent();
                RetrieveFoodTask rft = null;

                rft = new RetrieveFoodTask(hintList, getFoodViewContent(), NahrungsMittelFragment.this);
                rft.execute();
            }
        });
    }

    private String getFoodViewContent() {
        EditText foodName = (EditText) getView().findViewById(R.id.nahrungText);
        return foodName.getText().toString();
    }

    // set a list view, which displays the results from the api calls
    public void setListView(List<Hint> hintList) {
        ListView listView = (ListView) getView().findViewById(R.id.foodList);

        // set adapter
//        listView.setAdapter(new MyBaseAdapter(this.getContext()));
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, foodItems);
        adapter.clear();
        for(int i = 0; i < hintList.size(); i++) {
            adapter.add(hintList.get(i).getFood().getLabel());
        }
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Waiting for response...", Toast.LENGTH_SHORT);
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
                if (responseObject == null) {
                    Toast.makeText(getContext(), "Response failed", Toast.LENGTH_SHORT);
                }
                foodBundle = getFoodBundle(position);
                Intent nahrungDetailsIntent = new Intent(getActivity(), NahrungDetails.class);
                nahrungDetailsIntent.putExtras(foodBundle);
                startActivity(nahrungDetailsIntent);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Toast.makeText(getContext(), "No response", Toast.LENGTH_SHORT);
            }
        });
    }

    public void setHintList(List<Hint> hintList) {
        this.hintList = hintList;
    }

    private Bundle getFoodBundle(int position) {
        foodBundle = new Bundle();
        foodBundle.putString("title", getFoodName(position));
        foodBundle.putInt("amount", getTotalWeight());
        foodBundle.putString("unit", "grams");
        foodBundle.putString("calories", getCaloriesString());
        foodBundle.putString("protein", getProteinString());
        foodBundle.putString("carbs", getCarbsString());
        foodBundle.putString("fat", getFatString());
        foodBundle.putString("calcium", getCalcium());
        foodBundle.putString("iron", getIron());
        foodBundle.putString("fiber", getFiber());
        foodBundle.putString("kalium", getKalium());
        foodBundle.putString("magnesium", getMagnesium());
        foodBundle.putString("natrium", getNatrium());
        foodBundle.putString("vitaminB3", getVitaminB3());
        foodBundle.putString("phosphorus", getPhosphorus());
        foodBundle.putString("vitaminB2", getVitaminB2());
        foodBundle.putString("vitaminB1", getVitaminB1());
        foodBundle.putString("vitaminE", getVitaminE());
        foodBundle.putString("vitaminA", getVitaminA());
        foodBundle.putString("vitaminB6", getVitaminB6());
        foodBundle.putString("vitaminC", getVitaminC());
        foodBundle.putString("vitaminK", getVitaminK());
        return foodBundle;
    }

    private int getTotalWeight() {
        if(responseObject.getTotalWeight() == null) {
            return 0;
        } else {
            return responseObject.getTotalWeight();
        }
    }

    private String getFoodName(int position) {
        return hintList.get(position).getFood().getLabel();
    }

    private String getCaloriesString() {
        if(responseObject.getTotalNutrients().getENERCKCAL() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getENERCKCAL().getQuantity()) + " " + responseObject.getTotalNutrients().getENERCKCAL().getUnit();
        }
    }

    private String getProteinString() {
        if(responseObject.getTotalNutrients().getPROCNT() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getPROCNT().getQuantity()) + " " + responseObject.getTotalNutrients().getPROCNT().getUnit();
        }
    }

    private String getFatString() {
        if(responseObject.getTotalNutrients().getFAT() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getFAT().getQuantity()) + " " + responseObject.getTotalNutrients().getFAT().getUnit();
        }
    }

    private String getCarbsString() {
        if(responseObject.getTotalNutrients().getCHOCDF() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getCHOCDF().getQuantity()) + " " + responseObject.getTotalNutrients().getCHOCDF().getUnit();
        }
    }

    private String getCalcium() {
        if(responseObject.getTotalNutrients().getCA() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getCA().getQuantity()) + " " + responseObject.getTotalNutrients().getCA().getUnit();
        }
    }

    private String getIron() {
        if(responseObject.getTotalNutrients().getFE() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getFE().getQuantity()) + " " + responseObject.getTotalNutrients().getFE().getUnit();
        }
    }

    private String getFiber() {
        if(responseObject.getTotalNutrients().getFIBTG() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getFIBTG().getQuantity()) + " " + responseObject.getTotalNutrients().getFIBTG().getUnit();
        }
    }

    private String getKalium() {
        //Kalium
        if(responseObject.getTotalNutrients().getK() == null) {
            return "N.A.";
        } else {
            String test = String.format("%.2f",responseObject.getTotalNutrients().getK().getQuantity()) + " " + responseObject.getTotalNutrients().getK().getUnit();
            return String.format("%.2f",responseObject.getTotalNutrients().getK().getQuantity()) + " " + responseObject.getTotalNutrients().getK().getUnit();
        }
    }

    private String getMagnesium() {
        if(responseObject.getTotalNutrients().getMG() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getMG().getQuantity()) + " " + responseObject.getTotalNutrients().getMG().getUnit();
        }
    }

    private String getNatrium() {
        //Natrium
        if(responseObject.getTotalNutrients().getNA() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getNA().getQuantity()) + " " + responseObject.getTotalNutrients().getNA().getUnit();
        }
    }

    private String getVitaminB3() {
        //Niacin
        if(responseObject.getTotalNutrients().getNIA() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getNIA().getQuantity()) + " " + responseObject.getTotalNutrients().getNIA().getUnit();
        }
    }

    private String getPhosphorus() {
        if(responseObject.getTotalNutrients().getP() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getP().getQuantity()) + " " + responseObject.getTotalNutrients().getP().getUnit();
        }
    }

    private String getVitaminB2() {
        //Riboflavin
        if(responseObject.getTotalNutrients().getRIBF() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getRIBF().getQuantity()) + " " + responseObject.getTotalNutrients().getRIBF().getUnit();
        }
    }

    private String getVitaminB1() {
        //Thiamin
        if(responseObject.getTotalNutrients().getTHIA() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getTHIA().getQuantity()) + " " + responseObject.getTotalNutrients().getTHIA().getUnit();
        }
    }

    private String getVitaminE() {
        //Tocopherol
        if(responseObject.getTotalNutrients().getTOCPHA() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getTOCPHA().getQuantity()) + " " + responseObject.getTotalNutrients().getTOCPHA().getUnit();
        }
    }

    private String getVitaminA() {
        //Retinol
        if(responseObject.getTotalNutrients().getVITARAE() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getVITARAE().getQuantity()) + " " + responseObject.getTotalNutrients().getVITARAE().getUnit();
        }
    }

    private String getVitaminB6() {
        if(responseObject.getTotalNutrients().getVITB6A() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getVITB6A().getQuantity()) + " " + responseObject.getTotalNutrients().getVITB6A().getUnit();
        }
    }

    private String getVitaminC() {
        if(responseObject.getTotalNutrients().getVITC() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getVITC().getQuantity()) + " " + responseObject.getTotalNutrients().getVITC().getUnit();
        }
    }

    private String getVitaminK() {
        if(responseObject.getTotalNutrients().getVITK1() == null) {
            return "N.A.";
        } else {
            return String.format("%.2f",responseObject.getTotalNutrients().getVITK1().getQuantity()) + " " + responseObject.getTotalNutrients().getVITK1().getUnit();
        }
    }

















}
