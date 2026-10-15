package p185x4;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.os.Handler;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;

/* JADX INFO: compiled from: NmeaClient.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f22336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f22337c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f22341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f22342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Calendar f22343i;
    public boolean j = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @TargetApi(24)
    public final n f22338d = new OnNmeaMessageListener() { // from class: x4.n
        @Override // android.location.OnNmeaMessageListener
        public final void onNmeaMessage(String str, long j) {
            o oVar = this.f22334a;
            oVar.getClass();
            if (str.trim().matches("^\\$..GGA.*$")) {
                oVar.f22340f = str;
                oVar.f22343i = Calendar.getInstance();
            }
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @TargetApi(24)
    public final a f22339e = new a();

    /* JADX INFO: compiled from: NmeaClient.java */
    public class a extends GnssStatus.Callback {
        public a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            double satelliteCount = gnssStatus.getSatelliteCount();
            o oVar = o.this;
            oVar.f22341g = satelliteCount;
            oVar.f22342h = 0.0d;
            for (int i9 = 0; i9 < oVar.f22341g; i9++) {
                if (gnssStatus.usedInFix(i9)) {
                    oVar.f22342h += 1.0d;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [x4.n] */
    public o(Context context, l lVar) {
        this.f22335a = context;
        this.f22337c = lVar;
        this.f22336b = (LocationManager) context.getSystemService("location");
    }

    public final void a(Location location) {
        l lVar;
        if (location == null) {
            return;
        }
        if (location.getExtras() == null) {
            location.setExtras(Bundle.EMPTY);
        }
        location.getExtras().putDouble("geolocator_mslSatelliteCount", this.f22341g);
        location.getExtras().putDouble("geolocator_mslSatellitesUsedInFix", this.f22342h);
        if (this.f22340f == null || (lVar = this.f22337c) == null || !this.j) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, -5);
        Calendar calendar2 = this.f22343i;
        if ((calendar2 == null || !calendar2.before(calendar)) && lVar.f22331d) {
            String[] strArrSplit = this.f22340f.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            String str = strArrSplit[0];
            if (!this.f22340f.trim().matches("^\\$..GGA.*$") || strArrSplit.length <= 9 || strArrSplit[9].isEmpty()) {
                return;
            }
            double d9 = Double.parseDouble(strArrSplit[9]);
            if (location.getExtras() == null) {
                location.setExtras(Bundle.EMPTY);
            }
            location.getExtras().putDouble("geolocator_mslAltitude", d9);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void b() {
        LocationManager locationManager;
        if (this.j || this.f22337c == null || (locationManager = this.f22336b) == null || this.f22335a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        locationManager.addNmeaListener(this.f22338d, (Handler) null);
        locationManager.registerGnssStatusCallback(this.f22339e, (Handler) null);
        this.j = true;
    }
}
