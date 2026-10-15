package com.starburst.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h f16449c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16451b;

    public static h a() {
        if (f16449c == null) {
            f16449c = new h();
        }
        return f16449c;
    }

    public final String b(String str) {
        j.k("SpUtils", "mContext--" + this.f16450a);
        Context context = this.f16450a;
        return context == null ? "" : context.getSharedPreferences("hs_sdk_share", 0).getString(str, "");
    }

    public final void c(String str, String str2) {
        j.k("SpUtils", "mContext--" + this.f16450a);
        Context context = this.f16450a;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("hs_sdk_share", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
