package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f18387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f18388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f18389c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f1143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final c f1144a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f18390a;

        public a(c cVar) {
            this.f18390a = cVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.f18390a) {
                    this.f18390a.f18394c = true;
                    this.f18390a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f18391a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String f1145a;

        public b(int i9) {
            this.f18391a = i9;
        }

        public void a(String str) {
            this.f1145a = str;
        }
    }

    public static final class c extends Thread {

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f1148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f18394c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile long f18392a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private volatile boolean f1147a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f18393b = 50;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f1146a = new a();

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f18395a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private d[] f1149a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f18396b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f18397c;

            private a() {
                this.f18395a = 256;
                this.f1149a = new d[256];
                this.f18396b = 0;
                this.f18397c = 0;
            }

            private void c() {
                int i9 = this.f18396b;
                int i10 = i9 - 1;
                int i11 = (i9 - 2) / 2;
                while (true) {
                    d[] dVarArr = this.f1149a;
                    d dVar = dVarArr[i10];
                    long j = dVar.f1150a;
                    d dVar2 = dVarArr[i11];
                    if (j >= dVar2.f1150a) {
                        return;
                    }
                    dVarArr[i10] = dVar2;
                    dVarArr[i11] = dVar;
                    i10 = i11;
                    i11 = (i11 - 1) / 2;
                }
            }

            public void b(int i9) {
                int i10;
                if (i9 < 0 || i9 >= (i10 = this.f18396b)) {
                    return;
                }
                d[] dVarArr = this.f1149a;
                int i11 = i10 - 1;
                this.f18396b = i11;
                dVarArr[i9] = dVarArr[i11];
                dVarArr[i11] = null;
                c(i9);
            }

            public d a() {
                return this.f1149a[0];
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m822a() {
                return this.f18396b == 0;
            }

            public void b() {
                int i9 = 0;
                while (i9 < this.f18396b) {
                    if (this.f1149a[i9].f1153a) {
                        this.f18397c++;
                        b(i9);
                        i9--;
                    }
                    i9++;
                }
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m821a(d dVar) {
                d[] dVarArr = this.f1149a;
                int length = dVarArr.length;
                int i9 = this.f18396b;
                if (length == i9) {
                    d[] dVarArr2 = new d[i9 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i9);
                    this.f1149a = dVarArr2;
                }
                d[] dVarArr3 = this.f1149a;
                int i10 = this.f18396b;
                this.f18396b = i10 + 1;
                dVarArr3[i10] = dVar;
                c();
            }

            private void c(int i9) {
                int i10 = (i9 * 2) + 1;
                while (true) {
                    int i11 = this.f18396b;
                    if (i10 >= i11 || i11 <= 0) {
                        return;
                    }
                    int i12 = i10 + 1;
                    if (i12 < i11) {
                        d[] dVarArr = this.f1149a;
                        if (dVarArr[i12].f1150a < dVarArr[i10].f1150a) {
                            i10 = i12;
                        }
                    }
                    d[] dVarArr2 = this.f1149a;
                    d dVar = dVarArr2[i9];
                    long j = dVar.f1150a;
                    d dVar2 = dVarArr2[i10];
                    if (j < dVar2.f1150a) {
                        return;
                    }
                    dVarArr2[i9] = dVar2;
                    dVarArr2[i10] = dVar;
                    int i13 = i10;
                    i10 = (i10 * 2) + 1;
                    i9 = i13;
                }
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m823a(int i9) {
                for (int i10 = 0; i10 < this.f18396b; i10++) {
                    if (this.f1149a[i10].f18398a == i9) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i9) {
                for (int i10 = 0; i10 < this.f18396b; i10++) {
                    d dVar = this.f1149a[i10];
                    if (dVar.f18398a == i9) {
                        dVar.a();
                    }
                }
                b();
            }

            public void a(int i9, b bVar) {
                for (int i10 = 0; i10 < this.f18396b; i10++) {
                    d dVar = this.f1149a[i10];
                    if (dVar.f1151a == bVar) {
                        dVar.a();
                    }
                }
                b();
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m820a() {
                this.f1149a = new d[this.f18395a];
                this.f18396b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i9 = 0;
                while (true) {
                    d[] dVarArr = this.f1149a;
                    if (i9 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i9] == dVar) {
                        return i9;
                    }
                    i9++;
                }
            }
        }

        public c(String str, boolean z8) {
            setName(str);
            setDaemon(z8);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x009a, code lost:
        
            r10.f18392a = android.os.SystemClock.uptimeMillis();
            r10.f1147a = true;
            r2.f1151a.run();
            r10.f1147a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00ac, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ad, code lost:
        
            r10.f1148b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00b0, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r10 = this;
            L0:
                monitor-enter(r10)
                boolean r0 = r10.f1148b     // Catch: java.lang.Throwable -> L7
                if (r0 == 0) goto La
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                goto L17
            L7:
                r0 = move-exception
                goto Lb8
            La:
                com.xiaomi.push.service.s$c$a r0 = r10.f1146a     // Catch: java.lang.Throwable -> L7
                boolean r0 = r0.m822a()     // Catch: java.lang.Throwable -> L7
                if (r0 == 0) goto L1d
                boolean r0 = r10.f18394c     // Catch: java.lang.Throwable -> L7
                if (r0 == 0) goto L18
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
            L17:
                return
            L18:
                r10.wait()     // Catch: java.lang.Throwable -> L7 java.lang.InterruptedException -> L1b
            L1b:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                goto L0
            L1d:
                long r0 = com.xiaomi.push.service.s.a()     // Catch: java.lang.Throwable -> L7
                com.xiaomi.push.service.s$c$a r2 = r10.f1146a     // Catch: java.lang.Throwable -> L7
                com.xiaomi.push.service.s$d r2 = r2.a()     // Catch: java.lang.Throwable -> L7
                java.lang.Object r3 = r2.f1152a     // Catch: java.lang.Throwable -> L7
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L7
                boolean r4 = r2.f1153a     // Catch: java.lang.Throwable -> L37
                r5 = 0
                if (r4 == 0) goto L3a
                com.xiaomi.push.service.s$c$a r0 = r10.f1146a     // Catch: java.lang.Throwable -> L37
                r0.b(r5)     // Catch: java.lang.Throwable -> L37
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L37
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                goto L0
            L37:
                r0 = move-exception
                goto Lb6
            L3a:
                long r6 = r2.f1150a     // Catch: java.lang.Throwable -> L37
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L37
                r0 = 0
                int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                r8 = 50
                if (r3 <= 0) goto L5d
                long r0 = r10.f18393b     // Catch: java.lang.Throwable -> L7
                int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r2 <= 0) goto L4d
                r6 = r0
            L4d:
                long r0 = r0 + r8
                r10.f18393b = r0     // Catch: java.lang.Throwable -> L7
                r2 = 500(0x1f4, double:2.47E-321)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L58
                r10.f18393b = r2     // Catch: java.lang.Throwable -> L7
            L58:
                r10.wait(r6)     // Catch: java.lang.Throwable -> L7 java.lang.InterruptedException -> L5b
            L5b:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                goto L0
            L5d:
                r10.f18393b = r8     // Catch: java.lang.Throwable -> L7
                java.lang.Object r3 = r2.f1152a     // Catch: java.lang.Throwable -> L7
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L7
                com.xiaomi.push.service.s$c$a r4 = r10.f1146a     // Catch: java.lang.Throwable -> L77
                com.xiaomi.push.service.s$d r4 = r4.a()     // Catch: java.lang.Throwable -> L77
                long r6 = r4.f1150a     // Catch: java.lang.Throwable -> L77
                long r8 = r2.f1150a     // Catch: java.lang.Throwable -> L77
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L79
                com.xiaomi.push.service.s$c$a r4 = r10.f1146a     // Catch: java.lang.Throwable -> L77
                int r4 = com.xiaomi.push.service.s.c.a.a(r4, r2)     // Catch: java.lang.Throwable -> L77
                goto L7a
            L77:
                r0 = move-exception
                goto Lb4
            L79:
                r4 = r5
            L7a:
                boolean r6 = r2.f1153a     // Catch: java.lang.Throwable -> L77
                if (r6 == 0) goto L8b
                com.xiaomi.push.service.s$c$a r0 = r10.f1146a     // Catch: java.lang.Throwable -> L77
                int r1 = com.xiaomi.push.service.s.c.a.a(r0, r2)     // Catch: java.lang.Throwable -> L77
                r0.b(r1)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                goto L0
            L8b:
                long r6 = r2.f1150a     // Catch: java.lang.Throwable -> L77
                r2.a(r6)     // Catch: java.lang.Throwable -> L77
                com.xiaomi.push.service.s$c$a r6 = r10.f1146a     // Catch: java.lang.Throwable -> L77
                r6.b(r4)     // Catch: java.lang.Throwable -> L77
                r2.f1150a = r0     // Catch: java.lang.Throwable -> L77
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> Lab
                r10.f18392a = r3     // Catch: java.lang.Throwable -> Lab
                r10.f1147a = r0     // Catch: java.lang.Throwable -> Lab
                com.xiaomi.push.service.s$b r1 = r2.f1151a     // Catch: java.lang.Throwable -> Lab
                r1.run()     // Catch: java.lang.Throwable -> Lab
                r10.f1147a = r5     // Catch: java.lang.Throwable -> Lab
                goto L0
            Lab:
                r1 = move-exception
                monitor-enter(r10)
                r10.f1148b = r0     // Catch: java.lang.Throwable -> Lb1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb1
                throw r1
            Lb1:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb1
                throw r0
            Lb4:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L77
                throw r0     // Catch: java.lang.Throwable -> L7
            Lb6:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L37
                throw r0     // Catch: java.lang.Throwable -> L7
            Lb8:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L7
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.s.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f1146a.m821a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1148b = true;
            this.f1146a.m820a();
            notify();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m818a() {
            return this.f1147a && SystemClock.uptimeMillis() - this.f18392a > 600000;
        }
    }

    static {
        long jElapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f18387a = jElapsedRealtime;
        f18388b = jElapsedRealtime;
    }

    public s(String str, boolean z8) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z8);
        this.f1144a = cVar;
        this.f1143a = new a(cVar);
    }

    public static synchronized long a() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = f18388b;
            if (jElapsedRealtime > j) {
                f18387a = (jElapsedRealtime - j) + f18387a;
            }
            f18388b = jElapsedRealtime;
        } catch (Throwable th) {
            throw th;
        }
        return f18387a;
    }

    private static synchronized long b() {
        long j;
        j = f18389c;
        f18389c = 1 + j;
        return j;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m816b() {
        synchronized (this.f1144a) {
            this.f1144a.f1146a.m820a();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18398a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        long f1150a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        b f1151a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final Object f1152a = new Object();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f18399b;

        public void a(long j) {
            synchronized (this.f1152a) {
                this.f18399b = j;
            }
        }

        public boolean a() {
            boolean z8;
            synchronized (this.f1152a) {
                try {
                    z8 = !this.f1153a && this.f1150a > 0;
                    this.f1153a = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z8;
        }
    }

    public s(String str) {
        this(str, false);
    }

    public void b(b bVar) {
        try {
            Thread threadCurrentThread = Thread.currentThread();
            c cVar = this.f1144a;
            if (threadCurrentThread == cVar) {
                a(bVar);
                return;
            }
            synchronized (cVar) {
                d dVar = new d();
                dVar.f18398a = bVar.f18391a;
                dVar.f1151a = bVar;
                dVar.f1150a = -1L;
                this.f1144a.a(dVar);
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("execute job now error: " + e9.getMessage());
        }
    }

    public s(boolean z8) {
        this("Timer-" + b(), z8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m813a() {
        com.xiaomi.channel.commonutils.logger.c.m9a("quit. finalizer:" + this.f1143a);
        this.f1144a.a();
    }

    public s() {
        this(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m815a(int i9) {
        boolean zM823a;
        synchronized (this.f1144a) {
            zM823a = this.f1144a.f1146a.m823a(i9);
        }
        return zM823a;
    }

    public void a(int i9) {
        synchronized (this.f1144a) {
            this.f1144a.f1146a.a(i9);
        }
    }

    public void a(int i9, b bVar) {
        synchronized (this.f1144a) {
            this.f1144a.f1146a.a(i9, bVar);
        }
    }

    private void b(b bVar, long j) {
        synchronized (this.f1144a) {
            try {
                if (!this.f1144a.f1148b) {
                    long jA = j + a();
                    if (jA < 0) {
                        throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                    }
                    d dVar = new d();
                    dVar.f18398a = bVar.f18391a;
                    dVar.f1151a = bVar;
                    dVar.f1150a = jA;
                    this.f1144a.a(dVar);
                    bk.m783a().a(this.f1144a.f1146a.f1149a, this.f1144a.f1146a.f18396b);
                } else {
                    throw new IllegalStateException("Timer was canceled");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m814a() {
        return this.f1144a.m818a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.c.a() < 1 && Thread.currentThread() != this.f1144a) {
            com.xiaomi.channel.commonutils.logger.c.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException(defpackage.f.d(j, "delay < 0: "));
    }
}
