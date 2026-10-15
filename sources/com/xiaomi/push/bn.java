package com.xiaomi.push;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class bn<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f17091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f17092i;

    public bn(long j, long j8) {
        this.f17092i = j * 1000000;
        this.f17084a = j8;
    }

    public long a() {
        return this.f17086c;
    }

    public long b() {
        return this.f17087d;
    }

    public long c() {
        long j = this.f17089f;
        if (j > 0) {
            long j8 = this.f17088e;
            if (j8 > 0) {
                return j / j8;
            }
        }
        return 0L;
    }

    public long d() {
        long j = this.f17091h;
        long j8 = this.f17090g;
        if (j > j8) {
            return j - j8;
        }
        return 0L;
    }

    public T a(Callable<T> callable) {
        T tCall;
        long j = this.f17085b;
        long j8 = this.f17092i;
        if (j > j8) {
            long j9 = (j / j8) * this.f17084a;
            this.f17085b = 0L;
            if (j9 > 0) {
                try {
                    Thread.sleep(j9);
                } catch (Exception unused) {
                }
            }
        }
        long jNanoTime = System.nanoTime();
        if (this.f17090g <= 0) {
            this.f17090g = jNanoTime;
        }
        try {
            tCall = callable.call();
        } catch (Exception e9) {
            e9.printStackTrace();
            tCall = null;
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        this.f17091h = System.nanoTime();
        this.f17088e++;
        if (this.f17086c < jNanoTime2) {
            this.f17086c = jNanoTime2;
        }
        if (jNanoTime2 > 0) {
            this.f17089f += jNanoTime2;
            long j10 = this.f17087d;
            if (j10 == 0 || j10 > jNanoTime2) {
                this.f17087d = jNanoTime2;
            }
        }
        this.f17085b = Math.max(jNanoTime2, 0L) + this.f17085b;
        return tCall;
    }
}
