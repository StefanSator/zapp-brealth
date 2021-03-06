package com.example.stefansator.brealth.uebungen.brain.logik;

import com.example.stefansator.brealth.uebungen.GameRater;

public class LogikRater implements GameRater {

    private long duration;
    private int attempts;

    public LogikRater(long duration, int attempts) {
        this.duration = duration;
        this.attempts = attempts;
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
        this.attempts = attempts;
    }

    public int getRating() {
        if (attempts < 3) {
            if (duration <= 30) {
                return 5;
            } else if (duration > 45 && duration <= 60) {
                return 4;
            } else {
                return 3;
            }
        } else if (attempts >= 3 && attempts < 6) {
            if (duration <= 30) {
                return 4;
            } else if (duration > 45 && duration <= 60) {
                return 3;
            } else {
                return 2;
            }
        } else if (attempts >= 6 && attempts < 8) {
            if (duration <= 30) {
                return 3;
            } else if (duration > 45 && duration <=60) {
                return 2;
            } else {
                return 1;
            }
        } else if (attempts >= 8 && attempts < 10) {
            if (duration <= 30) {
                return 2;
            } else if (duration > 45 && duration <= 60) {
                return 1;
            } else {
                return 0;
            }
        } else if (attempts >= 10 && attempts < 12) {
            if (duration <= 15) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

}
