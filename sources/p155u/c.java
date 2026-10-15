package p155u;

import L7.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: IndexBasedArrayIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements Iterator<T>, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21646c;

    public c(int i9) {
        this.f21644a = i9;
    }

    public abstract T a(int i9);

    public abstract void b(int i9);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f21645b < this.f21644a;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tA = a(this.f21645b);
        this.f21645b++;
        this.f21646c = true;
        return tA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f21646c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i9 = this.f21645b - 1;
        this.f21645b = i9;
        b(i9);
        this.f21644a--;
        this.f21646c = false;
    }
}
