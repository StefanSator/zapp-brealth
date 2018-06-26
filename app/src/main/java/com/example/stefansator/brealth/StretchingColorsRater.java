package com.example.stefansator.brealth;

public class StretchingColorsRater implements GameRater {
    private long duration;
    private int attempts;

    public StretchingColorsRater (int falseCounter) {
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
        if (attempts <= 3) {
            return 5;
        } else if (attempts <= 5) {
            return 4;
        } else if (attempts <= 7) {
            return 3;
        } else if (attempts <= 9) {
            return 2;
        } else if (attempts <= 11) {
            return 1;
        } else {
            return 0;
        }
    }
}
