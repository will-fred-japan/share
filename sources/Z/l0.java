package Z;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements B7.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f5433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0460l<?> f5434b;

    public l0(l0 l0Var, C0460l<?> instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        this.f5433a = l0Var;
        this.f5434b = instance;
    }

    @Override // B7.h
    public final <R> R A(R r8, K7.p<? super R, ? super B7.h.a, ? extends R> pVar) {
        return pVar.invoke(r8, this);
    }

    public final void c(C0460l c0460l) {
        if (this.f5434b == c0460l) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        l0 l0Var = this.f5433a;
        if (l0Var != null) {
            l0Var.c(c0460l);
        }
    }

    @Override // B7.h
    public final B7.h d(B7.h.b<?> bVar) {
        return B7.h.a.C0007a.b(this, bVar);
    }

    @Override // B7.h.a
    public final B7.h.b<?> getKey() {
        return k0.f5419a;
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
}
