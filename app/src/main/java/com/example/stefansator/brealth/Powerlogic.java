package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Powerlogic extends AppCompatActivity{
    private AlertDialog dlg;
    private AlertDialog.Builder dlgBuilder;
    private TextView dlgText;
    private Button dlgButton;
    private CountDownTimer dlgCdt;
    private ImageView dlgView;
    private String dlgExerciseImg;

    private ImageView symbols[];
    private TextView firstRowResult,secondRowResult;
    private EditText submitAnswer;
    private int firstRowNr, secondRowNr, endResult=0, counter = 0, falseCounter = 0, LIMIT = 10,symNr = 9,chkExercise[],exerciseNr = 8,imageCounter = 0;
    private String taskName = "powerlogik",firstRowImage,secondRowImage;
    private long starttime, endtime, dlgDuration = 0;;
    private boolean wipeHighscore = false;
    private Highscore highscore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerlogic);

        LIMIT = getIntent().getIntExtra("LIMIT",10);
        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);

        chkExercise = new int[exerciseNr];
        symbols = new ImageView[symNr + 1];

        symbols[1] = findViewById(R.id.logik_symbol_1);
        symbols[2] = findViewById(R.id.logik_symbol_2);
        symbols[3] = findViewById(R.id.logik_symbol_3);
        symbols[4] = findViewById(R.id.logik_symbol_4);
        symbols[5] = findViewById(R.id.logik_symbol_5);
        symbols[6] = findViewById(R.id.logik_symbol_6);
        symbols[7] = findViewById(R.id.logik_symbol_7);
        symbols[8] = findViewById(R.id.logik_symbol_8);
        symbols[9] = findViewById(R.id.logik_symbol_9);

        firstRowResult = findViewById(R.id.logik_firstRowResult);
        secondRowResult = findViewById(R.id.logik_secondRowResult);
        submitAnswer = findViewById(R.id.logik_answer);

        setFirstRow();
        setSecondRow();
        setThirdRow();

        starttime = System.currentTimeMillis();
    }

    public String getExerciseId(int i) {
        switch(i) {
            case 0:
                return "" + R.drawable.powerlogic_curl_left;
            case 1:
                return "" + R.drawable.powerlogic_flutter_left;
            case 2:
                return "" + R.drawable.powerlogic_peck_in;
            case 3:
                return "" + R.drawable.powerlogic_rear_in;
            case 4:
                return "" + R.drawable.powerlogic_spp;
            case 5 :
                return "" + R.drawable.powerlogic_plank;
            case 6:
                return "" + R.drawable.powerlogic_swimmer_left;
            case 7:
                return "" + R.drawable.powerlogic_tricep_up;
            default:
                return "not found";
        }
    }

    public int usableExercise() {
        Random r = new Random();
        int nr;
        do {
            nr = r.nextInt(exerciseNr);
        } while (chkExercise[nr] != 0);

        chkExercise[nr] = 1;

        return nr;
    }

    public void setFirstRow() {
        int result, nr;

        Random r = new Random();

        firstRowNr = r.nextInt(20) + 1;
        result = firstRowNr * 3;
        firstRowResult.setText("= "+result);

        nr = usableExercise();
        firstRowImage = getExerciseId(nr);
        symbols[1].setImageResource(Integer.parseInt(firstRowImage));
        symbols[2].setImageResource(Integer.parseInt(firstRowImage));
        symbols[3].setImageResource(Integer.parseInt(firstRowImage));
        return;
    }

    public void setSecondRow() {
        int result, nr;

        Random r = new Random();

        do {
            secondRowNr= r.nextInt(20) + 1;
        } while(secondRowNr == firstRowNr);

        result = secondRowNr * 3;
        secondRowResult.setText("= " +result);

        nr = usableExercise();
        secondRowImage = getExerciseId(nr);
        symbols[4].setImageResource(Integer.parseInt(secondRowImage));
        symbols[5].setImageResource(Integer.parseInt(secondRowImage));
        symbols[6].setImageResource(Integer.parseInt(secondRowImage));

        return;
    }

    public void setThirdRow(){
        int symbol,circleCnt = 0,triangleCnt = 0;

        Random r = new Random();
        symbol = r.nextInt(2) + 1;

        switch (symbol) {
            case 1:
                symbols[7].setImageResource(Integer.parseInt(firstRowImage));
                endResult = endResult + firstRowNr;
                circleCnt++;
                break;
            case 2:
                symbols[7].setImageResource(Integer.parseInt(secondRowImage));
                endResult = endResult + secondRowNr;
                triangleCnt++;
                break;
        }

        symbol = r.nextInt( 2)+ 1;
        switch (symbol) {
            case 1:
                symbols[8].setImageResource(Integer.parseInt(firstRowImage));
                endResult = endResult + firstRowNr;
                circleCnt++;
                break;
            case 2:
                symbols[8].setImageResource(Integer.parseInt(secondRowImage));
                endResult = endResult + secondRowNr;
                triangleCnt++;
                break;
        }

        if (circleCnt == 2 && triangleCnt == 0) {
            symbols[9].setImageResource(Integer.parseInt(secondRowImage));
            endResult = endResult + secondRowNr;
        } else if (circleCnt == 0 && triangleCnt == 2) {
            symbols[9].setImageResource(Integer.parseInt(firstRowImage));
            endResult = endResult + firstRowNr;
        } else {
            symbol = r.nextInt(2 ) + 1;
            switch(symbol){
                case 1:
                    symbols[9].setImageResource(Integer.parseInt(firstRowImage));
                    endResult = endResult + firstRowNr;
                    break;
                case 2:
                    symbols[9].setImageResource(Integer.parseInt(secondRowImage));
                    endResult = endResult + secondRowNr;
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

        Arrays.fill(chkExercise,0);
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
        duration = duration - dlgDuration;
        int rating = RateTheGame(duration, falseCounter);

        highscore.setDuration(duration);
        highscore.setRating(rating);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscore();

        Intent finishscreenIntent = new Intent(Powerlogic.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", duration);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        Powerlogic.this.startActivity(finishscreenIntent);
        Powerlogic.this.finish();
    }

    public void createAlertDialog() {
        View view = getLayoutInflater().inflate(R.layout.activity_powerlogic_dialog, null);
        dlgText = view.findViewById(R.id.powerlogic_Dlg_Timer);
        dlgView = view.findViewById(R.id.powerlogic_Dlg_Img);
        dlgButton = view.findViewById(R.id.powerlogic_Dlg_cancel);

        dlgBuilder = new AlertDialog.Builder(this);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setView(view);

        dlgExerciseImg = randomExercise();
        dlg = dlgBuilder.create();
        dlg.show();
        setDlgCdt();
    }

    private String randomExercise() {
        Random r = new Random();
        int nr = r.nextInt(2) + 1;
        switch(nr){
            case 1: return firstRowImage;
            case 2: return secondRowImage;
            default: return "not found";
        }
    }

    private void setDlgCdt() {
        final long previewtime = 10000;
        final long exerciseDuration = endResult*1000;
        final long offset = 2000;


        dlgDuration = dlgDuration + previewtime+exerciseDuration+1000;

        dlgCdt = new CountDownTimer(offset+previewtime+exerciseDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long timeRemaining = millisUntilFinished/1000 - 1;
                long waitingTime = timeRemaining - endResult - 1;
                if ((waitingTime)>= 0) {
                    dlgText.setText("Wartezeit: " + waitingTime);
                    dlgSetImage(dlgExerciseImg);
                    return;
                } else if (timeRemaining > 0) {
                    dlgText.setText("Sekunden: " + timeRemaining);
                    dlgSetImage(dlgExerciseImg);
                } else {
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

    private void imageSwitch(String firstImage, String secondImage) {
        if(imageCounter == 0) {
            dlgView.setImageResource(Integer.parseInt(firstImage));
            imageCounter++;
        } else {
            dlgView.setImageResource(Integer.parseInt(secondImage));
            imageCounter--;
        }
    }

    private void dlgSetImage(String exercise) {
        switch (exercise) {
            case "" + R.drawable.powerlogic_curl_left:
                imageSwitch("" + R.drawable.powerlogic_curl_left,"" + R.drawable.powerlogic_curl_right);
                break;
            case "" + R.drawable.powerlogic_flutter_left:
                imageSwitch("" + R.drawable.powerlogic_flutter_left, "" + R.drawable.powerlogic_flutter_right);
                break;
            case "" + R.drawable.powerlogic_peck_in:
                imageSwitch("" + R.drawable.powerlogic_peck_in,"" + R.drawable.powerlogic_peck_out);
                break;
            case "" + R.drawable.powerlogic_rear_in:
                imageSwitch("" + R.drawable.powerlogic_rear_in,"" + R.drawable.powerlogic_rear_out);
                break;
            case "" + R.drawable.powerlogic_spp:
                imageSwitch("" + R.drawable.powerlogic_spp,"" + R.drawable.powerlogic_sps);
                break;
            case "" + R.drawable.powerlogic_swimmer_left:
                imageSwitch("" + R.drawable.powerlogic_swimmer_left,"" + R.drawable.powerlogic_swimmer_right);
                 break;
            case "" + R.drawable.powerlogic_tricep_up:
                imageSwitch("" + R.drawable.powerlogic_tricep_up,"" + R.drawable.powerlogic_tricep_down);
                break;
            default:
                return;
        }
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