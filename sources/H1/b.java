package H1;

import I1.b;

/* JADX INFO: compiled from: AbsBatteryTimeStats.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends I1.b> extends d<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f2347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2350h;

    public b(String str) {
        super(str);
        this.f2347e = 0;
    }

    @Override // H1.i
    public final void a() {
        if (this.f2347e > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.f2350h;
            p133r2.b.f21107i.a(new a(this, this.f2355c, j));
            this.f2350h = jCurrentTimeMillis;
        }
        this.f2355c = true;
    }

    @Override // H1.i
    public final void b() {
        if (this.f2347e > 0 && this.f2350h > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.f2350h;
            p133r2.b.f21107i.a(new a(this, this.f2355c, j));
            this.f2350h = jCurrentTimeMillis;
        }
        this.f2355c = false;
    }

    @Override // H1.d
    public final void c(long j, long j8) {
        this.f2349g = 0;
        this.f2348f = 0L;
        if (this.f2347e > 0 && this.f2350h > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            p133r2.b.f21107i.a(new a(this, this.f2355c, jCurrentTimeMillis - this.f2350h));
            this.f2350h = jCurrentTimeMillis;
        }
        super.c(j, j8);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        double d9 = this.f2348f;
        double d10 = jCurrentTimeMillis2 - this.f2354b;
        double d11 = 10L;
        e((d9 / d10) * 60000.0d * d11, (((double) this.f2349g) / d10) * 60000.0d * d11);
    }

    @Override // H1.d
    public final void d(T t, long j, long j8) {
        this.f2349g++;
        long j9 = t.f2550a;
        if (j9 >= j) {
            j = j9;
        }
        long j10 = t.f2551b;
        if (j10 > 0 && j8 >= j10) {
            j8 = j10;
        }
        f(t, j8 - j9);
        long j11 = j8 - j;
        if (j11 > 0) {
            this.f2348f += j11;
        }
    }

    public abstract void e(double d9, double d10);

    public abstract void f(T t, long j);

    public final synchronized void g() {
        this.f2347e--;
        if (this.f2347e == 0) {
            p133r2.b.f21107i.a(new a(this, this.f2355c, System.currentTimeMillis() - this.f2350h));
            this.f2350h = -1L;
        }
    }
}
