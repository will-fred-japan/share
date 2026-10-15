package Q3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
    }
}
