package p133r2;

import android.annotation.SuppressLint;
import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: AsyncEventManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f21106h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f21107i = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f21108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p133r2.c f21109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f21110c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f21111d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RunnableC0249b f21112e = new RunnableC0249b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f21113f = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f21114g = new CopyOnWriteArraySet<>();

    /* JADX INFO: compiled from: AsyncEventManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<d> it = b.this.f21113f.iterator();
            while (it.hasNext()) {
                it.next().b(System.currentTimeMillis());
            }
            if (b.this.f21110c) {
                p133r2.c cVar = b.this.f21109b;
                b bVar = b.f21107i;
                cVar.c(Message.obtain(cVar.f21122d, this), 30000L);
            }
        }
    }

    /* JADX INFO: renamed from: r2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncEventManager.java */
    public class RunnableC0249b implements Runnable {
        public RunnableC0249b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<d> it = b.this.f21114g.iterator();
            while (it.hasNext()) {
                it.next().b(System.currentTimeMillis());
            }
            if (b.this.f21110c) {
                p133r2.c cVar = b.this.f21109b;
                cVar.c(Message.obtain(cVar.f21122d, this), b.f21106h);
            }
        }
    }

    /* JADX INFO: compiled from: AsyncEventManager.java */
    public class c implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Apm_Normal");
        }
    }

    /* JADX INFO: compiled from: AsyncEventManager.java */
    public interface d {
        void b(long j);
    }

    public b() {
        p133r2.c cVar = new p133r2.c(0);
        this.f21109b = cVar;
        cVar.f21119a.start();
    }

    public final void a(Runnable runnable) {
        if (this.f21110c) {
            p133r2.c cVar = this.f21109b;
            cVar.c(Message.obtain(cVar.f21122d, runnable), 0L);
        }
    }

    public final void b(Runnable runnable, long j) {
        if (this.f21110c) {
            p133r2.c cVar = this.f21109b;
            cVar.c(Message.obtain(cVar.f21122d, runnable), j);
        }
    }

    public final void c(d dVar) {
        try {
            if (!this.f21110c || this.f21113f.contains(dVar)) {
                return;
            }
            this.f21113f.add(dVar);
            this.f21109b.a(this.f21111d);
            this.f21109b.b(this.f21111d, 30000L);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    public final void d(Runnable runnable) {
        if (this.f21108a == null) {
            synchronized (this) {
                try {
                    if (this.f21108a == null) {
                        this.f21108a = Executors.newFixedThreadPool(1, new c());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f21108a.submit(runnable);
    }
}
