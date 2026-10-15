package Z7;

import B0.N;
import S7.C;
import X7.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5624h = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5625i = AtomicLongFieldUpdater.newUpdater(a.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final N f5626k = new N(7, "NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5629c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f5631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f5632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q<C0085a> f5633g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: Z7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class C0085a extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f5634i = AtomicIntegerFieldUpdater.newUpdater(C0085a.class, "workerCtl$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f5635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y<g> f5636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f5637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5640f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5641g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        public C0085a() {
            throw null;
        }

        public C0085a(int i9) {
            setDaemon(true);
            setContextClassLoader(a.this.getClass().getClassLoader());
            this.f5635a = new k();
            this.f5636b = new y<>();
            this.f5637c = b.f5646d;
            this.nextParkedWorker = a.f5626k;
            int iNanoTime = (int) System.nanoTime();
            this.f5640f = iNanoTime == 0 ? 42 : iNanoTime;
            g(i9);
        }

        public final g a(boolean z8) {
            g gVarF;
            g gVarF2;
            a aVar;
            long j;
            b bVar = this.f5637c;
            b bVar2 = b.f5643a;
            g gVar = null;
            k kVar = this.f5635a;
            a aVar2 = a.this;
            if (bVar != bVar2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = a.f5625i;
                do {
                    aVar = a.this;
                    j = atomicLongFieldUpdater.get(aVar);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        kVar.getClass();
                        loop1: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.f5664b;
                            g gVar2 = (g) atomicReferenceFieldUpdater.get(kVar);
                            if (gVar2 == null || !gVar2.f5655b) {
                                int i9 = k.f5666d.get(kVar);
                                int i10 = k.f5665c.get(kVar);
                                while (i9 != i10 && k.f5667e.get(kVar) != 0) {
                                    i10--;
                                    g gVarB = kVar.b(i10, true);
                                    if (gVarB != null) {
                                        gVar = gVarB;
                                        break;
                                    }
                                }
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(kVar, gVar2, null)) {
                                    gVar = gVar2;
                                    break loop1;
                                }
                            } while (atomicReferenceFieldUpdater.get(kVar) == gVar2);
                        }
                        if (gVar != null) {
                            return gVar;
                        }
                        g gVarD = aVar2.f5632f.d();
                        return gVarD == null ? j(1) : gVarD;
                    }
                } while (!a.f5625i.compareAndSet(aVar, j, j - 4398046511104L));
                this.f5637c = b.f5643a;
            }
            if (z8) {
                boolean z9 = e(aVar2.f5627a * 2) == 0;
                if (z9 && (gVarF2 = f()) != null) {
                    return gVarF2;
                }
                kVar.getClass();
                g gVarA = (g) k.f5664b.getAndSet(kVar, null);
                if (gVarA == null) {
                    gVarA = kVar.a();
                }
                if (gVarA != null) {
                    return gVarA;
                }
                if (!z9 && (gVarF = f()) != null) {
                    return gVarF;
                }
            } else {
                g gVarF3 = f();
                if (gVarF3 != null) {
                    return gVarF3;
                }
            }
            return j(3);
        }

        public final int c() {
            return this.indexInArray;
        }

        public final Object d() {
            return this.nextParkedWorker;
        }

        public final int e(int i9) {
            int i10 = this.f5640f;
            int i11 = i10 ^ (i10 << 13);
            int i12 = i11 ^ (i11 >> 17);
            int i13 = i12 ^ (i12 << 5);
            this.f5640f = i13;
            int i14 = i9 - 1;
            return (i14 & i9) == 0 ? i13 & i14 : (i13 & Integer.MAX_VALUE) % i9;
        }

        public final g f() {
            int iE = e(2);
            a aVar = a.this;
            if (iE == 0) {
                g gVarD = aVar.f5631e.d();
                return gVarD != null ? gVarD : aVar.f5632f.d();
            }
            g gVarD2 = aVar.f5632f.d();
            return gVarD2 != null ? gVarD2 : aVar.f5631e.d();
        }

        public final void g(int i9) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f5630d);
            sb.append("-worker-");
            sb.append(i9 == 0 ? "TERMINATED" : String.valueOf(i9));
            setName(sb.toString());
            this.indexInArray = i9;
        }

        public final void h(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean i(b bVar) {
            b bVar2 = this.f5637c;
            boolean z8 = bVar2 == b.f5643a;
            if (z8) {
                a.f5625i.addAndGet(a.this, 4398046511104L);
            }
            if (bVar2 != bVar) {
                this.f5637c = bVar;
            }
            return z8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1, types: [T, Z7.g, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v14, types: [Z7.g] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5, types: [Z7.g] */
        public final g j(int i9) {
            int i10;
            long j;
            T tB;
            long j8;
            long j9;
            T t;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f5625i;
            a aVar = a.this;
            int i11 = (int) (atomicLongFieldUpdater.get(aVar) & 2097151);
            Object obj = null;
            if (i11 < 2) {
                return null;
            }
            int iE = e(i11);
            int i12 = 0;
            long jMin = Long.MAX_VALUE;
            while (i12 < i11) {
                int i13 = iE + 1;
                if (i13 > i11) {
                    i13 = 1;
                }
                C0085a c0085aB = aVar.f5633g.b(i13);
                if (c0085aB == null || c0085aB == this) {
                    i10 = i13;
                } else {
                    k kVar = c0085aB.f5635a;
                    if (i9 != 3) {
                        kVar.getClass();
                        int i14 = k.f5666d.get(kVar);
                        int i15 = k.f5665c.get(kVar);
                        boolean z8 = i9 == 1;
                        while (true) {
                            if (i14 != i15) {
                                j = 0;
                                if (!z8 || k.f5667e.get(kVar) != 0) {
                                    int i16 = i14 + 1;
                                    tB = kVar.b(i14, z8);
                                    if (tB != 0) {
                                        break;
                                    }
                                    i14 = i16;
                                }
                            } else {
                                j = 0;
                            }
                            tB = obj;
                            break;
                        }
                    } else {
                        tB = kVar.a();
                        j = 0;
                    }
                    y<g> yVar = this.f5636b;
                    Object obj2 = obj;
                    if (tB == 0) {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.f5664b;
                            ?? r14 = (g) atomicReferenceFieldUpdater.get(kVar);
                            if (r14 == 0) {
                                j8 = -1;
                            } else {
                                j8 = -1;
                                if (((r14.f5655b ? 1 : 2) & i9) != 0) {
                                    i.f5662f.getClass();
                                    i10 = i13;
                                    long jNanoTime = System.nanoTime() - r14.f5654a;
                                    long j10 = i.f5658b;
                                    if (jNanoTime < j10) {
                                        j9 = j10 - jNanoTime;
                                        t = 0;
                                        break;
                                    }
                                    do {
                                        t = 0;
                                        if (atomicReferenceFieldUpdater.compareAndSet(kVar, r14, null)) {
                                            yVar.f20008a = r14;
                                            j9 = -1;
                                            break;
                                        }
                                    } while (atomicReferenceFieldUpdater.get(kVar) == r14);
                                    i13 = i10;
                                    obj2 = null;
                                }
                            }
                            j9 = -2;
                            i10 = i13;
                            t = obj2;
                            break;
                        }
                    } else {
                        yVar.f20008a = tB;
                        i10 = i13;
                        j9 = -1;
                        j8 = -1;
                        t = obj;
                    }
                    if (j9 == j8) {
                        g gVar = yVar.f20008a;
                        yVar.f20008a = t;
                        return gVar;
                    }
                    if (j9 > j) {
                        jMin = Math.min(jMin, j9);
                    }
                }
                i12++;
                iE = i10;
                obj = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f5639e = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AtomicLongFieldUpdater atomicLongFieldUpdater;
            long j;
            int i9;
            loop0: while (true) {
                boolean z8 = false;
                while (true) {
                    a aVar = a.this;
                    aVar.getClass();
                    if (a.j.get(aVar) == 0) {
                        b bVar = this.f5637c;
                        b bVar2 = b.f5647e;
                        if (bVar == bVar2) {
                            break loop0;
                        }
                        g gVarA = a(this.f5641g);
                        if (gVarA == null) {
                            this.f5641g = false;
                            if (this.f5639e == 0) {
                                Object obj = this.nextParkedWorker;
                                N n8 = a.f5626k;
                                long j8 = 2097151;
                                if (obj != n8) {
                                    f5634i.set(this, -1);
                                    while (this.nextParkedWorker != a.f5626k) {
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5634i;
                                        if (atomicIntegerFieldUpdater.get(this) != -1) {
                                            break;
                                        }
                                        a aVar2 = a.this;
                                        aVar2.getClass();
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = a.j;
                                        if (atomicIntegerFieldUpdater2.get(aVar2) != 0) {
                                            break;
                                        }
                                        b bVar3 = this.f5637c;
                                        b bVar4 = b.f5647e;
                                        if (bVar3 == bVar4) {
                                            break;
                                        }
                                        i(b.f5645c);
                                        Thread.interrupted();
                                        if (this.f5638d == 0) {
                                            this.f5638d = System.nanoTime() + a.this.f5629c;
                                        }
                                        LockSupport.parkNanos(a.this.f5629c);
                                        if (System.nanoTime() - this.f5638d >= 0) {
                                            this.f5638d = 0L;
                                            a aVar3 = a.this;
                                            synchronized (aVar3.f5633g) {
                                                try {
                                                    if (!(atomicIntegerFieldUpdater2.get(aVar3) != 0)) {
                                                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = a.f5625i;
                                                        if (((int) (atomicLongFieldUpdater2.get(aVar3) & j8)) > aVar3.f5627a) {
                                                            if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                                int i10 = this.indexInArray;
                                                                g(0);
                                                                aVar3.d(this, i10, 0);
                                                                int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(aVar3) & j8);
                                                                if (andDecrement != i10) {
                                                                    C0085a c0085aB = aVar3.f5633g.b(andDecrement);
                                                                    kotlin.jvm.internal.k.b(c0085aB);
                                                                    C0085a c0085a = c0085aB;
                                                                    aVar3.f5633g.c(i10, c0085a);
                                                                    c0085a.g(i10);
                                                                    aVar3.d(c0085a, andDecrement, i10);
                                                                }
                                                                aVar3.f5633g.c(andDecrement, null);
                                                                p188x7.k kVar = p188x7.k.f22364a;
                                                                this.f5637c = bVar4;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    throw th;
                                                }
                                            }
                                        }
                                        j8 = j8;
                                    }
                                } else {
                                    a aVar4 = a.this;
                                    aVar4.getClass();
                                    if (this.nextParkedWorker == n8) {
                                        do {
                                            atomicLongFieldUpdater = a.f5624h;
                                            j = atomicLongFieldUpdater.get(aVar4);
                                            i9 = this.indexInArray;
                                            this.nextParkedWorker = aVar4.f5633g.b((int) (j & 2097151));
                                        } while (!atomicLongFieldUpdater.compareAndSet(aVar4, j, ((2097152 + j) & (-2097152)) | ((long) i9)));
                                    }
                                }
                            } else {
                                if (z8) {
                                    i(b.f5645c);
                                    Thread.interrupted();
                                    LockSupport.parkNanos(this.f5639e);
                                    this.f5639e = 0L;
                                    break;
                                }
                                z8 = true;
                            }
                        } else {
                            this.f5639e = 0L;
                            this.f5638d = 0L;
                            if (this.f5637c == b.f5645c) {
                                this.f5637c = b.f5644b;
                            }
                            boolean z9 = gVarA.f5655b;
                            a aVar5 = a.this;
                            if (!z9) {
                                aVar5.getClass();
                                try {
                                    gVarA.run();
                                    break;
                                } catch (Throwable th2) {
                                    Thread threadCurrentThread = Thread.currentThread();
                                    threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                                    break;
                                }
                            }
                            if (i(b.f5644b) && !aVar5.g() && !aVar5.f(a.f5625i.get(aVar5))) {
                                aVar5.g();
                            }
                            aVar5.getClass();
                            try {
                                gVarA.run();
                            } catch (Throwable th3) {
                                Thread threadCurrentThread2 = Thread.currentThread();
                                threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th3);
                            }
                            a.f5625i.addAndGet(aVar5, -2097152L);
                            if (this.f5637c == bVar2) {
                                break;
                            }
                            this.f5637c = b.f5646d;
                            break;
                        }
                    } else {
                        break loop0;
                    }
                }
            }
            i(b.f5647e);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f5644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f5645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f5646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f5647e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ b[] f5648f;

        static {
            b bVar = new b("CPU_ACQUIRED", 0);
            f5643a = bVar;
            b bVar2 = new b("BLOCKING", 1);
            f5644b = bVar2;
            b bVar3 = new b("PARKING", 2);
            f5645c = bVar3;
            b bVar4 = new b("DORMANT", 3);
            f5646d = bVar4;
            b bVar5 = new b("TERMINATED", 4);
            f5647e = bVar5;
            f5648f = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
        }

        public b() {
            throw null;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f5648f.clone();
        }
    }

    public a(int i9, int i10, long j8, String str) {
        this.f5627a = i9;
        this.f5628b = i10;
        this.f5629c = j8;
        this.f5630d = str;
        if (i9 < 1) {
            throw new IllegalArgumentException(defpackage.f.b(i9, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i9) {
            throw new IllegalArgumentException(W5.e.h(i10, i9, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(defpackage.f.b(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j8 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j8 + " must be positive").toString());
        }
        this.f5631e = new d();
        this.f5632f = new d();
        this.f5633g = new q<>((i9 + 1) * 2);
        this.controlState$volatile = ((long) i9) << 42;
        this._isTerminated$volatile = 0;
    }

    public final int a() {
        synchronized (this.f5633g) {
            try {
                if (j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f5625i;
                long j8 = atomicLongFieldUpdater.get(this);
                int i9 = (int) (j8 & 2097151);
                int i10 = i9 - ((int) ((j8 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f5627a) {
                    return 0;
                }
                if (i9 >= this.f5628b) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f5633g.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                C0085a c0085a = new C0085a(i11);
                this.f5633g.c(i11, c0085a);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                c0085a.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z8) {
        g hVar;
        b bVar;
        AtomicReferenceArray<g> atomicReferenceArray;
        i.f5662f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof g) {
            hVar = (g) runnable;
            hVar.f5654a = jNanoTime;
            hVar.f5655b = z8;
        } else {
            hVar = new h(runnable, jNanoTime, z8);
        }
        boolean z9 = hVar.f5655b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5625i;
        long jAddAndGet = z9 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        C0085a c0085a = threadCurrentThread instanceof C0085a ? (C0085a) threadCurrentThread : null;
        if (c0085a == null || !kotlin.jvm.internal.k.a(a.this, this)) {
            c0085a = null;
        }
        if (c0085a != null && (bVar = c0085a.f5637c) != b.f5647e && (hVar.f5655b || bVar != b.f5644b)) {
            c0085a.f5641g = true;
            k kVar = c0085a.f5635a;
            kVar.getClass();
            hVar = (g) k.f5664b.getAndSet(kVar, hVar);
            if (hVar == null) {
                hVar = null;
            } else {
                kVar.getClass();
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k.f5665c;
                if (atomicIntegerFieldUpdater.get(kVar) - k.f5666d.get(kVar) != 127) {
                    if (hVar.f5655b) {
                        k.f5667e.incrementAndGet(kVar);
                    }
                    int i9 = atomicIntegerFieldUpdater.get(kVar) & 127;
                    while (true) {
                        atomicReferenceArray = kVar.f5668a;
                        if (atomicReferenceArray.get(i9) == null) {
                            break;
                        } else {
                            Thread.yield();
                        }
                    }
                    atomicReferenceArray.lazySet(i9, hVar);
                    atomicIntegerFieldUpdater.incrementAndGet(kVar);
                    hVar = null;
                }
            }
        }
        if (hVar != null) {
            if (!(hVar.f5655b ? this.f5632f.a(hVar) : this.f5631e.a(hVar))) {
                throw new RejectedExecutionException(A.a.j(new StringBuilder(), this.f5630d, " was terminated"));
            }
        }
        if (z9) {
            if (g() || f(jAddAndGet)) {
                return;
            }
            g();
            return;
        }
        if (g() || f(atomicLongFieldUpdater.get(this))) {
            return;
        }
        g();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i9;
        g gVarD;
        if (j.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            C0085a c0085a = threadCurrentThread instanceof C0085a ? (C0085a) threadCurrentThread : null;
            if (c0085a == null || !kotlin.jvm.internal.k.a(a.this, this)) {
                c0085a = null;
            }
            synchronized (this.f5633g) {
                i9 = (int) (f5625i.get(this) & 2097151);
            }
            if (1 <= i9) {
                int i10 = 1;
                while (true) {
                    C0085a c0085aB = this.f5633g.b(i10);
                    kotlin.jvm.internal.k.b(c0085aB);
                    C0085a c0085a2 = c0085aB;
                    if (c0085a2 != c0085a) {
                        while (c0085a2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(c0085a2);
                            c0085a2.join(10000L);
                        }
                        k kVar = c0085a2.f5635a;
                        d dVar = this.f5632f;
                        kVar.getClass();
                        g gVar = (g) k.f5664b.getAndSet(kVar, null);
                        if (gVar != null) {
                            dVar.a(gVar);
                        }
                        while (true) {
                            g gVarA = kVar.a();
                            if (gVarA == null) {
                                break;
                            } else {
                                dVar.a(gVarA);
                            }
                        }
                    }
                    if (i10 == i9) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.f5632f.b();
            this.f5631e.b();
            while (true) {
                if (c0085a != null) {
                    gVarD = c0085a.a(true);
                    if (gVarD == null) {
                        gVarD = this.f5631e.d();
                        if (gVarD == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    gVarD = this.f5631e.d();
                    if (gVarD == null && (gVarD = this.f5632f.d()) == null) {
                        break;
                    }
                }
                try {
                    gVarD.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (c0085a != null) {
                c0085a.i(b.f5647e);
            }
            f5624h.set(this, 0L);
            f5625i.set(this, 0L);
        }
    }

    public final void d(C0085a c0085a, int i9, int i10) {
        while (true) {
            long j8 = f5624h.get(this);
            int i11 = (int) (2097151 & j8);
            long j9 = (2097152 + j8) & (-2097152);
            if (i11 == i9) {
                if (i10 == 0) {
                    Object objD = c0085a.d();
                    while (true) {
                        if (objD == f5626k) {
                            i11 = -1;
                            break;
                        }
                        if (objD == null) {
                            i11 = 0;
                            break;
                        }
                        C0085a c0085a2 = (C0085a) objD;
                        int iC = c0085a2.c();
                        if (iC != 0) {
                            i11 = iC;
                            break;
                        }
                        objD = c0085a2.d();
                    }
                } else {
                    i11 = i10;
                }
            }
            if (i11 >= 0) {
                if (f5624h.compareAndSet(this, j8, ((long) i11) | j9)) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, false);
    }

    public final boolean f(long j8) {
        int i9 = ((int) (2097151 & j8)) - ((int) ((j8 & 4398044413952L) >> 21));
        if (i9 < 0) {
            i9 = 0;
        }
        int i10 = this.f5627a;
        if (i9 < i10) {
            int iA = a();
            if (iA == 1 && i10 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        N n8;
        int iC;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5624h;
            long j8 = atomicLongFieldUpdater.get(this);
            C0085a c0085aB = this.f5633g.b((int) (2097151 & j8));
            if (c0085aB == null) {
                c0085aB = null;
            } else {
                long j9 = (2097152 + j8) & (-2097152);
                Object objD = c0085aB.d();
                while (true) {
                    n8 = f5626k;
                    if (objD == n8) {
                        iC = -1;
                        break;
                    }
                    if (objD == null) {
                        iC = 0;
                        break;
                    }
                    C0085a c0085a = (C0085a) objD;
                    iC = c0085a.c();
                    if (iC != 0) {
                        break;
                    }
                    objD = c0085a.d();
                }
                if (iC >= 0 && atomicLongFieldUpdater.compareAndSet(this, j8, j9 | ((long) iC))) {
                    c0085aB.h(n8);
                }
            }
            if (c0085aB == null) {
                return false;
            }
            if (C0085a.f5634i.compareAndSet(c0085aB, -1, 0)) {
                LockSupport.unpark(c0085aB);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        q<C0085a> qVar = this.f5633g;
        int iA = qVar.a();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iA; i14++) {
            C0085a c0085aB = qVar.b(i14);
            if (c0085aB != null) {
                k kVar = c0085aB.f5635a;
                kVar.getClass();
                int i15 = k.f5664b.get(kVar) != null ? (k.f5665c.get(kVar) - k.f5666d.get(kVar)) + 1 : k.f5665c.get(kVar) - k.f5666d.get(kVar);
                int iOrdinal = c0085aB.f5637c.ordinal();
                if (iOrdinal == 0) {
                    i9++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i11++;
                } else if (iOrdinal == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i15);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new L4.b();
                    }
                    i13++;
                }
            }
        }
        long j8 = f5625i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f5630d);
        sb4.append('@');
        sb4.append(C.a(this));
        sb4.append("[Pool Size {core = ");
        int i16 = this.f5627a;
        sb4.append(i16);
        sb4.append(", max = ");
        sb4.append(this.f5628b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i9);
        sb4.append(", blocking = ");
        sb4.append(i10);
        sb4.append(", parked = ");
        sb4.append(i11);
        sb4.append(", dormant = ");
        sb4.append(i12);
        sb4.append(", terminated = ");
        sb4.append(i13);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f5631e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f5632f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j8));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j8) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i16 - ((int) ((j8 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
