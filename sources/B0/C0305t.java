package B0;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* JADX INFO: renamed from: B0.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForTiramisu.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0305t {
    public static ServiceInfo a(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }

    public static PackageManager.ComponentInfoFlags b(long j) {
        return PackageManager.ComponentInfoFlags.of(j);
    }
}
