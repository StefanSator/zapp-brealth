package com.example.stefansator.brealth.uebungen.brain.lesen;

import com.example.stefansator.brealth.uebungen.GameRater;

/**
 * Created by StefanSator on 29.05.18.
 */

public class LeseRater implements GameRater {
    private long duration;
    private int attempts;
    private String difficulty;

    public LeseRater(long duration, String difficulty) {
        this.duration = duration;
        this.difficulty = difficulty;
        attempts = 1;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        attempts = 1;
    }

    public int getRating() {
        /* Set Perfect Duration dependent on difficulty */
        int perfectDuration;
        if (difficulty.equals("leicht")) {
            perfectDuration = 400; // Zahl 400 durch praktische Tests im Schwierigkeitsgrad Leicht ermittelt
        } else if (difficulty.equals("normal")) {
            perfectDuration = (int) (0.75 * 400); // Normal ist 1.3 mal schneller als leicht
        } else {
            perfectDuration = (int) (0.45 * 400); // Schwer ist 2.17 mal schneller als leicht
        }

        if (duration >= perfectDuration) {
            return 5;
        } else if (duration >= 0.75 * perfectDuration) {
            return 4;
        } else if (duration >= 0.50 * perfectDuration) {
            return 3;
        } else if (duration >= 0.25 * perfectDuration) {
            return 2;
        } else if (duration >= 0.10 * perfectDuration) {
            return 1;
        } else {
            return 0;
        }
    }
}
