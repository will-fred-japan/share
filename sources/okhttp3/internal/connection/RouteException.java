package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.k;
import p188x7.j;

/* JADX INFO: compiled from: RouteException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException firstConnectException) {
        super(firstConnectException);
        k.e(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    public final void addConnectException(IOException e9) {
        k.e(e9, "e");
        j.a(this.firstConnectException, e9);
        this.lastConnectException = e9;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
