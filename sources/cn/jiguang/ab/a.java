package cn.jiguang.ab;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aw.l;
import cn.jiguang.e.d;
import cn.jiguang.e.f;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.starburst.sdk.core.tts.EventType;
import java.util.LinkedHashMap;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8845i;
    public static final String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f8847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f8848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f8849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f8850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f8851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f8852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f8853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f8854s;
    private static String t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f8855u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f8856v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f8857w;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f8851p = linkedHashMap;
        String strB = l.b(new byte[]{98, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f8837a = strB;
        String strB2 = l.b(new byte[]{83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 120, 95});
        f8838b = strB2;
        String strB3 = l.b(new byte[]{85, 65, 106, 113, 98, 126, 93, 69, 106, 123, 119, 118, 85, 14, 122, 103, 123});
        f8839c = strB3;
        String strB4 = l.b(new byte[]{67, 73, 106, 37, 127, 97, 70, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 98, 102, EventType.ERROR, 67, 72, 55, 107, 120});
        f8840d = strB4;
        linkedHashMap.put(strB, 19000);
        linkedHashMap.put(strB2, 19000);
        linkedHashMap.put(strB3, 19000);
        linkedHashMap.put(strB4, 19000);
        String strB5 = l.b(new byte[]{39, 32, 5, 14, 40, 58, 38, Utf8.REPLACEMENT_BYTE, 1, 25, 42, 38, 39, 38, 9});
        f8841e = strB5;
        String strB6 = l.b(new byte[]{40, 57, 37, Utf8.REPLACEMENT_BYTE, 4, 21, 55, 60, 38, Utf8.REPLACEMENT_BYTE, 2, 18, 47});
        f8842f = strB6;
        String strB7 = l.b(new byte[]{40, 58, 38, Utf8.REPLACEMENT_BYTE, 4, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 57, 32, Utf8.REPLACEMENT_BYTE, 2, 20, 43});
        f8843g = strB7;
        String strB8 = l.b(new byte[]{40, 58, 38, Utf8.REPLACEMENT_BYTE, 4, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 48, 34, Utf8.REPLACEMENT_BYTE, 1, 16, 33});
        f8844h = strB8;
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        f8852q = linkedHashMap2;
        try {
            linkedHashMap2.put(strB5, 19000);
            linkedHashMap2.put(strB6, 19000);
            linkedHashMap2.put(strB7, 19000);
            linkedHashMap2.put(strB8, 19000);
        } catch (Throwable unused) {
        }
        f8845i = l.b(new byte[]{112, 101, 32, 37, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        j = l.b(new byte[]{70, 97, 123, 39, 4, 14, 70, 124, 117, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f8846k = l.b(new byte[]{70, 120, 101, 120, 67, 14, 70, 125, 114, 97, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f8853r = new LinkedHashMap<>();
        f8854s = new LinkedHashMap<>();
        t = "";
        f8855u = "";
        f8856v = "";
        f8857w = "";
    }

    public static String a(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(t)) {
            return t;
        }
        String str = (String) f.b(context, d.aI());
        return !TextUtils.isEmpty(str) ? str : f8845i;
    }

    public static String b(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f8855u)) {
            return f8855u;
        }
        String str = (String) f.b(context, d.aJ());
        return !TextUtils.isEmpty(str) ? str : j;
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f8856v)) ? f8846k : f8856v;
    }

    public static String d() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f8857w)) ? "" : f8857w;
    }

    public static LinkedHashMap<String, Integer> a() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f8853r;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f8851p;
    }

    public static LinkedHashMap<String, Integer> b() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = f8854s;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f8852q;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.x.f.i("HostConfig", "conn info was empty");
            return;
        }
        cn.jiguang.x.f.c("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("srv");
            cn.jiguang.x.f.c("HostConfig", "save srvHost:" + strOptString);
            if (!TextUtils.isEmpty(strOptString)) {
                f.a(context, (d<?>[]) new d[]{d.aJ().a(strOptString)});
            }
            String strOptString2 = jSONObject.optString("conn");
            cn.jiguang.x.f.c("HostConfig", "save connHost:" + strOptString2);
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            f.a(context, (d<?>[]) new d[]{d.aI().a(strOptString2)});
        } catch (Throwable unused) {
        }
    }
}
