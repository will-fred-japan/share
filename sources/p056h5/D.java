package p056h5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class D extends A implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f19051b = new B(E.f19052e, 0);

    /* JADX WARN: Multi-variable type inference failed */
    public static D o(List list) {
        if (list instanceof A) {
            D dK = ((A) list).k();
            if (!dK.l()) {
                return dK;
            }
            Object[] array = dK.toArray(A.f19044a);
            int length = array.length;
            return length == 0 ? E.f19052e : new E(array, length);
        }
        Object[] array2 = list.toArray();
        int length2 = array2.length;
        for (int i9 = 0; i9 < length2; i9++) {
            if (array2[i9] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i9).length() + 9);
                sb.append("at index ");
                sb.append(i9);
                throw new NullPointerException(sb.toString());
            }
        }
        return length2 == 0 ? E.f19052e : new E(array2, length2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i9, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i9, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        Object next;
        Object next2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i9 = 0; i9 < size; i9++) {
                        Object obj2 = get(i9);
                        Object obj3 = list.get(i9);
                        if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                        }
                    }
                    return true;
                }
                B bListIterator = listIterator(0);
                Iterator it = list.iterator();
                while (bListIterator.hasNext()) {
                    if (it.hasNext() && ((next = bListIterator.next()) == (next2 = it.next()) || (next != null && next.equals(next2)))) {
                    }
                }
                if (!it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p056h5.A
    /* JADX INFO: renamed from: f */
    public final B iterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i9 = 0; i9 < size; i9++) {
            iHashCode = (iHashCode * 31) + get(i9).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            if (obj.equals(get(i9))) {
                return i9;
            }
        }
        return -1;
    }

    @Override // p056h5.A, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // p056h5.A
    public void m(Object[] objArr) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            objArr[i9] = get(i9);
        }
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: n */
    public D subList(int i9, int i10) {
        y.b(i9, i10, size());
        int i11 = i10 - i9;
        if (i11 == size()) {
            return this;
        }
        return i11 == 0 ? E.f19052e : new C(this, i9, i11);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final B listIterator(int i9) {
        int size = size();
        if (i9 < 0 || i9 > size) {
            throw new IndexOutOfBoundsException(y.c(i9, size, "index"));
        }
        return isEmpty() ? f19051b : new B(this, i9);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i9) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i9, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p056h5.A
    @Deprecated
    public final D k() {
        return this;
    }
}
