package com.hack.server.core;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class TransactRegistry implements TransactCallback {
    private final SparseArray<TransactCallback> transactCallbacks = new SparseArray<>();

    public final void registerTransactCallback(int i, TransactCallback transactCallback) {
        synchronized (this.transactCallbacks) {
            this.transactCallbacks.put(i, transactCallback);
        }
    }

    public final void unregisterTransactCallback(int i) {
        synchronized (this.transactCallbacks) {
            this.transactCallbacks.remove(i);
        }
    }

    @Override // com.hack.server.core.TransactCallback
    public Bundle transact(Context context, int i, Bundle bundle) {
        TransactCallback transactCallback;
        synchronized (this.transactCallbacks) {
            transactCallback = this.transactCallbacks.get(i);
        }
        if (transactCallback != null) {
            return transactCallback.transact(context, i, bundle);
        }
        return null;
    }
}
