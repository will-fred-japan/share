package V0;

import android.app.Application;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: GaidGetter.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f4814a;

    public static String a(Application application, R0.f fVar) {
        String id;
        if (TextUtils.isEmpty(f4814a)) {
            synchronized (f.class) {
                if (!TextUtils.isEmpty(f4814a)) {
                    return f4814a;
                }
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(application);
                    id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        th.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(id)) {
                    id = fVar.f3925e.getString("google_aid", null);
                } else if (!TextUtils.equals(fVar.f3925e.getString("google_aid", null), id) && !TextUtils.isEmpty(id)) {
                    fVar.f3925e.edit().putString("google_aid", id).apply();
                }
                f4814a = id;
            }
        }
        return f4814a;
    }
}
