package p061i1;

import android.app.Application;
import p083l2.a;

/* JADX INFO: compiled from: ApmAgent.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f19214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f19215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f19216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f19217d;

    public c(Application application, long j, long j8, boolean z8) {
        this.f19214a = application;
        this.f19215b = j;
        this.f19216c = j8;
        this.f19217d = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Application application = this.f19214a;
            a aVar = new a();
            if (application != null) {
                aVar.f20018a = application;
            }
            aVar.a(this.f19215b, this.f19216c, this.f19217d);
        } catch (Exception unused) {
        }
    }
}
