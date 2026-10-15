package A4;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: PackageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f1475a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f1476b = new ConcurrentHashMap();

    public static boolean a(Context context, String str) {
        boolean zEquals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        ConcurrentHashMap concurrentHashMap = f1475a;
        synchronized (concurrentHashMap) {
            try {
                if (!concurrentHashMap.containsKey(str2)) {
                    try {
                        concurrentHashMap.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, Http2.INITIAL_MAX_FRAME_SIZE) != null));
                    } catch (Throwable unused) {
                        f1475a.put(str2, Boolean.FALSE);
                    }
                }
                zEquals = Boolean.TRUE.equals(f1475a.get(str2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return zEquals;
    }

    public static PackageInfo b(int i9, String str, Context context) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i9 + Constants.COLON_SEPARATOR + context.hashCode() + "@" + str;
        ConcurrentHashMap concurrentHashMap = f1476b;
        synchronized (concurrentHashMap) {
            if (!concurrentHashMap.containsKey(str2)) {
                try {
                    concurrentHashMap.put(str2, context.getPackageManager().getPackageInfo(str, i9));
                } catch (Throwable unused) {
                }
            }
            packageInfo = (PackageInfo) f1476b.get(str2);
        }
        return packageInfo;
    }

    public static String c(Context context) {
        PackageInfo packageInfoB = b(0, context.getPackageName(), context);
        return packageInfoB != null ? packageInfoB.versionName : "";
    }
}
