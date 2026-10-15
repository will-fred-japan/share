package o;

import A0.h;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f20623c;

    /* JADX INFO: compiled from: DefaultTaskExecutor.java */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f20624a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f20624a.getAndIncrement());
            return thread;
        }
    }

    public b() {
        super(13);
        this.f20622b = new Object();
        this.f20623c = Executors.newFixedThreadPool(4, new a());
    }
}
