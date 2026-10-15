package p155u;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import p011b4.h;
import y7.f;

/* JADX INFO: compiled from: ArraySet.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f21640a = p163v.a.f21768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f21641b = p163v.a.f21769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21642c;

    /* JADX INFO: compiled from: ArraySet.jvm.kt */
    public final class a extends c<E> {
        public a() {
            super(b.this.f21642c);
        }

        @Override // p155u.c
        public final E a(int i9) {
            return (E) b.this.f21641b[i9];
        }

        @Override // p155u.c
        public final void b(int i9) {
            b.this.f(i9);
        }
    }

    public b(int i9) {
        if (i9 > 0) {
            h.q(this, i9);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e9) {
        int i9;
        int iA;
        int i10 = this.f21642c;
        if (e9 == null) {
            iA = h.A(this, null, 0);
            i9 = 0;
        } else {
            int iHashCode = e9.hashCode();
            i9 = iHashCode;
            iA = h.A(this, e9, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i11 = ~iA;
        int[] iArr = this.f21640a;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f21641b;
            h.q(this, i12);
            if (i10 != this.f21642c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f21640a;
            if (iArr2.length != 0) {
                f.b(0, 0, iArr, iArr2, iArr.length);
                f.e(objArr, this.f21641b, 0, objArr.length, 6);
            }
        }
        if (i11 < i10) {
            int[] iArr3 = this.f21640a;
            int i13 = i11 + 1;
            f.b(i13, i11, iArr3, iArr3, i10);
            Object[] objArr2 = this.f21641b;
            f.d(objArr2, objArr2, i13, i11, i10);
        }
        int i14 = this.f21642c;
        if (i10 == i14) {
            int[] iArr4 = this.f21640a;
            if (i11 < iArr4.length) {
                iArr4[i11] = i9;
                this.f21641b[i11] = e9;
                this.f21642c = i14 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> elements) {
        k.e(elements, "elements");
        int size = elements.size() + this.f21642c;
        int i9 = this.f21642c;
        int[] iArr = this.f21640a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f21641b;
            h.q(this, size);
            int i10 = this.f21642c;
            if (i10 > 0) {
                f.b(0, 0, iArr, this.f21640a, i10);
                f.e(objArr, this.f21641b, 0, this.f21642c, 6);
            }
        }
        if (this.f21642c != i9) {
            throw new ConcurrentModificationException();
        }
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f21642c != 0) {
            this.f21640a = p163v.a.f21768a;
            this.f21641b = p163v.a.f21769b;
            this.f21642c = 0;
        }
        if (this.f21642c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? h.A(this, null, 0) : h.A(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<? extends Object> elements) {
        k.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f21642c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i9 = this.f21642c;
            for (int i10 = 0; i10 < i9; i10++) {
                if (!((Set) obj).contains(this.f21641b[i10])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final E f(int i9) {
        int i10 = this.f21642c;
        Object[] objArr = this.f21641b;
        E e9 = (E) objArr[i9];
        if (i10 <= 1) {
            clear();
            return e9;
        }
        int i11 = i10 - 1;
        int[] iArr = this.f21640a;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i9 < i11) {
                int i12 = i9 + 1;
                f.b(i9, i12, iArr, iArr, i10);
                Object[] objArr2 = this.f21641b;
                f.d(objArr2, objArr2, i9, i12, i10);
            }
            this.f21641b[i11] = null;
        } else {
            h.q(this, i10 > 8 ? i10 + (i10 >> 1) : 8);
            if (i9 > 0) {
                f.b(0, 0, iArr, this.f21640a, i9);
                f.e(objArr, this.f21641b, 0, i9, 6);
            }
            if (i9 < i11) {
                int i13 = i9 + 1;
                f.b(i9, i13, iArr, this.f21640a, i10);
                f.d(objArr, this.f21641b, i9, i13, i10);
            }
        }
        if (i10 != this.f21642c) {
            throw new ConcurrentModificationException();
        }
        this.f21642c = i11;
        return e9;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f21640a;
        int i9 = this.f21642c;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f21642c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iA = obj == null ? h.A(this, null, 0) : h.A(this, obj, obj.hashCode());
        if (iA < 0) {
            return false;
        }
        f(iA);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<? extends Object> elements) {
        k.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> elements) {
        boolean zContains;
        k.e(elements, "elements");
        int i9 = this.f21642c - 1;
        boolean z8 = false;
        while (true) {
            int iIndexOf = -1;
            if (-1 >= i9) {
                return z8;
            }
            Collection<? extends Object> collection = elements;
            Object obj = this.f21641b[i9];
            if (collection instanceof Collection) {
                zContains = collection.contains(obj);
            } else {
                if (collection instanceof List) {
                    iIndexOf = ((List) collection).indexOf(obj);
                } else {
                    int i10 = 0;
                    for (Object obj2 : collection) {
                        if (i10 < 0) {
                            y7.h.D();
                            throw null;
                        }
                        if (k.a(obj, obj2)) {
                            iIndexOf = i10;
                            break;
                        }
                        i10++;
                    }
                }
                zContains = iIndexOf >= 0;
            }
            if (!zContains) {
                f(i9);
                z8 = true;
            }
            i9--;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f21642c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return f.g(this.f21641b, 0, this.f21642c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f21642c * 14);
        sb.append('{');
        int i9 = this.f21642c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = this.f21641b[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        k.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        k.e(array, "array");
        int i9 = this.f21642c;
        if (array.length < i9) {
            array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), i9));
        } else if (array.length > i9) {
            array[i9] = null;
        }
        f.d(this.f21641b, array, 0, 0, this.f21642c);
        return array;
    }
}
