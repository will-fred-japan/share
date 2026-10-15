package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FloatArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0581u extends AbstractC0564c<Float> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f14166d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f14167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14168c;

    static {
        float[] fArr = new float[0];
        f14166d = fArr;
        new C0581u(fArr, 0, false);
    }

    public C0581u() {
        this(f14166d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        float fFloatValue = ((Float) obj).floatValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f14168c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14168c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        float[] fArr = this.f14167b;
        if (i10 < fArr.length) {
            System.arraycopy(fArr, i9, fArr, i9 + 1, i10 - i9);
        } else {
            float[] fArr2 = new float[W5.f.i(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14167b, 0, fArr2, 0, i9);
            System.arraycopy(this.f14167b, i9, fArr2, i9 + 1, this.f14168c - i9);
            this.f14167b = fArr2;
        }
        this.f14167b[i9] = fFloatValue;
        this.f14168c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        f();
        Charset charset = C0585y.f14183a;
        collection.getClass();
        if (!(collection instanceof C0581u)) {
            return super.addAll(collection);
        }
        C0581u c0581u = (C0581u) collection;
        int i9 = c0581u.f14168c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f14168c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        float[] fArr = this.f14167b;
        if (i11 > fArr.length) {
            this.f14167b = Arrays.copyOf(fArr, i11);
        }
        System.arraycopy(c0581u.f14167b, 0, this.f14167b, this.f14168c, c0581u.f14168c);
        this.f14168c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14168c) {
            return new C0581u(i9 == 0 ? f14166d : Arrays.copyOf(this.f14167b, i9), this.f14168c, true);
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
        if (!(obj instanceof C0581u)) {
            return super.equals(obj);
        }
        C0581u c0581u = (C0581u) obj;
        if (this.f14168c != c0581u.f14168c) {
            return false;
        }
        float[] fArr = c0581u.f14167b;
        for (int i9 = 0; i9 < this.f14168c; i9++) {
            if (Float.floatToIntBits(this.f14167b[i9]) != Float.floatToIntBits(fArr[i9])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f6) {
        f();
        int i9 = this.f14168c;
        float[] fArr = this.f14167b;
        if (i9 == fArr.length) {
            float[] fArr2 = new float[W5.f.i(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14167b, 0, fArr2, 0, this.f14168c);
            this.f14167b = fArr2;
        }
        float[] fArr3 = this.f14167b;
        int i10 = this.f14168c;
        this.f14168c = i10 + 1;
        fArr3[i10] = f6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        h(i9);
        return Float.valueOf(this.f14167b[i9]);
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f14168c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14168c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i9 = 0; i9 < this.f14168c; i9++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f14167b[i9]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i9 = this.f14168c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f14167b[i10] == fFloatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        float[] fArr = this.f14167b;
        float f6 = fArr[i9];
        int i10 = this.f14168c;
        if (i9 < i10 - 1) {
            System.arraycopy(fArr, i9 + 1, fArr, i9, (i10 - i9) - 1);
        }
        this.f14168c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f14167b;
        System.arraycopy(fArr, i10, fArr, i9, this.f14168c - i10);
        this.f14168c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        f();
        h(i9);
        float[] fArr = this.f14167b;
        float f6 = fArr[i9];
        fArr[i9] = fFloatValue;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14168c;
    }

    public C0581u(float[] fArr, int i9, boolean z8) {
        super(z8);
        this.f14167b = fArr;
        this.f14168c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Float) obj).floatValue());
        return true;
    }
}
