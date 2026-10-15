package Z6;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: ContentSizingFlag.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static boolean a(Context context) {
        Bundle bundle;
        Context applicationContext = context.getApplicationContext();
        try {
            bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("ContentSizingFlag", "Could not get metadata");
            bundle = null;
        }
        if (bundle != null) {
            return bundle.getBoolean("io.flutter.embedding.android.EnableContentSizing", false);
        }
        return false;
    }
}
