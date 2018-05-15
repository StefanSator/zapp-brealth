package com.example.stefansator.brealth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class FarbenEasyMode extends AppCompatActivity {
    TextView text,explanation;
    int counter;
    String mainColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbeneasymode);
        text = (TextView) findViewById(R.id.farbenView);
        explanation = (TextView) findViewById(R.id.explanation);
        mainColor = setColorText();
        explanation.setText("Klicken Sie True wenn die Farbe in "+mainColor+" geschrieben ist");

    }

    private void setColor(TextView textview) {
        Random r = new Random();
        int color = r.nextInt(5 - 1) + 1;
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
        int textFeld = r.nextInt(5 - 1) + 1;
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


    void changeColor(View view){
        String color = setColorText();
        setColor(text);
        text.setText(color);

        counter++;

        if(counter == 10)
            gotoEndscreen();
    }

    private void gotoEndscreen() {
        Intent farbenEndscreen = new Intent(FarbenEasyMode.this, FarbenEndscreen.class);
        FarbenEasyMode.this.startActivity(farbenEndscreen);
    }


}
