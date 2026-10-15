package cn.jiguang.commons.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class jx implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ jw f10337b;

    public jx(jw jwVar, CountDownLatch countDownLatch) {
        this.f10337b = jwVar;
        this.f10336a = countDownLatch;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        try {
            jw jwVar = this.f10337b;
            ab abVarA = jw.a(location);
            if (abVarA != null) {
                this.f10337b.b(abVarA);
                ee.a("LocationUtils", "loc:callback:ok:" + location.getProvider());
            }
        } catch (Throwable th) {
            try {
                ee.d("LocationUtils", "loc:callback:err:" + th.getMessage());
            } finally {
                jw jwVar2 = this.f10337b;
                jw.a(this.f10336a);
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        ee.d("LocationUtils", "loc:provider_disabled:" + str);
        jw jwVar = this.f10337b;
        jw.a(this.f10336a);
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i9, Bundle bundle) {
        if (i9 == 0) {
            ee.d("LocationUtils", "loc:provider_out:" + str);
            jw jwVar = this.f10337b;
            jw.a(this.f10336a);
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }
}
