package y7;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e<E> extends c<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f22402d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f22404b = f22402d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22405c;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e9) {
        addLast(e9);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        o();
        i(elements.size() + f());
        h(n(f() + this.f22403a), elements);
        return true;
    }

    public final void addFirst(E e9) {
        o();
        i(this.f22405c + 1);
        int length = this.f22403a;
        if (length == 0) {
            Object[] objArr = this.f22404b;
            kotlin.jvm.internal.k.e(objArr, "<this>");
            length = objArr.length;
        }
        int i9 = length - 1;
        this.f22403a = i9;
        this.f22404b[i9] = e9;
        this.f22405c++;
    }

    public final void addLast(E e9) {
        o();
        i(f() + 1);
        this.f22404b[n(f() + this.f22403a)] = e9;
        this.f22405c = f() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            o();
            m(this.f22403a, n(f() + this.f22403a));
        }
        this.f22403a = 0;
        this.f22405c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // y7.c
    public final int f() {
        return this.f22405c;
    }

    @Override // y7.c
    public final E g(int i9) {
        b.a aVar = b.Companion;
        int i10 = this.f22405c;
        aVar.getClass();
        b.a.a(i9, i10);
        if (i9 == size() - 1) {
            return removeLast();
        }
        if (i9 == 0) {
            return removeFirst();
        }
        o();
        int iN = n(this.f22403a + i9);
        Object[] objArr = this.f22404b;
        E e9 = (E) objArr[iN];
        if (i9 < (this.f22405c >> 1)) {
            int i11 = this.f22403a;
            if (iN >= i11) {
                f.d(objArr, objArr, i11 + 1, i11, iN);
            } else {
                f.d(objArr, objArr, 1, 0, iN);
                Object[] objArr2 = this.f22404b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f22403a;
                f.d(objArr2, objArr2, i12 + 1, i12, objArr2.length - 1);
            }
            Object[] objArr3 = this.f22404b;
            int i13 = this.f22403a;
            objArr3[i13] = null;
            this.f22403a = k(i13);
        } else {
            int iN2 = n((size() - 1) + this.f22403a);
            if (iN <= iN2) {
                Object[] objArr4 = this.f22404b;
                f.d(objArr4, objArr4, iN, iN + 1, iN2 + 1);
            } else {
                Object[] objArr5 = this.f22404b;
                f.d(objArr5, objArr5, iN, iN + 1, objArr5.length);
                Object[] objArr6 = this.f22404b;
                objArr6[objArr6.length - 1] = objArr6[0];
                f.d(objArr6, objArr6, 0, 1, iN2 + 1);
            }
            this.f22404b[iN2] = null;
        }
        this.f22405c--;
        return e9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i9) {
        b.a aVar = b.Companion;
        int i10 = this.f22405c;
        aVar.getClass();
        b.a.a(i9, i10);
        return (E) this.f22404b[n(this.f22403a + i9)];
    }

    public final void h(int i9, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f22404b.length;
        while (i9 < length && it.hasNext()) {
            this.f22404b[i9] = it.next();
            i9++;
        }
        int i10 = this.f22403a;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f22404b[i11] = it.next();
        }
        this.f22405c = collection.size() + this.f22405c;
    }

    public final void i(int i9) {
        if (i9 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f22404b;
        if (i9 <= objArr.length) {
            return;
        }
        if (objArr == f22402d) {
            if (i9 < 10) {
                i9 = 10;
            }
            this.f22404b = new Object[i9];
            return;
        }
        b.a aVar = b.Companion;
        int length = objArr.length;
        aVar.getClass();
        int i10 = length + (length >> 1);
        if (i10 - i9 < 0) {
            i10 = i9;
        }
        if (i10 - 2147483639 > 0) {
            i10 = i9 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i10];
        Object[] objArr3 = this.f22404b;
        f.d(objArr3, objArr2, 0, this.f22403a, objArr3.length);
        Object[] objArr4 = this.f22404b;
        int length2 = objArr4.length;
        int i11 = this.f22403a;
        f.d(objArr4, objArr2, length2 - i11, 0, i11);
        this.f22403a = 0;
        this.f22404b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i9;
        int iN = n(f() + this.f22403a);
        int length = this.f22403a;
        if (length < iN) {
            while (length < iN) {
                if (kotlin.jvm.internal.k.a(obj, this.f22404b[length])) {
                    i9 = this.f22403a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iN) {
            return -1;
        }
        int length2 = this.f22404b.length;
        while (length < length2) {
            if (kotlin.jvm.internal.k.a(obj, this.f22404b[length])) {
                i9 = this.f22403a;
            } else {
                length++;
            }
        }
        for (int i10 = 0; i10 < iN; i10++) {
            if (kotlin.jvm.internal.k.a(obj, this.f22404b[i10])) {
                length = i10 + this.f22404b.length;
                i9 = this.f22403a;
            }
        }
        return -1;
        return length - i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return f() == 0;
    }

    public final int k(int i9) {
        Object[] objArr = this.f22404b;
        kotlin.jvm.internal.k.e(objArr, "<this>");
        if (i9 == objArr.length - 1) {
            return 0;
        }
        return i9 + 1;
    }

    public final int l(int i9) {
        return i9 < 0 ? i9 + this.f22404b.length : i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i9;
        int iN = n(this.f22405c + this.f22403a);
        int i10 = this.f22403a;
        if (i10 < iN) {
            length = iN - 1;
            if (i10 <= length) {
                while (!kotlin.jvm.internal.k.a(obj, this.f22404b[length])) {
                    if (length != i10) {
                        length--;
                    }
                }
                i9 = this.f22403a;
                return length - i9;
            }
            return -1;
        }
        if (i10 > iN) {
            for (int i11 = iN - 1; -1 < i11; i11--) {
                if (kotlin.jvm.internal.k.a(obj, this.f22404b[i11])) {
                    length = i11 + this.f22404b.length;
                    i9 = this.f22403a;
                    return length - i9;
                }
            }
            Object[] objArr = this.f22404b;
            kotlin.jvm.internal.k.e(objArr, "<this>");
            length = objArr.length - 1;
            int i12 = this.f22403a;
            if (i12 <= length) {
                while (!kotlin.jvm.internal.k.a(obj, this.f22404b[length])) {
                    if (length != i12) {
                        length--;
                    }
                }
                i9 = this.f22403a;
                return length - i9;
            }
        }
        return -1;
    }

    public final void m(int i9, int i10) {
        if (i9 < i10) {
            f.i(this.f22404b, i9, i10);
            return;
        }
        Object[] objArr = this.f22404b;
        f.i(objArr, i9, objArr.length);
        f.i(this.f22404b, 0, i10);
    }

    public final int n(int i9) {
        Object[] objArr = this.f22404b;
        return i9 >= objArr.length ? i9 - objArr.length : i9;
    }

    public final void o() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<?> elements) {
        int iN;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty() && this.f22404b.length != 0) {
            int iN2 = n(this.f22405c + this.f22403a);
            int i9 = this.f22403a;
            if (i9 < iN2) {
                iN = i9;
                while (i9 < iN2) {
                    Object obj = this.f22404b[i9];
                    if (elements.contains(obj)) {
                        z8 = true;
                    } else {
                        this.f22404b[iN] = obj;
                        iN++;
                    }
                    i9++;
                }
                f.i(this.f22404b, iN, iN2);
            } else {
                int length = this.f22404b.length;
                boolean z9 = false;
                int i10 = i9;
                while (i9 < length) {
                    Object[] objArr = this.f22404b;
                    Object obj2 = objArr[i9];
                    objArr[i9] = null;
                    if (elements.contains(obj2)) {
                        z9 = true;
                    } else {
                        this.f22404b[i10] = obj2;
                        i10++;
                    }
                    i9++;
                }
                iN = n(i10);
                for (int i11 = 0; i11 < iN2; i11++) {
                    Object[] objArr2 = this.f22404b;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (elements.contains(obj3)) {
                        z9 = true;
                    } else {
                        this.f22404b[iN] = obj3;
                        iN = k(iN);
                    }
                }
                z8 = z9;
            }
            if (z8) {
                o();
                this.f22405c = l(iN - this.f22403a);
            }
        }
        return z8;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        o();
        Object[] objArr = this.f22404b;
        int i9 = this.f22403a;
        E e9 = (E) objArr[i9];
        objArr[i9] = null;
        this.f22403a = k(i9);
        this.f22405c = f() - 1;
        return e9;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        o();
        int iN = n(h.B(this) + this.f22403a);
        Object[] objArr = this.f22404b;
        E e9 = (E) objArr[iN];
        objArr[iN] = null;
        this.f22405c = f() - 1;
        return e9;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        b.a aVar = b.Companion;
        int i11 = this.f22405c;
        aVar.getClass();
        b.a.c(i9, i10, i11);
        int i12 = i10 - i9;
        if (i12 == 0) {
            return;
        }
        if (i12 == this.f22405c) {
            clear();
            return;
        }
        if (i12 == 1) {
            g(i9);
            return;
        }
        o();
        if (i9 < this.f22405c - i10) {
            int iN = n(this.f22403a + (i9 - 1));
            int iN2 = n(this.f22403a + (i10 - 1));
            while (i9 > 0) {
                int i13 = iN + 1;
                int iMin = Math.min(i9, Math.min(i13, iN2 + 1));
                Object[] objArr = this.f22404b;
                int i14 = iN2 - iMin;
                int i15 = iN - iMin;
                f.d(objArr, objArr, i14 + 1, i15 + 1, i13);
                iN = l(i15);
                iN2 = l(i14);
                i9 -= iMin;
            }
            int iN3 = n(this.f22403a + i12);
            m(this.f22403a, iN3);
            this.f22403a = iN3;
        } else {
            int iN4 = n(this.f22403a + i10);
            int iN5 = n(this.f22403a + i9);
            int i16 = this.f22405c;
            while (true) {
                i16 -= i10;
                if (i16 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f22404b;
                i10 = Math.min(i16, Math.min(objArr2.length - iN4, objArr2.length - iN5));
                Object[] objArr3 = this.f22404b;
                int i17 = iN4 + i10;
                f.d(objArr3, objArr3, iN5, iN4, i17);
                iN4 = n(i17);
                iN5 = n(iN5 + i10);
            }
            int iN6 = n(this.f22405c + this.f22403a);
            m(l(iN6 - i12), iN6);
        }
        this.f22405c -= i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<?> elements) {
        int iN;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty() && this.f22404b.length != 0) {
            int iN2 = n(this.f22405c + this.f22403a);
            int i9 = this.f22403a;
            if (i9 < iN2) {
                iN = i9;
                while (i9 < iN2) {
                    Object obj = this.f22404b[i9];
                    if (elements.contains(obj)) {
                        this.f22404b[iN] = obj;
                        iN++;
                    } else {
                        z8 = true;
                    }
                    i9++;
                }
                f.i(this.f22404b, iN, iN2);
            } else {
                int length = this.f22404b.length;
                boolean z9 = false;
                int i10 = i9;
                while (i9 < length) {
                    Object[] objArr = this.f22404b;
                    Object obj2 = objArr[i9];
                    objArr[i9] = null;
                    if (elements.contains(obj2)) {
                        this.f22404b[i10] = obj2;
                        i10++;
                    } else {
                        z9 = true;
                    }
                    i9++;
                }
                iN = n(i10);
                for (int i11 = 0; i11 < iN2; i11++) {
                    Object[] objArr2 = this.f22404b;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (elements.contains(obj3)) {
                        this.f22404b[iN] = obj3;
                        iN = k(iN);
                    } else {
                        z9 = true;
                    }
                }
                z8 = z9;
            }
            if (z8) {
                o();
                this.f22405c = l(iN - this.f22403a);
            }
        }
        return z8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i9, E e9) {
        b.a aVar = b.Companion;
        int i10 = this.f22405c;
        aVar.getClass();
        b.a.a(i9, i10);
        int iN = n(this.f22403a + i9);
        Object[] objArr = this.f22404b;
        E e10 = (E) objArr[iN];
        objArr[iN] = e9;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[f()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, E e9) {
        int length;
        b.a aVar = b.Companion;
        int i10 = this.f22405c;
        aVar.getClass();
        b.a.b(i9, i10);
        if (i9 == this.f22405c) {
            addLast(e9);
            return;
        }
        if (i9 == 0) {
            addFirst(e9);
            return;
        }
        o();
        i(this.f22405c + 1);
        int iN = n(this.f22403a + i9);
        int i11 = this.f22405c;
        if (i9 < ((i11 + 1) >> 1)) {
            if (iN == 0) {
                Object[] objArr = this.f22404b;
                kotlin.jvm.internal.k.e(objArr, "<this>");
                iN = objArr.length;
            }
            int i12 = iN - 1;
            int i13 = this.f22403a;
            if (i13 == 0) {
                Object[] objArr2 = this.f22404b;
                kotlin.jvm.internal.k.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i13 - 1;
            }
            int i14 = this.f22403a;
            if (i12 >= i14) {
                Object[] objArr3 = this.f22404b;
                objArr3[length] = objArr3[i14];
                f.d(objArr3, objArr3, i14, i14 + 1, i12 + 1);
            } else {
                Object[] objArr4 = this.f22404b;
                f.d(objArr4, objArr4, i14 - 1, i14, objArr4.length);
                Object[] objArr5 = this.f22404b;
                objArr5[objArr5.length - 1] = objArr5[0];
                f.d(objArr5, objArr5, 0, 1, i12 + 1);
            }
            this.f22404b[i12] = e9;
            this.f22403a = length;
        } else {
            int iN2 = n(i11 + this.f22403a);
            if (iN < iN2) {
                Object[] objArr6 = this.f22404b;
                f.d(objArr6, objArr6, iN + 1, iN, iN2);
            } else {
                Object[] objArr7 = this.f22404b;
                f.d(objArr7, objArr7, 1, 0, iN2);
                Object[] objArr8 = this.f22404b;
                objArr8[0] = objArr8[objArr8.length - 1];
                f.d(objArr8, objArr8, iN + 1, iN, objArr8.length - 1);
            }
            this.f22404b[iN] = e9;
        }
        this.f22405c++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        int length = array.length;
        int i9 = this.f22405c;
        if (length < i9) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i9);
            kotlin.jvm.internal.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (T[]) ((Object[]) objNewInstance);
        }
        int iN = n(this.f22405c + this.f22403a);
        int i10 = this.f22403a;
        if (i10 < iN) {
            f.e(this.f22404b, array, i10, iN, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f22404b;
            f.d(objArr, array, 0, this.f22403a, objArr.length);
            Object[] objArr2 = this.f22404b;
            f.d(objArr2, array, objArr2.length - this.f22403a, 0, iN);
        }
        int i11 = this.f22405c;
        if (i11 < array.length) {
            array[i11] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i9, Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        b.a aVar = b.Companion;
        int i10 = this.f22405c;
        aVar.getClass();
        b.a.b(i9, i10);
        if (elements.isEmpty()) {
            return false;
        }
        if (i9 == this.f22405c) {
            return addAll(elements);
        }
        o();
        i(elements.size() + this.f22405c);
        int iN = n(this.f22405c + this.f22403a);
        int iN2 = n(this.f22403a + i9);
        int size = elements.size();
        if (i9 < ((this.f22405c + 1) >> 1)) {
            int i11 = this.f22403a;
            int length = i11 - size;
            if (iN2 < i11) {
                Object[] objArr = this.f22404b;
                f.d(objArr, objArr, length, i11, objArr.length);
                if (size >= iN2) {
                    Object[] objArr2 = this.f22404b;
                    f.d(objArr2, objArr2, objArr2.length - size, 0, iN2);
                } else {
                    Object[] objArr3 = this.f22404b;
                    f.d(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f22404b;
                    f.d(objArr4, objArr4, 0, size, iN2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f22404b;
                f.d(objArr5, objArr5, length, i11, iN2);
            } else {
                Object[] objArr6 = this.f22404b;
                length += objArr6.length;
                int i12 = iN2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    f.d(objArr6, objArr6, length, i11, iN2);
                } else {
                    f.d(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f22404b;
                    f.d(objArr7, objArr7, 0, this.f22403a + length2, iN2);
                }
            }
            this.f22403a = length;
            h(l(iN2 - size), elements);
            return true;
        }
        int i13 = iN2 + size;
        if (iN2 < iN) {
            int i14 = size + iN;
            Object[] objArr8 = this.f22404b;
            if (i14 <= objArr8.length) {
                f.d(objArr8, objArr8, i13, iN2, iN);
            } else if (i13 >= objArr8.length) {
                f.d(objArr8, objArr8, i13 - objArr8.length, iN2, iN);
            } else {
                int length3 = iN - (i14 - objArr8.length);
                f.d(objArr8, objArr8, 0, length3, iN);
                Object[] objArr9 = this.f22404b;
                f.d(objArr9, objArr9, i13, iN2, length3);
            }
        } else {
            Object[] objArr10 = this.f22404b;
            f.d(objArr10, objArr10, size, 0, iN);
            Object[] objArr11 = this.f22404b;
            if (i13 >= objArr11.length) {
                f.d(objArr11, objArr11, i13 - objArr11.length, iN2, objArr11.length);
            } else {
                f.d(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.f22404b;
                f.d(objArr12, objArr12, i13, iN2, objArr12.length - size);
            }
        }
        h(iN2, elements);
        return true;
    }
}
