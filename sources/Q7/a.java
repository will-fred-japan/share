package Q7;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<e<T>> f3869a;

    public a(e<? extends T> eVar) {
        this.f3869a = new AtomicReference<>(eVar);
    }

    @Override // Q7.e
    public final Iterator<T> iterator() {
        e<T> andSet = this.f3869a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
