package cn.jiguang.commons.a;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Location> f10181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<ae> f10182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f10183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f10184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f10185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f10186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<LocationManager> f10187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HandlerThread f10188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f10189i;
    private GnssStatus.Callback j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GpsStatus.Listener f10190k;

    private id() {
        this.f10181a = new AtomicReference<>();
        this.f10182b = new AtomicReference<>();
        this.f10183c = new AtomicLong(0L);
        this.f10184d = new AtomicLong(0L);
        this.f10185e = new AtomicInteger(0);
        this.f10186f = new AtomicBoolean(false);
        this.f10187g = new AtomicReference<>();
        HandlerThread handlerThread = new HandlerThread("jg_c_v2", 5);
        this.f10188h = handlerThread;
        handlerThread.start();
        this.f10189i = new Handler(handlerThread.getLooper());
        ee.a("GpsStatusManager", "gps helper init ok");
    }

    private LocationManager c() {
        Context contextA;
        LocationManager locationManager = this.f10187g.get();
        if (locationManager != null || (contextA = jg.a()) == null) {
            return locationManager;
        }
        LocationManager locationManager2 = (LocationManager) contextA.getSystemService("location");
        this.f10187g.set(locationManager2);
        return locationManager2;
    }

    private static boolean d() {
        return true;
    }

    public /* synthetic */ id(byte b9) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Location a(String str) {
        try {
            Location locationA = jw.a().a(c(), str);
            ee.a("GpsStatusManager", "lk from " + str);
            if (!b(locationA)) {
                return null;
            }
            ee.a("GpsStatusManager", String.format("%s location - lat: %f, lon: %f, acc: %f, time: %d", str, Double.valueOf(locationA.getLatitude()), Double.valueOf(locationA.getLongitude()), Float.valueOf(locationA.getAccuracy()), Long.valueOf(locationA.getTime())));
            return locationA;
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("get loc err:"), "GpsStatusManager");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Handler handlerA = a();
            if (handlerA != null) {
                handlerA.removeCallbacksAndMessages(null);
            }
            if (d() && this.j != null) {
                c().unregisterGnssStatusCallback(this.j);
                this.j = null;
            } else if (this.f10190k != null) {
                c().removeGpsStatusListener(this.f10190k);
                this.f10190k = null;
            }
        } catch (Throwable th) {
            try {
                ee.d("GpsStatusManager", "stop gps err:" + th.getMessage());
            } finally {
                this.f10186f.set(false);
            }
        }
    }

    public static /* synthetic */ void b(id idVar, ii iiVar) {
        if (b(idVar.f10181a.get())) {
            ee.a("GpsStatusManager", "use cached location on timeout");
            iiVar.a(a(idVar.f10181a.get()));
            return;
        }
        Location locationA = idVar.a("network");
        ee.a("GpsStatusManager", "use coarse location");
        if (b(locationA)) {
            iiVar.a(a(locationA));
        } else {
            iiVar.b("No valid location available");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location == null || location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    private Handler a() {
        if (!this.f10188h.isAlive()) {
            ee.e("GpsStatusManager", "handler thread not alive");
            return null;
        }
        if (this.f10189i == null) {
            this.f10189i = new Handler(this.f10188h.getLooper());
        }
        return this.f10189i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        return String.format("%d|%s|%f|%f|%f|%f|%f", Long.valueOf(location.getTime()), location.getProvider(), Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getBearing()), Float.valueOf(location.getAccuracy()));
    }

    public final void a(ae aeVar, il ilVar) {
        Handler handlerA = a();
        if (handlerA == null) {
            ee.e("GpsStatusManager", "cannot get gps handler");
            ilVar.b("Internal error");
            ey.b().m(3035);
        } else if (!kh.c()) {
            ee.d("GpsStatusManager", "location permission denied");
            ilVar.b("Location permission not granted");
            ey.b().m(Integer.valueOf(MTPushConstants.MainWhat.ALIAS_GET));
        } else {
            if (jw.a().d()) {
                handlerA.post(new ie(this, ilVar, aeVar));
                return;
            }
            ee.d("GpsStatusManager", "gps disabled");
            ilVar.b("GPS is disabled");
            ey.b().m(Integer.valueOf(MTPushConstants.MainWhat.ON_PLATFORM_TOKEN_TO_USER));
        }
    }

    public static /* synthetic */ void a(id idVar, ae aeVar, ii iiVar) {
        jw.a();
        if (!jw.c()) {
            iiVar.b("Background location permission not granted");
            return;
        }
        if (idVar.c() == null) {
            iiVar.b("LocationManager not available");
            ey.b().m(Integer.valueOf(MTPushConstants.MainWhat.ALIAS_CLEAR));
            return;
        }
        if (!idVar.f10186f.compareAndSet(false, true)) {
            iiVar.b("GPS already listening");
            return;
        }
        try {
            idVar.f10182b.set(aeVar);
            idVar.f10183c.set(System.currentTimeMillis());
            idVar.f10184d.set(0L);
            idVar.f10185e.set(0);
            idVar.f10181a.set(null);
            if (d()) {
                idVar.j = new Cif(idVar, iiVar);
                if (idVar.c().registerGnssStatusCallback(idVar.j, idVar.f10189i)) {
                    ee.a("GpsStatusManager", "gnss callback registered");
                } else {
                    iiVar.b("Failed to register GNSS callback");
                    idVar.b();
                }
            } else {
                idVar.a(iiVar);
            }
            Handler handlerA = idVar.a();
            if (handlerA == null) {
                iiVar.b("Internal error");
            } else {
                handlerA.postDelayed(new ih(idVar, iiVar), 20000L);
            }
            ee.a("GpsStatusManager", "gps listening started");
        } catch (Throwable th) {
            String str = "Error: " + th.getMessage();
            ee.e("GpsStatusManager", "generic err:" + th.getMessage());
            iiVar.b(str);
            idVar.b();
        }
    }

    public static /* synthetic */ void a(id idVar, ii iiVar) {
        String str;
        String str2;
        try {
            if (idVar.f10185e.get() < 3) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                ae aeVar = idVar.f10182b.get();
                long jC = aeVar.c("gps_update_interval");
                ee.a("GpsStatusManager", "attempt location update");
                if (jCurrentTimeMillis - idVar.f10183c.get() > jC) {
                    idVar.f10183c.set(jCurrentTimeMillis);
                    idVar.f10185e.set(0);
                    ee.a("GpsStatusManager", "gps interval reset");
                }
                if (jCurrentTimeMillis - idVar.f10184d.get() < 2000) {
                    Location location = idVar.f10181a.get();
                    if (!b(location)) {
                        str = "no valid cached location";
                        ee.d("GpsStatusManager", str);
                        return;
                    }
                    ae aeVar2 = idVar.f10182b.get();
                    ee.a("GpsStatusManager", "use cached location, remaining:" + ((aeVar2 != null ? ((long) aeVar2.c("gps_update_interval")) - Math.abs(System.currentTimeMillis() - idVar.f10184d.get()) : 0L) / 1000) + "s");
                    iiVar.a(a(location));
                    idVar.b();
                    return;
                }
                idVar.f10185e.incrementAndGet();
                idVar.f10184d.set(System.currentTimeMillis());
                ee.a("GpsStatusManager", "attempt location, count:" + idVar.f10185e.get());
                Location locationA = idVar.a("gps");
                if (!b(locationA)) {
                    str = "invalid gps location";
                    ee.d("GpsStatusManager", str);
                    return;
                }
                Location location2 = idVar.f10181a.get();
                str2 = (location2 != null && locationA.distanceTo(location2) < ((float) aeVar.c("gps_update_distance"))) ? "location not updated - distance threshold not met" : "session terminated - max attempts";
                idVar.f10181a.set(new Location(locationA));
                iiVar.a(a(locationA));
                idVar.b();
                return;
            }
            if (b(idVar.f10181a.get())) {
                ee.a("GpsStatusManager", "use cached location after max attempts");
                iiVar.a(a(idVar.f10181a.get()));
            } else {
                iiVar.b("Max attempts reached without valid location");
            }
            idVar.b();
            ee.a("GpsStatusManager", str2);
        } catch (Throwable th) {
            ee.d("GpsStatusManager", "location err:" + th.getMessage());
            iiVar.b("Error: " + th.getMessage());
            idVar.b();
        }
    }

    private void a(ii iiVar) {
        this.f10190k = new ig(this, iiVar);
        try {
            c().addGpsStatusListener(this.f10190k);
            ee.a("GpsStatusManager", "gps listener registered");
        } catch (Throwable th) {
            iiVar.b("Failed to register GPS listener: " + th.getMessage());
            b();
        }
    }
}
