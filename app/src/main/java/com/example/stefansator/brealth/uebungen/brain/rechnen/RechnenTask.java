package com.example.stefansator.brealth.uebungen.brain.rechnen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stefansator.brealth.uebungen.GameRater;
import com.example.stefansator.brealth.uebungen.Highscore;
import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.TaskEndscreen;

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
    private boolean wipeHighscore = false;
    private Highscore highscore;
    private String taskName = "rechnen";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnen);

        if (getIntent().hasExtra("limit") == true) {
            LIMIT = getIntent().getExtras().getInt("limit");
        }

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName+LIMIT,wipeHighscore);

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
        Integer ergebnis;
        ergebnisfeld = findViewById(R.id.rechenaufgabe_answer);

        if (ergebnisfeld.getText().toString().isEmpty()) {
            return;
        } else {
            ergebnis = Integer.parseInt(ergebnisfeld.getText().toString());
        }

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
            ergebnisfeld.setText("");
        } else {
            falseCounter++;
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
        }
    }

    private void endGame() {
        endzeit = System.currentTimeMillis();
        long bearbeitungsDauer = endzeit - startzeit;
        int bewertung = RateTheGame(bearbeitungsDauer, falseCounter, LIMIT);

        highscore.setDuration(bearbeitungsDauer);
        highscore.setRating(bewertung);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscore();

        Intent finishscreenIntent = new Intent(RechnenTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsDauer);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", bewertung);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        finishscreenIntent.putExtra("highscoreObject", highscore);
        RechnenTask.this.startActivity(finishscreenIntent);
        RechnenTask.this.finish();
    }

    private int RateTheGame(long duration, int attempts, int limit) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new RechnenRater(durationInSeconds, attempts, limit);
        return gameRater.getRating();
    }
}
