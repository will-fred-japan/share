package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f15182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<b1> f15187f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f15182a = (byte[]) bArr.clone();
        this.f15183b = str;
        this.f15184c = str2;
        this.f15186e = str3;
        this.f15185d = str4;
        this.f15187f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f15183b, this.f15182a, map);
    }

    private void b() {
        b0.c().a(new d1(this.f15187f, this.f15184c, this.f15185d, this.f15186e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.a("hmsSdk", "send data running");
        int iB = a(a()).b();
        if (iB != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f15185d, this.f15186e, this.f15184c, Integer.valueOf(iB));
    }

    private Map<String, String> a() {
        return k.b(this.f15184c, this.f15186e, this.f15185d);
    }
}
