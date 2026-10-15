package p024d2;

import org.json.JSONObject;

/* JADX INFO: compiled from: TracingManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p175w3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f18491a;

    public a(b bVar) {
        this.f18491a = bVar;
    }

    @Override // p175w3.a
    public final void onRefresh(JSONObject jSONObject, boolean z8) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("general");
        b bVar = this.f18491a;
        if (jSONObjectOptJSONObject != null) {
            bVar.f18494b = jSONObjectOptJSONObject.optBoolean("enable_apmplus_alog", true);
        } else {
            bVar.f18494b = false;
        }
    }

    @Override // p175w3.a
    public final void onReady() {
    }
}
