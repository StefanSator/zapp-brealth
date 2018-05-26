package com.example.stefansator.brealth;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by StefanSator on 25.05.18.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, BrainDailyMenu.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context);
        mNotifyBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        if (intent.hasExtra("title") == true) {
            mNotifyBuilder.setContentTitle(intent.getExtras().getString("title"));
        } else {
            mNotifyBuilder.setContentTitle("Default");
        }
        if (intent.hasExtra("text") == true) {
            mNotifyBuilder.setContentText(intent.getExtras().getString("text"));
        } else {
            mNotifyBuilder.setContentText("Default Text");
        }
        mNotifyBuilder.setAutoCancel(true).setWhen(when);
        mNotifyBuilder.setContentIntent(pendingIntent);
        mNotifyBuilder.setVibrate(new long[]{1000, 1000, 1000, 1000});

        notificationManager.notify(0, mNotifyBuilder.build());
    }
}
