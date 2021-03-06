package com.example.stefansator.brealth.uebungen.brain.logik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stefansator.brealth.uebungen.GameRater;
import com.example.stefansator.brealth.uebungen.Highscore;
import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.TaskEndscreen;

import java.util.Random;

public class Logik extends AppCompatActivity{
    private ImageView firstSymbol,secondSymbol,thirdSymbol;
    private TextView firstRowResult,secondRowResult;
    private EditText submitAnswer;
    private int symbolCNumber, symbolTNumber, endResult=0, counter = 0, falseCounter = 0, LIMIT = 10;
    private long starttime, endtime;

    private boolean wipeHighscore = false;
    private Highscore highscore;
    private String taskName = "logik";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logik);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);

        firstSymbol = findViewById(R.id.logik_symbol_7);
        secondSymbol = findViewById(R.id.logik_symbol_8);
        thirdSymbol = findViewById(R.id.logik_symbol_9);
        firstRowResult = findViewById(R.id.logik_firstRowResult);
        secondRowResult = findViewById(R.id.logik_secondRowResult);
        submitAnswer = findViewById(R.id.logik_answer);
        setFirstRow();
        setSecondRow();
        setThirdRow();

        starttime = System.currentTimeMillis();
    }

    public void setFirstRow() {
        int result;
        Random r = new Random();
        symbolCNumber = r.nextInt(3) + 1;


        result = symbolCNumber * 3;
        firstRowResult.setText("= "+result);
        return;
    }

    public void setSecondRow() {
        int result;
        Random r = new Random();

        do {
            symbolTNumber = r.nextInt(33) + 1;
        } while(symbolTNumber == symbolCNumber);

        result = symbolTNumber * 3;
        secondRowResult.setText("= " +result);
        return;
    }

    public void setThirdRow(){
        int triangleCnt = 0, circleCnt = 0, symbol;

        Random r = new Random();
        symbol = r.nextInt(2) + 1;
        switch (symbol) {
            case 1:
                firstSymbol.setImageResource(R.drawable.circle);
                endResult = endResult + symbolCNumber;
                circleCnt++;
                break;
            case 2:
                firstSymbol.setImageResource(R.drawable.triangle);
                endResult = endResult + symbolTNumber;
                triangleCnt++;
                break;
        }

        symbol = r.nextInt( 2)+ 1;
        switch (symbol) {
            case 1:
                secondSymbol.setImageResource(R.drawable.circle);
                endResult = endResult + symbolCNumber;
                circleCnt++;
                break;
            case 2:
                secondSymbol.setImageResource(R.drawable.triangle);
                endResult = endResult + symbolTNumber;
                triangleCnt++;
                break;
        }

        if (circleCnt == 2 && triangleCnt == 0) {
            thirdSymbol.setImageResource(R.drawable.triangle);
            endResult = endResult + symbolTNumber;
        } else if (circleCnt == 0 && triangleCnt == 2) {
            thirdSymbol.setImageResource(R.drawable.circle);
            endResult = endResult + symbolCNumber;
        } else {
            symbol = r.nextInt(2 ) + 1;
            switch(symbol){
                case 1:
                    thirdSymbol.setImageResource(R.drawable.circle);
                    endResult = endResult + symbolCNumber;
                    break;
                case 2:
                    thirdSymbol.setImageResource(R.drawable.triangle);
                    endResult = endResult + symbolTNumber;
                    break;
            }
        }
    }

    public void setRows() {
        setFirstRow();
        setSecondRow();
        setThirdRow();
    }

    public void checkIfRight(View view) {
        if (submitAnswer.getText().length() == 0){
            Toast.makeText(this, "Zahl eingeben", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer result = Integer.parseInt(submitAnswer.getText().toString());

        if (endResult == result){
            Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
            submitAnswer.setText("");
            counter++;
        } else {
            Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
            submitAnswer.setText("");
            falseCounter++;
            return;
        }

        if(counter == LIMIT) {
            gotoEndscreen();
        } else {
            endResult = 0;
            setRows();
        }
    }

    private int RateTheGame(long duration, int attempts) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new LogikRater(durationInSeconds, attempts);
        return gameRater.getRating();
    }

    private void gotoEndscreen() {
        endtime = System.currentTimeMillis();
        long duration = endtime - starttime;
        int rating = RateTheGame(duration, falseCounter);

        highscore.setDuration(duration);
        highscore.setRating(rating);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscore();

        Intent finishscreenIntent = new Intent(Logik.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        finishscreenIntent.putExtra("highscoreObject", highscore);
        Logik.this.startActivity(finishscreenIntent);
        Logik.this.finish();
    }
}
