package cn.jiguang.commons.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class az implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!ax.e()) {
                ee.a("ActiveConfigManager", "Cannot request config");
                return;
            }
            String strI = ax.i();
            long unused = ax.f9697f = System.currentTimeMillis();
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            em.a("ActiveConfigManager");
            JSONObject jSONObjectD = ax.d(strI);
            if (jSONObjectD != null) {
                String strOptString = jSONObjectD.optString("af", "");
                String unused2 = ax.f9696e = jSONObjectD.optString("sign", "");
                int unused3 = ax.f9694c = jSONObjectD.optInt("al_idx", 0);
                long unused4 = ax.f9699h = jSONObjectD.optLong("req_gap", 43200L);
                long unused5 = ax.f9700i = jSONObjectD.optLong("t_interval", 172800L);
                ax.g();
                if (TextUtils.isEmpty(strOptString) || "null".equalsIgnoreCase(strOptString)) {
                    return;
                }
                jq.a(defpackage.f.b(ax.f9694c, "afm_", ".cache"), "al", km.a(strOptString, f.f10031c));
                ax.a("al", true);
            }
        } catch (Throwable unused6) {
        }
    }
}
