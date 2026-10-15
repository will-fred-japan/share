package com.google.android.gms.location;

import N.a;
import S4.C0375f;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p056h5.x;
import p071j5.C0616h;
import p071j5.C0620l;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f12735b = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<LocationResult> CREATOR = new C0616h();

    public LocationResult(List list) {
        this.f12736a = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        int i9 = Build.VERSION.SDK_INT;
        List<Location> list = this.f12736a;
        if (i9 >= 31) {
            return list.equals(locationResult.f12736a);
        }
        if (list.size() != locationResult.f12736a.size()) {
            return false;
        }
        Iterator it = locationResult.f12736a.iterator();
        for (Location location : list) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !C0375f.a(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12736a});
    }

    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder("LocationResult");
        DecimalFormat decimalFormat = C0620l.f19866a;
        List<Location> list = this.f12736a;
        sb.ensureCapacity(list.size() * 100);
        sb.append("[");
        boolean z8 = false;
        for (Location location : list) {
            sb.ensureCapacity(100);
            if (location == null) {
                sb.append((String) null);
            } else {
                sb.append("{");
                sb.append(location.getProvider());
                sb.append(", ");
                if (Build.VERSION.SDK_INT >= 31 ? a.a(location) : location.isFromMockProvider()) {
                    sb.append("mock, ");
                }
                DecimalFormat decimalFormat2 = C0620l.f19866a;
                sb.append(decimalFormat2.format(location.getLatitude()));
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(decimalFormat2.format(location.getLongitude()));
                boolean zHasAccuracy = location.hasAccuracy();
                DecimalFormat decimalFormat3 = C0620l.f19867b;
                if (zHasAccuracy) {
                    sb.append("±");
                    sb.append(decimalFormat3.format(location.getAccuracy()));
                    sb.append("m");
                }
                if (location.hasAltitude()) {
                    sb.append(", alt=");
                    sb.append(decimalFormat3.format(location.getAltitude()));
                    if (location.hasVerticalAccuracy()) {
                        sb.append("±");
                        sb.append(decimalFormat3.format(location.getVerticalAccuracyMeters()));
                    }
                    sb.append("m");
                }
                if (location.hasSpeed()) {
                    sb.append(", spd=");
                    sb.append(decimalFormat3.format(location.getSpeed()));
                    if (location.hasSpeedAccuracy()) {
                        sb.append("±");
                        sb.append(decimalFormat3.format(location.getSpeedAccuracyMetersPerSecond()));
                    }
                    sb.append("m/s");
                }
                if (location.hasBearing()) {
                    sb.append(", brg=");
                    sb.append(decimalFormat3.format(location.getBearing()));
                    if (location.hasBearingAccuracy()) {
                        sb.append("±");
                        sb.append(decimalFormat3.format(location.getBearingAccuracyDegrees()));
                    }
                    sb.append("°");
                }
                Bundle extras = location.getExtras();
                String string2 = extras != null ? extras.getString("floorLabel") : null;
                if (string2 != null) {
                    sb.append(", fl=");
                    sb.append(string2);
                }
                Bundle extras2 = location.getExtras();
                String string3 = extras2 != null ? extras2.getString("levelId") : null;
                if (string3 != null) {
                    sb.append(", lv=");
                    sb.append(string3);
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                sb.append(", ert=");
                long millis = TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos()) + jCurrentTimeMillis;
                if (millis >= 0) {
                    string = x.f19081a.format(new Date(millis));
                } else {
                    SimpleDateFormat simpleDateFormat = x.f19081a;
                    string = Long.toString(millis);
                }
                sb.append(string);
                sb.append('}');
            }
            sb.append(", ");
            z8 = true;
        }
        if (z8) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12736a);
        b.V(parcel, iU);
    }
}
