package com.example.stefansator.brealth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class StretchingColors extends AppCompatActivity {
    private ImageView stretchingImg;
    private TextView stretchingColorText, instruction;
    private EditText falseAnswer;
    private Button submitAnswer;
    private CountDownTimer countDownTimer;
    private String textColor, stretchingExercise;
    private boolean waiting = false;
    private int switchCounter = 0, chkExercise[],exerciseNr = 6,imageCounter =0, falseCounter, colorCounter = 0;
    private long exerciseDuration = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretchingcolors);

        stretchingImg =findViewById(R.id.stretching_colors_image);
        stretchingColorText = findViewById(R.id.stretching_color_word);
        instruction = findViewById(R.id.stretching_color_instruction);
        submitAnswer = findViewById(R.id.stretching_color_Submit);
        falseAnswer = findViewById(R.id.stretching_color_falseAnswer);

        chkExercise = new int[exerciseNr];

        startExercise();
    }

    private void switchImage (String exercise) {
        switch (exercise) {
            case "" + R.drawable.stretchingcolors_shoulder_stretch_left:
                stretchingImg.setImageResource(Integer.parseInt("" + R.drawable.stretchingcolors_shoulder_stretch_right));
                break;
            case "" + R.drawable.stretchingcolors_neck_left:
                stretchingImg.setImageResource(Integer.parseInt("" + R.drawable.stretchingcolors_neck_right));
                break;
            case "" + R.drawable.stretchingcolors_triceps_left:
                stretchingImg.setImageResource(Integer.parseInt("" + R.drawable.stretchingcolors_triceps_right));
                break;
            case "" + R.drawable.stretchingcolors_wrist_down:
                stretchingImg.setImageResource(Integer.parseInt( "" + R.drawable.stretchingcolors_wrist_up));
                break;
            case "" + R.drawable.stretchingcolors_quad_left:
                stretchingImg.setImageResource(Integer.parseInt("" + R.drawable.stretchingcolors_quad_right));
                break;
            case "" + R.drawable.stretchingcolors_flexor_left:
                stretchingImg.setImageResource(Integer.parseInt("" + R.drawable.stretchingcolors_flexor_right));
            default:
                return;
        }
    }

    private void imageSwitch(String firstImage, String secondImage) {
        if(switchCounter == 0) {
            stretchingImg.setImageResource(Integer.parseInt(firstImage));
            switchCounter++;
        } else {
            stretchingImg.setImageResource(Integer.parseInt(secondImage));
            switchCounter--;
        }
    }

    private void startExercise() {
        long offset = 2000;
        long previewtime = 5000;

        countDownTimer = new CountDownTimer(exerciseDuration+previewtime+offset, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long timeRemaining = millisUntilFinished/1000 - 1;
                long waitingTime = (millisUntilFinished - exerciseDuration)/1000 - 2;

                if(imageCounter == 0 && !waiting && timeRemaining != 0) {
                    stretchingExercise = randomExercise();
                    stretchingImg.setImageResource(Integer.parseInt(stretchingExercise));
                } else if (imageCounter == 10){
                    switchImage(stretchingExercise);
                }

                if ((waitingTime)>= 0) {
                    waiting = true;
                    stretchingColorText.setText("Wartezeit: " + waitingTime);
                    return;
                } else if (timeRemaining > 0 && colorCounter == 0) {
                    stretchingColorText.setText("Sekunden: " + timeRemaining);
                    changeColor();
                } else if (timeRemaining == 0){
                    finishStretching();
                }

                imageCounter++;
                colorCounter++;

                if(colorCounter == 2)
                    colorCounter = 0;

                if (imageCounter == 20) {
                    imageCounter = 0;
                }

                waiting = false;
            }

            public void onFinish() {
                countDownTimer.cancel();
            }
        }.start();
    }

    public void finishStretching(){
        stretchingColorText.setText("Fertig");
        stretchingColorText.setTextColor(Color.YELLOW);
        instruction.setText("Wie viele Fehler haben Sie gemacht ?");
        submitAnswer.setVisibility(View.VISIBLE);
        falseAnswer.setVisibility(View.VISIBLE);
    }

    public void checkAnswer(View view) {
        if (falseAnswer.getText().length() == 0){
            Toast.makeText(this, "Zahl eingeben", Toast.LENGTH_SHORT).show();
            return;
        }

        falseCounter = Integer.parseInt(falseAnswer.getText().toString());
        gotoEndscreen();
    }


    private int RateTheGame(int attempts) {
        GameRater gameRater = new StretchingColorsRater(attempts);
        return gameRater.getRating();
    }

    public void gotoEndscreen() {
        int rating = RateTheGame(falseCounter);

        Intent finishscreenIntent = new Intent(StretchingColors.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", rating);
        StretchingColors.this.startActivity(finishscreenIntent);
        StretchingColors.this.finish();
    }

    private String randomExercise() {
        int nr;
        nr = usableExercise();
        return getExerciseId(nr);
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

    public void changeColor(){
        textColor = setColorText();
        stretchingColorText.setText(textColor);
        setColor();
    }

    private void setColor() {
        Random r = new Random();
        int color = r.nextInt(4) + 1;
        switch (color) {
            case 1:
                stretchingColorText.setTextColor(Color.RED);
                break;
            case 2:
                stretchingColorText.setTextColor(Color.GREEN);
                break;
            case 3:
                stretchingColorText.setTextColor(Color.WHITE);
                break;
            case 4:
                stretchingColorText.setTextColor(Color.YELLOW);
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
                return "weiß";
            case 4:
                return "gelb";
            default:
                break;
        }
        return null;
    }

    public String getExerciseId(int i) {
        switch(i) {
            case 0:
                return "" + R.drawable.stretchingcolors_shoulder_stretch_left;
            case 1:
                return "" + R.drawable.stretchingcolors_neck_left;
            case 2:
                return "" + R.drawable.stretchingcolors_triceps_left;
            case 3:
                return "" + R.drawable.stretchingcolors_wrist_down;
            case 4:
                return "" + R.drawable.stretchingcolors_quad_left;
            case 5:
                return "" + R.drawable.stretchingcolors_flexor_left;
            default:
                return "not found";
        }
    }
}
