package cn.jiguang.r;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.v.e;
import cn.jiguang.v.f;
import cn.jiguang.v.j;
import com.starburst.sdk.core.tts.EventType;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Map<Integer, Bundle> f10726e = new ConcurrentHashMap();

    static {
        a();
        f10722a = cn.jiguang.t.a.b(new byte[]{67, 119, 38, 102, Utf8.REPLACEMENT_BYTE, 90, 73, 126, 125, 119, 127, 87, 14, 83, 75, 121, 99, 85, 104, 124, EventType.ERROR, 102, 116, 66});
        f10723b = cn.jiguang.t.a.b(new byte[]{117, 127, 30, 74, 112, 111, 99, 112, 94, 71, 55, 97, 120, 101, 85, 82, 119, 105, 122, Utf8.REPLACEMENT_BYTE, 122, 99, 118, 122, 115, 88, 94, 84, 124, 122, 120, 112, 92, 104, 124, EventType.ERROR, 102, 116, 66});
        f10724c = cn.jiguang.t.a.b(new byte[]{122, 102, 56, 123, 89, 71, 108, 105, 120, 118, 30, 73, 119, 124, 115, 99, 94, 65, 117, 38, 92, 82, 95, 82, 124, 64, 115, 125, 64, 69, 107, 73, 117, 101, 89, 79, 119});
        f10725d = cn.jiguang.t.a.b(new byte[]{83, 78, 55, 120, 56, 123, 89, 71, 108, 105, 120, 118, 30, 106, 90, 103, EventType.ERROR, 116, 115, 76, 120, 123, 101, 93, 95, 65, 125, 109, EventType.ERROR});
    }

    public static File a(Context context, int i9) {
        try {
            return a(context, b(context, i9), true);
        } catch (Throwable th) {
            cn.jiguang.u.b.e("PH", "getIIf error:" + th.getMessage());
            return null;
        }
    }

    public static cn.jiguang.s.c b(Context context, int i9) {
        return cn.jiguang.s.c.a(e.a(context, i9, "use"));
    }

    public static File a(Context context, cn.jiguang.s.c cVar, boolean z8) {
        if (cVar == null) {
            return null;
        }
        try {
            File fileA = b.a(context, cVar.t, cVar.f10780m, cVar.f10782o);
            cn.jiguang.u.b.b("PH", "pF:" + fileA);
            if (b.a(fileA, cVar, z8)) {
                return fileA;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.u.b.b("PH", "gIF error:" + th.getMessage());
        }
    }

    public static String a(int i9, int i10) {
        String str;
        if (i10 == 0) {
            str = "ic";
        } else if (i10 == 1) {
            str = "if";
        } else if (i10 == 2) {
            str = "iff";
        } else if (i10 == 3) {
            str = "dc";
        } else {
            if (i10 != 4) {
                cn.jiguang.u.b.e("PH", "unkown type:" + i10);
                return "";
            }
            str = "code";
        }
        return f10726e.containsKey(Integer.valueOf(i9)) ? f10726e.get(Integer.valueOf(i9)).getString(str) : "";
    }

    private static void a() {
        try {
            cn.jiguang.u.b.b("PH", "[loadPinfo]");
            f10726e.putAll(f.a());
            Bundle bundle = new Bundle();
            bundle.putInt("pid", 1);
            bundle.putString("code", f.b() + "");
            bundle.putString("ic", j.a("Y24ucC5qaWd1YW5nLkpDb3JlSGVscGVy"));
            Class<?> cls = Class.forName(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUludGVybmFsSGVscGVy"));
            bundle.putString("if", cls.getCanonicalName());
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().getCanonicalName().equals(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUhlbHBlckFjdGlvbg"))) {
                    cn.jiguang.u.b.b("PH", "find filed name:" + field.getName());
                    bundle.putString("iff", field.getName());
                    break;
                }
            }
            bundle.putString("dc", j.a("Y24ucC5qaWd1YW5nLkpDb3JlQ2xhc3NMb2FkZXI"));
            f10726e.put(1, bundle);
            cn.jiguang.u.b.b("PH", "[loadPinfo] end:" + f10726e);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i9, String str, boolean z8) {
        e.a(context, i9, "use", str, z8);
    }

    public static void a(Context context, cn.jiguang.s.c cVar) {
        try {
            cn.jiguang.u.b.b("PH", "clearPlugin...");
            e.a(context, cVar.f10780m, "use", "", false);
            File fileA = b.a(context, cVar.t, cVar.f10780m, cVar.f10782o);
            if (fileA.exists()) {
                fileA.delete();
            }
        } catch (Throwable unused) {
        }
    }
}
