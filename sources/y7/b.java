package y7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<E> extends y7.a<E> implements List<E> {
    public static final a Companion = new a();
    private static final int maxArraySize = 2147483639;

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        public static void a(int i9, int i10) {
            if (i9 < 0 || i9 >= i10) {
                throw new IndexOutOfBoundsException(W5.e.h(i9, i10, "index: ", ", size: "));
            }
        }

        public static void b(int i9, int i10) {
            if (i9 < 0 || i9 > i10) {
                throw new IndexOutOfBoundsException(W5.e.h(i9, i10, "index: ", ", size: "));
            }
        }

        public static void c(int i9, int i10, int i11) {
            if (i9 < 0 || i10 > i11) {
                StringBuilder sbG = H2.a.g(i9, i10, "fromIndex: ", ", toIndex: ", ", size: ");
                sbG.append(i11);
                throw new IndexOutOfBoundsException(sbG.toString());
            }
            if (i9 > i10) {
                throw new IllegalArgumentException(W5.e.h(i9, i10, "fromIndex: ", " > toIndex: "));
            }
        }
    }

    /* JADX INFO: renamed from: y7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractList.kt */
    public class C0283b implements Iterator<E>, L7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22394a;

        public C0283b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f22394a < b.this.size();
        }

        @Override // java.util.Iterator
        public final E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i9 = this.f22394a;
            this.f22394a = i9 + 1;
            return b.this.get(i9);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    public class c extends b<E>.C0283b implements ListIterator<E> {
        public c(int i9) {
            super();
            a aVar = b.Companion;
            int size = b.this.size();
            aVar.getClass();
            a.b(i9, size);
            this.f22394a = i9;
        }

        @Override // java.util.ListIterator
        public final void add(E e9) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f22394a > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f22394a;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i9 = this.f22394a - 1;
            this.f22394a = i9;
            return b.this.get(i9);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f22394a - 1;
        }

        @Override // java.util.ListIterator
        public final void set(E e9) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class d<E> extends b<E> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<E> f22397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22399c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> list, int i9, int i10) {
            kotlin.jvm.internal.k.e(list, "list");
            this.f22397a = list;
            this.f22398b = i9;
            a aVar = b.Companion;
            int size = list.size();
            aVar.getClass();
            a.c(i9, i10, size);
            this.f22399c = i10 - i9;
        }

        @Override // y7.b, java.util.List
        public final E get(int i9) {
            a aVar = b.Companion;
            int i10 = this.f22399c;
            aVar.getClass();
            a.a(i9, i10);
            return this.f22397a.get(this.f22398b + i9);
        }

        @Override // y7.b, y7.a
        public final int getSize() {
            return this.f22399c;
        }

        @Override // y7.b, java.util.List
        public final List<E> subList(int i9, int i10) {
            a aVar = b.Companion;
            int i11 = this.f22399c;
            aVar.getClass();
            a.c(i9, i10, i11);
            int i12 = this.f22398b;
            return new d(this.f22397a, i9 + i12, i12 + i10);
        }
    }

    @Override // java.util.List
    public void add(int i9, E e9) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i9, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection other = (Collection) obj;
        Companion.getClass();
        kotlin.jvm.internal.k.e(other, "other");
        if (size() == other.size()) {
            Iterator<E> it = other.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.k.a(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    public abstract E get(int i9);

    @Override // y7.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        Companion.getClass();
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i9 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.k.a(it.next(), obj)) {
                return i9;
            }
            i9++;
        }
        return -1;
    }

    @Override // y7.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0283b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.k.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i9) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i9, E e9) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i9, int i10) {
        return new d(this, i9, i10);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i9) {
        return new c(i9);
    }
}
