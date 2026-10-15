package androidx.datastore.preferences.protobuf;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes.dex */
public class i0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f7253f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<i0<K, V>.a> f7254a = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<K, V> f7255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile i0<K, V>.c f7257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<K, V> f7258e;

    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class a implements Map.Entry<K, V>, Comparable<i0<K, V>.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f7259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f7260b;

        public a() {
            throw null;
        }

        public a(K k7, V v5) {
            this.f7259a = k7;
            this.f7260b = v5;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f7259a.compareTo(((a) obj).f7259a);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean zEquals;
            boolean zEquals2;
            if (obj != this) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    K k7 = this.f7259a;
                    if (k7 == null) {
                        zEquals = key == null;
                    } else {
                        zEquals = k7.equals(key);
                    }
                    if (zEquals) {
                        V v5 = this.f7260b;
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
            return this.f7259a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f7260b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k7 = this.f7259a;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v5 = this.f7260b;
            return (v5 != null ? v5.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            int i9 = i0.f7253f;
            i0.this.b();
            V v8 = this.f7260b;
            this.f7260b = v5;
            return v8;
        }

        public final String toString() {
            return this.f7259a + ContainerUtils.KEY_VALUE_DELIMITER + this.f7260b;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class b implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7262a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f7264c;

        public b() {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f7264c == null) {
                this.f7264c = i0.this.f7255b.entrySet().iterator();
            }
            return this.f7264c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i9 = this.f7262a + 1;
            i0 i0Var = i0.this;
            return i9 < i0Var.f7254a.size() || (!i0Var.f7255b.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f7263b = true;
            int i9 = this.f7262a + 1;
            this.f7262a = i9;
            i0 i0Var = i0.this;
            return i9 < i0Var.f7254a.size() ? i0Var.f7254a.get(this.f7262a) : a().next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f7263b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f7263b = false;
            int i9 = i0.f7253f;
            i0 i0Var = i0.this;
            i0Var.b();
            if (this.f7262a >= i0Var.f7254a.size()) {
                a().remove();
                return;
            }
            int i10 = this.f7262a;
            this.f7262a = i10 - 1;
            i0Var.h(i10);
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
            i0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            i0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = i0.this.get(entry.getKey());
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
            i0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return i0.this.size();
        }
    }

    public i0() {
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f7255b = map;
        this.f7258e = map;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0038 A[SYNTHETIC] */
    public final int a(K k7) {
        int i9;
        int i10;
        int i11;
        int iCompareTo;
        int size = this.f7254a.size();
        int i12 = size - 1;
        if (i12 < 0) {
            i9 = 0;
            while (i9 <= i12) {
                i11 = (i9 + i12) / 2;
                iCompareTo = k7.compareTo(this.f7254a.get(i11).f7259a);
                if (iCompareTo < 0) {
                    i12 = i11 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i11;
                    }
                    i9 = i11 + 1;
                }
            }
            i10 = i9 + 1;
        } else {
            int iCompareTo2 = k7.compareTo(this.f7254a.get(i12).f7259a);
            if (iCompareTo2 > 0) {
                i10 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i12;
                }
                i9 = 0;
                while (i9 <= i12) {
                    i11 = (i9 + i12) / 2;
                    iCompareTo = k7.compareTo(this.f7254a.get(i11).f7259a);
                    if (iCompareTo < 0) {
                        i12 = i11 - 1;
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
        if (this.f7256c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry<K, V> c(int i9) {
        return this.f7254a.get(i9);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f7254a.isEmpty()) {
            this.f7254a.clear();
        }
        if (this.f7255b.isEmpty()) {
            return;
        }
        this.f7255b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f7255b.containsKey(comparable);
    }

    public final Set d() {
        return this.f7255b.isEmpty() ? Collections.EMPTY_SET : this.f7255b.entrySet();
    }

    public final SortedMap<K, V> e() {
        b();
        if (this.f7255b.isEmpty() && !(this.f7255b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7255b = treeMap;
            this.f7258e = treeMap.descendingMap();
        }
        return (SortedMap) this.f7255b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.f7257d == null) {
            this.f7257d = new c();
        }
        return this.f7257d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return super.equals(obj);
        }
        i0 i0Var = (i0) obj;
        int size = size();
        if (size == i0Var.size()) {
            int size2 = this.f7254a.size();
            if (size2 != i0Var.f7254a.size()) {
                return ((AbstractSet) entrySet()).equals(i0Var.entrySet());
            }
            for (int i9 = 0; i9 < size2; i9++) {
                if (c(i9).equals(i0Var.c(i9))) {
                }
            }
            if (size2 != size) {
                return this.f7255b.equals(i0Var.f7255b);
            }
            return true;
        }
        return false;
    }

    public void f() {
        if (this.f7256c) {
            return;
        }
        this.f7255b = this.f7255b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f7255b);
        this.f7258e = this.f7258e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f7258e);
        this.f7256c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final V put(K k7, V v5) {
        b();
        int iA = a(k7);
        if (iA >= 0) {
            return this.f7254a.get(iA).setValue(v5);
        }
        b();
        if (this.f7254a.isEmpty() && !(this.f7254a instanceof ArrayList)) {
            this.f7254a = new ArrayList(16);
        }
        int i9 = -(iA + 1);
        if (i9 >= 16) {
            return e().put(k7, v5);
        }
        if (this.f7254a.size() == 16) {
            i0<K, V>.a aVarRemove = this.f7254a.remove(15);
            e().put(aVarRemove.f7259a, aVarRemove.f7260b);
        }
        this.f7254a.add(i9, new a(k7, v5));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.f7254a.get(iA).f7260b : this.f7255b.get(comparable);
    }

    public final V h(int i9) {
        b();
        V v5 = this.f7254a.remove(i9).f7260b;
        if (!this.f7255b.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = e().entrySet().iterator();
            List<i0<K, V>.a> list = this.f7254a;
            Map.Entry<K, V> next = it.next();
            list.add(new a(next.getKey(), next.getValue()));
            it.remove();
        }
        return v5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f7254a.size();
        int iHashCode = 0;
        for (int i9 = 0; i9 < size; i9++) {
            iHashCode += this.f7254a.get(i9).hashCode();
        }
        return this.f7255b.size() > 0 ? this.f7255b.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f7255b.isEmpty()) {
            return null;
        }
        return this.f7255b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f7255b.size() + this.f7254a.size();
    }
}
