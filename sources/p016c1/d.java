package p016c1;

import java.util.concurrent.ConcurrentHashMap;
import p023d1.b;

/* JADX INFO: compiled from: AsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f8680e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f8682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f8683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f8684d = new ConcurrentHashMap(3);

    /* JADX INFO: compiled from: AsyncTaskManager.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8685a = new d();
    }

    public d() {
        c();
        b();
        d();
    }

    public final b a(g gVar) {
        e eVarB = gVar.b();
        if (eVarB == e.f8686a) {
            if (this.f8681a == null) {
                b();
            }
            return this.f8681a;
        }
        if (eVarB == e.f8687b) {
            if (this.f8683c == null) {
                d();
            }
            return this.f8683c;
        }
        if (this.f8682b == null) {
            c();
        }
        return this.f8682b;
    }

    public final void b() {
        synchronized (f8680e) {
            try {
                if (this.f8681a == null) {
                    p023d1.a aVar = new p023d1.a("io-task");
                    aVar.f18486b = new p016c1.a(this);
                    this.f8681a = new b(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (f8680e) {
            try {
                if (this.f8682b == null) {
                    p023d1.a aVar = new p023d1.a("light-weight-task");
                    aVar.f18486b = new b(this);
                    this.f8682b = new b(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (f8680e) {
            try {
                if (this.f8683c == null) {
                    p023d1.a aVar = new p023d1.a("time-sensitive-task");
                    aVar.f18486b = new c(this);
                    this.f8683c = new b(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
