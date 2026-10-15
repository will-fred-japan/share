package b8;

import X7.s;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends s<k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f8659e;

    public k(long j, k kVar, int i9) {
        super(j, kVar, i9);
        this.f8659e = new AtomicReferenceArray(j.f8658f);
    }

    @Override // X7.s
    public final int g() {
        return j.f8658f;
    }

    @Override // X7.s
    public final void h(int i9, B7.h hVar) {
        this.f8659e.set(i9, j.f8657e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f5169c + ", hashCode=" + hashCode() + ']';
    }
}
