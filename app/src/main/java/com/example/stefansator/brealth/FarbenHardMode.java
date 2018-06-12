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

public class FarbenHardMode extends AppCompatActivity {
    private TextView firsttext, sectext, thirdtext, explanation;
    private int LIMIT = 10, counter = 0, falseCounter = 0;
    private long starttime, endtime;
    private String mainColor, ftextColor, stextColor, ttextColor;
    private VARIANTE variante;

    public enum VARIANTE {
        TEXTFARBE,GESCHRIEBEN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbenhardmode);
        firsttext = findViewById(R.id.farben_view1_hm);
        sectext = findViewById(R.id.farben_view2_hm);
        thirdtext = findViewById(R.id.farben_view3_hm);
        explanation = findViewById(R.id.farben_explanation_hm);
        changeColor();
        starttime = System.currentTimeMillis();
    }

    public void setExplanationText(String color) {
        Random r = new Random();
        int choice = r.nextInt(2) + 1;
        switch (choice) {
            case 1:
                explanation.setText("Tippen Sie den Text der "+color+" ist");
                variante = VARIANTE.TEXTFARBE;
                break;
            case 2:
                explanation.setText("Tippen Sie wenn "+color+" geschrieben ist");
                variante = VARIANTE.GESCHRIEBEN;
                break;
            default:
                break;
        }
    }

    private String setColor(TextView textview) {
        Random r = new Random();
        int color = r.nextInt(4) + 1;
        switch (color) {
            case 1:
                textview.setTextColor(Color.RED);
                return "rot";
            case 2:
                textview.setTextColor(Color.GREEN);
                return "grün";
            case 3:
                textview.setTextColor(Color.BLUE);
                return "blau";
            case 4:
                textview.setTextColor(Color.YELLOW);
                return "gelb";
            default:
                break;
        }
        return null;
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
        mainColor = setColorText();
        setExplanationText(mainColor);
        ftextColor = setColor(firsttext);
        stextColor = setColor(sectext);
        ttextColor = setColor(thirdtext);
        firsttext.setText(setColorText());
        sectext.setText(setColorText());
        thirdtext.setText(setColorText());
    }

    public void checkOption (View view){
        switch (view.getId()){
            case R.id.farben_view1_hm:
                if (variante == VARIANTE.GESCHRIEBEN) {
                    if (firsttext.getText() == mainColor) {
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                } else {
                    if(ftextColor == mainColor){
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                }
                break;
            case R.id.farben_view2_hm:
                if (variante == VARIANTE.GESCHRIEBEN) {
                    if (sectext.getText() == mainColor) {
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                } else {
                    if(stextColor == mainColor){
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                }
                break;
            case R.id.farben_view3_hm:
                if (variante == VARIANTE.GESCHRIEBEN) {
                    if (thirdtext.getText() == mainColor) {
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                } else {
                    if(ttextColor == mainColor){
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                }
                break;
            case R.id.farben_falseButton_hm:
                if (variante == VARIANTE.GESCHRIEBEN){
                    if(firsttext.getText() != mainColor && sectext.getText() != mainColor && thirdtext.getText()!= mainColor) {
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
                } else {
                    if(ftextColor != mainColor && stextColor != mainColor && ttextColor != mainColor) {
                        Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
                        counter++;
                    } else {
                        Toast.makeText(this,"Falsch",Toast.LENGTH_SHORT).show();
                        falseCounter++;
                    }
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

        Intent finishscreenIntent = new Intent(FarbenHardMode.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        FarbenHardMode.this.startActivity( finishscreenIntent);
        FarbenHardMode.this.finish();
    }
}
