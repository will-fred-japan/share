package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import defpackage.f;
import java.io.InputStream;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class SSFSecureX509SingleInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15820a = "SSFSecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f15821b;

    private SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f15821b == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                try {
                    if (f15821b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            e.c(f15820a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            e.c(f15820a, "get files bks");
                        }
                        f15821b = new SecureX509TrustManager(filesBksIS, "", true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15821b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f15820a;
        e.c(str, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f15821b != null) {
            f15821b = new SecureX509TrustManager(inputStream, "", true);
            f.j(jCurrentTimeMillis, new StringBuilder("updateBks: new SecureX509TrustManager cost : "), " ms", str);
            SSFCompatiableSystemCA.a(f15821b);
            SASFCompatiableSystemCA.a(f15821b);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("update bks cost : "), " ms", str);
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f15820a;
        e.c(str, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f15821b != null) {
            f15821b = new SecureX509TrustManager(inputStream, "", true);
            f.j(jCurrentTimeMillis, new StringBuilder("updateBks: new SecureX509TrustManager cost : "), " ms", str);
            SSFCompatiableSystemCA.a(f15821b, secureRandom);
            SASFCompatiableSystemCA.a(f15821b, secureRandom);
        }
        f.j(jCurrentTimeMillis, new StringBuilder("update bks cost : "), " ms", str);
    }
}
