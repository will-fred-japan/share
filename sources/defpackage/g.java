package defpackage;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import y7.h;
import y7.s;

/* JADX INFO: compiled from: WakelockPlusMessages.g.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final List a(Throwable th) {
        if (th instanceof d) {
            return h.C(null, null, null);
        }
        return h.C(th.getClass().getSimpleName(), th.toString(), f.f("Cause: ", ", Stacktrace: ", Log.getStackTraceString(th), th.getCause()));
    }

    public static final boolean b(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length == objArr2.length) {
                Iterable iterableM = y7.g.m(objArr);
                if (!(iterableM instanceof Collection) || !((Collection) iterableM).isEmpty()) {
                    Iterator it = iterableM.iterator();
                    while (it.hasNext()) {
                        int iA = ((s) it).a();
                        if (!b(objArr[iA], objArr2[iA])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() == list2.size()) {
                Iterable iterableA = h.A((Collection) obj);
                if (!(iterableA instanceof Collection) || !((Collection) iterableA).isEmpty()) {
                    Iterator it2 = iterableA.iterator();
                    while (it2.hasNext()) {
                        int iA2 = ((s) it2).a();
                        if (!b(list.get(iA2), list2.get(iA2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
            return k.a(obj, obj2);
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() == map2.size()) {
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!map2.containsKey(entry.getKey()) || !b(entry.getValue(), map2.get(entry.getKey()))) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
