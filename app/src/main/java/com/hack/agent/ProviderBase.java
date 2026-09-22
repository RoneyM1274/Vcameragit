package com.hack.agent;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import com.hack.opensdk.Cmd;
import com.hack.opensdk.HackRuntime;
import com.hack.server.core.transact.TransactActivityLifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProviderBase extends AppAgentFileProvider {
    private static final boolean DEBUG = false;
    private static final String TAG = "ProviderBase";

    public abstract int getProviderCallType();

    @Override // com.hack.agent.BaseAgentFileProvider, android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(TransactActivityLifecycle.INSTANCE);
        HackRuntime.attachProviderInfo(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return (Bundle) Cmd.INSTANCE().exec(getProviderCallType(), str, str2, bundle);
    }
}
