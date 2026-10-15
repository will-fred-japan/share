package p061i1;

import android.app.Activity;
import android.os.Bundle;
import org.json.JSONObject;
import p167v3.b;
import p167v3.f;
import p175w3.a;

/* JADX INFO: compiled from: BaseApmWidget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements f, a, b, r2.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f19253a;

    @Override // p167v3.b
    public final void c(Activity activity) {
    }

    @Override // p175w3.a
    public void onRefresh(JSONObject jSONObject, boolean z8) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optJSONObject("allow_log_type");
            jSONObjectOptJSONObject.optJSONObject("allow_metric_type");
            this.f19253a = jSONObjectOptJSONObject.optJSONObject("allow_service_name");
        }
    }

    @Override // p167v3.b
    /* JADX INFO: renamed from: c */
    public void mo848c() {
    }

    public void onReady() {
    }

    @Override // r2.b.d
    public final void b(long j) {
    }

    @Override // p167v3.b
    public final void e(Bundle bundle) {
    }

    @Override // p167v3.b
    public final void onActivityStarted(Activity activity) {
    }
}
