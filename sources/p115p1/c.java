package p115p1;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.g;
import p061i1.h;
import p099n1.d;
import p107o1.b;

/* JADX INFO: compiled from: NetDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p107o1.a<p124q1.a> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f20774p = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile ArrayList f20775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f20776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f20777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f20778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20779i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f20782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedList f20783n = new LinkedList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20784o;

    /* JADX INFO: compiled from: NetDataPipeline.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20785a = new c();
    }

    @Override // p107o1.a
    public final boolean b(b bVar) {
        return !TextUtils.isEmpty(((p124q1.a) bVar).f20879c);
    }

    @Override // p107o1.a
    public final void d(b bVar) {
        boolean zC0;
        p124q1.a aVar = (p124q1.a) bVar;
        if (g.b().a() && this.j) {
            String str = aVar.f20879c;
            if (d.a(h.f19229a) || this.f20779i) {
                boolean z8 = true;
                if ("collect_all".equals(this.f20782m)) {
                    zC0 = true;
                } else if ("allow_list".equals(this.f20782m)) {
                    zC0 = A1.b.c0(str, this.f20777g, this.f20778h);
                } else {
                    zC0 = "block_list".equals(this.f20782m) ? !A1.b.c0(str, this.f20775e, this.f20776f) : false;
                }
                if (zC0) {
                    JSONObject jSONObjectA = aVar.a();
                    A1.b.V(jSONObjectA, aVar.f20883g);
                    if (jSONObjectA == null) {
                        return;
                    }
                    if (jSONObjectA.optInt("data_type") == 3) {
                        z8 = this.f20780k;
                    } else if (!this.f20780k && !this.f20781l) {
                        z8 = false;
                    }
                    if (this.f20783n.size() > 0 && !aVar.f20883g.optBoolean("download", false)) {
                        for (b bVar2 : this.f20783n) {
                            if (bVar2 != null) {
                                bVar2.b(str, aVar.f20883g);
                            }
                        }
                    }
                    if (z8) {
                        try {
                            jSONObjectA.put("is_sample", this.f20780k ? 1 : 0);
                            jSONObjectA.put("filters", p158u2.a.a().b());
                        } catch (Exception unused) {
                        }
                        p107o1.a.a("network", "network", jSONObjectA, z8);
                    }
                }
            }
        }
    }

    @Override // p107o1.a
    public final void f(b bVar) {
        p124q1.a aVar = (p124q1.a) bVar;
        try {
            int i9 = (ActivityLifeObserver.getInstance() == null ? 1 : !ActivityLifeObserver.getInstance().isForeground() ? 1 : 0) ^ 1;
            boolean zIsNull = aVar.f20883g.isNull("front");
            JSONObject jSONObject = aVar.f20883g;
            if (zIsNull) {
                jSONObject.put("front", i9);
            }
            if (jSONObject.isNull("net_consume_type")) {
                jSONObject.put("net_consume_type", "network");
            }
        } catch (JSONException unused) {
        }
    }

    @Override // p107o1.a, p175w3.a
    public final void onRefresh(JSONObject jSONObject, boolean z8) {
        JSONObject jSONObjectOptJSONObject = (jSONObject == null || TextUtils.isEmpty("network_image_modules")) ? null : jSONObject.optJSONObject("network_image_modules");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = TextUtils.isEmpty("network") ? null : jSONObjectOptJSONObject.optJSONObject("network");
            if (jSONObjectOptJSONObject2 != null) {
                this.f20784o = true;
                this.f20779i = jSONObjectOptJSONObject2.optInt("enable_net_monitor_with_net_disable") == 1;
                this.j = jSONObjectOptJSONObject2.optInt("enable_net_monitor") == 1;
                this.f20780k = jSONObjectOptJSONObject2.optInt("enable_success_net_sample") == 1;
                this.f20781l = jSONObjectOptJSONObject2.optInt("ignore_neterror_sampling") == 1;
                String strOptString = jSONObjectOptJSONObject2.optString("filter_info");
                try {
                    if (TextUtils.isEmpty(strOptString)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    String strOptString2 = jSONObject2.optString("selected", "");
                    this.f20782m = strOptString2;
                    if ("collect_all".equals(strOptString2)) {
                        return;
                    }
                    if ("allow_list".equals(this.f20782m)) {
                        this.f20777g = A1.b.r("allow_list", jSONObject2);
                        this.f20778h = A1.b.n0("allow_list", jSONObject2);
                    } else if ("block_list".equals(this.f20782m)) {
                        this.f20775e = A1.b.r("block_list", jSONObject2);
                        this.f20776f = A1.b.n0("block_list", jSONObject2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
