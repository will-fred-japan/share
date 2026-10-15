package p017c2;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.xiaomi.clientreport.data.Config;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.h;
import p124q1.f;

/* JADX INFO: compiled from: StorageCollector.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends p017c2.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static long f8715A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static long f8716B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f8717w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f8718x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f8719y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f8720z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8723i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f8728o;
    public p099n1.g<b> t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p099n1.g<b> f8733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p099n1.g<d> f8734v;
    public long j = 524288000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f8724k = 524288000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8725l = 20;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f8726m = 2592000000L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f8729p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f8730q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f8731r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f8732s = new ArrayList();

    /* JADX INFO: compiled from: StorageCollector.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8739e = "normal";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ArrayList f8740f = new ArrayList();

        public final long a() {
            long j = g.f8715A;
            if (j > 0) {
                return j;
            }
            if (TextUtils.equals(this.f8735a, g.f8718x)) {
                long j8 = this.f8736b;
                g.f8715A = j8;
                return j8;
            }
            if (!this.f8740f.isEmpty()) {
                Iterator it = this.f8740f.iterator();
                while (it.hasNext()) {
                    long jA = ((a) it.next()).a();
                    if (jA > 0) {
                        return jA;
                    }
                }
            }
            return 0L;
        }

        public final JSONObject b(BigDecimal bigDecimal) {
            JSONObject jSONObject = new JSONObject();
            try {
                float fFloatValue = new BigDecimal(this.f8736b).divide(bigDecimal, 4, 4).floatValue();
                this.f8737c = fFloatValue;
                if (fFloatValue > 1.0f) {
                    this.f8737c = 0.0f;
                }
                String strReplace = this.f8735a;
                if (strReplace.contains(g.f8717w)) {
                    strReplace = strReplace.replace(g.f8717w, "internal");
                } else if (strReplace.contains(g.f8719y)) {
                    strReplace = strReplace.replace(g.f8719y, "external");
                }
                jSONObject.put("path", strReplace);
                jSONObject.put("size", this.f8736b);
                jSONObject.put("size_rate", this.f8737c);
                jSONObject.put("is_folder", this.f8738d);
                jSONObject.put("report_type", this.f8739e);
                if (!this.f8740f.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = this.f8740f.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((a) it.next()).b(bigDecimal));
                    }
                    jSONObject.put("next_disk", jSONArray);
                    return jSONObject;
                }
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
            return jSONObject;
        }

        public final long c() {
            long j = g.f8716B;
            if (j > 0) {
                return j;
            }
            if (TextUtils.equals(this.f8735a, g.f8720z)) {
                long j8 = this.f8736b;
                g.f8716B = j8;
                return j8;
            }
            if (!this.f8740f.isEmpty()) {
                Iterator it = this.f8740f.iterator();
                while (it.hasNext()) {
                    long jC = ((a) it.next()).c();
                    if (jC > 0) {
                        return jC;
                    }
                }
            }
            return 0L;
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    public static class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f8742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8743c;

        public b() {
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                String strReplace = this.f8741a;
                if (strReplace.contains(g.f8717w)) {
                    strReplace = strReplace.replace(g.f8717w, "internal");
                } else if (strReplace.contains(g.f8719y)) {
                    strReplace = strReplace.replace(g.f8719y, "external");
                }
                jSONObject.put(MTCommonConstants.Network.KEY_NAME, strReplace);
                jSONObject.put("size", this.f8742b);
                int i9 = this.f8743c;
                if (i9 > 0) {
                    jSONObject.put("num", i9);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            long j = this.f8742b;
            long j8 = ((b) obj).f8742b;
            if (j == j8) {
                return 0;
            }
            return j > j8 ? 1 : -1;
        }

        public b(int i9, String str, long j) {
            this.f8741a = str;
            this.f8742b = j;
            this.f8743c = i9;
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f8745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8751h;

        public c() {
        }

        public final void a(long j) {
            int i9;
            long j8 = this.f8746c + j;
            this.f8746c = j8;
            int i10 = this.f8748e + 1;
            this.f8748e = i10;
            c cVar = this.f8745b;
            if (cVar == null || i10 != (i9 = this.f8747d)) {
                return;
            }
            if (this.f8751h) {
                cVar.f8751h = true;
            }
            g gVar = g.this;
            if (j8 >= gVar.f8724k && !this.f8751h) {
                String str = this.f8744a;
                if (j8 <= 68719476736L) {
                    if (gVar.f8733u == null) {
                        gVar.f8733u = new p099n1.g<>(gVar.f8725l);
                    }
                    gVar.f8733u.a(new b(i9, str, j8));
                }
                this.f8745b.f8751h = true;
            }
            this.f8745b.a(this.f8746c);
            if (this.f8749f) {
                g.this.o(this.f8744a, this.f8747d, this.f8746c, this.f8750g);
            }
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    public static class d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8756g;

        @Override // c2.g.b
        public final JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                String strReplace = this.f8753d;
                if (strReplace.contains(g.f8717w)) {
                    strReplace = strReplace.replace(g.f8717w, "internal");
                } else if (strReplace.contains(g.f8719y)) {
                    strReplace = strReplace.replace(g.f8719y, "external");
                }
                jSONObject.put(MTCommonConstants.Network.KEY_NAME, strReplace);
                jSONObject.put("size", this.f8754e);
                int i9 = this.f8755f;
                if (i9 > 0) {
                    jSONObject.put("num", i9);
                }
                jSONObject.put("outdate_interval", this.f8756g);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // c2.g.b, java.lang.Comparable
        public final int compareTo(Object obj) {
            long j = this.f8756g;
            long j8 = ((d) obj).f8756g;
            if (j == j8) {
                return 0;
            }
            return j > j8 ? 1 : -1;
        }
    }

    public g() {
        this.f8695e = "disk";
    }

    public static long l(File file) {
        long jL = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    jL += file2.isDirectory() ? l(file2) : file2.length();
                }
            }
            return jL;
        } catch (Exception e9) {
            e9.printStackTrace();
            return jL;
        }
    }

    @Override // p017c2.a
    public final void a(JSONObject jSONObject) {
        this.f8722h = jSONObject.optBoolean("dump_switch", true);
        this.f8723i = jSONObject.optBoolean("enable_upload", true);
        if (this.f8722h) {
            long jCurrentTimeMillis = System.currentTimeMillis() - W1.b.a.f5047a.f5046a.getLong("check_disk_last_time", 0L);
            if (jCurrentTimeMillis < 86400000 && jCurrentTimeMillis > 0) {
                this.f8721g = true;
            }
            if (jSONObject.optInt("dump_threshold") > 0) {
                this.j = ((long) jSONObject.optInt("dump_threshold")) * Config.DEFAULT_MAX_FILE_LENGTH;
            }
            if (jSONObject.optInt("abnormal_folder_size") > 0) {
                this.f8724k = ((long) jSONObject.optInt("abnormal_folder_size")) * Config.DEFAULT_MAX_FILE_LENGTH;
            }
            if (jSONObject.optInt("dump_top_count") > 0) {
                this.f8725l = jSONObject.optInt("dump_top_count");
            }
            if (jSONObject.optInt("outdated_days") > 0) {
                this.f8726m = ((long) jSONObject.optInt("outdated_days")) * 86400000;
            }
            ArrayList arrayList = null;
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("disk_customed_paths");
                if (!A1.b.E0(jSONObjectOptJSONObject)) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (jSONObjectOptJSONObject.optInt(next) == 1) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Exception unused) {
            }
            this.f8729p = arrayList;
            this.f8730q = A1.b.r("ignored_relative_paths", jSONObject);
        }
    }

    @Override // p017c2.a
    public final boolean h() {
        return true;
    }

    @Override // p017c2.a
    public final void j() {
        g gVar;
        if (h.f19230b) {
            Log.i("DiskMonitor", p199z2.b.f(new String[]{"Storage onStart"}));
        }
        boolean z8 = this.f8692b;
        boolean z9 = h.f19230b;
        if (!z9 && (this.f8721g || !z8)) {
            if (z9) {
                Log.i("DiskMonitor", p199z2.b.f(new String[]{"mHasUploadUsedStorage：" + this.f8721g + " background：" + z8 + " return"}));
                return;
            }
            return;
        }
        if (!this.f8723i && !this.f8722h) {
            if (z9) {
                Log.i("DiskMonitor", p199z2.b.f(new String[]{"isIndicatorSwitch:" + this.f8723i + " isExceptionDiskSwitch:" + this.f8722h + " return"}));
                return;
            }
            return;
        }
        if (f8717w == null) {
            Application application = h.f19229a;
            try {
                application.getPackageName();
                f8717w = application.getFilesDir().getParent();
                f8718x = application.getCacheDir().getAbsolutePath();
                f8719y = application.getExternalFilesDir(null).getParentFile().getAbsolutePath();
                File externalCacheDir = application.getExternalCacheDir();
                if (externalCacheDir != null) {
                    f8720z = externalCacheDir.getAbsolutePath();
                }
                ArrayList<String> arrayList = this.f8730q;
                if (arrayList != null) {
                    for (String str : arrayList) {
                        boolean zContains = str.contains("internal");
                        ArrayList arrayList2 = this.f8731r;
                        if (zContains) {
                            arrayList2.add(str.replace("internal", f8717w));
                        } else if (str.contains("external")) {
                            arrayList2.add(str.replace("external", f8719y));
                        }
                    }
                }
                ArrayList<String> arrayList3 = this.f8729p;
                if (arrayList3 != null) {
                    for (String str2 : arrayList3) {
                        boolean zContains2 = str2.contains("internal");
                        ArrayList arrayList4 = this.f8732s;
                        if (zContains2) {
                            arrayList4.add(str2.replace("internal", f8717w));
                        } else if (str2.contains("external")) {
                            arrayList4.add(str2.replace("external", f8719y));
                        }
                    }
                }
            } catch (Exception e9) {
                this.f8727n = true;
                if (h.f19230b) {
                    Log.i("DiskMonitor", p199z2.b.f(new String[]{"mInitException:" + this.f8727n + " exception:" + e9.getMessage()}));
                }
            }
        }
        if (this.f8727n) {
            this.f8721g = true;
            return;
        }
        try {
            p();
            ArrayList arrayList5 = this.f8728o;
            long j = 0;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                Iterator it = this.f8728o.iterator();
                while (it.hasNext()) {
                    j += ((a) it.next()).f8736b;
                }
            }
            long j8 = j;
            ArrayList arrayList6 = this.f8728o;
            if (arrayList6 != null && !arrayList6.isEmpty()) {
                for (a aVar : this.f8728o) {
                    aVar.a();
                    aVar.c();
                }
            }
            gVar = this;
            try {
                gVar.m(j8, f8716B + f8715A, Environment.getRootDirectory().getTotalSpace() + Environment.getDataDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());
                W1.b.a.f5047a.f5046a.edit().putLong("check_disk_last_time", System.currentTimeMillis()).apply();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gVar = this;
        }
        gVar.f8721g = true;
        if (h.f19230b) {
            Log.i("DiskMonitor", p199z2.b.f(new String[]{"mHasUploadUsedStorage:" + gVar.f8721g + " finish"}));
        }
        if (gVar.f8694d) {
            gVar.f8694d = false;
            p133r2.b bVar = p133r2.b.f21107i;
            bVar.getClass();
            try {
                bVar.f21113f.remove(this);
            } catch (Throwable unused3) {
            }
        }
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) E4.c.a(IConfigManager.class)).unregisterConfigListener(this);
    }

    @Override // p017c2.a
    public final long k() {
        return 120000L;
    }

    public final void m(long j, long j8, long j9, long j10) {
        JSONObject jSONObject;
        try {
            if (h.f19230b) {
                Log.i("DiskMonitor", p199z2.b.f(new String[]{"disk: data: " + j + " , cache: " + j8 + " , total: " + j9 + " , free: " + j10}));
            }
            long j11 = 68719476736L;
            long j12 = j > 68719476736L ? 68719476736L : j;
            if (j8 <= 68719476736L) {
                j11 = j8;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (j > 0) {
                jSONObject2.put("data", j12);
            }
            if (j8 > 0) {
                jSONObject2.put("cache", j11);
            }
            if (j9 > 0) {
                long j13 = j9 / 1073741824;
                if (j13 > RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                    j13 = 0;
                }
                jSONObject2.put("total", j13);
            }
            if (j10 > 0) {
                long j14 = j10 / 1073741824;
                if (j14 > RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                    j14 = 0;
                }
                jSONObject2.put("rom_free", j14);
            }
            JSONObject jSONObject3 = new JSONObject();
            ArrayList arrayList = this.f8728o;
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f8728o.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((a) it.next()).b(new BigDecimal(j12)));
                }
                jSONObject3.put("disk_info", jSONArray);
            }
            JSONObject jSONObject4 = null;
            this.f8728o = null;
            if (this.f8722h && j12 > this.j) {
                if (this.t != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    p099n1.g<b> gVar = this.t;
                    gVar.getClass();
                    ArrayList arrayList2 = new ArrayList(gVar.f20564a);
                    Collections.sort(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        JSONObject jSONObjectA = ((b) it2.next()).a();
                        if (jSONObjectA != null) {
                            jSONArray2.put(jSONObjectA);
                        }
                    }
                    jSONObject3.put("top_usage", jSONArray2);
                }
                if (this.f8733u != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    p099n1.g<b> gVar2 = this.f8733u;
                    gVar2.getClass();
                    ArrayList arrayList3 = new ArrayList(gVar2.f20564a);
                    Collections.sort(arrayList3);
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        JSONObject jSONObjectA2 = ((b) it3.next()).a();
                        if (jSONObjectA2 != null) {
                            jSONArray3.put(jSONObjectA2);
                        }
                    }
                    jSONObject3.put("exception_folders", jSONArray3);
                }
                if (this.f8734v != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    p099n1.g<d> gVar3 = this.f8734v;
                    gVar3.getClass();
                    ArrayList arrayList4 = new ArrayList(gVar3.f20564a);
                    Collections.sort(arrayList4);
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        JSONObject jSONObjectA3 = ((d) it4.next()).a();
                        if (jSONObjectA3 != null) {
                            jSONArray4.put(jSONObjectA3);
                        }
                    }
                    jSONObject3.put("outdated_files", jSONArray4);
                }
                this.t = null;
                this.f8733u = null;
                this.f8734v = null;
            }
            f fVar = new f();
            fVar.f20895a = "disk";
            fVar.f20896b = "storageUsed";
            fVar.f20897c = "";
            fVar.f20898d = jSONObject2;
            fVar.f20899e = null;
            fVar.f20901g = jSONObject3;
            d(fVar);
            if (h.f19230b) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"Receive:DiskData"}));
                Log.i("DiskMonitor", p199z2.b.f(new String[]{"extraValues: " + jSONObject2.toString() + " extraLog:" + jSONObject3.toString()}));
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("log_type", "performance_monitor");
                jSONObject5.put("service", "disk");
                if (!A1.b.w0(jSONObject2)) {
                    jSONObject5.put("extra_values", jSONObject2);
                }
                if (TextUtils.equals("start", "disk") && TextUtils.equals("from", jSONObject5.optString("monitor-plugin"))) {
                    jSONObject = new JSONObject();
                    jSONObject.put("start_mode", h.f19237i);
                } else {
                    jSONObject = null;
                }
                if (!A1.b.w0(jSONObject)) {
                    jSONObject5.put("extra_status", jSONObject);
                }
                jSONObject4 = jSONObject5;
            } catch (JSONException unused) {
            }
            if (jSONObject4 != null) {
                p024d2.b.f18492c.a(jSONObject4.toString());
            }
        } catch (Throwable unused2) {
        }
    }

    public final void n(File file, int i9, boolean z8, ArrayList arrayList) {
        ArrayList arrayList2;
        int i10 = 4;
        if (i9 > 4 || !file.exists()) {
            return;
        }
        ArrayList arrayList3 = this.f8731r;
        if (arrayList3.contains(file.getAbsolutePath())) {
            return;
        }
        int i11 = 0;
        if (!file.isDirectory()) {
            a aVar = new a();
            aVar.f8738d = false;
            aVar.f8735a = file.getAbsolutePath();
            aVar.f8736b = file.length();
            if (!z8) {
                aVar.f8739e = "custom";
            }
            arrayList.add(aVar);
            return;
        }
        if (!z8) {
            a aVar2 = new a();
            aVar2.f8738d = true;
            aVar2.f8739e = "custom";
            aVar2.f8735a = file.getAbsolutePath();
            aVar2.f8736b = l(file);
            arrayList.add(aVar2);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        int length = fileArrListFiles.length;
        int i12 = 0;
        while (i11 < length) {
            File file2 = fileArrListFiles[i11];
            if (i12 >= 50) {
                return;
            }
            i12++;
            if (file2 == null || !file2.exists() || arrayList3.contains(file2.getAbsolutePath())) {
                arrayList2 = arrayList3;
            } else {
                a aVar3 = new a();
                aVar3.f8738d = file2.isDirectory();
                aVar3.f8735a = file2.getAbsolutePath();
                if (file2.isDirectory()) {
                    ArrayList arrayList4 = new ArrayList();
                    aVar3.f8740f = arrayList4;
                    if (i9 == i10) {
                        aVar3.f8736b = l(file2);
                    }
                    int i13 = i9 + 1;
                    n(file2, i13, z8, arrayList4);
                    if (i13 <= i10) {
                        Iterator it = arrayList4.iterator();
                        while (it.hasNext()) {
                            aVar3.f8736b += ((a) it.next()).f8736b;
                            arrayList3 = arrayList3;
                        }
                    }
                    arrayList2 = arrayList3;
                    arrayList.add(aVar3);
                } else {
                    arrayList2 = arrayList3;
                    aVar3.f8736b = file2.length();
                    arrayList.add(aVar3);
                }
            }
            i11++;
            arrayList3 = arrayList2;
            i10 = 4;
        }
    }

    public final void o(String str, int i9, long j, long j8) {
        if (j < 102400 || j > 68719476736L) {
            return;
        }
        if (this.f8734v == null) {
            this.f8734v = new p099n1.g<>(this.f8725l);
        }
        p099n1.g<d> gVar = this.f8734v;
        d dVar = new d();
        dVar.f8753d = str;
        dVar.f8754e = j;
        dVar.f8755f = i9;
        dVar.f8756g = j8;
        gVar.a(dVar);
    }

    public final void p() {
        long j;
        long j8;
        String[] strArr = {f8717w, f8719y};
        this.f8728o = new ArrayList();
        for (int i9 = 0; i9 < 2; i9++) {
            String str = strArr[i9];
            n(new File(str), 1, true, this.f8728o);
            File file = new File(str);
            c cVar = new c();
            cVar.f8744a = str;
            cVar.f8745b = new c();
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                cVar.f8747d = fileArrListFiles.length;
                LinkedList linkedList = new LinkedList();
                linkedList.offer(cVar);
                while (!linkedList.isEmpty()) {
                    int size = linkedList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        c cVar2 = (c) linkedList.poll();
                        if (cVar2 != null) {
                            String str2 = cVar2.f8744a;
                            File file2 = new File(str2);
                            if (!file2.exists() || this.f8731r.contains(str2)) {
                                cVar2.f8745b.f8747d--;
                            } else {
                                long j9 = 0;
                                if (file2.isFile()) {
                                    long length = file2.length();
                                    if (length <= 0 || length > 68719476736L) {
                                        j8 = 62899200000L;
                                    } else {
                                        j8 = 62899200000L;
                                        if (this.t == null) {
                                            this.t = new p099n1.g<>(this.f8725l);
                                        }
                                        this.t.a(new b(1, str2, length));
                                    }
                                    c cVar3 = cVar2.f8745b;
                                    if (cVar3 != null) {
                                        cVar3.a(length);
                                        if (!cVar2.f8745b.f8749f) {
                                            long jCurrentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                                            long j10 = (jCurrentTimeMillis < this.f8726m || jCurrentTimeMillis >= j8) ? 0L : jCurrentTimeMillis;
                                            if (j10 > 0) {
                                                o(str2, 0, length, j10);
                                            }
                                        }
                                    }
                                } else {
                                    File[] fileArrListFiles2 = file2.listFiles();
                                    if (fileArrListFiles2 == null || fileArrListFiles2.length == 0) {
                                        cVar2.f8745b.a(0L);
                                    } else {
                                        cVar2.f8747d = fileArrListFiles2.length;
                                        int length2 = fileArrListFiles2.length;
                                        int i11 = 0;
                                        while (i11 < length2) {
                                            File file3 = fileArrListFiles2[i11];
                                            c cVar4 = new c();
                                            cVar4.f8745b = cVar2;
                                            cVar4.f8744a = file3.getAbsolutePath();
                                            if (!file3.isDirectory() || cVar2.f8749f) {
                                                j = j9;
                                            } else {
                                                long jCurrentTimeMillis2 = System.currentTimeMillis() - file3.lastModified();
                                                j = j9;
                                                long j11 = (jCurrentTimeMillis2 < this.f8726m || jCurrentTimeMillis2 >= 62899200000L) ? j : jCurrentTimeMillis2;
                                                if (j11 > j) {
                                                    cVar4.f8749f = true;
                                                    cVar4.f8750g = j11;
                                                }
                                            }
                                            linkedList.offer(cVar4);
                                            i11++;
                                            j9 = j;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList arrayList = this.f8732s;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            n(new File((String) it.next()), 1, false, this.f8728o);
        }
    }
}
