package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by stefansator on 07.05.18.
 * Revised by stefansator on 28.05.18
 */

public class TaskEndscreen extends AppCompatActivity {
    private TextView dauerFeld;
    private TextView falschFeld;
    private RatingBar rating;
    private long bearbeitungsDauer;
    private int falseCounter;
    private int bewertung;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskendscreen);

        dauerFeld = findViewById(R.id.zeit_rechnen);
        falschFeld = findViewById(R.id.falschCounter_rechnenend);
        rating = findViewById(R.id.setRating);



        if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
            setDauerAndFalschFeld();
        } else if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == false) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            setOnlyDauerFeld();
        } else {
            System.out.println("Error in RechnenEnd");
            TaskEndscreen.this.finish();
        }

        if (getIntent().hasExtra("highscore") == true) {
            boolean isHighscore = getIntent().getExtras().getBoolean("highscore");
            if (isHighscore == true) {
                TextView ergebnis = findViewById(R.id.ergebnis_rechnenend);
                ergebnis.setText("NEW HIGHSCORE");
            }
        }
        /* Show right Star Rating */
        setStarRating();
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

    private void setStarRating() {
        if (getIntent().hasExtra("rating") == true) {
            setNumberOfStars();
        } else {
            rating.setRating(0.0f);
        }
    }

    private void setNumberOfStars() {
        bewertung = getIntent().getExtras().getInt("rating");

        switch (bewertung) {
            case 0:
                rating.setRating(0.0f);
                break;
            case 1:
                rating.setRating(1.0f);
                break;
            case 2:
                rating.setRating(2.0f);
                break;
            case 3:
                rating.setRating(3.0f);
                break;
            case 4:
                rating.setRating(4.0f);
                break;
            case 5:
                rating.setRating(5.0f);
                break;
            default:
                rating.setRating(0.0f);
                break;
        }
    }

    public void endResultScreen(View view) {
        TaskEndscreen.this.finish();
    }
}
