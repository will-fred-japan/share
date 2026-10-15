package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import com.starburst.sdk.req.GuiControlRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<ay>> f17063a = new AtomicReference<>(m103a());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f133a = Pattern.compile("([^\\s;]+)(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f17064b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f17065c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static class a<T> extends FutureTask<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f17066a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            if (k.m649a(t.m835a())) {
                return true;
            }
            return isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f17066a) > 1800000;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f17066a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17067a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i9, int i10) {
            int i11;
            if (!this.f17067a && (i11 = super.read(bArr, i9, i10)) != -1) {
                return i11;
            }
            this.f17067a = true;
            return -1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17068a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f134a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f17068a), this.f134a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z8, String str, String str2) {
        return a(context, url, z8, str, str2, null, null);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m113b() {
        f17063a.set(m103a());
    }

    public static boolean c(Context context) {
        ay ayVarM104a = m104a();
        return ayVarM104a != null && ayVarM104a.m117a();
    }

    public static boolean d(Context context) {
        return d(m104a());
    }

    public static boolean e(ay ayVar) {
        return ayVar != null && ayVar.m117a() && ayVar.a() == 0;
    }

    public static boolean f(ay ayVar) {
        return ayVar != null && ayVar.a() == 0 && 20 == ayVar.b();
    }

    public static boolean g(ay ayVar) {
        return ayVar != null && ayVar.a() == 0 && 13 == ayVar.b();
    }

    public static boolean h(ay ayVar) {
        if (ayVar == null || ayVar.a() != 0) {
            return false;
        }
        String strM118b = ayVar.m118b();
        if (!"TD-SCDMA".equalsIgnoreCase(strM118b) && !"CDMA2000".equalsIgnoreCase(strM118b) && !"WCDMA".equalsIgnoreCase(strM118b)) {
            switch (ayVar.b()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean i(ay ayVar) {
        if (ayVar == null || ayVar.a() != 0) {
            return false;
        }
        int iB = ayVar.b();
        return iB == 1 || iB == 2 || iB == 4 || iB == 7 || iB == 11;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m109a() {
        m113b();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    public static boolean b(ay ayVar) {
        boolean zHasCapability;
        ConnectivityManager connectivityManager;
        if (ayVar == null) {
            return false;
        }
        Context contextM835a = t.m835a();
        if (contextM835a == null || (connectivityManager = (ConnectivityManager) contextM835a.getSystemService("connectivity")) == null) {
            zHasCapability = false;
        } else {
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    zHasCapability = networkCapabilities.hasCapability(16);
                } else {
                    zHasCapability = false;
                }
            } catch (Exception unused) {
            }
        }
        return zHasCapability && c(ayVar);
    }

    public static boolean d(ay ayVar) {
        return ayVar != null && 1 == ayVar.a();
    }

    public static boolean e(Context context) {
        return f(m104a());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Object m105a(Context context) {
        if (context == null) {
            context = t.m835a();
        }
        ConnectivityManager.NetworkCallback networkCallback = null;
        if (context != null && !k.m649a(context)) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
                ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.ax.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        ax.m113b();
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        super.onLost(network);
                        ax.m113b();
                    }
                };
                try {
                    connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback2);
                    return networkCallback2;
                } catch (Throwable th) {
                    th = th;
                    networkCallback = networkCallback2;
                    com.xiaomi.channel.commonutils.logger.c.m9a("exception occurred in adding network callback :" + th);
                    return networkCallback;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return networkCallback;
    }

    public static boolean c(ay ayVar) {
        return ayVar != null && ayVar.m117a();
    }

    public static boolean f(Context context) {
        return g(m104a());
    }

    public static boolean g(Context context) {
        return h(m104a());
    }

    public static boolean b(Context context) {
        return b(m104a());
    }

    public static boolean h(Context context) {
        return i(m104a());
    }

    public static void a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.m9a("exception occurred in removing network callback :" + th);
        }
    }

    public static int b() {
        try {
            Object objA = bh.a("android.telephony.SubscriptionManager", "getPhoneId", Integer.valueOf(SubscriptionManager.getDefaultDataSubscriptionId()));
            if (objA instanceof Integer) {
                return ((Integer) objA).intValue();
            }
            return -1;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d("exception occurred when get phone card number. " + th);
            return -1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static a<ay> m103a() {
        return new a<>(new Callable<ay>() { // from class: com.xiaomi.push.ax.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ay call() {
                NetworkInfo activeNetworkInfo;
                Context contextM835a = t.m835a();
                if (contextM835a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) contextM835a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new ay(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ay m104a() {
        if (t.m835a() == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("SDK not initialized");
            return null;
        }
        AtomicReference<a<ay>> atomicReference = f17063a;
        a<ay> aVarM103a = atomicReference.get();
        if (aVarM103a != null) {
            try {
                if (aVarM103a.a()) {
                    aVarM103a = m103a();
                    atomicReference.set(aVarM103a);
                }
                if (!aVarM103a.isDone()) {
                    aVarM103a.run();
                }
                return aVarM103a.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z8, String str, String str2, Map<String, String> map, c cVar) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url != null) {
            URL url2 = !z8 ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection httpURLConnectionM107a = m107a(context, url2);
                httpURLConnectionM107a.setConnectTimeout(10000);
                httpURLConnectionM107a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnectionM107a.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    httpURLConnectionM107a.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpURLConnectionM107a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals(GuiControlRequest.IMAGE_TYPE_HTTP) || url.getProtocol().equals("https"))) {
                    cVar.f17068a = httpURLConnectionM107a.getResponseCode();
                    if (cVar.f134a == null) {
                        cVar.f134a = new HashMap();
                    }
                    int i9 = 0;
                    while (true) {
                        String headerFieldKey = httpURLConnectionM107a.getHeaderFieldKey(i9);
                        String headerField = httpURLConnectionM107a.getHeaderField(i9);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f134a.put(headerFieldKey, headerField);
                        }
                        i9++;
                    }
                }
                return new b(httpURLConnectionM107a.getInputStream());
            } catch (IOException e9) {
                throw new IOException("IOException:".concat(e9.getClass().getSimpleName()));
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException(RemoteMessageConst.Notification.URL);
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z8, String str, String str2, String str3) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = a(context, url, z8, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int i9 = bufferedReader.read(cArr);
                    if (-1 != i9) {
                        sb.append(cArr, 0, i9);
                    } else {
                        y.a((Closeable) inputStreamA);
                        return sb.toString();
                    }
                }
            } catch (Throwable th) {
                th = th;
                y.a((Closeable) inputStreamA);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamA = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return p171w.a.a(str, "&key=", bl.a(str + "be988a6134bc8254465424e5a70ef037"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod(HttpRequestBean.METHOD_POST);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i9 = fileInputStream.read(bArr);
                        if (i9 == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, i9);
                        dataOutputStream.flush();
                        throw new IOException("IOException:" + e.getClass().getSimpleName());
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                stringBuffer.append(line);
                            } else {
                                String string = stringBuffer.toString();
                                y.a((Closeable) fileInputStream);
                                y.a(bufferedReader);
                                return string;
                            }
                        } catch (IOException e9) {
                            e = e9;
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                y.a((Closeable) null);
                y.a((Closeable) file);
                throw th3;
            }
        } catch (IOException e11) {
            e = e11;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static int a(Context context) {
        return a(m104a());
    }

    public static int a(ay ayVar) {
        if (ayVar == null) {
            return -1;
        }
        return ayVar.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m107a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m111a(Context context) {
        return a(context) >= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m112a(ay ayVar) {
        return a(ayVar) >= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m110a() {
        return e(m104a());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m106a(Context context) {
        if (d(context)) {
            return "wifi";
        }
        ay ayVarM104a = m104a();
        if (ayVarM104a == null) {
            return "";
        }
        return (ayVarM104a.m116a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ayVarM104a.m118b()).toLowerCase();
    }

    public static av a(Context context, String str, Map<String, String> map) {
        return a(context, str, HttpRequestBean.METHOD_POST, (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static av a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean zEqualsIgnoreCase;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        av avVar = new av();
        try {
            try {
                try {
                    HttpURLConnection httpURLConnectionM107a = m107a(context, m108a(str));
                    httpURLConnectionM107a.setConnectTimeout(10000);
                    httpURLConnectionM107a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = HttpRequestBean.METHOD_GET;
                    }
                    httpURLConnectionM107a.setRequestMethod(str4);
                    int i9 = 0;
                    if (map != null) {
                        zEqualsIgnoreCase = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            httpURLConnectionM107a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        zEqualsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionM107a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (zEqualsIgnoreCase) {
                            outputStream = new GZIPOutputStream(httpURLConnectionM107a.getOutputStream());
                        } else {
                            outputStream = httpURLConnectionM107a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e9) {
                            e = e9;
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    avVar.f17062a = httpURLConnectionM107a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.c.m9a("Http POST Response Code: " + avVar.f17062a);
                    while (true) {
                        String headerFieldKey = httpURLConnectionM107a.getHeaderFieldKey(i9);
                        String headerField = httpURLConnectionM107a.getHeaderField(i9);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM107a.getErrorStream())));
                            }
                        } else {
                            avVar.f132a.put(headerFieldKey, headerField);
                            i9 += 2;
                        }
                        throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM107a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            stringBuffer.append(line);
                            stringBuffer.append(property);
                        }
                        avVar.f131a = stringBuffer.toString();
                        bufferedReader.close();
                        y.a((Closeable) null);
                        y.a((Closeable) null);
                        return avVar;
                    } catch (IOException e10) {
                        e = e10;
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            y.a((Closeable) null);
            y.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                } catch (UnsupportedEncodingException e9) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("Failed to convert from params map to string: " + e9);
                    com.xiaomi.channel.commonutils.logger.c.m9a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static URL m108a(String str) {
        return new URL(str);
    }

    public static int a() {
        Context contextM835a = t.m835a();
        if (contextM835a == null) {
            return -1;
        }
        if (!c(contextM835a)) {
            return 0;
        }
        if (!b(contextM835a)) {
            return 1;
        }
        if (d(contextM835a)) {
            return 2;
        }
        return m110a() ? 3 : -1;
    }
}
