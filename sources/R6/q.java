package R6;

import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends p096m7.r {
    @Override // p096m7.r
    public final Object f(byte b9, ByteBuffer buffer) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        if (b9 == -127) {
            Long l8 = (Long) e(buffer);
            if (l8 != null) {
                int iLongValue = (int) l8.longValue();
                l.f4058b.getClass();
                for (l lVar : l.values()) {
                    if (lVar.f4061a == iLongValue) {
                        return lVar;
                    }
                }
            }
        } else if (b9 == -126) {
            Object objE = e(buffer);
            List list = objE instanceof List ? (List) objE : null;
            if (list != null) {
                Object obj = list.get(0);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type dev.flutter.packages.file_selector_android.FileSelectorExceptionCode");
                Object obj2 = list.get(1);
                kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                return new m((l) obj, (String) obj2);
            }
        } else if (b9 == -125) {
            Object objE2 = e(buffer);
            List list2 = objE2 instanceof List ? (List) objE2 : null;
            if (list2 != null) {
                Object obj3 = list2.get(0);
                kotlin.jvm.internal.k.c(obj3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj3;
                String str2 = (String) list2.get(1);
                String str3 = (String) list2.get(2);
                Object obj4 = list2.get(3);
                kotlin.jvm.internal.k.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                long jLongValue = ((Long) obj4).longValue();
                Object obj5 = list2.get(4);
                kotlin.jvm.internal.k.c(obj5, "null cannot be cast to non-null type kotlin.ByteArray");
                return new a(str, str2, str3, jLongValue, (byte[]) obj5, (m) list2.get(5));
            }
        } else {
            if (b9 != -124) {
                return super.f(b9, buffer);
            }
            Object objE3 = e(buffer);
            List list3 = objE3 instanceof List ? (List) objE3 : null;
            if (list3 != null) {
                Object obj6 = list3.get(0);
                kotlin.jvm.internal.k.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                Object obj7 = list3.get(1);
                kotlin.jvm.internal.k.c(obj7, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                return new n((List) obj6, (List) obj7);
            }
        }
        return null;
    }

    @Override // p096m7.r
    public final void k(m7.r.a aVar, Object obj) {
        if (obj instanceof l) {
            aVar.write(129);
            k(aVar, Long.valueOf(((l) obj).f4061a));
            return;
        }
        if (obj instanceof m) {
            aVar.write(130);
            m mVar = (m) obj;
            k(aVar, y7.h.C(mVar.f4062a, mVar.f4063b));
        } else if (obj instanceof a) {
            aVar.write(131);
            a aVar2 = (a) obj;
            k(aVar, y7.h.C(aVar2.f4030a, aVar2.f4031b, aVar2.f4032c, Long.valueOf(aVar2.f4033d), aVar2.f4034e, aVar2.f4035f));
        } else {
            if (!(obj instanceof n)) {
                super.k(aVar, obj);
                return;
            }
            aVar.write(132);
            n nVar = (n) obj;
            k(aVar, y7.h.C(nVar.f4064a, nVar.f4065b));
        }
    }
}
