package com.example.stefansator.brealth.uebungen;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by StefanSator on 22.06.18.
 */

public class TestScore {
    protected final static int DEFAULT = 0;
    int attempts = 0;
    long duration = 0;

    public int readTestAttempts(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return attempts = sharedPreferences.getInt(key,DEFAULT);
    }

    public void writeTestAttempts(Context context, String fileName,String key , int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public long readTestDuration(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return duration = sharedPreferences.getLong(key,DEFAULT);
    }

    public void writeTestDuration(Context context, String fileName, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }
}
