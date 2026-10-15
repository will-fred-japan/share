package p016c1;

import p032e2.b;

/* JADX INFO: compiled from: AsyncTaskUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f8690a;

    public f(b bVar) {
        this.f8690a = bVar;
    }

    @Override // p016c1.g
    public final e b() {
        return e.f8688c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8690a.run();
            d dVar = d.a.f8685a;
        } catch (Throwable unused) {
            d.a.f8685a.getClass();
        }
    }
}
