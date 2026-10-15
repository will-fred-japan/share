package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gq implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17545a = "wcc-ml-test10.bj";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17546b = bj.b("MTAuMzguMTYyLjM1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f17547c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private gt f523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f524a = gp.f506a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f525b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17550f;

    public gq(Map<String, Integer> map, int i9, String str, gt gtVar) {
        a(map, i9, str, gtVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo441a() {
        return null;
    }

    public void b(String str) {
        this.f17550f = str;
    }

    public String c() {
        if (this.f17549e == null) {
            this.f17549e = a();
        }
        return this.f17549e;
    }

    public static final String a() {
        String str = f17547c;
        if (str != null) {
            return str;
        }
        if (z.m845a()) {
            return "sandbox.xmpush.xiaomi.com";
        }
        return z.b() ? f17546b : "app.chat.xiaomi.net";
    }

    public String b() {
        return this.f17550f;
    }

    public void c(String str) {
        this.f17549e = str;
    }

    public static final void a(String str) {
        if (z.b()) {
            return;
        }
        f17547c = str;
    }

    private void a(Map<String, Integer> map, int i9, String str, gt gtVar) {
        this.f522a = i9;
        this.f17548d = str;
        this.f523a = gtVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m439a() {
        return this.f522a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m440a() {
        return this.f524a;
    }

    public void a(boolean z8) {
        this.f524a = z8;
    }
}
