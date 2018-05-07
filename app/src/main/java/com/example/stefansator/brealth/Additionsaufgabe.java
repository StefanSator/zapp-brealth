package com.example.stefansator.brealth;

import java.util.Random;

/**
 * Created by stefansator on 07.05.18.
 */

public class Additionsaufgabe {
    private int max, min, erg, x1, x2;

    public Additionsaufgabe(int limit) {
        max = limit / 2;
        min = 1;
        x1 = randomNumberGenerator(min, max); System.out.println(x1);
        x2 = randomNumberGenerator(min, max); System.out.println(x2);
    }

    public void setX1(int min, int max) {
        x1 = randomNumberGenerator(min, max);
    }

    public void setX2(int min, int max) {
        x2 = randomNumberGenerator(min, max);
    }

    public int getErgebnis() {
        return x1 + x2;
    }

    public int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public String toString() {
        return "" + x1 + " + " + x2 + " =";
    }
}
