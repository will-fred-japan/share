package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.http2.Http2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static Context f17160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ct f197a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f17162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f17163d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private cs f200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected b f201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<String, cq> f203a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f204b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f205b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private long f206c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Map<String, cp> f17161b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected static boolean f198a = false;

    public interface a {
        ct a(Context context, cs csVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    public ct(Context context, cs csVar, b bVar, String str) {
        this(context, csVar, bVar, str, null, null);
    }

    public static synchronized ct a() {
        ct ctVar;
        ctVar = f197a;
        if (ctVar == null) {
            throw new IllegalStateException("the host manager is not initialized yet.");
        }
        return ctVar;
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() {
        try {
            PackageInfo packageInfo = f17160a.getPackageManager().getPackageInfo(f17160a.getPackageName(), Http2.INITIAL_MAX_FRAME_SIZE);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public cp b(String str) {
        return a(str, true);
    }

    public cp c(String str) {
        cq cqVar;
        cp cpVarA;
        synchronized (this.f203a) {
            m176a();
            cqVar = this.f203a.get(str);
        }
        if (cqVar == null || (cpVarA = cqVar.a()) == null) {
            return null;
        }
        return cpVarA;
    }

    public cp d(String str) {
        cp cpVar;
        Map<String, cp> map = f17161b;
        synchronized (map) {
            cpVar = map.get(str);
        }
        return cpVar;
    }

    public cp e(String str) {
        if (System.currentTimeMillis() - this.f206c <= this.f199a * 60000) {
            return null;
        }
        this.f206c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        cp cpVar = a(arrayList).get(0);
        if (cpVar != null) {
            this.f199a = 0L;
            return cpVar;
        }
        long j = this.f199a;
        if (j >= 15) {
            return null;
        }
        this.f199a = j + 1;
        return null;
    }

    public ct(Context context, cs csVar, b bVar, String str, String str2, String str3) {
        this.f203a = new HashMap();
        this.f202a = "0";
        this.f199a = 0L;
        this.f204b = 15L;
        this.f206c = 0L;
        this.f205b = "isp_prov_city_country_ip";
        this.f201a = bVar;
        if (csVar == null) {
            this.f200a = new cs() { // from class: com.xiaomi.push.ct.1
                @Override // com.xiaomi.push.cs
                public boolean a(String str4) {
                    return true;
                }
            };
        } else {
            this.f200a = csVar;
        }
        this.f202a = str;
        f17162c = str2 == null ? context.getPackageName() : str2;
        f17163d = str3 == null ? g() : str3;
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m177b() {
        ArrayList<String> arrayList;
        synchronized (this.f203a) {
            try {
                m176a();
                arrayList = new ArrayList<>(this.f203a.keySet());
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    cq cqVar = this.f203a.get(arrayList.get(size));
                    if (cqVar != null && cqVar.a() != null) {
                        arrayList.remove(size);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList<cp> arrayListA = a(arrayList);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if (arrayListA.get(i9) != null) {
                a(arrayList.get(i9), arrayListA.get(i9));
            }
        }
    }

    public String d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        try {
            File file = new File(f17160a.getFilesDir(), f());
            try {
                if (file.isFile()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                        try {
                            String str = new String(i.a(m171a(), y.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                            com.xiaomi.channel.commonutils.logger.c.b("load host fallbacks = ".concat(str));
                            y.a((Closeable) bufferedInputStream);
                            y.a((Closeable) fileInputStream);
                            return str;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = null;
                    }
                } else {
                    y.a((Closeable) null);
                    y.a((Closeable) null);
                    return null;
                }
                com.xiaomi.channel.commonutils.logger.c.m9a("load host exception " + th.getMessage());
                return null;
            } finally {
                y.a((Closeable) bufferedInputStream);
                y.a((Closeable) fileInputStream);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            fileInputStream = null;
        }
    }

    public static synchronized void a(a aVar) {
        f196a = aVar;
        f197a = null;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f203a) {
            try {
                for (Map.Entry<String, cq> entry : this.f203a.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":\n");
                    sb.append(entry.getValue().toString());
                    sb.append("\n");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public static synchronized void a(Context context, cs csVar, b bVar, String str, String str2, String str3) {
        try {
            Context applicationContext = context.getApplicationContext();
            f17160a = applicationContext;
            if (applicationContext == null) {
                f17160a = context;
            }
            if (f197a == null) {
                a aVar = f196a;
                if (aVar == null) {
                    f197a = new ct(context, csVar, bVar, str, str2, str3);
                } else {
                    f197a = aVar.a(context, csVar, bVar, str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(f17162c)) {
            return f17162c;
        }
        return A.a.j(new StringBuilder(), f17162c, ":pushservice");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m170a() {
        if (f17160a == null) {
            return "unknown";
        }
        try {
            ay ayVarM104a = ax.m104a();
            if (ayVarM104a == null) {
                return "unknown";
            }
            if (ayVarM104a.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return ayVarM104a.m116a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ayVarM104a.m118b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m178b(String str) {
        synchronized (this.f203a) {
            try {
                this.f203a.clear();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("ver") == 2) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                    if (jSONArrayOptJSONArray != null) {
                        for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                            cq cqVarA = new cq().a(jSONArrayOptJSONArray.getJSONObject(i9));
                            this.f203a.put(cqVarA.m165a(), cqVarA);
                        }
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("reserved");
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i10 = 0; i10 < jSONArrayOptJSONArray2.length(); i10++) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i10);
                            String strOptString = jSONObject2.optString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
                            if (!TextUtils.isEmpty(strOptString)) {
                                try {
                                    cp cpVarA = new cp(strOptString).a(jSONObject2);
                                    f17161b.put(cpVarA.f193b, cpVarA);
                                    com.xiaomi.channel.commonutils.logger.c.m9a("load local reserved host for " + cpVarA.f193b);
                                } catch (JSONException unused) {
                                    com.xiaomi.channel.commonutils.logger.c.m9a("parse reserved host fail.");
                                }
                            }
                        }
                    }
                } else {
                    throw new JSONException("Bad version");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m181e() {
        String next;
        synchronized (this.f203a) {
            try {
                Iterator<cq> it = this.f203a.values().iterator();
                while (it.hasNext()) {
                    it.next().a(true);
                }
                while (true) {
                    Iterator<String> it2 = this.f203a.keySet().iterator();
                    do {
                        if (it2.hasNext()) {
                            next = it2.next();
                        }
                    } while (!this.f203a.get(next).m166a().isEmpty());
                    this.f203a.remove(next);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m179c() {
        FileOutputStream fileOutputStreamOpenFileOutput;
        BufferedOutputStream bufferedOutputStream;
        Exception e9;
        synchronized (this.f203a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    String string = m173a().toString();
                    com.xiaomi.channel.commonutils.logger.c.b("persist host fallbacks = " + string);
                    if (TextUtils.isEmpty(string)) {
                        fileOutputStreamOpenFileOutput = null;
                    } else {
                        fileOutputStreamOpenFileOutput = f17160a.openFileOutput(f(), 0);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStreamOpenFileOutput);
                            try {
                                try {
                                    bufferedOutputStream.write(i.b(m171a(), string.getBytes(StandardCharsets.UTF_8)));
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (Exception e10) {
                                    e9 = e10;
                                    com.xiaomi.channel.commonutils.logger.c.m9a("persist bucket failure: " + e9.getMessage());
                                    y.a(bufferedOutputStream);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream2 = bufferedOutputStream;
                                y.a(bufferedOutputStream2);
                                y.a(fileOutputStreamOpenFileOutput);
                                throw th;
                            }
                        } catch (Exception e11) {
                            bufferedOutputStream = null;
                            e9 = e11;
                        } catch (Throwable th2) {
                            th = th2;
                            y.a(bufferedOutputStream2);
                            y.a(fileOutputStreamOpenFileOutput);
                            throw th;
                        }
                    }
                    y.a(bufferedOutputStream2);
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (Exception e12) {
                bufferedOutputStream = null;
                e9 = e12;
                fileOutputStreamOpenFileOutput = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStreamOpenFileOutput = null;
            }
            y.a(fileOutputStreamOpenFileOutput);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public cp m172a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m180d() {
        String strE = e();
        try {
            File file = new File(f17160a.getFilesDir(), strE);
            if (file.exists()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder("Delete old host fallbacks file ");
                sb.append(strE);
                sb.append(zDelete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.c.m9a(sb.toString());
                return;
            }
            com.xiaomi.channel.commonutils.logger.c.b("Old host fallbacks file " + strE + " does not exist.");
        } catch (Exception e9) {
            StringBuilder sbI = defpackage.f.i("Delete old host fallbacks file ", strE, " error: ");
            sbI.append(e9.getMessage());
            com.xiaomi.channel.commonutils.logger.c.m9a(sbI.toString());
        }
    }

    public cp a(String str, boolean z8) {
        cp cpVarE;
        com.xiaomi.channel.commonutils.logger.c.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z8));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f200a.a(str)) {
                return null;
            }
            cp cpVarC = c(str);
            if (cpVarC == null || !cpVarC.b()) {
                return (z8 && ax.m111a(f17160a) && (cpVarE = e(str)) != null) ? cpVarE : new cp(str, cpVarC) { // from class: com.xiaomi.push.ct.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    cp f17165a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ cp f17166b;

                    {
                        this.f17166b = cpVarC;
                        this.f17165a = cpVarC;
                        ((cp) this).f193b = ((cp) this).f193b;
                        if (cpVarC != null) {
                            this.f17154f = cpVarC.f17154f;
                        }
                    }

                    @Override // com.xiaomi.push.cp
                    public synchronized ArrayList<String> a(boolean z9) {
                        ArrayList<String> arrayList;
                        try {
                            arrayList = new ArrayList<>();
                            cp cpVar = this.f17165a;
                            if (cpVar != null) {
                                arrayList.addAll(cpVar.a(true));
                            }
                            Map<String, cp> map = ct.f17161b;
                            synchronized (map) {
                                try {
                                    cp cpVar2 = map.get(((cp) this).f193b);
                                    if (cpVar2 != null) {
                                        for (String str2 : cpVar2.a(true)) {
                                            if (arrayList.indexOf(str2) == -1) {
                                                arrayList.add(str2);
                                            }
                                        }
                                        arrayList.remove(((cp) this).f193b);
                                        arrayList.add(((cp) this).f193b);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        return arrayList;
                    }

                    @Override // com.xiaomi.push.cp
                    public boolean b() {
                        return false;
                    }

                    @Override // com.xiaomi.push.cp
                    public synchronized void a(String str2, co coVar) {
                        cp cpVar = this.f17165a;
                        if (cpVar != null) {
                            cpVar.a(str2, coVar);
                        }
                    }
                };
            }
            return cpVarC;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private ArrayList<cp> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        m181e();
        synchronized (this.f203a) {
            try {
                m176a();
                for (String str : this.f203a.keySet()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Map<String, cp> map = f17161b;
        synchronized (map) {
            try {
                for (Object obj : map.values().toArray()) {
                    cp cpVar = (cp) obj;
                    if (!cpVar.b()) {
                        f17161b.remove(cpVar.f193b);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cp> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            arrayList2.add(null);
        }
        try {
            String str2 = ax.d(f17160a) ? "wifi" : "wap";
            String strA = a(arrayList, str2, this.f202a, true);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject2 = new JSONObject(strA);
                com.xiaomi.channel.commonutils.logger.c.b(strA);
                if ("OK".equalsIgnoreCase(jSONObject2.getString("S"))) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("R");
                    String string = jSONObject3.getString("province");
                    String string2 = jSONObject3.getString("city");
                    String string3 = jSONObject3.getString("isp");
                    String string4 = jSONObject3.getString("ip");
                    String string5 = jSONObject3.getString("country");
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.c.c("get bucket: net=" + string3 + ", hosts=" + jSONObject4.toString());
                    int i10 = 0;
                    while (i10 < arrayList.size()) {
                        String str3 = arrayList.get(i10);
                        JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray(str3);
                        if (jSONArrayOptJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.c.m9a("no bucket found for " + str3);
                            jSONObject = jSONObject4;
                        } else {
                            cp cpVar2 = new cp(str3);
                            int i11 = 0;
                            while (i11 < jSONArrayOptJSONArray.length()) {
                                String string6 = jSONArrayOptJSONArray.getString(i11);
                                if (!TextUtils.isEmpty(string6)) {
                                    cpVar2.a(new cw(string6, jSONArrayOptJSONArray.length() - i11));
                                }
                                i11++;
                                jSONObject4 = jSONObject4;
                            }
                            jSONObject = jSONObject4;
                            arrayList2.set(i10, cpVar2);
                            cpVar2.f17155g = string5;
                            cpVar2.f17151c = string;
                            cpVar2.f17153e = string3;
                            cpVar2.f17154f = string4;
                            cpVar2.f17152d = string2;
                            if (jSONObject3.has("stat-percent")) {
                                cpVar2.a(jSONObject3.getDouble("stat-percent"));
                            }
                            if (jSONObject3.has("stat-domain")) {
                                cpVar2.b(jSONObject3.getString("stat-domain"));
                            }
                            if (jSONObject3.has(RemoteMessageConst.TTL)) {
                                cpVar2.a(((long) jSONObject3.getInt(RemoteMessageConst.TTL)) * 1000);
                            }
                            m175a(cpVar2.a());
                        }
                        i10++;
                        jSONObject4 = jSONObject;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("reserved");
                    if (jSONObjectOptJSONObject != null) {
                        long j = jSONObject3.has("reserved-ttl") ? ((long) jSONObject3.getInt("reserved-ttl")) * 1000 : 604800000L;
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.c.m9a("no bucket found for " + next);
                            } else {
                                cp cpVar3 = new cp(next);
                                cpVar3.a(j);
                                for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                                    String string7 = jSONArrayOptJSONArray2.getString(i12);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cpVar3.a(new cw(string7, jSONArrayOptJSONArray2.length() - i12));
                                    }
                                }
                                Map<String, cp> map2 = f17161b;
                                synchronized (map2) {
                                    try {
                                        if (this.f200a.a(next)) {
                                            map2.put(next, cpVar3);
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("failed to get bucket " + e9.getMessage());
        }
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            cp cpVar4 = arrayList2.get(i13);
            if (cpVar4 != null) {
                a(arrayList.get(i13), cpVar4);
            }
        }
        m179c();
        return arrayList2;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z8) throws IOException {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<aw> arrayList3 = new ArrayList();
        arrayList3.add(new au("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new au("conpt", a(ax.m106a(f17160a))));
        }
        if (z8) {
            arrayList3.add(new au("reserved", "1"));
        }
        arrayList3.add(new au("uuid", str2));
        arrayList3.add(new au("list", bm.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new au("countrycode", com.xiaomi.push.service.c.a(f17160a).b()));
        arrayList3.add(new au("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String strB = b();
        cp cpVarC = c(strB);
        String str3 = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", strB);
        if (cpVarC == null) {
            arrayList2.add(str3);
            Map<String, cp> map = f17161b;
            synchronized (map) {
                try {
                    cp cpVar = map.get(strB);
                    if (cpVar != null) {
                        Iterator<String> it = cpVar.a(true).iterator();
                        while (it.hasNext()) {
                            arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            arrayList2 = cpVarC.a(str3);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e9 = null;
        while (it2.hasNext()) {
            Uri.Builder builderBuildUpon = Uri.parse(it2.next()).buildUpon();
            for (aw awVar : arrayList3) {
                builderBuildUpon.appendQueryParameter(awVar.a(), awVar.b());
            }
            try {
                b bVar = this.f201a;
                if (bVar == null) {
                    return ax.a(f17160a, new URL(builderBuildUpon.toString()));
                }
                return bVar.a(builderBuildUpon.toString());
            } catch (IOException e10) {
                e9 = e10;
            }
        }
        if (e9 == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("network exception: " + e9.getMessage());
        throw e9;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m174a() {
        synchronized (this.f203a) {
            this.f203a.clear();
        }
    }

    public void a(String str, cp cpVar) {
        if (!TextUtils.isEmpty(str) && cpVar != null) {
            if (this.f200a.a(str)) {
                synchronized (this.f203a) {
                    try {
                        m176a();
                        if (this.f203a.containsKey(str)) {
                            this.f203a.get(str).a(cpVar);
                        } else {
                            cq cqVar = new cq(str);
                            cqVar.a(cpVar);
                            this.f203a.put(str, cqVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + cpVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m176a() {
        synchronized (this.f203a) {
            try {
                if (f198a) {
                    return true;
                }
                f198a = true;
                this.f203a.clear();
                try {
                    String strD = d();
                    if (!TextUtils.isEmpty(strD)) {
                        m178b(strD);
                        com.xiaomi.channel.commonutils.logger.c.b("loading the new hosts succeed");
                        return true;
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("load bucket failure: " + th.getMessage());
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(String str, String str2) {
        Map<String, cp> map = f17161b;
        cp cpVar = map.get(str);
        synchronized (map) {
            try {
                if (cpVar == null) {
                    cp cpVar2 = new cp(str);
                    cpVar2.a(604800000L);
                    cpVar2.m163a(str2);
                    map.put(str, cpVar2);
                } else {
                    cpVar.m163a(str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private byte[] m171a() {
        return bl.m126a(f17160a.getPackageName() + "_key_salt");
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i9 = 0; i9 < bytes.length; i9++) {
                byte b9 = bytes[i9];
                int i10 = b9 & 240;
                if (i10 != 240) {
                    bytes[i9] = (byte) (((b9 & 15) ^ ((byte) (((b9 >> 4) + length) & 15))) | i10);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m175a(String str) {
        this.f205b = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m173a() {
        JSONObject jSONObject;
        synchronized (this.f203a) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("ver", 2);
                JSONArray jSONArray = new JSONArray();
                Iterator<cq> it = this.f203a.values().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m167a());
                }
                jSONObject.put("data", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                Iterator<cp> it2 = f17161b.values().iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next().m162a());
                }
                jSONObject.put("reserved", jSONArray2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }
}
