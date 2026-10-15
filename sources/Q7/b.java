package Q7;

import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements e<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f3870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3871b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, L7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f3872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3873b;

        public a(b<T> bVar) {
            this.f3872a = bVar.f3870a.iterator();
            this.f3873b = bVar.f3871b;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Iterator<T> it;
            while (true) {
                int i9 = this.f3873b;
                it = this.f3872a;
                if (i9 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f3873b--;
            }
            return it.hasNext();
        }

        @Override // java.util.Iterator
        public final T next() {
            Iterator<T> it;
            while (true) {
                int i9 = this.f3873b;
                it = this.f3872a;
                if (i9 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f3873b--;
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(e<? extends T> eVar, int i9) {
        this.f3870a = eVar;
        this.f3871b = i9;
        if (i9 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i9 + '.').toString());
    }

    @Override // Q7.c
    public final b a(int i9) {
        int i10 = this.f3871b + i9;
        return i10 < 0 ? new b(this, i9) : new b(this.f3870a, i10);
    }

    @Override // Q7.e
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
