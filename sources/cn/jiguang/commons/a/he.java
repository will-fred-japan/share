package cn.jiguang.commons.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class he extends AbstractC0552a {
    private he() {
    }

    public static he b() {
        return hf.f10145a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JBattery";
    }

    public /* synthetic */ he(byte b9) {
        this();
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        try {
            y yVar = (y) bu.a().a(y.class, 1200, z8);
            if (yVar == null) {
                ee.a("JBattery", "battery info null, skip report");
                return;
            }
            JSONObject jSONObjectA = yVar.a();
            ee.a("JBattery", "battery info collected");
            ca.a().a(jSONObjectA, "battery");
            AbstractC0552a.a("JBattery");
        } catch (Throwable th) {
            ee.d("JBattery", "battery err:" + th.getMessage());
        }
    }
}
