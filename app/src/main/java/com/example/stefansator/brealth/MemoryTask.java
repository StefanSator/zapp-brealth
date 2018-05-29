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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by StefanSator on 17.05.18.
 */

public class MemoryTask extends AppCompatActivity {
    private String cardPos[];
    private String cardNames[] = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
    private TextView memoryCard[];
    private long startZeit, endZeit;
    private int falseCounter = 0, rightCounter = 0;
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    /* variables which will later include index of drawn cards */
    private int firstDraw = -1;
    private int secondDraw = -1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        cardPos = new String[12];
        memoryCard = new TextView[12];

        /* Initialize memoryCard Array */
        memoryCard[0] = findViewById(R.id.memory_card1);
        memoryCard[1] = findViewById(R.id.memory_card2);
        memoryCard[2] = findViewById(R.id.memory_card3);
        memoryCard[3] = findViewById(R.id.memory_card4);
        memoryCard[4] = findViewById(R.id.memory_card5);
        memoryCard[5] = findViewById(R.id.memory_card6);
        memoryCard[6] = findViewById(R.id.memory_card7);
        memoryCard[7] = findViewById(R.id.memory_card8);
        memoryCard[8] = findViewById(R.id.memory_card9);
        memoryCard[9] = findViewById(R.id.memory_card10);
        memoryCard[10] = findViewById(R.id.memory_card11);
        memoryCard[11] = findViewById(R.id.memory_card12);

        /* Initialize Position of the memory cards */
        for (int i = 0 ; i < memoryCard.length ; i++) {
            int randomNumber = randomNumberGenerator(0, 11);
            while (cardNames[randomNumber].equals("empty")) {
                randomNumber = randomNumberGenerator(0, 11);
            }
            String name = cardNames[randomNumber];
            cardNames[randomNumber] = "empty";

            cardPos[i] = name;
        }

        startZeit = System.currentTimeMillis();
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void revealMemoryCard(View view) throws InterruptedException {
        for (int i = 0 ; i < memoryCard.length ; i++) {
            if (memoryCard[i] == view) {
                ((TextView) view).setText(cardPos[i]);
                if (firstDraw == -1) firstDraw = i;
                else secondDraw = i;
            }
        }

        /* 2 cards selected, now test if right cards where selected */
        if (firstDraw != -1 && secondDraw != -1) {
            checkMemoryCards();
        }
    }

    private void checkMemoryCards() {
        boolean test = testIfDrawnCardsAreRight(firstDraw, secondDraw);
        if (test == true) {
            disableRightCards(firstDraw, secondDraw);
            rightCounter++;
            Toast rightToast = Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT);
            rightToast.show();
        } else {
            falseCounter++;
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
            createInformationDialog(memoryCard[firstDraw], memoryCard[secondDraw]);
        }

        if (rightCounter == 6) {
            endGame();
        }
        beginNewDraw();
    }

    private void endGame() {
        endZeit = System.currentTimeMillis();
        long bearbeitungsDauer = endZeit - startZeit;
        int bewertung = RateThePlayer(bearbeitungsDauer, falseCounter);

        Intent finishscreenIntent = new Intent(MemoryTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsDauer);
        finishscreenIntent.putExtra("falsch", falseCounter);
        finishscreenIntent.putExtra("rating", bewertung);
        MemoryTask.this.startActivity(finishscreenIntent);
        MemoryTask.this.finish();
    }

    private boolean testIfDrawnCardsAreRight(int first, int second) {
        if (cardPos[first] == cardPos[second]) return true;
        return false;
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
        ((TextView) view1).setText("/@");
        ((TextView) view2).setText("/@");
    }

    /* Rates your Skill in this particular Task */
    private int RateThePlayer(long duration, int attempts) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new MemoryRater(durationInSeconds, attempts);
        return gameRater.getRating();
    }

    private void createInformationDialog(final View view1, final View view2) {
        dlgBuilder = new AlertDialog.Builder(MemoryTask.this);
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

}
