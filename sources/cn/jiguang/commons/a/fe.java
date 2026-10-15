package cn.jiguang.commons.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class fe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f10040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile ThreadPoolExecutor f10041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile ThreadPoolExecutor f10042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ThreadPoolExecutor f10043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile ScheduledThreadPoolExecutor f10044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile ThreadPoolExecutor f10045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f10046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f10047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f10048i;
    private final Object j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f10049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f10050l;

    private fe() {
        this.f10046g = new Object();
        this.f10047h = new Object();
        this.f10048i = new Object();
        this.j = new Object();
        this.f10049k = new Object();
        this.f10050l = new Object();
    }

    public static fe a() {
        return fk.f10063a;
    }

    private void b() {
        if (this.f10044e == null || this.f10044e.isShutdown()) {
            synchronized (this.f10049k) {
                try {
                    if (this.f10044e == null || this.f10044e.isShutdown()) {
                        if (this.f10044e != null) {
                            ee.d("SdkThreadPoolManager", "sp closed,reinit");
                            this.f10044e = null;
                        }
                        this.f10044e = new ScheduledThreadPoolExecutor(2, new fi("jg_c_scheduled"), new fh(this, false));
                        this.f10044e.setKeepAliveTime(30L, TimeUnit.SECONDS);
                        this.f10044e.allowCoreThreadTimeOut(true);
                        ee.a("SdkThreadPoolManager", "sp init:c=2,ka=30");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadPoolExecutor c() {
        if (this.f10045f == null || this.f10045f.isShutdown()) {
            synchronized (this.f10050l) {
                try {
                    if (this.f10045f == null || this.f10045f.isShutdown()) {
                        if (this.f10045f != null) {
                            ee.d("SdkThreadPoolManager", "bp closed,reinit");
                            this.f10045f = null;
                        }
                        this.f10045f = new ThreadPoolExecutor(1, 2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new fi("jg_c_fb"), new ThreadPoolExecutor.AbortPolicy());
                        this.f10045f.allowCoreThreadTimeOut(true);
                        ee.a("SdkThreadPoolManager", "bp init:c=1,m=2,q=64");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10045f;
    }

    private ThreadPoolExecutor d() {
        if (this.f10040a == null || this.f10040a.isShutdown()) {
            synchronized (this.f10046g) {
                try {
                    if (this.f10040a == null || this.f10040a.isShutdown()) {
                        if (this.f10040a != null) {
                            ee.d("SdkThreadPoolManager", "lt closed,reinit");
                            this.f10040a = null;
                        }
                        this.f10040a = a(new fg(1, 2, 10, 30L, "jg_c_lt", true));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10040a;
    }

    private ThreadPoolExecutor e() {
        if (this.f10041b == null || this.f10041b.isShutdown()) {
            synchronized (this.f10047h) {
                try {
                    if (this.f10041b == null || this.f10041b.isShutdown()) {
                        if (this.f10041b != null) {
                            ee.d("SdkThreadPoolManager", "ac closed,reinit");
                            this.f10041b = null;
                        }
                        this.f10041b = a(new fg(1, 2, 20, 60L, "jg_c_ac", true));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10041b;
    }

    private ThreadPoolExecutor f() {
        if (this.f10042c == null || this.f10042c.isShutdown()) {
            synchronized (this.f10048i) {
                try {
                    if (this.f10042c == null || this.f10042c.isShutdown()) {
                        if (this.f10042c != null) {
                            ee.d("SdkThreadPoolManager", "net closed,reinit");
                            this.f10042c = null;
                        }
                        this.f10042c = a(new fg(1, 2, 10, 120L, "jg_c_net", true));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10042c;
    }

    private ThreadPoolExecutor g() {
        if (this.f10043d == null || this.f10043d.isShutdown()) {
            synchronized (this.j) {
                try {
                    if (this.f10043d == null || this.f10043d.isShutdown()) {
                        if (this.f10043d != null) {
                            ee.d("SdkThreadPoolManager", "dev closed,reinit");
                            this.f10043d = null;
                        }
                        this.f10043d = a(new fg(2, 3, 80, 45L, "jg_c_dev", true));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10043d;
    }

    public /* synthetic */ fe(byte b9) {
        this();
    }

    public final ScheduledFuture<?> a(Runnable runnable, long j) {
        return a(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final ScheduledFuture<?> a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            ee.d("SdkThreadPoolManager", "sc null");
            return null;
        }
        try {
            b();
            if (this.f10044e != null) {
                return this.f10044e.schedule(runnable, j, timeUnit);
            }
            ee.d("SdkThreadPoolManager", "sp null");
            return null;
        } catch (Throwable th) {
            ee.b("SdkThreadPoolManager", "sc err:".concat(runnable.getClass().getSimpleName()), th);
            return null;
        }
    }

    private ThreadPoolExecutor a(fg fgVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(fgVar.f10052a, fgVar.f10053b, fgVar.f10055d, TimeUnit.SECONDS, new LinkedBlockingQueue(fgVar.f10054c), new fi(fgVar.f10056e), new fh(this, true));
        if (fgVar.f10057f) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        ee.a("SdkThreadPoolManager", "p init:" + fgVar.f10056e + ",c=" + fgVar.f10052a + ",m=" + fgVar.f10053b + ",q=" + fgVar.f10054c);
        return threadPoolExecutor;
    }

    public final boolean a(Runnable runnable) {
        return a(runnable, fl.LIGHT_TASK);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f A[Catch: all -> 0x0024, RejectedExecutionException -> 0x005e, TryCatch #2 {RejectedExecutionException -> 0x005e, all -> 0x0024, blocks: (B:6:0x000b, B:17:0x0026, B:21:0x0036, B:23:0x0048, B:18:0x002b, B:19:0x0030, B:14:0x001f), top: B:29:0x000b }] */
    public final boolean a(Runnable runnable, fl flVar) {
        ThreadPoolExecutor threadPoolExecutorD;
        if (runnable == null) {
            ee.d("SdkThreadPoolManager", "ex null");
            return false;
        }
        try {
            int i9 = ff.f10051a[flVar.ordinal()];
            if (i9 == 1) {
                threadPoolExecutorD = d();
            } else if (i9 == 2) {
                threadPoolExecutorD = e();
            } else if (i9 == 3) {
                threadPoolExecutorD = f();
            } else if (i9 != 4) {
                threadPoolExecutorD = d();
            } else {
                threadPoolExecutorD = g();
            }
            if (threadPoolExecutorD != null) {
                threadPoolExecutorD.execute(runnable);
                return true;
            }
            ee.d("SdkThreadPoolManager", "p null,t=" + flVar);
            return false;
        } catch (RejectedExecutionException unused) {
            ee.d("SdkThreadPoolManager", "ex rj:".concat(runnable.getClass().getSimpleName()));
            return false;
        } catch (Throwable th) {
            ee.b("SdkThreadPoolManager", "ex err:".concat(runnable.getClass().getSimpleName()), th);
            return false;
        }
    }
}
