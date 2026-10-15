package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BooleanArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0567f extends AbstractC0564c<Boolean> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean[] f14060d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f14061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14062c;

    static {
        boolean[] zArr = new boolean[0];
        f14060d = zArr;
        new C0567f(zArr, 0, false);
    }

    public C0567f() {
        this(f14060d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f14062c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14062c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        boolean[] zArr = this.f14061b;
        if (i10 < zArr.length) {
            System.arraycopy(zArr, i9, zArr, i9 + 1, i10 - i9);
        } else {
            boolean[] zArr2 = new boolean[W5.f.i(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14061b, 0, zArr2, 0, i9);
            System.arraycopy(this.f14061b, i9, zArr2, i9 + 1, this.f14062c - i9);
            this.f14061b = zArr2;
        }
        this.f14061b[i9] = zBooleanValue;
        this.f14062c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        f();
        Charset charset = C0585y.f14183a;
        collection.getClass();
        if (!(collection instanceof C0567f)) {
            return super.addAll(collection);
        }
        C0567f c0567f = (C0567f) collection;
        int i9 = c0567f.f14062c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f14062c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        boolean[] zArr = this.f14061b;
        if (i11 > zArr.length) {
            this.f14061b = Arrays.copyOf(zArr, i11);
        }
        System.arraycopy(c0567f.f14061b, 0, this.f14061b, this.f14062c, c0567f.f14062c);
        this.f14062c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14062c) {
            return new C0567f(i9 == 0 ? f14060d : Arrays.copyOf(this.f14061b, i9), this.f14062c, true);
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
        if (!(obj instanceof C0567f)) {
            return super.equals(obj);
        }
        C0567f c0567f = (C0567f) obj;
        if (this.f14062c != c0567f.f14062c) {
            return false;
        }
        boolean[] zArr = c0567f.f14061b;
        for (int i9 = 0; i9 < this.f14062c; i9++) {
            if (this.f14061b[i9] != zArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(boolean z8) {
        f();
        int i9 = this.f14062c;
        boolean[] zArr = this.f14061b;
        if (i9 == zArr.length) {
            boolean[] zArr2 = new boolean[W5.f.i(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14061b, 0, zArr2, 0, this.f14062c);
            this.f14061b = zArr2;
        }
        boolean[] zArr3 = this.f14061b;
        int i10 = this.f14062c;
        this.f14062c = i10 + 1;
        zArr3[i10] = z8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Boolean.valueOf(this.f14061b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f14062c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14062c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i9 = 1;
        for (int i10 = 0; i10 < this.f14062c; i10++) {
            int i11 = i9 * 31;
            boolean z8 = this.f14061b[i10];
            Charset charset = C0585y.f14183a;
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
        int i9 = this.f14062c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f14061b[i10] == zBooleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        boolean[] zArr = this.f14061b;
        boolean z8 = zArr[i9];
        int i10 = this.f14062c;
        if (i9 < i10 - 1) {
            System.arraycopy(zArr, i9 + 1, zArr, i9, (i10 - i9) - 1);
        }
        this.f14062c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f14061b;
        System.arraycopy(zArr, i10, zArr, i9, this.f14062c - i10);
        this.f14062c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        f();
        h(i9);
        boolean[] zArr = this.f14061b;
        boolean z8 = zArr[i9];
        zArr[i9] = zBooleanValue;
        return Boolean.valueOf(z8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14062c;
    }

    public C0567f(boolean[] zArr, int i9, boolean z8) {
        super(z8);
        this.f14061b = zArr;
        this.f14062c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Boolean) obj).booleanValue());
        return true;
    }
}
