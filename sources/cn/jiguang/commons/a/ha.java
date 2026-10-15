package cn.jiguang.commons.a;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class ha implements gr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gz f10138a;

    public ha(gz gzVar) {
        this.f10138a = gzVar;
    }

    @Override // cn.jiguang.commons.a.gr
    public final void a(k kVar) {
        String str;
        try {
            if (kVar == null) {
                ee.d("JBluetooth", "ble info null");
                return;
            }
            JSONObject jSONObjectA = kVar.a();
            if (jSONObjectA.length() <= 0 || !jSONObjectA.has("pls") || jSONObjectA.getJSONArray("pls").length() <= 0) {
                str = "ble no devices";
            } else {
                ca.a().a(jSONObjectA, "ble_info");
                jq.c(Build.MANUFACTURER + "_ble_info", jSONObjectA.toString());
                gz gzVar = this.f10138a;
                AbstractC0552a.a("JBluetooth");
                str = "ble cl success";
            }
            ee.a("JBluetooth", str);
        } catch (Throwable th) {
            ee.d("JBluetooth", "ble report err:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.commons.a.gr
    public final void a(String str) {
        ee.d("JBluetooth", "ble scan err:" + str);
    }
}
