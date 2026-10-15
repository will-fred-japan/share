package p056h5;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class B implements ListIterator, Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D f19047c;

    public B(D d9, int i9) {
        int size = d9.size();
        if (i9 < 0 || i9 > size) {
            throw new IndexOutOfBoundsException(y.c(i9, size, "index"));
        }
        this.f19045a = size;
        this.f19046b = i9;
        this.f19047c = d9;
    }

    public final Object a(int i9) {
        return this.f19047c.get(i9);
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f19046b < this.f19045a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f19046b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f19046b;
        this.f19046b = i9 + 1;
        return a(i9);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f19046b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i9 = this.f19046b - 1;
        this.f19046b = i9;
        return a(i9);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f19046b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
