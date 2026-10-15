package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractProtobufList.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0509c<E> extends AbstractList<E> implements C0530y.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7205a;

    public AbstractC0509c(boolean z8) {
        this.f7205a = z8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        f();
        return super.addAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final void b() {
        if (this.f7205a) {
            this.f7205a = false;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        super.clear();
    }

    @Override // androidx.datastore.preferences.protobuf.C0530y.c
    public final boolean e() {
        return this.f7205a;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i9 = 0; i9 < size; i9++) {
            if (!get(i9).equals(list.get(i9))) {
                return false;
            }
        }
        return true;
    }

    public final void f() {
        if (!this.f7205a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i9 = 0; i9 < size; i9++) {
            iHashCode = (iHashCode * 31) + get(i9).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E remove(int i9);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<?> collection) {
        f();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<?> collection) {
        f();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i9, Collection<? extends E> collection) {
        f();
        return super.addAll(i9, collection);
    }
}
