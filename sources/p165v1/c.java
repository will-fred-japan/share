package p165v1;

import java.io.Closeable;
import java.io.IOException;
import java.util.EventObject;

/* JADX INFO: compiled from: StreamCompleteEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends EventObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IOException f21887b;

    public c(Closeable closeable, long j, IOException iOException) {
        super(closeable);
        this.f21886a = j;
        this.f21887b = iOException;
    }
}
