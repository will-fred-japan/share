package cn.jiguang.ao;

import android.content.Context;
import com.engagelab.privates.push.constants.MTPushConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends cn.jiguang.an.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9367a;

    public a(Context context) {
        super(context, "COLD_BOOT_APP");
    }

    @Override // cn.jiguang.an.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, this.f9367a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void a(int i9) {
        this.f9367a = i9;
    }
}
