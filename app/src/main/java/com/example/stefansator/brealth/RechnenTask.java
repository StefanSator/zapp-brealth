package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by stefansator on 06.05.18.
 */

public class RechnenTask extends AppCompatActivity {
    private TextView aufgabe;
    private EditText ergebnisfeld;
    private int LIMIT;
    private int aufgabeNr = 0;
    private Rechenaufgabe rechenaufgaben[];
    private long startzeit;
    private long endzeit;
    private int falseCounter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnen);

        if (getIntent().hasExtra("limit") == true) {
            LIMIT = getIntent().getExtras().getInt("limit");
        }
        rechenaufgaben = new Rechenaufgabe[LIMIT];

        /* Initialize Array with Addition Tasks */
        for (int i = 0 ; i < LIMIT ; i++) {
            rechenaufgaben[i] = new Rechenaufgabe();
        }

        aufgabe = findViewById(R.id.rechenaufgabe);
        aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
        startzeit = System.currentTimeMillis();
    }

    public void showIfRight(View view) {
        ergebnisfeld = findViewById(R.id.rechenaufgabe_answer);
        Integer ergebnis = Integer.parseInt(ergebnisfeld.getText().toString());

        /* Control if result is right */
        if (rechenaufgaben[aufgabeNr].getErgebnis() == ergebnis) {
            Toast rightToast = Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT);
            rightToast.show();
            aufgabeNr++;
            if (aufgabeNr == LIMIT) {
                aufgabeNr = 0;
                endzeit = System.currentTimeMillis();
                long bearbeitungsDauer = endzeit - startzeit;
                Intent finishscreenIntent = new Intent(RechnenTask.this, RechnenEnd.class);
                finishscreenIntent.putExtra("dauer", bearbeitungsDauer);
                finishscreenIntent.putExtra("falsch", falseCounter);
                RechnenTask.this.startActivity(finishscreenIntent);
                RechnenTask.this.finish();
            }
            aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
        } else {
            falseCounter++;
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
        }
    }
}
