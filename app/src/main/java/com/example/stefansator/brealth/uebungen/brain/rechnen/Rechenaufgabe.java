package com.example.stefansator.brealth.uebungen.brain.rechnen;

import java.util.Random;

import static java.lang.System.exit;

/**
 * Created by stefansator on 07.05.18.
 */

public class Rechenaufgabe {
    private int max, min, erg, x1, x2, op;
    private static final int ERROR = -9999;

    public Rechenaufgabe() {
        op = randomNumberGenerator(0, 2);
        min = 1;
        max = 10;
        x1 = randomNumberGenerator(min, max);
        // System.out.println(x1);
        x2 = randomNumberGenerator(min, max);
        // System.out.println(x2);
    }

    public void setX1(int min, int max) {
        x1 = randomNumberGenerator(min, max);
    }

    public void setX2(int min, int max) {
        x2 = randomNumberGenerator(min, max);
    }

    public int getErgebnis() {
        switch (op) {
            case 0:
                return x1 + x2;
            case 1:
                return x1 - x2;
            case 2:
                return x1 * x2;
        }
        System.out.println("Fehler in Klasse Rechenaufgabe: Methode getErgebnis()");
        return ERROR;
    }

    public int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public String toString() {
        switch (op) {
            case 0:
                return "" + x1 + " + " + x2 + " =";
            case 1:
                return "" + x1 + " - " + x2 + " =";
            case 2:
                return "" + x1 + " * " + x2 + " =";
        }
        System.out.println("Fehler in Klasse Rechenaufgabe: Methode toString()");
        return "Error";
    }
}
