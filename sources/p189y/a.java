package p189y;

import W5.e;
import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* JADX INFO: compiled from: Debug.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(Context context, int i9) {
        if (i9 == -1) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i9);
        } catch (Exception unused) {
            return e.i(i9, "?");
        }
    }
}
