package cn.jiguang.al;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Date f9283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f9284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f9285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UUID f9286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f9287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f9288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Long f9289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Double f9290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9291i;
    private String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f9293l;

    public enum a {
        Ok,
        Exited,
        Crashed
    }

    public i() {
        this(a.Ok, cn.jiguang.aw.f.c(), cn.jiguang.aw.f.c(), 0, UUID.randomUUID(), Boolean.TRUE, null, null, null, null, "production");
    }

    private double b(Date date) {
        return Math.abs(date.getTime() - this.f9283a.getTime()) / 1000.0d;
    }

    private long c(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Date a() {
        Date date = this.f9283a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public int d() {
        return this.f9285c.get();
    }

    public a e() {
        return this.f9288f;
    }

    public Long f() {
        return this.f9289g;
    }

    public Double g() {
        return this.f9290h;
    }

    public Date h() {
        Date date = this.f9284b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void i() {
        a(cn.jiguang.aw.f.c());
    }

    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public i clone() {
        return new i(this.f9288f, this.f9283a, this.f9284b, this.f9285c.get(), this.f9286d, this.f9287e, this.f9289g, this.f9290h, this.f9291i, this.j, this.f9292k);
    }

    public i(a aVar, Date date, Date date2, int i9, UUID uuid, Boolean bool, Long l8, Double d9, String str, String str2, String str3) {
        this.f9293l = new Object();
        this.f9288f = aVar;
        this.f9283a = date;
        this.f9284b = date2;
        this.f9285c = new AtomicInteger(i9);
        this.f9286d = uuid;
        this.f9287e = bool;
        this.f9289g = l8;
        this.f9290h = d9;
        this.f9291i = str;
        this.j = str2;
        this.f9292k = str3;
    }

    public void a(Date date) {
        synchronized (this.f9293l) {
            try {
                this.f9287e = null;
                if (this.f9288f == a.Ok) {
                    this.f9288f = a.Exited;
                }
                if (date == null) {
                    date = cn.jiguang.aw.f.c();
                }
                this.f9284b = date;
                Date date2 = this.f9284b;
                if (date2 != null) {
                    this.f9290h = Double.valueOf(b(date2));
                    this.f9289g = Long.valueOf(c(this.f9284b));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public UUID b() {
        return this.f9286d;
    }

    public Boolean c() {
        return this.f9287e;
    }

    public boolean a(a aVar, String str, boolean z8) {
        boolean z9;
        boolean z10;
        synchronized (this.f9293l) {
            z9 = true;
            if (aVar != null) {
                try {
                    this.f9288f = aVar;
                    z10 = true;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z10 = false;
            }
            if (str != null) {
                this.j = str;
                z10 = true;
            }
            if (z8) {
                this.f9285c.addAndGet(1);
            } else {
                z9 = z10;
            }
            if (z9) {
                this.f9287e = null;
                Date dateC = cn.jiguang.aw.f.c();
                this.f9284b = dateC;
                if (dateC != null) {
                    this.f9289g = Long.valueOf(c(dateC));
                }
            }
        }
        return z9;
    }
}
