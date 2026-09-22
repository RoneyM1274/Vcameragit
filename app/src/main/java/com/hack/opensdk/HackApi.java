package com.hack.opensdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.hack.Slog;
import com.hack.server.core.TransactCallback;
import com.hack.server.core.TransactRegistry;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HackApi {
    private static final String TAG = "HackApi";
    private static final TransactRegistry sTransactRegistry = new TransactRegistry();

    public interface ApplicationCallback {
        void onAttachBaseContext(Application application);

        void onCreate(Application application);

        void onInitAppContext(Object obj, Context context);

        void onInstallProviders(Application application);
    }

    public static void attachBaseContext(Application application, Context context) {
        Cmd.INSTANCE().exec(1, application, context);
    }

    public static void onCreate() {
        Cmd.INSTANCE().exec(2, new Object[0]);
    }

    public static Bundle getPackageSetting(String str, int i, int i2) {
        return (Bundle) Cmd.INSTANCE().exec(25, str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int installPackageFromHost(String str, int i, boolean z) {
        Cmd cmdINSTANCE = Cmd.INSTANCE();
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(z ? CmdConstants.MODE_FORCE_INSTALL : 0);
        return ((Integer) cmdINSTANCE.exec(10, objArr)).intValue();
    }

    public static int uninstallPackage(String str, int i) {
        return ((Integer) Cmd.INSTANCE().exec(11, Integer.valueOf(i), str, 0)).intValue();
    }

    public static int deletePackageData(String str, int i) {
        return ((Integer) Cmd.INSTANCE().exec(13, Integer.valueOf(i), str, 0)).intValue();
    }

    public static int deletePackageCache(String str, int i) {
        return ((Integer) Cmd.INSTANCE().exec(14, Integer.valueOf(i), str, 0)).intValue();
    }

    public static PackageInfo getPackageInfo(String str, int i, int i2) {
        return (PackageInfo) Cmd.INSTANCE().exec(20, Integer.valueOf(i), str, Integer.valueOf(i2));
    }

    public static ResolveInfo resolveIntent(Intent intent, String str, int i, int i2) {
        return (ResolveInfo) Cmd.INSTANCE().exec(21, intent, str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i, int i2) {
        return (List) Cmd.INSTANCE().exec(22, intent, str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static ActivityInfo getActivityInfo(ComponentName componentName, int i, int i2) {
        return (ActivityInfo) Cmd.INSTANCE().exec(23, componentName, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static List<String> getInstalledPackages(int i, int i2) {
        return (List) Cmd.INSTANCE().exec(24, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static Map<String, List<Integer>> getUnavailablePackages(int i) {
        return (Map) Cmd.INSTANCE().exec(27, Integer.valueOf(i), 0);
    }

    public static void registerTransactCallback(int i, TransactCallback transactCallback) {
        sTransactRegistry.registerTransactCallback(i, transactCallback);
    }

    public static void unregisterTransactCallback(int i) {
        sTransactRegistry.unregisterTransactCallback(i);
    }

    @Deprecated
    public static boolean startPackage(String str, int i) {
        return ((Boolean) Cmd.INSTANCE().exec(30, str, Integer.valueOf(i), 0)).booleanValue();
    }

    public static int startActivity(Intent intent, int i) {
        return ((Integer) Cmd.INSTANCE().exec(31, intent, null, Integer.valueOf(i))).intValue();
    }

    public static Object registerDeleteObserver(Object obj) {
        return Integer.valueOf(((Integer) Cmd.INSTANCE().exec(40, obj)).intValue());
    }

    public static void unregisterDeleteObserver(Object obj) {
        Cmd.INSTANCE().exec(41, obj);
    }

    public static Object registerInstallObserver(Object obj) {
        return Integer.valueOf(((Integer) Cmd.INSTANCE().exec(42, obj)).intValue());
    }

    public static void unregisterInstallObserver(Object obj) {
        Cmd.INSTANCE().exec(43, obj);
    }

    public static int[] getAvailableUserSpace() {
        return (int[]) Cmd.INSTANCE().exec(CmdConstants.CMD_GET_ALL_USERID, new Object[0]);
    }

    public static int[] getInstallUsersForPackage(String str) {
        return (int[]) Cmd.INSTANCE().exec(CmdConstants.CMD_PKG_ALL_USERID, str);
    }

    public static int getAvailableUser(String str) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int[] installUsersForPackage = getInstallUsersForPackage(str);
        int i = 0;
        if (installUsersForPackage != null) {
            for (int i2 = 0; i2 < Integer.MAX_VALUE; i2++) {
                int length = installUsersForPackage.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    if (installUsersForPackage[i3] == i2) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    i = i2;
                    break;
                }
            }
        }
        Slog.v(TAG, "getUsers consume: " + ((System.currentTimeMillis() - jCurrentTimeMillis) / 1000));
        return i;
    }

    public static TransactRegistry getTransactRegistry() {
        return sTransactRegistry;
    }

    public static Intent getLaunchIntentForPackage(String str, int i) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = queryIntentActivities(intent, null, 0, i);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            listQueryIntentActivities = queryIntentActivities(intent, null, 0, i);
        }
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            return null;
        }
        Intent intent2 = new Intent(intent);
        intent2.setFlags(268435456);
        intent2.setClassName(listQueryIntentActivities.get(0).activityInfo.packageName, listQueryIntentActivities.get(0).activityInfo.name);
        return intent2;
    }

    public static Map<String, Object> getRuntimeProperties() {
        return (Map) Cmd.INSTANCE().exec(CmdConstants.CMD_GET_RUNTIME_PROPERTIES, new Object[0]);
    }

    public static <T> T getRuntimeProperty(String str, T t) {
        try {
            T t2 = (T) getRuntimeProperties().get(str);
            return t2 == null ? t : t2;
        } catch (Throwable unused) {
            return t;
        }
    }

    public static void registerApplicationCallback(final ApplicationCallback applicationCallback) {
        Cmd.INSTANCE().exec(CmdConstants.CMD_REGISTER_APPLICATION_CALLBACK, new InvocationHandler() { // from class: com.hack.opensdk.HackApi.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                int iIntValue = ((Integer) objArr[0]).intValue();
                if (iIntValue == 0) {
                    applicationCallback.onInitAppContext(objArr[1], (Context) objArr[2]);
                    return null;
                }
                if (iIntValue == 1) {
                    applicationCallback.onAttachBaseContext((Application) objArr[1]);
                    return null;
                }
                if (iIntValue == 2) {
                    applicationCallback.onInstallProviders((Application) objArr[1]);
                    return null;
                }
                if (iIntValue != 3) {
                    return null;
                }
                applicationCallback.onCreate((Application) objArr[1]);
                return null;
            }
        });
    }
}
