package cn.jiguang.v;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f10798a = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    private static File a(String str, byte[] bArr) throws IOException {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static File b(Context context, String str, int i9, String str2) {
        try {
            boolean zB = f.b(context);
            cn.jiguang.u.b.e("HttpUtils", " https download continueBusiness=" + zB);
            if (!zB) {
                cn.jiguang.u.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection httpURLConnectionA = a(str);
            httpURLConnectionA.setConnectTimeout(i9);
            httpURLConnectionA.setReadTimeout(i9);
            int responseCode = httpURLConnectionA.getResponseCode();
            byte[] bArrA = a(httpURLConnectionA.getInputStream());
            f.a(context, str, 0L, bArrA != null ? bArrA.length : 0);
            cn.jiguang.u.b.e("HttpUtils", "download:" + str + " responseCode:" + responseCode);
            if (200 != responseCode) {
                return null;
            }
            return a(str2, bArrA);
        } catch (Throwable th) {
            StringBuilder sbI = defpackage.f.i("download:", str, " fail.");
            sbI.append(th.getMessage());
            cn.jiguang.u.b.a("HttpUtils", sbI.toString(), th);
            return null;
        }
    }

    public static String a(Context context, String str, int i9, String str2) {
        try {
            boolean zB = f.b(context);
            cn.jiguang.u.b.e("HttpUtils", " https sdk continueBusiness=" + zB);
            if (!zB) {
                cn.jiguang.u.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection httpURLConnectionA = a(str);
            httpURLConnectionA.setRequestProperty("Content-Type", "application/json");
            a(httpURLConnectionA, context);
            httpURLConnectionA.setConnectTimeout(i9);
            httpURLConnectionA.setReadTimeout(i9);
            httpURLConnectionA.setRequestMethod(HttpRequestBean.METHOD_POST);
            httpURLConnectionA.setDoOutput(true);
            httpURLConnectionA.setDoInput(true);
            byte[] bytes = str2.getBytes();
            httpURLConnectionA.getOutputStream().write(bytes);
            int responseCode = httpURLConnectionA.getResponseCode();
            byte[] bArrA = a(httpURLConnectionA.getInputStream());
            f.a(context, str, bytes.length, bArrA != null ? bArrA.length : 0);
            cn.jiguang.u.b.e("HttpUtils", "httpPost:" + str + " responseCode:" + responseCode);
            if (200 == responseCode && bArrA != null) {
                return new String(bArrA, "UTF-8");
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.u.b.a("HttpUtils", "httpPost:" + str + " fail.", th);
            return null;
        }
    }

    public static HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private static void a(HttpURLConnection httpURLConnection, Context context) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            long jA = f.a(context);
            if (jA <= 0) {
                return;
            }
            String strEncodeToString = Base64.encodeToString(String.valueOf(jA).getBytes("UTF-8"), 2);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return;
            }
            httpURLConnection.setRequestProperty("X-UDD", strEncodeToString);
        } catch (Throwable th) {
            cn.jiguang.u.b.e("HttpUtils", "set uid header failed." + th.getMessage());
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i9 = inputStream.read(bArr);
                    if (i9 == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        inputStream.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i9);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jiguang.u.b.a("HttpUtils", " readInputStream failed , error is : " + th.getMessage());
                    return null;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }
}
