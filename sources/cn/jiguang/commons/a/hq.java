package cn.jiguang.commons.a;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.text.TextUtils;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class hq extends AbstractC0552a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<BroadcastReceiver> f10158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f10159b;

    private hq() {
        this.f10158a = new AtomicReference<>();
        this.f10159b = new AtomicBoolean(false);
    }

    public static hq b() {
        return ht.f10163a;
    }

    private hr e() {
        return new hr(this);
    }

    private void f() {
        String str;
        try {
            BroadcastReceiver andSet = this.f10158a.getAndSet(null);
            if (andSet == null) {
                str = "screen receiver not registered";
            } else {
                a(andSet);
                str = "screen receiver unregistered success";
            }
            ee.a("JDeviceScreen", str);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("unregister screen receiver error: "), "JDeviceScreen");
        }
    }

    private static IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        return intentFilter;
    }

    private static boolean h() {
        try {
            aa aaVarA = bl.e().a(2900);
            if (aaVarA == null) {
                return false;
            }
            long jD = AbstractC0552a.d("JDeviceScreen");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jD2 = aaVarA.d();
            long jAbs = Math.abs(jCurrentTimeMillis - jD);
            long j = jAbs / 1000;
            long j8 = jD2 / 1000;
            boolean z8 = jAbs >= jD2;
            ee.a("JDeviceScreen", "report interval check: elapsed:" + j + "s, limit:" + j8 + "s, result:" + z8);
            return z8;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("check report interval error: "), "JDeviceScreen");
            return false;
        }
    }

    private static String i() {
        try {
            String strB = bu.a().b(INotificationPermissionCallback.CODE_FREQUENT, false);
            String strB2 = bu.a().b(1900, false);
            String strB3 = bu.a().b(1901, false);
            if (TextUtils.isEmpty(strB) && TextUtils.isEmpty(strB2) && TextUtils.isEmpty(strB3)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(strB)) {
                strB = "";
            }
            sb.append(strB);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            if (TextUtils.isEmpty(strB2)) {
                strB2 = "";
            }
            sb.append(strB2);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            if (TextUtils.isEmpty(strB3)) {
                strB3 = "";
            }
            sb.append(strB3);
            return sb.toString();
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get device id error: "), "JDeviceScreen");
            return "";
        }
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JDeviceScreen";
    }

    public final void c() {
        ee.a("JDeviceScreen", "screen monitoring disabled");
        f();
    }

    public final void d() {
        boolean z8;
        String str;
        if (this.f10158a.get() != null) {
            ee.a("JDeviceScreen", "screen receiver already registered");
            return;
        }
        hr hrVarE = e();
        try {
            AtomicReference<BroadcastReceiver> atomicReference = this.f10158a;
            while (true) {
                if (atomicReference.compareAndSet(null, hrVarE)) {
                    z8 = true;
                    break;
                } else if (atomicReference.get() != null) {
                    z8 = false;
                    break;
                }
            }
            if (z8) {
                kj.a(jg.a(), hrVarE, g(), jg.a().getPackageName() + ".permission.JPUSH_MESSAGE", null, false);
                str = "screen receiver registered success";
            } else {
                str = "another thread handling registration";
            }
            ee.a("JDeviceScreen", str);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("register screen receiver error: "), "JDeviceScreen");
            this.f10158a.set(null);
            try {
                a(hrVarE);
            } catch (Throwable unused) {
            }
        }
    }

    public /* synthetic */ hq(byte b9) {
        this();
    }

    private static void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            jg.a().unregisterReceiver(broadcastReceiver);
        }
    }

    private void e(String str) {
        try {
            if (!this.f10159b.get() && !TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("\\|");
                if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1]) || !this.f10159b.compareAndSet(false, true)) {
                    return;
                }
                ee.b("JDevice", "dev_rpt_state|1900_v3=ok");
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("check oa state error: "), "JDeviceScreen");
        }
    }

    public static /* synthetic */ void a(hq hqVar, String str) {
        try {
            aa aaVarA = bl.e().a(2900);
            if (aaVarA == null || bq.a().a(aaVarA)) {
                ee.a("JDeviceScreen", "data collection disabled for screen events");
                hqVar.c();
                return;
            }
            try {
                if (!h()) {
                    ee.a("JDeviceScreen", "skip screen event report due to interval");
                    return;
                }
                AbstractC0552a.c("JDeviceScreen");
                Context contextA = jg.a();
                PowerManager powerManager = (PowerManager) contextA.getSystemService("power");
                KeyguardManager keyguardManager = (KeyguardManager) contextA.getSystemService("keyguard");
                boolean zIsScreenOn = powerManager.isScreenOn();
                boolean zInKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
                int i9 = 1;
                boolean z8 = zIsScreenOn && !zInKeyguardRestrictedInputMode;
                ee.a("JDeviceScreen", "screen state - on: " + zIsScreenOn + ", locked: " + zInKeyguardRestrictedInputMode);
                String strI = i();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", z8);
                if (!zIsScreenOn || zInKeyguardRestrictedInputMode) {
                    i9 = (zIsScreenOn && zInKeyguardRestrictedInputMode) ? 2 : 3;
                }
                jSONObject.put("state", i9);
                jSONObject.put("dev_id", strI);
                ee.a("JDeviceScreen", "screen report success");
                ca.a().a(jSONObject, "sc_status");
                StringBuilder sb = new StringBuilder("screen event reported: ");
                sb.append(str);
                sb.append(", status: ");
                sb.append(z8 ? "unlock" : "lock");
                ee.a("JDeviceScreen", sb.toString());
                hqVar.e(strI);
            } catch (Throwable th) {
                ee.d("JDeviceScreen", "screen err:" + th.getMessage());
            }
        } catch (Throwable th2) {
            W5.f.o(th2, new StringBuilder("process screen event error: "), "JDeviceScreen");
        }
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        try {
            ee.a("JDeviceScreen", "starting doBusiness");
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("doBusiness screen err:"), "JDeviceScreen");
        }
    }
}
