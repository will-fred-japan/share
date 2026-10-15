package B0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: StartupApiFeature.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f1606c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1608b;

    /* JADX INFO: compiled from: StartupApiFeature.java */
    public static class a extends F {
        @Override // B0.F
        public final boolean b() {
            return false;
        }
    }

    /* JADX INFO: compiled from: StartupApiFeature.java */
    public static class b extends F {
        @Override // B0.F
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public F(String str, String str2) {
        this.f1607a = str;
        this.f1608b = str2;
        f1606c.add(this);
    }

    public final boolean a(Context context) {
        if (!b()) {
            PackageInfo packageInfoB = A0.p.b(context);
            Bundle bundle = null;
            if (packageInfoB != null) {
                ComponentName componentName = new ComponentName(packageInfoB.packageName, "org.chromium.android_webview.services.StartupFeatureMetadataHolder");
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        bundle = C0305t.a(context.getPackageManager(), componentName, C0305t.b(640L)).metaData;
                    } else {
                        bundle = context.getPackageManager().getServiceInfo(componentName, 640).metaData;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (!(bundle == null ? false : bundle.containsKey(this.f1608b))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean b();
}
