package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f17093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f17097e = System.currentTimeMillis();

    public int a() {
        return com.xiaomi.push.service.ao.a() ? 1 : 0;
    }

    public long b() {
        return this.f17094b;
    }

    public long c() {
        return this.f17095c;
    }

    public long d() {
        return this.f17096d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m129a() {
        return this.f17093a;
    }

    public void b(long j) {
        this.f17094b += j;
    }

    public void c(long j) {
        this.f17096d += j;
    }

    public void a(long j) {
        this.f17093a = j;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m130a() {
        this.f17095c++;
    }
}
