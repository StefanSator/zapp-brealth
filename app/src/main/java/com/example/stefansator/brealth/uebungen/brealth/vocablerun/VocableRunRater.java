package com.example.stefansator.brealth.uebungen.brealth.vocablerun;

import com.example.stefansator.brealth.uebungen.GameRater;

/**
 * Created by StefanSator on 17.06.18.
 */

public class VocableRunRater implements GameRater {
    private long duration;
    private int attempts;

    public VocableRunRater(int falseCounter) {
        attempts = falseCounter;
        duration = 0;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void setDuration(long duration) {
        this.duration = 0;
    }

    @Override
    public int getAttempts() {
        return attempts;
    }

    @Override
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public int getRating() {
        if (attempts <= 1) {
            return 5;
        } else if (attempts <= 3) {
            return 4;
        } else if (attempts <= 5) {
            return 3;
        } else if (attempts <= 7) {
            return 2;
        } else if (attempts <= 10) {
            return 1;
        } else {
            return 0;
        }
    }
}
