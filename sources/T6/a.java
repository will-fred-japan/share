package T6;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import com.engagelab.privates.common.constants.MTCommonConstants;
import kotlin.jvm.internal.k;
import p096m7.c;
import p096m7.l;

/* JADX INFO: compiled from: DeviceInfoPlusPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements p042f7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f4566a;

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b binding) {
        k.e(binding, "binding");
        c cVar = binding.f18713c;
        k.d(cVar, "getBinaryMessenger(...)");
        Context context = binding.f18711a;
        k.d(context, "getApplicationContext(...)");
        this.f4566a = new l(cVar, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        k.d(packageManager, "getPackageManager(...)");
        Object systemService = context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
        k.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ContentResolver contentResolver = context.getContentResolver();
        k.b(contentResolver);
        b bVar = new b(packageManager, (ActivityManager) systemService, contentResolver);
        l lVar = this.f4566a;
        if (lVar != null) {
            lVar.b(bVar);
        } else {
            k.i("methodChannel");
            throw null;
        }
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b binding) {
        k.e(binding, "binding");
        l lVar = this.f4566a;
        if (lVar != null) {
            lVar.b(null);
        } else {
            k.i("methodChannel");
            throw null;
        }
    }
}
