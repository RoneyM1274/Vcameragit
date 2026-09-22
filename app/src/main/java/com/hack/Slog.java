package com.hack;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Slog {
    public static boolean iSloggable(String str, int i) {
        return false;
    }

    public static void print(String str, String str2) {
        Log.d(str, str2);
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void v(String str, String str2) {
        Log.v(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        Log.e(str, String.format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        Log.w(str, String.format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        Log.i(str, String.format(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        Log.d(str, String.format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        Log.v(str, String.format(str2, objArr));
    }
}
