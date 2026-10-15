package p168v4;

import I.a;
import android.content.Context;
import android.content.IntentFilter;
import p096m7.d;
import p185x4.m;

/* JADX INFO: compiled from: LocationServiceHandlerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f21895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f21896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f21897c;

    @Override // m7.d.c
    public final void a(Object obj, d.b.a aVar) {
        if (this.f21896b == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
        intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
        m mVar = new m(aVar);
        this.f21897c = mVar;
        a.c(this.f21896b, mVar, intentFilter);
    }

    @Override // m7.d.c
    public final void b() {
        m mVar;
        Context context = this.f21896b;
        if (context == null || (mVar = this.f21897c) == null) {
            return;
        }
        context.unregisterReceiver(mVar);
    }
}
