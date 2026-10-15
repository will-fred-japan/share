package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: MapFieldSchemaLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class M implements L {
    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final K a(Object obj, Object obj2) {
        K k7 = (K) obj;
        K k8 = (K) obj2;
        if (!k8.isEmpty()) {
            if (!k7.f14011a) {
                if (k7.isEmpty()) {
                    k7 = new K();
                } else {
                    K k9 = new K(k7);
                    k9.f14011a = true;
                    k7 = k9;
                }
            }
            k7.b();
            if (!k8.isEmpty()) {
                k7.putAll(k8);
            }
        }
        return k7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final int b(int i9, Object obj, Object obj2) {
        K k7 = (K) obj;
        J j = (J) obj2;
        if (k7.isEmpty()) {
            return 0;
        }
        Iterator it = k7.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        j.getClass();
        AbstractC0572k.C(i9);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final boolean c(Object obj) {
        return !((K) obj).f14011a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final Object d(Object obj) {
        ((K) obj).f14011a = false;
        return obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final void e(Object obj) {
        ((J) obj).getClass();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final K f() {
        K<?, ?> k7 = K.f14010b;
        if (k7.isEmpty()) {
            return new K();
        }
        K k8 = new K(k7);
        k8.f14011a = true;
        return k8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final K g(Object obj) {
        return (K) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.L
    public final K h(Object obj) {
        return (K) obj;
    }
}
