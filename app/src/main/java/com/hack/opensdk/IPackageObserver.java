package com.hack.opensdk;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class IPackageObserver {

    public interface Delete {
        void onPackageDeleted(String str, int i, String str2, int i2);
    }

    public interface Install {
        void onPackageInstalled(String str, int i, String str2, Bundle bundle, int i2);
    }
}
