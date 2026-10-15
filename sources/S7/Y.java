package S7;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Y extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient c0 f4252a;

    public Y(String str, Throwable th, c0 c0Var) {
        super(str);
        this.f4252a = c0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y8 = (Y) obj;
        return kotlin.jvm.internal.k.a(y8.getMessage(), getMessage()) && kotlin.jvm.internal.k.a(y8.f4252a, this.f4252a) && kotlin.jvm.internal.k.a(y8.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.k.b(message);
        int iHashCode = (this.f4252a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f4252a;
    }
}
