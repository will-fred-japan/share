package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Map<String, l1> f15293b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static s f15294c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g1 f15295a = new g1();

    private s() {
    }

    public static s c() {
        if (f15294c == null) {
            d();
        }
        return f15294c;
    }

    private static synchronized void d() {
        if (f15294c == null) {
            f15294c = new s();
        }
    }

    public l1 a(String str) {
        return f15293b.get(str);
    }

    public g1 b() {
        return this.f15295a;
    }

    public Set<String> a() {
        return f15293b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f15293b.put(str, l1Var);
    }
}
