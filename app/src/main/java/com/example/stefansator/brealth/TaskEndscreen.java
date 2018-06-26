package com.example.stefansator.brealth;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by stefansator on 07.05.18.
 * Revised by stefansator on 28.05.18
 * Revised by juliansellner on 26.06.18
 */

public class TaskEndscreen extends AppCompatActivity {
    private TextView dauerFeld;
    private TextView falschFeld;
    private RatingBar rating;
    private String hsTask;
    private long bearbeitungsDauer, hsduration;
    private int falseCounter, hsRating, hsFalseAnswer;
    private int bewertung;
    private AlertDialog.Builder dlgBuilder;
    private AlertDialog alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskendscreen);

        dauerFeld = findViewById(R.id.zeit_rechnen);
        falschFeld = findViewById(R.id.falschCounter_rechnenend);
        rating = findViewById(R.id.setRating);
        ImageView highscoreImg = findViewById(R.id.highscore);

        if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
            setDauerAndFalschFeld();
        } else if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == false) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            setOnlyDauerFeld();
        } else if (getIntent().hasExtra("dauer") == false && getIntent().hasExtra("falsch") == true){
            falseCounter = getIntent().getExtras().getInt("falsch");
            setOnlyFalschFeld();
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

        if (getIntent().hasExtra("highscoreObject")){
            Highscore highscore = getIntent().getParcelableExtra("highscoreObject");
            hsRating = highscore.getRating();
            hsFalseAnswer = highscore.getFalseAnswer();
            hsTask = highscore.getTask();
            hsduration = highscore.getDuration()/1000;
        } else {
            highscoreImg.setVisibility(View.INVISIBLE);
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

    private void setOnlyFalschFeld() {
        falschFeld.setText("" + falseCounter);
        TextView dauerText = findViewById(R.id.bemerkung_rechnenend);
        dauerText.setText("");
    }

    private void setStarRating() {
        if (getIntent().hasExtra("rating") == true) {
            setNumberOfStars();
        } else {
            rating.setRating(0.0f);
        }
    }

    private void setNumberOfStars() {
        if (getIntent().hasExtra("rating")) {
            bewertung = getIntent().getExtras().getInt("rating");
        }

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

    public void showHighscore(View view) {
       dlgBuilder = new AlertDialog.Builder(TaskEndscreen.this);
        dlgBuilder.setTitle("Highscore");

        if(hsTask.toLowerCase().contains("lesen")) {
            dlgBuilder.setMessage("Sterne: " + hsRating+"\n"+ "Dauer: "+ hsduration);
        } else if (hsTask.toLowerCase().contains("vocable")){
            dlgBuilder.setMessage("Sterne: " + hsRating+"\n"+ "Fehler: "+ hsFalseAnswer);
        } else {
            dlgBuilder.setMessage("Sterne: " + hsRating+ "\n"+ "Dauer: "+ hsduration + "\n"+ "Fehler: "+ hsFalseAnswer);
        }

        alert = dlgBuilder.create();
        alert.show();
    }
}
