package cn.jiguang.commons.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9599i;
    private int j;

    public final long a() {
        return this.f9592b;
    }

    public final long b() {
        return this.j;
    }

    public final int c() {
        return this.f9591a;
    }

    public final long d() {
        return this.f9595e;
    }

    public final long e() {
        return this.f9598h;
    }

    public final long f() {
        return this.f9594d;
    }

    public final int g() {
        return this.f9596f;
    }

    public final int h() {
        return this.f9597g;
    }

    public final long i() {
        return this.f9599i;
    }

    public final JSONObject j() {
        try {
            return new JSONObject().put("ci", this.f9591a).put("sc", this.f9592b).put("sr", this.f9593c).put("bc", this.f9594d).put("br", this.f9595e).put("bg", this.f9596f).put("md", this.f9597g).put("rp", this.f9598h).put("de", this.f9599i).put("scc", this.j);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JDataConfig{id=");
        sb.append(this.f9591a);
        sb.append(", coolStartCollectDelay=");
        sb.append(this.f9592b);
        sb.append(", reportDelay=");
        sb.append(this.f9593c);
        sb.append(", collectInterval=");
        sb.append(this.f9594d);
        sb.append(", reportInterval=");
        sb.append(this.f9595e);
        sb.append(", backgroundState=");
        sb.append(this.f9596f);
        sb.append(", methodFreq=");
        sb.append(this.f9597g);
        sb.append(", registerProtectionTime=");
        sb.append(this.f9598h);
        sb.append(", expiredTime=");
        sb.append(this.f9599i);
        sb.append(", collectCount=");
        return H2.a.a(sb, this.j, '}');
    }

    public final void a(int i9) {
        this.f9592b = i9;
    }

    public final void b(int i9) {
        this.j = i9;
    }

    public final void c(int i9) {
        this.f9595e = i9;
    }

    public final void d(int i9) {
        this.f9593c = i9;
    }

    public final void e(int i9) {
        this.f9591a = i9;
    }

    public final void f(int i9) {
        this.f9594d = i9;
    }

    public final void g(int i9) {
        this.f9596f = i9;
    }

    public final void h(int i9) {
        this.f9597g = i9;
    }

    public final void a(long j) {
        this.f9598h = j;
    }

    public final void b(long j) {
        this.f9599i = j;
    }
}
