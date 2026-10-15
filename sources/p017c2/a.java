package p017c2;

import E4.c;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;
import p061i1.h;
import p124q1.f;
import p167v3.b;

/* JADX INFO: compiled from: AbstractPerfCollector.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b, p175w3.a, r2.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8696f;

    public abstract void a(JSONObject jSONObject);

    @Override // r2.b.d
    public final void b(long j) {
        long jK = k();
        if (jK <= 0 || j - this.f8696f <= jK || !this.f8691a) {
            return;
        }
        j();
        this.f8696f = System.currentTimeMillis();
    }

    @Override // p167v3.b
    public final void c(Activity activity) {
    }

    public final void d(f fVar) {
        A1.b.W(fVar);
        p115p1.a.g().c(fVar);
    }

    @Override // p167v3.b
    public void f(Activity activity) {
        this.f8692b = true;
        Application application = h.f19229a;
    }

    public final void g() {
        if (this.f8693c) {
            return;
        }
        if (TextUtils.isEmpty(this.f8695e)) {
            throw new IllegalStateException("Must set collector Setting key, before init");
        }
        this.f8693c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f8692b = true ^ ActivityLifeObserver.getInstance().isForeground();
        i();
        ((IConfigManager) c.a(IConfigManager.class)).registerConfigListener(this);
        if (h.f19230b) {
            Log.d("AbstractPerfCollector", p199z2.b.f(new String[]{"perf init: " + this.f8695e}));
        }
    }

    public abstract boolean h();

    public abstract void j();

    public abstract long k();

    public void onReady() {
        this.f8691a = true;
        if (!this.f8694d) {
            this.f8694d = true;
            if (h()) {
                p133r2.b.f21107i.c(this);
            }
        }
        j();
        this.f8696f = System.currentTimeMillis();
    }

    @Override // p175w3.a
    public final void onRefresh(JSONObject jSONObject, boolean z8) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(this.f8695e)) == null) {
            return;
        }
        jSONObjectOptJSONObject.optInt("enable_upload", 0);
        a(jSONObjectOptJSONObject);
    }

    @Override // p167v3.b
    /* JADX INFO: renamed from: c */
    public void mo848c() {
        this.f8692b = false;
        Application application = h.f19229a;
    }

    public void i() {
    }

    @Override // p167v3.b
    public final void e(Bundle bundle) {
    }

    @Override // p167v3.b
    public final void onActivityStarted(Activity activity) {
    }
}
