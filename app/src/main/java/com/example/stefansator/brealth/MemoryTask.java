package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by StefanSator on 13.05.18.
 */

public class MemoryTask extends AppCompatActivity {
    private String cardPos[];
    private String cardNames[] = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
    private int countCards;
    private TextView memoryCard[];

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
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void revealMemoryCard(View view) {
        for (int i = 0 ; i < countCards ; i++) {
            if (memoryCard[i] == view) {
                memoryCard[i].setText(cardPos[i]);
            }
        }
    }

}
