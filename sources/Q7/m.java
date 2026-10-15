package Q7;

import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T, R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f3887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K7.l<T, R> f3888b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, L7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f3889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m<T, R> f3890b;

        public a(m<T, R> mVar) {
            this.f3890b = mVar;
            this.f3889a = mVar.f3887a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f3889a.hasNext();
        }

        @Override // java.util.Iterator
        public final R next() {
            return (R) this.f3890b.f3888b.invoke(this.f3889a.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(e<? extends T> eVar, K7.l<? super T, ? extends R> lVar) {
        this.f3887a = eVar;
        this.f3888b = lVar;
    }

    @Override // Q7.e
    public final Iterator<R> iterator() {
        return new a(this);
    }
}
