package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public enum ii {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f657a;

    ii(int i9) {
        this.f657a = i9;
    }

    public int a() {
        return this.f657a;
    }

    public static ii a(int i9) {
        if (i9 == 0) {
            return RegIdExpired;
        }
        if (i9 == 1) {
            return PackageUnregistered;
        }
        if (i9 != 2) {
            return null;
        }
        return Init;
    }
}
