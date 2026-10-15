package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f17503a = a(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f17504b = a(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f17505c = a(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f17506d = a(3, 2);

    public static int a(int i9) {
        return i9 & 7;
    }

    public static int b(int i9) {
        return i9 >>> 3;
    }

    public static int a(int i9, int i10) {
        return (i9 << 3) | i10;
    }
}
