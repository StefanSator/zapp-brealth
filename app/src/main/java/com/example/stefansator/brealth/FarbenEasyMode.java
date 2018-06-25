package com.example.stefansator.brealth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FarbenEasyMode extends AppCompatActivity {
    private TextView text, explanation;
    private int LIMIT = 10,counter, falseCounter = 0;
    private long starttime, endtime;
    private String mainColor, textColor, taskName = "fem";
    private boolean wipeHighscore = false;
    private Highscore highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbeneasymode);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);

        text = findViewById(R.id.farbenView_em);
        explanation = findViewById(R.id.farben_explanation_em);
        mainColor = setColorText();
        explanation.setText("Klicken Sie Richtig wenn " +mainColor+" geschrieben ist");
        starttime = System.currentTimeMillis();
        changeColor();
    }

    private void setColor(TextView textview) {
        Random r = new Random();
        int color = r.nextInt(4) + 1;
        switch (color) {
            case 1:
                textview.setTextColor(Color.RED);
                break;
            case 2:
                textview.setTextColor(Color.GREEN);
                break;
            case 3:
                textview.setTextColor(Color.BLUE);
                break;
            case 4:
                textview.setTextColor(Color.YELLOW);
                break;
            default:
                break;
        }
    }

    private String setColorText() {
        Random r = new Random();
        int textFeld = r.nextInt(4) + 1;
        switch (textFeld) {
            case 1:
                return "rot";
            case 2:
                return "grün";
            case 3:
                return "blau";
            case 4:
                return "gelb";
            default:
                break;
        }
        return null;
    }

    public void changeColor(){
        textColor = setColorText();
        setColor(text);
        text.setText(textColor);
    }

    public void checkOption (View view){
        switch (view.getId()){
            case R.id.farben_buttonTrue_em:
                if(textColor == mainColor) {
                    Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                    counter++;
                } else {
                    Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                    falseCounter++;
                }
                break;
            case R.id.farben_buttonFalse_em:
                if(textColor != mainColor) {
                    Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                    counter++;
                } else {
                    Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                    falseCounter++;
                }
                break;
        }

        if(counter == LIMIT)
            gotoEndscreen();
        else
            changeColor();
    }

    private int RateThePlayer(long duration, int attempts) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new FarbenModeRater(durationInSeconds, attempts);
        return gameRater.getRating();
    }

    private void gotoEndscreen() {
        endtime = System.currentTimeMillis();
        long duration = endtime - starttime;
        int rating = RateThePlayer(duration, falseCounter);

        highscore.setDuration(duration);
        highscore.setRating(rating);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscore();

        Intent finishscreenIntent = new Intent(FarbenEasyMode.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        finishscreenIntent.putExtra("highscoreObject", highscore);
        FarbenEasyMode.this.startActivity( finishscreenIntent);
        FarbenEasyMode.this.finish();
    }
}
