package p024d2;

import D4.f;
import E4.c;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.h;

/* JADX INFO: compiled from: TracingManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f18492c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18494b;

    static {
        b bVar = new b();
        bVar.f18493a = false;
        bVar.f18494b = true;
        f.a.f1924a.b();
        ((IConfigManager) c.a(IConfigManager.class)).registerConfigListener(new a(bVar));
        f18492c = bVar;
    }

    public final void a(String str) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str) && this.f18493a && this.f18494b) {
                ILog vLog = VLog.getInstance("APMPlus");
                if (vLog != null) {
                    vLog.i("APMPlus", str);
                }
                if (h.f19230b) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException unused) {
                        jSONObject = null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObject != null ? jSONObject.optString("service") : "");
                    sb.append(": ");
                    sb.append(str);
                    Log.d("APMPlus", p199z2.b.f(new String[]{sb.toString()}));
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
