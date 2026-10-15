package H6;

import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: VolceNetworkClient.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Z3.a {
    public static Z3.b b(String str, String str2, byte[] bArr, Map map) throws IOException {
        byte[] byteArray;
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        k.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (bArr != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                p188x7.k kVar = p188x7.k.f22364a;
                outputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    p199z2.b.r(outputStream, th);
                    throw th2;
                }
            }
        }
        try {
            int responseCode = httpURLConnection.getResponseCode();
            InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            if (errorStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int i9 = errorStream.read(bArr2);
                        if (i9 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i9);
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    k.d(byteArray, "toByteArray(...)");
                    errorStream.close();
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        p199z2.b.r(errorStream, th3);
                        throw th4;
                    }
                }
            } else {
                byteArray = new byte[0];
            }
            HashMap map2 = new HashMap();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            k.d(headerFields, "getHeaderFields(...)");
            for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                String key = entry2.getKey();
                List<String> value = entry2.getValue();
                if (key != null) {
                    k.b(value);
                    if (!value.isEmpty()) {
                        map2.put(key, value.get(0));
                    }
                }
            }
            Z3.b bVar = new Z3.b();
            bVar.f5518a = responseCode;
            bVar.f5519b = map2;
            bVar.f5520c = byteArray;
            httpURLConnection.disconnect();
            return bVar;
        } catch (Throwable th5) {
            httpURLConnection.disconnect();
            throw th5;
        }
    }

    @Override // Z3.a
    public final Z3.b a(String url, byte[] bArr, Map<String, String> map) {
        k.e(url, "url");
        return b(url, HttpRequestBean.METHOD_POST, bArr, map);
    }

    @Override // Z3.a
    public final Z3.b c(String url, Map<String, String> map) {
        k.e(url, "url");
        return b(url, HttpRequestBean.METHOD_GET, null, map);
    }
}
