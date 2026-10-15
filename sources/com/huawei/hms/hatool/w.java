package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static n0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, HttpRequestBean.METHOD_POST);
    }

    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            return k1.a(inputStream);
        } catch (IOException unused) {
            v.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
            return "";
        } finally {
            k1.a((Closeable) inputStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:76:0x010e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0129  */
    /* JADX WARN: Code duplicated, block: B:90:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0151  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    public static n0 a(String str, byte[] bArr, Map<String, String> map, String str2) throws Throwable {
        HttpURLConnection httpURLConnectionA;
        ?? bufferedOutputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        if (TextUtils.isEmpty(str)) {
            return new n0(-100, "");
        }
        String str3 = null;
        int responseCode = -102;
        try {
            try {
                httpURLConnectionA = a(str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (httpURLConnectionA == null) {
                        n0 n0Var = new n0(-101, "");
                        k1.a((Closeable) null);
                        k1.a((Closeable) null);
                        if (httpURLConnectionA != null) {
                            k1.a(httpURLConnectionA);
                        }
                        return n0Var;
                    }
                    map = httpURLConnectionA.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(map);
                        try {
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            responseCode = httpURLConnectionA.getResponseCode();
                            n0 n0Var2 = new n0(responseCode, b(httpURLConnectionA));
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            k1.a(httpURLConnectionA);
                            return n0Var2;
                        } catch (a unused) {
                            httpURLConnection7 = httpURLConnectionA;
                            v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                            n0 n0Var3 = new n0(-101, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection7 != null) {
                                k1.a(httpURLConnection7);
                            }
                            return n0Var3;
                        } catch (SecurityException unused2) {
                            httpURLConnection6 = httpURLConnectionA;
                            v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                            n0 n0Var4 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection6 != null) {
                                k1.a(httpURLConnection6);
                            }
                            return n0Var4;
                        } catch (ConnectException unused3) {
                            httpURLConnection5 = httpURLConnectionA;
                            v.f("hmsSdk", "Network is unreachable or Connection refused");
                            n0 n0Var5 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection5 != null) {
                                k1.a(httpURLConnection5);
                            }
                            return n0Var5;
                        } catch (UnknownHostException unused4) {
                            httpURLConnection4 = httpURLConnectionA;
                            v.f("hmsSdk", "No address associated with hostname or No network");
                            n0 n0Var6 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection4 != null) {
                                k1.a(httpURLConnection4);
                            }
                            return n0Var6;
                        } catch (SSLHandshakeException unused5) {
                            httpURLConnection3 = httpURLConnectionA;
                            v.f("hmsSdk", "Chain validation failed,Certificate expired");
                            n0 n0Var7 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection3 != null) {
                                k1.a(httpURLConnection3);
                            }
                            return n0Var7;
                        } catch (SSLPeerUnverifiedException unused6) {
                            httpURLConnection2 = httpURLConnectionA;
                            v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                            n0 n0Var8 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection2 != null) {
                                k1.a(httpURLConnection2);
                            }
                            return n0Var8;
                        } catch (IOException unused7) {
                            httpURLConnection = httpURLConnectionA;
                            v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                            n0 n0Var9 = new n0(responseCode, "");
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnection != null) {
                                k1.a(httpURLConnection);
                            }
                            return n0Var9;
                        } catch (Throwable th) {
                            th = th;
                            k1.a((Closeable) bufferedOutputStream);
                            k1.a((Closeable) map);
                            if (httpURLConnectionA != null) {
                                k1.a(httpURLConnectionA);
                            }
                            throw th;
                        }
                    } catch (a unused8) {
                        bufferedOutputStream = 0;
                        httpURLConnection7 = httpURLConnectionA;
                        v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        n0 n0Var10 = new n0(-101, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection7 != null) {
                            k1.a(httpURLConnection7);
                        }
                        return n0Var10;
                    } catch (SecurityException unused9) {
                        bufferedOutputStream = 0;
                        httpURLConnection6 = httpURLConnectionA;
                        v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                        n0 n0Var11 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection6 != null) {
                            k1.a(httpURLConnection6);
                        }
                        return n0Var11;
                    } catch (ConnectException unused10) {
                        bufferedOutputStream = 0;
                        httpURLConnection5 = httpURLConnectionA;
                        v.f("hmsSdk", "Network is unreachable or Connection refused");
                        n0 n0Var12 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection5 != null) {
                            k1.a(httpURLConnection5);
                        }
                        return n0Var12;
                    } catch (UnknownHostException unused11) {
                        bufferedOutputStream = 0;
                        httpURLConnection4 = httpURLConnectionA;
                        v.f("hmsSdk", "No address associated with hostname or No network");
                        n0 n0Var13 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection4 != null) {
                            k1.a(httpURLConnection4);
                        }
                        return n0Var13;
                    } catch (SSLHandshakeException unused12) {
                        bufferedOutputStream = 0;
                        httpURLConnection3 = httpURLConnectionA;
                        v.f("hmsSdk", "Chain validation failed,Certificate expired");
                        n0 n0Var14 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection3 != null) {
                            k1.a(httpURLConnection3);
                        }
                        return n0Var14;
                    } catch (SSLPeerUnverifiedException unused13) {
                        bufferedOutputStream = 0;
                        httpURLConnection2 = httpURLConnectionA;
                        v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                        n0 n0Var15 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection2 != null) {
                            k1.a(httpURLConnection2);
                        }
                        return n0Var15;
                    } catch (IOException unused14) {
                        bufferedOutputStream = 0;
                        httpURLConnection = httpURLConnectionA;
                        v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                        n0 n0Var16 = new n0(responseCode, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection != null) {
                            k1.a(httpURLConnection);
                        }
                        return n0Var16;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = str3;
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnectionA != null) {
                            k1.a(httpURLConnectionA);
                        }
                        throw th;
                    }
                } catch (a unused15) {
                    map = 0;
                } catch (SecurityException unused16) {
                    map = 0;
                } catch (ConnectException unused17) {
                    map = 0;
                } catch (UnknownHostException unused18) {
                    map = 0;
                } catch (SSLHandshakeException unused19) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused20) {
                    map = 0;
                } catch (IOException unused21) {
                    map = 0;
                } catch (Throwable th3) {
                    th = th3;
                    map = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnectionA = null;
                str3 = str2;
            }
        } catch (a unused22) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SecurityException unused23) {
            httpURLConnectionA = null;
            map = 0;
        } catch (ConnectException unused24) {
            httpURLConnectionA = null;
            map = 0;
        } catch (UnknownHostException unused25) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SSLHandshakeException unused26) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SSLPeerUnverifiedException unused27) {
            httpURLConnectionA = null;
            map = 0;
        } catch (IOException unused28) {
            httpURLConnectionA = null;
            map = 0;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnectionA = null;
            map = 0;
        }
    }

    private static HttpURLConnection a(String str, int i9, Map<String, String> map, String str2) throws ProtocolException, a {
        if (TextUtils.isEmpty(str)) {
            v.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i9));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) throws a {
        String str;
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(q0.i());
            } catch (IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (IllegalAccessException unused2) {
                str = "getSocketFactory(): Illegal Access Exception ";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (KeyStoreException unused3) {
                str = "getSocketFactory(): Key Store exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (NoSuchAlgorithmException unused4) {
                str = "getSocketFactory(): Algorithm Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (GeneralSecurityException unused5) {
                str = "getSocketFactory(): General Security Exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            }
            if (secureSSLSocketFactory == null) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }
}
