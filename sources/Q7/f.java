package Q7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import okio.Path;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends g<T> implements Iterator<T>, B7.e<p188x7.k>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f3880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public B7.e<? super p188x7.k> f3881c;

    @Override // Q7.g
    public final void a(Path path, B7.e eVar) {
        this.f3880b = path;
        this.f3879a = 3;
        this.f3881c = eVar;
        C7.a aVar = C7.a.f1806a;
    }

    public final RuntimeException b() {
        int i9 = this.f3879a;
        if (i9 == 4) {
            return new NoSuchElementException();
        }
        if (i9 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f3879a);
    }

    @Override // B7.e
    public final B7.h getContext() {
        return B7.i.f1761a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i9;
        while (true) {
            i9 = this.f3879a;
            if (i9 != 0) {
                break;
            }
            this.f3879a = 5;
            B7.e<? super p188x7.k> eVar = this.f3881c;
            kotlin.jvm.internal.k.b(eVar);
            this.f3881c = null;
            eVar.resumeWith(p188x7.k.f22364a);
        }
        if (i9 == 1) {
            kotlin.jvm.internal.k.b(null);
            throw null;
        }
        if (i9 == 2 || i9 == 3) {
            return true;
        }
        if (i9 == 4) {
            return false;
        }
        throw b();
    }

    @Override // java.util.Iterator
    public final T next() {
        int i9 = this.f3879a;
        if (i9 == 0 || i9 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i9 == 2) {
            this.f3879a = 1;
            kotlin.jvm.internal.k.b(null);
            throw null;
        }
        if (i9 != 3) {
            throw b();
        }
        this.f3879a = 0;
        T t = (T) this.f3880b;
        this.f3880b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // B7.e
    public final void resumeWith(Object obj) {
        p188x7.g.b(obj);
        this.f3879a = 4;
    }
}
