package com.hack.server.core.transact;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.hack.opensdk.CmdConstants;
import com.hack.server.core.TransactCallback;

/* JADX INFO: loaded from: classes.dex */
public class ProcessBindCallback implements TransactCallback {
    @Override // com.hack.server.core.TransactCallback
    public final Bundle transact(Context context, int i, Bundle bundle) {
        if (i != 1) {
            return null;
        }
        int i2 = bundle.getInt("space");
        onBindProcess(bundle.getString(CmdConstants.TRANSACT_KEY_PROCESS), bundle.getString("pkg"), i2);
        return null;
    }

    protected void onBindProcess(String str, String str2, int i) {
        Log.d("TransactProvider", String.format("agent process bind complete! [space: %d] [pkg: %s] [process: %s]", Integer.valueOf(i), str2, str));
    }
}
