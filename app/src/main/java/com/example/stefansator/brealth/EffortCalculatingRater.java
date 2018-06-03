package com.example.stefansator.brealth;

/**
 * Created by StefanSator on 31.05.18.
 */

public class EffortCalculatingRater implements GameRater {
    private long duration;
    private int attempts;
    private int LIMIT;
    private int sportTasksPerUnit;

    public EffortCalculatingRater(long duration, int attempts, int limit, int cnt) {
        this.duration = duration;
        this.attempts = attempts;
        LIMIT = limit;
        sportTasksPerUnit = cnt;
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
        int sportUnits = ((LIMIT / 5) - 1);
        int sportTasks = sportUnits * sportTasksPerUnit; // Anzahl Sportaufgaben
        int calculatingTasks = LIMIT - sportTasks; // Anzahl Rechenaufgaben
        int perfectDuration = 3 * calculatingTasks + 4 * sportTasks;
        int normalDuration = 4 * calculatingTasks + 5 * sportTasks;

        if (attempts < 0.05 * LIMIT) {
            if (duration <= perfectDuration) {
                return 5;
            } else if (duration > perfectDuration && duration <= normalDuration) {
                return 4;
            } else {
                return 3;
            }
        } else if (attempts >= 0.05 * LIMIT && attempts < 0.10 * LIMIT) {
            if (duration <= perfectDuration) {
                return 4;
            } else if (duration > perfectDuration && duration <= normalDuration) {
                return 3;
            } else {
                return 2;
            }
        } else if (attempts >= 0.10 * LIMIT && attempts < 0.20 * LIMIT) {
            if (duration <= perfectDuration) {
                return 3;
            } else if (duration > perfectDuration && duration <= normalDuration) {
                return 2;
            } else {
                return 1;
            }
        } else if (attempts >= 0.20 * LIMIT && attempts < 0.30 * LIMIT) {
            if (duration <= perfectDuration) {
                return 2;
            } else if (duration > perfectDuration && duration <= normalDuration) {
                return 1;
            } else {
                return 0;
            }
        } else if (attempts >= 0.30 * LIMIT && attempts < 0.40 * LIMIT) {
            if (duration <= perfectDuration) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
