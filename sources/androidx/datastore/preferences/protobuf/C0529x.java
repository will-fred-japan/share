package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: IntArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0529x extends AbstractC0509c<Integer> implements RandomAccess, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7342c;

    static {
        new C0529x(new int[0], 0, false);
    }

    public C0529x() {
        this(new int[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f7342c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7342c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        int[] iArr = this.f7341b;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i9, iArr, i9 + 1, i10 - i9);
        } else {
            int[] iArr2 = new int[((i10 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            System.arraycopy(this.f7341b, i9, iArr2, i9 + 1, this.f7342c - i9);
            this.f7341b = iArr2;
        }
        this.f7341b[i9] = iIntValue;
        this.f7342c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        f();
        Charset charset = C0530y.f7343a;
        collection.getClass();
        if (!(collection instanceof C0529x)) {
            return super.addAll(collection);
        }
        C0529x c0529x = (C0529x) collection;
        int i9 = c0529x.f7342c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f7342c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        int[] iArr = this.f7341b;
        if (i11 > iArr.length) {
            this.f7341b = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(c0529x.f7341b, 0, this.f7341b, this.f7342c, c0529x.f7342c);
        this.f7342c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 >= this.f7342c) {
            return new C0529x(Arrays.copyOf(this.f7341b, i9), this.f7342c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0529x)) {
            return super.equals(obj);
        }
        C0529x c0529x = (C0529x) obj;
        if (this.f7342c != c0529x.f7342c) {
            return false;
        }
        int[] iArr = c0529x.f7341b;
        for (int i9 = 0; i9 < this.f7342c; i9++) {
            if (this.f7341b[i9] != iArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i9) {
        f();
        int i10 = this.f7342c;
        int[] iArr = this.f7341b;
        if (i10 == iArr.length) {
            int[] iArr2 = new int[((i10 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            this.f7341b = iArr2;
        }
        int[] iArr3 = this.f7341b;
        int i11 = this.f7342c;
        this.f7342c = i11 + 1;
        iArr3[i11] = i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return Integer.valueOf(i(i9));
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f7342c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7342c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i9 = 1;
        for (int i10 = 0; i10 < this.f7342c; i10++) {
            i9 = (i9 * 31) + this.f7341b[i10];
        }
        return i9;
    }

    public final int i(int i9) {
        h(i9);
        return this.f7341b[i9];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i9 = this.f7342c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f7341b[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        int[] iArr = this.f7341b;
        int i10 = iArr[i9];
        int i11 = this.f7342c;
        if (i9 < i11 - 1) {
            System.arraycopy(iArr, i9 + 1, iArr, i9, (i11 - i9) - 1);
        }
        this.f7342c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f7341b;
        System.arraycopy(iArr, i10, iArr, i9, this.f7342c - i10);
        this.f7342c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        f();
        h(i9);
        int[] iArr = this.f7341b;
        int i10 = iArr[i9];
        iArr[i9] = iIntValue;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7342c;
    }

    public C0529x(int[] iArr, int i9, boolean z8) {
        super(z8);
        this.f7341b = iArr;
        this.f7342c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
