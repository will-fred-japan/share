package p113p;

import java.util.HashMap;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f20736e = new HashMap<>();

    @Override // p113p.b
    public final b.c<K, V> f(K k7) {
        return this.f20736e.get(k7);
    }

    @Override // p113p.b
    public final V g(K k7) {
        V v5 = (V) super.g(k7);
        this.f20736e.remove(k7);
        return v5;
    }
}
