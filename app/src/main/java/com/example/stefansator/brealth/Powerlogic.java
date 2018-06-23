package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Powerlogic extends AppCompatActivity{
    private AlertDialog dlg;
    private AlertDialog.Builder dlgBuilder;
    private TextView dlgText;
    private Button dlgButton;
    private CountDownTimer dlgCdt;

    private ImageView firstSymbol,secondSymbol,thirdSymbol;
    private TextView firstRowResult,secondRowResult;
    private EditText submitAnswer;
    private int symbolCNumber, symbolTNumber, endResult=0, counter = 0, falseCounter = 0, LIMIT = 10;
    private String taskName = "powerlogik";
    private long starttime, endtime;
    private boolean wipeHighscore = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerlogic);

        LIMIT = getIntent().getIntExtra("LIMIT",10);
        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);

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
            submitAnswer.setText("");
            counter++;
        } else {
            Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
            submitAnswer.setText("");
            falseCounter++;
            return;
        }

        //createExerciseDialog(view);
        createAlertDialog();
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

        //Highscore highscore = new Highscore(this,duration,rating,taskName);
        //boolean isNewHighscore = highscore.isNewHighscore();
        //highscore.deleteHighscore(wipeHighscore);

        Intent finishscreenIntent = new Intent(Powerlogic.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        //finishscreenIntent.putExtra("highscore", isNewHighscore);
        Powerlogic.this.startActivity(finishscreenIntent);
        Powerlogic.this.finish();
    }

    private void setDialogImageView(ImageView dlgView) {
        Random r = new Random();
        int symbol = r.nextInt(2 ) + 1;
        switch(symbol){
            case 1:
                dlgView.setImageResource(R.drawable.circle);
                break;
            case 2:
                dlgView.setImageResource(R.drawable.triangle);
                break;
        }
    }

    public void createAlertDialog() {
        View view = getLayoutInflater().inflate(R.layout.activity_powerlogic_dialog, null);
        dlgText = view.findViewById(R.id.powerlogic_Dlg_Timer);
        ImageView dlgView = view.findViewById(R.id.powerlogic_Dlg_Img);
        dlgButton = view.findViewById(R.id.powerlogic_Dlg_cancel);
        setDialogImageView(dlgView);

        dlgBuilder = new AlertDialog.Builder(this);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setView(view);

        dlg = dlgBuilder.create();
        dlg.show();
        setDlgCdt();
    }

    private void setDlgCdt() {
        dlgCdt = new CountDownTimer(12000, 1000) {
            public void onTick(long millisUntilFinished) {
                long timeRemaining = millisUntilFinished/1000 - 1;
                dlgText.setText("Sekunden: " + timeRemaining);
                if (timeRemaining == 0) {
                    dlgText.setText("Fertig");
                    dlgButton.setVisibility(View.VISIBLE);
                    if (counter == LIMIT)
                        dlgButton.setText("Ende");
                }
            }

            public void onFinish() {
                dlgCdt.cancel();

            }
        }.start();
    }

    public void closeDialog(View view) {
        dlg.dismiss();

        if(counter == LIMIT) {
            gotoEndscreen();
        } else {
            endResult = 0;
            setRows();
        }
    }
}
