package com.example.stefansator.brealth.uebungen.brain.rechnen;

import com.example.stefansator.brealth.uebungen.GameRater;

/**
 * Created by StefanSator on 29.05.18.
 */

public class RechnenRater implements GameRater {
    private long duration;
    private int attempts;
    private int LIMIT;

    public RechnenRater(long duration, int attempts, int limit) {
        this.duration = duration;
        this.attempts = attempts;
        LIMIT = limit;
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
        if (attempts < 0.05 * LIMIT) {
            if (duration <= 3 * LIMIT) {
                return 5;
            } else if (duration > 3 * LIMIT && duration <= 4 * LIMIT) {
                return 4;
            } else {
                return 3;
            }
        } else if (attempts >= 0.05 * LIMIT && attempts < 0.10 * LIMIT) {
            if (duration <= 3 * LIMIT) {
                return 4;
            } else if (duration > 3 * LIMIT && duration <= 4 * LIMIT) {
                return 3;
            } else {
                return 2;
            }
        } else if (attempts >= 0.10 * LIMIT && attempts < 0.20 * LIMIT) {
            if (duration <= 3 * LIMIT) {
                return 3;
            } else if (duration > 3 * LIMIT && duration <= 4 * LIMIT) {
                return 2;
            } else {
                return 1;
            }
        } else if (attempts >= 0.20 * LIMIT && attempts < 0.30 * LIMIT) {
            if (duration <= 3 * LIMIT) {
                return 2;
            } else if (duration > 3 * LIMIT && duration <= 4 * LIMIT) {
                return 1;
            } else {
                return 0;
            }
        } else if (attempts >= 0.30 * LIMIT && attempts < 0.40 * LIMIT) {
            if (duration <= 3 * LIMIT) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
