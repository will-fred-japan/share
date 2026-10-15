package p152t4;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import p011b4.i;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f21463f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f21464g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f21465a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f21468d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f21466b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f21467c = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f21469e = new Object();

    public static class a implements d<f, Runnable> {
        @Override // t4.q.d
        public final boolean a(Runnable runnable, Object obj) {
            Message message;
            f fVar = (f) obj;
            return (fVar == null || (message = fVar.f21474a) == null || !runnable.equals(message.getCallback())) ? false : true;
        }
    }

    public static class b implements d<Message, Runnable> {
        @Override // t4.q.d
        public final boolean a(Runnable runnable, Object obj) {
            Message message = (Message) obj;
            return message != null && runnable.equals(message.getCallback());
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!q.this.f21467c.isEmpty()) {
                if (q.this.f21468d != null) {
                    try {
                        q.this.f21468d.sendMessageAtFrontOfQueue((Message) q.this.f21467c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!q.this.f21466b.isEmpty()) {
                f fVar = (f) q.this.f21466b.poll();
                if (q.this.f21468d != null) {
                    try {
                        q.this.f21468d.sendMessageAtTime(fVar.f21474a, fVar.f21475b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public interface d<A, B> {
        boolean a(Runnable runnable, Object obj);
    }

    public class e extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f21471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f21472b;

        public e(String str) {
            super(str);
            this.f21471a = 0;
            this.f21472b = false;
        }

        /* JADX INFO: Infinite loop detected, blocks: 29, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            p011b4.d dVar;
            super.onLooperPrepared();
            synchronized (q.this.f21469e) {
                try {
                    q.this.f21468d = new Handler();
                } catch (Throwable th) {
                    throw th;
                }
            }
            q.this.f21468d.post(q.this.new c());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    try {
                        if (i.f8546b != null && i.f8546b.f8548a != null && (dVar = i.f8546b.f8548a.f8500a) != null && !dVar.f8529b) {
                            l.a().b(dVar.f8530c, com.heytap.mcssdk.constant.a.f14256r);
                        }
                        if (this.f21471a < 5) {
                            int i9 = com.apm.insight.b.f11841a;
                            p027d5.a.k("NPTH_CATCH", th2);
                        } else if (!this.f21472b) {
                            this.f21472b = true;
                            int i10 = com.apm.insight.b.f11841a;
                            p027d5.a.k("NPTH_ERR_MAX", new RuntimeException());
                        }
                        this.f21471a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f21474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21475b;
    }

    public q(String str) {
        this.f21465a = new e(str);
    }

    public static void c(ConcurrentLinkedQueue concurrentLinkedQueue, Runnable runnable, d dVar) {
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        try {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (dVar.a(runnable, it.next())) {
                    it.remove();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Runnable runnable) {
        d(Message.obtain(this.f21468d, runnable), 0L);
    }

    public final void b(Runnable runnable, long j) {
        d(Message.obtain(this.f21468d, runnable), j);
    }

    public final boolean d(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j;
        if (this.f21468d == null) {
            synchronized (this.f21469e) {
                try {
                    if (this.f21468d == null) {
                        ConcurrentLinkedQueue concurrentLinkedQueue = this.f21466b;
                        f fVar = new f();
                        fVar.f21474a = message;
                        fVar.f21475b = jUptimeMillis;
                        concurrentLinkedQueue.add(fVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        try {
            return this.f21468d.sendMessageAtTime(message, jUptimeMillis);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void e(Runnable runnable) {
        if (!this.f21466b.isEmpty() || !this.f21467c.isEmpty()) {
            c(this.f21466b, runnable, f21463f);
            c(this.f21467c, runnable, f21464g);
        }
        if (this.f21468d != null) {
            this.f21468d.removeCallbacks(runnable);
        }
    }
}
