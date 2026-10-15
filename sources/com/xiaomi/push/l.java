package com.xiaomi.push;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f18123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f924a;

    public static synchronized String a() {
        String str;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - f18123a) > 86400000) {
                f18123a = jCurrentTimeMillis;
                f924a = Build.MODEL;
            }
            str = f924a;
            if (str == null) {
                str = "";
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }
}
