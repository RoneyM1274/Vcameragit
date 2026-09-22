package com.hack.server.core.transact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.hack.opensdk.CmdConstants;
import com.hack.server.core.TransactCallback;
import com.hack.utils.IntentUtils;
import com.hack.utils.ThreadUtils;

/* JADX INFO: loaded from: classes.dex */
public class OuterActivityMonitor implements TransactCallback {
    @Override // com.hack.server.core.TransactCallback
    public Bundle transact(Context context, int i, Bundle bundle) {
        String string = bundle.getString("pkg");
        String string2 = bundle.getString(CmdConstants.TRANSACT_KEY_SHELL_PKG);
        Intent intent = (Intent) bundle.getParcelable(CmdConstants.TRANSACT_KEY_INTENT);
        Log.d("TransactProvider", String.format("target intent not found! [caller: %s-%s] [fromToken: %s] [intent: %s]", string, string2, bundle.getBinder(CmdConstants.TRANSACT_KEY_FROM_TOKEN), intent));
        Integer numStartActivity = startActivity(context, intent);
        if (numStartActivity == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(CmdConstants.TRANSACT_KEY_RESULT, numStartActivity.intValue());
        return bundle2;
    }

    public Integer startActivity(final Context context, final Intent intent) {
        if (!IntentUtils.isSysLauncherHome(intent)) {
            return null;
        }
        ThreadUtils.postOnMainThread(new Runnable() { // from class: com.hack.server.core.transact.OuterActivityMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                context.startActivity(intent);
            }
        });
        return 0;
    }
}
