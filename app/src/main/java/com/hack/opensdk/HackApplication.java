package com.hack.opensdk;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class HackApplication extends Application {
    private static final boolean DEBUG = false;
    private static final String TAG = "HackApplication";

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        HackRuntime.install(this, "version", true);
        Cmd.INSTANCE().exec(1, this, context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Cmd.INSTANCE().exec(2, new Object[0]);
    }
}
