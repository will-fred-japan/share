package cn.jiguang.commons.a;

import android.location.GpsStatus;

/* JADX INFO: loaded from: classes.dex */
final class ig implements GpsStatus.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ii f10196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ id f10197b;

    public ig(id idVar, ii iiVar) {
        this.f10197b = idVar;
        this.f10196a = iiVar;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int i9) {
        if (i9 == 4) {
            id.a(this.f10197b, this.f10196a);
        }
    }
}
