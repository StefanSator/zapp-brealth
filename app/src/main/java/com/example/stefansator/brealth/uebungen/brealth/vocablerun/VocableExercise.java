package com.example.stefansator.brealth.uebungen.brealth.vocablerun;


import java.util.Random;

/**
 * Created by StefanSator on 17.06.18.
 */

public class VocableExercise {
    private String task;
    private String chosenVocable; // ausgesuchte Vokabel
    private String vocables[]; // Katalog mit allen verfügbaren Vokabeln

    public VocableExercise(String[] vocableCatalog) {
        setVocables(vocableCatalog);
        setRandomTask();
        setRandomVocable();
    }

    public void setVocables(String[] vocableCatalog) {
        this.vocables = vocableCatalog;
    }

    public String[] getVocables() {
        return vocables;
    }

    public void setTask(String task) {
        if (task.equals("Rückwärts") || task.equals("5 Wörter, 1 Buchstabe") || task.equals("Kopfüber")) {
            this.task = task;
        }
    }

    public void setRandomTask() {
        int tasknr = randomNumberGenerator(0, 2);
        switch (tasknr) {
            case 0:
                task = "Rückwärts";
                break;
            case 1:
                task = "5 Wörter, 1 Buchstabe";
                break;
            default:
                task = "Kopfüber";
        }
    }

    public String getTask() {
        return task;
    }

    public void setRandomVocable() {
        if (task.equals("5 Wörter, 1 Buchstabe")) {
            setRandomLetter();
            return;
        }

        chosenVocable = vocables[randomNumberGenerator(0, 49)];
    }

    private void setRandomLetter() {
        /* ASCII Code for A to Z */
        chosenVocable = "" + (char) randomNumberGenerator(65, 90);
    }

    public String getChosenVocable() {
        return chosenVocable;
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
