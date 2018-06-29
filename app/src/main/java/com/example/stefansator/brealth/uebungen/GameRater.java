package com.example.stefansator.brealth.uebungen;

/**
 * Created by StefanSator on 29.05.18.
 */

public interface GameRater {
    public long getDuration();
    public void setDuration(long duration);
    public int getAttempts();
    public void setAttempts(int attempts);
    public int getRating();
}
