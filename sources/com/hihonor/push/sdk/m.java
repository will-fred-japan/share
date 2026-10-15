package com.hihonor.push.sdk;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a(String str, String str2, Throwable th) {
        if (str2.length() <= 4000) {
            Log.e(str, str2, th);
            return;
        }
        int i9 = 0;
        while (i9 < str2.length()) {
            int i10 = i9 + 4000;
            Log.e(str, str2.length() > i10 ? str2.substring(i9, i10) : str2.substring(i9), th);
            i9 = i10;
        }
    }

    public static void a(String str) {
        String strSubstring;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i9 = 2; i9 < stackTrace.length; i9++) {
            if (!stackTrace[i9].getClass().equals(m.class)) {
                String className = stackTrace[i9].getClassName();
                strSubstring = className.substring(className.lastIndexOf(46) + 1);
                a("HonorPush_" + strSubstring, str, null);
            }
        }
        strSubstring = "";
        a("HonorPush_" + strSubstring, str, null);
    }
}
