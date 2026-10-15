package cn.jiguang.aa;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.x.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8831a = "JDataControlManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8832c = "DISABLE_DATA";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f8833d = "ENABLE_DATA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> f8834b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f8835e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f8836a = new c();
    }

    private c() {
        this.f8834b = new ConcurrentHashMap<>();
    }

    public synchronized Bundle a(Context context, String str, Bundle bundle) {
        try {
            f.c(f8831a, "setDataControl control=" + bundle + " sdkType=" + str);
            this.f8835e = context;
            ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = this.f8834b.get(str);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
            }
            Set<Integer> hashSet = concurrentHashMap.get("enable_c_c");
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("enable_c_c");
            Set<Integer> hashSet2 = concurrentHashMap.get("disable_c_c");
            if (hashSet2 == null) {
                hashSet2 = new HashSet<>();
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("disable_c_c");
            if (integerArrayList2 != null) {
                hashSet2.addAll(integerArrayList2);
            }
            if (integerArrayList != null) {
                for (Integer num : integerArrayList) {
                    num.intValue();
                    hashSet2.remove(num);
                }
            }
            if (integerArrayList2 != null) {
                for (Integer num2 : integerArrayList2) {
                    num2.intValue();
                    hashSet.remove(num2);
                }
            }
            if (integerArrayList != null) {
                hashSet.addAll(integerArrayList);
            }
            concurrentHashMap.put("enable_c_c", hashSet);
            concurrentHashMap.put("disable_c_c", hashSet2);
            this.f8834b.put(str, concurrentHashMap);
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }

    public Bundle b() {
        ConcurrentHashMap concurrentHashMap;
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            Bundle bundle = new Bundle();
            synchronized (this) {
                concurrentHashMap = new ConcurrentHashMap(this.f8834b);
            }
            if (!concurrentHashMap.isEmpty()) {
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) ((Map.Entry) it.next()).getValue();
                    Set set = (Set) concurrentHashMap2.get("enable_c_c");
                    if (set != null) {
                        arrayList.addAll(new ArrayList(set));
                    }
                    Set set2 = (Set) concurrentHashMap2.get("disable_c_c");
                    if (set2 != null) {
                        arrayList2.addAll(new ArrayList(set2));
                    }
                }
                bundle.putIntegerArrayList(f8832c, arrayList2);
                bundle.putIntegerArrayList(f8833d, arrayList);
            }
            if (!arrayList2.isEmpty()) {
                Iterator<Integer> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    cn.jiguang.at.a.a().b(it2.next().intValue());
                }
            }
            f.c(f8831a, "sendDataToRemoteProcess bundle=" + bundle);
            return bundle;
        } catch (Throwable th) {
            f.c(f8831a, "sendDataToRemoteProcess throwable=" + th);
            return null;
        }
    }

    public static c a() {
        return a.f8836a;
    }
}
