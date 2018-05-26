package com.example.stefansator.brealth;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by stefansator on 25.05.18.
 */

public class BrainDailyMenu extends AppCompatActivity {
    private SharedPreferences sharedPref;
    private int dailyTask;
    private Calendar previousDate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braindailymenu);

        initializeSharedPreferences();
        loadPreferences();
        setupDailyNotification();
    }

    public void startDailyTask(View view) {
        setupDailyTask();
    }

    private void setupDailyTask() {
        Calendar currentDate = Calendar.getInstance();

        /* If user comes in on another day he gets a new Task, while if he comes in on
         * the same day he gets always the same Task.
         */
        if (!isSameDay(currentDate, previousDate)) {
            dailyTask = randomNumberGenerator(0, 4);
        }

        savePreferences();

        switch (dailyTask) {
            case 0:
                Intent rechnenIntent = new Intent(BrainDailyMenu.this, RechnenTask.class);
                rechnenIntent.putExtra("limit", 5);
                BrainDailyMenu.this.startActivity(rechnenIntent);
                break;
            case 1:
                Intent lesenIntent = new Intent(BrainDailyMenu.this, LesenTask.class);
                BrainDailyMenu.this.startActivity(lesenIntent);
                break;
            case 2:
                Intent memoryIntent = new Intent(BrainDailyMenu.this, MemoryTask.class);
                BrainDailyMenu.this.startActivity(memoryIntent);
                break;
            case 3:
                Intent easyFarbenIntent = new Intent(BrainDailyMenu.this, FarbenEasyMode.class);
                BrainDailyMenu.this.startActivity(easyFarbenIntent);
                break;
            case 4:
                Intent hardFarbenIntent = new Intent(BrainDailyMenu.this, FarbenHardMode.class);
                BrainDailyMenu.this.startActivity(hardFarbenIntent);
                break;
            default:
                // do nothing
        }
    }

    public boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null)
            return false;
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private void setupDailyNotification() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        Intent notiIntent = new Intent(BrainDailyMenu.this, AlarmReceiver.class);
        notiIntent.putExtra("title", "Tägliche Aufgabe");
        notiIntent.putExtra("text", "Sie haben eine neue tägliche Aufgabe.");
        PendingIntent pendingIntent = PendingIntent
                .getBroadcast(BrainDailyMenu.this, 0, notiIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) BrainDailyMenu.this
                .getSystemService(BrainDailyMenu.this.ALARM_SERVICE);
        alarmManager
                .setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void initializeSharedPreferences() {
        sharedPref = BrainDailyMenu.this.getPreferences(Context.MODE_PRIVATE);
    }

    private void loadPreferences() {
        dailyTask = sharedPref.getInt("THE_DAILY_TASK", 0);
        long millis = sharedPref.getLong("THE_DATE", 0L);
        previousDate = Calendar.getInstance();
        previousDate.setTimeInMillis(millis);
    }

    private void savePreferences() {
        Calendar currentDate = Calendar.getInstance();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("THE_DATE", currentDate.getTimeInMillis());
        editor.putInt("THE_DAILY_TASK", dailyTask);
        editor.commit();
    }
}
