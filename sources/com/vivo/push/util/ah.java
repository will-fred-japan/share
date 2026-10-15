package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SpCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class ah implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f16831a = "SpCache";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f16832b = "com.vivo.push.cache";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f16833c;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.f16833c != null) {
            return true;
        }
        this.f16833c = context.getSharedPreferences(f16832b, 0);
        return true;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.f16833c.getString(str, str2);
        w.d(f16831a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor editorEdit = this.f16833c.edit();
        if (editorEdit != null) {
            editorEdit.clear();
            c.a(editorEdit);
        }
        w.d(f16831a, "system cache is cleared");
    }
}
