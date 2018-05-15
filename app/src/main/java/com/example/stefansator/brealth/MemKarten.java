package com.example.stefansator.brealth;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by StefanSator on 15.05.18.
 */

public class MemKarten {
    private ArrayList<String> cards;
    private String cardNames[] = {"A", "B", "C", "D", "E", "F"};
    private int countCards;
    private int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0;

    public MemKarten(int countCards) {
        cards = new ArrayList<>();
        this.countCards = countCards;
    }

    public void initializeMemKarten(ArrayList<String> cards) {
        for (int i = 0 ; i < countCards ; i++) {
            String name = cardNames[randomNumberGenerator(0, 5)];
            /* if (isComplete(name) == true) {
                i--;
                continue;
            } */
            cards.add(name);
        }
    }

    public ArrayList<String> getKarten() {
        return cards;
    }

    private boolean isComplete(String name) {
        switch (name) {
            case "A":
                countA++;
                if (countA > 2) return true;
            case "B":
                countB++;
                if (countB > 2) return true;
            case "C":
                countC++;
                if (countC > 2) return true;
            case "D":
                countD++;
                if (countD > 2) return true;
            case "E":
                countE++;
                if (countE > 2) return true;
            case "F":
                countF++;
                if (countF > 2) return true;
        }
        return false;
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
