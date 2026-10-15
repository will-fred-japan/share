package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MapFieldLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class K<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final K<?, ?> f7174b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7175a = true;

    static {
        K<?, ?> k7 = new K<>();
        f7174b = k7;
        k7.f7175a = false;
    }

    public static int a(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof C0530y.a) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = C0530y.f7343a;
        int length = bArr.length;
        for (byte b9 : bArr) {
            length = (length * 31) + b9;
        }
        if (length == 0) {
            return 1;
        }
        return length;
    }

    public final void b() {
        if (!this.f7175a) {
            throw new UnsupportedOperationException();
        }
    }

    public final K<K, V> c() {
        if (isEmpty()) {
            return new K<>();
        }
        K<K, V> k7 = new K<>(this);
        k7.f7175a = true;
        return k7;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean z8;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<K, V> next = it.next();
                            if (map.containsKey(next.getKey())) {
                                V value = next.getValue();
                                Object obj2 = map.get(next.getKey());
                                if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                                }
                            }
                        } else {
                            z8 = true;
                        }
                    }
                }
                z8 = false;
            } else {
                z8 = true;
            }
            if (z8) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iA = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iA += a(entry.getValue()) ^ a(entry.getKey());
        }
        return iA;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k7, V v5) {
        b();
        Charset charset = C0530y.f7343a;
        k7.getClass();
        v5.getClass();
        return (V) super.put(k7, v5);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b();
        for (K k7 : map.keySet()) {
            Charset charset = C0530y.f7343a;
            k7.getClass();
            map.get(k7).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        return (V) super.remove(obj);
    }
}
