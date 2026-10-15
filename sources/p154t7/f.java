package p154t7;

import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.k;
import p096m7.r;
import y7.h;

/* JADX INFO: compiled from: MessagesAsync.g.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends r {
    @Override // p096m7.r
    public final Object f(byte b9, ByteBuffer buffer) {
        k.e(buffer, "buffer");
        if (b9 == -127) {
            Long l8 = (Long) e(buffer);
            if (l8 != null) {
                int iLongValue = (int) l8.longValue();
                u.f21620b.getClass();
                for (u uVar : u.values()) {
                    if (uVar.f21625a == iLongValue) {
                        return uVar;
                    }
                }
            }
        } else if (b9 == -126) {
            Object objE = e(buffer);
            List list = objE instanceof List ? (List) objE : null;
            if (list != null) {
                String str = (String) list.get(0);
                Object obj = list.get(1);
                k.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                return new n(str, ((Boolean) obj).booleanValue());
            }
        } else {
            if (b9 != -125) {
                return super.f(b9, buffer);
            }
            Object objE2 = e(buffer);
            List list2 = objE2 instanceof List ? (List) objE2 : null;
            if (list2 != null) {
                String str2 = (String) list2.get(0);
                Object obj2 = list2.get(1);
                k.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
                return new w(str2, (u) obj2);
            }
        }
        return null;
    }

    @Override // p096m7.r
    public final void k(r.a aVar, Object obj) {
        if (obj instanceof u) {
            aVar.write(129);
            k(aVar, Long.valueOf(((u) obj).f21625a));
        } else if (obj instanceof n) {
            aVar.write(130);
            k(aVar, ((n) obj).a());
        } else {
            if (!(obj instanceof w)) {
                super.k(aVar, obj);
                return;
            }
            aVar.write(131);
            w wVar = (w) obj;
            k(aVar, h.C(wVar.f21626a, wVar.f21627b));
        }
    }
}
