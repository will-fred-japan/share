package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: ProtobufArrayList.java */
/* JADX INFO: loaded from: classes.dex */
public final class d0<E> extends AbstractC0509c<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0<Object> f7211d = new d0<>(0, false, new Object[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E[] f7212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7213c;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(int i9, boolean z8, Object[] objArr) {
        super(z8);
        this.f7212b = objArr;
        this.f7213c = i9;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e9) {
        f();
        int i9 = this.f7213c;
        E[] eArr = this.f7212b;
        if (i9 == eArr.length) {
            this.f7212b = (E[]) Arrays.copyOf(eArr, ((i9 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f7212b;
        int i10 = this.f7213c;
        this.f7213c = i10 + 1;
        eArr2[i10] = e9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final C0530y.c c(int i9) {
        if (i9 < this.f7213c) {
            throw new IllegalArgumentException();
        }
        return new d0(this.f7213c, true, Arrays.copyOf(this.f7212b, i9));
    }

    public final void g(int i9) {
        if (i9 < 0 || i9 >= this.f7213c) {
            StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
            sbA.append(this.f7213c);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i9) {
        g(i9);
        return this.f7212b[i9];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0509c, java.util.AbstractList, java.util.List
    public final E remove(int i9) {
        f();
        g(i9);
        E[] eArr = this.f7212b;
        E e9 = eArr[i9];
        int i10 = this.f7213c;
        if (i9 < i10 - 1) {
            System.arraycopy(eArr, i9 + 1, eArr, i9, (i10 - i9) - 1);
        }
        this.f7213c--;
        ((AbstractList) this).modCount++;
        return e9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i9, E e9) {
        f();
        g(i9);
        E[] eArr = this.f7212b;
        E e10 = eArr[i9];
        eArr[i9] = e9;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7213c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, E e9) {
        int i10;
        f();
        if (i9 >= 0 && i9 <= (i10 = this.f7213c)) {
            E[] eArr = this.f7212b;
            if (i10 < eArr.length) {
                System.arraycopy(eArr, i9, eArr, i9 + 1, i10 - i9);
            } else {
                E[] eArr2 = (E[]) new Object[((i10 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i9);
                System.arraycopy(this.f7212b, i9, eArr2, i9 + 1, this.f7213c - i9);
                this.f7212b = eArr2;
            }
            this.f7212b[i9] = e9;
            this.f7213c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbA = C0524s.a(i9, "Index:", ", Size:");
        sbA.append(this.f7213c);
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
