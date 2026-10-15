package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* JADX INFO: compiled from: MapFieldSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class M implements L {
    @Override // androidx.datastore.preferences.protobuf.L
    public final K a(Object obj, Object obj2) {
        K kC = (K) obj;
        K k7 = (K) obj2;
        if (!k7.isEmpty()) {
            if (!kC.f7175a) {
                kC = kC.c();
            }
            kC.b();
            if (!k7.isEmpty()) {
                kC.putAll(k7);
            }
        }
        return kC;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final int b(int i9, Object obj, Object obj2) {
        K k7 = (K) obj;
        J j = (J) obj2;
        int iD = 0;
        if (k7.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : k7.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            j.getClass();
            int iC = AbstractC0516j.C(i9);
            int iA = J.a(j.f7170a, key, value);
            iD += AbstractC0516j.D(iA) + iA + iC;
        }
        return iD;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean c(Object obj) {
        return !((K) obj).f7175a;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final Object d(Object obj) {
        ((K) obj).f7175a = false;
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final J.a<?, ?> e(Object obj) {
        return ((J) obj).f7170a;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final K f() {
        return K.f7174b.c();
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final K g(Object obj) {
        return (K) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final K h(Object obj) {
        return (K) obj;
    }
}
