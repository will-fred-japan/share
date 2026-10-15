package cn.jiguang.r;

import W5.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.v.d;
import cn.jiguang.v.f;
import cn.jiguang.v.h;
import cn.jiguang.v.i;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.starburst.sdk.core.tts.EventType;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static LinkedList<String> f10735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static LinkedList<String> f10736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static LinkedList<String> f10737i;
    private boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f10739l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10746a = new c();
    }

    static {
        String strB = cn.jiguang.t.a.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 114, 90, 67, 45, 123, 119});
        f10729a = strB;
        String strB2 = cn.jiguang.t.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, 127, 97, 70, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 98, 102, EventType.ERROR, 67, 72, 55, 107, 120, 62, 71, 73, 54, 107, 124, 114, 4, 83, 120});
        f10730b = strB2;
        String strB3 = cn.jiguang.t.a.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 117, 8, 78, 42, 96, 124});
        f10731c = strB3;
        String strB4 = cn.jiguang.t.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, 127, 97, 70, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 55, 98, 102, EventType.ERROR, 67, 72, 55, 107, 120, 62, 71, 73, 54, 108, 46, 127, 3, 72, 115});
        f10732d = strB4;
        String strB5 = cn.jiguang.t.a.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 114, 85, 19, 124, Utf8.REPLACEMENT_BYTE, 35, 117, 5, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 111, 58, 57, 117, 8, 78, 42, 96, 124});
        f10733e = strB5;
        String strB6 = cn.jiguang.t.a.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 117, 116, 3, 69, 46, 61, 114, 36, 29, 73, 105, 126, 32, Utf8.REPLACEMENT_BYTE, 90, 80, 108, 123, 126, Utf8.REPLACEMENT_BYTE, 83, 78, 54, 127, 127, 62, 70, 18, 54, 108, 46, 127, 3, 72, 115});
        f10734f = strB6;
        f10735g = new LinkedList<>();
        f10736h = new LinkedList<>();
        f10737i = new LinkedList<>();
        f10735g.clear();
        f10736h.clear();
        f10737i.clear();
        f10735g.add(strB);
        f10735g.add(strB2);
        f10736h.add(strB3);
        f10736h.add(strB4);
        f10737i.add(strB5);
        f10737i.add(strB6);
    }

    private c() {
        this.j = true;
        this.f10738k = "I7MUZXCPZWRFZAJS";
        this.f10739l = "CBDHJXMDDVXH8THW";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v5, types: [cn.jiguang.dy.c] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, org.json.JSONObject] */
    private File b(Context context, int i9, String str) {
        ?? IsEmpty;
        StringBuilder sb;
        String strA;
        StringBuilder sb2;
        int i10 = i9;
        try {
            cn.jiguang.u.b.b("UPM", "u p:" + i10 + ",url:" + str);
            int iA = a(context, i9);
            try {
                boolean zA = a(str);
                ?? jSONObject = new JSONObject();
                jSONObject.put(cn.jiguang.dy.a.f10467h, i10);
                try {
                    if (zA) {
                        String strC = c(context, i9);
                        if (TextUtils.isEmpty(strC)) {
                            cn.jiguang.u.b.e("UPM", "v2 version is invalid");
                            sb2 = new StringBuilder("pI:");
                        } else {
                            String str2 = cn.jiguang.dy.a.f10468i;
                            jSONObject.put(str2, strC);
                            IsEmpty = str2;
                        }
                        sb2.append(i10);
                        sb2.append(" u finish");
                        cn.jiguang.u.b.b("UPM", sb2.toString());
                        return null;
                    }
                    jSONObject.put(cn.jiguang.dy.a.f10468i, iA);
                    IsEmpty = "u:";
                    if (!zA) {
                        IsEmpty = TextUtils.isEmpty(strA);
                        if (IsEmpty == 0) {
                            try {
                                IsEmpty = cn.jiguang.dy.a.j;
                                jSONObject.put(IsEmpty, Integer.parseInt(strA));
                            } catch (Throwable th) {
                                cn.jiguang.u.b.e("UPM", "put l_version error, " + th.getMessage());
                                sb2 = new StringBuilder("pI:");
                            }
                        } else {
                            cn.jiguang.u.b.b("UPM", "get l_version is null");
                            sb2 = new StringBuilder("pI:");
                        }
                        sb2.append(i10);
                        sb2.append(" u finish");
                        cn.jiguang.u.b.b("UPM", sb2.toString());
                        return null;
                    }
                    String strB = b(strA);
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObject.put(cn.jiguang.dy.a.j, strB);
                    }
                    cn.jiguang.dy.c cVarA = cn.jiguang.dy.c.a();
                    cn.jiguang.s.a aVar = cn.jiguang.s.a.f10753g;
                    cVarA.a(context, i10, iA, aVar, 0, null);
                    ?? jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    long jA = f.a(context);
                    if (jA <= 0) {
                        cn.jiguang.u.b.b("UPM", "missing uid <=0");
                        sb2 = new StringBuilder("pI:");
                    } else {
                        String strA2 = h.a(context);
                        String strB2 = h.b(context);
                        PackageInfo packageInfoA = f.a(context, 0);
                        String str3 = packageInfoA != null ? packageInfoA.versionName : "";
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        String string = applicationInfo != null ? context.getPackageManager().getApplicationLabel(applicationInfo).toString() : "";
                        JSONObject jSONObjectA = cn.jiguang.v.a.a(context);
                        JSONObject jSONObject2 = jSONObjectA != null ? jSONObjectA : null;
                        ?? jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put(cn.jiguang.dy.a.f10469k, jSONArray);
                            try {
                                jSONObject3.put(cn.jiguang.dy.a.f10460a, System.currentTimeMillis());
                                jSONObject3.put(cn.jiguang.dy.a.f10461b, strA2 == 0 ? "" : strA2);
                                jSONObject3.put(cn.jiguang.dy.a.f10462c, jA);
                                jSONObject3.put(cn.jiguang.dy.a.f10463d, strB2 == null ? "" : strB2);
                                jSONObject3.put(cn.jiguang.dy.a.f10464e, str3 == null ? "" : str3);
                                jSONObject3.put(cn.jiguang.dy.a.f10465f, string);
                                jSONObject3.put(cn.jiguang.dy.a.f10466g, context.getPackageName());
                                jSONObject3.put(cn.jiguang.dy.a.f10470l, jSONObject2 == null ? "" : jSONObject2);
                                cn.jiguang.u.b.b("UPM", "u:" + str);
                                String string2 = jSONObject3.toString();
                                cn.jiguang.u.b.b("UPM", "request p :" + string2);
                                if (this.j) {
                                    string2 = i.a(jSONObject3.toString().getBytes(), this.f10738k, this.f10739l);
                                    cn.jiguang.u.b.b("UPM", "request p after :" + string2);
                                    if (TextUtils.isEmpty(string2)) {
                                        sb2 = new StringBuilder("pI:");
                                        i10 = i9;
                                    }
                                }
                                i10 = i9;
                                String strA3 = a(context, str, string2, zA);
                                cn.jiguang.u.b.b("UPM", "request http response:" + strA3);
                                if (this.j && !TextUtils.isEmpty(strA3)) {
                                    String str4 = new String(i.a(strA3, this.f10738k, this.f10739l));
                                    cn.jiguang.u.b.b("UPM", "request http response after:".concat(str4));
                                    strA3 = str4;
                                }
                                if (TextUtils.isEmpty(strA3)) {
                                    cn.jiguang.dy.c.a().a(context, i10, iA, aVar, 2, "config response is empty");
                                    sb = new StringBuilder("pI:");
                                    sb.append(i10);
                                    sb.append(" u finish");
                                    String string3 = sb.toString();
                                    return null;
                                }
                                File fileA = a(context, i10, iA, strA3);
                                cn.jiguang.u.b.b("UPM", "pI:" + i10 + " u finish");
                                return fileA;
                            } catch (Throwable th2) {
                                th = th2;
                                i10 = i9;
                                IsEmpty = iA;
                                try {
                                    cn.jiguang.u.b.f("UPM", "sU error:" + th.getMessage());
                                    cn.jiguang.dy.c.a().a(context, i10, IsEmpty, cn.jiguang.s.a.f10753g, 2, th.getMessage());
                                    sb = new StringBuilder("pI:");
                                } finally {
                                    cn.jiguang.u.b.b("UPM", "pI:" + i10 + " u finish");
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    sb2.append(i10);
                    sb2.append(" u finish");
                    cn.jiguang.u.b.b("UPM", sb2.toString());
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    cn.jiguang.u.b.f("UPM", "sU error:" + th.getMessage());
                    cn.jiguang.dy.c.a().a(context, i10, IsEmpty, cn.jiguang.s.a.f10753g, 2, th.getMessage());
                    sb = new StringBuilder("pI:");
                    sb.append(i10);
                    sb.append(" u finish");
                    String string4 = sb.toString();
                    return null;
                }
                strA = cn.jiguang.r.a.a(i10, 4);
            } catch (Throwable th5) {
                th = th5;
                IsEmpty = iA;
            }
        } catch (Throwable th6) {
            th = th6;
            IsEmpty = -1;
        }
    }

    private String c(Context context, int i9) {
        cn.jiguang.s.c cVarB = cn.jiguang.r.a.b(context, i9);
        return b((cVarB == null || TextUtils.isEmpty(cVarB.f10783p)) ? cn.jiguang.r.a.a(i9, 4) : cVarB.f10783p);
    }

    private void d(Context context, int i9) {
        a(cn.jiguang.r.a.a(context, i9));
    }

    public int a(Context context, int i9) {
        cn.jiguang.s.c cVarB = cn.jiguang.r.a.b(context, i9);
        if (cn.jiguang.r.a.a(context, i9) != null) {
            return cVarB.f10782o;
        }
        try {
            return Integer.parseInt(cn.jiguang.r.a.a(i9, 4));
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static c a() {
        return a.f10746a;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        if (cn.jiguang.s.c.b(strTrim)) {
            return strTrim;
        }
        if (!strTrim.matches("\\d+")) {
            return "";
        }
        int length = strTrim.length();
        if (length == 1) {
            return strTrim.concat(".0.0");
        }
        if (length == 2) {
            return strTrim.substring(0, 1) + "." + strTrim.substring(1) + ".0";
        }
        StringBuilder sb = new StringBuilder();
        int i9 = length - 2;
        sb.append(strTrim.substring(0, i9));
        sb.append(".");
        int i10 = length - 1;
        sb.append(strTrim.substring(i9, i10));
        sb.append(".");
        sb.append(strTrim.substring(i10));
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0177  */
    private File a(Context context, int i9, int i10, String str) {
        JSONObject jSONObjectOptJSONObject;
        int i11;
        cn.jiguang.dy.c cVarA;
        cn.jiguang.s.a aVar;
        int i12;
        String strI;
        String str2;
        File fileA = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i13 = jSONObject.getInt("code");
            if (i13 != 0) {
                cn.jiguang.u.b.f("UPM", "dealUif ERR:" + i13);
                cn.jiguang.u.b.f("UPM", "dealUif ERR:" + jSONObject.getString("message"));
                cn.jiguang.dy.c.a().a(context, i9, i10, cn.jiguang.s.a.f10753g, 2, jSONObject.getString("message"));
                return null;
            }
            jSONObjectOptJSONObject = jSONObject.getJSONArray("data").optJSONObject(0);
            if (jSONObjectOptJSONObject == null) {
                try {
                    cn.jiguang.dy.c.a().a(context, i9, i10, cn.jiguang.s.a.f10753g, 2, "reponseData is empty");
                } catch (Throwable th) {
                    th = th;
                    cn.jiguang.u.b.f("UPM", "dealUif e:" + th);
                    i11 = i9;
                    cn.jiguang.dy.c.a().a(context, i11, i10, cn.jiguang.s.a.f10753g, 2, th.getMessage());
                }
            }
            i11 = i9;
            if (jSONObjectOptJSONObject == null) {
                cn.jiguang.u.b.f("UPM", "dealUif ERR");
                return null;
            }
            cn.jiguang.s.c cVarA2 = cn.jiguang.s.c.a(jSONObjectOptJSONObject);
            if (cVarA2 != null) {
                int i14 = cVarA2.f10785r;
                cn.jiguang.dy.c.a().a(context, cVarA2.f10792z);
                cn.jiguang.dy.c.a().b(context, cVarA2.f10779A);
                if (i14 == 2) {
                    str2 = "l is newest.";
                } else {
                    if (i14 == 1) {
                        str2 = "p not exist.";
                    } else if (i14 == 3) {
                        d(context, i9);
                        cn.jiguang.r.a.a(context, i11, "", false);
                    } else if (i14 != 0) {
                        cn.jiguang.u.b.e("UPM", "p status is :" + i14);
                    } else if (a(cVarA2, context)) {
                        cn.jiguang.dy.c cVarA3 = cn.jiguang.dy.c.a();
                        cn.jiguang.s.a aVar2 = cn.jiguang.s.a.f10752f;
                        cVarA3.a(context, i11, i10, aVar2, 0, null);
                        cn.jiguang.dy.c cVarA4 = cn.jiguang.dy.c.a();
                        cn.jiguang.s.a aVar3 = cn.jiguang.s.a.f10754h;
                        cVarA4.a(context, i9, i10, aVar3, 0, null);
                        if (TextUtils.isEmpty(cVarA2.f10786s)) {
                            cn.jiguang.u.b.b("UPM", "p:" + i9 + " du is empty");
                            cn.jiguang.dy.c.a().a(context, i9, i10, aVar2, 2, defpackage.f.b(i9, "p:", " du is empty"));
                            cn.jiguang.dy.c.a().a(context, i9, i10, aVar3, 2, defpackage.f.b(i9, "p:", " du is empty"));
                            return null;
                        }
                        fileA = a(context, cVarA2);
                        if (fileA == null || !fileA.exists()) {
                            cn.jiguang.dy.c.a().a(context, i9, i10, aVar2, 2, "update plugin failed");
                        }
                    }
                    if (i14 <= 3 || i14 < 0) {
                        cVarA = cn.jiguang.dy.c.a();
                        aVar = cn.jiguang.s.a.f10753g;
                        strI = e.i(i14, "unknown status ");
                        i12 = 2;
                    } else {
                        cVarA = cn.jiguang.dy.c.a();
                        aVar = cn.jiguang.s.a.f10753g;
                        i12 = 1;
                        strI = null;
                    }
                }
                cn.jiguang.u.b.b("UPM", str2);
                fileA = cn.jiguang.r.a.a(context, cVarA2, true);
                if (i14 <= 3) {
                    cVarA = cn.jiguang.dy.c.a();
                    aVar = cn.jiguang.s.a.f10753g;
                    strI = e.i(i14, "unknown status ");
                    i12 = 2;
                } else {
                    cVarA = cn.jiguang.dy.c.a();
                    aVar = cn.jiguang.s.a.f10753g;
                    strI = e.i(i14, "unknown status ");
                    i12 = 2;
                }
            } else {
                cn.jiguang.u.b.b("UPM", "dUif error:" + str);
                cVarA = cn.jiguang.dy.c.a();
                aVar = cn.jiguang.s.a.f10753g;
                i12 = 2;
                strI = "parsePluginInfo failed";
            }
            cVarA.a(context, i9, i10, aVar, i12, strI);
            return fileA;
        } catch (Throwable th2) {
            th = th2;
            jSONObjectOptJSONObject = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, int i9, final String str, final cn.jiguang.dy.b.c cVar, final cn.jiguang.dy.b.a aVar, boolean z8) {
        final Context context2 = context;
        final int i10 = i9;
        if (aVar != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = context2.getSharedPreferences("cn.jiguang.prefs", 0);
                long j = sharedPreferences.getLong("plugin_update_time_" + i10, 0L);
                long j8 = sharedPreferences.getLong("plugin_update_interval_" + i10, 86400000L);
                Runnable runnable = new Runnable() { // from class: cn.jiguang.r.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cn.jiguang.u.b.b("UPM", "startUpdate run");
                        c.this.b(context2, i10, str, cVar, aVar, false);
                    }
                };
                context2 = context;
                i10 = i9;
                if (!aVar.a(context2, z8, jCurrentTimeMillis, j, j8, i10, runnable)) {
                }
            } catch (Throwable th) {
                th = th;
                cn.jiguang.u.b.e("UPM", "UpdateAction failed:" + th.getMessage());
            }
        }
        File fileB = b(context, i9, str);
        if (fileB == null) {
            cn.jiguang.u.b.b("UPM", "pluginFile is null");
        }
        if (cVar == 0 || cVar.a(fileB)) {
            try {
                a(context2, i10, System.currentTimeMillis());
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.u.b.e("UPM", "UpdateAction failed:" + th.getMessage());
            }
        }
    }

    private boolean b(Context context, int i9) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.prefs", 0);
        long j = sharedPreferences.getLong("plugin_update_time_" + i9, 0L);
        StringBuilder sb = new StringBuilder("plugin_update_interval_");
        sb.append(i9);
        boolean z8 = j <= 0 || System.currentTimeMillis() > sharedPreferences.getLong(sb.toString(), 86400000L) + j;
        if (!z8) {
            cn.jiguang.u.b.b("UPM", "no need update, last is " + cn.jiguang.v.b.a(j));
        }
        return z8;
    }

    private File a(Context context, cn.jiguang.s.c cVar) {
        int iA = a(context, cVar.f10780m);
        File fileA = b.a(context, cVar.t, cVar.f10780m, cVar.f10782o);
        if (d.b(context, cVar.f10786s, 10000, fileA.getAbsolutePath()) != null) {
            cn.jiguang.u.b.b("UPM", "d p :" + cVar.f10786s + " p:" + fileA);
            cn.jiguang.dy.c.a().a(context, cVar.f10780m, iA, cn.jiguang.s.a.f10754h, 1, null);
            cn.jiguang.dy.c cVarA = cn.jiguang.dy.c.a();
            int i9 = cVar.f10780m;
            cn.jiguang.s.a aVar = cn.jiguang.s.a.f10755i;
            cVarA.a(context, i9, iA, aVar, 0, null);
            String strA = cn.jiguang.v.c.a(fileA.getAbsolutePath());
            if (TextUtils.isEmpty(strA) || !strA.equalsIgnoreCase(cVar.t)) {
                StringBuilder sbI = defpackage.f.i("d p m not m, will d: file m:", strA, ",config m:");
                sbI.append(cVar.t);
                cn.jiguang.u.b.b("UPM", sbI.toString());
                cn.jiguang.dy.c.a().a(context, cVar.f10780m, iA, aVar, 2, "check plugin file md5 failed");
                fileA.delete();
            } else {
                File fileA2 = cn.jiguang.r.a.a(context, cVar.f10780m);
                cn.jiguang.r.a.a(context, cVar.f10780m, cVar.f10791y, true);
                if (fileA2 != null && fileA2.exists()) {
                    cn.jiguang.u.b.b("UPM", "delete old file:" + fileA2.getAbsolutePath());
                    fileA2.delete();
                }
                cn.jiguang.u.b.b("UPM", "d p val succ");
                cn.jiguang.dy.c.a().a(context, cVar.f10780m, iA, aVar, 1, null);
            }
        } else {
            cn.jiguang.u.b.e("UPM", "d p :" + cVar.f10786s + " fail.");
            cn.jiguang.dy.c.a().a(context, cVar.f10780m, iA, cn.jiguang.s.a.f10754h, 2, "down load plugin fail.");
        }
        if (fileA.exists()) {
            return fileA;
        }
        return null;
    }

    private String a(Context context, String str, String str2) {
        return d.a(context, str, 10000, str2);
    }

    private String a(Context context, String str, String str2, boolean z8) {
        LinkedList<String> linkedListE;
        if (TextUtils.isEmpty(str)) {
            if (this.j) {
                linkedListE = z8 ? f10737i : f10736h;
            } else {
                linkedListE = f10735g;
            }
            if (f.d() && f.e() != null && f.e().size() > 0) {
                linkedListE = f.e();
            }
            a(context, linkedListE);
            Iterator<String> it = linkedListE.iterator();
            while (it.hasNext()) {
                String strA = a(context, it.next(), str2);
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
            }
        }
        return a(context, str, str2);
    }

    private void a(Context context, int i9, long j) {
        try {
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putLong("plugin_update_time_" + i9, j).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, int i9, String str) {
        if (!b(context, i9)) {
            a(context, i9, 0L);
        }
        a(context, i9, str, null, null, false);
    }

    public void a(Context context, int i9, String str, cn.jiguang.dy.b.c cVar, cn.jiguang.dy.b.a aVar, boolean z8) {
        if (b(context, i9)) {
            b(context, i9, str, cVar, aVar, z8);
        }
    }

    private static void a(Context context, List<String> list) {
        if (!f.c(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    private void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private boolean a(cn.jiguang.s.c cVar, Context context) {
        cn.jiguang.u.b.b("UPM", "c nU l p...");
        File fileA = cn.jiguang.r.a.a(context, cVar, true);
        cn.jiguang.u.b.b("UPM", "pII:" + fileA);
        if (fileA == null) {
            return true;
        }
        cn.jiguang.r.a.a(context, cVar.f10780m, cVar.f10791y, false);
        cn.jiguang.u.b.b("UPM", "p has exist, p is:" + fileA.getAbsolutePath());
        return false;
    }

    private boolean a(String str) {
        if (!this.j) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.contains("/wi/v2/d8n3hj");
    }
}
