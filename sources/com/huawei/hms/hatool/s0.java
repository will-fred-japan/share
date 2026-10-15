package com.huawei.hms.hatool;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j0 f15302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, String> f15304i;
    private String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f15309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f15310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f15311q;

    public s0() {
        this.f15300e = "";
        this.f15301f = "";
        this.f15302g = new j0();
        this.f15303h = "";
        this.j = "";
        this.f15305k = 10;
        this.f15306l = 7;
        this.f15307m = true;
        this.f15308n = true;
        this.f15309o = false;
        this.f15311q = 0L;
    }

    public void a(int i9) {
        this.f15305k = i9;
    }

    public int b() {
        return this.f15305k;
    }

    public void c(String str) {
        this.f15310p = str;
    }

    public int d() {
        return this.f15306l;
    }

    public void e(String str) {
        this.f15300e = str;
    }

    public String f() {
        return this.f15298c;
    }

    public void g(String str) {
        this.f15301f = str;
    }

    public String h() {
        return this.f15299d;
    }

    public boolean i() {
        return this.f15309o;
    }

    public j0 j() {
        return this.f15302g;
    }

    public Map<String, String> k() {
        return this.f15304i;
    }

    public long l() {
        return this.f15311q;
    }

    public String m() {
        return this.f15310p;
    }

    public String n() {
        return this.f15303h;
    }

    public String o() {
        return this.f15300e;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.f15301f;
    }

    public s0(s0 s0Var) {
        this.f15300e = "";
        this.f15301f = "";
        this.f15302g = new j0();
        this.f15303h = "";
        this.j = "";
        this.f15305k = 10;
        this.f15306l = 7;
        this.f15307m = true;
        this.f15308n = true;
        this.f15309o = false;
        this.f15311q = 0L;
        this.f15302g = s0Var.f15302g;
        b(s0Var.f15296a);
        a(s0Var.f15298c);
        b(s0Var.f15299d);
        e(s0Var.f15300e);
        g(s0Var.f15301f);
        d(s0Var.f15303h);
        f(s0Var.j);
        c(s0Var.f15297b);
        a(s0Var.f15305k);
        b(s0Var.f15306l);
        d(s0Var.f15307m);
        a(s0Var.f15308n);
        e(s0Var.f15309o);
        a(s0Var.f15304i);
        c(s0Var.f15310p);
        a(s0Var.f15311q);
    }

    public void a(long j) {
        this.f15311q = j;
    }

    public void b(int i9) {
        this.f15306l = i9;
    }

    public void c(boolean z8) {
        this.f15297b = z8;
    }

    public void d(String str) {
        this.f15303h = str;
    }

    public void e(boolean z8) {
        this.f15309o = z8;
    }

    public void f(String str) {
        this.j = str;
    }

    public boolean g() {
        return this.f15307m;
    }

    public void a(String str) {
        this.f15298c = str;
    }

    public void b(String str) {
        this.f15299d = str;
    }

    public boolean c() {
        return this.f15296a;
    }

    public void d(boolean z8) {
        this.f15307m = z8;
    }

    public boolean e() {
        return this.f15297b;
    }

    public void a(Map<String, String> map) {
        this.f15304i = map;
    }

    public void b(boolean z8) {
        this.f15296a = z8;
    }

    public void a(boolean z8) {
        this.f15308n = z8;
    }

    public boolean a() {
        return this.f15308n;
    }
}
