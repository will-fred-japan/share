package cn.jiguang.commons.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public final class jw {
    private static final String[] j = {"passive", "network", "gps"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocationManager f10327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile HandlerThread f10328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<ab> f10329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f10330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<kc> f10334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<String, ka> f10335i;

    private jw() {
        this.f10329c = new AtomicReference<>();
        this.f10330d = false;
        this.f10331e = new Object();
        this.f10334h = new ArrayList();
        this.f10335i = new ConcurrentHashMap<>();
        Context contextA = jg.a();
        this.f10327a = contextA != null ? (LocationManager) contextA.getSystemService("location") : null;
    }

    private static void c(ab abVar) {
        if (abVar == null) {
            ee.d("LocationUtils", "loc:sp:save:null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", abVar.f9603d);
            jSONObject.put("lng", abVar.f9604e);
            jSONObject.put("acc", abVar.f9607h);
            jSONObject.put("alt", abVar.f9605f);
            jSONObject.put("bearing", abVar.f9606g);
            jSONObject.put("speed", abVar.f9608i);
            jSONObject.put(CrashHianalyticsData.TIME, abVar.f9600a);
            jSONObject.put("fetch", abVar.f9601b);
            String str = abVar.j;
            if (str == null) {
                str = "";
            }
            jSONObject.put("provider", str);
            jSONObject.put("mock", abVar.f9609k);
            String string = jSONObject.toString();
            ee.a("LocationUtils", "loc:sp:saving:data=" + string);
            kr.f10380a.a("loc_gps_cache", string);
            ee.a("LocationUtils", "loc:sp:saved");
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:sp:save:err:"), "LocationUtils");
        }
    }

    private void f() {
        if (this.f10328b == null || !this.f10328b.isAlive()) {
            synchronized (this) {
                try {
                    if (this.f10328b == null || !this.f10328b.isAlive()) {
                        this.f10328b = new HandlerThread("jg_c_location");
                        this.f10328b.start();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private ab g() {
        ab abVarH = h();
        if (abVarH != null) {
            return abVarH;
        }
        ab abVarE = e();
        if (abVarE == null) {
            ee.a("LocationUtils", "loc:sp_miss");
            return null;
        }
        ee.a("LocationUtils", "loc:sp_hit:lat=" + abVarE.f9603d + ",lng=" + abVarE.f9604e);
        this.f10329c.set(abVarE);
        return abVarE;
    }

    private ab h() {
        ab abVar = this.f10329c.get();
        if (abVar == null || Math.abs(System.currentTimeMillis() - abVar.f9600a) >= 40000) {
            return null;
        }
        return abVar;
    }

    private boolean i() {
        ey eyVarB;
        int i9;
        if (this.f10327a == null) {
            ee.d("LocationUtils", "loc:err:mgr_null");
            eyVarB = ey.b();
            i9 = MTPushConstants.MainWhat.ALIAS_CLEAR;
        } else if (!kh.c()) {
            ee.d("LocationUtils", "loc:err:no_perm");
            eyVarB = ey.b();
            i9 = MTPushConstants.MainWhat.ALIAS_GET;
        } else {
            if (d()) {
                return true;
            }
            ee.d("LocationUtils", "loc:err:service_disabled");
            eyVarB = ey.b();
            i9 = MTPushConstants.MainWhat.ON_PLATFORM_TOKEN_TO_USER;
        }
        eyVarB.b(Integer.valueOf(i9));
        return false;
    }

    private static boolean j() {
        try {
            return ((Boolean) bq.a().a(1502, true, true, true, false, false)).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean k() {
        boolean z8;
        synchronized (this.f10331e) {
            z8 = this.f10333g;
        }
        return z8;
    }

    private static void l() {
        try {
            kr.f10380a.a("loc_gps_cache");
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:sp:clear:err:"), "LocationUtils");
        }
    }

    public final Location a(LocationManager locationManager, String str) {
        return a(locationManager, str, false);
    }

    public final ab b() {
        if (!i()) {
            return null;
        }
        ee.a("LocationUtils", "loc:start");
        ab abVarG = g();
        if (abVarG == null) {
            ee.a("LocationUtils", "loc:cache_miss");
            ee.a("LocationUtils", "loc:no_data:trigger_bg");
            ey.b().b((Object) 3001);
            a((kb) null, false, false);
            return null;
        }
        ee.a("LocationUtils", "loc:cache_hit:lat=" + abVarG.f9603d + ",lng=" + abVarG.f9604e);
        ey.b().b(Integer.valueOf(BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT));
        a((kb) null, false, false);
        return abVarG;
    }

    public final boolean d() {
        try {
            LocationManager locationManager = this.f10327a;
            if (locationManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                return locationManager.isLocationEnabled();
            }
            return locationManager.isProviderEnabled("gps") || this.f10327a.isProviderEnabled("network") || this.f10327a.isProviderEnabled("passive");
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("gps:err:check:"), "LocationUtils");
            return false;
        }
    }

    public final ab e() {
        try {
            String strC = kr.f10380a.c("loc_gps_cache", null);
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strC);
            ab abVar = new ab();
            abVar.f9603d = jSONObject.optDouble("lat", 0.0d);
            abVar.f9604e = jSONObject.optDouble("lng", 0.0d);
            abVar.f9607h = jSONObject.optDouble("acc", 0.0d);
            abVar.f9605f = jSONObject.optDouble("alt", 0.0d);
            abVar.f9606g = jSONObject.optDouble("bearing", 0.0d);
            abVar.f9608i = jSONObject.optDouble("speed", 0.0d);
            abVar.f9600a = jSONObject.optLong(CrashHianalyticsData.TIME, 0L);
            abVar.f9601b = jSONObject.optLong("fetch", 0L);
            abVar.j = jSONObject.optString("provider", "");
            abVar.f9609k = jSONObject.optBoolean("mock", false);
            if (abVar.f9603d == 0.0d && abVar.f9604e == 0.0d) {
                l();
                return null;
            }
            long j8 = abVar.f9601b;
            if (j8 <= 0) {
                j8 = abVar.f9600a;
            }
            if (j8 <= 0) {
                l();
                return null;
            }
            long jAbs = Math.abs(System.currentTimeMillis() - j8);
            if (jAbs <= 86400000) {
                return abVar;
            }
            ee.a("LocationUtils", "loc:sp:expired:age_s=" + (jAbs / 1000));
            l();
            return null;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:sp:err:"), "LocationUtils");
            return null;
        }
    }

    public /* synthetic */ jw(byte b9) {
        this();
    }

    private Location a(LocationManager locationManager, String str, boolean z8) {
        Location lastKnownLocation = null;
        if (locationManager == null || str == null) {
            ee.d("LocationUtils", "loc:get:null_param");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ka kaVar = this.f10335i.get(str);
        if (kaVar != null && Math.abs(jCurrentTimeMillis - kaVar.f10350b) < 2000) {
            ee.a("LocationUtils", "loc:hit:".concat(str));
            return kaVar.f10349a;
        }
        if (!c()) {
            return null;
        }
        try {
            lastKnownLocation = (z8 || j()) ? locationManager.getLastKnownLocation(str) : null;
            StringBuilder sb = new StringBuilder("loc:call:");
            sb.append(str);
            sb.append(":ret=");
            sb.append(lastKnownLocation != null);
            ee.a("LocationUtils", sb.toString());
        } catch (SecurityException e9) {
            StringBuilder sbI = defpackage.f.i("loc:err:perm:", str, Constants.COLON_SEPARATOR);
            sbI.append(e9.getMessage());
            ee.d("LocationUtils", sbI.toString());
        } catch (Throwable th) {
            defpackage.f.n(th, defpackage.f.i("loc:err:", str, Constants.COLON_SEPARATOR), "LocationUtils");
        }
        this.f10335i.put(str, new ka(lastKnownLocation, jCurrentTimeMillis));
        return lastKnownLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ab abVar) {
        if (abVar == null) {
            ee.d("LocationUtils", "loc:err:cache_null");
            return;
        }
        ee.a("LocationUtils", "loc:cache:updating");
        this.f10329c.set(abVar);
        this.f10330d = true;
        ap.a().a(1502, abVar);
        c(abVar);
        ee.a("LocationUtils", "loc:cache:updated");
    }

    private boolean b(String str) {
        try {
            LocationManager locationManager = this.f10327a;
            return locationManager != null && locationManager.isProviderEnabled(str);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:provider:err:"), "LocationUtils");
            return false;
        }
    }

    public static boolean c() {
        boolean zA = true;
        if (!ca.a().b() && Build.VERSION.SDK_INT >= 29) {
            try {
                Context contextA = jg.a();
                if (contextA != null && contextA.getApplicationInfo().targetSdkVersion < 29) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            zA = Build.VERSION.SDK_INT >= 29 ? kh.a("android.permission.ACCESS_BACKGROUND_LOCATION") : true;
            if (!zA) {
                ee.a("LocationUtils", "loc:api_blocked:no_bg_pern");
            }
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ab a(Location location) {
        if (location == null) {
            return null;
        }
        ab abVar = new ab();
        abVar.f9603d = location.getLatitude();
        abVar.f9604e = location.getLongitude();
        abVar.f9607h = location.getAccuracy();
        abVar.f9606g = location.getBearing();
        abVar.f9608i = location.getSpeed();
        abVar.f9605f = location.getAltitude();
        abVar.j = location.getProvider();
        abVar.f9600a = location.getTime();
        abVar.f9601b = System.currentTimeMillis();
        abVar.f9609k = location.isFromMockProvider();
        return abVar;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:63:0x0103 A[Catch: all -> 0x00fd, InterruptedException -> 0x0100, Merged into TryCatch #2 {all -> 0x00fd, InterruptedException -> 0x0100, blocks: (B:33:0x0071, B:49:0x00de, B:77:0x0123, B:80:0x013a, B:82:0x0144, B:84:0x014a, B:88:0x0164, B:90:0x0182, B:95:0x0192, B:89:0x0168, B:56:0x00f3, B:63:0x0103, B:66:0x010d, B:48:0x00c6, B:100:0x01a3), top: B:107:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x010b  */
    /* JADX WARN: Code duplicated, block: B:66:0x010d A[Catch: all -> 0x00fd, InterruptedException -> 0x0100, Merged into TryCatch #2 {all -> 0x00fd, InterruptedException -> 0x0100, blocks: (B:33:0x0071, B:49:0x00de, B:77:0x0123, B:80:0x013a, B:82:0x0144, B:84:0x014a, B:88:0x0164, B:90:0x0182, B:95:0x0192, B:89:0x0168, B:56:0x00f3, B:63:0x0103, B:66:0x010d, B:48:0x00c6, B:100:0x01a3), top: B:107:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0113  */
    /* JADX WARN: Code duplicated, block: B:69:0x0114  */
    /* JADX WARN: Code duplicated, block: B:71:0x0117  */
    /* JADX WARN: Code duplicated, block: B:76:0x0121  */
    /* JADX WARN: Code duplicated, block: B:80:0x013a A[Catch: all -> 0x00fd, InterruptedException -> 0x0100, Merged into TryCatch #2 {all -> 0x00fd, InterruptedException -> 0x0100, blocks: (B:33:0x0071, B:49:0x00de, B:77:0x0123, B:80:0x013a, B:82:0x0144, B:84:0x014a, B:88:0x0164, B:90:0x0182, B:95:0x0192, B:89:0x0168, B:56:0x00f3, B:63:0x0103, B:66:0x010d, B:48:0x00c6, B:100:0x01a3), top: B:107:0x0071 }, TRY_ENTER] */
    /* JADX WARN: Code duplicated, block: B:89:0x0168 A[Catch: all -> 0x00fd, InterruptedException -> 0x0100, Merged into TryCatch #2 {all -> 0x00fd, InterruptedException -> 0x0100, blocks: (B:33:0x0071, B:49:0x00de, B:77:0x0123, B:80:0x013a, B:82:0x0144, B:84:0x014a, B:88:0x0164, B:90:0x0182, B:95:0x0192, B:89:0x0168, B:56:0x00f3, B:63:0x0103, B:66:0x010d, B:48:0x00c6, B:100:0x01a3), top: B:107:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x018c A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:94:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0192 A[Catch: all -> 0x00fd, InterruptedException -> 0x0100, Merged into TryCatch #2 {all -> 0x00fd, InterruptedException -> 0x0100, blocks: (B:33:0x0071, B:49:0x00de, B:77:0x0123, B:80:0x013a, B:82:0x0144, B:84:0x014a, B:88:0x0164, B:90:0x0182, B:95:0x0192, B:89:0x0168, B:56:0x00f3, B:63:0x0103, B:66:0x010d, B:48:0x00c6, B:100:0x01a3), top: B:107:0x0071 }, TRY_ENTER, TRY_LEAVE] */
    /* JADX WARN: Code duplicated, block: B:98:0x019f A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:89:0x0168, please report this as an issue */
    private ab a(String str) {
        String str2;
        int iHashCode;
        long j8;
        boolean zAwait;
        long jAbs;
        String str3;
        ab abVarA;
        ab abVar;
        boolean z8 = this.f10330d;
        String[] strArr = j;
        int length = strArr.length;
        byte b9 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                ee.d("LocationUtils", "loc:no_provider");
                str2 = null;
                break;
            }
            String str4 = strArr[i9];
            if (!str4.equals(str) && ((z8 || !"passive".equals(str4)) && b(str4))) {
                ee.a("LocationUtils", "loc:best_provider:".concat(str4));
                str2 = str4;
                break;
            }
            i9++;
        }
        boolean zK = k();
        if (str2 == null) {
            ab abVarA2 = a(true, zK);
            if (abVarA2 != null) {
                return abVarA2;
            }
            ab abVarE = e();
            if (abVarE != null) {
                return abVarE;
            }
            return null;
        }
        if (!zK && !j()) {
            ee.a("LocationUtils", "loc:req:fail:po");
            return null;
        }
        if (!c()) {
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        jx jxVar = new jx(this, countDownLatch);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                f();
                if (this.f10327a == null) {
                    ee.d("LocationUtils", "loc:req_err:null_param");
                } else {
                    if (b(str2)) {
                        if (c()) {
                            this.f10327a.requestLocationUpdates(str2, 2000L, 0.0f, jxVar, this.f10328b.getLooper());
                            ee.a("LocationUtils", "loc:req_registered:" + str2);
                        }
                        iHashCode = str2.hashCode();
                        if (iHashCode != -792039641) {
                            if (iHashCode != 102570) {
                                if (iHashCode == 1843485230 && str2.equals("network")) {
                                    b9 = 1;
                                } else {
                                    b9 = -1;
                                }
                            } else if (str2.equals("gps")) {
                                b9 = 2;
                            } else {
                                b9 = -1;
                            }
                        } else if (str2.equals("passive")) {
                            b9 = -1;
                        }
                        if (b9 != 0) {
                            j8 = com.heytap.mcssdk.constant.a.f14256r;
                            if (b9 != 1 && b9 == 2) {
                                j8 = 8000;
                            }
                        } else {
                            j8 = 2000;
                        }
                        zAwait = countDownLatch.await(j8, TimeUnit.MILLISECONDS);
                        jAbs = Math.abs(System.currentTimeMillis() - jCurrentTimeMillis) / 1000;
                        if (zAwait) {
                            abVar = this.f10329c.get();
                            if (abVar == null && abVar.f9601b >= jCurrentTimeMillis) {
                                ee.a("LocationUtils", "loc:req_ok:time=" + jAbs + "s");
                                return abVar;
                            }
                            str3 = "loc:req:fail:latch_ok:no_fresh";
                        } else {
                            str3 = "loc:req_timeout:" + str2 + Constants.COLON_SEPARATOR + jAbs + "s";
                        }
                        ee.d("LocationUtils", str3);
                        abVarA = a(true, k());
                        if (abVarA != null) {
                            return abVarA;
                        }
                        if (str == null) {
                            return null;
                        }
                        ee.a("LocationUtils", "loc:req_retry");
                        return a(str2);
                    }
                    ee.d("LocationUtils", "loc:req_err:provider_disabled:" + str2);
                }
                a(countDownLatch);
            } catch (Throwable th) {
                ee.d("LocationUtils", "loc:req_err:" + th.getMessage());
                a(countDownLatch);
            }
            iHashCode = str2.hashCode();
            if (iHashCode != -792039641) {
                if (iHashCode != 102570) {
                    if (iHashCode == 1843485230) {
                        b9 = 1;
                    }
                    b9 = -1;
                } else if (str2.equals("gps")) {
                    b9 = 2;
                } else {
                    b9 = -1;
                }
            } else if (str2.equals("passive")) {
                b9 = -1;
            }
            if (b9 != 0) {
                j8 = com.heytap.mcssdk.constant.a.f14256r;
                if (b9 != 1) {
                    j8 = 8000;
                }
            } else {
                j8 = 2000;
            }
            zAwait = countDownLatch.await(j8, TimeUnit.MILLISECONDS);
            jAbs = Math.abs(System.currentTimeMillis() - jCurrentTimeMillis) / 1000;
            if (zAwait) {
                abVar = this.f10329c.get();
                if (abVar == null) {
                }
                str3 = "loc:req:fail:latch_ok:no_fresh";
            } else {
                str3 = "loc:req_timeout:" + str2 + Constants.COLON_SEPARATOR + jAbs + "s";
            }
            ee.d("LocationUtils", str3);
            abVarA = a(true, k());
            if (abVarA != null) {
                return abVarA;
            }
            if (str == null) {
                return null;
            }
            ee.a("LocationUtils", "loc:req_retry");
            return a(str2);
        } catch (InterruptedException e9) {
            ee.d("LocationUtils", "loc:err:interrupted:" + e9.getMessage());
            Thread.currentThread().interrupt();
            return null;
        } finally {
            a(jxVar, countDownLatch);
        }
    }

    private ab a(boolean z8, boolean z9) {
        String str;
        try {
            Location location = null;
            for (String str2 : j) {
                try {
                    if (b(str2)) {
                        try {
                            Location locationA = a(this.f10327a, str2, z9);
                            if (locationA != null) {
                                ee.a("LocationUtils", "loc:lk:" + str2 + ":ok");
                            }
                            if (locationA != null) {
                                if (location != null) {
                                    long time = locationA.getTime() - location.getTime();
                                    if (time <= 120000) {
                                        if (time >= -120000) {
                                            float accuracy = locationA.getAccuracy() - location.getAccuracy();
                                            if (accuracy < 0.0f || (time > 0 && accuracy <= 200.0f)) {
                                            }
                                        }
                                    }
                                }
                                location = locationA;
                            }
                        } catch (Throwable th) {
                            th = th;
                            ee.d("LocationUtils", "loc:lk:" + str2 + ":err:" + th.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (location != null) {
                long jAbs = Math.abs(System.currentTimeMillis() - location.getTime());
                str = ((jAbs < 40000) || (jAbs < 300000)) ? "loc:lk:null" : "loc:lk:old:age=" + jAbs + "ms";
                ee.a("LocationUtils", "loc:lk:valid:age=" + jAbs + "ms,provider=" + location.getProvider());
                return a(location);
            }
            ee.a("LocationUtils", str);
        } catch (Throwable th3) {
            defpackage.f.n(th3, new StringBuilder("loc:lk:err:"), "LocationUtils");
        }
        return null;
    }

    public static jw a() {
        return kd.f10353a;
    }

    private void a(LocationListener locationListener) {
        try {
            LocationManager locationManager = this.f10327a;
            if (locationManager == null || locationListener == null) {
                return;
            }
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:err:remove_updates:"), "LocationUtils");
        }
    }

    private void a(LocationListener locationListener, CountDownLatch countDownLatch) {
        try {
            a(locationListener);
            a(countDownLatch);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:err:cleanup:"), "LocationUtils");
        }
    }

    private void a(ab abVar) {
        a((ab) null, k());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0014 A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:6:0x0008, B:13:0x0025, B:12:0x0014), top: B:33:0x0008 }] */
    private void a(ab abVar, boolean z8) {
        ab abVarG;
        boolean z9;
        ArrayList<kc> arrayList;
        boolean z10;
        boolean z11;
        ab abVar2;
        while (true) {
            synchronized (this.f10331e) {
                abVarG = null;
                z9 = false;
                if (abVar == null) {
                    try {
                        if (!this.f10333g || z8) {
                            arrayList = new ArrayList(this.f10334h);
                            this.f10334h.clear();
                            this.f10333g = false;
                            this.f10332f = false;
                            z10 = false;
                        } else {
                            arrayList = null;
                            z10 = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    arrayList = new ArrayList(this.f10334h);
                    this.f10334h.clear();
                    this.f10333g = false;
                    this.f10332f = false;
                    z10 = false;
                }
            }
            if (!z10) {
                for (kc kcVar : arrayList) {
                    if (abVar == null && kcVar.f10352b) {
                        if (!z9) {
                            abVarG = g();
                            z9 = true;
                        }
                        z11 = z9;
                        abVar2 = abVarG;
                    } else {
                        z11 = z9;
                        abVar2 = abVarG;
                        abVarG = abVar;
                    }
                    a(kcVar.f10351a, abVarG);
                    abVarG = abVar2;
                    z9 = z11;
                }
                return;
            }
            if (fe.a().a(new jz(this), fl.LIGHT_TASK)) {
                return;
            }
            ee.d("LocationUtils", "loc:bg:rerun_submit_fail");
            abVar = null;
            z8 = true;
        }
    }

    public static /* synthetic */ void a(jw jwVar) {
        String str;
        boolean zK = jwVar.k();
        ab abVarA = null;
        try {
            ee.a("LocationUtils", "loc:bg:start request");
            abVarA = jwVar.a((String) null);
            if (abVarA != null) {
                jwVar.b(abVarA);
                str = "loc:bg:ok";
            } else {
                str = "loc:bg:failed";
            }
            ee.a("LocationUtils", str);
        } catch (Throwable th) {
            try {
                ee.d("LocationUtils", "loc:bg:err:" + th.getMessage());
            } finally {
                jwVar.a(abVarA, zK);
                ee.a("LocationUtils", "loc:bg:done");
            }
        }
    }

    private static void a(kb kbVar, ab abVar) {
        if (kbVar == null) {
            return;
        }
        try {
            kbVar.a(abVar);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("loc:cb:err:"), "LocationUtils");
        }
    }

    private void a(kb kbVar, boolean z8, boolean z9) {
        synchronized (this.f10331e) {
            if (kbVar != null) {
                try {
                    this.f10334h.add(new kc(kbVar, z9));
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z8) {
                this.f10333g = true;
            }
            if (this.f10332f) {
                ee.a("LocationUtils", "loc:bg:skip:running");
                return;
            }
            this.f10332f = true;
            if (fe.a().a(new jy(this), fl.LIGHT_TASK)) {
                return;
            }
            ee.d("LocationUtils", "loc:bg:submit_fail");
            a((ab) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            try {
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.countDown();
                }
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("loc:signal:err:"), "LocationUtils");
            }
        }
    }

    public final void a(boolean z8, hw hwVar) {
        if (i()) {
            a((kb) hwVar, z8, true);
        } else {
            a(hwVar, g());
        }
    }
}
