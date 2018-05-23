package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by stefansator on 07.05.18.
 */

public class RechnenEnd extends AppCompatActivity {
    private TextView dauerFeld;
    private TextView falschFeld;
    private long bearbeitungsDauer;
    private int falseCounter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnenendscreen);

        dauerFeld = findViewById(R.id.zeit_rechnen);
        falschFeld = findViewById(R.id.falschCounter_rechnenend);

        if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
            setDauerAndFalschFeld();
        } else if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == false) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            setOnlyDauerFeld();
        } else {
            System.out.println("Error in RechnenEnd");
            RechnenEnd.this.finish();
        }
    }

    private void setDauerAndFalschFeld() {
        dauerFeld.setText("" + (bearbeitungsDauer/1000) + " s");
        falschFeld.setText("" + falseCounter);
    }

    private void setOnlyDauerFeld() {
        dauerFeld.setText("" + (bearbeitungsDauer/1000) + " s");
        TextView falschText = findViewById(R.id.falsch_rechnenend);
        falschText.setText("");
    }

    public void endResultScreen(View view) {
        RechnenEnd.this.finish();
    }
}
