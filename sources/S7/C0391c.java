package S7;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: S7.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0391c<T> extends AbstractC0389a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f4257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final N f4258e;

    public C0391c(B7.h hVar, Thread thread, N n8) {
        super(hVar, true);
        this.f4257d = thread;
        this.f4258e = n8;
    }

    @Override // S7.c0
    public final void C(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f4257d;
        if (kotlin.jvm.internal.k.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
