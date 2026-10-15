package p013b7;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p170v7.a;

/* JADX INFO: compiled from: DartMessenger.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements p096m7.c, p013b7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f8614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f8615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f8616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f8618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f8619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p013b7.e f8621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakHashMap<p096m7.c.InterfaceC0232c, b> f8622i;
    public final C0114c j;

    /* JADX INFO: compiled from: DartMessenger.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f8623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f8625c;

        public a(long j, ByteBuffer byteBuffer, int i9) {
            this.f8623a = byteBuffer;
            this.f8624b = i9;
            this.f8625c = j;
        }
    }

    /* JADX INFO: compiled from: DartMessenger.java */
    public interface b {
        void a(p013b7.b bVar);
    }

    /* JADX INFO: renamed from: b7.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DartMessenger.java */
    public static class C0114c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExecutorService f8626a;
    }

    /* JADX INFO: compiled from: DartMessenger.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m7.c.a f8627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f8628b;

        public d(m7.c.a aVar, b bVar) {
            this.f8627a = aVar;
            this.f8628b = bVar;
        }
    }

    /* JADX INFO: compiled from: DartMessenger.java */
    public static class e implements m7.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlutterJNI f8629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f8631c = new AtomicBoolean(false);

        public e(FlutterJNI flutterJNI, int i9) {
            this.f8629a = flutterJNI;
            this.f8630b = i9;
        }

        @Override // m7.c.b
        public final void a(ByteBuffer byteBuffer) {
            if (this.f8631c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            int i9 = this.f8630b;
            FlutterJNI flutterJNI = this.f8629a;
            if (byteBuffer == null) {
                flutterJNI.invokePlatformMessageEmptyResponseCallback(i9);
            } else {
                flutterJNI.invokePlatformMessageResponseCallback(i9, byteBuffer, byteBuffer.position());
            }
        }
    }

    /* JADX INFO: compiled from: DartMessenger.java */
    public static class f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f8632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue<Runnable> f8633b = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f8634c = new AtomicBoolean(false);

        public f(ExecutorService executorService) {
            this.f8632a = executorService;
        }

        @Override // b7.c.b
        public final void a(p013b7.b bVar) {
            this.f8633b.add(bVar);
            this.f8632a.execute(new F6.b(4, this));
        }
    }

    /* JADX INFO: compiled from: DartMessenger.java */
    public static class g implements p096m7.c.InterfaceC0232c {
    }

    public c(FlutterJNI flutterJNI) {
        C0114c c0114c = new C0114c();
        c0114c.f8626a = Y6.b.a().f5269c;
        this.f8615b = new HashMap();
        this.f8616c = new HashMap();
        this.f8617d = new Object();
        this.f8618e = new AtomicBoolean(false);
        this.f8619f = new HashMap();
        this.f8620g = 1;
        this.f8621h = new p013b7.e();
        this.f8622i = new WeakHashMap<>();
        this.f8614a = flutterJNI;
        this.j = c0114c;
    }

    @Override // p096m7.c
    public final void a(String str, ByteBuffer byteBuffer, m7.c.b bVar) {
        p170v7.a.b("DartMessenger#send on " + str);
        try {
            int i9 = this.f8620g;
            this.f8620g = i9 + 1;
            if (bVar != null) {
                this.f8619f.put(Integer.valueOf(i9), bVar);
            }
            FlutterJNI flutterJNI = this.f8614a;
            if (byteBuffer == null) {
                flutterJNI.dispatchEmptyPlatformMessage(str, i9);
            } else {
                flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i9);
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // p096m7.c
    public final void b(String str, m7.c.a aVar, p096m7.c.InterfaceC0232c interfaceC0232c) {
        b bVar;
        if (aVar == null) {
            synchronized (this.f8617d) {
                this.f8615b.remove(str);
            }
            return;
        }
        if (interfaceC0232c != null) {
            bVar = this.f8622i.get(interfaceC0232c);
            if (bVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            bVar = null;
        }
        synchronized (this.f8617d) {
            try {
                this.f8615b.put(str, new d(aVar, bVar));
                List<a> list = (List) this.f8616c.remove(str);
                if (list == null) {
                    return;
                }
                for (a aVar2 : list) {
                    f(str, (d) this.f8615b.get(str), aVar2.f8623a, aVar2.f8624b, aVar2.f8625c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p096m7.c
    public final p096m7.c.InterfaceC0232c c(m7.c.d dVar) {
        C0114c c0114c = this.j;
        c0114c.getClass();
        f fVar = new f(c0114c.f8626a);
        g gVar = new g();
        this.f8622i.put(gVar, fVar);
        return gVar;
    }

    @Override // p096m7.c
    public final void d(String str, ByteBuffer byteBuffer) {
        a(str, byteBuffer, null);
    }

    @Override // p096m7.c
    public final void e(String str, m7.c.a aVar) {
        b(str, aVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [b7.b] */
    public final void f(final String str, final d dVar, final ByteBuffer byteBuffer, final int i9, final long j) {
        b bVar = dVar != null ? dVar.f8628b : null;
        String strA = p170v7.a.a("PlatformChannel ScheduleHandler on " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            p156u0.b.a(i9, p156u0.a.c(strA));
        } else {
            String strC = p156u0.a.c(strA);
            try {
                if (p156u0.a.f21667c == null) {
                    p156u0.a.f21667c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                p156u0.a.f21667c.invoke(null, Long.valueOf(p156u0.a.f21665a), strC, Integer.valueOf(i9));
            } catch (Exception e9) {
                p156u0.a.a("asyncTraceBegin", e9);
            }
        }
        ?? r8 = new Runnable() { // from class: b7.b
            @Override // java.lang.Runnable
            public final void run() {
                long j8 = j;
                FlutterJNI flutterJNI = this.f8608a.f8614a;
                StringBuilder sb = new StringBuilder("PlatformChannel ScheduleHandler on ");
                String str2 = str;
                sb.append(str2);
                String strA2 = a.a(sb.toString());
                int i10 = Build.VERSION.SDK_INT;
                int i11 = i9;
                if (i10 >= 29) {
                    p156u0.b.b(i11, p156u0.a.c(strA2));
                } else {
                    String strC2 = p156u0.a.c(strA2);
                    try {
                        if (p156u0.a.f21668d == null) {
                            p156u0.a.f21668d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                        }
                        p156u0.a.f21668d.invoke(null, Long.valueOf(p156u0.a.f21665a), strC2, Integer.valueOf(i11));
                    } catch (Exception e10) {
                        p156u0.a.a("asyncTraceEnd", e10);
                    }
                }
                try {
                    a.b("DartMessenger#handleMessageFromDart on " + str2);
                    c.d dVar2 = dVar;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    try {
                        if (dVar2 != null) {
                            try {
                                try {
                                    dVar2.f8627a.a(byteBuffer2, new c.e(flutterJNI, i11));
                                } catch (Exception e11) {
                                    Log.e("DartMessenger", "Uncaught exception in binary message listener", e11);
                                    flutterJNI.invokePlatformMessageEmptyResponseCallback(i11);
                                }
                            } catch (Error e12) {
                                Thread threadCurrentThread = Thread.currentThread();
                                if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
                                    throw e12;
                                }
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e12);
                            }
                        } else {
                            flutterJNI.invokePlatformMessageEmptyResponseCallback(i11);
                        }
                        if (byteBuffer2 != null && byteBuffer2.isDirect()) {
                            byteBuffer2.limit(0);
                        }
                        Trace.endSection();
                        flutterJNI.cleanupMessageData(j8);
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    flutterJNI.cleanupMessageData(j8);
                    throw th3;
                }
            }
        };
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = this.f8621h;
        }
        bVar2.a(r8);
    }
}
