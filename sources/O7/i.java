package O7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements Iterator, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3596d;

    public i(long j, long j8) {
        this.f3593a = j8;
        this.f3594b = j;
        boolean z8 = false;
        if (j8 <= 0 ? 1 >= j : 1 <= j) {
            z8 = true;
        }
        this.f3595c = z8;
        this.f3596d = z8 ? 1L : j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3595c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j = this.f3596d;
        if (j != this.f3594b) {
            this.f3596d = this.f3593a + j;
        } else {
            if (!this.f3595c) {
                throw new NoSuchElementException();
            }
            this.f3595c = false;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
