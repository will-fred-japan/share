package N;

import android.location.LocationManager;
import android.location.LocationRequest;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p185x4.j;

/* JADX INFO: compiled from: LocationManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3105a = 0;

    /* JADX INFO: compiled from: LocationManagerCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Class<?> f3106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f3107b;
    }

    /* JADX INFO: compiled from: LocationManagerCompat.java */
    public static class b {
        public static void a(LocationManager locationManager, String str, LocationRequest locationRequest, P.c cVar, j jVar) {
            locationManager.requestLocationUpdates(str, locationRequest, cVar, jVar);
        }
    }

    static {
        new WeakHashMap();
    }
}
