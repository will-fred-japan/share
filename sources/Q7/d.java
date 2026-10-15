package Q7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G6.a f3874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3875b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, L7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f3876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3877b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d<T> f3878c;

        public a(d<T> dVar) {
            this.f3878c = dVar;
        }

        public final void a() {
            T t;
            int i9 = this.f3877b;
            d<T> dVar = this.f3878c;
            if (i9 == -2) {
                t = (T) dVar.f3874a.invoke();
            } else {
                j jVar = dVar.f3875b;
                T t6 = this.f3876a;
                kotlin.jvm.internal.k.b(t6);
                t = (T) jVar.invoke(t6);
            }
            this.f3876a = t;
            this.f3877b = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f3877b < 0) {
                a();
            }
            return this.f3877b == 1;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f3877b < 0) {
                a();
            }
            if (this.f3877b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f3876a;
            kotlin.jvm.internal.k.c(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f3877b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(G6.a aVar, j jVar) {
        this.f3874a = aVar;
        this.f3875b = jVar;
    }

    @Override // Q7.e
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
