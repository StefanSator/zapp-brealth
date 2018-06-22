package com.example.stefansator.brealth;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

/**
 * Created by StefanSator on 22.06.18.
 */

public class TestScore {
    private Context context;
    private String task;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public TestScore(Context context, String task) {
        this.context = context;
        this.task = task;

        initializeSharedPreferences();
    }

    private void initializeSharedPreferences() {
        sharedPref = context.getSharedPreferences(task, Context.MODE_PRIVATE);
    }

    public void save(long duration, int attempts) {
        editor = sharedPref.edit();
        editor.putLong("TEST_DURATION_" + task, duration);
        editor.putInt("TEST_ATTEMPTS_" + task, attempts);
    }

    public void resetPreferences() {
        save(0, 0);
    }

    public long loadDuration() {
        return sharedPref.getLong("TEST_DURATION_" + task, 0L);
    }

    public int loadAttempts() {
        return sharedPref.getInt("TEST_ATTEMPTS_" + task, 0);
    }
}
