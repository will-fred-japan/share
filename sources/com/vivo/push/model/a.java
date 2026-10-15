package com.vivo.push.model;

import android.text.TextUtils;

/* JADX INFO: compiled from: PushPackageInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16684a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16687d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16685b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16686c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16688e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16689f = false;

    public a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f16684a = str;
    }

    public final String a() {
        return this.f16684a;
    }

    public final long b() {
        return this.f16685b;
    }

    public final boolean c() {
        return this.f16688e;
    }

    public final boolean d() {
        return this.f16689f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f16684a + ", mPushVersion=" + this.f16685b + ", mPackageVersion=" + this.f16686c + ", mInBlackList=" + this.f16688e + ", mPushEnable=" + this.f16689f + "}";
    }

    public final void a(long j) {
        this.f16685b = j;
    }

    public final void a(boolean z8) {
        this.f16689f = z8;
    }

    public final void a(int i9) {
        this.f16686c = i9;
    }

    public final void a(String str) {
        this.f16687d = str;
    }
}
