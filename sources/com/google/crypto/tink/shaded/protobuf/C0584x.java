package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: IntArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0584x extends AbstractC0564c<Integer> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f14180d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f14181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14182c;

    static {
        int[] iArr = new int[0];
        f14180d = iArr;
        new C0584x(iArr, 0, false);
    }

    public C0584x() {
        this(f14180d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f14182c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14182c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        int[] iArr = this.f14181b;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i9, iArr, i9 + 1, i10 - i9);
        } else {
            int[] iArr2 = new int[W5.f.i(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14181b, 0, iArr2, 0, i9);
            System.arraycopy(this.f14181b, i9, iArr2, i9 + 1, this.f14182c - i9);
            this.f14181b = iArr2;
        }
        this.f14181b[i9] = iIntValue;
        this.f14182c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        f();
        Charset charset = C0585y.f14183a;
        collection.getClass();
        if (!(collection instanceof C0584x)) {
            return super.addAll(collection);
        }
        C0584x c0584x = (C0584x) collection;
        int i9 = c0584x.f14182c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f14182c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        int[] iArr = this.f14181b;
        if (i11 > iArr.length) {
            this.f14181b = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(c0584x.f14181b, 0, this.f14181b, this.f14182c, c0584x.f14182c);
        this.f14182c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14182c) {
            return new C0584x(i9 == 0 ? f14180d : Arrays.copyOf(this.f14181b, i9), this.f14182c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0584x)) {
            return super.equals(obj);
        }
        C0584x c0584x = (C0584x) obj;
        if (this.f14182c != c0584x.f14182c) {
            return false;
        }
        int[] iArr = c0584x.f14181b;
        for (int i9 = 0; i9 < this.f14182c; i9++) {
            if (this.f14181b[i9] != iArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i9) {
        f();
        int i10 = this.f14182c;
        int[] iArr = this.f14181b;
        if (i10 == iArr.length) {
            int[] iArr2 = new int[W5.f.i(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14181b, 0, iArr2, 0, this.f14182c);
            this.f14181b = iArr2;
        }
        int[] iArr3 = this.f14181b;
        int i11 = this.f14182c;
        this.f14182c = i11 + 1;
        iArr3[i11] = i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return Integer.valueOf(i(i9));
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f14182c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14182c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i9 = 1;
        for (int i10 = 0; i10 < this.f14182c; i10++) {
            i9 = (i9 * 31) + this.f14181b[i10];
        }
        return i9;
    }

    public final int i(int i9) {
        h(i9);
        return this.f14181b[i9];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i9 = this.f14182c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f14181b[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        int[] iArr = this.f14181b;
        int i10 = iArr[i9];
        int i11 = this.f14182c;
        if (i9 < i11 - 1) {
            System.arraycopy(iArr, i9 + 1, iArr, i9, (i11 - i9) - 1);
        }
        this.f14182c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f14181b;
        System.arraycopy(iArr, i10, iArr, i9, this.f14182c - i10);
        this.f14182c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        f();
        h(i9);
        int[] iArr = this.f14181b;
        int i10 = iArr[i9];
        iArr[i9] = iIntValue;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14182c;
    }

    public C0584x(int[] iArr, int i9, boolean z8) {
        super(z8);
        this.f14181b = iArr;
        this.f14182c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
