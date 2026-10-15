package S4;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: renamed from: S4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0377h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0377h f4191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f4192c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f4193a;

    public static synchronized C0377h a() {
        try {
            if (f4191b == null) {
                f4191b = new C0377h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4191b;
    }
}
