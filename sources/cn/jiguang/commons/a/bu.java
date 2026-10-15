package cn.jiguang.commons.a;

import androidx.datastore.preferences.protobuf.C0524s;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f9756a;

    private bu() {
        this.f9756a = new bt();
    }

    public final int a(int i9, boolean z8, int i10) {
        try {
            Object objA = a(i9, z8);
            if (objA instanceof Integer) {
                return ((Integer) objA).intValue();
            }
            if (objA instanceof Number) {
                return ((Number) objA).intValue();
            }
            return objA instanceof String ? Integer.parseInt((String) objA) : i10;
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "cast int err:", Constants.COLON_SEPARATOR), "DataManager");
            return i10;
        }
    }

    public final String b(int i9, boolean z8) {
        try {
            Object objA = a(i9, z8);
            if (objA == null) {
                return null;
            }
            return objA instanceof String ? (String) objA : objA.toString();
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "cast str err:", Constants.COLON_SEPARATOR), "DataManager");
            return null;
        }
    }

    public final <T> List<T> c(int i9, boolean z8) {
        try {
            Object objA = a(i9, z8);
            if (objA instanceof List) {
                return (List) objA;
            }
            return null;
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "cast list err:", Constants.COLON_SEPARATOR), "DataManager");
            return null;
        }
    }

    public /* synthetic */ bu(byte b9) {
        this();
    }

    public static bu a() {
        return bv.f9757a;
    }

    public final Object a(int i9) {
        return a(i9, false);
    }

    public final Object a(int i9, boolean z8) {
        if (!a(Integer.valueOf(i9))) {
            return null;
        }
        ee.a("DataManager", "gd:" + i9 + ",cmd=" + z8);
        return this.f9756a.a(i9, z8, new Object[0]);
    }

    public final <T> T a(Class<T> cls, int i9, boolean z8) {
        try {
            T t = (T) a(i9, z8);
            if (t != null && cls.isInstance(t)) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("cast ");
            sb.append(cls.getSimpleName());
            sb.append(" err:");
            sb.append(i9);
            sb.append(Constants.COLON_SEPARATOR);
            defpackage.f.n(th, sb, "DataManager");
            return null;
        }
    }

    public final Map<Integer, Object> a(Map<Integer, Boolean> map) {
        if (map == null || map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            try {
                if (a(key)) {
                    try {
                        map2.put(key, a(key.intValue(), value != null ? value.booleanValue() : false));
                    } catch (Throwable th) {
                        ee.e("DataManager", "gd:" + key + ",err=" + th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                StringBuilder sb = new StringBuilder("gd:");
                sb.append(key);
                sb.append(",validate err=");
                W5.f.o(th2, sb, "DataManager");
            }
        }
        return map2;
    }

    public final Map<Integer, Object> a(Set<Integer> set) {
        if (set == null || set.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(set.size());
        for (Integer num : set) {
            try {
                if (a(num)) {
                    try {
                        map.put(num, a(num.intValue(), false));
                    } catch (Throwable th) {
                        ee.e("DataManager", "gd:" + num + ",err=" + th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                StringBuilder sb = new StringBuilder("gd:");
                sb.append(num);
                sb.append(",validate err=");
                W5.f.o(th2, sb, "DataManager");
            }
        }
        return map;
    }

    private static boolean a(Integer num) {
        try {
            if (num == null) {
                ee.d("DataManager", "gd:null configId");
                return false;
            }
            if (bf.c(num.intValue())) {
                return true;
            }
            ee.d("DataManager", "gd:" + num + " not found");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
