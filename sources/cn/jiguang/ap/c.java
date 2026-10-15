package cn.jiguang.ap;

import W5.e;
import android.content.Context;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends cn.jiguang.an.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9368a;

    public c(Context context, String str) {
        super(context, str);
    }

    @Override // cn.jiguang.an.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HianalyticsBaseData.SDK_TYPE, this.f9368a);
            jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, 1);
            return jSONObject;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("build getExtraJson data failed, "), "ExceptMonitor");
            return jSONObject;
        }
    }

    @Override // cn.jiguang.an.a
    public JSONObject b() {
        return super.b();
    }

    @Override // cn.jiguang.an.a
    public String c() {
        return super.c();
    }

    public void a(String str) {
        this.f9368a = str;
    }
}
