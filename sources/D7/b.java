package D7;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements B7.e<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1938a = new b();

    @Override // B7.e
    public final B7.h getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
