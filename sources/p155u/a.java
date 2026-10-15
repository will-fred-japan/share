package p155u;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<K, V> extends g<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a<K, V>.C0269a f21628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a<K, V>.c f21629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<K, V>.e f21630f;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayMap.java */
    public final class C0269a extends AbstractSet<Map.Entry<K, V>> {
        public C0269a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a.this.f21660c;
        }
    }

    /* JADX INFO: compiled from: ArrayMap.java */
    public final class b extends p155u.c<K> {
        public b() {
            super(a.this.f21660c);
        }

        @Override // p155u.c
        public final K a(int i9) {
            return a.this.f(i9);
        }

        @Override // p155u.c
        public final void b(int i9) {
            a.this.g(i9);
        }
    }

    /* JADX INFO: compiled from: ArrayMap.java */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21635b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21636c;

        public d() {
            this.f21634a = a.this.f21660c - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f21636c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i9 = this.f21635b;
            a aVar = a.this;
            return k.a(key, aVar.f(i9)) && k.a(entry.getValue(), aVar.i(this.f21635b));
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.f21636c) {
                return a.this.f(this.f21635b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.f21636c) {
                return a.this.i(this.f21635b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f21635b < this.f21634a;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f21636c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            int i9 = this.f21635b;
            a aVar = a.this;
            K kF = aVar.f(i9);
            V vI = aVar.i(this.f21635b);
            return (kF == null ? 0 : kF.hashCode()) ^ (vI != null ? vI.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f21635b++;
            this.f21636c = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f21636c) {
                throw new IllegalStateException();
            }
            a.this.g(this.f21635b);
            this.f21635b--;
            this.f21634a--;
            this.f21636c = false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            if (this.f21636c) {
                return a.this.h(this.f21635b, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    /* JADX INFO: compiled from: ArrayMap.java */
    public final class f extends p155u.c<V> {
        public f() {
            super(a.this.f21660c);
        }

        @Override // p155u.c
        public final V a(int i9) {
            return a.this.i(i9);
        }

        @Override // p155u.c
        public final void b(int i9) {
            a.this.g(i9);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(g gVar) {
        super(0);
        if (gVar != null) {
            int i9 = gVar.f21660c;
            b(this.f21660c + i9);
            if (this.f21660c != 0) {
                for (int i10 = 0; i10 < i9; i10++) {
                    put(gVar.f(i10), gVar.i(i10));
                }
            } else if (i9 > 0) {
                y7.f.b(0, 0, gVar.f21658a, this.f21658a, i9);
                y7.f.d(gVar.f21659b, this.f21659b, 0, 0, i9 << 1);
                this.f21660c = i9;
            }
        }
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        a<K, V>.C0269a c0269a = this.f21628d;
        if (c0269a != null) {
            return c0269a;
        }
        a<K, V>.C0269a c0269a2 = new C0269a();
        this.f21628d = c0269a2;
        return c0269a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(Collection<?> collection) {
        int i9 = this.f21660c;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i9 != this.f21660c;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        a<K, V>.c cVar = this.f21629e;
        if (cVar != null) {
            return cVar;
        }
        a<K, V>.c cVar2 = new c();
        this.f21629e = cVar2;
        return cVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f21660c);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        a<K, V>.e eVar = this.f21630f;
        if (eVar != null) {
            return eVar;
        }
        a<K, V>.e eVar2 = new e();
        this.f21630f = eVar2;
        return eVar2;
    }

    /* JADX INFO: compiled from: ArrayMap.java */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k7) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            return a.this.j(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            a aVar = a.this;
            try {
                return aVar.f21660c == set.size() && aVar.j(set);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            a aVar = a.this;
            int iHashCode = 0;
            for (int i9 = aVar.f21660c - 1; i9 >= 0; i9--) {
                K kF = aVar.f(i9);
                iHashCode += kF == null ? 0 : kF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            a aVar = a.this;
            int iD = aVar.d(obj);
            if (iD < 0) {
                return false;
            }
            aVar.g(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            return a.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            for (int i10 = i9 - 1; i10 >= 0; i10--) {
                if (!collection.contains(aVar.f(i10))) {
                    aVar.g(i10);
                }
            }
            return i9 != aVar.f21660c;
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return a.this.f21660c;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            Object[] objArr = new Object[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                objArr[i10] = aVar.f(i10);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            if (tArr.length < i9) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i9));
            }
            for (int i10 = 0; i10 < i9; i10++) {
                tArr[i10] = aVar.f(i10);
            }
            if (tArr.length > i9) {
                tArr[i9] = null;
            }
            return tArr;
        }
    }

    /* JADX INFO: compiled from: ArrayMap.java */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public final boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            a.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return a.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            a aVar = a.this;
            int iA = aVar.a(obj);
            if (iA < 0) {
                return false;
            }
            aVar.g(iA);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            int i10 = 0;
            boolean z8 = false;
            while (i10 < i9) {
                if (collection.contains(aVar.i(i10))) {
                    aVar.g(i10);
                    i10--;
                    i9--;
                    z8 = true;
                }
                i10++;
            }
            return z8;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            int i10 = 0;
            boolean z8 = false;
            while (i10 < i9) {
                if (!collection.contains(aVar.i(i10))) {
                    aVar.g(i10);
                    i10--;
                    i9--;
                    z8 = true;
                }
                i10++;
            }
            return z8;
        }

        @Override // java.util.Collection
        public final int size() {
            return a.this.f21660c;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            Object[] objArr = new Object[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                objArr[i10] = aVar.i(i10);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            a aVar = a.this;
            int i9 = aVar.f21660c;
            if (tArr.length < i9) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i9));
            }
            for (int i10 = 0; i10 < i9; i10++) {
                tArr[i10] = aVar.i(i10);
            }
            if (tArr.length > i9) {
                tArr[i9] = null;
            }
            return tArr;
        }
    }

    public a() {
    }
}
