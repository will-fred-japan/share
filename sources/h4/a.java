package h4;

import android.content.Context;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.apm.insight.nativecrash.NativeImpl;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p056h5.C0598e;
import p142s2.j;
import p144s4.h;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f19034a = new JSONObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Header f19035b;

    public static a a(long j, Context context, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.e(1, "isJava");
        aVar.e(h.b(th), "data");
        aVar.e(Long.valueOf(j), "crash_time");
        aVar.e(p144s4.a.h(), "process_name");
        if (!p144s4.a.g(context)) {
            aVar.e(1, "remote_process");
        }
        return aVar;
    }

    public static a b(Context context, long j, String str) {
        a aVar = new a();
        aVar.e(1, "is_dart");
        aVar.e(Long.valueOf(j), "crash_time");
        aVar.e(p144s4.a.h(), "process_name");
        aVar.e(str, "data");
        p144s4.a.b(context, aVar.f19034a);
        return aVar;
    }

    public static void i(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            try {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put(str, jSONObjectOptJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        jSONObjectOptJSONObject.put(str2, str3);
    }

    public static void j(JSONObject jSONObject, Throwable th) {
        String str = "npth_err_info";
        if (jSONObject.opt("npth_err_info") != null) {
            for (int i9 = 0; i9 < 5; i9++) {
                if (jSONObject.opt("npth_err_info" + i9) == null) {
                    try {
                        str = "npth_err_info" + i9;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
            return;
        }
        jSONObject.put(str, h.b(th));
    }

    public static void k(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void l(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        try {
            jSONObject.put("storage", jSONObject2);
        } catch (Throwable unused) {
        }
        long jOptLong = jSONObject2.optLong("inner_free");
        long jOptLong2 = jSONObject2.optLong("sdcard_free");
        long jOptLong3 = jSONObject2.optLong("inner_free_real");
        String str3 = "64M - ";
        if (jOptLong <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            str = "0 - 1K";
        } else if (jOptLong <= 65536) {
            str = "1K - 64K";
        } else if (jOptLong <= 524288) {
            str = "64K - 512K";
        } else if (jOptLong <= Config.DEFAULT_MAX_FILE_LENGTH) {
            str = "512K - 1M";
        } else {
            str = jOptLong <= 67108864 ? "1M - 64M" : "64M - ";
        }
        if (jOptLong3 <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            str2 = "0 - 1K";
        } else if (jOptLong3 <= 65536) {
            str2 = "1K - 64K";
        } else if (jOptLong3 <= 524288) {
            str2 = "64K - 512K";
        } else if (jOptLong3 <= Config.DEFAULT_MAX_FILE_LENGTH) {
            str2 = "512K - 1M";
        } else {
            str2 = jOptLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        }
        if (jOptLong2 <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            str3 = "0 - 1K";
        } else if (jOptLong2 <= 65536) {
            str3 = "1K - 64K";
        } else if (jOptLong2 <= 524288) {
            str3 = "64K - 512K";
        } else if (jOptLong2 <= Config.DEFAULT_MAX_FILE_LENGTH) {
            str3 = "512K - 1M";
        } else if (jOptLong2 <= 67108864) {
            str3 = "1M - 64M";
        }
        i(jSONObject, "filters", "inner_free", str);
        i(jSONObject, "filters", "inner_free_real", str2);
        i(jSONObject, "filters", "sdcard_free", str3);
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null) {
                    if (objOpt instanceof JSONObject) {
                        jSONObject3 = jSONObject.getJSONObject(next);
                        jSONObject4 = jSONObject2.getJSONObject(next);
                    } else if (objOpt instanceof JSONArray) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            JSONArray jSONArray = (JSONArray) objOpt;
                            if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (jSONArrayOptJSONArray.opt(0) instanceof JSONObject)) {
                                jSONObject3 = jSONArray.getJSONObject(0);
                                jSONObject4 = jSONArrayOptJSONArray.getJSONObject(0);
                            } else {
                                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                                    jSONArray.put(jSONArrayOptJSONArray.get(i9));
                                }
                            }
                        }
                    }
                    o(jSONObject3, jSONObject4);
                }
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }

    public static boolean p(String str) {
        long j;
        p135r4.b.C0252b c0252b = new p135r4.b.C0252b(new File(C0598e.d(f.f11853a, str), "meminfo.txt"));
        c0252b.f21139b = "VmSize:";
        c0252b.f21140c = "\\s+";
        c0252b.f21141d = -1;
        long jA = c0252b.a();
        if (NativeImpl.t()) {
            j = Long.MAX_VALUE;
        } else {
            j = Header.e() ? 3891200L : 2867200L;
        }
        return jA > j;
    }

    public static boolean s(String str) {
        r4.b.a aVar = new r4.b.a(new File(C0598e.d(f.f11853a, str), "fds.txt"));
        aVar.f21139b = "Total FD Count:";
        aVar.f21140c = Constants.COLON_SEPARATOR;
        aVar.f21141d = -2;
        return aVar.a() > 960;
    }

    public static boolean t(String str) {
        r4.b.d dVar = new r4.b.d(new File(C0598e.d(f.f11853a, str), "threads.txt"));
        dVar.f21139b = "Total Threads Count:";
        dVar.f21140c = Constants.COLON_SEPARATOR;
        dVar.f21141d = -2;
        return dVar.a() > 350;
    }

    public final void c(long j) {
        try {
            e(Long.valueOf(j), "app_start_time");
            e(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)), "app_start_time_readable");
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    public final void d(Header header) {
        e(header.f11851a, "header");
        this.f19035b = header;
    }

    public final void e(Object obj, String str) {
        try {
            this.f19034a.put(str, obj);
        } catch (Exception e9) {
            j.m(e9);
        }
    }

    public final void f(String str, String str2) {
        JSONObject jSONObject = this.f19034a;
        Object objOpt = jSONObject.opt("data");
        if (objOpt instanceof JSONArray) {
            i(((JSONArray) objOpt).optJSONObject(0), "filters", str, str2);
        } else {
            i(jSONObject, "filters", str, str2);
        }
    }

    public final void g(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            e(jSONArray, "patch_info");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        e(jSONArray, "patch_info");
    }

    public final void h(Map map) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = this.f19034a;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(Constants.PACKAGE_NAME, str);
                    jSONObject2.put("version_code", map.get(str));
                    jSONArray.put(jSONObject2);
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put("plugin_info", jSONArray);
    }

    public final boolean m() {
        if (!f.f11876z) {
            return false;
        }
        JSONObject jSONObject = this.f19034a;
        Object objOpt = jSONObject.opt("data");
        return objOpt instanceof JSONArray ? !p011b4.h.n(((JSONArray) objOpt).optJSONObject(0)) : !p011b4.h.n(jSONObject);
    }

    public final void n(String str, String str2) {
        JSONObject jSONObject = this.f19034a;
        Object objOpt = jSONObject.opt("data");
        if (objOpt instanceof JSONArray) {
            i(((JSONArray) objOpt).optJSONObject(0), "custom", str, str2);
        } else {
            i(jSONObject, "custom", str, str2);
        }
    }

    public final void q() {
        f("is_64_devices", String.valueOf(Header.e()));
        f("is_64_runtime", String.valueOf(NativeImpl.t()));
        f("is_x86_devices", String.valueOf(Header.g()));
    }

    public final void r(HashMap map) {
        JSONObject jSONObjectOptJSONObject;
        if (map != null) {
            JSONObject jSONObjectOptJSONObject2 = this.f19034a;
            Object objOpt = jSONObjectOptJSONObject2.opt("data");
            if (objOpt instanceof JSONArray) {
                jSONObjectOptJSONObject2 = ((JSONArray) objOpt).optJSONObject(0);
            }
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject = new JSONObject();
            } else {
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("filters");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    e(jSONObjectOptJSONObject, "filters");
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            e(jSONObjectOptJSONObject, "filters");
        }
    }

    public final Header u() {
        if (this.f19035b == null) {
            Context context = f.f11853a;
            Header header = new Header();
            this.f19035b = header;
            d(header);
        }
        return this.f19035b;
    }
}
