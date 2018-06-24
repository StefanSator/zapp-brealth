package com.example.stefansator.brealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Highscore {
    private int rating;
    private int falseAnswer;
    private long duration;
    private String task;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    public Highscore(Context context, String task, boolean wipe) {
        this.task = task;;
        this.preferences = context.getSharedPreferences(task,Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        if(wipe == true) {
            preferencesEditor.clear();
            preferencesEditor.apply();
        }
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setFalseAnswer(int falseAnswer) {
        this.falseAnswer = falseAnswer;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isNewHighscore() {
        preferencesEditor = preferences.edit();

        if (preferences.getInt(task+"rating",0) <= rating) {
            if (preferences.getInt(task + "falseAnswer",Integer.MAX_VALUE) >= falseAnswer) {
                if (preferences.getLong(task + "duration", Long.MAX_VALUE) > duration) {
                    preferencesEditor.putInt(task + "rating", rating);
                    preferencesEditor.putLong(task + "duration", duration);
                    preferencesEditor.apply();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNewHighscoreLesen() {
        preferencesEditor = preferences.edit();

        if (preferences.getInt(task+"rating",0) <= rating){
            if (preferences.getLong(task+"duration", Long.MIN_VALUE) < duration) {
                preferencesEditor.putInt(task+"rating", rating);
                preferencesEditor.putLong(task+"duration",duration);
                preferencesEditor.apply();
                return true;
            }
        }
        return false;
    }

}
