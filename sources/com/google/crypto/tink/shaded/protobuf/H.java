package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LongArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class H extends AbstractC0564c<Long> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f14004d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f14005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14006c;

    static {
        long[] jArr = new long[0];
        f14004d = jArr;
        new H(jArr, 0, false);
    }

    public H() {
        this(f14004d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        long jLongValue = ((Long) obj).longValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f14006c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14006c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        long[] jArr = this.f14005b;
        if (i10 < jArr.length) {
            System.arraycopy(jArr, i9, jArr, i9 + 1, i10 - i9);
        } else {
            long[] jArr2 = new long[W5.f.i(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14005b, 0, jArr2, 0, i9);
            System.arraycopy(this.f14005b, i9, jArr2, i9 + 1, this.f14006c - i9);
            this.f14005b = jArr2;
        }
        this.f14005b[i9] = jLongValue;
        this.f14006c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        f();
        Charset charset = C0585y.f14183a;
        collection.getClass();
        if (!(collection instanceof H)) {
            return super.addAll(collection);
        }
        H h9 = (H) collection;
        int i9 = h9.f14006c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f14006c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        long[] jArr = this.f14005b;
        if (i11 > jArr.length) {
            this.f14005b = Arrays.copyOf(jArr, i11);
        }
        System.arraycopy(h9.f14005b, 0, this.f14005b, this.f14006c, h9.f14006c);
        this.f14006c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.c
    public final C0585y.c c(int i9) {
        if (i9 >= this.f14006c) {
            return new H(i9 == 0 ? f14004d : Arrays.copyOf(this.f14005b, i9), this.f14006c, true);
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
        if (!(obj instanceof H)) {
            return super.equals(obj);
        }
        H h9 = (H) obj;
        if (this.f14006c != h9.f14006c) {
            return false;
        }
        long[] jArr = h9.f14005b;
        for (int i9 = 0; i9 < this.f14006c; i9++) {
            if (this.f14005b[i9] != jArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j) {
        f();
        int i9 = this.f14006c;
        long[] jArr = this.f14005b;
        if (i9 == jArr.length) {
            long[] jArr2 = new long[W5.f.i(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f14005b, 0, jArr2, 0, this.f14006c);
            this.f14005b = jArr2;
        }
        long[] jArr3 = this.f14005b;
        int i10 = this.f14006c;
        this.f14006c = i10 + 1;
        jArr3[i10] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return Long.valueOf(i(i9));
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f14006c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f14006c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i9 = 0; i9 < this.f14006c; i9++) {
            iB = (iB * 31) + C0585y.b(this.f14005b[i9]);
        }
        return iB;
    }

    public final long i(int i9) {
        h(i9);
        return this.f14005b[i9];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i9 = this.f14006c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f14005b[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0564c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        long[] jArr = this.f14005b;
        long j = jArr[i9];
        int i10 = this.f14006c;
        if (i9 < i10 - 1) {
            System.arraycopy(jArr, i9 + 1, jArr, i9, (i10 - i9) - 1);
        }
        this.f14006c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f14005b;
        System.arraycopy(jArr, i10, jArr, i9, this.f14006c - i10);
        this.f14006c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        f();
        h(i9);
        long[] jArr = this.f14005b;
        long j = jArr[i9];
        jArr[i9] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14006c;
    }

    public H(long[] jArr, int i9, boolean z8) {
        super(z8);
        this.f14005b = jArr;
        this.f14006c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }
}
