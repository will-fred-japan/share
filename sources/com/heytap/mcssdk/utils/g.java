package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.mcssdk.PushService;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14391a = "shared_msg_sdk";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14392b = "hasDefaultChannelCreated";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14393c = "decryptTag";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14394d = "registerTimeoutCount";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f14395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f14396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f14397g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static g f14398a = new g();

        private a() {
        }
    }

    private g() {
        this.f14397g = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.f14395e = a(context);
        }
        Context context2 = this.f14395e;
        if (context2 != null) {
            this.f14396f = context2.getSharedPreferences(f14391a, 0);
        }
    }

    private Context a(Context context) {
        boolean zA = com.heytap.mcssdk.utils.a.a();
        e.b("fbeVersion is " + zA);
        return zA ? context.createDeviceProtectedStorageContext() : context.getApplicationContext();
    }

    public static g f() {
        return a.f14398a;
    }

    private SharedPreferences g() {
        SharedPreferences sharedPreferences;
        Context context;
        SharedPreferences sharedPreferences2 = this.f14396f;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        synchronized (this.f14397g) {
            sharedPreferences = this.f14396f;
            if (sharedPreferences == null && (context = this.f14395e) != null) {
                sharedPreferences = context.getSharedPreferences(f14391a, 0);
                this.f14396f = sharedPreferences;
            }
        }
        return sharedPreferences;
    }

    public String b() {
        SharedPreferences sharedPreferencesG = g();
        return sharedPreferencesG != null ? sharedPreferencesG.getString(f14393c, "DES") : "DES";
    }

    public int c() {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            return sharedPreferencesG.getInt(f14394d, 0);
        }
        return 0;
    }

    public void d() {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            sharedPreferencesG.edit().putInt(f14394d, c() + 1).commit();
        }
    }

    public void e() {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            sharedPreferencesG.edit().putInt(f14394d, 0).commit();
        }
    }

    public void a(String str) {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            sharedPreferencesG.edit().putString(f14393c, str).commit();
        }
    }

    public void a(boolean z8) {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            sharedPreferencesG.edit().putBoolean(f14392b, z8).commit();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferencesG = g();
        if (sharedPreferencesG != null) {
            return sharedPreferencesG.getBoolean(f14392b, false);
        }
        return false;
    }
}
