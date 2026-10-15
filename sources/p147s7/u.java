package p147s7;

import com.jieli.jl_bt_ota.constant.GattError;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.k;
import p056h5.C0598e;
import p096m7.r;
import y7.h;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends r {
    @Override // p096m7.r
    public final Object f(byte b9, ByteBuffer buffer) {
        k.e(buffer, "buffer");
        int i9 = 0;
        if (b9 == -127) {
            Long l8 = (Long) e(buffer);
            if (l8 != null) {
                int iLongValue = (int) l8.longValue();
                w.f21375b.getClass();
                w[] wVarArrValues = w.values();
                int length = wVarArrValues.length;
                while (i9 < length) {
                    w wVar = wVarArrValues[i9];
                    if (wVar.f21377a == iLongValue) {
                        return wVar;
                    }
                    i9++;
                }
            }
        } else if (b9 == -126) {
            Long l9 = (Long) e(buffer);
            if (l9 != null) {
                int iLongValue2 = (int) l9.longValue();
                y.f21380b.getClass();
                y[] yVarArrValues = y.values();
                int length2 = yVarArrValues.length;
                while (i9 < length2) {
                    y yVar = yVarArrValues[i9];
                    if (yVar.f21382a == iLongValue2) {
                        return yVar;
                    }
                    i9++;
                }
            }
        } else if (b9 == -125) {
            Long l10 = (Long) e(buffer);
            if (l10 != null) {
                int iLongValue3 = (int) l10.longValue();
                c.f21308b.getClass();
                c[] cVarArrValues = c.values();
                int length3 = cVarArrValues.length;
                while (i9 < length3) {
                    c cVar = cVarArrValues[i9];
                    if (cVar.f21312a == iLongValue3) {
                        return cVar;
                    }
                    i9++;
                }
            }
        } else if (b9 == -124) {
            Object objE = e(buffer);
            List list = objE instanceof List ? (List) objE : null;
            if (list != null) {
                Object obj = list.get(0);
                k.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Object obj2 = list.get(1);
                k.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                return new f(zBooleanValue, ((Boolean) obj2).booleanValue(), (Long) list.get(2));
            }
        } else if (b9 == -123) {
            Object objE2 = e(buffer);
            List list2 = objE2 instanceof List ? (List) objE2 : null;
            if (list2 != null) {
                Double d9 = (Double) list2.get(0);
                Double d10 = (Double) list2.get(1);
                Object obj3 = list2.get(2);
                k.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                return new s(d9, d10, ((Long) obj3).longValue());
            }
        } else if (b9 == -122) {
            Object objE3 = e(buffer);
            List list3 = objE3 instanceof List ? (List) objE3 : null;
            if (list3 != null) {
                Object obj4 = list3.get(0);
                k.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.ImageSelectionOptions");
                return new t((s) obj4);
            }
        } else if (b9 == -121) {
            Object objE4 = e(buffer);
            List list4 = objE4 instanceof List ? (List) objE4 : null;
            if (list4 != null) {
                return new z((Long) list4.get(0));
            }
        } else if (b9 == -120) {
            Object objE5 = e(buffer);
            List list5 = objE5 instanceof List ? (List) objE5 : null;
            if (list5 != null) {
                Object obj5 = list5.get(0);
                k.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceType");
                return new x((y) obj5, (w) list5.get(1));
            }
        } else if (b9 == -119) {
            Object objE6 = e(buffer);
            List list6 = objE6 instanceof List ? (List) objE6 : null;
            if (list6 != null) {
                Object obj6 = list6.get(0);
                k.c(obj6, "null cannot be cast to non-null type kotlin.String");
                return new a((String) obj6, (String) list6.get(1));
            }
        } else {
            if (b9 != -118) {
                return super.f(b9, buffer);
            }
            Object objE7 = e(buffer);
            List list7 = objE7 instanceof List ? (List) objE7 : null;
            if (list7 != null) {
                Object obj7 = list7.get(0);
                k.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.CacheRetrievalType");
                a aVar = (a) list7.get(1);
                Object obj8 = list7.get(2);
                k.c(obj8, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                return new b((c) obj7, aVar, (List) obj8);
            }
        }
        return null;
    }

    @Override // p096m7.r
    public final void k(r.a aVar, Object obj) {
        if (obj instanceof w) {
            aVar.write(129);
            k(aVar, Long.valueOf(((w) obj).f21377a));
            return;
        }
        if (obj instanceof y) {
            aVar.write(130);
            k(aVar, Long.valueOf(((y) obj).f21382a));
            return;
        }
        if (obj instanceof c) {
            aVar.write(131);
            k(aVar, Long.valueOf(((c) obj).f21312a));
            return;
        }
        if (obj instanceof f) {
            aVar.write(132);
            f fVar = (f) obj;
            k(aVar, h.C(Boolean.valueOf(fVar.f21315a), Boolean.valueOf(fVar.f21316b), fVar.f21317c));
            return;
        }
        if (obj instanceof s) {
            aVar.write(GattError.GATT_ERROR);
            s sVar = (s) obj;
            k(aVar, h.C(sVar.f21371a, sVar.f21372b, Long.valueOf(sVar.f21373c)));
            return;
        }
        if (obj instanceof t) {
            aVar.write(134);
            k(aVar, C0598e.y(((t) obj).f21374a));
            return;
        }
        if (obj instanceof z) {
            aVar.write(135);
            k(aVar, C0598e.y(((z) obj).f21383a));
            return;
        }
        if (obj instanceof x) {
            aVar.write(136);
            x xVar = (x) obj;
            k(aVar, h.C(xVar.f21378a, xVar.f21379b));
        } else if (obj instanceof a) {
            aVar.write(137);
            a aVar2 = (a) obj;
            k(aVar, h.C(aVar2.f21303a, aVar2.f21304b));
        } else {
            if (!(obj instanceof b)) {
                super.k(aVar, obj);
                return;
            }
            aVar.write(138);
            b bVar = (b) obj;
            k(aVar, h.C(bVar.f21305a, bVar.f21306b, bVar.f21307c));
        }
    }
}
