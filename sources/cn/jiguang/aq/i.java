package cn.jiguang.aq;

import android.content.Context;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends cn.jiguang.an.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9378e;

    public i(Context context) {
        super(context, "NET_DATA");
    }

    @Override // cn.jiguang.an.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RemoteMessageConst.Notification.URL, this.f9378e);
            jSONObject.put("res", this.f9376c);
            jSONObject.put(HiAnalyticsConstant.Direction.REQUEST, this.f9375b);
            jSONObject.put("type", this.f9374a);
            jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, this.f9377d);
            return jSONObject;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("build getExtraJson data failed, "), "NetDataLengthMonitor");
            return jSONObject;
        }
    }

    public void b(long j) {
        this.f9375b = j;
    }

    public void c(long j) {
        this.f9377d = j;
    }

    public void b(String str) {
        this.f9374a = str;
    }

    public void a(long j) {
        this.f9376c = j;
    }

    public void a(String str) {
        this.f9378e = str;
    }
}
