package cn.jpush.android.v;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11706a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11707b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11708c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11709d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11710e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11711f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f11712g = 0;

    public long a() {
        return this.f11706a;
    }

    public int b() {
        return this.f11707b;
    }

    public int c() {
        return this.f11708c;
    }

    public String d() {
        return this.f11710e;
    }

    public long e() {
        return this.f11712g;
    }

    public long f() {
        return this.f11711f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocalNotificationDBData [ln_id=");
        sb.append(this.f11706a);
        sb.append(", ln_count=");
        sb.append(this.f11707b);
        sb.append(", ln_remove=");
        sb.append(this.f11708c);
        sb.append(", ln_type=");
        sb.append(this.f11709d);
        sb.append(", ln_extra=");
        sb.append(this.f11710e);
        sb.append(", ln_trigger_time=");
        sb.append(this.f11711f);
        sb.append(", ln_add_time=");
        return W5.e.m(sb, this.f11712g, "]");
    }

    public void a(int i9) {
        this.f11707b = i9;
    }

    public void b(int i9) {
        this.f11708c = i9;
    }

    public void c(int i9) {
        this.f11709d = i9;
    }

    public void a(long j) {
        this.f11706a = j;
    }

    public void b(long j) {
        this.f11712g = j;
    }

    public void c(long j) {
        this.f11711f = j;
    }

    public void a(String str) {
        this.f11710e = str;
    }
}
