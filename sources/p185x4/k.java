package p185x4;

import android.location.Location;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: LocationMapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static HashMap a(Location location) {
        if (location == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(MTPushConstants.Geofence.KEY_LATITUDE, Double.valueOf(location.getLatitude()));
        map.put(MTPushConstants.Geofence.KEY_LONGITUDE, Double.valueOf(location.getLongitude()));
        map.put("timestamp", Long.valueOf(location.getTime()));
        int i9 = Build.VERSION.SDK_INT;
        map.put("is_mocked", Boolean.valueOf(i9 >= 31 ? location.isMock() : location.isFromMockProvider()));
        if (location.hasAltitude()) {
            map.put("altitude", Double.valueOf(location.getAltitude()));
        }
        if (location.hasVerticalAccuracy()) {
            map.put("altitude_accuracy", Float.valueOf(location.getVerticalAccuracyMeters()));
        }
        if (location.hasAccuracy()) {
            map.put("accuracy", Double.valueOf(location.getAccuracy()));
        }
        if (location.hasBearing()) {
            map.put("heading", Double.valueOf(location.getBearing()));
        }
        if (location.hasBearingAccuracy()) {
            map.put("heading_accuracy", Float.valueOf(location.getBearingAccuracyDegrees()));
        }
        if (location.hasSpeed()) {
            map.put("speed", Double.valueOf(location.getSpeed()));
        }
        if (location.hasSpeedAccuracy()) {
            map.put("speed_accuracy", Double.valueOf(location.getSpeedAccuracyMetersPerSecond()));
        }
        if (location.getExtras() != null) {
            if (location.getExtras().containsKey("geolocator_mslAltitude")) {
                map.put("altitude", Double.valueOf(location.getExtras().getDouble("geolocator_mslAltitude")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatelliteCount")) {
                map.put("gnss_satellite_count", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatelliteCount")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatellitesUsedInFix")) {
                map.put("gnss_satellites_used_in_fix", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatellitesUsedInFix")));
            }
            if (i9 >= 34 && location.hasMslAltitude()) {
                map.put("altitude", Double.valueOf(location.getMslAltitudeMeters()));
                if (location.hasMslAltitudeAccuracy()) {
                    map.put("altitude_accuracy", Float.valueOf(location.getMslAltitudeAccuracyMeters()));
                }
            }
        }
        return map;
    }
}
