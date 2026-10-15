package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: MapEntryLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class J<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V> f7170a;

    /* JADX INFO: compiled from: MapEntryLite.java */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.a f7171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0.c f7172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p007b0.f f7173c;

        public a(r0.a aVar, r0.c cVar, p007b0.f fVar) {
            this.f7171a = aVar;
            this.f7172b = cVar;
            this.f7173c = fVar;
        }
    }

    public J(r0.a aVar, r0.c cVar, p007b0.f fVar) {
        this.f7170a = new a<>(aVar, cVar, fVar);
    }

    public static <K, V> int a(a<K, V> aVar, K k7, V v5) {
        return r.b(aVar.f7172b, 2, v5) + r.b(aVar.f7171a, 1, k7);
    }

    public static <K, V> void b(AbstractC0516j abstractC0516j, a<K, V> aVar, K k7, V v5) {
        r.k(abstractC0516j, aVar.f7171a, 1, k7);
        r.k(abstractC0516j, aVar.f7172b, 2, v5);
    }
}
