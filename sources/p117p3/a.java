package p117p3;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MemoryExecutorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f20786a = Executors.newScheduledThreadPool(1, new b("CheckToDump"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f20787b;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("Normal"));
        f20787b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
