package W0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: compiled from: HWOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5001a = new a(1);

    /* JADX INFO: compiled from: HWOaidImpl.java */
    public static class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            return Boolean.valueOf(A4.c.a((Context) objArr[0], "com.huawei.hwid"));
        }
    }

    /* JADX INFO: compiled from: HWOaidImpl.java */
    public static class b extends l.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5002c = 0;
    }

    @Override // W0.l
    public final l.a a(Context context) {
        b bVar = new b();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                bVar.f5014a = string;
                bVar.f5015b = Boolean.parseBoolean(string2);
                bVar.f5002c = 202003021704L;
                return bVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Pair pair = (Pair) new s(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new g()).a();
        if (pair != null) {
            bVar.f5014a = (String) pair.first;
            bVar.f5015b = ((Boolean) pair.second).booleanValue();
            int i9 = 0;
            try {
                PackageInfo packageInfoB = A4.c.b(0, "com.huawei.hwid", context);
                if (packageInfoB != null) {
                    i9 = packageInfoB.versionCode;
                }
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            bVar.f5002c = i9;
        }
        return bVar;
    }

    @Override // W0.l
    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) f5001a.b(context)).booleanValue();
    }
}
