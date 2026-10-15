package cn.jiguang.av;

import android.text.TextUtils;
import cn.jiguang.x.f;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadGroup f9467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f9468b = new AtomicInteger(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9469c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f9467a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f9469c = A.a.i("jg_", TextUtils.isEmpty(str) ? "default" : str.toLowerCase(), "_pool_thread");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0080 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:21:0x007a, B:23:0x0080, B:26:0x0088, B:28:0x008e), top: B:36:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008e A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #1 {all -> 0x0084, blocks: (B:21:0x007a, B:23:0x0080, B:26:0x0088, B:28:0x008e), top: B:36:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Runnable runnable2;
        Throwable th;
        Throwable th2;
        Thread thread;
        Thread thread2 = null;
        try {
            runnable2 = runnable;
            try {
                Thread thread3 = new Thread(this.f9467a, runnable2, this.f9469c + this.f9468b.getAndIncrement(), 0L);
                try {
                    if (thread3.isDaemon()) {
                        thread3.setDaemon(false);
                    }
                    if (thread3.getPriority() != 5) {
                        thread3.setPriority(5);
                    }
                    return thread3;
                } catch (Throwable th3) {
                    th = th3;
                    thread2 = thread3;
                    f.l("JThreadFactory", "JThreadFactory new Thread error, " + th.getMessage());
                    try {
                        thread = new Thread(this.f9467a, runnable2, this.f9469c + this.f9468b.getAndIncrement(), 0L);
                        try {
                            if (thread.isDaemon()) {
                                thread.setDaemon(false);
                            }
                            if (thread.getPriority() != 5) {
                                return thread;
                            }
                            thread.setPriority(5);
                            return thread;
                        } catch (Throwable th4) {
                            th2 = th4;
                            thread2 = thread;
                            f.l("JThreadFactory", "JThreadFactory new Thread again error, " + th2.getMessage());
                            return thread2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                th = th;
                f.l("JThreadFactory", "JThreadFactory new Thread error, " + th.getMessage());
                thread = new Thread(this.f9467a, runnable2, this.f9469c + this.f9468b.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() != 5) {
                    return thread;
                }
                thread.setPriority(5);
                return thread;
            }
        } catch (Throwable th7) {
            th = th7;
            runnable2 = runnable;
        }
    }
}
