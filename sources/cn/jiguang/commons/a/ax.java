package cn.jiguang.commons.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.C0524s;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.starburst.sdk.core.tts.EventType;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f9694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f9695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f9696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f9697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f9698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f9699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f9700i;
    private static final az j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LinkedList<String> f9701k;

    static {
        String strA = jr.a(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 104, 82, 19, 47, 112, 101});
        f9692a = strA;
        String strA2 = jr.a(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, 127, 97, 70, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 98, 102, EventType.ERROR, 67, 72, 55, 107, 120, 62, 71, 73, 54, 113, 116, 34, 6, 88, 106});
        f9693b = strA2;
        f9694c = 0;
        f9695d = "";
        f9696e = "";
        f9697f = 0L;
        f9698g = 0L;
        f9699h = 43200L;
        f9700i = 172800L;
        j = new az();
        LinkedList<String> linkedList = new LinkedList<>();
        f9701k = linkedList;
        linkedList.clear();
        linkedList.add(strA);
        linkedList.add(strA2);
    }

    private ax() {
    }

    public static /* synthetic */ boolean e() {
        String str;
        List listC = bu.a().c(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, false);
        if (listC != null && !listC.isEmpty()) {
            str = " al sz >0,not need req";
        } else {
            if (!bq.a().a(1110, false) || !kh.a()) {
                ee.a("ActiveConfigManager", "need req");
                return true;
            }
            str = " app list file sz >0,not need req";
        }
        ee.a("ActiveConfigManager", str);
        return false;
    }

    public static /* synthetic */ void g() {
        kq kqVarA = kq.a();
        kqVarA.a("last_time", f9697f);
        kqVarA.a("sign", f9696e);
        kqVarA.a("al_idx", f9694c);
        kqVarA.a("req_gap", f9699h);
        kqVarA.a("t_interval", f9700i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i() {
        try {
            ca caVarA = ca.a();
            String strI = ca.i();
            long jE = caVarA.e();
            if (!TextUtils.isEmpty(strI) && jE > 0) {
                JSONObject jSONObjectA = a(strI, jE);
                if (jSONObjectA == null) {
                    return null;
                }
                return a(jSONObjectA, strI, jE);
            }
            ee.d("ActiveConfigManager", "appkey or uid unavailable, skip active config request");
        } catch (Throwable unused) {
        }
        return null;
    }

    public /* synthetic */ ax(byte b9) {
        this();
    }

    public static synchronized String c() {
        if (!TextUtils.isEmpty(f9695d)) {
            return f9695d;
        }
        String strB = jq.b(e.f9924b);
        if (!TextUtils.isEmpty(strB)) {
            f9695d = km.b(strB, f.f10031c);
        }
        if (!TextUtils.isEmpty(f9695d)) {
            a("al", true);
        }
        return f9695d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ks.a(str, true));
            ee.a("ActiveConfigManager", "acf map cf: " + jSONObject);
            if (jSONObject.optInt("code") == 2000 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                return jSONObjectOptJSONObject;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static ax a() {
        return ba.f9707a;
    }

    private static String a(JSONObject jSONObject, String str, long j8) {
        String strB = ks.b(jSONObject.toString(), true);
        Iterator<String> it = f9701k.iterator();
        while (it.hasNext()) {
            try {
                eh ehVar = new eh(it.next());
                ehVar.a("Content-Type", "text/plain");
                ehVar.a("Accept", "application/json");
                ehVar.a("Charset", "UTF-8");
                ehVar.a("X-UDD", ca.a(j8));
                ehVar.a("X-App-Key", str);
                ehVar.a(strB);
                ei eiVarA = ej.a(ehVar);
                if (eiVarA != null && eiVarA.c() == 200 && !TextUtils.isEmpty(eiVarA.a())) {
                    return eiVarA.a();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static HashMap<String, List<String>> a(String str) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        HashMap<String, List<String>> map = new HashMap<>();
        int i14 = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return map;
            }
            i13 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            for (String str2 : str.split("&&")) {
                try {
                    i13++;
                    String[] strArrSplit = str2.split(ContainerUtils.FIELD_DELIMITER);
                    if (strArrSplit.length < 2) {
                        i9++;
                    } else {
                        String str3 = strArrSplit[0];
                        String str4 = strArrSplit[1];
                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                            i10++;
                        } else if (iy.c(str4)) {
                            if (map.containsKey(str4)) {
                                i12++;
                            }
                            map.put(str4, Arrays.asList(str3.split("@")));
                        } else {
                            i11++;
                        }
                    }
                } catch (Throwable unused) {
                    i14 = i13;
                }
            }
            StringBuilder sbA = C0524s.a(i13, "parse pkg: t=", ", r=");
            sbA.append(map.size());
            sbA.append(", sf=");
            sbA.append(i9);
            sbA.append(", se=");
            sbA.append(i10);
            sbA.append(", sni=");
            sbA.append(i11);
            sbA.append(", d=");
            sbA.append(i12);
            ee.a("ActiveConfigManager", sbA.toString());
            return map;
        } catch (Throwable unused2) {
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        i13 = i14;
        StringBuilder sbA2 = C0524s.a(i13, "parse pkg: t=", ", r=");
        sbA2.append(map.size());
        sbA2.append(", sf=");
        sbA2.append(i9);
        sbA2.append(", se=");
        sbA2.append(i10);
        sbA2.append(", sni=");
        sbA2.append(i11);
        sbA2.append(", d=");
        sbA2.append(i12);
        ee.a("ActiveConfigManager", sbA2.toString());
        return map;
    }

    public final void b() {
        kq kqVarA = kq.a();
        f9697f = kqVarA.b("last_time", 0L);
        f9698g = kqVarA.b("last_all_time", 0L);
        f9696e = kqVarA.c("sign", "");
        f9694c = kqVarA.b("al_idx", 0);
        f9699h = kqVarA.b("req_gap", 43200L);
        f9700i = kqVarA.b("t_interval", 172800L);
        if (em.a("ActiveConfigManager", f9697f, f9699h * 1000) && !em.a("ActiveConfigManager", f9697f, f9699h * 1000, new ay(this))) {
            fe.a().a(j, 3000L);
        }
    }

    @TargetApi(16)
    private static JSONObject a(String str, long j8) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            jSONObject.put("uid", j8);
            jSONObject.put("sign", (TextUtils.isEmpty(f9696e) || "null".equalsIgnoreCase(f9696e)) ? "" : f9696e);
            jSONObject.put("al", "");
            jSONObject.put("ver", 1);
            jSONObject.put("al_idx", f9694c);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(String str, boolean z8) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(jg.a().getFilesDir(), str);
        try {
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                a(fileArrListFiles, sb, true);
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                f9695d = string;
                jq.a(e.f9924b, km.a(string, f.f10031c));
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(File[] fileArr, StringBuilder sb, boolean z8) {
        for (int i9 = 0; i9 < fileArr.length; i9++) {
            File file = fileArr[i9];
            if (file.exists() && file.isFile()) {
                String strA = jq.a(file);
                if (!TextUtils.isEmpty(strA)) {
                    String strB = km.b(strA, f.f10031c);
                    if (!TextUtils.isEmpty(strB) && z8) {
                        sb.append(strB);
                        if (i9 < fileArr.length - 1) {
                            sb.append("&&");
                        }
                    }
                }
            }
        }
    }
}
