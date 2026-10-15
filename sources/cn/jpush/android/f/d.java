package cn.jpush.android.f;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f11389c;

    public d(String str, long j, JSONObject jSONObject) {
        this.f11387a = str;
        this.f11388b = j;
        this.f11389c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f11387a, this.f11388b, this.f11389c);
    }
}
