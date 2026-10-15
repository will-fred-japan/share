package cn.jiguang.ac;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f8937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f8938c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final cn.jiguang.ac.a<Object> f8940e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f8942g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f8939d = new AtomicBoolean(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f8941f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CountDownLatch f8943h = new CountDownLatch(1);

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f8945a;

        public a(ExecutorService executorService) {
            super(p.d());
            this.f8945a = executorService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f8945a.isShutdown()) {
                    cn.jiguang.x.f.i("Step", "executor is shutdown");
                } else {
                    this.f8945a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                W5.f.m("handleMessage e:", "Step", th);
            }
        }
    }

    public p(int i9, int i10, cn.jiguang.ac.a<Object> aVar, String str) {
        this.f8936a = i10;
        this.f8940e = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i9, i9, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cn.jiguang.av.c(str)) { // from class: cn.jiguang.ac.p.1
            @Override // java.util.concurrent.ThreadPoolExecutor
            public void afterExecute(Runnable runnable, Throwable th) {
                try {
                    if (getActiveCount() > 1 || !getQueue().isEmpty() || p.this.f8938c.hasMessages(233)) {
                        return;
                    }
                } catch (Throwable unused) {
                }
                try {
                    p.this.f8939d.set(true);
                    p.this.f8943h.countDown();
                } catch (Throwable unused2) {
                }
            }
        };
        this.f8937b = threadPoolExecutor;
        this.f8938c = new a(threadPoolExecutor);
    }

    private synchronized long b(long j) {
        long j8 = this.f8941f + j;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (j8 < jUptimeMillis) {
            this.f8941f = jUptimeMillis;
            return -1L;
        }
        this.f8941f = j8;
        return j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Looper d() {
        HandlerThread handlerThread = new HandlerThread("jg_step_thread") { // from class: cn.jiguang.ac.p.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public synchronized Object a(long j) {
        if (a()) {
            return this.f8942g;
        }
        if (this.f8939d.get()) {
            return null;
        }
        try {
            if (j != -1) {
                this.f8943h.await(j, TimeUnit.MILLISECONDS);
            } else {
                this.f8943h.await();
            }
        } catch (InterruptedException unused) {
        }
        if (this.f8943h.getCount() == 0) {
            this.f8943h = new CountDownLatch(1);
        }
        return this.f8942g;
    }

    public void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.f8942g = obj;
        this.f8943h.countDown();
        cn.jiguang.ac.a<Object> aVar = this.f8940e;
        if (aVar != null) {
            aVar.a(obj);
        }
        a(true);
        cn.jiguang.x.f.c("Step", "done!");
    }

    public void b() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f8937b;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().clear();
                this.f8938c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }

    public void a(Callable<?> callable) {
        try {
            long jB = b(this.f8936a);
            if (jB < 0) {
                this.f8937b.submit(callable);
            } else {
                Message messageObtain = Message.obtain();
                messageObtain.what = 233;
                messageObtain.obj = callable;
                this.f8938c.sendMessageAtTime(messageObtain, jB);
            }
            this.f8939d.set(false);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z8) {
        this.f8938c.removeMessages(233);
        if (!this.f8937b.isShutdown()) {
            if (z8) {
                this.f8937b.shutdownNow();
            } else {
                this.f8937b.shutdown();
            }
        }
        try {
            this.f8938c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.x.f.c("Step", "StepParallelScheduler stop !");
    }

    public boolean a() {
        return this.f8942g != null;
    }
}
