package com.example.stefansator.brealth;

/**
 * Created by StefanSator on 07.06.18.
 */

public class YogaMemoryRater implements GameRater {
    private long duration;
    private int attempts;

    public YogaMemoryRater(long duration, int attempts) {
        this.duration = duration;
        this.attempts = attempts;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void setDuration(long duration) {
        this.duration = duration;
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
        int numberOfYogaTasks = 6;
        int durationForYogaTasks = numberOfYogaTasks * 240; // 240s (4min) per Yoga Task

        if (attempts < 3) {
            if (duration <= 15 + durationForYogaTasks) {
                return 5;
            } else if (duration > 15 + durationForYogaTasks && duration <= 25 + durationForYogaTasks) {
                return 4;
            } else {
                return 3;
            }
        } else if (attempts >= 3 && attempts < 6) {
            if (duration <= 15 + durationForYogaTasks) {
                return 4;
            } else if (duration > 15 + durationForYogaTasks && duration <= 25 + durationForYogaTasks) {
                return 3;
            } else {
                return 2;
            }
        } else if (attempts >= 6 && attempts < 8) {
            if (duration <= 15 + durationForYogaTasks) {
                return 3;
            } else if (duration > 15 + durationForYogaTasks && duration <= 25 + durationForYogaTasks) {
                return 2;
            } else {
                return 1;
            }
        } else if (attempts >= 8 && attempts < 10) {
            if (duration <= 15 + durationForYogaTasks) {
                return 2;
            } else if (duration > 15 + durationForYogaTasks && duration <= 25 + durationForYogaTasks) {
                return 1;
            } else {
                return 0;
            }
        } else if (attempts >= 10 && attempts < 12) {
            if (duration <= 15 + durationForYogaTasks) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
