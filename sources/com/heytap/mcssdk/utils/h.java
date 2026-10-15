package com.heytap.mcssdk.utils;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static int a(String str, int i9) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i9))).intValue();
        } catch (Throwable unused) {
            return i9;
        }
    }

    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(String str, boolean z8) {
        try {
            return ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z8))).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
