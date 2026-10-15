package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BooleanArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0511e extends AbstractC0509c<Boolean> implements RandomAccess, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f7214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7215c;

    static {
        new C0511e(new boolean[0], 0, false);
    }

    public C0511e() {
        this(new boolean[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f7215c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7215c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        boolean[] zArr = this.f7214b;
        if (i10 < zArr.length) {
            System.arraycopy(zArr, i9, zArr, i9 + 1, i10 - i9);
        } else {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i9);
            System.arraycopy(this.f7214b, i9, zArr2, i9 + 1, this.f7215c - i9);
            this.f7214b = zArr2;
        }
        this.f7214b[i9] = zBooleanValue;
        this.f7215c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        f();
        Charset charset = C0530y.f7343a;
        collection.getClass();
        if (!(collection instanceof C0511e)) {
            return super.addAll(collection);
        }
        C0511e c0511e = (C0511e) collection;
        int i9 = c0511e.f7215c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f7215c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        boolean[] zArr = this.f7214b;
        if (i11 > zArr.length) {
            this.f7214b = Arrays.copyOf(zArr, i11);
        }
        System.arraycopy(c0511e.f7214b, 0, this.f7214b, this.f7215c, c0511e.f7215c);
        this.f7215c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 >= this.f7215c) {
            return new C0511e(Arrays.copyOf(this.f7214b, i9), this.f7215c, true);
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
        if (!(obj instanceof C0511e)) {
            return super.equals(obj);
        }
        C0511e c0511e = (C0511e) obj;
        if (this.f7215c != c0511e.f7215c) {
            return false;
        }
        boolean[] zArr = c0511e.f7214b;
        for (int i9 = 0; i9 < this.f7215c; i9++) {
            if (this.f7214b[i9] != zArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(boolean z8) {
        f();
        int i9 = this.f7215c;
        boolean[] zArr = this.f7214b;
        if (i9 == zArr.length) {
            boolean[] zArr2 = new boolean[((i9 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i9);
            this.f7214b = zArr2;
        }
        boolean[] zArr3 = this.f7214b;
        int i10 = this.f7215c;
        this.f7215c = i10 + 1;
        zArr3[i10] = z8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Boolean.valueOf(this.f7214b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f7215c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7215c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i9 = 1;
        for (int i10 = 0; i10 < this.f7215c; i10++) {
            int i11 = i9 * 31;
            boolean z8 = this.f7214b[i10];
            Charset charset = C0530y.f7343a;
            i9 = i11 + (z8 ? 1231 : 1237);
        }
        return i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i9 = this.f7215c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f7214b[i10] == zBooleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        boolean[] zArr = this.f7214b;
        boolean z8 = zArr[i9];
        int i10 = this.f7215c;
        if (i9 < i10 - 1) {
            System.arraycopy(zArr, i9 + 1, zArr, i9, (i10 - i9) - 1);
        }
        this.f7215c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f7214b;
        System.arraycopy(zArr, i10, zArr, i9, this.f7215c - i10);
        this.f7215c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        f();
        h(i9);
        boolean[] zArr = this.f7214b;
        boolean z8 = zArr[i9];
        zArr[i9] = zBooleanValue;
        return Boolean.valueOf(z8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7215c;
    }

    public C0511e(boolean[] zArr, int i9, boolean z8) {
        super(z8);
        this.f7214b = zArr;
        this.f7215c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Boolean) obj).booleanValue());
        return true;
    }
}
