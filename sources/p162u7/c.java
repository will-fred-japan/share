package p162u7;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import p056h5.C0598e;
import p096m7.r;
import y7.h;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends r {
    @Override // p096m7.r
    public final Object f(byte b9, ByteBuffer buffer) {
        k.e(buffer, "buffer");
        if (b9 == -127) {
            Object objE = e(buffer);
            List list = objE instanceof List ? (List) objE : null;
            if (list != null) {
                Object obj = list.get(0);
                k.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Object obj2 = list.get(1);
                k.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                Object obj3 = list.get(2);
                k.c(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                return new j(zBooleanValue, zBooleanValue2, (Map) obj3);
            }
        } else {
            if (b9 != -126) {
                return super.f(b9, buffer);
            }
            Object objE2 = e(buffer);
            List list2 = objE2 instanceof List ? (List) objE2 : null;
            if (list2 != null) {
                Object obj4 = list2.get(0);
                k.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                return new a(((Boolean) obj4).booleanValue());
            }
        }
        return null;
    }

    @Override // p096m7.r
    public final void k(r.a aVar, Object obj) {
        if (obj instanceof j) {
            aVar.write(129);
            j jVar = (j) obj;
            k(aVar, h.C(Boolean.valueOf(jVar.f21765a), Boolean.valueOf(jVar.f21766b), jVar.f21767c));
        } else if (!(obj instanceof a)) {
            super.k(aVar, obj);
        } else {
            aVar.write(130);
            k(aVar, C0598e.y(Boolean.valueOf(((a) obj).f21751a)));
        }
    }
}
