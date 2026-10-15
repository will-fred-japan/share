package R0;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DeviceRegisterParameterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile ConcurrentHashMap<f, i> f3947c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile V0.c f3948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public U0.a f3949b;

    public static void a(Context context) {
        V0.m.a("DeviceRegisterParameterFactory isNewUserMode false. context=" + context + " isDebugChannel()=false", null);
    }
}
