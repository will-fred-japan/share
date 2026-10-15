package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s0 f15255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s0 f15256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s0 f15257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s0 f15258d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f15257c;
    }

    public s0 b() {
        return this.f15255a;
    }

    public s0 c() {
        return this.f15256b;
    }

    public s0 d() {
        return this.f15258d;
    }

    public s0 a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: ".concat(str));
        return null;
    }

    public void b(s0 s0Var) {
        this.f15256b = s0Var;
    }

    public void a(s0 s0Var) {
        this.f15255a = s0Var;
    }
}
