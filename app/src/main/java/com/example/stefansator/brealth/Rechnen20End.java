package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by stefansator on 07.05.18.
 */

public class Rechnen20End extends AppCompatActivity {
    private TextView dauerFeld;
    private TextView falschFeld;
    private long bearbeitungsDauer;
    private int falseCounter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnenendscreen);

        if (getIntent().hasExtra("dauer") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
        }

        dauerFeld = findViewById(R.id.zeit_rechnen);
        dauerFeld.setText("" + (bearbeitungsDauer/1000) + " s");
        falschFeld = findViewById(R.id.falschCounter_rechnenend);
        falschFeld.setText("" + falseCounter);
    }

    public void endResultScreen(View view) {
        Rechnen20End.this.finish();
    }
}
