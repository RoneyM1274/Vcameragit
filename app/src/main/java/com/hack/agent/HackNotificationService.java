package com.hack.agent;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.Intent;
import android.os.IBinder;
import android.os.UserHandle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/* JADX INFO: loaded from: classes.dex */
public class HackNotificationService extends NotificationListenerService {
    private static final boolean DEBUG = false;
    private static final String TAG = "HackNotificationService";

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        super.onNotificationPosted(statusBarNotification);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification, NotificationListenerService.RankingMap rankingMap) {
        super.onNotificationPosted(statusBarNotification, rankingMap);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        super.onNotificationRemoved(statusBarNotification);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification, NotificationListenerService.RankingMap rankingMap) {
        super.onNotificationRemoved(statusBarNotification, rankingMap);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification, NotificationListenerService.RankingMap rankingMap, int i) {
        super.onNotificationRemoved(statusBarNotification, rankingMap, i);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRankingUpdate(NotificationListenerService.RankingMap rankingMap) {
        super.onNotificationRankingUpdate(rankingMap);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerHintsChanged(int i) {
        super.onListenerHintsChanged(i);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onSilentStatusBarIconsVisibilityChanged(boolean z) {
        super.onSilentStatusBarIconsVisibilityChanged(z);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationChannelModified(String str, UserHandle userHandle, NotificationChannel notificationChannel, int i) {
        super.onNotificationChannelModified(str, userHandle, notificationChannel, i);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationChannelGroupModified(String str, UserHandle userHandle, NotificationChannelGroup notificationChannelGroup, int i) {
        super.onNotificationChannelGroupModified(str, userHandle, notificationChannelGroup, i);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onInterruptionFilterChanged(int i) {
        super.onInterruptionFilterChanged(i);
    }

    @Override // android.service.notification.NotificationListenerService
    public StatusBarNotification[] getActiveNotifications() {
        return super.getActiveNotifications();
    }

    @Override // android.service.notification.NotificationListenerService
    public StatusBarNotification[] getActiveNotifications(String[] strArr) {
        return super.getActiveNotifications(strArr);
    }

    @Override // android.service.notification.NotificationListenerService
    public NotificationListenerService.RankingMap getCurrentRanking() {
        return super.getCurrentRanking();
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
