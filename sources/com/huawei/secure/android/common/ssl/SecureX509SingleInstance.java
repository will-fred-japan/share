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
public class SecureX509SingleInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15857a = "SecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f15858b;

    private SecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) {
        InputStream inputStreamOpen;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f15858b == null) {
            synchronized (SecureX509SingleInstance.class) {
                if (f15858b == null) {
                    try {
                        inputStreamOpen = BksUtil.getFilesBksIS(context);
                    } catch (RuntimeException unused) {
                        e.b(f15857a, "get files bks error");
                        inputStreamOpen = null;
                    }
                    if (inputStreamOpen == null) {
                        e.c(f15857a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.c(f15857a, "get files bks");
                    }
                    f15858b = new SecureX509TrustManager(inputStreamOpen, "");
                }
            }
        }
        f.j(jCurrentTimeMillis, new StringBuilder("SecureX509TrustManager getInstance: cost : "), " ms", f15857a);
        return f15858b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f15857a;
        e.c(str, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f15858b != null) {
            f15858b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f15858b);
            SecureApacheSSLSocketFactory.a(f15858b);
        }
        e.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f15857a;
        e.c(str, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f15858b != null) {
            f15858b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f15858b, secureRandom);
            SecureApacheSSLSocketFactory.a(f15858b, secureRandom);
        }
        e.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }
}
