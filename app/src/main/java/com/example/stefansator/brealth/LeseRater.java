package com.example.stefansator.brealth;

/**
 * Created by StefanSator on 29.05.18.
 */

public class LeseRater implements GameRater {
    private long duration;
    private int attempts;

    public LeseRater(long duration) {
        this.duration = duration;
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
        if (duration < 390) {
            return 5;
        } else if (duration >= 390 && duration < 450) {
            return 4;
        } else if (duration >= 450 && duration < 480) {
            return 3;
        } else if (duration >= 480 && duration < 510) {
            return 2;
        } else if (duration >= 510 && duration < 540) {
            return 1;
        } else {
            return 0;
        }
    }
}
