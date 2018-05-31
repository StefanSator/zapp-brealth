package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by StefanSator on 30.05.18.
 */

public class EffortCalculatingTask extends AppCompatActivity {
    private TextView aufgabe;
    private EditText ergebnisfeld;
    private LottieAnimationView stopwatch;
    private TextView sporttask;
    private int LIMIT;
    private int aufgabeNr = 0;
    private Rechenaufgabe rechenaufgaben[];
    private long startzeit;
    private long endzeit;
    private int falseCounter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effortcalculating);

        if (getIntent().hasExtra("limit") == true) {
            LIMIT = getIntent().getExtras().getInt("limit");
        }
        rechenaufgaben = new Rechenaufgabe[LIMIT];

        /* Initialize Array with Addition Tasks */
        for (int i = 0 ; i < LIMIT ; i++) {
            rechenaufgaben[i] = new Rechenaufgabe();
        }

        /* Hide stopwatch and sporttask at beginning of game */
        stopwatch = findViewById(R.id.stopwatch_animation);
        stopwatch.setVisibility(View.INVISIBLE);
        sporttask = findViewById(R.id.sportaufgabe);
        sporttask.setVisibility(View.INVISIBLE);
        findViewById(R.id.readyEffort_button).setVisibility(View.INVISIBLE);

        aufgabe = findViewById(R.id.effortaufgabe);
        aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
        ergebnisfeld = findViewById(R.id.effort_answer);
        startzeit = System.currentTimeMillis();
    }

    public void gotoNextTask(View view) {
        if (aufgabeNr % 5 == 0 && aufgabeNr != 0) {
            switchToSportsTask();
            aufgabeNr++;
            aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
            return;
        }

        Integer ergebnis = Integer.parseInt(ergebnisfeld.getText().toString());

        /* Control if result is right */
        if (rechenaufgaben[aufgabeNr].getErgebnis() == ergebnis) {
            Toast rightToast = Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT);
            rightToast.show();
            aufgabeNr++;
            if (aufgabeNr == LIMIT) {
                aufgabeNr = 0;
                endGame();
            }
            aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
        } else {
            falseCounter++;
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
        }
    }

    public void endSportsTask(View view) {
        switchToRechnenTask();
    }

    private void switchToSportsTask() {
        ergebnisfeld.setVisibility(View.INVISIBLE);
        aufgabe.setVisibility(View.INVISIBLE);
        findViewById(R.id.submitEffort_button).setVisibility(View.INVISIBLE);
        stopwatch.setVisibility(View.VISIBLE);
        sporttask.setVisibility(View.VISIBLE);
        findViewById(R.id.readyEffort_button).setVisibility(View.VISIBLE);
    }

    private void switchToRechnenTask() {
        ergebnisfeld.setVisibility(View.VISIBLE);
        aufgabe.setVisibility(View.VISIBLE);
        findViewById(R.id.submitEffort_button).setVisibility(View.VISIBLE);
        stopwatch.setVisibility(View.INVISIBLE);
        sporttask.setVisibility(View.INVISIBLE);
        findViewById(R.id.readyEffort_button).setVisibility(View.INVISIBLE);
    }

    private void endGame() {
        endzeit = System.currentTimeMillis();
        long bearbeitungsDauer = endzeit - startzeit;
        int bewertung = RateTheGame(bearbeitungsDauer, falseCounter, LIMIT);

        Intent finishscreenIntent = new Intent(EffortCalculatingTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsDauer);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", bewertung);
        EffortCalculatingTask.this.startActivity(finishscreenIntent);
        EffortCalculatingTask.this.finish();
    }

    private int RateTheGame(long duration, int attempts, int limit) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new RechnenRater(durationInSeconds, attempts, limit);
        return gameRater.getRating();
    }
}
