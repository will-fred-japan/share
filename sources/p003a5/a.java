package p003a5;

import S4.P;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import p027d5.c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5681a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f5682b;

    public final void a(Context context, P p8) {
        try {
            context.unbindService(p8);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    @ResultIgnorabilityUnspecified
    public final boolean b(Context context, String str, Intent intent, P p8, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((c.a(context).f18524a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (executor == null) {
            executor = null;
        }
        return (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, p8, 4225) : context.bindService(intent, 4225, executor, p8);
    }
}
