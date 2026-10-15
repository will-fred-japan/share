package p142s2;

import A0.h;
import A4.b;
import com.engagelab.privates.core.constants.MTCoreConstants;
import org.json.JSONObject;
import p090m1.a;

/* JADX INFO: compiled from: Apm6.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends h {
    public final JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            a aVar = p061i1.h.f19233e;
            if (aVar != null) {
                jSONObject.put("user_unique_id", aVar.b());
                jSONObject.put("ab_sdk_version", p061i1.h.f19233e.a());
                jSONObject.put("ssid", p061i1.h.f19233e.c());
                jSONObject.put(MTCoreConstants.Register.KEY_USER_ID, p061i1.h.f19233e.getUserId());
                jSONObject.put("device_id", p061i1.h.f19233e.getDid());
                try {
                    jSONObject.put("access", b.a(b.b(p061i1.h.f19229a)));
                    return jSONObject;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return jSONObject;
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
