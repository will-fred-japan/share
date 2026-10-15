package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DoubleArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0518l extends AbstractC0509c<Double> implements RandomAccess, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f7278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7279c;

    static {
        new C0518l(new double[0], 0, false);
    }

    public C0518l() {
        this(new double[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        double dDoubleValue = ((Double) obj).doubleValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f7279c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7279c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        double[] dArr = this.f7278b;
        if (i10 < dArr.length) {
            System.arraycopy(dArr, i9, dArr, i9 + 1, i10 - i9);
        } else {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i9);
            System.arraycopy(this.f7278b, i9, dArr2, i9 + 1, this.f7279c - i9);
            this.f7278b = dArr2;
        }
        this.f7278b[i9] = dDoubleValue;
        this.f7279c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        f();
        Charset charset = C0530y.f7343a;
        collection.getClass();
        if (!(collection instanceof C0518l)) {
            return super.addAll(collection);
        }
        C0518l c0518l = (C0518l) collection;
        int i9 = c0518l.f7279c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f7279c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        double[] dArr = this.f7278b;
        if (i11 > dArr.length) {
            this.f7278b = Arrays.copyOf(dArr, i11);
        }
        System.arraycopy(c0518l.f7278b, 0, this.f7278b, this.f7279c, c0518l.f7279c);
        this.f7279c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 >= this.f7279c) {
            return new C0518l(Arrays.copyOf(this.f7278b, i9), this.f7279c, true);
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
        if (!(obj instanceof C0518l)) {
            return super.equals(obj);
        }
        C0518l c0518l = (C0518l) obj;
        if (this.f7279c != c0518l.f7279c) {
            return false;
        }
        double[] dArr = c0518l.f7278b;
        for (int i9 = 0; i9 < this.f7279c; i9++) {
            if (Double.doubleToLongBits(this.f7278b[i9]) != Double.doubleToLongBits(dArr[i9])) {
                return false;
            }
        }
        return true;
    }

    public final void g(double d9) {
        f();
        int i9 = this.f7279c;
        double[] dArr = this.f7278b;
        if (i9 == dArr.length) {
            double[] dArr2 = new double[((i9 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i9);
            this.f7278b = dArr2;
        }
        double[] dArr3 = this.f7278b;
        int i10 = this.f7279c;
        this.f7279c = i10 + 1;
        dArr3[i10] = d9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Double.valueOf(this.f7278b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f7279c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7279c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i9 = 0; i9 < this.f7279c; i9++) {
            iB = (iB * 31) + C0530y.b(Double.doubleToLongBits(this.f7278b[i9]));
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i9 = this.f7279c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f7278b[i10] == dDoubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        double[] dArr = this.f7278b;
        double d9 = dArr[i9];
        int i10 = this.f7279c;
        if (i9 < i10 - 1) {
            System.arraycopy(dArr, i9 + 1, dArr, i9, (i10 - i9) - 1);
        }
        this.f7279c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d9);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f7278b;
        System.arraycopy(dArr, i10, dArr, i9, this.f7279c - i10);
        this.f7279c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        f();
        h(i9);
        double[] dArr = this.f7278b;
        double d9 = dArr[i9];
        dArr[i9] = dDoubleValue;
        return Double.valueOf(d9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7279c;
    }

    public C0518l(double[] dArr, int i9, boolean z8) {
        super(z8);
        this.f7278b = dArr;
        this.f7279c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Double) obj).doubleValue());
        return true;
    }
}
