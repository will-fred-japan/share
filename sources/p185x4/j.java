package p185x4;

import N.b;
import N.c;
import N.d;
import Z6.e;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p168v4.g;
import p176w4.a;

/* JADX INFO: compiled from: LocationManagerClient.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationManager f22319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f22320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f22321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f22322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22323e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Location f22324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f22326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f22327i;

    public j(Context context, l lVar) {
        this.f22319a = (LocationManager) context.getSystemService("location");
        this.f22321c = lVar;
        this.f22322d = context;
        this.f22320b = new o(context, lVar);
    }

    public static boolean g(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z8 = time > 120000;
        boolean z9 = time < -120000;
        boolean z10 = time > 0;
        if (z8) {
            return true;
        }
        if (z9) {
            return false;
        }
        float accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z11 = accuracy > 0.0f;
        boolean z12 = accuracy < 0.0f;
        boolean z13 = accuracy > 200.0f;
        boolean zEquals = location.getProvider() != null ? location.getProvider().equals(location2.getProvider()) : false;
        if (z12) {
            return true;
        }
        if (!z10 || z11) {
            return z10 && !z13 && zEquals;
        }
        return true;
    }

    @Override // p185x4.i
    public final boolean a(int i9, int i10) {
        return false;
    }

    @Override // p185x4.i
    @SuppressLint({"MissingPermission"})
    public final void c(e eVar, p pVar, a aVar) {
        long j;
        long j8;
        float f6;
        int i9;
        String str;
        boolean zB = i.b(this.f22322d);
        p176w4.b bVar = p176w4.b.f22109c;
        if (!zB) {
            aVar.b(bVar);
            return;
        }
        this.f22326h = pVar;
        this.f22327i = aVar;
        f fVar = f.f22312e;
        f fVar2 = f.f22308a;
        l lVar = this.f22321c;
        if (lVar != null) {
            float f9 = lVar.f22329b;
            f fVar3 = lVar.f22328a;
            if (fVar3 == fVar2) {
                j = Long.MAX_VALUE;
                j8 = Long.MAX_VALUE;
            } else {
                j = Long.MAX_VALUE;
                j8 = lVar.f22330c;
            }
            int iOrdinal = fVar3.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                i9 = 104;
            } else {
                i9 = (iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5) ? 100 : 102;
            }
            f6 = f9;
            fVar = fVar3;
        } else {
            j = Long.MAX_VALUE;
            j8 = 0;
            f6 = 0.0f;
            i9 = 102;
        }
        long j9 = j8;
        List<String> providers = this.f22319a.getProviders(true);
        if (fVar == fVar2) {
            str = "passive";
        } else {
            str = "fused";
            if (!providers.contains("fused") || Build.VERSION.SDK_INT < 31) {
                str = "gps";
                if (!providers.contains("gps")) {
                    str = "network";
                    if (!providers.contains("network")) {
                        str = !providers.isEmpty() ? providers.get(0) : null;
                    }
                }
            }
        }
        this.f22325g = str;
        if (str == null) {
            aVar.b(bVar);
            return;
        }
        A1.b.I0(j9, "intervalMillis");
        if (f6 < 0.0f) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", "minUpdateDistanceMeters", Float.valueOf(0.0f), Float.valueOf(Float.MAX_VALUE)));
        }
        if (f6 > Float.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", "minUpdateDistanceMeters", Float.valueOf(0.0f), Float.valueOf(Float.MAX_VALUE)));
        }
        A1.b.I0(j9, "minUpdateIntervalMillis");
        boolean z8 = i9 == 104 || i9 == 102 || i9 == 100;
        Object[] objArr = {Integer.valueOf(i9)};
        if (!z8) {
            throw new IllegalArgumentException(String.format("quality must be a defined QUALITY constant, not %d", objArr));
        }
        if (!((j9 == j && j9 == -1) ? false : true)) {
            throw new IllegalStateException("passive location requests must have an explicit minimum update interval");
        }
        d dVar = new d(j9, i9, Math.min(j9, j9), f6);
        this.f22323e = true;
        this.f22320b.b();
        String str2 = this.f22325g;
        Looper mainLooper = Looper.getMainLooper();
        int i10 = c.f3105a;
        int i11 = Build.VERSION.SDK_INT;
        LocationManager locationManager = this.f22319a;
        if (i11 >= 31) {
            c.b.a(locationManager, str2, d.b.a(dVar), new P.c(new Handler(mainLooper), 0), this);
            return;
        }
        try {
            if (c.a.f3106a == null) {
                c.a.f3106a = Class.forName("android.location.LocationRequest");
            }
            if (c.a.f3107b == null) {
                Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", c.a.f3106a, LocationListener.class, Looper.class);
                c.a.f3107b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            LocationRequest locationRequestA = dVar.a(str2);
            if (locationRequestA != null) {
                c.a.f3107b.invoke(locationManager, locationRequestA, this, mainLooper);
                return;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
        }
        locationManager.requestLocationUpdates(str2, dVar.f3109b, dVar.f3111d, this, mainLooper);
    }

    @Override // p185x4.i
    public final void d(b bVar) {
        if (this.f22319a == null) {
            bVar.f22286a.success(Boolean.FALSE);
        } else {
            bVar.f22286a.success(Boolean.valueOf(i.b(this.f22322d)));
        }
    }

    @Override // p185x4.i
    @SuppressLint({"MissingPermission"})
    public final void e() {
        LocationManager locationManager;
        this.f22323e = false;
        o oVar = this.f22320b;
        if (oVar.f22337c != null && (locationManager = oVar.f22336b) != null) {
            locationManager.removeNmeaListener(oVar.f22338d);
            locationManager.unregisterGnssStatusCallback(oVar.f22339e);
            oVar.j = false;
        }
        this.f22319a.removeUpdates(this);
    }

    @Override // p185x4.i
    public final void f(g gVar, p168v4.e eVar) {
        LocationManager locationManager = this.f22319a;
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && g(lastKnownLocation, location)) {
                location = lastKnownLocation;
            }
        }
        gVar.c(location);
    }

    @Override // android.location.LocationListener
    public final synchronized void onLocationChanged(Location location) {
        if (g(location, this.f22324f)) {
            this.f22324f = location;
            if (this.f22326h != null) {
                this.f22320b.a(location);
                this.f22326h.c(this.f22324f);
            }
        }
    }

    @Override // android.location.LocationListener
    @SuppressLint({"MissingPermission"})
    public final void onProviderDisabled(String str) {
        if (str.equals(this.f22325g)) {
            if (this.f22323e) {
                this.f22319a.removeUpdates(this);
            }
            a aVar = this.f22327i;
            if (aVar != null) {
                aVar.b(p176w4.b.f22109c);
            }
            this.f22325g = null;
        }
    }

    @Override // android.location.LocationListener
    @TargetApi(28)
    public final void onStatusChanged(String str, int i9, Bundle bundle) {
        if (i9 != 2 && i9 == 0) {
            onProviderDisabled(str);
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }
}
