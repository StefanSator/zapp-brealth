package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.stefansator.brealth.health.bmi_rechner.BMIActivity;
import com.example.stefansator.brealth.health.tipps.TippsActivity;
import com.example.stefansator.brealth.health.rezepte.RezepteActivity;
import com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel.Zentrale;

/**
 * Created by stefansator on 04.05.18.
 */

public class HealthMenu extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthmenu);

        Button zentraleButton = (Button)findViewById(R.id.health_zentrale_button);
        zentraleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zentraleIntent = new Intent(HealthMenu.this, Zentrale.class);
                startActivity(zentraleIntent);
            }
        });

        Button bmiCalculatorButton = (Button)findViewById(R.id.health_bmi_button);
        bmiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmiIntent = new Intent(HealthMenu.this, BMIActivity.class);
                startActivity(bmiIntent);
            }
        });

        Button rezepteButton = (Button)findViewById(R.id.health_rezepte_button);
        rezepteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rezepteIntent = new Intent(HealthMenu.this, RezepteActivity.class);
                startActivity(rezepteIntent);
            }
        });

        Button tippsButton = (Button)findViewById(R.id.health_tipps_button);
        tippsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tippsIntent = new Intent(HealthMenu.this, TippsActivity.class);
                startActivity(tippsIntent);
            }
        });
    }
}
