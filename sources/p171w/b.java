package p171w;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: AbstractResolvableFuture.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<V> implements Future {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f21942d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f21943e = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f21944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f21945g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f21946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f21947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f21948c;

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static abstract class a {
        public abstract boolean a(b bVar, d dVar);

        public abstract boolean b(b<?> bVar, Object obj, Object obj2);

        public abstract boolean c(b<?> bVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* JADX INFO: renamed from: w.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class C0275b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0275b f21949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0275b f21950c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CancellationException f21951a;

        static {
            if (b.f21942d) {
                f21950c = null;
                f21949b = null;
            } else {
                f21950c = new C0275b(false, null);
                f21949b = new C0275b(true, null);
            }
        }

        public C0275b(boolean z8, CancellationException cancellationException) {
            this.f21951a = cancellationException;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f21952a;

        /* JADX INFO: compiled from: AbstractResolvableFuture.java */
        public class a extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new c(new a("Failure occurred while trying to finish a future."));
        }

        public c(Throwable th) {
            boolean z8 = b.f21942d;
            th.getClass();
            this.f21952a = th;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f21953b = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f21954a;
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f21955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f21956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, h> f21957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, d> f21958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, Object> f21959e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            this.f21955a = atomicReferenceFieldUpdater;
            this.f21956b = atomicReferenceFieldUpdater2;
            this.f21957c = atomicReferenceFieldUpdater3;
            this.f21958d = atomicReferenceFieldUpdater4;
            this.f21959e = atomicReferenceFieldUpdater5;
        }

        @Override // w.b.a
        public final boolean a(b bVar, d dVar) {
            AtomicReferenceFieldUpdater<b, d> atomicReferenceFieldUpdater;
            d dVar2 = d.f21953b;
            do {
                atomicReferenceFieldUpdater = this.f21958d;
                if (atomicReferenceFieldUpdater.compareAndSet(bVar, dVar, dVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(bVar) == dVar);
            return false;
        }

        @Override // w.b.a
        public final boolean b(b<?> bVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f21959e;
                if (atomicReferenceFieldUpdater.compareAndSet(bVar, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(bVar) == obj);
            return false;
        }

        @Override // w.b.a
        public final boolean c(b<?> bVar, h hVar, h hVar2) {
            AtomicReferenceFieldUpdater<b, h> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f21957c;
                if (atomicReferenceFieldUpdater.compareAndSet(bVar, hVar, hVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(bVar) == hVar);
            return false;
        }

        @Override // w.b.a
        public final void d(h hVar, h hVar2) {
            this.f21956b.lazySet(hVar, hVar2);
        }

        @Override // w.b.a
        public final void e(h hVar, Thread thread) {
            this.f21955a.lazySet(hVar, thread);
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class f<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class g extends a {
        @Override // w.b.a
        public final boolean a(b bVar, d dVar) {
            d dVar2 = d.f21953b;
            synchronized (bVar) {
                try {
                    if (bVar.f21947b != dVar) {
                        return false;
                    }
                    bVar.f21947b = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // w.b.a
        public final boolean b(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                try {
                    if (bVar.f21946a != obj) {
                        return false;
                    }
                    bVar.f21946a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // w.b.a
        public final boolean c(b<?> bVar, h hVar, h hVar2) {
            synchronized (bVar) {
                try {
                    if (bVar.f21948c != hVar) {
                        return false;
                    }
                    bVar.f21948c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // w.b.a
        public final void d(h hVar, h hVar2) {
            hVar.f21962b = hVar2;
        }

        @Override // w.b.a
        public final void e(h hVar, Thread thread) {
            hVar.f21961a = thread;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f21960c = new h();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f21961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f21962b;

        public h() {
            b.f21944f.e(this, Thread.currentThread());
        }
    }

    static {
        a gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(b.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(b.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f21944f = gVar;
        if (th != null) {
            f21943e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f21945g = new Object();
    }

    public static void b(b<?> bVar) {
        h hVar;
        d dVar;
        do {
            hVar = bVar.f21948c;
        } while (!f21944f.c(bVar, hVar, h.f21960c));
        while (hVar != null) {
            Thread thread = hVar.f21961a;
            if (thread != null) {
                hVar.f21961a = null;
                LockSupport.unpark(thread);
            }
            hVar = hVar.f21962b;
        }
        do {
            dVar = bVar.f21947b;
        } while (!f21944f.a(bVar, dVar));
        d dVar2 = null;
        while (dVar != null) {
            d dVar3 = dVar.f21954a;
            dVar.f21954a = dVar2;
            dVar2 = dVar;
            dVar = dVar3;
        }
        while (dVar2 != null) {
            dVar2 = dVar2.f21954a;
            try {
                throw null;
            } catch (RuntimeException e9) {
                f21943e.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e9);
            }
        }
    }

    public static Object c(Object obj) throws ExecutionException {
        if (obj instanceof C0275b) {
            CancellationException cancellationException = ((C0275b) obj).f21951a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f21952a);
        }
        if (obj == f21945g) {
            return null;
        }
        return obj;
    }

    public static Object d(b bVar) {
        Object obj;
        boolean z8 = false;
        while (true) {
            try {
                obj = bVar.get();
                break;
            } catch (InterruptedException unused) {
                z8 = true;
            } catch (Throwable th) {
                if (z8) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z8) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objD = d(this);
            sb.append("SUCCESS, result=[");
            sb.append(objD == this ? "this future" : String.valueOf(objD));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e9) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e9.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z8) {
        C0275b c0275b;
        Object obj = this.f21946a;
        if ((obj == null) | (obj instanceof f)) {
            if (f21942d) {
                c0275b = new C0275b(z8, new CancellationException("Future.cancel() was called."));
            } else {
                c0275b = z8 ? C0275b.f21949b : C0275b.f21950c;
            }
            while (!f21944f.b(this, obj, c0275b)) {
                obj = this.f21946a;
                if (!(obj instanceof f)) {
                }
            }
            b(this);
            if (!(obj instanceof f)) {
                return true;
            }
            ((f) obj).getClass();
            throw null;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String e() {
        Object obj = this.f21946a;
        if (obj instanceof f) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ((f) obj).getClass();
            sb.append("null");
            sb.append("]");
            return sb.toString();
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void f(h hVar) {
        hVar.f21961a = null;
        while (true) {
            h hVar2 = this.f21948c;
            if (hVar2 == h.f21960c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f21962b;
                if (hVar2.f21961a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f21962b = hVar4;
                    if (hVar3.f21961a == null) {
                    }
                } else if (!f21944f.c(this, hVar2, hVar4)) {
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z8;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f21946a;
        if ((obj != null) && (!(obj instanceof f))) {
            return (V) c(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f21948c;
            h hVar2 = h.f21960c;
            if (hVar != hVar2) {
                h hVar3 = new h();
                z8 = true;
                while (true) {
                    a aVar = f21944f;
                    aVar.d(hVar3, hVar);
                    if (aVar.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                f(hVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f21946a;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return (V) c(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        f(hVar3);
                        break;
                    }
                    hVar = this.f21948c;
                    if (hVar == hVar2) {
                    }
                }
            }
            return (V) c(this.f21946a);
        }
        z8 = true;
        while (nanos > 0) {
            Object obj3 = this.f21946a;
            if ((obj3 != null ? z8 : false) && (!(obj3 instanceof f))) {
                return (V) c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbH = defpackage.f.h(j, "Waited ", " ");
        sbH.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbH.toString();
        if (nanos + 1000 < 0) {
            String strU = W5.e.u(string3, " (plus ");
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z9 = (jConvert == 0 || nanos2 > 1000) ? z8 : false;
            if (jConvert > 0) {
                String strU2 = strU + jConvert + " " + lowerCase;
                if (z9) {
                    strU2 = W5.e.u(strU2, Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                strU = W5.e.u(strU2, " ");
            }
            if (z9) {
                strU = strU + nanos2 + " nanoseconds ";
            }
            string3 = W5.e.u(strU, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(W5.e.u(string3, " but future completed as timeout expired"));
        }
        throw new TimeoutException(p171w.a.a(string3, " for ", string));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f21946a instanceof C0275b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f21946a;
        return (!(obj instanceof f)) & (obj != null);
    }

    public final String toString() {
        String strE;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f21946a instanceof C0275b) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strE = e();
            } catch (RuntimeException e9) {
                strE = "Exception thrown from implementation: " + e9.getClass();
            }
            if (strE != null && !strE.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strE);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f21946a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return (V) c(obj2);
            }
            h hVar = this.f21948c;
            h hVar2 = h.f21960c;
            if (hVar != hVar2) {
                h hVar3 = new h();
                do {
                    a aVar = f21944f;
                    aVar.d(hVar3, hVar);
                    if (aVar.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f21946a;
                            } else {
                                f(hVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return (V) c(obj);
                    }
                    hVar = this.f21948c;
                } while (hVar != hVar2);
            }
            return (V) c(this.f21946a);
        }
        throw new InterruptedException();
    }
}
