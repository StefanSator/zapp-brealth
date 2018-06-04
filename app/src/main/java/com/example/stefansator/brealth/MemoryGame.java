package com.example.stefansator.brealth;

import java.util.Random;

/**
 * Created by StefanSator on 04.06.18.
 */

public abstract class MemoryGame {
    private String cardPos[];
    private String cardNames[];
    private final int NUMBER_OF_CARDS = 12;

    public MemoryGame() {
        cardNames = new String[NUMBER_OF_CARDS];
        cardNames = setCardNames();
        cardPos = new String[NUMBER_OF_CARDS];
        initializeMemoryGame();
    }

    /* abstract Method which sets the names of your memory cards for each specific memory game,
     * is implemented in subclass
     */
    public abstract String[] setCardNames();

    /* Initialize Position of the memory cards */
    public void initializeMemoryGame() {
        for (int i = 0 ; i < NUMBER_OF_CARDS ; i++) {
            int randomNumber = randomNumberGenerator(0, 11);
            while (cardNames[randomNumber].equals("empty")) {
                randomNumber = randomNumberGenerator(0, 11);
            }
            String name = cardNames[randomNumber];
            cardNames[randomNumber] = "empty";

            cardPos[i] = name;
        }
    }

    public String getMemoryCard(int index) {
        return cardPos[index];
    }

    public boolean areEqual(int index1, int index2) {
        if (cardPos[index1] == cardPos[index2]) return true;
        return false;
    }

    /* gives back a random number between min and max */
    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
