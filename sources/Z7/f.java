package Z7;

import S7.Q;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public class f extends Q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f5653c;

    @Override // S7.AbstractC0410w
    public final void g(B7.h hVar, Runnable runnable) {
        a aVar = this.f5653c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.f5624h;
        aVar.b(runnable, false);
    }
}
