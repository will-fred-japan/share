package B4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TTThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor.AbortPolicy f1742a = new ThreadPoolExecutor.AbortPolicy();

    public b(int i9, int i10, LinkedBlockingQueue linkedBlockingQueue, ThreadFactory threadFactory) {
        super(i9, i10, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory, f1742a);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }
}
