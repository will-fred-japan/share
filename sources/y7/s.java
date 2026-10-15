package y7;

import java.util.Iterator;

/* JADX INFO: compiled from: PrimitiveIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements Iterator<Integer>, L7.a {
    public abstract int a();

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
