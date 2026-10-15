package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DoubleArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0574m extends AbstractC0564c<Double> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double[] f14125d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f14126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14127c;

    static {
        double[] dArr = new double[0];
        f14125d = dArr;
        new C0574m(dArr, 0, false);
    }

    public C0574m() {
        this(f14125d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        double dDoubleValue = ((Double) obj).doubleValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f14127c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14127c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        double[] dArr = this.f14126b;
        if (i10 < dArr.length) {
            System.arraycopy(dArr, i9, dArr, i9 + 1, i10 - i9);
        } else {
            double[] dArr2 = new double[W5.f.i(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14126b, 0, dArr2, 0, i9);
            System.arraycopy(this.f14126b, i9, dArr2, i9 + 1, this.f14127c - i9);
            this.f14126b = dArr2;
        }
        this.f14126b[i9] = dDoubleValue;
        this.f14127c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        f();
        Charset charset = C0585y.f14183a;
        collection.getClass();
        if (!(collection instanceof C0574m)) {
            return super.addAll(collection);
        }
        C0574m c0574m = (C0574m) collection;
        int i9 = c0574m.f14127c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f14127c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        double[] dArr = this.f14126b;
        if (i11 > dArr.length) {
            this.f14126b = Arrays.copyOf(dArr, i11);
        }
        System.arraycopy(c0574m.f14126b, 0, this.f14126b, this.f14127c, c0574m.f14127c);
        this.f14127c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14127c) {
            return new C0574m(i9 == 0 ? f14125d : Arrays.copyOf(this.f14126b, i9), this.f14127c, true);
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
        if (!(obj instanceof C0574m)) {
            return super.equals(obj);
        }
        C0574m c0574m = (C0574m) obj;
        if (this.f14127c != c0574m.f14127c) {
            return false;
        }
        double[] dArr = c0574m.f14126b;
        for (int i9 = 0; i9 < this.f14127c; i9++) {
            if (Double.doubleToLongBits(this.f14126b[i9]) != Double.doubleToLongBits(dArr[i9])) {
                return false;
            }
        }
        return true;
    }

    public final void g(double d9) {
        f();
        int i9 = this.f14127c;
        double[] dArr = this.f14126b;
        if (i9 == dArr.length) {
            double[] dArr2 = new double[W5.f.i(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14126b, 0, dArr2, 0, this.f14127c);
            this.f14126b = dArr2;
        }
        double[] dArr3 = this.f14126b;
        int i10 = this.f14127c;
        this.f14127c = i10 + 1;
        dArr3[i10] = d9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Double.valueOf(this.f14126b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f14127c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14127c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i9 = 0; i9 < this.f14127c; i9++) {
            iB = (iB * 31) + C0585y.b(Double.doubleToLongBits(this.f14126b[i9]));
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i9 = this.f14127c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f14126b[i10] == dDoubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        double[] dArr = this.f14126b;
        double d9 = dArr[i9];
        int i10 = this.f14127c;
        if (i9 < i10 - 1) {
            System.arraycopy(dArr, i9 + 1, dArr, i9, (i10 - i9) - 1);
        }
        this.f14127c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d9);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f14126b;
        System.arraycopy(dArr, i10, dArr, i9, this.f14127c - i10);
        this.f14127c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        f();
        h(i9);
        double[] dArr = this.f14126b;
        double d9 = dArr[i9];
        dArr[i9] = dDoubleValue;
        return Double.valueOf(d9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14127c;
    }

    public C0574m(double[] dArr, int i9, boolean z8) {
        super(z8);
        this.f14126b = dArr;
        this.f14127c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Double) obj).doubleValue());
        return true;
    }
}
