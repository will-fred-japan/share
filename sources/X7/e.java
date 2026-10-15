package X7;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient B7.h f5136a;

    public e(B7.h hVar) {
        this.f5136a = hVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f5136a.toString();
    }
}
