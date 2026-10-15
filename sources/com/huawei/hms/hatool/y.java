package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static y f15328b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f15329a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f15329a.containsKey(str)) {
            this.f15329a.put(str, new p0());
        }
        return this.f15329a.get(str);
    }

    private static synchronized void b() {
        if (f15328b == null) {
            f15328b = new y();
        }
    }

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }

    public static y a() {
        if (f15328b == null) {
            b();
        }
        return f15328b;
    }
}
