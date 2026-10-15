package y7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes2.dex */
public class u extends t {
    public static <K, V> HashMap<K, V> C(p188x7.e<? extends K, ? extends V>... eVarArr) {
        HashMap<K, V> map = new HashMap<>(t.A(eVarArr.length));
        G(map, eVarArr);
        return map;
    }

    public static <K, V> Map<K, V> D(p188x7.e<? extends K, ? extends V>... eVarArr) {
        if (eVarArr.length <= 0) {
            return q.f22409a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.A(eVarArr.length));
        G(linkedHashMap, eVarArr);
        return linkedHashMap;
    }

    public static LinkedHashMap E(p188x7.e... eVarArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.A(eVarArr.length));
        G(linkedHashMap, eVarArr);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> F(Map<? extends K, ? extends V> map, p188x7.e<? extends K, ? extends V> eVar) {
        if (map.isEmpty()) {
            return t.B(eVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(eVar.f22353a, eVar.f22354b);
        return linkedHashMap;
    }

    public static final void G(HashMap map, p188x7.e[] eVarArr) {
        for (p188x7.e eVar : eVarArr) {
            map.put(eVar.f22353a, eVar.f22354b);
        }
    }

    public static Map H(ArrayList arrayList) {
        q qVar = q.f22409a;
        int size = arrayList.size();
        if (size == 0) {
            return qVar;
        }
        if (size == 1) {
            return t.B((p188x7.e) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.A(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p188x7.e eVar = (p188x7.e) it.next();
            linkedHashMap.put(eVar.f22353a, eVar.f22354b);
        }
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> I(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return q.f22409a;
        }
        if (size != 1) {
            return J(map);
        }
        kotlin.jvm.internal.k.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.k.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static LinkedHashMap J(Map map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
