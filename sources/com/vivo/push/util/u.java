package com.vivo.push.util;

import android.os.Process;
import android.util.Log;

/* JADX INFO: compiled from: LogController.java */
/* JADX INFO: loaded from: classes.dex */
public final class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16903a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.v
    public final int a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2);
    }

    @Override // com.vivo.push.util.v
    public final int b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2);
    }

    @Override // com.vivo.push.util.v
    public final int c(String str, String str2) {
        if (!w.a()) {
            return -1;
        }
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2);
    }

    @Override // com.vivo.push.util.v
    public final int d(String str, String str2) {
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2);
    }

    @Override // com.vivo.push.util.v
    public final int e(String str, String str2) {
        if (!w.a()) {
            return -1;
        }
        return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2);
    }

    @Override // com.vivo.push.util.v
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.v
    public final int b(String str, String str2, Throwable th) {
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2, th);
    }

    @Override // com.vivo.push.util.v
    public final void b(String str) {
        if (a()) {
            a(str, 1);
        }
    }

    @Override // com.vivo.push.util.v
    public final void c(String str) {
        if (a()) {
            a(str, 2);
        }
    }

    @Override // com.vivo.push.util.v
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f16903a + str2, th);
    }

    @Override // com.vivo.push.util.v
    public final void a(String str) {
        if (a()) {
            a(str, 0);
        }
    }

    private void a(String str, int i9) {
        if (i9 > 0) {
            d("LogController", str);
        }
        com.vivo.push.i.b.a();
    }

    private static boolean a() {
        w.a();
        return com.vivo.push.i.b.a().b();
    }
}
