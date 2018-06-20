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
        String calcium = extras.getString("calcium");
        String iron = extras.getString("iron");
        String fiber = extras.getString("fiber");
        String kalium = extras.getString("kalium");
        String magnesium = extras.getString("magnesium");
        String natrium = extras.getString("natrium");
        String vitaminB1 = extras.getString("vitaminB1");
        String vitaminB2 = extras.getString("vitaminB2");
        String vitaminB3 = extras.getString("vitaminB3");
        String vitaminB6 = extras.getString("vitaminB6");
        String phosphorus = extras.getString("phosphorus");
        String vitaminE = extras.getString("vitaminE");
        String vitaminA = extras.getString("vitaminA");
        String vitaminC = extras.getString("vitaminC");
        String vitaminK = extras.getString("vitaminK");

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

        TextView calciumView = (TextView) findViewById(R.id.calciumView);
        calciumView.setText(calcium);

        TextView ironView = (TextView) findViewById(R.id.ironView);
        ironView.setText(iron);

        TextView fiberView = (TextView) findViewById(R.id.fiberView);
        fiberView.setText(fiber);

        TextView kaliumView = (TextView) findViewById(R.id.kaliumView);
        kaliumView.setText(kalium);

        TextView magnesiumView = (TextView) findViewById(R.id.magnesiumView);
        magnesiumView.setText(magnesium);

        TextView natriumView = (TextView) findViewById(R.id.natriumView);
        natriumView.setText(natrium);

        TextView vitaminB1View = (TextView) findViewById(R.id.vitaminB1View);
        vitaminB1View.setText(vitaminB1);

        TextView vitaminB2View = (TextView) findViewById(R.id.vitaminB2View);
        vitaminB2View.setText(vitaminB2);

        TextView vitaminB3View = (TextView) findViewById(R.id.vitaminB3View);
        vitaminB3View.setText(vitaminB3);

        TextView vitaminB6View = (TextView) findViewById(R.id.vitaminB6View);
        vitaminB6View.setText(vitaminB6);

        TextView phosphorusView = (TextView) findViewById(R.id.phosphorusView);
        phosphorusView.setText(phosphorus);

        TextView vitaminEView = (TextView) findViewById(R.id.vitaminEView);
        vitaminEView.setText(vitaminE);

        TextView vitaminAView = (TextView) findViewById(R.id.vitaminAView);
        vitaminAView.setText(vitaminA);

        TextView vitaminCView = (TextView) findViewById(R.id.vitaminCView);
        vitaminCView.setText(vitaminC);

        TextView vitaminKView = (TextView) findViewById(R.id.vitaminKView);
        vitaminKView.setText(vitaminK);

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
