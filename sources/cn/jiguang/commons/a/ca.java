package cn.jiguang.commons.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.local.JPushConstants;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f9771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f9772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f9773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f9774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicReference<Byte> f9775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicLong f9776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f9777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f9778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f9779i;
    private final AtomicBoolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f9780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f9781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f9782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f9783n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f9784o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile long f9785p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile long f9786q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile String f9787r;

    private ca() {
        this.f9771a = new AtomicBoolean();
        this.f9772b = new AtomicBoolean();
        this.f9773c = new AtomicBoolean(true);
        this.f9774d = new AtomicBoolean(false);
        this.f9775e = new AtomicReference<>();
        this.f9776f = new AtomicLong(0L);
        this.f9777g = new Object();
        this.f9778h = new AtomicBoolean(false);
        this.f9779i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.f9780k = new AtomicBoolean(false);
        this.f9781l = new AtomicBoolean(false);
        this.f9782m = new AtomicBoolean(false);
        this.f9783n = new AtomicBoolean(false);
        this.f9784o = new AtomicBoolean(false);
    }

    public static ca a() {
        return cb.f9788a;
    }

    private long b(long j) {
        return (j + n()) / 1000;
    }

    public static String f() {
        return kq.a().c("jversion_name", "");
    }

    public static String g() {
        return kq.a().c("regId", "");
    }

    public static String h() {
        return kq.a().c(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD, "");
    }

    public static String i() {
        return kq.a().c(com.heytap.mcssdk.constant.b.f14307z, "");
    }

    public static long j() {
        return kq.a().b("rtime", 0L);
    }

    private long m() {
        synchronized (this.f9777g) {
            try {
                long j = this.f9776f.get();
                if (j > 0) {
                    return j;
                }
                a(this.f9778h, 3124);
                try {
                    String string = jg.a().getSharedPreferences("cn.jiguang.sdk.user.profile", 0).getString("key_uid_e", "");
                    if (TextUtils.isEmpty(string)) {
                        a(this.f9779i, 3125);
                    } else {
                        String strB = km.b(string, "DFA84B10B7ACDD25");
                        if (TextUtils.isEmpty(strB)) {
                            a(this.j, 3126);
                        } else {
                            long j8 = Long.parseLong(strB);
                            if (j8 > 0) {
                                this.f9776f.set(j8);
                                a(this.f9781l, 3128);
                                try {
                                    kq kqVarA = kq.a();
                                    kqVarA.a("uid", j8);
                                    if (kqVarA.b("uid", 0L) != j8) {
                                        a(this.f9783n, 3130);
                                    }
                                } catch (Throwable unused) {
                                    a(this.f9783n, 3130);
                                }
                                return j8;
                            }
                            a(this.f9780k, 3127);
                        }
                    }
                    return 0L;
                } catch (Throwable unused2) {
                    a(this.f9782m, 3129);
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private long n() {
        if (this.f9785p != 0 && this.f9786q != 0) {
            return this.f9785p - this.f9786q;
        }
        kq kqVarA = kq.a();
        long jB = kqVarA.b("serverTime", 0L);
        long jB2 = kqVarA.b("loginTime", 0L);
        if (jB2 == 0 || jB == 0) {
            return 0L;
        }
        this.f9785p = jB;
        this.f9786q = jB2;
        return jB - jB2;
    }

    public final boolean c() {
        return this.f9773c.get();
    }

    public final boolean d() {
        return this.f9774d.get();
    }

    public final long e() {
        long j = this.f9776f.get();
        if (j > 0) {
            return j;
        }
        try {
            long jB = kq.a().b("uid", 0L);
            if (jB > 0) {
                this.f9776f.compareAndSet(0L, jB);
                return this.f9776f.get();
            }
        } catch (Throwable unused) {
            a(this.f9784o, 3131);
        }
        return m();
    }

    public final long k() {
        return b(System.currentTimeMillis());
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f9787r)) {
            return this.f9787r;
        }
        try {
            if (!bj.a().b()) {
                return "";
            }
            String str = (String) JPushConstants.class.getField("SDK_VERSION_NAME").get(null);
            if (str == null) {
                str = "";
            }
            this.f9787r = str;
            return this.f9787r;
        } catch (Throwable unused) {
            this.f9787r = "";
            return "";
        }
    }

    public /* synthetic */ ca(byte b9) {
        this();
    }

    public static String a(long j) {
        try {
            return Base64.encodeToString(String.valueOf(j).getBytes("UTF-8"), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final boolean b() {
        return this.f9771a.get();
    }

    public final void a(Bundle bundle) {
        ey eyVarB;
        int i9;
        if (bundle == null) {
            return;
        }
        ee.a("SDKStateManager", "updateConfig: " + bundle.toString());
        if (bundle.containsKey("uid")) {
            try {
                long j = bundle.getLong("uid");
                if (j > 0) {
                    try {
                        synchronized (this.f9777g) {
                            try {
                                kq kqVarA = kq.a();
                                kqVarA.a("uid", j);
                                if (kqVarA.b("uid", 0L) == j) {
                                    this.f9776f.set(j);
                                    eyVarB = ey.b();
                                    i9 = 3098;
                                } else {
                                    eyVarB = ey.b();
                                    i9 = 3117;
                                }
                                eyVarB.n(i9);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        ey.b().n(3116);
                        ee.d("SDKStateManager", "save uid err: " + th2.getMessage());
                    }
                } else {
                    ey.b().n(3099);
                }
            } catch (Throwable th3) {
                ey.b().n(3115);
                defpackage.f.n(th3, new StringBuilder("read uid from bundle err: "), "SDKStateManager");
            }
        }
        if (bundle.containsKey("regId")) {
            try {
                kq.a().a("regId", bundle.getString("regId"));
            } catch (Throwable unused) {
            }
        }
        if (bundle.containsKey("KEY_PLATFORM_TYPE")) {
            try {
                this.f9775e.set(Byte.valueOf(bundle.getByte("KEY_PLATFORM_TYPE")));
            } catch (Throwable unused2) {
            }
        }
        if (bundle.containsKey("KEY_PLATFORM_REGID")) {
            try {
                kq.a().a("KEY_PLATFORM_REGID", bundle.getString("KEY_PLATFORM_REGID"));
            } catch (Throwable unused3) {
            }
        }
        if (bundle.containsKey("serverTime")) {
            try {
                this.f9774d.set(true);
                kq.a().a("serverTime", bundle.getLong("serverTime"));
                kq.a().a("loginTime", System.currentTimeMillis());
            } catch (Throwable unused4) {
            }
        }
        if (bundle.containsKey(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD)) {
            try {
                kq.a().a(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD, bundle.getString(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD));
            } catch (Throwable unused5) {
            }
        }
        if (bundle.containsKey(com.heytap.mcssdk.constant.b.f14307z)) {
            try {
                kq.a().a(com.heytap.mcssdk.constant.b.f14307z, bundle.getString(com.heytap.mcssdk.constant.b.f14307z));
            } catch (Throwable unused6) {
            }
        }
        if (bundle.containsKey("jversion")) {
            try {
                kq.a().a("jversion", bundle.getInt("jversion"));
            } catch (Throwable unused7) {
            }
        }
        if (bundle.containsKey("jversion_name")) {
            try {
                kq.a().a("jversion_name", bundle.getString("jversion_name"));
            } catch (Throwable unused8) {
            }
        }
        if (bundle.containsKey("jpush_version")) {
            try {
                kq.a().a("jpush_version", bundle.getString("jpush_version"));
            } catch (Throwable unused9) {
            }
        }
        if (bundle.containsKey("isForeground")) {
            try {
                this.f9771a.set(bundle.getBoolean("isForeground"));
            } catch (Throwable unused10) {
            }
        }
        if (bundle.containsKey("connected")) {
            try {
                this.f9772b.set(bundle.getBoolean("connected"));
            } catch (Throwable unused11) {
            }
        }
        if (bundle.containsKey("KEY_CHANNEL")) {
            try {
                kq.a().a("KEY_CHANNEL", bundle.getString("KEY_CHANNEL"));
            } catch (Throwable unused12) {
            }
        }
        if (bundle.containsKey("auth")) {
            try {
                this.f9773c.set(bundle.getBoolean("auth"));
            } catch (Throwable unused13) {
            }
        }
        if (bundle.containsKey("init_state")) {
            try {
                kq.a().a("init_state", bundle.getInt("init_state", -1));
            } catch (Throwable unused14) {
            }
        }
    }

    public static void a(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        cn.jiguang.commons.j.m.b(bundle2);
    }

    private static void a(AtomicBoolean atomicBoolean, int i9) {
        if (atomicBoolean.compareAndSet(false, true)) {
            ey.b().n(Integer.valueOf(i9));
        }
    }

    public final void a(JSONObject jSONObject, String str) {
        String str2;
        long jCurrentTimeMillis;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("type", str);
            if (TextUtils.equals(str, "app_list")) {
                str2 = "it";
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                str2 = "itime";
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            jSONObject.put(str2, b(jCurrentTimeMillis));
            ee.a("SDKStateManager", "report:" + str + ",keys=" + jSONObject.length());
            cn.jiguang.commons.j.m.e(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, long j, String str2, long j8) {
        return j == j8 && !TextUtils.isEmpty(str) && str.equals(str2);
    }
}
