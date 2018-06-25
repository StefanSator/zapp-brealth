package com.example.stefansator.brealth;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class StretchingColors extends AppCompatActivity {
    private String taskName, textColor, stretchingExercise;
    private boolean wipeHighscore = false;
    private Highscore highscore;
    private int switchCounter = 0, chkExercise[],exerciseNr = 2,imageCounter =0;
    long starttime;
    private ImageView stretchingImg;
    private TextView stretchingColorText;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretchingcolors);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);

        stretchingImg =findViewById(R.id.stretching_colors_image);
        stretchingColorText = findViewById(R.id.stretching_color_word);

        chkExercise = new int[exerciseNr];

        startExercise();
    }

    private void startExercise() {
        starttime = System.currentTimeMillis();


        countDownTimer = new CountDownTimer(20000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long timeRemaining = millisUntilFinished/1000 - 1;
                if(imageCounter == 0) {
                    stretchingExercise = randomExercise();
                }
                imageCounter++;

                if (timeRemaining > 0) {
                    changeColor();
                    setImage(stretchingExercise);
                } else {
                    stretchingColorText.setText("Fertig");
                }

                if (imageCounter == 10)
                    imageCounter =0;

            }

            public void onFinish() {
                countDownTimer.cancel();

            }
        }.start();
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
                stretchingColorText.setTextColor(Color.BLUE);
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
                return "blau";
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
                return "" + R.drawable.stretchingcolors_shoulder_stretch_right;
            default:
                return "not found";
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

    private void setImage(String exercise) {
        switch (exercise) {
            case "" + R.drawable.stretchingcolors_shoulder_stretch_left:
                imageSwitch("" + R.drawable.stretchingcolors_shoulder_stretch_left, "" + R.drawable.stretchingcolors_shoulder_stretch_right);
                break;
            case "" + R.drawable.stretchingcolors_shoulder_stretch_right:
                imageSwitch("" + R.drawable.stretchingcolors_shoulder_stretch_right, "" + R.drawable.stretchingcolors_shoulder_stretch_left);
            default:
                return;
        }
    }
}
