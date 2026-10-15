package cn.jiguang.commons.a;

import android.location.GnssStatus;

/* JADX INFO: renamed from: cn.jiguang.commons.a.if, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
final class Cif extends GnssStatus.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ii f10194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ id f10195b;

    public Cif(id idVar, ii iiVar) {
        this.f10195b = idVar;
        this.f10194a = iiVar;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onFirstFix(int i9) {
        ee.a("GpsStatusManager", "gnss first fix:" + i9);
    }

    @Override // android.location.GnssStatus.Callback
    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        id.a(this.f10195b, this.f10194a);
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStarted() {
        ee.a("GpsStatusManager", "gnss started");
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStopped() {
        ee.a("GpsStatusManager", "gnss stopped");
    }
}
