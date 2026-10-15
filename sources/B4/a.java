package B4;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TTExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B4.b f1728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B4.b f1729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final B4.b f1730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f1731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final B4.b f1732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final B4.b f1733f;

    /* JADX INFO: renamed from: B4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTExecutors.java */
    public static class RejectedExecutionHandlerC0005a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newCachedThreadPool().execute(runnable);
        }
    }

    /* JADX INFO: compiled from: TTExecutors.java */
    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f1734d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f1735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f1736b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1737c;

        /* JADX INFO: renamed from: B4.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TTExecutors.java */
        public class C0006a extends Thread {
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f1735a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f1737c = "TTBackgroundExecutors-" + f1734d.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            C0006a c0006a = new C0006a(this.f1735a, runnable, this.f1737c + this.f1736b.getAndIncrement(), 0L);
            if (c0006a.isDaemon()) {
                c0006a.setDaemon(false);
            }
            return c0006a;
        }
    }

    /* JADX INFO: compiled from: TTExecutors.java */
    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f1738d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f1739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f1740b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1741c;

        public c(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f1739a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            StringBuilder sbC = p171w.a.c(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sbC.append(f1738d.getAndIncrement());
            sbC.append("-Thread-");
            this.f1741c = sbC.toString();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f1739a, runnable, this.f1741c + this.f1740b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iAvailableProcessors <= 0) {
            iAvailableProcessors = 1;
        }
        int i9 = iAvailableProcessors - 1;
        int iMax = Math.max(2, Math.min(i9, 6));
        c cVar = new c("TTDefaultExecutors");
        c cVar2 = new c("TTCpuExecutors");
        c cVar3 = new c("TTScheduledExecutors");
        c cVar4 = new c("TTDownLoadExecutors");
        c cVar5 = new c("TTSerialExecutors");
        b bVar = new b();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        RejectedExecutionHandlerC0005a rejectedExecutionHandlerC0005a = new RejectedExecutionHandlerC0005a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        B4.b bVar2 = new B4.b(iMax * 2, (iMax * 4) + 1, 30L, timeUnit, linkedBlockingQueue, cVar, rejectedExecutionHandlerC0005a);
        f1728a = bVar2;
        bVar2.allowCoreThreadTimeOut(true);
        B4.b bVar3 = new B4.b(Math.max(2, Math.min(i9, 3)), (iAvailableProcessors * 2) + 1, 30L, timeUnit, linkedBlockingQueue2, cVar2, rejectedExecutionHandlerC0005a);
        f1729b = bVar3;
        bVar3.allowCoreThreadTimeOut(true);
        f1731d = Executors.newScheduledThreadPool(3, cVar3);
        B4.b bVar4 = new B4.b(2, 2, 30L, timeUnit, linkedBlockingQueue3, cVar4, rejectedExecutionHandlerC0005a);
        f1730c = bVar4;
        bVar4.allowCoreThreadTimeOut(true);
        B4.b bVar5 = new B4.b(1, 1, new LinkedBlockingQueue(), cVar5);
        f1732e = bVar5;
        bVar5.allowCoreThreadTimeOut(true);
        B4.b bVar6 = new B4.b(0, 3, new LinkedBlockingQueue(), bVar);
        f1733f = bVar6;
        bVar6.allowCoreThreadTimeOut(true);
    }
}
