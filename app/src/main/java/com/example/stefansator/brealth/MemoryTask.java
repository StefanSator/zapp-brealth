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
    private String cards[];
    private String cardNames[] = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
    private int countCards;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        countCards = 12;
        cards = new String[countCards];

        for (int i = 0 ; i < countCards ; i++) {
            int randomNumber = randomNumberGenerator(0, 11);
            while (cardNames[randomNumber].equals("empty")) {
                randomNumber = randomNumberGenerator(0, 11);
            }
            String name = cardNames[randomNumber];
            cardNames[randomNumber] = "empty";

            cards[i] = name;
        }
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void revealMemoryCard(View view) {
        TextView memoryText1 = findViewById(R.id.memory_card1);
        TextView memoryText2 = findViewById(R.id.memory_card2);
        TextView memoryText3 = findViewById(R.id.memory_card3);
        TextView memoryText4 = findViewById(R.id.memory_card4);
        TextView memoryText5 = findViewById(R.id.memory_card5);
        TextView memoryText6 = findViewById(R.id.memory_card6);
        TextView memoryText7 = findViewById(R.id.memory_card7);
        TextView memoryText8 = findViewById(R.id.memory_card8);
        TextView memoryText9 = findViewById(R.id.memory_card9);
        TextView memoryText10 = findViewById(R.id.memory_card10);
        TextView memoryText11 = findViewById(R.id.memory_card11);
        TextView memoryText12 = findViewById(R.id.memory_card12);

        memoryText1.setText(cards[0]);
        memoryText2.setText(cards[1]);
        memoryText3.setText(cards[2]);
        memoryText4.setText(cards[3]);
        memoryText5.setText(cards[4]);
        memoryText6.setText(cards[5]);
        memoryText7.setText(cards[6]);
        memoryText8.setText(cards[7]);
        memoryText9.setText(cards[8]);
        memoryText10.setText(cards[9]);
        memoryText11.setText(cards[10]);
        memoryText12.setText(cards[11]);
    }
}
