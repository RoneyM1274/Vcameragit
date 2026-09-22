package com.hack.server.core.transact;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.hack.opensdk.HackApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TransactActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final TransactActivityLifecycle INSTANCE = new TransactActivityLifecycle();
    private static final String TAG = "TransactActivityLifecycle";
    private boolean mHasCall = false;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.isTaskRoot()) {
            fixTaskDescription(activity);
        }
        if (this.mHasCall) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("virtual.camera.camera.ʽ").getDeclaredMethod("ʼ", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
            Log.e("11111", "done...");
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                Log.e("11111", "exception:" + th);
            } finally {
                this.mHasCall = true;
            }
        }
    }

    private boolean fixTaskDescription(Activity activity) {
        Bitmap bitmap;
        int iIntValue = ((Integer) HackApi.getRuntimeProperty("space", 0)).intValue();
        ActivityInfo activityInfo = HackApi.getActivityInfo(new ComponentName(activity.getPackageName(), activity.getClass().getName()), 0, iIntValue);
        if (activityInfo == null) {
            Log.e(TAG, "fixTaskDescription: fail");
            return false;
        }
        PackageManager packageManager = activity.getPackageManager();
        Drawable drawableLoadIcon = activityInfo.loadIcon(packageManager);
        String strValueOf = String.valueOf(activityInfo.loadLabel(packageManager));
        if (iIntValue != 0) {
            strValueOf = strValueOf + "(" + (iIntValue + 1) + ")";
        }
        if (drawableLoadIcon instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawableLoadIcon).getBitmap();
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableLoadIcon.getIntrinsicWidth(), drawableLoadIcon.getIntrinsicHeight(), drawableLoadIcon.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableLoadIcon.setBounds(0, 0, drawableLoadIcon.getIntrinsicWidth(), drawableLoadIcon.getIntrinsicHeight());
            drawableLoadIcon.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        activity.setTaskDescription(new ActivityManager.TaskDescription(strValueOf, bitmap));
        return true;
    }
}
