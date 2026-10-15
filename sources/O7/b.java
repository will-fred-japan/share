package O7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Iterator, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3583d;

    public b(char c5, int i9) {
        this.f3580a = i9;
        this.f3581b = c5;
        boolean z8 = false;
        if (i9 <= 0 ? kotlin.jvm.internal.k.f(1, c5) >= 0 : kotlin.jvm.internal.k.f(1, c5) <= 0) {
            z8 = true;
        }
        this.f3582c = z8;
        this.f3583d = z8 ? (char) 1 : c5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3582c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i9 = this.f3583d;
        if (i9 != this.f3581b) {
            this.f3583d = this.f3580a + i9;
        } else {
            if (!this.f3582c) {
                throw new NoSuchElementException();
            }
            this.f3582c = false;
        }
        return Character.valueOf((char) i9);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
