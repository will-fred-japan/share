package y7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements List, Serializable, RandomAccess, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f22408a = new p();
    private static final long serialVersionUID = -7390468764508069838L;

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i9, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i9, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        Void element = (Void) obj;
        kotlin.jvm.internal.k.e(element, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List
    public final Object get(int i9) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i9 + '.');
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        Void element = (Void) obj;
        kotlin.jvm.internal.k.e(element, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return o.f22407a;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        Void element = (Void) obj;
        kotlin.jvm.internal.k.e(element, "element");
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return o.f22407a;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i9) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i9, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // java.util.List
    public final List subList(int i9, int i10) {
        if (i9 == 0 && i10 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(W5.e.h(i9, i10, "fromIndex: ", ", toIndex: "));
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.e.a(this);
    }

    public final String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i9) {
        if (i9 == 0) {
            return o.f22407a;
        }
        throw new IndexOutOfBoundsException(W5.e.i(i9, "Index: "));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }
}
