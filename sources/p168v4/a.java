package p168v4;

import android.location.Location;
import com.baseflow.geolocator.GeolocatorLocationService;
import p096m7.d;
import p176w4.b;
import p185x4.k;
import p185x4.p;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements p, p176w4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.b.a f21894a;

    @Override // p176w4.a
    public void b(b bVar) {
        this.f21894a.b(bVar.toString(), bVar.a(), null);
    }

    @Override // p185x4.p
    public void c(Location location) {
        int i9 = GeolocatorLocationService.f11985k;
        this.f21894a.success(k.a(location));
    }
}
