package p061i1;

import Q2.a;
import com.bytedance.apm.insight.ApmInsightInitConfig;

/* JADX INFO: compiled from: ApmConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f19226c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ApmInsightInitConfig f19227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19228b;

    public static g b() {
        if (f19226c == null) {
            synchronized (a.class) {
                try {
                    if (f19226c == null) {
                        g gVar = new g();
                        a.a().b(new f());
                        f19226c = gVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f19226c;
    }

    public final boolean a() {
        ApmInsightInitConfig apmInsightInitConfig;
        if (!this.f19228b || (apmInsightInitConfig = this.f19227a) == null) {
            return false;
        }
        return apmInsightInitConfig.enableNetMonitor();
    }
}
