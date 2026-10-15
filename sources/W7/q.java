package W7;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> implements B7.e<T>, D7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B7.e<T> f5106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B7.h f5107b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(B7.e<? super T> eVar, B7.h hVar) {
        this.f5106a = eVar;
        this.f5107b = hVar;
    }

    @Override // D7.d
    public final D7.d getCallerFrame() {
        B7.e<T> eVar = this.f5106a;
        if (eVar instanceof D7.d) {
            return (D7.d) eVar;
        }
        return null;
    }

    @Override // B7.e
    public final B7.h getContext() {
        return this.f5107b;
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        this.f5106a.resumeWith(obj);
    }
}
