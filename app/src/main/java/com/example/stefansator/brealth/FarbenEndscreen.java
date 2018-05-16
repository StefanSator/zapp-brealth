package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FarbenEndscreen extends AppCompatActivity {
    private TextView anmerkungsFeld;
    private TextView falschFeld;
    private long bearbeitungsDauer;
    private int falseCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbenendscreen);

        if (getIntent().hasExtra("dauer") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
        }

        anmerkungsFeld = findViewById(R.id.Bemerkung);
        anmerkungsFeld.setText("Du hast " + (bearbeitungsDauer / 1000) + " s gebraucht um die Übung zu beenden.");
        falschFeld = findViewById(R.id.falsche_Antwort);
        falschFeld.setText("Du hast " + falseCounter + " Aufgaben falsch beantwortet.");
    }

    public void endResultScreen(View view) {
        FarbenEndscreen.this.finish();
    }
}