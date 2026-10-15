package p154t7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import y7.h;
import y7.s;

/* JADX INFO: compiled from: MessagesAsync.g.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static boolean a(Object obj, Object obj2) {
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
            if (objArr.length != objArr2.length) {
                return false;
            }
            Iterable iterableM = y7.g.m(objArr);
            if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
                return true;
            }
            Iterator<Integer> it = iterableM.iterator();
            while (((O7.g) it).f3590c) {
                int iA = ((s) it).a();
                if (!a(objArr[iA], objArr2[iA])) {
                    return false;
                }
            }
            return true;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() != list2.size()) {
                return false;
            }
            Iterable iterableA = h.A((Collection) obj);
            if ((iterableA instanceof Collection) && ((Collection) iterableA).isEmpty()) {
                return true;
            }
            Iterator<Integer> it2 = iterableA.iterator();
            while (((O7.g) it2).f3590c) {
                int iA2 = ((s) it2).a();
                if (!a(list.get(iA2), list2.get(iA2))) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
            return k.a(obj, obj2);
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() != map2.size()) {
            return false;
        }
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !a(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
