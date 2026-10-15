package cn.jiguang.commons.a;

import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class gi extends AbstractC0552a {
    private gi() {
    }

    public static gi b() {
        return gj.f10098a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JAppSDK";
    }

    public /* synthetic */ gi(byte b9) {
        this();
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        String str;
        JSONObject jSONObjectE;
        try {
            List<w> listC = bu.a().c(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, z8);
            if (listC == null || listC.isEmpty()) {
                str = "no sdk installed apps found";
            } else {
                JSONArray jSONArray = new JSONArray();
                for (w wVar : listC) {
                    if (wVar.f10426f != 0 && (jSONObjectE = wVar.e(128)) != null) {
                        jSONArray.put(jSONObjectE);
                    }
                }
                if (jSONArray.length() != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", jSONArray);
                    ee.a("JAppSDK", "reporting sdk data ok");
                    ca.a().a(jSONObject, "app_sdk");
                    AbstractC0552a.a("JAppSDK");
                    return;
                }
                str = "no sdk data to report";
            }
            ee.a("JAppSDK", str);
        } catch (Throwable th) {
            ee.d("JAppSDK", "sdk err:" + th.getMessage());
        }
    }
}
