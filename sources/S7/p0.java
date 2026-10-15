package S7;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements B7.h.a, B7.h.b<p0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f4298a = new p0();

    @Override // B7.h
    public final <R> R A(R r8, K7.p<? super R, ? super B7.h.a, ? extends R> pVar) {
        return pVar.invoke(r8, this);
    }

    @Override // B7.h
    public final B7.h d(B7.h.b<?> bVar) {
        return B7.h.a.C0007a.b(this, bVar);
    }

    @Override // B7.h
    public final <E extends B7.h.a> E i(B7.h.b<E> bVar) {
        return (E) B7.h.a.C0007a.a(this, bVar);
    }

    @Override // B7.h
    public final B7.h r(B7.h context) {
        kotlin.jvm.internal.k.e(context, "context");
        return context == B7.i.f1761a ? this : (B7.h) context.A(this, new B7.g(0));
    }

    @Override // B7.h.a
    public final B7.h.b<?> getKey() {
        return this;
    }
}
