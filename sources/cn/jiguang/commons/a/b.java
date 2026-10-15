package cn.jiguang.commons.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f9704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AbstractC0552a f9706d;

    public b(AbstractC0552a abstractC0552a, String str, JSONObject jSONObject, boolean z8) {
        this.f9706d = abstractC0552a;
        this.f9703a = str;
        this.f9704b = jSONObject;
        this.f9705c = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            bq.a();
            ee.a("TopicManager", this.f9703a + " real c, scd:" + bq.a(this.f9703a));
            JSONObject jSONObject = this.f9704b;
            if (jSONObject == null) {
                this.f9706d.a(this.f9705c);
            } else {
                this.f9706d.a(this.f9705c, jSONObject);
            }
        } catch (Throwable th) {
            ee.e("JCommon", "collect task failed, tag:" + this.f9703a + ", err:" + th.getMessage());
        }
    }
}
