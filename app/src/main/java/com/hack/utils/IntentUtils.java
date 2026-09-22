package com.hack.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class IntentUtils {
    public static String getPackage(Intent intent) {
        if (intent == null) {
            return null;
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            return component.getPackageName();
        }
        return intent.getPackage();
    }

    public static boolean isSysLauncherHome(Intent intent) {
        return intent != null && intent.getAction() != null && TextUtils.equals(intent.getAction(), "android.intent.action.MAIN") && intent.hasCategory("android.intent.category.HOME");
    }

    public static String toShortString(Intent intent) {
        if (intent == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (intent.getExtras() != null) {
            sb.append(toShortString(intent.getExtras()));
        }
        return sb.toString();
    }

    public static String toShortString(Bundle bundle) {
        ArrayMap arrayMap;
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(IntentUtils.class.getClassLoader());
        bundle.containsKey("test");
        if (bundle == null || !(bundle instanceof BaseBundle) || (arrayMap = (ArrayMap) new RefUtils.FieldRef(BaseBundle.class, false, "mMap").get(bundle)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{<- ");
        for (Map.Entry entry : arrayMap.entrySet()) {
            sb.append("[" + ((String) entry.getKey()));
            sb.append(":");
            Object value = entry.getValue();
            if (value instanceof Bundle) {
                sb.append(toShortString((Bundle) value));
            } else if (value instanceof Intent) {
                sb.append(toShortString((Intent) value));
            } else {
                sb.append(value);
            }
            sb.append("]");
        }
        sb.append(" ->}");
        return sb.toString();
    }
}
