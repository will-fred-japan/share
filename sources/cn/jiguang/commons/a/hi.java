package cn.jiguang.commons.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class hi extends AbstractC0552a {
    private hi() {
    }

    public static hi b() {
        return hj.f10149a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JDeviceIdMap";
    }

    public /* synthetic */ hi(byte b9) {
        this();
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        try {
            JSONObject jSONObject = new JSONObject();
            String strB = bu.a().b(1030, z8);
            String strB2 = bu.a().b(1031, z8);
            if (TextUtils.isEmpty(strB) && TextUtils.isEmpty(strB2)) {
                ee.a("JDeviceIdMap", "no device id map data to report");
                return;
            }
            jSONObject.put("boot_id", strB);
            jSONObject.put("media_drm_id", strB2);
            ee.a("JDeviceIdMap", "report id map data success");
            ca.a().a(jSONObject, "device_id_map");
            AbstractC0552a.a("JDeviceIdMap");
        } catch (Throwable th) {
            ee.d("JDeviceIdMap", "id map err:" + th.getMessage());
        }
    }
}
