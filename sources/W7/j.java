package W7;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements B7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B7.h f5094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f5095b;

    public j(B7.h hVar, Throwable th) {
        this.f5094a = hVar;
        this.f5095b = th;
    }

    @Override // B7.h
    public final <R> R A(R r8, K7.p<? super R, ? super B7.h.a, ? extends R> pVar) {
        return (R) this.f5094a.A(r8, pVar);
    }

    @Override // B7.h
    public final B7.h d(B7.h.b<?> bVar) {
        return this.f5094a.d(bVar);
    }

    @Override // B7.h
    public final <E extends B7.h.a> E i(B7.h.b<E> bVar) {
        return (E) this.f5094a.i(bVar);
    }

    @Override // B7.h
    public final B7.h r(B7.h hVar) {
        return this.f5094a.r(hVar);
    }
}
