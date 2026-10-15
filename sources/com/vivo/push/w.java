package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: PushCommand.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16909b;

    public w(int i9) {
        this.f16908a = -1;
        if (i9 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f16908a = i9;
    }

    public static long c() {
        return 0L;
    }

    private void e(d dVar) {
        dVar.a(com.heytap.mcssdk.constant.b.f14306y, this.f16908a);
        dVar.a("client_pkgname", this.f16909b);
        c(dVar);
    }

    public final String a() {
        return this.f16909b;
    }

    public final int b() {
        return this.f16908a;
    }

    public abstract void c(d dVar);

    public abstract void d(d dVar);

    public boolean d() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f16909b = str;
    }

    public final void b(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.w.b("PushCommand", "bundleWapper is null");
            return;
        }
        dVarA.a("method", this.f16908a);
        e(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.w.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(d dVar) {
        String strA = y.a(this.f16908a);
        if (strA == null) {
            strA = "";
        }
        dVar.a("method", strA);
        e(dVar);
    }

    public final void b(d dVar) {
        String strA = dVar.a();
        if (!TextUtils.isEmpty(strA)) {
            this.f16909b = strA;
        } else {
            this.f16909b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
