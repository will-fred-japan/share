package defpackage;

import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.k;
import p056h5.C0598e;
import p096m7.r;

/* JADX INFO: compiled from: WakelockPlusMessages.g.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends r {
    @Override // p096m7.r
    public final Object f(byte b9, ByteBuffer buffer) {
        k.e(buffer, "buffer");
        if (b9 == -127) {
            Object objE = e(buffer);
            List list = objE instanceof List ? (List) objE : null;
            if (list != null) {
                return new b((Boolean) list.get(0));
            }
        } else {
            if (b9 != -126) {
                return super.f(b9, buffer);
            }
            Object objE2 = e(buffer);
            List list2 = objE2 instanceof List ? (List) objE2 : null;
            if (list2 != null) {
                return new a((Boolean) list2.get(0));
            }
        }
        return null;
    }

    @Override // p096m7.r
    public final void k(r.a aVar, Object obj) {
        if (obj instanceof b) {
            aVar.write(129);
            k(aVar, C0598e.y(((b) obj).f8468a));
        } else if (!(obj instanceof a)) {
            super.k(aVar, obj);
        } else {
            aVar.write(130);
            k(aVar, C0598e.y(((a) obj).f5669a));
        }
    }
}
