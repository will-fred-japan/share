package cn.jiguang.commons.a;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
final class ie implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ii f10191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f10192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ id f10193c;

    public ie(id idVar, ii iiVar, ae aeVar) {
        this.f10193c = idVar;
        this.f10191a = iiVar;
        this.f10192b = aeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Location locationA = this.f10193c.a("gps");
        id idVar = this.f10193c;
        if (!id.b(locationA)) {
            id.a(this.f10193c, this.f10192b, this.f10191a);
            return;
        }
        ii iiVar = this.f10191a;
        id idVar2 = this.f10193c;
        iiVar.a(id.a(locationA));
    }
}
