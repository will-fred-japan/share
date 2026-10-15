package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        c.a();
    }

    public static boolean getInitFlag() {
        return a.b();
    }

    public static void init(Context context, boolean z8, boolean z9, boolean z10, String str, String str2) {
        new b(context).a(z8).c(z9).b(z10).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void onReport() {
        a.c();
    }

    public static void onStreamEvent(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.b(i9, str, linkedHashMap);
    }

    public static void onEvent(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.a(i9, str, linkedHashMap);
    }
}
