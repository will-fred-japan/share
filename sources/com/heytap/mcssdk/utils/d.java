package com.heytap.mcssdk.utils;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14373a = "oplus_system_folding_mode";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14374b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14375c = "tablet";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14376d = "ro.build.characteristics";

    public static final boolean a() {
        try {
            String strA = h.a(f14376d);
            return strA != null && strA.contains("tablet");
        } catch (Exception unused) {
            return false;
        }
    }

    public static final int b(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), f14373a, -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final boolean a(Context context) {
        return -1 != b(context);
    }
}
