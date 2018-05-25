package com.example.stefansator.brealth;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

/**
 * Created by stefansator on 25.05.18.
 */

public class BrainDailyMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braindailymenu);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 0);
        Intent notiIntent = new Intent(BrainDailyMenu.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(BrainDailyMenu.this, 0, notiIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) BrainDailyMenu.this.getSystemService(BrainDailyMenu.this.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

    }
}
