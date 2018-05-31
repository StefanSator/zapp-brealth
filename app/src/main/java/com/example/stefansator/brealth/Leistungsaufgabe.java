package com.example.stefansator.brealth;

import java.util.Random;

/**
 * Created by StefanSator on 31.05.18.
 */

public class Leistungsaufgabe {
    private int exerciseNr;
    private String exercise;
    private int count;

    public Leistungsaufgabe(int count) {
        exerciseNr = randomNumberGenerator(0, 2);
        setExercise(exerciseNr);
        this.count = count;
    }

    public void setExerciseNr(int Nr) {
        exerciseNr = Nr;
    }

    public int getExerciseNr() {
        return exerciseNr;
    }

    public void setExercise(int Nr) {
        switch (Nr) {
            case 0:
                exercise = "Liegestützen";
                break;
            case 1:
                exercise = "Sit Ups";
                break;
            case 2:
                exercise = "Kniebeugen";
                break;
            default:
                exercise = "Liegestützen";
        }
    }

    public String getExercise() {
        return exercise;
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public String toString() {
        return "Machen Sie " + count + " " + exercise;
    }
}
