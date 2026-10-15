package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes.dex */
public class j1 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15236b;

    public j1(String str, String str2) {
        this.f15235a = str;
        this.f15236b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        w0.b(this.f15235a, this.f15236b);
    }
}
