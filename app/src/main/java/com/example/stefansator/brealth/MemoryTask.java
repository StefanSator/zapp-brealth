package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by StefanSator on 13.05.18.
 */

public class MemoryTask extends AppCompatActivity {
    private String cardPos[];
    private String cardNames[] = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
    private int countCards;
    private TextView memoryCard[];
    /* variables which will later include index of drawn cards */
    private int firstDraw = -1;
    private int secondDraw = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        countCards = 12;
        cardPos = new String[countCards];
        memoryCard = new TextView[countCards];

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
        for (int i = 0 ; i < countCards ; i++) {
            int randomNumber = randomNumberGenerator(0, 11);
            while (cardNames[randomNumber].equals("empty")) {
                randomNumber = randomNumberGenerator(0, 11);
            }
            String name = cardNames[randomNumber];
            cardNames[randomNumber] = "empty";

            cardPos[i] = name;
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds

            }
        }, 2000);
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void revealMemoryCard(View view) throws InterruptedException {
        for (int i = 0 ; i < countCards ; i++) {
            if (memoryCard[i] == view) {
                memoryCard[i].setText(cardPos[i]);
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
            Toast rightToast = Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT);
            rightToast.show();
        } else {
            unrevealMemoryCards(firstDraw, secondDraw);
            Toast falseToast = Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT);
            falseToast.show();
        }
        beginNewDraw();
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

    private void unrevealMemoryCards(int first, int second) {
        memoryCard[first].setText("/@");
        memoryCard[second].setText("/@");
    }

}
