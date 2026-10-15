package cn.jiguang.commons.a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.starburst.sdk.core.tts.EventType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class fy extends AbstractC0552a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10081a = jr.a(new byte[]{81, 78, 125, 122, 121, 120, 84, 14, 112, 102, 98, 116, 94, 84, 55, 105, 117, 101, 89, 79, 119, 38, 70, 80, 115, 107, 88, 79, 83, 78, 113, EventType.ERROR, 93, 77, 82});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10082b = jr.a(new byte[]{120, 102, 114, 99, 95, 73, 125, 38, 127, 127, 68, 69, 119, 124, 56, 112, 83, 84, 112, 103, 120, Utf8.REPLACEMENT_BYTE, 96, 97, 90, 67, 87, 86, 117, 127, 75, 77, 91, 94, 102, 101, 93});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<BroadcastReceiver> f10083c = new AtomicReference<>();

    public static fy b() {
        return gb.f10092a;
    }

    private fz e() {
        return new fz(this);
    }

    private w f(String str) {
        w wVarC;
        try {
            List<w> listH = h();
            if (listH != null && !listH.isEmpty()) {
                Iterator<w> it = listH.iterator();
                do {
                    if (!it.hasNext()) {
                        wVarC = null;
                        break;
                    }
                    wVarC = it.next();
                } while (!str.equals(wVarC.f10422b));
            } else {
                wVarC = null;
                break;
            }
            if (wVarC == null) {
                wVarC = g(str);
            }
            if (wVarC == null) {
                wVarC = iz.c(str);
                ee.a("JAppMovement", "created basic app info for removed package:" + str);
            }
            if (!kg.a(wVarC.f10425e)) {
                return wVarC;
            }
            ee.a("JAppMovement", "ignoring system package removal:" + str);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f10081a);
        intentFilter.addAction(f10082b);
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    private static List<w> h() {
        try {
            return bu.a().c(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, false);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("get current app list err:"), "JAppMovement");
            return null;
        }
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JAppMovement";
    }

    public final void c() {
        ee.a("JAppMovement", "app monitoring disabled");
        f();
    }

    public final void d() {
        boolean z8;
        String str;
        if (this.f10083c.get() != null) {
            ee.a("JAppMovement", "app receiver already registered");
            return;
        }
        fz fzVarE = e();
        try {
            AtomicReference<BroadcastReceiver> atomicReference = this.f10083c;
            while (true) {
                if (atomicReference.compareAndSet(null, fzVarE)) {
                    z8 = true;
                    break;
                } else if (atomicReference.get() != null) {
                    z8 = false;
                    break;
                }
            }
            if (z8) {
                kj.a(jg.a(), fzVarE, g(), false);
                str = "app receiver registered ok";
            } else {
                str = "another thread handling registration";
            }
            ee.a("JAppMovement", str);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("register receiver err:"), "JAppMovement");
            this.f10083c.set(null);
            try {
                a(fzVarE);
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            jg.a().unregisterReceiver(broadcastReceiver);
        }
    }

    private static JSONObject b(String str, w wVar, int i9) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("app_name", wVar.f10421a);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, wVar.f10422b);
            jSONObject.put("source", i9);
            jSONObject.put("update_time", wVar.f10430k);
            jSONObject.put("install_time", wVar.j);
            jSONObject.put(HiAnalyticsConstant.BI_KEY_INSTALL_TYPE, wVar.f10425e);
            return jSONObject;
        } catch (Throwable th) {
            ee.e("JAppMovement", "create package event data err:" + th.getMessage());
            return new JSONObject();
        }
    }

    private static w e(String str) {
        try {
            PackageInfo packageInfoA = kg.a(str, false);
            if (packageInfoA == null || kg.b(packageInfoA)) {
                return null;
            }
            return iz.a(packageInfoA, false);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void f() {
        String str;
        try {
            BroadcastReceiver andSet = this.f10083c.getAndSet(null);
            if (andSet == null) {
                str = "app receiver not registered";
            } else {
                a(andSet);
                str = "app receiver unregistered ok";
            }
            ee.a("JAppMovement", str);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("unregister receiver err:"), "JAppMovement");
        }
    }

    private static w g(String str) {
        try {
            List<w> listA = iz.a();
            if (listA == null || listA.isEmpty()) {
                return null;
            }
            for (w wVar : listA) {
                if (str.equals(wVar.f10422b)) {
                    ee.a("JAppMovement", "found app info in backup:" + str);
                    return wVar;
                }
            }
            return null;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("search backup err:"), "JAppMovement");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0078 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:29:0x0064, B:31:0x0071, B:35:0x007c, B:34:0x0078), top: B:45:0x0064, outer: #1 }] */
    public static /* synthetic */ void a(fy fyVar, Intent intent, String str) {
        w wVarE;
        try {
            aa aaVarA = bl.e().a(1101);
            if (aaVarA != null && !bq.a().a(aaVarA)) {
                String schemeSpecificPart = intent.getData() != null ? intent.getData().getSchemeSpecificPart() : null;
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                boolean zEquals = f10081a.equals(str);
                if (!zEquals && !f10082b.equals(str)) {
                    ee.d("JAppMovement", "unknown action:" + str);
                    return;
                }
                String str2 = zEquals ? "addition" : "removal";
                if (zEquals) {
                    try {
                        if (bq.a().a(1105, false)) {
                            wVarE = e(schemeSpecificPart);
                        } else {
                            wVarE = fyVar.f(schemeSpecificPart);
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder("handle package ");
                        sb.append(zEquals ? "addition" : "removal");
                        sb.append(" err:");
                        sb.append(th.getMessage());
                        ee.e("JAppMovement", sb.toString());
                        return;
                    }
                } else {
                    wVarE = fyVar.f(schemeSpecificPart);
                }
                ee.a("JAppMovement", "caching app " + str2 + Constants.COLON_SEPARATOR + wVarE.f10422b);
                fyVar.a(wVarE, zEquals);
                return;
            }
            ee.a("JAppMovement", "data collection disabled for app events");
            fyVar.c();
        } catch (Throwable th2) {
            W5.f.o(th2, new StringBuilder("process package event err:"), "JAppMovement");
        }
    }

    private static List<w> h(String str) {
        try {
            String strB = jq.b(str);
            return TextUtils.isEmpty(strB) ? new ArrayList() : iz.a(strB);
        } catch (Throwable th) {
            ee.e("JAppMovement", "read cache file err:" + th.getMessage());
            return new ArrayList();
        }
    }

    private void a(w wVar, boolean z8) {
        try {
            String str = z8 ? e.f9927e : e.f9928f;
            List<w> listH = h(str);
            listH.add(wVar);
            jq.a(str, iz.a(listH));
            StringBuilder sb = new StringBuilder("saved ");
            sb.append(z8 ? "add" : "remove");
            sb.append(" to cache:");
            sb.append(wVar.f10422b);
            ee.a("JAppMovement", sb.toString());
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("save to cache err:"), "JAppMovement");
        }
    }

    private void a(String str, w wVar, int i9) {
        try {
            ee.a("JAppMovement", "reporting app change:" + str + ", app:" + wVar.f10421a);
            ca.a().a(b(str, wVar, i9), "app_add_rmv");
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("report app change err:"), "JAppMovement");
        }
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        try {
            ee.a("JAppMovement", "start app change detection");
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                List<w> listH = h(e.f9927e);
                List<w> listH2 = h(e.f9928f);
                ee.a("JAppMovement", "broadcast events - adds:" + listH.size() + ", removes:" + listH2.size());
                ArrayList<w> arrayList = new ArrayList();
                ArrayList<w> arrayList2 = new ArrayList();
                List<w> listA = iz.a();
                List<w> listH3 = h();
                StringBuilder sb = new StringBuilder("backup app list size:");
                sb.append(listA == null ? 0 : listA.size());
                ee.a("JAppMovement", sb.toString());
                StringBuilder sb2 = new StringBuilder("current app list size:");
                sb2.append(listH3 == null ? 0 : listH3.size());
                ee.a("JAppMovement", sb2.toString());
                if (listA != null && listH3 != null && !listA.isEmpty() && !listH3.isEmpty()) {
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    Iterator<w> it = listA.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().f10422b);
                    }
                    Iterator<w> it2 = listH3.iterator();
                    while (it2.hasNext()) {
                        hashSet2.add(it2.next().f10422b);
                    }
                    for (w wVar : listH3) {
                        if (!hashSet.contains(wVar.f10422b)) {
                            arrayList.add(wVar);
                        }
                    }
                    for (w wVar2 : listA) {
                        if (!hashSet2.contains(wVar2.f10422b)) {
                            arrayList2.add(wVar2);
                        }
                    }
                }
                ee.a("JAppMovement", "comparison events - adds:" + arrayList.size() + ", removes:" + arrayList2.size());
                if (listH.isEmpty() && listH2.isEmpty() && arrayList.isEmpty() && arrayList2.isEmpty()) {
                    ee.a("JAppMovement", "no app changes detected, skipping");
                    return;
                }
                HashMap map3 = new HashMap();
                HashMap map4 = new HashMap();
                for (w wVar3 : listH) {
                    if (!map2.containsKey(wVar3.f10422b)) {
                        map.put(wVar3.f10422b, wVar3);
                        map3.put(wVar3.f10422b, 0);
                    }
                }
                for (w wVar4 : listH2) {
                    if (!map.containsKey(wVar4.f10422b)) {
                        map2.put(wVar4.f10422b, wVar4);
                        map4.put(wVar4.f10422b, 0);
                    }
                }
                for (w wVar5 : arrayList) {
                    String str = wVar5.f10422b;
                    if (!map.containsKey(str) && !map2.containsKey(str)) {
                        map.put(str, wVar5);
                        map3.put(str, 1);
                    }
                }
                for (w wVar6 : arrayList2) {
                    String str2 = wVar6.f10422b;
                    if (!map.containsKey(str2) && !map2.containsKey(str2)) {
                        map2.put(str2, wVar6);
                        map4.put(str2, 1);
                    }
                }
                ee.a("JAppMovement", "final merged events - adds:" + map.size() + ", removes:" + map2.size());
                ee.a("JAppMovement", "processed app changes:" + map.size() + " adds," + map2.size() + " removes");
                for (w wVar7 : map.values()) {
                    if (wVar7 != null && !kg.a(wVar7.f10425e)) {
                        a("add", wVar7, ((Integer) map3.get(wVar7.f10422b)).intValue());
                    }
                }
                for (w wVar8 : map2.values()) {
                    if (wVar8 != null && !kg.a(wVar8.f10425e)) {
                        a("rmv", wVar8, ((Integer) map4.get(wVar8.f10422b)).intValue());
                    }
                }
                ee.a("JAppMovement", "reported all app changes ok");
                jq.a(e.f9927e);
                jq.a(e.f9928f);
                AbstractC0552a.a("JAppMovement");
            } catch (Throwable th) {
                ee.d("JAppMovement", "movement err:" + th.getMessage());
            }
        } catch (Throwable th2) {
            defpackage.f.n(th2, new StringBuilder("doBusiness movement err:"), "JAppMovement");
        }
    }
}
