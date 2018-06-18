package com.example.stefansator.brealth.naehrstoffzentrale;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

public class NahrungDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nahrung_details);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        int amount = extras.getInt("amount");
        String unit = extras.getString("unit");
        String calories = extras.getString("calories");
        String protein = extras.getString("protein");
        String carbs = extras.getString("carbs");
        String fat = extras.getString("fat");

        TextView caloriesView = (TextView) findViewById(R.id.caloriesView);
        caloriesView.setText(calories);

        TextView titleView = (TextView) findViewById(R.id.nahrungDetailsTitleText);
        titleView.setText(title);

        TextView proteinView = (TextView) findViewById(R.id.proteinView);
        proteinView.setText(protein);

        TextView fatView = (TextView) findViewById(R.id.fatView);
        fatView.setText(fat);

        TextView carbsView = (TextView) findViewById(R.id.carbsView);
        carbsView.setText(carbs);

    }

    //    private void setFatText(int position) {
//        TextView fatView = (TextView) getView().findViewById(R.id.textViewFat);
//        Double fat = hintList.get(position).getFood().getNutrients().getFat();
//
//        if (fat == null) {
//            fatView.setText("N.A.");
//        } else {
//            fatView.setText(String.format("%.2f",fat));
//        }
//    }
//
//    private void setProteinText(int position) {
//        TextView proteinView = (TextView) getView().findViewById(R.id.textViewProtein);
//        Double protein = hintList.get(position).getFood().getNutrients().getProtein();
//
//        if (protein == null) {
//            proteinView.setText("N.A.");
//        } else {
//            proteinView.setText(String.format("%.2f",protein));
//        }
//    }
//
//    private void setCarbsText(int position) {
//        TextView carbsView = (TextView) getView().findViewById(R.id.textViewCarbs);
//        Double carbs = hintList.get(position).getFood().getNutrients().getCarbohydrates();
//
//        if (carbs == null) {
//            carbsView.setText("N.A.");
//        } else {
//            carbsView.setText(String.format("%.2f",carbs));
//        }
//    }
}
