package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LongArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class H extends AbstractC0509c<Long> implements RandomAccess, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f7165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7166c;

    static {
        new H(new long[0], 0, false);
    }

    public H() {
        this(new long[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        long jLongValue = ((Long) obj).longValue();
        f();
        if (i9 < 0 || i9 > (i10 = this.f7166c)) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7166c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        long[] jArr = this.f7165b;
        if (i10 < jArr.length) {
            System.arraycopy(jArr, i9, jArr, i9 + 1, i10 - i9);
        } else {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i9);
            System.arraycopy(this.f7165b, i9, jArr2, i9 + 1, this.f7166c - i9);
            this.f7165b = jArr2;
        }
        this.f7165b[i9] = jLongValue;
        this.f7166c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        f();
        Charset charset = C0530y.f7343a;
        collection.getClass();
        if (!(collection instanceof H)) {
            return super.addAll(collection);
        }
        H h9 = (H) collection;
        int i9 = h9.f7166c;
        if (i9 == 0) {
            return false;
        }
        int i10 = this.f7166c;
        if (Integer.MAX_VALUE - i10 < i9) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i9;
        long[] jArr = this.f7165b;
        if (i11 > jArr.length) {
            this.f7165b = Arrays.copyOf(jArr, i11);
        }
        System.arraycopy(h9.f7165b, 0, this.f7165b, this.f7166c, h9.f7166c);
        this.f7166c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 >= this.f7166c) {
            return new H(Arrays.copyOf(this.f7165b, i9), this.f7166c, true);
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
        if (!(obj instanceof H)) {
            return super.equals(obj);
        }
        H h9 = (H) obj;
        if (this.f7166c != h9.f7166c) {
            return false;
        }
        long[] jArr = h9.f7165b;
        for (int i9 = 0; i9 < this.f7166c; i9++) {
            if (this.f7165b[i9] != jArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j) {
        f();
        int i9 = this.f7166c;
        long[] jArr = this.f7165b;
        if (i9 == jArr.length) {
            long[] jArr2 = new long[((i9 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i9);
            this.f7165b = jArr2;
        }
        long[] jArr3 = this.f7165b;
        int i10 = this.f7166c;
        this.f7166c = i10 + 1;
        jArr3[i10] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return Long.valueOf(i(i9));
    }

    public final void h(int i9) {
        if (i9 < 0 || i9 >= this.f7166c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7166c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i9 = 0; i9 < this.f7166c; i9++) {
            iB = (iB * 31) + C0530y.b(this.f7165b[i9]);
        }
        return iB;
    }

    public final long i(int i9) {
        h(i9);
        return this.f7165b[i9];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i9 = this.f7166c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (this.f7165b[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        f();
        h(i9);
        long[] jArr = this.f7165b;
        long j = jArr[i9];
        int i10 = this.f7166c;
        if (i9 < i10 - 1) {
            System.arraycopy(jArr, i9 + 1, jArr, i9, (i10 - i9) - 1);
        }
        this.f7166c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        f();
        if (i10 < i9) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f7165b;
        System.arraycopy(jArr, i10, jArr, i9, this.f7166c - i10);
        this.f7166c -= i10 - i9;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        f();
        h(i9);
        long[] jArr = this.f7165b;
        long j = jArr[i9];
        jArr[i9] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7166c;
    }

    public H(long[] jArr, int i9, boolean z8) {
        super(z8);
        this.f7165b = jArr;
        this.f7166c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }
}
