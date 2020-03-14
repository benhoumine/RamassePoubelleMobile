package com.example.greenpp.Notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.greenpp.R;

import static com.example.greenpp.Notification.App.CHANNEL_ID;

public class BuildNotification {
    public static final String NOTIFICATION_TITLE = "Watering Process";
    public static String NOTIFICATION_DESCRIPTION = "";

    private NotificationManagerCompat notificationManager;
    private Context context;
    private Class aClass;

    /**
     *
     * @param notificationManager : to show the notification user .notify()
     * @param context : for use in intent
     * @param aClass  : for use in intent
     */
    public BuildNotification(NotificationManagerCompat notificationManager, Context context, Class aClass) {
        this.notificationManager = notificationManager;
        this.context = context;
        this.aClass = aClass;
    }

    /**
     * Function to create a notification and put it in the channel created in App.java
     */
    public void displayNotification() {
        Intent intent = new Intent(context, aClass);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(NOTIFICATION_TITLE)
                .setContentText(NOTIFICATION_DESCRIPTION)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(1, notification);
    }

}
