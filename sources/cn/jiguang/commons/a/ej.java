package cn.jiguang.commons.a;

import android.net.Network;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<WeakReference<SecureRandom>> f9965a = new ek();

    private static int a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return -1;
        }
        try {
            return httpURLConnection.getResponseCode();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static ei b(eh ehVar) {
        ei eiVar;
        String str;
        if (ehVar == null) {
            eiVar = new ei("");
            eiVar.a(-1);
            str = "request is null";
        } else {
            String strA = ehVar.a();
            if (TextUtils.isEmpty(strA)) {
                eiVar = new ei("");
                eiVar.a(-1);
                str = "url is null or empty";
            } else if (!ca.a().c()) {
                eiVar = new ei(strA);
                eiVar.a(-1);
                str = "no auth";
            } else {
                if (jf.c()) {
                    return c(ehVar);
                }
                eiVar = new ei(strA);
                eiVar.a(-1);
                str = "no network connection";
            }
        }
        eiVar.a(str);
        return eiVar;
    }

    private static ei c(eh ehVar) {
        ei eiVarD;
        String[] strArr;
        String str;
        String strA = ehVar.a();
        String strH = ehVar.h() != null ? ehVar.h() : HttpRequestBean.METHOD_POST;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i9 = 1;
        int i10 = 1;
        while (true) {
            if (i10 > 3) {
                ee.d("JHttpUtils", String.format("all retry attempts failed after %dms total time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                ei eiVar = new ei(strA);
                eiVar.a(-1);
                eiVar.a("all retry attempts failed");
                ehVar.a((Object) null);
                return eiVar;
            }
            try {
                ee.a("JHttpUtils", String.format("http request attempt %d/%d, method:%s, url:%s", Integer.valueOf(i10), 3, HttpRequestBean.METHOD_POST.equalsIgnoreCase(strH) ? HttpRequestBean.METHOD_POST : "other", strA));
                eiVarD = d(ehVar);
                if (eiVarD != null && eiVarD.c() == 200) {
                    ee.a("JHttpUtils", String.format("http request successful on attempt %d, total time:%dms", Integer.valueOf(i10), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    ehVar.a((Object) null);
                    return eiVarD;
                }
                if (i10 >= 3) {
                    break;
                }
                if (eiVarD != null) {
                    int iC = eiVarD.c();
                    if ((iC >= 200 && iC < 300) || ((iC >= 300 && iC < 400) || (iC >= 400 && iC < 500))) {
                        break;
                    }
                    if (iC < 500 || iC >= 600) {
                        if (iC < 0) {
                            String strA2 = eiVarD.a();
                            if (strA2 != null) {
                                String lowerCase = strA2.toLowerCase();
                                if (!lowerCase.contains("malformed url")) {
                                    if (!lowerCase.contains("invalid method")) {
                                        if (!lowerCase.contains("unable to resolve host")) {
                                            if (!lowerCase.contains("unknown host")) {
                                                if (lowerCase.contains("failed to create connection") && i10 > i9) {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    } else if (iC == 504 || i10 >= 2) {
                        break;
                    }
                }
                if (i10 < 3) {
                    long jMin = Math.min((long) (Math.pow(2.0d, i10 - 1) * 1000.0d), 30000L);
                    long jMax = Math.max(jMin + ((long) (jMin * 0.1d * (Math.random() - 0.5d))), 100L);
                    String strA3 = eiVarD.a();
                    Long lValueOf = Long.valueOf(jMax);
                    if (strA3 != null) {
                        str = ", error:" + strA3;
                    } else {
                        str = "";
                    }
                    ee.a("JHttpUtils", String.format("request failed, retrying in %dms%s", lValueOf, str));
                    try {
                        Thread.sleep(jMax);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    i9 = i9;
                }
                i10++;
                i9 = i9;
            } catch (Throwable th) {
                ehVar.a((Object) null);
                throw th;
            }
        }
        int i11 = i9;
        int iC2 = eiVarD.c();
        String strA4 = eiVarD.a();
        if (a(strA4)) {
            if (a(strA4)) {
                String[] strArrSplit = strA4.split("\\|", 3);
                strArr = strArrSplit.length < 3 ? null : new String[]{strArrSplit[i11], strArrSplit[2].replace("||", HiAnalyticsConstant.REPORT_VAL_SEPARATOR)};
            }
            if (strArr != null && strArr.length >= 2) {
                strA4 = strArr[i11];
            }
        }
        ee.d("JHttpUtils", String.format("not retrying on attempt %d, response code:%d, error:%s", Integer.valueOf(i10), Integer.valueOf(iC2), strA4));
        ehVar.a((Object) null);
        return eiVarD;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0223 A[Catch: all -> 0x0227, TRY_LEAVE, TryCatch #5 {all -> 0x0227, blocks: (B:116:0x020b, B:118:0x0211, B:120:0x0214, B:121:0x0223), top: B:143:0x020b, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ee A[Catch: all -> 0x00cc, TryCatch #7 {all -> 0x00cc, blocks: (B:39:0x00b1, B:41:0x00c5, B:46:0x00d2, B:48:0x00e2, B:50:0x00ee, B:51:0x00f2), top: B:146:0x00b1, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f2 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #7 {all -> 0x00cc, blocks: (B:39:0x00b1, B:41:0x00c5, B:46:0x00d2, B:48:0x00e2, B:50:0x00ee, B:51:0x00f2), top: B:146:0x00b1, outer: #0 }] */
    private static ei d(eh ehVar) {
        int iA;
        String string;
        SecureRandom secureRandom;
        String strA = ehVar.a();
        String strH = ehVar.h() != null ? ehVar.h() : HttpRequestBean.METHOD_GET;
        byte[] bArrF = ehVar.f();
        Map<String, String> mapG = ehVar.g();
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        try {
            Object objJ = ehVar.j();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) (objJ != null ? ((Network) objJ).openConnection(new URL(strA)) : new URL(strA).openConnection());
            try {
                httpURLConnection2.setRequestMethod(strH);
                httpURLConnection2.setConnectTimeout(ehVar.b() >= 0 ? ehVar.b() : 30000);
                httpURLConnection2.setReadTimeout(ehVar.c() >= 0 ? ehVar.c() : 30000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(ehVar.i());
                if (mapG != null && !mapG.isEmpty()) {
                    for (Map.Entry<String, String> entry : mapG.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key != null && value != null) {
                            httpURLConnection2.setRequestProperty(key, value);
                        }
                    }
                }
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                    X509TrustManager x509TrustManagerD = ehVar.d();
                    HostnameVerifier hostnameVerifierE = ehVar.e();
                    if (x509TrustManagerD != null) {
                        try {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            TrustManager[] trustManagerArr = {x509TrustManagerD};
                            ThreadLocal<WeakReference<SecureRandom>> threadLocal = f9965a;
                            WeakReference<SecureRandom> weakReference = threadLocal.get();
                            SecureRandom secureRandom2 = weakReference != null ? weakReference.get() : null;
                            if (secureRandom2 == null) {
                                secureRandom = new SecureRandom();
                                threadLocal.set(new WeakReference<>(secureRandom));
                            } else {
                                secureRandom = secureRandom2;
                            }
                            sSLContext.init(null, trustManagerArr, secureRandom);
                            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                            if (hostnameVerifierE != null) {
                                httpsURLConnection.setHostnameVerifier(hostnameVerifierE);
                            } else {
                                httpsURLConnection.setHostnameVerifier(new eg(httpsURLConnection.getURL().getHost()));
                            }
                        } catch (Throwable th) {
                            ee.d("JHttpUtils", "set ssl config error:" + th.getMessage());
                        }
                    } else if (hostnameVerifierE != null) {
                        httpsURLConnection.setHostnameVerifier(hostnameVerifierE);
                    } else {
                        httpsURLConnection.setHostnameVerifier(new eg(httpsURLConnection.getURL().getHost()));
                    }
                    try {
                        ee.d("JHttpUtils", "execute request error: " + th.getMessage());
                        ei eiVar = new ei(strA);
                        if (iA == -1) {
                            iA = a(httpURLConnection);
                        }
                        if (th instanceof el) {
                            a(eiVar, th);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                        } else if (httpURLConnection != null) {
                            try {
                                byte[] bArrA = a(httpURLConnection, iA, 10485760L);
                                if (bArrA == null || bArrA.length <= 0) {
                                    a(eiVar, th);
                                } else {
                                    eiVar.a(iA);
                                    eiVar.a(bArrA);
                                    eiVar.a(new String(bArrA, "UTF-8"));
                                }
                            } catch (Throwable unused2) {
                                a(eiVar, th);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } else {
                            a(eiVar, th);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                        return eiVar;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused3) {
                            }
                        }
                        throw th2;
                    }
                }
                if (bArrF != null && bArrF.length > 0) {
                    httpURLConnection2.setDoOutput(true);
                    try {
                        outputStream = httpURLConnection2.getOutputStream();
                        outputStream.write(bArrF);
                        outputStream.flush();
                        jv.a(outputStream);
                    } catch (Throwable th3) {
                        jv.a(outputStream);
                        throw th3;
                    }
                }
                iA = httpURLConnection2.getResponseCode();
                try {
                    ei eiVar2 = new ei(strA);
                    eiVar2.a(iA);
                    Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                    String str = "";
                    if (headerFields != null) {
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            if (entry2.getKey() != null) {
                                String key2 = entry2.getKey();
                                List<String> value2 = entry2.getValue();
                                if (value2 == null || value2.isEmpty()) {
                                    string = "";
                                } else if (value2.size() == 1) {
                                    string = value2.get(0);
                                } else {
                                    StringBuilder sb = new StringBuilder(value2.size() * 25);
                                    for (int i9 = 0; i9 < value2.size(); i9++) {
                                        if (i9 > 0) {
                                            sb.append(", ");
                                        }
                                        sb.append(value2.get(i9));
                                    }
                                    string = sb.toString();
                                }
                                eiVar2.a(key2, string);
                            }
                        }
                    }
                    byte[] bArrA2 = a(httpURLConnection2, iA, 10485760L);
                    eiVar2.a(bArrA2 != null ? bArrA2 : new byte[0]);
                    if (bArrA2 != null && bArrA2.length > 0) {
                        str = new String(bArrA2, "UTF-8");
                    }
                    eiVar2.a(str);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused4) {
                    }
                    return eiVar2;
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                iA = -1;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static ei a(eh ehVar) {
        if (ehVar == null) {
            return null;
        }
        ehVar.b(HttpRequestBean.METHOD_POST);
        return b(ehVar);
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "CLIENT_EXCEPTION|Unknown|null exception";
        }
        String name = th.getClass().getName();
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        return "CLIENT_EXCEPTION|" + name + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + message.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "||");
    }

    private static void a(ei eiVar, Throwable th) {
        eiVar.a(-1);
        try {
            String strA = a(th);
            eiVar.a(strA.getBytes("UTF-8"));
            eiVar.a(strA);
        } catch (Throwable unused) {
            eiVar.a(new byte[0]);
            eiVar.a("");
        }
    }

    private static boolean a(String str) {
        return str != null && str.startsWith("CLIENT_EXCEPTION|");
    }

    private static byte[] a(URLConnection uRLConnection, int i9, long j) {
        InputStream errorStream;
        InputStream inputStream;
        if (uRLConnection == null) {
            return new byte[0];
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        if (i9 == -1 || i9 >= 400) {
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Throwable unused) {
                errorStream = null;
            }
            if (errorStream == null) {
                try {
                    inputStream = uRLConnection.getInputStream();
                } catch (Throwable unused2) {
                    inputStream = errorStream;
                }
            } else {
                inputStream = errorStream;
            }
        } else {
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Throwable unused3) {
                inputStream = null;
            }
            if (inputStream == null) {
                try {
                    inputStream = httpURLConnection.getErrorStream();
                } catch (Throwable unused4) {
                }
            }
        }
        if (inputStream == null) {
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(1048576, 32768));
            byte[] bArr = new byte[4096];
            long j8 = 0;
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    jv.a(inputStream);
                    return byteArray;
                }
                j8 += (long) i10;
                if (j8 > 10485760) {
                    throw new el(j8, 10485760L);
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable unused5) {
            jv.a(inputStream);
            return null;
        }
    }
}
