package com.example.stefansator.brealth;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by stefansator on 25.05.18.
 */

public class BrainDailyMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braindailymenu);
    }

    public void sendNotification(View view) {
        Notifi("Hallo dies ist eine Benachrichtigung");
    }

    public void Notifi(String Nachricht) {
        final Intent notificationIntent = new Intent(BrainDailyMenu.this, BrainDailyMenu.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(BrainDailyMenu.this, 0, notificationIntent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(BrainDailyMenu.this);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        mBuilder.setContentTitle("Brealth");
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setContentText(Nachricht);

        NotificationManager mNotificationManager = (NotificationManager) BrainDailyMenu.this.getSystemService(BrainDailyMenu.this.NOTIFICATION_SERVICE);
        mNotificationManager.notify(666, mBuilder.build());

    }
}
