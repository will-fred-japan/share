package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FloatArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0526u extends AbstractC0509c<Float> implements RandomAccess, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f7329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7330c;

    static {
        new C0526u(new float[0], 0, false);
    }

    public C0526u() {
        this(new float[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        float fFloatValue = ((Float) obj).floatValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f7330c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7330c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        float[] fArr = this.f7329b;
        if (i10 < fArr.length) {
            System.arraycopy(fArr, i9, fArr, i9 + 1, i10 - i9);
        } else {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i9);
            System.arraycopy(this.f7329b, i9, fArr2, i9 + 1, this.f7330c - i9);
            this.f7329b = fArr2;
        }
        this.f7329b[i9] = fFloatValue;
        this.f7330c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        f();
        Charset charset = C0530y.f7343a;
        collection.getClass();
        if (!(collection instanceof C0526u)) {
            return super.addAll(collection);
        }
        C0526u c0526u = (C0526u) collection;
        int i9 = c0526u.f7330c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f7330c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        float[] fArr = this.f7329b;
        if (i11 > fArr.length) {
            this.f7329b = Arrays.copyOf(fArr, i11);
        }
        System.arraycopy(c0526u.f7329b, 0, this.f7329b, this.f7330c, c0526u.f7330c);
        this.f7330c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 >= this.f7330c) {
            return new C0526u(Arrays.copyOf(this.f7329b, i9), this.f7330c, true);
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
        if (!(obj instanceof C0526u)) {
            return super.equals(obj);
        }
        C0526u c0526u = (C0526u) obj;
        if (this.f7330c != c0526u.f7330c) {
            return false;
        }
        float[] fArr = c0526u.f7329b;
        for (int i9 = 0; i9 < this.f7330c; i9++) {
            if (Float.floatToIntBits(this.f7329b[i9]) != Float.floatToIntBits(fArr[i9])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f6) {
        f();
        int i9 = this.f7330c;
        float[] fArr = this.f7329b;
        if (i9 == fArr.length) {
            float[] fArr2 = new float[((i9 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i9);
            this.f7329b = fArr2;
        }
        float[] fArr3 = this.f7329b;
        int i10 = this.f7330c;
        this.f7330c = i10 + 1;
        fArr3[i10] = f6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Float.valueOf(this.f7329b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f7330c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7330c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i9 = 0; i9 < this.f7330c; i9++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f7329b[i9]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i9 = this.f7330c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f7329b[i10] == fFloatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        float[] fArr = this.f7329b;
        float f6 = fArr[i9];
        int i10 = this.f7330c;
        if (i9 < i10 - 1) {
            System.arraycopy(fArr, i9 + 1, fArr, i9, (i10 - i9) - 1);
        }
        this.f7330c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f7329b;
        System.arraycopy(fArr, i10, fArr, i9, this.f7330c - i10);
        this.f7330c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        f();
        h(i9);
        float[] fArr = this.f7329b;
        float f6 = fArr[i9];
        fArr[i9] = fFloatValue;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7330c;
    }

    public C0526u(float[] fArr, int i9, boolean z8) {
        super(z8);
        this.f7329b = fArr;
        this.f7330c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Float) obj).floatValue());
        return true;
    }
}
