package B7;

import K7.p;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h.b<?> f1753a;

    public a(h.b<?> bVar) {
        this.f1753a = bVar;
    }

    @Override // B7.h
    public final <R> R A(R r8, p<? super R, ? super h.a, ? extends R> pVar) {
        return pVar.invoke(r8, this);
    }

    @Override // B7.h
    public h d(h.b<?> bVar) {
        return h.a.C0007a.b(this, bVar);
    }

    @Override // B7.h.a
    public final h.b<?> getKey() {
        return this.f1753a;
    }

    @Override // B7.h
    public <E extends h.a> E i(h.b<E> bVar) {
        return (E) h.a.C0007a.a(this, bVar);
    }

    @Override // B7.h
    public final h r(h context) {
        k.e(context, "context");
        return context == i.f1761a ? this : (h) context.A(this, new g(0));
    }
}
