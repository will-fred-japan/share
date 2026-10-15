package p113p;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<K, V> f20737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f20738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f20739c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20740d = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class a<K, V> extends e<K, V> {
        @Override // p.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f20744d;
        }

        @Override // p.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f20743c;
        }
    }

    /* JADX INFO: renamed from: p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class C0242b<K, V> extends e<K, V> {
        @Override // p.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f20743c;
        }

        @Override // p.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f20744d;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f20741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f20742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<K, V> f20743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c<K, V> f20744d;

        public c(K k7, V v5) {
            this.f20741a = k7;
            this.f20742b = v5;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f20741a.equals(cVar.f20741a) && this.f20742b.equals(cVar.f20742b);
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f20741a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f20742b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f20741a.hashCode() ^ this.f20742b.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f20741a + ContainerUtils.KEY_VALUE_DELIMITER + this.f20742b;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f20745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20746b = true;

        public d() {
        }

        @Override // p.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f20745a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f20744d;
                this.f20745a = cVar3;
                this.f20746b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f20746b) {
                return b.this.f20737a != null;
            }
            c<K, V> cVar = this.f20745a;
            return (cVar == null || cVar.f20743c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f20746b) {
                this.f20746b = false;
                this.f20745a = b.this.f20737a;
            } else {
                c<K, V> cVar = this.f20745a;
                this.f20745a = cVar != null ? cVar.f20743c : null;
            }
            return this.f20745a;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f20748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f20749b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f20748a = cVar2;
            this.f20749b = cVar;
        }

        @Override // p.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVarC = null;
            if (this.f20748a == cVar && cVar == this.f20749b) {
                this.f20749b = null;
                this.f20748a = null;
            }
            c<K, V> cVar2 = this.f20748a;
            if (cVar2 == cVar) {
                this.f20748a = b(cVar2);
            }
            c<K, V> cVar3 = this.f20749b;
            if (cVar3 == cVar) {
                c<K, V> cVar4 = this.f20748a;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarC = c(cVar3);
                }
                this.f20749b = cVarC;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f20749b != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> cVar = this.f20749b;
            c<K, V> cVar2 = this.f20748a;
            this.f20749b = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public final boolean equals(Object obj) {
        e eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f20740d != bVar.f20740d) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (true) {
            eVar = (e) it;
            if (!eVar.hasNext()) {
                break;
            }
            e eVar2 = (e) it2;
            if (!eVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            Object next = eVar2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (eVar.hasNext() || ((e) it2).hasNext()) ? false : true;
    }

    public c<K, V> f(K k7) {
        c<K, V> cVar = this.f20737a;
        while (cVar != null && !cVar.f20741a.equals(k7)) {
            cVar = cVar.f20743c;
        }
        return cVar;
    }

    public V g(K k7) {
        c<K, V> cVarF = f(k7);
        if (cVarF == null) {
            return null;
        }
        this.f20740d--;
        WeakHashMap<f<K, V>, Boolean> weakHashMap = this.f20739c;
        if (!weakHashMap.isEmpty()) {
            Iterator<f<K, V>> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarF);
            }
        }
        c<K, V> cVar = cVarF.f20744d;
        if (cVar != null) {
            cVar.f20743c = cVarF.f20743c;
        } else {
            this.f20737a = cVarF.f20743c;
        }
        c<K, V> cVar2 = cVarF.f20743c;
        if (cVar2 != null) {
            cVar2.f20744d = cVar;
        } else {
            this.f20738b = cVar;
        }
        cVarF.f20743c = null;
        cVarF.f20744d = null;
        return cVarF.f20742b;
    }

    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f20737a, this.f20738b);
        this.f20739c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
