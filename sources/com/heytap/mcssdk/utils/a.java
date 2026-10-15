package com.heytap.mcssdk.utils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14368a = "file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14369b = "ro.crypto.type";

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return f14368a.equals(a(f14369b));
    }
}
