package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile k1 f14535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f14536b = new n();

    public final void a(Context context) {
        if (f14535a == null) {
            f14535a = new k1(context, "push");
        }
    }

    public synchronized String b(Context context) {
        String str;
        k1 k1Var;
        String str2;
        String strA;
        try {
            a(context);
            str = "";
            SharedPreferences sharedPreferences = f14535a.f14529a;
            if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
                SharedPreferences sharedPreferences2 = f14535a.f14529a;
                if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                    k1Var = f14535a;
                    str2 = "key_push_token";
                } else {
                    SharedPreferences sharedPreferences3 = f14535a.f14529a;
                    String string = sharedPreferences3 != null ? sharedPreferences3.getString("key_push_token", "") : "";
                    SharedPreferences sharedPreferences4 = f14535a.f14529a;
                    try {
                        strA = h.a(string, Base64.decode(sharedPreferences4 != null ? sharedPreferences4.getString("key_aes_gcm", "") : "", 0));
                    } catch (Exception e9) {
                        Log.e("AesGcmUtil", "encrypt error:" + e9);
                        strA = null;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        f14535a.a("key_aes_gcm");
                        k1Var = f14535a;
                        str2 = "key_push_token";
                    } else {
                        str = strA;
                    }
                }
                k1Var.a(str2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    public synchronized void a(Context context, String str) {
        String strB;
        try {
            a(context);
            if (TextUtils.isEmpty(str)) {
                f14535a.a("key_push_token");
            } else {
                String strA = h.a(context, context.getPackageName());
                byte[] bArrA = h.a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
                String strEncodeToString = Base64.encodeToString(l.a(l.a(l.a(l.a(bArrA, -4), h.a(strA)), 6), h.a(32)), 0);
                boolean zA = f14535a.a("key_aes_gcm", strEncodeToString);
                try {
                    strB = h.b(str, Base64.decode(strEncodeToString, 0));
                } catch (Exception e9) {
                    Log.e("AesGcmUtil", "encrypt error:" + e9);
                    strB = null;
                }
                if (zA && !TextUtils.isEmpty(strB)) {
                    f14535a.a("key_push_token", strB);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
