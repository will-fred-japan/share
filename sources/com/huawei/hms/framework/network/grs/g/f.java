package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class f extends a implements Callable<d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15095i = "f";

    public f(String str, int i9, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        super(str, i9, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:78:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0044: MOVE (r7 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:14:0x0044 */
    @Override // java.util.concurrent.Callable
    public d call() throws Throwable {
        HttpsURLConnection httpsURLConnectionA;
        long j;
        HttpURLConnection httpURLConnection;
        long jCurrentTimeMillis;
        String str = f15095i;
        Logger.i(str, "Post call execute");
        long jCurrentTimeMillis2 = 0;
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        httpsURLConnectionA = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                        try {
                            if (httpsURLConnectionA == null) {
                                Logger.w(str, "create HttpsURLConnection instance by url return null.");
                                if (httpsURLConnectionA != null) {
                                    try {
                                        httpsURLConnectionA.disconnect();
                                        return null;
                                    } catch (RuntimeException unused) {
                                        Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                                    } catch (Throwable unused2) {
                                        Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                                    }
                                }
                                return null;
                            }
                            httpsURLConnectionA.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                            httpsURLConnectionA.setRequestProperty("Connection", "close");
                            httpsURLConnectionA.setRequestMethod(HttpRequestBean.METHOD_POST);
                            httpsURLConnectionA.setDoOutput(true);
                            httpsURLConnectionA.setDoInput(true);
                            String strA = b() != null ? b().a() : "";
                            if (TextUtils.isEmpty(strA)) {
                                strA = ContainerUtils.FIELD_DELIMITER;
                            }
                            httpsURLConnectionA.setRequestProperty("If-None-Match", strA);
                            httpsURLConnectionA.connect();
                            com.huawei.hms.framework.network.grs.h.f.a.a(httpsURLConnectionA, f().a("services", ""));
                            int responseCode = httpsURLConnectionA.getResponseCode();
                            Logger.i(str, "httpsURLConnection result code:" + responseCode);
                            if (responseCode == 200) {
                                try {
                                    inputStream = httpsURLConnectionA.getInputStream();
                                    byte[] byteArray = IoUtils.toByteArray(inputStream);
                                    IoUtils.closeSecure(inputStream);
                                    bArr = byteArray;
                                } catch (Throwable th) {
                                    IoUtils.closeSecure(inputStream);
                                    throw th;
                                }
                            }
                            Map<String, List<String>> headerFields = httpsURLConnectionA.getHeaderFields();
                            httpsURLConnectionA.disconnect();
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (bArr == null) {
                                bArr = new byte[0];
                            }
                            this.f15056a = new d(responseCode, headerFields, bArr, jElapsedRealtime2 - jElapsedRealtime);
                            try {
                                httpsURLConnectionA.disconnect();
                            } catch (RuntimeException unused3) {
                                Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                            } catch (Throwable unused4) {
                                Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                            }
                            long j8 = jCurrentTimeMillis;
                            this.f15056a.b(c());
                            this.f15056a.a(d());
                            this.f15056a.b(jCurrentTimeMillis2);
                            this.f15056a.a(j8);
                            if (b() != null) {
                                b().a(this.f15056a);
                            }
                            return this.f15056a;
                        } catch (IOException e9) {
                            e = e9;
                            j = jCurrentTimeMillis2;
                            jCurrentTimeMillis2 = jElapsedRealtime;
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            jCurrentTimeMillis = System.currentTimeMillis();
                            Logger.w(f15095i, "RequestCallableV2 run task catch IOException", e);
                            this.f15056a = new d(e, jElapsedRealtime3 - jCurrentTimeMillis2);
                            if (httpsURLConnectionA != null) {
                                try {
                                    httpsURLConnectionA.disconnect();
                                } catch (RuntimeException unused5) {
                                    jCurrentTimeMillis2 = j;
                                    Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                                } catch (Throwable unused6) {
                                    jCurrentTimeMillis2 = j;
                                    Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                                }
                            }
                            jCurrentTimeMillis2 = j;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        httpsURLConnectionA = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (RuntimeException unused7) {
                            Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused8) {
                            Logger.w(f15095i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            httpsURLConnectionA = null;
            j = 0;
        }
    }
}
