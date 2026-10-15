package cn.jiguang.commons.a;

import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class hu extends AbstractC0552a {
    private hu() {
    }

    private static int a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return 0;
        }
        return jSONArrayOptJSONArray.length();
    }

    public static hu b() {
        return hy.f10177a;
    }

    public /* synthetic */ hu(byte b9) {
        this();
    }

    private JSONArray b(List<z> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (z zVar : list) {
                if (zVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    a(jSONObject, "itime", Long.valueOf(ca.a().k()));
                    a(jSONObject, "radio_type", zVar.f10454h);
                    a(jSONObject, "generation", zVar.f10453g);
                    a(jSONObject, "carrier", zVar.f10452f);
                    a(jSONObject, "mobile_country_code", Integer.valueOf(zVar.f10449c));
                    a(jSONObject, "mobile_network_code", Integer.valueOf(zVar.f10450d));
                    a(jSONObject, "signal_strength", Integer.valueOf(zVar.f10455i));
                    a(jSONObject, "cell_id", Long.valueOf(zVar.f10447a));
                    a(jSONObject, "location_area_code", Integer.valueOf(zVar.f10448b));
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("buildCellJsonArray err: "), "JLocation");
        }
        return jSONArray;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JLocation";
    }

    private JSONArray a(ab abVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "itime", Long.valueOf(abVar.f9600a));
            a(jSONObject, "tag", abVar.f9602c);
            a(jSONObject, "lat", Double.valueOf(abVar.f9603d));
            a(jSONObject, "lng", Double.valueOf(abVar.f9604e));
            a(jSONObject, "alt", Double.valueOf(abVar.f9605f));
            a(jSONObject, "bear", Double.valueOf(abVar.f9606g));
            a(jSONObject, "acc", Double.valueOf(abVar.f9607h));
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("buildGpsJsonArray err: "), "JLocation");
            return jSONArray;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0019, B:12:0x0024, B:14:0x002e, B:16:0x0035, B:18:0x003f, B:19:0x0044, B:24:0x007c, B:21:0x004a), top: B:28:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002e A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0019, B:12:0x0024, B:14:0x002e, B:16:0x0035, B:18:0x003f, B:19:0x0044, B:24:0x007c, B:21:0x004a), top: B:28:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0035 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0019, B:12:0x0024, B:14:0x002e, B:16:0x0035, B:18:0x003f, B:19:0x0044, B:24:0x007c, B:21:0x004a), top: B:28:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x003f A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0019, B:12:0x0024, B:14:0x002e, B:16:0x0035, B:18:0x003f, B:19:0x0044, B:24:0x007c, B:21:0x004a), top: B:28:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private JSONObject b(List<ac> list, List<z> list2, ab abVar, boolean z8) {
        JSONArray jSONArrayA;
        JSONArray jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    JSONArray jSONArrayA2 = a(list);
                    if (jSONArrayA2.length() > 0) {
                        jSONObject.put("wifi", jSONArrayA2);
                    }
                }
                if (list2 != null) {
                    jSONArrayB = b(list2);
                    if (jSONArrayB.length() > 0) {
                        jSONObject.put("cell", jSONArrayB);
                    }
                }
                if (abVar != null) {
                    jSONArrayA = a(abVar);
                    if (jSONArrayA.length() > 0) {
                        jSONObject.put("gps", jSONArrayA);
                    }
                }
                if (jSONObject.length() > 0) {
                    try {
                        bu buVarA = bu.a();
                        a(jSONObject, "network_type", buVarA.b(1504, z8));
                        a(jSONObject, "local_dns", buVarA.b(1503, z8));
                        a(jSONObject, "ipv6", buVarA.b(2800, z8));
                        a(jSONObject, "ip2", buVarA.b(2801, z8));
                        return jSONObject;
                    } catch (Throwable th) {
                        ee.d("JLocation", "addNetworkInfo err: " + th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                defpackage.f.n(th2, new StringBuilder("buildCompleteLocationData err: "), "JLocation");
            }
        } else {
            if (list2 != null) {
                jSONArrayB = b(list2);
                if (jSONArrayB.length() > 0) {
                    jSONObject.put("cell", jSONArrayB);
                }
            }
            if (abVar != null) {
                jSONArrayA = a(abVar);
                if (jSONArrayA.length() > 0) {
                    jSONObject.put("gps", jSONArrayA);
                }
            }
            if (jSONObject.length() > 0) {
                bu buVarA2 = bu.a();
                a(jSONObject, "network_type", buVarA2.b(1504, z8));
                a(jSONObject, "local_dns", buVarA2.b(1503, z8));
                a(jSONObject, "ipv6", buVarA2.b(2800, z8));
                a(jSONObject, "ip2", buVarA2.b(2801, z8));
                return jSONObject;
            }
        }
        return jSONObject;
    }

    private JSONArray a(List<ac> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ac acVar : list) {
                if (acVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    a(jSONObject, "itime", Long.valueOf(acVar.f9610a));
                    a(jSONObject, "tag", acVar.f9612c);
                    String str = acVar.f9611b;
                    if (str == null) {
                        str = "<unknown ssid>";
                    }
                    a(jSONObject, "ssid", str);
                    a(jSONObject, "mac_address", acVar.f9614e);
                    a(jSONObject, "signal_strength", Integer.valueOf(acVar.f9613d));
                    a(jSONObject, "age", (Object) 0);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("buildWifiJsonArray err: "), "JLocation");
        }
        return jSONArray;
    }

    private void a(hx hxVar) {
        ey.b().b((Object) 3003);
        hxVar.f10176i = fe.a().a(new hv(this, hxVar), 25000L);
        jw.a().a(hxVar.f10168a, new hw(this, hxVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(hx hxVar, ab abVar, boolean z8) {
        ey eyVarB;
        int iValueOf;
        if (hxVar == null || !hxVar.f10169b.compareAndSet(false, true)) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = hxVar.f10176i;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            hxVar.f10176i.cancel(false);
        }
        if (hxVar.f10172e) {
            if (abVar != null) {
                ey.b().b(Integer.valueOf(BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT));
            } else {
                ey.b().b((Object) 3001);
                if (z8) {
                    ee.d("JLocation", "gps wait timeout, report without gps");
                }
            }
        }
        ee.a("JLocation", "gps: ".concat(abVar != null ? "ok" : "null"));
        if (a(hxVar.f10170c, hxVar.f10171d, abVar, hxVar.f10168a)) {
            eyVarB = ey.b();
            iValueOf = Integer.valueOf(BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT);
        } else {
            eyVarB = ey.b();
            iValueOf = 3001;
        }
        eyVarB.c(iValueOf);
    }

    private void a(JSONObject jSONObject) {
        try {
            ee.a("JLocation", "report loc data,wifi=" + a(jSONObject, "wifi") + ",cell=" + a(jSONObject, "cell") + ",gps=" + a(jSONObject, "gps") + ",slice=" + jSONObject.optInt("wifi_slice_index", 0) + "/" + jSONObject.optInt("wifi_slice_count", 0));
            ca.a().a(jSONObject, "loc_info");
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("reportLocationData err: "), "JLocation");
        }
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!"wifi".equals(next)) {
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("copyNonWifiData err: "), "JLocation");
        }
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        a(z8, false, false, false);
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
            int iOptInt = jSONObject.optInt(MTCoreConstants.Protocol.KEY_CMD);
            if (jSONObjectOptJSONObject != null && iOptInt == 5) {
                int iOptInt2 = jSONObjectOptJSONObject.optInt("en_config", 0);
                boolean z9 = (iOptInt2 & 1) != 0;
                boolean z10 = (iOptInt2 & 2) != 0;
                boolean z11 = (iOptInt2 & 4) != 0;
                ee.a("JLocation", "gps: " + z9 + " cell: " + z10 + " wifi: " + z11);
                a(z8, z9, z10, z11);
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("doBusiness with command err: "), "JLocation");
        }
    }

    private void a(boolean z8, boolean z9, boolean z10, boolean z11) {
        try {
            hx hxVar = new hx(z8);
            if (z8) {
                if (z11) {
                    if (a(1505, "wifi")) {
                        ey.b().e((Object) 3003);
                        hxVar.f10170c = ib.a(z8);
                    } else {
                        hxVar.f10175h = true;
                    }
                }
                if (z9) {
                    if (a(1502, "gps")) {
                        hxVar.f10172e = bq.a().a(1502, true);
                    } else {
                        hxVar.f10173f = true;
                    }
                }
                if (z10) {
                    if (a(1501, "cell")) {
                        ey.b().d((Object) 3003);
                        hz unused = ia.f10180a;
                        hxVar.f10171d = hz.a(z8);
                    } else {
                        hxVar.f10174g = true;
                    }
                }
                if (a(z9, z10, z11, hxVar)) {
                    ey.b().c(Integer.valueOf(MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS));
                    return;
                }
            } else {
                ey.b().e((Object) 3003);
                hxVar.f10170c = ib.a(z8);
                hxVar.f10172e = bq.a().a(1502, false);
                ey.b().d((Object) 3003);
                hz unused2 = ia.f10180a;
                hxVar.f10171d = hz.a(z8);
            }
            StringBuilder sb = new StringBuilder("wifi: ");
            List<ac> list = hxVar.f10170c;
            sb.append(list != null ? list.size() : 0);
            ee.a("JLocation", sb.toString());
            StringBuilder sb2 = new StringBuilder("cell: ");
            List<z> list2 = hxVar.f10171d;
            sb2.append(list2 != null ? list2.size() : 0);
            ee.a("JLocation", sb2.toString());
            if (hxVar.f10172e) {
                a(hxVar);
            } else {
                a(hxVar, (ab) null, false);
            }
        } catch (Throwable th) {
            ee.d("JLocation", "loc err: " + th.getMessage());
            ey.b().c((Object) 3002);
        }
    }

    private static boolean a(int i9, String str) {
        if (bn.a().a(i9)) {
            return true;
        }
        if ("gps".equals(str)) {
            ey.b().b(Integer.valueOf(MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS));
            return false;
        }
        if ("wifi".equals(str)) {
            ey.b().e(Integer.valueOf(MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS));
            return false;
        }
        if (!"cell".equals(str)) {
            return false;
        }
        ey.b().d(Integer.valueOf(MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS));
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0077 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:3:0x0006, B:5:0x0010, B:7:0x0019, B:11:0x0022, B:13:0x002c, B:15:0x0032, B:19:0x0041, B:21:0x004c, B:23:0x0053, B:26:0x007b, B:34:0x00f1, B:33:0x00db, B:25:0x0077, B:28:0x0080, B:30:0x0086), top: B:40:0x0006, inners: #0 }] */
    private boolean a(List<ac> list, List<z> list2, ab abVar, boolean z8) {
        try {
            JSONObject jSONObjectB = b(list, list2, abVar, z8);
            if (jSONObjectB.length() == 0) {
                StringBuilder sb = new StringBuilder("no valid loc data - wifi:");
                sb.append(list != null ? list.size() : 0);
                sb.append(" cell:");
                sb.append(list2 != null ? list2.size() : 0);
                sb.append(" gps:");
                sb.append(abVar != null ? "ok" : "null");
                ee.d("JLocation", sb.toString());
                return false;
            }
            if (jSONObjectB.has("wifi")) {
                ArrayList<JSONArray> arrayListA = ks.a(jSONObjectB.getJSONArray("wifi"));
                ee.a("JLocation", "wifi split: " + arrayListA.size());
                if (arrayListA.size() <= 1) {
                    a(jSONObjectB);
                } else {
                    int size = list.size();
                    int i9 = 0;
                    while (i9 < arrayListA.size()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            a(jSONObjectB, jSONObject);
                            jSONObject.put("wifi", arrayListA.get(i9));
                            int i10 = i9 + 1;
                            jSONObject.put("wifi_slice_index", i10);
                            jSONObject.put("wifi_slice_count", arrayListA.size());
                            jSONObject.put("wifi_total_count", size);
                            a(jSONObject);
                            ee.a("JLocation", String.format("wifi slice: %d/%d, count: %d", Integer.valueOf(i10), Integer.valueOf(arrayListA.size()), Integer.valueOf(arrayListA.get(i9).length())));
                            i9 = i10;
                        } catch (Throwable th) {
                            ee.d("JLocation", "wifi split err: " + th.getMessage());
                        }
                    }
                }
            } else {
                a(jSONObjectB);
            }
            AbstractC0552a.a("JLocation");
            return true;
        } catch (Throwable th2) {
            defpackage.f.n(th2, new StringBuilder("processAndReportLocationData err: "), "JLocation");
            return false;
        }
    }

    private static boolean a(boolean z8, boolean z9, boolean z10, hx hxVar) {
        if (z8 || z9 || z10) {
            return (!z8 || hxVar.f10173f) && (!z9 || hxVar.f10174g) && (!z10 || hxVar.f10175h);
        }
        return false;
    }
}
