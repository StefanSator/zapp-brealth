package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Logik extends AppCompatActivity{
    private ImageView firstSymbol,secondSymbol,thirdSymbol;
    private TextView firstRowResult,secondRowResult,thirdRowResult;
    private EditText submitAnswer;
    private int symbolCNumber, symbolTNumber, endResult=0, counter = 0, falseCounter = 0, LIMIT = 10 ;
    private long starttime, endtime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logik);

        firstSymbol = findViewById(R.id.logik_symbol_7);
        secondSymbol = findViewById(R.id.logik_symbol_8);
        thirdSymbol = findViewById(R.id.logik_symbol_9);
        firstRowResult = findViewById(R.id.logik_firstRowResult);
        secondRowResult = findViewById(R.id.logik_secondRowResult);
        thirdRowResult = findViewById(R.id.logik_thirdRowResult);
        submitAnswer = findViewById(R.id.logik_answer);
        setFirstRow();
        setSecondRow();
        setThirdRow();
        starttime = System.currentTimeMillis();
    }

    public void setFirstRow() {
        String result;
        Random r = new Random();

        do {
            symbolCNumber = r.nextInt(99) + 1;
        } while(symbolCNumber % 3 != 0);

        result = Integer.toString(symbolCNumber);
        firstRowResult.setText("= " +result);
        return;
    }

    public void setSecondRow() {
        String result;
        Random r = new Random();

        do {
            symbolTNumber = r.nextInt(99) + 1;
        } while(symbolTNumber % 3 != 0 && symbolTNumber != symbolCNumber);

        result = Integer.toString(symbolTNumber);
        secondRowResult.setText("= " +result);
        return;
    }

    public void setThirdRow(){
        int triangeCnt = 0, circleCnt = 0, symbol = 0;
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
                triangeCnt++;
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
                triangeCnt++;
                break;
        }


        if (circleCnt == 2 && triangeCnt == 0) {
            thirdSymbol.setImageResource(R.drawable.triangle);
            endResult = endResult + symbolTNumber;
        } else if (circleCnt == 0 && triangeCnt == 2) {
            thirdSymbol.setImageResource(R.drawable.circle);
            endResult = endResult + symbolCNumber;
        } else {
            symbol = r.nextInt((2 - 1) + 1);

            switch (symbol) {
                case 1:
                    thirdSymbol.setImageResource(R.drawable.circle);
                    endResult = endResult + symbolCNumber;
                    circleCnt++;
                    break;
                case 2:
                    thirdSymbol.setImageResource(R.drawable.triangle);
                    endResult =endResult + symbolTNumber;
                    triangeCnt++;
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
        Integer result = Integer.parseInt(submitAnswer.getText().toString());

        if (endResult == result){
            Toast.makeText(this, "Richtig", Toast.LENGTH_SHORT).show();
            counter++;
        } else {
            Toast.makeText(this,""+endResult, Toast.LENGTH_SHORT).show();
            falseCounter++;
        }

        if(counter > LIMIT)
            gotoEndscreen();
        else
            setRows();
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

        Intent finishscreenIntent = new Intent(Logik.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        Logik.this.startActivity(finishscreenIntent);
        Logik.this.finish();
    }
}
