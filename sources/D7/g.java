package D7;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends a {
    public g(B7.e<Object> eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != B7.i.f1761a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // B7.e
    public B7.h getContext() {
        return B7.i.f1761a;
    }
}
