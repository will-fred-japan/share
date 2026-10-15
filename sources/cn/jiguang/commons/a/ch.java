package cn.jiguang.commons.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f9799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicLong f9800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f9801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f9802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f9803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f9804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HandlerThread f9805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final fe f9806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f9807i;
    private final AtomicBoolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f9808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile cr f9809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f9810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f9811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f9812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f9813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Runnable f9814q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Runnable f9815r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final cq f9816s;
    private final cp t;

    public ch() {
        this(30000L, false);
    }

    private void c() {
        if (!this.f9807i.get() || !this.f9805g.isAlive()) {
            ee.a("PeriodicTaskScheduler", "task scheduler not running or background thread dead, skipping next task");
            return;
        }
        ee.a("PeriodicTaskScheduler", "scheduling next task in " + this.f9808k + "ms");
        this.f9804f.postDelayed(this.f9811n, this.f9808k);
    }

    public final void a() {
        if (this.j.compareAndSet(false, true)) {
            this.f9803e.sendEmptyMessage(2);
        }
    }

    public ch(long j, boolean z8) {
        String str;
        this.f9799a = new AtomicLong(0L);
        this.f9800b = new AtomicLong(0L);
        this.f9801c = new AtomicLong(0L);
        this.f9802d = new AtomicLong(0L);
        this.f9811n = new ci(this);
        this.f9812o = new cj(this);
        this.f9813p = new ck(this);
        this.f9814q = new cl(this);
        this.f9815r = new cm(this);
        byte b9 = 0;
        this.f9816s = new cq(this, b9);
        this.t = new cp(this, b9);
        long j8 = 30000;
        if (j >= 30000) {
            j8 = 300000;
            str = j > 300000 ? "task interval too large, using maximum: 300000" : "task interval too small, using minimum: 30000";
            this.f9808k = j;
            this.f9810m = false;
            this.f9807i = new AtomicBoolean(false);
            this.j = new AtomicBoolean(false);
            this.f9803e = new cn(this, Looper.getMainLooper());
            HandlerThread handlerThread = new HandlerThread("jg_c_hrt");
            handlerThread.setPriority(5);
            handlerThread.start();
            this.f9805g = handlerThread;
            this.f9804f = new Handler(handlerThread.getLooper());
            this.f9806h = fe.a();
            ee.a("PeriodicTaskScheduler", "periodic task scheduler initialized with interval: " + this.f9808k + "ms");
        }
        ee.d("PeriodicTaskScheduler", str);
        j = j8;
        this.f9808k = j;
        this.f9810m = false;
        this.f9807i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.f9803e = new cn(this, Looper.getMainLooper());
        HandlerThread handlerThread2 = new HandlerThread("jg_c_hrt");
        handlerThread2.setPriority(5);
        handlerThread2.start();
        this.f9805g = handlerThread2;
        this.f9804f = new Handler(handlerThread2.getLooper());
        this.f9806h = fe.a();
        ee.a("PeriodicTaskScheduler", "periodic task scheduler initialized with interval: " + this.f9808k + "ms");
    }

    public final void a(cd cdVar) {
        this.f9809l = cdVar;
    }

    public final void b() {
        if (this.j.compareAndSet(true, false)) {
            this.f9803e.sendEmptyMessage(3);
        }
    }

    public static /* synthetic */ void a(ch chVar) {
        if (!chVar.f9807i.get()) {
            ee.a("PeriodicTaskScheduler", "task scheduler not running, skipping task");
            return;
        }
        if (!chVar.f9805g.isAlive()) {
            ee.e("PeriodicTaskScheduler", "background thread is not alive: " + chVar.f9805g.getState());
            chVar.f9802d.incrementAndGet();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            chVar.f9799a.incrementAndGet();
            chVar.f9800b.set(jCurrentTimeMillis2);
            ee.a("PeriodicTaskScheduler", "task triggered at: " + jCurrentTimeMillis2 + ", task count: " + chVar.f9799a.get());
            if (chVar.f9809l == null) {
                ee.a("PeriodicTaskScheduler", "no task callback set");
            } else if (chVar.f9810m) {
                chVar.f9816s.a(jCurrentTimeMillis2);
                chVar.f9806h.a(chVar.f9816s);
            } else {
                ee.a("PeriodicTaskScheduler", "sending task callback to main thread");
                chVar.f9803e.obtainMessage(4, new co("task", jCurrentTimeMillis2)).sendToTarget();
            }
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            chVar.f9801c.addAndGet(jCurrentTimeMillis3);
            ee.a("PeriodicTaskScheduler", "task execution completed in " + jCurrentTimeMillis3 + "ms");
            chVar.c();
        } catch (Throwable th) {
            try {
                ee.b("PeriodicTaskScheduler", "err in task handling", th);
                chVar.f9802d.incrementAndGet();
                if (chVar.f9809l != null) {
                    String str = "Task error: " + th.getMessage();
                    if (chVar.f9810m) {
                        chVar.t.a(str);
                        chVar.f9806h.a(chVar.t);
                    } else {
                        chVar.f9803e.obtainMessage(4, new co("error", str)).sendToTarget();
                    }
                }
            } finally {
                long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                chVar.f9801c.addAndGet(jCurrentTimeMillis4);
                ee.a("PeriodicTaskScheduler", "task execution completed in " + jCurrentTimeMillis4 + "ms");
                chVar.c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0050  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static /* synthetic */ void a(ch chVar, Message message) {
        Handler handler;
        Runnable runnable;
        co coVar;
        try {
            int i9 = message.what;
            byte b9 = 0;
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 4 || chVar.f9809l == null || (coVar = (co) message.obj) == null) {
                        return;
                    }
                    try {
                        String str = coVar.f9823a;
                        switch (str.hashCode()) {
                            case -1897185151:
                                if (!str.equals("started")) {
                                    b9 = -1;
                                } else {
                                    b9 = 1;
                                }
                                break;
                            case -1884319283:
                                if (!str.equals("stopped")) {
                                    b9 = -1;
                                } else {
                                    b9 = 2;
                                }
                                break;
                            case 3552645:
                                if (!str.equals("task")) {
                                    b9 = -1;
                                }
                                break;
                            case 96784904:
                                if (!str.equals("error")) {
                                    b9 = -1;
                                } else {
                                    b9 = 3;
                                }
                                break;
                            default:
                                b9 = -1;
                                break;
                        }
                        if (b9 == 0) {
                            chVar.f9809l.a();
                            return;
                        }
                        if (b9 == 1) {
                            chVar.f9809l.b();
                            return;
                        } else if (b9 == 2) {
                            chVar.f9809l.c();
                            return;
                        } else {
                            if (b9 != 3) {
                                return;
                            }
                            chVar.f9809l.a(coVar.f9825c);
                            return;
                        }
                    } catch (Throwable th) {
                        ee.b("PeriodicTaskScheduler", "err in main thread cb: " + th.getMessage(), th);
                        chVar.f9802d.incrementAndGet();
                        return;
                    }
                }
                if (!chVar.f9807i.compareAndSet(true, false)) {
                    return;
                }
                ee.a("PeriodicTaskScheduler", "task scheduler stopped");
                handler = chVar.f9804f;
                runnable = chVar.f9813p;
            } else {
                if (!chVar.f9807i.compareAndSet(false, true)) {
                    return;
                }
                ee.a("PeriodicTaskScheduler", "task scheduler started with interval: " + chVar.f9808k + "ms");
                handler = chVar.f9804f;
                runnable = chVar.f9812o;
            }
            handler.post(runnable);
        } catch (Throwable th2) {
            W5.f.p(th2, new StringBuilder("err handling main thread msg: "), "PeriodicTaskScheduler", th2);
        }
    }
}
