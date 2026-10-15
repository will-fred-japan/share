package androidx.appcompat.app;

import android.content.Context;
import android.location.LocationManager;

/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static r f6003d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f6005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6006c = new a();

    /* JADX INFO: compiled from: TwilightManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6008b;
    }

    public r(Context context, LocationManager locationManager) {
        this.f6004a = context;
        this.f6005b = locationManager;
    }
}
