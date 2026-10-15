package com.baseflow.geolocator;

import Z6.e;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import p185x4.c;
import p185x4.i;

/* JADX INFO: loaded from: classes.dex */
public class GeolocatorLocationService extends Service {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f11985k = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f11992g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11986a = new a(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11987b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11988c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11989d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f11990e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p185x4.e f11991f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PowerManager.WakeLock f11993h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WifiManager.WifiLock f11994i = null;
    public p185x4.a j = null;

    public class a extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GeolocatorLocationService f11995a;

        public a(GeolocatorLocationService geolocatorLocationService) {
            this.f11995a = geolocatorLocationService;
        }
    }

    @SuppressLint({"WakelockTimeout"})
    public final void a(c cVar) {
        WifiManager wifiManager;
        PowerManager powerManager;
        b();
        if (cVar.f22292f && (powerManager = (PowerManager) getApplicationContext().getSystemService("power")) != null) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "GeolocatorLocationService:Wakelock");
            this.f11993h = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            this.f11993h.acquire();
        }
        if (!cVar.f22291e || (wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi")) == null) {
            return;
        }
        WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(Build.VERSION.SDK_INT < 29 ? 3 : 4, "GeolocatorLocationService:WifiLock");
        this.f11994i = wifiLockCreateWifiLock;
        wifiLockCreateWifiLock.setReferenceCounted(false);
        this.f11994i.acquire();
    }

    public final void b() {
        PowerManager.WakeLock wakeLock = this.f11993h;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f11993h.release();
            this.f11993h = null;
        }
        WifiManager.WifiLock wifiLock = this.f11994i;
        if (wifiLock == null || !wifiLock.isHeld()) {
            return;
        }
        this.f11994i.release();
        this.f11994i = null;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("FlutterGeolocator", "Binding to location service.");
        return this.f11986a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("FlutterGeolocator", "Creating service.");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        p185x4.e eVar;
        Log.d("FlutterGeolocator", "Destroying location service.");
        this.f11989d--;
        Log.d("FlutterGeolocator", "Stopping location service.");
        i iVar = this.f11992g;
        if (iVar != null && (eVar = this.f11991f) != null) {
            eVar.f22307a.remove(iVar);
            iVar.e();
        }
        if (this.f11987b) {
            Log.d("FlutterGeolocator", "Stop service in foreground.");
            stopForeground(1);
            b();
            this.f11987b = false;
            this.j = null;
        }
        this.f11991f = null;
        this.j = null;
        Log.d("FlutterGeolocator", "Destroyed location service.");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        return 1;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        Log.d("FlutterGeolocator", "Unbinding from location service.");
        return super.onUnbind(intent);
    }
}
