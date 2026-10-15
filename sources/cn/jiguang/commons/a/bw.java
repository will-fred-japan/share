package cn.jiguang.commons.a;

import android.net.DhcpInfo;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.C0524s;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f9758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, FutureTask<Object>> f9759b;

    static {
        HashSet hashSet = new HashSet();
        f9758a = hashSet;
        hashSet.add(Integer.valueOf(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH));
        hashSet.add(1110);
        hashSet.add(1502);
        hashSet.add(1501);
        hashSet.add(1505);
        hashSet.add(2801);
        hashSet.add(2800);
        hashSet.add(1601);
        hashSet.add(1608);
        hashSet.add(1602);
        hashSet.add(1615);
        hashSet.add(1900);
        hashSet.add(1901);
    }

    private bw() {
        this.f9759b = new ConcurrentHashMap<>();
    }

    public static bw a() {
        return bz.f9767a;
    }

    private Object b(int i9, boolean z8, Object... objArr) {
        FutureTask futureTask = new FutureTask(new bx(this, i9, z8, objArr));
        FutureTask futureTask2 = (FutureTask) ke.a((ConcurrentHashMap<Integer, V>) this.f9759b, Integer.valueOf(i9), (Callable) new by(this, i9, futureTask));
        if (futureTask2 == futureTask) {
            futureTask2.run();
        }
        try {
            Object obj = futureTask2.get(15L, TimeUnit.SECONDS);
            ee.a("DeviceDataCollector", "cc:ok:" + i9);
            return obj;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            ee.d("DeviceDataCollector", "cc:interrupted:" + i9);
            return null;
        } catch (ExecutionException e9) {
            ee.d("DeviceDataCollector", "cc:err:" + i9 + Constants.COLON_SEPARATOR + e9.getCause().getMessage());
            return null;
        } catch (TimeoutException unused2) {
            ee.d("DeviceDataCollector", "cc:timeout:" + i9);
            futureTask2.cancel(true);
            return null;
        } finally {
            if (futureTask2.isDone()) {
                this.f9759b.remove(Integer.valueOf(i9));
                ee.a("DeviceDataCollector", "cc:removed:" + i9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(int i9, boolean z8, Object... objArr) {
        if (i9 == 1026) {
            return jj.j();
        }
        if (i9 == 1027) {
            return jo.a() ? "1" : "0";
        }
        if (i9 == 1113) {
            return kv.a();
        }
        if (i9 == 1114) {
            return ku.a();
        }
        if (i9 == 1900) {
            return cs.a(z8);
        }
        if (i9 == 1901) {
            return cs.a();
        }
        switch (i9) {
            case 1001:
                return jj.h();
            case 1002:
                return jj.d();
            case MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED /* 1003 */:
            case 1004:
                return "";
            case 1005:
                return jj.g();
            case 1006:
                return "";
            case MTCommonConstants.MainWhat.ON_NETWORK_CHANGED /* 1007 */:
                return jj.f();
            default:
                switch (i9) {
                    case 1009:
                        return jj.n();
                    case JPushCollectControl.IMSI /* 1010 */:
                        String strG = TextUtils.isEmpty(null) ? kw.g() : null;
                        return !ks.c(strG) ? "" : strG;
                    case MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED /* 1011 */:
                        return jj.b();
                    case 1012:
                        return b();
                    case 1013:
                        return jj.a();
                    case MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED /* 1014 */:
                        return jj.e();
                    case MTCommonConstants.MainWhat.ON_ACTIVITY_STOPPED /* 1015 */:
                        return jj.c();
                    case MTCommonConstants.MainWhat.ON_ACTIVITY_DESTROYED /* 1016 */:
                        return "";
                    case MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED /* 1017 */:
                        return jj.i();
                    case 1018:
                        return "";
                    case MTCommonConstants.MainWhat.ON_UPDATE_LOG_CACHE_CONFIG /* 1019 */:
                        return jj.o();
                    case 1020:
                        return jj.l();
                    case 1022:
                        return kt.f();
                    case 1036:
                        return jj.m();
                    case 1040:
                        return jh.a();
                    case MTPushConstants.Message.CODE_CLICK_EVENT_MATCH /* 1100 */:
                        return iz.a(i9, z8, false);
                    case 1102:
                        if (objArr != null && objArr.length > 0) {
                            Object obj = objArr[0];
                            if (obj instanceof Integer) {
                                return ki.a(((Integer) obj).intValue());
                            }
                        }
                        return ki.a(1);
                    case 1110:
                        return iz.a(z8);
                    case 1200:
                        return jb.a();
                    case 1800:
                        return kf.a(jg.a()) ? "1" : "0";
                    case 2001:
                        return jj.k();
                    case INotificationPermissionCallback.CODE_FREQUENT /* 2004 */:
                        return kt.a(0);
                    case INotificationPermissionCallback.CODE_UNSUPPORT /* 2005 */:
                        return kt.b(0);
                    case 2500:
                        return kl.a() ? "1" : "0";
                    case 2800:
                        return hm.b().c();
                    case 2801:
                        return kw.l();
                    default:
                        switch (i9) {
                            case 1029:
                                return jj.s();
                            case 1030:
                                return jj.p();
                            case 1031:
                                return jj.q();
                            case 1032:
                                return jj.r();
                            default:
                                switch (i9) {
                                    case 1501:
                                        return kt.d();
                                    case 1502:
                                        return jw.a().b();
                                    case 1503:
                                        return kw.m();
                                    case 1504:
                                        String strD = jf.d();
                                        return !TextUtils.isEmpty(strD) ? strD.toLowerCase() : strD;
                                    case 1505:
                                        return kw.k();
                                    case 1506:
                                        return kt.b();
                                    case 1507:
                                        return kt.a();
                                    case 1508:
                                        return kw.j();
                                    default:
                                        switch (i9) {
                                            case 1601:
                                                return kw.d();
                                            case 1602:
                                                return kw.h();
                                            case 1603:
                                                try {
                                                    JSONArray jSONArray = new JSONArray();
                                                    DhcpInfo dhcpInfoI = kw.i();
                                                    jSONArray.put(dhcpInfoI != null ? kw.a(dhcpInfoI.dns1) : null);
                                                    DhcpInfo dhcpInfoI2 = kw.i();
                                                    jSONArray.put(dhcpInfoI2 != null ? kw.a(dhcpInfoI2.dns2) : null);
                                                    return jSONArray;
                                                } catch (Throwable unused) {
                                                    return null;
                                                }
                                            case 1604:
                                                DhcpInfo dhcpInfoI3 = kw.i();
                                                if (dhcpInfoI3 != null) {
                                                    return kw.a(dhcpInfoI3.gateway);
                                                }
                                                return null;
                                            case 1605:
                                                DhcpInfo dhcpInfoI4 = kw.i();
                                                return Integer.valueOf(dhcpInfoI4 != null ? dhcpInfoI4.ipAddress : -1);
                                            default:
                                                switch (i9) {
                                                    case 1607:
                                                        DhcpInfo dhcpInfoI5 = kw.i();
                                                        if (dhcpInfoI5 != null) {
                                                            return kw.a(dhcpInfoI5.netmask);
                                                        }
                                                        return null;
                                                    case 1608:
                                                        return kw.c();
                                                    case 1609:
                                                        DhcpInfo dhcpInfoI6 = kw.i();
                                                        if (dhcpInfoI6 != null) {
                                                            return kw.a(dhcpInfoI6.serverAddress);
                                                        }
                                                        return null;
                                                    case 1610:
                                                        return String.valueOf(kw.e());
                                                    case 1611:
                                                        return String.valueOf(kw.f());
                                                    default:
                                                        switch (i9) {
                                                            case 1613:
                                                                return gm.b();
                                                            case 1614:
                                                                return gm.a();
                                                            case 1615:
                                                                return kw.a();
                                                            default:
                                                                ee.a("DeviceDataCollector", "dc:" + i9 + ",not_impl");
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public /* synthetic */ bw(byte b9) {
        this();
    }

    private static String b() {
        try {
            String strB = bv.f9757a.b(INotificationPermissionCallback.CODE_FREQUENT, false);
            return (TextUtils.isEmpty(strB) || strB.trim().length() != 14) ? "" : strB;
        } catch (Throwable unused) {
        }
    }

    public final Object a(int i9, boolean z8, Object... objArr) {
        try {
            if (!bs.f9755a.a(i9, z8)) {
                ee.a("DeviceDataCollector", "dc:" + i9 + ",skip=scd");
                return null;
            }
            if (f9758a.contains(Integer.valueOf(i9))) {
                return b(i9, z8, objArr);
            }
            Object objC = c(i9, z8, objArr);
            ee.a("DeviceDataCollector", "dc:" + i9 + ",v=" + ks.a(objC));
            ap.a().a(i9, objC);
            return objC;
        } catch (Throwable th) {
            W5.f.o(th, C0524s.a(i9, "dc:", ",err="), "DeviceDataCollector");
            return null;
        }
    }
}
