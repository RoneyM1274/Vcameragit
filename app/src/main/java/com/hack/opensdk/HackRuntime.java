package com.hack.opensdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.hack.Slog;
import com.hack.utils.FileUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HackRuntime {
    private static final String ENGINE_JAR_DIR = ".plugin";
    private static final String ENGINE_JAR_NAME = "hack.jar";
    private static DexClassLoader hackClassLoader;
    private static ProviderInfo providerInfo;

    public static void attachProviderInfo(ProviderInfo providerInfo2) {
        providerInfo = providerInfo2;
    }

    public static boolean isHackProcess() {
        return providerInfo != null;
    }

    public static ProviderInfo getHackProvider() {
        return providerInfo;
    }

    public static void install(Application application, String str, boolean z) {
        if (hackClassLoader != null) {
            return;
        }
        File file = new File(application.getFilesDir(), ENGINE_JAR_DIR);
        File file2 = new File(file, str + ".json");
        JSONObject json = readJson(file2);
        String strOptString = json.optString("current");
        File file3 = TextUtils.isEmpty(strOptString) ? null : new File(strOptString);
        if (z || TextUtils.isEmpty(strOptString)) {
            if (!z) {
                Slog.e(HackRuntime.class.getName(), "engine load fail");
            }
            long jOptLong = json.optLong("time");
            long jLastModified = new File(application.getPackageCodePath()).lastModified();
            if (jOptLong != jLastModified) {
                if (file3 == null) {
                    file3 = new File(file, str + "-1");
                } else {
                    if (strOptString.endsWith("-1")) {
                        file3 = new File(file, str + "-2");
                    } else {
                        file3 = new File(file, str + "-1");
                    }
                    FileUtils.deleteQuietly(new File(strOptString));
                }
                File file4 = new File(file3, "base.apk");
                try {
                    FileUtils.extractAsset(application, "hack.jar", file4);
                    FileUtils.extractFile(file4, "lib/", file3);
                    json.putOpt("current", file3.getPath());
                    json.putOpt("time", Long.valueOf(jLastModified));
                    FileUtils.writeString(file2, json.toString());
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
        }
        loadEngine(file3);
    }

    private static JSONObject readJson(File file) {
        String string = FileUtils.readString(file);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private static void loadEngine(File file) {
        File file2 = new File(file, "base.apk");
        File file3 = new File(file, "lib");
        ArrayList arrayList = new ArrayList();
        if (Process.is64Bit()) {
            for (String str : Build.SUPPORTED_64_BIT_ABIS) {
                File file4 = new File(file3, str);
                if (file4.exists()) {
                    arrayList.add(file4.getAbsolutePath());
                }
            }
        } else {
            for (String str2 : Build.SUPPORTED_32_BIT_ABIS) {
                File file5 = new File(file3, str2);
                if (file5.exists()) {
                    arrayList.add(file5.getAbsolutePath());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i != size - 1) {
                sb.append(File.pathSeparator);
            }
        }
        hackClassLoader = new DexClassLoader(file2.getPath(), file2.getParent(), sb.toString(), Context.class.getClassLoader());
    }

    public static DexClassLoader getHackClassLoader() {
        return hackClassLoader;
    }

    public static void setHackClassLoader(DexClassLoader dexClassLoader) {
        hackClassLoader = dexClassLoader;
    }
}
