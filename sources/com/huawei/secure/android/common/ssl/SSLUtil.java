package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public abstract class SSLUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15822a = "SSLUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15823b = "TLSv1.3";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15824c = "TLSv1.2";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15825d = "TLS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15826e = "TLSv1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f15827f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f15828g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f15829h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            e.c(f15822a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            e.c(f15822a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f15829h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null || setWhiteListCipherSuites(sSLSocket)) {
            return;
        }
        setBlackListCipherSuites(sSLSocket);
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{f15823b, f15824c});
        }
        if (i9 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f15824c});
        }
    }

    public static SSLContext setSSLContext() {
        return Build.VERSION.SDK_INT >= 29 ? SSLContext.getInstance(f15823b) : SSLContext.getInstance(f15824c);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        setEnabledProtocols(sSLSocket);
        setEnableSafeCipherSuites(sSLSocket);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setWhiteListCipherSuites(sSLSocket, f15828g);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = strArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    arrayList.add(str);
                    break;
                }
                if (upperCase.contains(strArr[i9].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i9++;
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (listAsList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e9) {
                e.b(f15822a, "setEnabledProtocols: exception : " + e9.getMessage());
            }
        }
        return false;
    }
}
