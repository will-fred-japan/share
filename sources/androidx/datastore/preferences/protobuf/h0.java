package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends i0<r.a<Object>, Object> {
    @Override // androidx.datastore.preferences.protobuf.i0
    public final void f() {
        if (!this.f7256c) {
            for (int i9 = 0; i9 < this.f7254a.size(); i9++) {
                c(i9).getKey().getClass();
            }
            Iterator it = d().iterator();
            while (it.hasNext()) {
                ((r.a) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        super.f();
    }

    @Override // androidx.datastore.preferences.protobuf.i0, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Comparable) obj, obj2);
    }
}
