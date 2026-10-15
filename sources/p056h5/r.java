package p056h5;

import P4.d;
import S4.AbstractC0372c;
import S4.C0371b;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import p071j5.B;
import p155u.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC0372c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final g f19078A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final g f19079B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f19080z;

    public r(Context context, Looper looper, C0371b c0371b, d.a aVar, d.b bVar) {
        super(context, looper, 23, c0371b, aVar, bVar);
        this.f19080z = new g();
        this.f19078A = new g();
        this.f19079B = new g();
        new g();
    }

    @Override // S4.AbstractC0370a, P4.a.e
    public final int f() {
        return 11717000;
    }

    @Override // S4.AbstractC0370a
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof N ? (N) iInterfaceQueryLocalInterface : new M(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService", 1);
    }

    @Override // S4.AbstractC0370a
    public final Feature[] p() {
        return B.f19860c;
    }

    @Override // S4.AbstractC0370a
    public final String s() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // S4.AbstractC0370a
    public final String t() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // S4.AbstractC0370a
    public final void v() {
        System.currentTimeMillis();
        synchronized (this.f19080z) {
            this.f19080z.clear();
        }
        synchronized (this.f19078A) {
            this.f19078A.clear();
        }
        synchronized (this.f19079B) {
            this.f19079B.clear();
        }
    }

    public final boolean y(Feature feature) {
        Feature feature2;
        Feature[] featureArrG = g();
        if (featureArrG != null) {
            int i9 = 0;
            while (true) {
                if (i9 >= featureArrG.length) {
                    feature2 = null;
                    break;
                }
                feature2 = featureArrG[i9];
                if (feature.f12454a.equals(feature2.f12454a)) {
                    break;
                }
                i9++;
            }
            if (feature2 != null && feature2.d() >= feature.d()) {
                return true;
            }
        }
        return false;
    }
}
