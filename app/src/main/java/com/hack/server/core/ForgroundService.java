package com.hack.server.core;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.hack.opensdk.R;

/* JADX INFO: loaded from: classes.dex */
public class ForgroundService extends Service {
    private static final String FORGROUND_CHANNEL_ID = "hack_forground_id";
    private static final String FORGROUND_CHANNEL_NAME = "hack_forground_channel";
    private static final int FORGROUND_NOTIFICATION_ID = 1000000;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForgroundNotification(getApplicationContext());
    }

    private void startForgroundNotification(Context context) {
        Notification notificationBuild;
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(new NotificationChannel(FORGROUND_CHANNEL_ID, FORGROUND_CHANNEL_NAME, 3));
        }
        if (Build.VERSION.SDK_INT < 27) {
            notificationBuild = new Notification();
        } else {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
            String strValueOf = String.valueOf(getApplicationInfo().loadLabel(getPackageManager()));
            notificationBuild = new Notification.Builder(this, FORGROUND_CHANNEL_ID).setContentTitle(getString(R.string.notification_running_title, new Object[]{strValueOf})).setContentText(getString(R.string.notification_running_warn, new Object[]{strValueOf})).setContentIntent(activity).setAutoCancel(false).build();
        }
        startForeground(1000000, notificationBuild);
    }
}
