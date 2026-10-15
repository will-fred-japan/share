package U7;

import S7.C0396h;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements K7.l<Throwable, p188x7.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0396h f4796a;

    public o(C0396h c0396h) {
        this.f4796a = c0396h;
    }

    @Override // K7.l
    public final p188x7.k invoke(Throwable th) {
        p188x7.k kVar = p188x7.k.f22364a;
        this.f4796a.resumeWith(kVar);
        return kVar;
    }
}
