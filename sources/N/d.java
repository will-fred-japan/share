package N;

import S.e;
import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: LocationRequestCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3111d;

    /* JADX INFO: compiled from: LocationRequestCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Class<?> f3112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f3113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f3114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Method f3115d;
    }

    /* JADX INFO: compiled from: LocationRequestCompat.java */
    public static class b {
        public static LocationRequest a(d dVar) {
            LocationRequest.Builder quality = new LocationRequest.Builder(dVar.f3109b).setQuality(dVar.f3108a);
            long j = dVar.f3110c;
            if (j == -1) {
                j = dVar.f3109b;
            }
            return quality.setMinUpdateIntervalMillis(j).setDurationMillis(Long.MAX_VALUE).setMaxUpdates(Integer.MAX_VALUE).setMinUpdateDistanceMeters(dVar.f3111d).setMaxUpdateDelayMillis(0L).build();
        }
    }

    public d(long j, int i9, long j8, float f6) {
        this.f3109b = j;
        this.f3108a = i9;
        this.f3110c = j8;
        this.f3111d = f6;
    }

    @SuppressLint({"NewApi"})
    public final LocationRequest a(String str) {
        long j = this.f3109b;
        if (Build.VERSION.SDK_INT >= 31) {
            return b.a(this);
        }
        Object obj = null;
        try {
            if (a.f3112a == null) {
                a.f3112a = Class.forName("android.location.LocationRequest");
            }
            Method method = a.f3113b;
            Class cls = Long.TYPE;
            if (method == null) {
                Method declaredMethod = a.f3112a.getDeclaredMethod("createFromDeprecatedProvider", String.class, cls, Float.TYPE, Boolean.TYPE);
                a.f3113b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object objInvoke = a.f3113b.invoke(null, str, Long.valueOf(j), Float.valueOf(this.f3111d), Boolean.FALSE);
            if (objInvoke != null) {
                Method method2 = a.f3114c;
                Class cls2 = Integer.TYPE;
                if (method2 == null) {
                    Method declaredMethod2 = a.f3112a.getDeclaredMethod("setQuality", cls2);
                    a.f3114c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                a.f3114c.invoke(objInvoke, Integer.valueOf(this.f3108a));
                if (a.f3115d == null) {
                    Method declaredMethod3 = a.f3112a.getDeclaredMethod("setFastestInterval", cls);
                    a.f3115d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                Method method3 = a.f3115d;
                long j8 = this.f3110c;
                if (j8 != -1) {
                    j = j8;
                }
                method3.invoke(objInvoke, Long.valueOf(j));
                obj = objInvoke;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return I6.a.e(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3108a == dVar.f3108a && this.f3109b == dVar.f3109b && this.f3110c == dVar.f3110c && Float.compare(dVar.f3111d, this.f3111d) == 0;
    }

    public final int hashCode() {
        int i9 = this.f3108a * 31;
        long j = this.f3109b;
        int i10 = (i9 + ((int) (j ^ (j >>> 32)))) * 31;
        long j8 = this.f3110c;
        return i10 + ((int) (j8 ^ (j8 >>> 32)));
    }

    public final String toString() {
        StringBuilder sbB = p171w.a.b("Request[");
        long j = this.f3109b;
        if (j != Long.MAX_VALUE) {
            sbB.append("@");
            e.a(j, sbB);
            int i9 = this.f3108a;
            if (i9 == 100) {
                sbB.append(" HIGH_ACCURACY");
            } else if (i9 == 102) {
                sbB.append(" BALANCED");
            } else if (i9 == 104) {
                sbB.append(" LOW_POWER");
            }
        } else {
            sbB.append("PASSIVE");
        }
        long j8 = this.f3110c;
        if (j8 != -1 && j8 < j) {
            sbB.append(", minUpdateInterval=");
            e.a(j8, sbB);
        }
        float f6 = this.f3111d;
        if (f6 > 0.0d) {
            sbB.append(", minUpdateDistance=");
            sbB.append(f6);
        }
        if (0 > j) {
            sbB.append(", maxUpdateDelay=");
            e.a(0L, sbB);
        }
        sbB.append(']');
        return sbB.toString();
    }
}
