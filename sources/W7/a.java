package W7;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient V7.e f5076a;

    public a(V7.e eVar) {
        super("Flow was aborted, no more elements needed");
        this.f5076a = eVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
