package com.vivo.push.i;

import java.util.ArrayList;

/* JADX INFO: compiled from: TestManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f16669a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f16670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.vivo.push.i.a f16671c;

    /* JADX INFO: compiled from: TestManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f16672a = new b(0);
    }

    public /* synthetic */ b(byte b9) {
        this();
    }

    public static b a() {
        return a.f16672a;
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.f16670b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private b() {
        this.f16670b = null;
        this.f16671c = null;
        this.f16670b = new ArrayList<>();
    }
}
