package com.google.crypto.tink.shaded.protobuf;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes.dex */
public class h0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f14075g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f14076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<K, V> f14078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile h0<K, V>.c f14080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<K, V> f14081f;

    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class a implements Map.Entry<K, V>, Comparable<h0<K, V>.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f14082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f14083b;

        public a() {
            throw null;
        }

        public a(K k7, V v5) {
            this.f14082a = k7;
            this.f14083b = v5;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f14082a.compareTo(((a) obj).f14082a);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean zEquals;
            boolean zEquals2;
            if (obj != this) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    K k7 = this.f14082a;
                    if (k7 == null) {
                        zEquals = key == null;
                    } else {
                        zEquals = k7.equals(key);
                    }
                    if (zEquals) {
                        V v5 = this.f14083b;
                        Object value = entry.getValue();
                        if (v5 == null) {
                            zEquals2 = value == null;
                        } else {
                            zEquals2 = v5.equals(value);
                        }
                        if (zEquals2) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f14082a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f14083b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k7 = this.f14082a;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v5 = this.f14083b;
            return (v5 != null ? v5.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            int i9 = h0.f14075g;
            h0.this.b();
            V v8 = this.f14083b;
            this.f14083b = v5;
            return v8;
        }

        public final String toString() {
            return this.f14082a + ContainerUtils.KEY_VALUE_DELIMITER + this.f14083b;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class b implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14085a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f14087c;

        public b() {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f14087c == null) {
                this.f14087c = h0.this.f14078c.entrySet().iterator();
            }
            return this.f14087c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i9 = this.f14085a + 1;
            h0 h0Var = h0.this;
            return i9 < h0Var.f14077b || (!h0Var.f14078c.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f14086b = true;
            int i9 = this.f14085a + 1;
            this.f14085a = i9;
            h0 h0Var = h0.this;
            return i9 < h0Var.f14077b ? (a) h0Var.f14076a[i9] : a().next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f14086b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f14086b = false;
            int i9 = h0.f14075g;
            h0 h0Var = h0.this;
            h0Var.b();
            int i10 = this.f14085a;
            if (i10 >= h0Var.f14077b) {
                a().remove();
            } else {
                this.f14085a = i10 - 1;
                h0Var.h(i10);
            }
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class c extends AbstractSet<Map.Entry<K, V>> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            h0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            h0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = h0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            h0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return h0.this.size();
        }
    }

    public h0() {
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f14078c = map;
        this.f14081f = map;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0030 A[SYNTHETIC] */
    public final int a(K k7) {
        int i9;
        int i10;
        int i11;
        int iCompareTo;
        int i12 = this.f14077b;
        int i13 = i12 - 1;
        if (i13 < 0) {
            i9 = 0;
            while (i9 <= i13) {
                i11 = (i9 + i13) / 2;
                iCompareTo = k7.compareTo(((a) this.f14076a[i11]).f14082a);
                if (iCompareTo < 0) {
                    i13 = i11 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i11;
                    }
                    i9 = i11 + 1;
                }
            }
            i10 = i9 + 1;
        } else {
            int iCompareTo2 = k7.compareTo(((a) this.f14076a[i13]).f14082a);
            if (iCompareTo2 > 0) {
                i10 = i12 + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i13;
                }
                i9 = 0;
                while (i9 <= i13) {
                    i11 = (i9 + i13) / 2;
                    iCompareTo = k7.compareTo(((a) this.f14076a[i11]).f14082a);
                    if (iCompareTo < 0) {
                        i13 = i11 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i11;
                        }
                        i9 = i11 + 1;
                    }
                }
                i10 = i9 + 1;
            }
        }
        return -i10;
    }

    public final void b() {
        if (this.f14079d) {
            throw new UnsupportedOperationException();
        }
    }

    public final a c(int i9) {
        if (i9 < this.f14077b) {
            return (a) this.f14076a[i9];
        }
        throw new ArrayIndexOutOfBoundsException(i9);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (this.f14077b != 0) {
            this.f14076a = null;
            this.f14077b = 0;
        }
        if (this.f14078c.isEmpty()) {
            return;
        }
        this.f14078c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f14078c.containsKey(comparable);
    }

    public final Set d() {
        return this.f14078c.isEmpty() ? Collections.EMPTY_SET : this.f14078c.entrySet();
    }

    public final SortedMap<K, V> e() {
        b();
        if (this.f14078c.isEmpty() && !(this.f14078c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f14078c = treeMap;
            this.f14081f = treeMap.descendingMap();
        }
        return (SortedMap) this.f14078c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.f14080e == null) {
            this.f14080e = new c();
        }
        return this.f14080e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        int size = size();
        if (size == h0Var.size()) {
            int i9 = this.f14077b;
            if (i9 != h0Var.f14077b) {
                return ((AbstractSet) entrySet()).equals(h0Var.entrySet());
            }
            for (int i10 = 0; i10 < i9; i10++) {
                if (c(i10).equals(h0Var.c(i10))) {
                }
            }
            if (i9 != size) {
                return this.f14078c.equals(h0Var.f14078c);
            }
            return true;
        }
        return false;
    }

    public void f() {
        if (this.f14079d) {
            return;
        }
        this.f14078c = this.f14078c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f14078c);
        this.f14081f = this.f14081f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f14081f);
        this.f14079d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final V put(K k7, V v5) {
        b();
        int iA = a(k7);
        if (iA >= 0) {
            return (V) ((a) this.f14076a[iA]).setValue(v5);
        }
        b();
        if (this.f14076a == null) {
            this.f14076a = new Object[16];
        }
        int i9 = -(iA + 1);
        if (i9 >= 16) {
            return e().put(k7, v5);
        }
        int i10 = this.f14077b;
        if (i10 == 16) {
            a aVar = (a) this.f14076a[15];
            this.f14077b = i10 - 1;
            e().put(aVar.f14082a, aVar.f14083b);
        }
        Object[] objArr = this.f14076a;
        System.arraycopy(objArr, i9, objArr, i9 + 1, (objArr.length - i9) - 1);
        this.f14076a[i9] = new a(k7, v5);
        this.f14077b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((a) this.f14076a[iA]).f14083b : this.f14078c.get(comparable);
    }

    public final V h(int i9) {
        b();
        Object[] objArr = this.f14076a;
        V v5 = ((a) objArr[i9]).f14083b;
        System.arraycopy(objArr, i9 + 1, objArr, i9, (this.f14077b - i9) - 1);
        this.f14077b--;
        if (!this.f14078c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = e().entrySet().iterator();
            Object[] objArr2 = this.f14076a;
            int i10 = this.f14077b;
            Map.Entry<K, V> next = it.next();
            objArr2[i10] = new a(next.getKey(), next.getValue());
            this.f14077b++;
            it.remove();
        }
        return v5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i9 = this.f14077b;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            iHashCode += this.f14076a[i10].hashCode();
        }
        return this.f14078c.size() > 0 ? this.f14078c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f14078c.isEmpty()) {
            return null;
        }
        return this.f14078c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f14078c.size() + this.f14077b;
    }
}
