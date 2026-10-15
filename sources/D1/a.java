package D1;

import android.app.Activity;
import android.app.Application;
import org.json.JSONObject;
import p061i1.h;

/* JADX INFO: compiled from: BatteryAbstractTimerCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends p017c2.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1843i = 5;

    public a() {
        this.f8695e = "battery";
        p133r2.b.f21107i.c(this);
    }

    @Override // p017c2.a
    public void a(JSONObject jSONObject) {
        this.f1841g = jSONObject.optInt("enable_upload", 0) == 1;
        this.f1842h = jSONObject.optInt("background_enable", 0) == 1;
        this.f1843i = jSONObject.optInt("sample_interval", 5);
    }

    @Override // p017c2.a, p167v3.b
    /* JADX INFO: renamed from: c */
    public final void mo848c() {
        this.f8692b = false;
        Application application = h.f19229a;
        p133r2.b.f21107i.c(this);
    }

    @Override // p017c2.a, p167v3.b
    public final void f(Activity activity) {
        this.f8692b = true;
        Application application = h.f19229a;
        if (this.f1842h) {
            return;
        }
        p133r2.b bVar = p133r2.b.f21107i;
        bVar.getClass();
        try {
            bVar.f21113f.remove(this);
        } catch (Throwable unused) {
        }
    }

    @Override // p017c2.a
    public final boolean h() {
        return this.f1841g;
    }

    @Override // p017c2.a
    public final long k() {
        return ((long) this.f1843i) * 60000;
    }
}
