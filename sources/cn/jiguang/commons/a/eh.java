package cn.jiguang.commons.a;

import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9952b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f9956f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f9958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Deprecated
    private X509TrustManager f9959i;

    @Deprecated
    private HostnameVerifier j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9957g = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9953c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9954d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f9955e = new HashMap();

    public eh(String str) {
        this.f9951a = str;
    }

    public final String a() {
        return this.f9951a;
    }

    public final int b() {
        return this.f9953c;
    }

    public final int c() {
        return this.f9954d;
    }

    @Deprecated
    public final X509TrustManager d() {
        return this.f9959i;
    }

    @Deprecated
    public final HostnameVerifier e() {
        return this.j;
    }

    public final byte[] f() {
        return this.f9956f;
    }

    public final Map<String, String> g() {
        return this.f9955e;
    }

    public final String h() {
        return this.f9952b;
    }

    public final boolean i() {
        return this.f9957g;
    }

    public final Object j() {
        return this.f9958h;
    }

    public final void a(int i9) {
        this.f9953c = 15000;
    }

    public final void b(int i9) {
        this.f9954d = 15000;
    }

    public final void a(Object obj) {
        this.f9958h = obj;
    }

    public final void b(String str) {
        this.f9952b = str;
    }

    public final void a(String str) {
        byte[] bytes;
        if (str == null) {
            bytes = null;
        } else {
            try {
                this.f9956f = str.getBytes("UTF-8");
                return;
            } catch (Throwable unused) {
                bytes = str.getBytes();
            }
        }
        this.f9956f = bytes;
    }

    public final void a(String str, String str2) {
        this.f9955e.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        if (map != null) {
            this.f9955e.putAll(map);
        }
    }

    public final void a(boolean z8) {
        this.f9957g = false;
    }

    public final void a(byte[] bArr) {
        this.f9956f = bArr;
    }
}
