package com.hack.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ThreadUtils {
    public static final int ASYNC_MAX_THREAD = 4;
    private static Thread sMainThread = Looper.getMainLooper().getThread();
    private static Handler sMainThreadHandler = new Handler(Looper.getMainLooper());
    private static volatile ThreadPoolExecutor sThreadExecutor;

    public static boolean isMainThread() {
        return Thread.currentThread() == sMainThread;
    }

    public static Handler getUiThreadHandler() {
        return sMainThreadHandler;
    }

    public static void ensureMainThread() {
        if (!isMainThread()) {
            throw new RuntimeException("Must be called on the UI thread");
        }
    }

    public static Future postOnBackgroundThread(Runnable runnable) {
        return getThreadExecutor().submit(runnable);
    }

    public static Future postOnBackgroundThread(Callable callable) {
        return getThreadExecutor().submit(callable);
    }

    public static void postOnMainThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    private static ExecutorService getThreadExecutor() {
        if (sThreadExecutor == null) {
            synchronized (ThreadUtils.class) {
                if (sThreadExecutor == null) {
                    int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
                    int i = iAvailableProcessors > 4 ? 4 : iAvailableProcessors;
                    sThreadExecutor = new ThreadPoolExecutor(i, i, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    sThreadExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return sThreadExecutor;
    }
}
