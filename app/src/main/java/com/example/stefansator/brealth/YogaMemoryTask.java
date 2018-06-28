package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by StefanSator on 05.06.18.
 */

public class YogaMemoryTask extends AppCompatActivity {
    private MemoryGame memoryGame;
    private ImageView memoryCard[];
    private long startZeit, endZeit;
    private int falseCounter = 0, rightCounter = 0;
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    private TestScore testScore;
    private boolean wipeHighscore = false;
    private Highscore highscore;
    private String taskName = "yogamemory";
    /* variables which will later include index of drawn cards */
    private int firstDraw = -1;
    private int secondDraw = -1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogamemorytask);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);

        memoryCard = new ImageView[12];

        /* Initialize memoryCard Array */
        memoryCard[0] = findViewById(R.id.yogamemory_card1);
        memoryCard[1] = findViewById(R.id.yogamemory_card2);
        memoryCard[2] = findViewById(R.id.yogamemory_card3);
        memoryCard[3] = findViewById(R.id.yogamemory_card4);
        memoryCard[4] = findViewById(R.id.yogamemory_card5);
        memoryCard[5] = findViewById(R.id.yogamemory_card6);
        memoryCard[6] = findViewById(R.id.yogamemory_card7);
        memoryCard[7] = findViewById(R.id.yogamemory_card8);
        memoryCard[8] = findViewById(R.id.yogamemory_card9);
        memoryCard[9] = findViewById(R.id.yogamemory_card10);
        memoryCard[10] = findViewById(R.id.yogamemory_card11);
        memoryCard[11] = findViewById(R.id.yogamemory_card12);

        memoryGame = new YogaMemoryGame();

        startZeit = System.currentTimeMillis();

        /* Reset Score for later use in Test Task in Brealth Category */
        testScore = new TestScore();
        writeTestScore(0, 0);
    }

    public void revealYogaTask(View view) throws InterruptedException {
        for (int i = 0 ; i < memoryCard.length ; i++) {
            if (memoryCard[i] == view) {
                ((ImageView) view).setImageResource(Integer.parseInt(memoryGame.getMemoryCard(i)));
                view.setBackgroundColor(getResources().getColor(R.color.white));
                if (firstDraw == -1) firstDraw = i;
                else secondDraw = i;
            }
        }

        /* 2 cards selected, now test if right cards where selected */
        if (firstDraw != -1 && secondDraw != -1) {
            checkMemoryCards(firstDraw, secondDraw);
        }
    }

    private void checkMemoryCards(int firstDraw, int secondDraw) {
        if (memoryGame.areEqual(firstDraw, secondDraw)) {
            disableRightCards(firstDraw, secondDraw);
            rightCounter++;
            Toast rightToast = Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT);
            rightToast.show();
            createTutorialDialog(firstDraw);
        } else {
            falseCounter++;
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
            createFalseDialog(memoryCard[firstDraw], memoryCard[secondDraw]);
        }

        beginNewDraw();
    }

    private void endGame() {
        endZeit = System.currentTimeMillis();
        long bearbeitungsDauer = endZeit - startZeit;
        int bewertung = RateThePlayer(bearbeitungsDauer, falseCounter);

        /* Save Score for later use in Test Task in Brealth Category */
        writeTestScore(falseCounter, bearbeitungsDauer/1000);

        highscore.setDuration(bearbeitungsDauer);
        highscore.setRating(bewertung);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscore();

        Intent finishscreenIntent = new Intent(YogaMemoryTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsDauer);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", bewertung);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        finishscreenIntent.putExtra("highscoreObject", highscore);
        YogaMemoryTask.this.startActivity(finishscreenIntent);
        YogaMemoryTask.this.finish();
    }

    private void beginNewDraw() {
        firstDraw = -1;
        secondDraw = -1;
    }

    private void disableRightCards(int first, int second) {
        memoryCard[first].setClickable(false);
        memoryCard[second].setClickable(false);
    }

    public void unrevealMemoryCards(View view1, View view2) {
        ((ImageView) view1).setImageResource(R.color.blue);
        view1.setBackgroundColor(getResources().getColor(R.color.blue));
        ((ImageView) view2).setImageResource(R.color.blue);
        view2.setBackgroundColor(getResources().getColor(R.color.blue));
    }

    /* Rates your Skill in this particular Task */
    private int RateThePlayer(long duration, int attempts) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new YogaMemoryRater(durationInSeconds, attempts);
        return gameRater.getRating();
    }

    private void createTutorialDialog(int yogaTask) {
        ImageView image = new ImageView(this);
        image.setImageResource(Integer.parseInt(memoryGame.getMemoryCard(yogaTask)));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
                if (rightCounter == 6) {
                    endGame();
                }
            }
        });

        dlgBuilder = new AlertDialog.Builder(YogaMemoryTask.this);
        dlgBuilder.setMessage("Führen Sie folgende Yoga Übung durch.");
        dlgBuilder.setCancelable(false);
        dlgBuilder.setView(image);

        alert = dlgBuilder.create();
        alert.show();
        alert.getWindow().setLayout(1000, 1000);
    }

    private void createFalseDialog(final View view1, final View view2) {
        dlgBuilder = new AlertDialog.Builder(YogaMemoryTask.this);
        dlgBuilder.setMessage("Leider Falsch!\n\nVersuch: Nr " + falseCounter);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Neuer Versuch", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                unrevealMemoryCards(view1, view2);
            }
        });

        alert = dlgBuilder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();

        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        messageView.setTextSize(32.0f);
        messageView.setTypeface(null, Typeface.BOLD);
    }

    private void writeTestScore(int attempts, long duration) {
        testScore.writeTestAttempts(this, "YogaTest", "TEST_ATTEMPT_YOGA", attempts);
        testScore.writeTestDuration(this, "YogaTest", "TEST_DURATION_YOGA", duration);
    }
}
