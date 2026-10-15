package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends h0<C0579s.a<Object>, Object> {
    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void f() {
        if (!this.f14079d) {
            for (int i9 = 0; i9 < this.f14077b; i9++) {
                ((C0579s.a) c(i9).f14082a).getClass();
            }
            Iterator it = d().iterator();
            while (it.hasNext()) {
                ((C0579s.a) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        super.f();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Comparable) obj, obj2);
    }
}
