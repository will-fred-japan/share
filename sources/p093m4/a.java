package p093m4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.UUID;
import p144s4.d;
import p152t4.p;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile UUID f20342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f20343b = "";

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public a(Context context) {
        String strD;
        if (f20342a == null) {
            synchronized (a.class) {
                if (f20342a == null) {
                    p pVarB = p.b();
                    pVarB.getClass();
                    String string = null;
                    try {
                        strD = d.d(pVarB.f21456c.getAbsolutePath());
                    } catch (Throwable unused) {
                        strD = null;
                    }
                    if (strD != null) {
                        f20342a = UUID.fromString(strD);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused2) {
                        }
                        try {
                            f20342a = string != null ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                        } catch (Throwable unused3) {
                        }
                        try {
                            p pVarB2 = p.b();
                            String string2 = f20342a.toString();
                            pVarB2.getClass();
                            d.h(pVarB2.f21456c, string2, false);
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        try {
            if (TextUtils.isEmpty(f20343b)) {
                new a(context);
                UUID uuid = f20342a;
                if (uuid != null) {
                    f20343b = uuid.toString();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f20343b;
    }
}
