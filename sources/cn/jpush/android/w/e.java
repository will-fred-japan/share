package cn.jpush.android.w;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.p;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11746a = cn.jpush.android.ad.e.b(new byte[]{32, 0, 14, 41, 38, 38, Utf8.REPLACEMENT_BYTE, 1, 23, 43});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11747b = cn.jpush.android.ad.e.b(new byte[]{66, 93, 99});

    public static d a(Context context, c cVar) {
        return a(context, cVar, true, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0219 A[Catch: all -> 0x0225, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0229 A[Catch: all -> 0x0225, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:106:0x022d A[Catch: all -> 0x0225, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0236 A[Catch: all -> 0x0225, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:109:0x023a A[Catch: all -> 0x0225, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0242 A[Catch: all -> 0x0225, TRY_LEAVE, TryCatch #4 {all -> 0x0225, blocks: (B:98:0x020c, B:100:0x0219, B:101:0x0221, B:110:0x0242, B:104:0x0229, B:106:0x022d, B:107:0x0236, B:109:0x023a), top: B:127:0x020c }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0260  */
    /* JADX WARN: Code duplicated, block: B:50:0x0130  */
    /* JADX WARN: Code duplicated, block: B:66:0x016e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0193 A[Catch: all -> 0x0184, IOException -> 0x0188, MalformedURLException -> 0x018c, TryCatch #13 {MalformedURLException -> 0x018c, IOException -> 0x0188, all -> 0x0184, blocks: (B:57:0x0155, B:70:0x0175, B:72:0x017b, B:80:0x0193, B:82:0x01a3), top: B:140:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bf A[PHI: r1 r3 r10 r12
  0x01bf: PHI (r1v10 ??) = (r1v25 ??), (r1v26 ??), (r1v27 ??) binds: [B:93:0x0204, B:116:0x028a, B:83:0x01b6] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r3v10 java.io.OutputStream) = (r3v22 java.io.OutputStream), (r3v23 java.io.OutputStream), (r3v24 java.io.OutputStream) binds: [B:93:0x0204, B:116:0x028a, B:83:0x01b6] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r10v8 java.io.InputStream) = (r10v3 java.io.InputStream), (r10v6 java.io.InputStream), (r10v15 java.io.InputStream) binds: [B:93:0x0204, B:116:0x028a, B:83:0x01b6] A[DONT_GENERATE, DONT_INLINE]
  0x01bf: PHI (r12v11 java.net.HttpURLConnection) = (r12v14 java.net.HttpURLConnection), (r12v15 java.net.HttpURLConnection), (r12v16 java.net.HttpURLConnection) binds: [B:93:0x0204, B:116:0x028a, B:83:0x01b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:110:0x0242, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.jpush.android.w.c] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static d a(Context context, c cVar, boolean z8, boolean z9) throws Throwable {
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        InputStream inputStream3;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection2;
        String str;
        HttpURLConnection httpURLConnection3;
        OutputStream outputStream3;
        ?? r8;
        InputStream inputStream4;
        OutputStream outputStream4;
        HttpsURLConnection httpsURLConnection;
        HostnameVerifier aVar;
        int length;
        OutputStream outputStream5;
        byte[] bArrA;
        int i9;
        ?? r9;
        String str2;
        ?? r10 = cVar;
        ?? r11 = 1;
        InputStream errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        HttpURLConnection httpURLConnection4 = null;
        errorStream = null;
        if (r10 == 0) {
            return null;
        }
        d dVar = new d(r10.a());
        if (JCoreHelper.isAuth(context)) {
            ?? IsContinueBusiness = JCoreHelper.isContinueBusiness(context);
            Logger.w("HttpUtils", " https sdk continueBusiness=" + IsContinueBusiness);
            try {
                if (IsContinueBusiness != 0) {
                    try {
                        HttpURLConnection httpURLConnectionA = a(context, r10.a());
                        try {
                            URL url = httpURLConnectionA.getURL();
                            Logger.v("HttpUtils", "host:" + url.getHost() + ",port:" + url.getPort());
                            a((c) r10, httpURLConnectionA);
                            if (httpURLConnectionA instanceof HttpsURLConnection) {
                                try {
                                    if (r10.f() != null) {
                                        SSLContext sSLContext = SSLContext.getInstance(f11747b);
                                        sSLContext.init(null, new TrustManager[]{r10.f()}, new SecureRandom());
                                        ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(sSLContext.getSocketFactory());
                                    }
                                    if (r10.g() != null) {
                                        httpsURLConnection = (HttpsURLConnection) httpURLConnectionA;
                                        aVar = r10.g();
                                    } else {
                                        httpsURLConnection = (HttpsURLConnection) httpURLConnectionA;
                                        aVar = new a(httpURLConnectionA.getURL().getHost());
                                    }
                                    httpsURLConnection.setHostnameVerifier(aVar);
                                } catch (Throwable th) {
                                    Logger.ww("HttpUtils", "set ssl config error:" + th.getMessage());
                                }
                            }
                            if (z8 || z9) {
                                httpURLConnectionA.setRequestMethod(z9 ? "PUT" : HttpRequestBean.METHOD_POST);
                                httpURLConnectionA.setDoOutput(true);
                                httpURLConnectionA.setDoInput(true);
                                httpURLConnectionA.setUseCaches(r10.d());
                                byte[] bArrH = r10.h();
                                if (bArrH != null) {
                                    length = bArrH.length;
                                    outputStream5 = httpURLConnectionA.getOutputStream();
                                    try {
                                        outputStream5.write(bArrH);
                                        outputStream5 = outputStream5;
                                    } catch (MalformedURLException e9) {
                                        e = e9;
                                        inputStream3 = null;
                                        outputStream2 = outputStream5;
                                        httpURLConnection2 = httpURLConnectionA;
                                        Logger.w("HttpUtils", "http post  error:" + e.getMessage());
                                        dVar.a(3004);
                                        dVar.a("MalformedURLException");
                                        p.a((Closeable) errorStream);
                                        p.a((Closeable) inputStream3);
                                        p.a(outputStream2);
                                        r8 = inputStream3;
                                        outputStream3 = outputStream2;
                                        httpURLConnection3 = httpURLConnection2;
                                        r10 = inputStream3;
                                        r11 = outputStream2;
                                        IsContinueBusiness = httpURLConnection2;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection3.disconnect();
                                            r10 = r8;
                                            r11 = outputStream3;
                                            IsContinueBusiness = httpURLConnection3;
                                        }
                                        return dVar;
                                    } catch (IOException e10) {
                                        e = e10;
                                        inputStream4 = null;
                                        inputStream2 = null;
                                        outputStream4 = outputStream5;
                                        httpURLConnection4 = httpURLConnectionA;
                                        r10 = inputStream4;
                                        r11 = outputStream4;
                                        try {
                                            dVar.a(MTCoreConstants.RemoteWhat.ON_TCP_DISCONNECTED);
                                            dVar.a("网络错误");
                                            if (e instanceof SocketTimeoutException) {
                                                dVar.a(3001);
                                                str = "请求超时";
                                            } else {
                                                if (e instanceof UnknownHostException) {
                                                    if (e instanceof SSLHandshakeException) {
                                                        dVar.a(3005);
                                                        str = "SSL失败";
                                                    } else {
                                                        Logger.w("HttpUtils", "http post IOException error:" + e.getMessage());
                                                        p.a((Closeable) inputStream2);
                                                        p.a((Closeable) r10);
                                                        p.a((Closeable) r11);
                                                        if (httpURLConnection4 != null) {
                                                            httpURLConnection4.disconnect();
                                                        }
                                                    }
                                                    return dVar;
                                                }
                                                dVar.a(3003);
                                                str = "域名无效";
                                            }
                                            dVar.a(str);
                                            Logger.w("HttpUtils", "http post IOException error:" + e.getMessage());
                                            p.a((Closeable) inputStream2);
                                            p.a((Closeable) r10);
                                            p.a((Closeable) r11);
                                            if (httpURLConnection4 != null) {
                                                httpURLConnection4.disconnect();
                                            }
                                            return dVar;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            IsContinueBusiness = httpURLConnection4;
                                            errorStream = inputStream2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = null;
                                        outputStream = outputStream5;
                                        httpURLConnection = httpURLConnectionA;
                                        Logger.w("HttpUtils", "http post Exception error:" + th);
                                        dVar.a(3006);
                                        dVar.a("UNKnow execption" + th.getMessage());
                                        p.a((Closeable) errorStream);
                                        p.a((Closeable) inputStream);
                                        p.a(outputStream);
                                        r8 = inputStream;
                                        outputStream3 = outputStream;
                                        httpURLConnection3 = httpURLConnection;
                                        r10 = inputStream;
                                        r11 = outputStream;
                                        IsContinueBusiness = httpURLConnection;
                                        if (httpURLConnection != null) {
                                            httpURLConnection3.disconnect();
                                            r10 = r8;
                                            r11 = outputStream3;
                                            IsContinueBusiness = httpURLConnection3;
                                        }
                                        return dVar;
                                    }
                                } else {
                                    outputStream5 = null;
                                    length = 0;
                                }
                                int responseCode = httpURLConnectionA.getResponseCode();
                                dVar.a(responseCode);
                                try {
                                    inputStream2 = httpURLConnectionA.getInputStream();
                                } catch (Throwable th4) {
                                    Logger.d("HttpUtils", "get input stream error:" + th4.getMessage());
                                    inputStream2 = null;
                                }
                                try {
                                    if (r10.j() || inputStream2 == null) {
                                        bArrA = null;
                                    } else {
                                        try {
                                            bArrA = a(inputStream2);
                                            if (bArrA != null) {
                                                try {
                                                    if (r10.k()) {
                                                        bArrA = p.a(bArrA);
                                                    }
                                                } catch (Throwable unused) {
                                                }
                                            }
                                        } catch (Throwable unused2) {
                                            bArrA = null;
                                        }
                                    }
                                    if (bArrA == null && responseCode != 200 && r10.e()) {
                                        errorStream = httpURLConnectionA.getErrorStream();
                                        bArrA = a(errorStream);
                                    }
                                    if (bArrA != null) {
                                        int length2 = bArrA.length;
                                        dVar.a(new String(bArrA, "UTF-8"));
                                        i9 = length2;
                                        r9 = "UTF-8";
                                    } else {
                                        i9 = 0;
                                        r9 = r10;
                                    }
                                    JCoreHelper.netMonitor(context, cVar.a(), cVar.l(), length, i9);
                                    a(httpURLConnectionA, dVar);
                                    p.a((Closeable) inputStream2);
                                    p.a((Closeable) errorStream);
                                    p.a(outputStream5);
                                    r8 = r9;
                                    outputStream3 = outputStream5;
                                    httpURLConnection3 = httpURLConnectionA;
                                } catch (MalformedURLException e11) {
                                    e = e11;
                                    inputStream3 = errorStream;
                                    errorStream = inputStream2;
                                    outputStream2 = outputStream5;
                                    httpURLConnection2 = httpURLConnectionA;
                                    Logger.w("HttpUtils", "http post  error:" + e.getMessage());
                                    dVar.a(3004);
                                    dVar.a("MalformedURLException");
                                    p.a((Closeable) errorStream);
                                    p.a((Closeable) inputStream3);
                                    p.a(outputStream2);
                                    r8 = inputStream3;
                                    outputStream3 = outputStream2;
                                    httpURLConnection3 = httpURLConnection2;
                                    r10 = inputStream3;
                                    r11 = outputStream2;
                                    IsContinueBusiness = httpURLConnection2;
                                    if (httpURLConnection2 != null) {
                                    }
                                    return dVar;
                                } catch (IOException e12) {
                                    e = e12;
                                    inputStream4 = errorStream;
                                    outputStream4 = outputStream5;
                                    httpURLConnection4 = httpURLConnectionA;
                                    r10 = inputStream4;
                                    r11 = outputStream4;
                                    dVar.a(MTCoreConstants.RemoteWhat.ON_TCP_DISCONNECTED);
                                    dVar.a("网络错误");
                                    if (e instanceof SocketTimeoutException) {
                                        dVar.a(3001);
                                        str = "请求超时";
                                    } else {
                                        if (e instanceof UnknownHostException) {
                                            if (e instanceof SSLHandshakeException) {
                                                dVar.a(3005);
                                                str = "SSL失败";
                                            } else {
                                                Logger.w("HttpUtils", "http post IOException error:" + e.getMessage());
                                                p.a((Closeable) inputStream2);
                                                p.a((Closeable) r10);
                                                p.a((Closeable) r11);
                                                if (httpURLConnection4 != null) {
                                                    httpURLConnection4.disconnect();
                                                }
                                            }
                                            return dVar;
                                        }
                                        dVar.a(3003);
                                        str = "域名无效";
                                    }
                                    dVar.a(str);
                                    Logger.w("HttpUtils", "http post IOException error:" + e.getMessage());
                                    p.a((Closeable) inputStream2);
                                    p.a((Closeable) r10);
                                    p.a((Closeable) r11);
                                    if (httpURLConnection4 != null) {
                                        httpURLConnection4.disconnect();
                                    }
                                    return dVar;
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream = errorStream;
                                    errorStream = inputStream2;
                                    outputStream = outputStream5;
                                    httpURLConnection = httpURLConnectionA;
                                    Logger.w("HttpUtils", "http post Exception error:" + th);
                                    dVar.a(3006);
                                    dVar.a("UNKnow execption" + th.getMessage());
                                    p.a((Closeable) errorStream);
                                    p.a((Closeable) inputStream);
                                    p.a(outputStream);
                                    r8 = inputStream;
                                    outputStream3 = outputStream;
                                    httpURLConnection3 = httpURLConnection;
                                    r10 = inputStream;
                                    r11 = outputStream;
                                    IsContinueBusiness = httpURLConnection;
                                    if (httpURLConnection != null) {
                                    }
                                    return dVar;
                                }
                                httpURLConnection3.disconnect();
                                r10 = r8;
                                r11 = outputStream3;
                                IsContinueBusiness = httpURLConnection3;
                            } else {
                                outputStream5 = null;
                                length = 0;
                                int responseCode2 = httpURLConnectionA.getResponseCode();
                                dVar.a(responseCode2);
                                inputStream2 = httpURLConnectionA.getInputStream();
                                if (r10.j()) {
                                    bArrA = null;
                                } else {
                                    bArrA = null;
                                }
                                if (bArrA == null) {
                                    errorStream = httpURLConnectionA.getErrorStream();
                                    bArrA = a(errorStream);
                                }
                                if (bArrA != null) {
                                    int length3 = bArrA.length;
                                    dVar.a(new String(bArrA, "UTF-8"));
                                    i9 = length3;
                                    r9 = "UTF-8";
                                } else {
                                    i9 = 0;
                                    r9 = r10;
                                }
                                JCoreHelper.netMonitor(context, cVar.a(), cVar.l(), length, i9);
                                a(httpURLConnectionA, dVar);
                                p.a((Closeable) inputStream2);
                                p.a((Closeable) errorStream);
                                p.a(outputStream5);
                                r8 = r9;
                                outputStream3 = outputStream5;
                                httpURLConnection3 = httpURLConnectionA;
                                httpURLConnection3.disconnect();
                                r10 = r8;
                                r11 = outputStream3;
                                IsContinueBusiness = httpURLConnection3;
                            }
                        } catch (MalformedURLException e13) {
                            e = e13;
                            inputStream3 = null;
                            outputStream2 = null;
                            httpURLConnection2 = httpURLConnectionA;
                        } catch (IOException e14) {
                            e = e14;
                            inputStream4 = null;
                            outputStream4 = null;
                            inputStream2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = null;
                            outputStream = null;
                            httpURLConnection = httpURLConnectionA;
                        }
                    } catch (MalformedURLException e15) {
                        e = e15;
                        inputStream3 = null;
                        outputStream2 = null;
                        httpURLConnection2 = null;
                    } catch (IOException e16) {
                        e = e16;
                        r10 = 0;
                        r11 = 0;
                        inputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream = null;
                        outputStream = null;
                        httpURLConnection = null;
                    }
                    return dVar;
                }
                Logger.w("HttpUtils", " https sdk limit");
                dVar.a(3006);
                str2 = "https sdk limit";
            } catch (Throwable th8) {
                th = th8;
            }
            p.a((Closeable) errorStream);
            p.a((Closeable) r10);
            p.a((Closeable) r11);
            if (IsContinueBusiness != 0) {
                IsContinueBusiness.disconnect();
            }
            throw th;
        }
        dVar.a(3006);
        str2 = "user not auth!!!";
        dVar.a(str2);
        return dVar;
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return sb.toString();
    }

    public static HttpURLConnection a(Context context, String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private static void a(c cVar, HttpURLConnection httpURLConnection) {
        if (cVar == null || httpURLConnection == null) {
            return;
        }
        a(cVar.i(), httpURLConnection);
        if (cVar.b() >= 0) {
            httpURLConnection.setConnectTimeout(cVar.b());
        }
        if (cVar.c() >= 0) {
            httpURLConnection.setReadTimeout(cVar.c());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, d dVar) {
        if (dVar == null || httpURLConnection == null) {
            return;
        }
        dVar.a(httpURLConnection.getResponseCode());
        dVar.b(httpURLConnection.getResponseCode());
        dVar.a("expires", httpURLConnection.getHeaderField("Expires"));
        dVar.a("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        return p.b(inputStream);
    }
}
