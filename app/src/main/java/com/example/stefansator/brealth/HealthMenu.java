package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.stefansator.brealth.naehrstoffzentrale.Zentrale;

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
    }
}
