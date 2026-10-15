package Z7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5664b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5665c = AtomicIntegerFieldUpdater.newUpdater(k.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5666d = AtomicIntegerFieldUpdater.newUpdater(k.class, "consumerIndex$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5667e = AtomicIntegerFieldUpdater.newUpdater(k.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<g> f5668a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final g a() {
        g andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5666d;
            int i9 = atomicIntegerFieldUpdater.get(this);
            if (i9 - f5665c.get(this) == 0) {
                return null;
            }
            int i10 = i9 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i9, i9 + 1) && (andSet = this.f5668a.getAndSet(i10, null)) != null) {
                if (andSet.f5655b) {
                    f5667e.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final g b(int i9, boolean z8) {
        int i10 = i9 & 127;
        AtomicReferenceArray<g> atomicReferenceArray = this.f5668a;
        g gVar = atomicReferenceArray.get(i10);
        if (gVar != null && gVar.f5655b == z8) {
            while (!atomicReferenceArray.compareAndSet(i10, gVar, null)) {
                if (atomicReferenceArray.get(i10) != gVar) {
                }
            }
            if (z8) {
                f5667e.decrementAndGet(this);
            }
            return gVar;
        }
        return null;
    }
}
