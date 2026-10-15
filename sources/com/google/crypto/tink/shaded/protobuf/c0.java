package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: ProtobufArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class c0<E> extends AbstractC0564c<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f14045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0<Object> f14046e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E[] f14047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14048c;

    static {
        Object[] objArr = new Object[0];
        f14045d = objArr;
        f14046e = new c0<>(0, false, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(int i9, boolean z8, Object[] objArr) {
        super(z8);
        this.f14047b = objArr;
        this.f14048c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e9) {
        f();
        int i9 = this.f14048c;
        E[] eArr = this.f14047b;
        if (i9 == eArr.length) {
            this.f14047b = (E[]) Arrays.copyOf(this.f14047b, W5.f.i(eArr.length, 3, 2, 1, 10));
        }
        E[] eArr2 = this.f14047b;
        int i10 = this.f14048c;
        this.f14048c = i10 + 1;
        eArr2[i10] = e9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14048c) {
            return new c0(this.f14048c, true, i9 == 0 ? f14045d : Arrays.copyOf(this.f14047b, i9));
        }
        throw new IllegalArgumentException();
    }

    public final void g(int i9) {
        if (i9 < 0 || i9 >= this.f14048c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14048c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i9) {
        g(i9);
        return this.f14047b[i9];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final E remove(int i9) {
        f();
        g(i9);
        E[] eArr = this.f14047b;
        E e9 = eArr[i9];
        int i10 = this.f14048c;
        if (i9 < i10 - 1) {
            System.arraycopy(eArr, i9 + 1, eArr, i9, (i10 - i9) - 1);
        }
        this.f14048c--;
        ((AbstractList) this).modCount++;
        return e9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i9, E e9) {
        f();
        g(i9);
        E[] eArr = this.f14047b;
        E e10 = eArr[i9];
        eArr[i9] = e9;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14048c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, E e9) {
        int i10;
        f();
        if (i9 >= 0 && i9 <= (i10 = this.f14048c)) {
            E[] eArr = this.f14047b;
            if (i10 < eArr.length) {
                System.arraycopy(eArr, i9, eArr, i9 + 1, i10 - i9);
            } else {
                E[] eArr2 = (E[]) new Object[W5.f.i(eArr.length, 3, 2, 1, 10)];
                System.arraycopy(this.f14047b, 0, eArr2, 0, i9);
                System.arraycopy(this.f14047b, i9, eArr2, i9 + 1, this.f14048c - i9);
                this.f14047b = eArr2;
            }
            this.f14047b[i9] = e9;
            this.f14048c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
        sbA.append(this.f14048c);
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
