package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0621a<T> implements Iterator<T>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f19996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19997b;

    public C0621a(T[] array) {
        k.e(array, "array");
        this.f19996a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19997b < this.f19996a.length;
    }

    @Override // java.util.Iterator
    public final T next() {
        try {
            T[] tArr = this.f19996a;
            int i9 = this.f19997b;
            this.f19997b = i9 + 1;
            return tArr[i9];
        } catch (ArrayIndexOutOfBoundsException e9) {
            this.f19997b--;
            throw new NoSuchElementException(e9.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
