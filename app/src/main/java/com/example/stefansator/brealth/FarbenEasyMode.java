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
    private Button fButton,rButton;
    private int LIMIT = 10,counter, falseCounter = 0;
    private long startzeit, endzeit;
    private String mainColor, textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbeneasymode);
        text = findViewById(R.id.farbenView_em);
        explanation = findViewById(R.id.farben_explanation_em);
        rButton = findViewById(R.id.farben_buttonTrue_em);
        fButton = findViewById(R.id.farben_buttonFalse_em);
        mainColor = setColorText();
        explanation.setText("Klicken Sie True wenn " +mainColor+" geschrieben ist");
    }

    public void start(View view){
        rButton.setClickable(true);
        rButton.setVisibility(View.VISIBLE);
        fButton.setClickable(true);
        fButton.setVisibility(View.VISIBLE);
        text.setClickable(false);
        startzeit = System.currentTimeMillis();
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

        if(counter > LIMIT)
            gotoEndscreen();
        else
            changeColor();
    }

    private void gotoEndscreen() {
        endzeit = System.currentTimeMillis();
        long bearbeitungsDauer = endzeit - startzeit;
        Intent farbenEndscreen = new Intent(FarbenEasyMode.this, FarbenEndscreen.class);

        farbenEndscreen.putExtra("dauer", bearbeitungsDauer);
        farbenEndscreen.putExtra("falsch",falseCounter);
        FarbenEasyMode.this.startActivity(farbenEndscreen);
        FarbenEasyMode.this.finish();
    }
}
