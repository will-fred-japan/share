package p133r2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.apm.insight.MonitorCrash;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import p061i1.h;

/* JADX INFO: compiled from: ThreadWithHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f21117f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f21118g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f21120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f21121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f21122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f21123e;

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class a {
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class b {
    }

    /* JADX INFO: renamed from: r2.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class RunnableC0250c implements Runnable {
        public RunnableC0250c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!c.this.f21121c.isEmpty()) {
                synchronized (c.this.f21123e) {
                    try {
                        if (c.this.f21122d != null) {
                            c.this.f21122d.sendMessageAtFrontOfQueue((Message) c.this.f21121c.poll());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            while (!c.this.f21120b.isEmpty()) {
                synchronized (c.this.f21123e) {
                    try {
                        e eVar = (e) c.this.f21120b.poll();
                        if (c.this.f21122d != null) {
                            c.this.f21122d.sendMessageAtTime(eVar.f21126a, eVar.f21127b);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f21126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21127b;
    }

    public c() {
        this.f21120b = new ConcurrentLinkedQueue();
        this.f21121c = new ConcurrentLinkedQueue();
        this.f21123e = new Object();
        this.f21119a = new d(0);
    }

    public final void a(Runnable runnable) {
        Message message;
        if (!this.f21120b.isEmpty() || !this.f21121c.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.f21120b;
            a aVar = f21117f;
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                aVar.getClass();
                e eVar = (e) next;
                if ((eVar == null || (message = eVar.f21126a) == null || !runnable.equals(message.getCallback())) ? false : true) {
                    it.remove();
                }
            }
            ConcurrentLinkedQueue concurrentLinkedQueue2 = this.f21121c;
            b bVar = f21118g;
            Iterator it2 = concurrentLinkedQueue2.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                bVar.getClass();
                Message message2 = (Message) next2;
                if (message2 != null && runnable.equals(message2.getCallback())) {
                    it2.remove();
                }
            }
        }
        if (this.f21122d != null) {
            this.f21122d.removeCallbacks(runnable);
        }
    }

    public final void b(Runnable runnable, long j) {
        c(Message.obtain(this.f21122d, runnable), j);
    }

    public final boolean c(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j;
        if (this.f21122d == null) {
            synchronized (this.f21123e) {
                try {
                    if (this.f21122d == null) {
                        ConcurrentLinkedQueue concurrentLinkedQueue = this.f21120b;
                        e eVar = new e();
                        eVar.f21126a = message;
                        eVar.f21127b = jUptimeMillis;
                        concurrentLinkedQueue.add(eVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f21122d.sendMessageAtTime(message, jUptimeMillis);
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class d extends HandlerThread {
        public d() {
            super("AsyncEventManager-Thread");
        }

        /* JADX INFO: Infinite loop detected, blocks: 16, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (c.this.f21123e) {
                try {
                    c.this.f21122d = new Handler();
                } catch (Throwable th) {
                    throw th;
                }
            }
            c.this.f21122d.post(c.this.new RunnableC0250c());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    try {
                        MonitorCrash monitorCrash = h.f19251y;
                        if (monitorCrash != null) {
                            monitorCrash.reportCustomErr("", "apm_error", th2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        public d(int i9) {
            super("caton_dump_stack", 10);
        }
    }

    public c(int i9) {
        this.f21120b = new ConcurrentLinkedQueue();
        this.f21121c = new ConcurrentLinkedQueue();
        this.f21123e = new Object();
        this.f21119a = new d();
    }
}
