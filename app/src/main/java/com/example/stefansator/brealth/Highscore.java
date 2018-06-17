package com.example.stefansator.brealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Highscore {
    private int rating;
    private long duration;
    private String task;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    public Highscore(Context context,long duration, int rating, String task) {
        this.rating = rating;
        this.duration = duration;
        this.task = task;
        this.preferences = context.getSharedPreferences(task,Context.MODE_PRIVATE);
    }

    public boolean isNewHighscore() {
        preferencesEditor = preferences.edit();

        if (preferences.getInt(task+"rating",0) <= rating){
            if (preferences.getLong(task+"duration", Long.MAX_VALUE) > duration) {
                Log.d("TESTT","highscore ist "+rating+" "+duration);
                preferencesEditor.putInt(task+"rating", rating);
                preferencesEditor.putLong(task+"duration",duration);
                preferencesEditor.apply();
                return true;
            }
        }
        return false;
    }

    public void deleteHighscore(boolean wipe){
        if (wipe == true) {
            preferencesEditor.clear();
            preferencesEditor.apply();
        }
    }
}
