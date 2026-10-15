package y7;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: AbstractMutableList.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<E> extends AbstractList<E> implements List<E>, L7.b {
    public abstract int f();

    public abstract E g(int i9);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i9) {
        return g(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return f();
    }
}
