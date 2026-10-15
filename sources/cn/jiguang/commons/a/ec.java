package cn.jiguang.commons.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ec implements eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f9938a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JSONObject f9939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f9940c;

    public ec() {
        int size = bf.b(1).size();
        int size2 = bf.b(2).size();
        int size3 = bf.b(3).size();
        int size4 = bf.b(4).size();
        int iA = bf.a();
        Log.d("JMback", "3rHevd6e3qbest6H36Hept6y3rnfod643rLevd6C3qnest+i3rzeu96a3rrehd+h3p7eud6K3qneit6H3qjevN6J3ojent683pzeh96Z3qjend6E3pXevd6J3qregt673p7el96V3qfeid+i3oXevd6D3pXeht6S3oLek96J3r3end663pHeqd6e3rnfoN6n3p/eg9+g3qjent653pHeqN6e3pTev9+h3p7elN6/3qnend6n363frQ==");
        ee.a("ICommonImpl", "icommonimpl total data items=" + iA + " (static=" + size + ", bulk=" + size2 + ", dynamic=" + size3 + ", realtime=" + size4 + ")");
    }

    private static Object a() {
        try {
            ca.a();
            ca.a((Bundle) null, "s_c");
            ee.a("ICommonImpl", "s ctrl success");
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("s ctrl failed: "), "ICommonImpl", th);
            return null;
        }
    }

    private Object c() {
        ee.a("ICommonImpl", "handling cmd_init - requesting config");
        try {
            if (f9938a.get()) {
                ee.a("ICommonImpl", "already initialized, skipping cmd_init");
                return 0;
            }
            f9938a.set(true);
            bl.e().a((be) new ed(this));
            ee.a("ICommonImpl", "initialization complete");
            return 0;
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("error during initialization:"), "ICommonImpl");
            return null;
        }
    }

    private static Object d() {
        ee.a("ICommonImpl", "handling cmd_on_register");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            kq.a().a("rtime", jCurrentTimeMillis);
            ee.a("ICommonImpl", "registration time recorded:" + jCurrentTimeMillis);
            return 0;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("error during registration:"), "ICommonImpl", th);
            return null;
        }
    }

    private Object e() {
        ee.a("ICommonImpl", "handling cmd_on_login - starting heartbeat");
        try {
            b(TCPTimingCache.P_LOGIN);
            ew.a();
            return 0;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("error during login:"), "ICommonImpl", th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    private static Bundle f(Object[] objArr) {
        boolean zBooleanValue;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Boolean) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                } else {
                    zBooleanValue = false;
                }
            } catch (Throwable th) {
                W5.f.p(th, new StringBuilder("get loc error:"), "ICommonImpl", th);
                return null;
            }
        } else {
            zBooleanValue = false;
        }
        ab abVarE = zBooleanValue ? (ab) bu.a().a(ab.class, 1502, zBooleanValue) : jw.a().e();
        StringBuilder sb = new StringBuilder("get loc:isA=");
        sb.append(zBooleanValue);
        sb.append(",result=");
        sb.append(abVarE != null);
        ee.a("ICommonImpl", sb.toString());
        if (abVarE == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(CrashHianalyticsData.TIME, abVarE.f9600a);
        bundle.putDouble("lat", abVarE.f9603d);
        bundle.putDouble("lot", abVarE.f9604e);
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    private static PackageInfo g(Object[] objArr) {
        int iIntValue;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    boolean zBooleanValue = false;
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (TextUtils.isEmpty(str)) {
                            return null;
                        }
                        boolean zA = kg.a(str);
                        if (!f9938a.get() && !zA) {
                            return null;
                        }
                        if (objArr.length > 1) {
                            Object obj2 = objArr[1];
                            if (obj2 instanceof Integer) {
                                iIntValue = ((Integer) obj2).intValue();
                            } else {
                                iIntValue = 0;
                            }
                        } else {
                            iIntValue = 0;
                        }
                        if (objArr.length > 2) {
                            Object obj3 = objArr[2];
                            if (obj3 instanceof Boolean) {
                                zBooleanValue = ((Boolean) obj3).booleanValue();
                            }
                        }
                        if (zA || bq.a().a(1105, zBooleanValue)) {
                            return kg.a(str, zBooleanValue, iIntValue);
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                W5.f.p(th, new StringBuilder("get pkg info error:"), "ICommonImpl", th);
            }
        }
        return null;
    }

    private static Object h(Object... objArr) {
        try {
            Object obj = objArr[0];
            if (obj instanceof Map) {
                Map<Integer, Boolean> map = (Map) obj;
                if (map.isEmpty()) {
                    return null;
                }
                ee.a("ICommonImpl", "rd: map " + map);
                return bu.a().a(map);
            }
            if (obj instanceof Set) {
                Set<Integer> set = (Set) obj;
                if (set.isEmpty()) {
                    return null;
                }
                ee.a("ICommonImpl", "rd: set " + set);
                return bu.a().a(set);
            }
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (objArr.length > 1) {
                    Object obj2 = objArr[1];
                    if (obj2 instanceof Boolean) {
                        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                        ee.a("ICommonImpl", "rd: " + num + ", cmd:" + zBooleanValue);
                        return bu.a().a(num.intValue(), zBooleanValue);
                    }
                }
                ee.a("ICommonImpl", "rd: " + num);
                return bu.a().a(num.intValue());
            }
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("error during data retrieval:"), "ICommonImpl", th);
        }
    }

    private static Object b(Bundle bundle) {
        try {
            String string = bundle.getString("ds");
            if (TextUtils.isEmpty(string)) {
                ee.d("ICommonImpl", "s report params empty");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", string);
            ca.a().a(jSONObject, "xlog");
            ee.a("ICommonImpl", "s report success");
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("s report failed: "), "ICommonImpl", th);
            return null;
        }
    }

    private Object c(Bundle bundle) {
        try {
            String string = bundle.getString("m");
            String string2 = bundle.getString("u");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                return ev.a(string, string2, a(bundle.getString("h")), bundle.getByteArray("b"));
            }
            ee.d("ICommonImpl", "s https params invalid");
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("s https failed: "), "ICommonImpl", th);
            return null;
        }
    }

    private static Object d(Bundle bundle) {
        try {
            String string = bundle.getString("ds");
            if (TextUtils.isEmpty(string)) {
                ee.d("ICommonImpl", "s cd params empty");
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            ca.a();
            ca.a((Bundle) null, "s_c");
            fm.a().a(86, jSONObject);
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("s cd failed: "), "ICommonImpl", th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    private static List<String> e(Object[] objArr) {
        boolean zBooleanValue;
        int iIntValue;
        String str;
        int i9 = 0;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Boolean) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                } else {
                    zBooleanValue = false;
                }
            } catch (Throwable th) {
                W5.f.p(th, new StringBuilder("get wf error:"), "ICommonImpl", th);
                return null;
            }
        } else {
            zBooleanValue = false;
        }
        if (objArr == null || objArr.length <= 1) {
            iIntValue = 10;
        } else {
            Object obj2 = objArr[1];
            if (obj2 instanceof Integer) {
                iIntValue = ((Integer) obj2).intValue();
            } else {
                iIntValue = 10;
            }
        }
        ArrayList arrayList = new ArrayList();
        List<ac> listA = ib.a(zBooleanValue);
        if (!listA.isEmpty()) {
            for (ac acVar : listA) {
                if (acVar != null && (str = acVar.f9611b) != null) {
                    if (i9 >= iIntValue) {
                        break;
                    }
                    if (!arrayList.contains(str)) {
                        i9++;
                        arrayList.add(acVar.f9611b);
                    }
                }
            }
        }
        return arrayList;
    }

    private static Object f(Bundle bundle) {
        try {
            JSONObject jSONObjectA = aw.a(bundle);
            if (jSONObjectA == null) {
                return null;
            }
            fm.a().a(jSONObjectA.optInt(MTCoreConstants.Protocol.KEY_CMD), jSONObjectA);
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("handle cmd error:"), "ICommonImpl", th);
            return null;
        }
    }

    private Object g(Bundle bundle) {
        ee.a("ICommonImpl", "handling cmd_sync_config");
        if (bundle != null) {
            try {
                if (bundle.containsKey("connected")) {
                    try {
                        boolean z8 = bundle.getBoolean("connected");
                        cc ccVarA = cc.a();
                        if (!z8) {
                            c("disconnection");
                        } else if (ccVarA.d() || !ca.a().d()) {
                            ee.a("ICommonImpl", "data collection scheduler not started - already running or user not logged in");
                        } else {
                            b("connection");
                        }
                    } catch (Throwable th) {
                        ee.b("ICommonImpl", "failed to handle connection state:" + th.getMessage(), th);
                    }
                }
            } catch (Throwable th2) {
                W5.f.p(th2, new StringBuilder("error during config sync:"), "ICommonImpl", th2);
                return null;
            }
        }
        bn.a().a(bundle);
        return 0;
    }

    @Override // cn.jiguang.commons.a.eb
    public final Object a(Context context, int i9, String str, Bundle bundle, Object... objArr) {
        String str2;
        int i10;
        try {
            Context contextA = jg.a(context);
            if (contextA == null) {
                ee.d("ICommonImpl", "app context is null, must send context in onEvent!!!!!");
                ee.d("ICommonImpl", Constants.COLON_SEPARATOR + i9 + ", action:" + str);
                return null;
            }
            ee.a("ICommonImpl", "processing command:" + i9 + ", action:" + str);
            if (i9 == 12) {
                ey eyVarB = ey.b();
                if (bundle == null || !bundle.containsKey("uid")) {
                    i10 = 3118;
                } else {
                    try {
                        eyVarB.n(Integer.valueOf(bundle.getLong("uid") > 0 ? 3120 : 3119));
                    } catch (Throwable unused) {
                        i10 = 3121;
                        eyVarB.n(i10);
                    }
                }
                eyVarB.n(i10);
            }
            ca.a().a(bundle);
            if (e(bundle)) {
                ew.c();
            }
            switch (i9) {
                case 10:
                    return c();
                case 11:
                    return g(bundle);
                case 12:
                    return d();
                case 13:
                    return e();
                case 14:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 26:
                case 27:
                    if (f9938a.get()) {
                        if (i9 == 14) {
                            return h(objArr);
                        }
                        if (i9 == 24) {
                            return c(objArr);
                        }
                        if (i9 == 26) {
                            return a(bundle);
                        }
                        if (i9 == 27) {
                            return b(objArr);
                        }
                        switch (i9) {
                            case 18:
                                return a(objArr);
                            case 19:
                                return f(objArr);
                            case 20:
                                return b();
                            case 21:
                                return d(objArr);
                            case 22:
                                return e(objArr);
                        }
                    }
                    str2 = "sdk not initialized, cmd=" + i9;
                    ee.d("ICommonImpl", str2);
                    return null;
                case 15:
                    if (bundle != null) {
                        bundle.size();
                    }
                    return null;
                case 16:
                    return f(bundle);
                case 17:
                    return g(objArr);
                case 23:
                    fe.a().a(new A(contextA, 0), fl.NETWORK);
                    return null;
                case 25:
                    TextUtils.isEmpty(str);
                    return null;
                default:
                    str2 = "unknown command:" + i9;
                    ee.d("ICommonImpl", str2);
                    return null;
            }
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("onEvent error:"), "ICommonImpl", th);
            return null;
        }
    }

    private static Object b(Object[] objArr) {
        boolean zBooleanValue = false;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Boolean) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                    }
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        y yVar = (y) bu.a().a(y.class, 1200, zBooleanValue);
        if (yVar != null) {
            return yVar.b();
        }
        return null;
    }

    private List<String> b() {
        String str;
        try {
            List<String> list = this.f9940c;
            if (list == null || list.isEmpty()) {
                this.f9940c = new ArrayList();
                List<w> listC = bu.a().c(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, false);
                if (listC != null && !listC.isEmpty()) {
                    for (w wVar : listC) {
                        if (wVar != null && (str = wVar.f10422b) != null) {
                            this.f9940c.add(str);
                        }
                    }
                }
            }
            return this.f9940c;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("get ap error:"), "ICommonImpl", th);
            return null;
        }
    }

    private Object a(Bundle bundle) {
        if (bundle == null) {
            ee.d("ICommonImpl", "so bundle is null");
            return null;
        }
        try {
            int i9 = bundle.getInt("sm", -1);
            if (i9 == 1) {
                return b(bundle);
            }
            if (i9 == 2) {
                return c(bundle);
            }
            if (i9 == 3) {
                return d(bundle);
            }
            if (i9 == 4) {
                return a();
            }
            ee.d("ICommonImpl", "unknown so method: " + i9);
            return null;
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("s handle error: "), "ICommonImpl", th);
            return null;
        }
    }

    private static JSONObject c(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                try {
                    aa aaVarA = bl.e().a(((Integer) obj).intValue());
                    if (aaVarA != null) {
                        return aaVarA.j();
                    }
                } catch (Throwable th) {
                    W5.f.p(th, new StringBuilder("getConfig error:"), "ICommonImpl", th);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    private static JSONObject d(Object[] objArr) {
        boolean zBooleanValue;
        String strA;
        JSONObject jSONObject = f9939b;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f9939b;
        }
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Boolean) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                } else {
                    zBooleanValue = false;
                }
                if (bq.a().a(1000, zBooleanValue) || (strA = hg.b().a(zBooleanValue, false)) == null) {
                    return null;
                }
                f9939b = new JSONObject(strA);
            } catch (Throwable th) {
                W5.f.p(th, new StringBuilder("getDeviceInfo error:"), "ICommonImpl", th);
            }
        } else {
            zBooleanValue = false;
            if (bq.a().a(1000, zBooleanValue)) {
                return null;
            }
            f9939b = new JSONObject(strA);
        }
        return f9939b;
    }

    private static boolean e(Bundle bundle) {
        if (bundle != null && bundle.containsKey("uid")) {
            try {
                long j = bundle.getLong("uid");
                if (j > 0 && ca.a().e() == j) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void b(String str) {
        String str2;
        try {
            cc ccVarA = cc.a();
            if (ccVarA.d()) {
                str2 = "data collection scheduler already running after " + str;
            } else {
                ccVarA.b();
                str2 = "data collection scheduler started due to " + str;
            }
            ee.a("ICommonImpl", str2);
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("failed to start data collection scheduler:"), "ICommonImpl", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    /* JADX WARN: Code duplicated, block: B:23:0x003c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0050  */
    /* JADX WARN: Code duplicated, block: B:39:0x0064  */
    /* JADX WARN: Code duplicated, block: B:47:0x0078  */
    private static Object a(Object[] objArr) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Integer) {
                        int iIntValue = ((Integer) obj).intValue();
                        int length = objArr.length;
                        if (length > 1) {
                            Object obj2 = objArr[1];
                            if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                        } else {
                            z8 = false;
                        }
                        if (length > 2) {
                            Object obj3 = objArr[2];
                            if ((obj3 instanceof Boolean) && ((Boolean) obj3).booleanValue()) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            z9 = false;
                        }
                        if (length > 3) {
                            Object obj4 = objArr[3];
                            if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        } else {
                            z10 = false;
                        }
                        if (length > 4) {
                            Object obj5 = objArr[4];
                            if ((obj5 instanceof Boolean) && ((Boolean) obj5).booleanValue()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z11 = false;
                        }
                        if (length > 5) {
                            Object obj6 = objArr[5];
                            if ((obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue()) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                        } else {
                            z12 = false;
                        }
                        return bq.a().a(iIntValue, z8, z9, z10, z11, z12);
                    }
                }
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
        ee.d("ICommonImpl", "invalid args for check config with rp enable");
        return Boolean.FALSE;
    }

    private static void c(String str) {
        try {
            cc.a().c();
            ee.a("ICommonImpl", "data collection scheduler stopped due to " + str);
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("failed to stop data collection scheduler:"), "ICommonImpl", th);
        }
    }

    private static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ks.a(new JSONObject(str));
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("parse headers failed: "), "ICommonImpl");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context) {
        if (iy.a(context)) {
            ee.a("ICommonImpl", "handle main process so init");
            ew.b();
        }
    }
}
