package cn.jiguang.aq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.aw.o;
import cn.jiguang.aw.w;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends cn.jiguang.an.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9390h;

    public k(Context context, String str) {
        super(context, str);
        this.f9383a = "unkown";
        this.f9384b = "unkown";
        this.f9383a = o.a(context);
        String strA = w.a(context, false);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.f9384b = strA;
    }

    @Override // cn.jiguang.an.a
    public JSONObject a() {
        try {
            this.f9386d = this.f9390h - this.f9389g;
            JSONObject jSONObjectD = d();
            jSONObjectD.put("network_type", this.f9383a);
            jSONObjectD.put("operate_type", this.f9384b);
            jSONObjectD.put("signal_strength", this.f9385c);
            jSONObjectD.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f9386d);
            jSONObjectD.put("error_code", this.f9387e);
            jSONObjectD.put("status_code", this.f9388f);
            jSONObjectD.put("status_code", this.f9388f);
            return jSONObjectD;
        } catch (JSONException e9) {
            cn.jiguang.x.f.c("NetMoniter", "build netmoniter data error" + e9.getMessage());
            return null;
        }
    }

    public void c(int i9) {
        this.f9387e = i9;
    }

    public abstract JSONObject d();

    public void d(int i9) {
        this.f9388f = i9;
    }

    public void e() {
        this.f9389g = System.currentTimeMillis();
    }

    public void f() {
        this.f9390h = System.currentTimeMillis();
    }
}
