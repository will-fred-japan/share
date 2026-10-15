package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SslErrorExt extends SslError {
    private SslErrorExt(int i9, SslCertificate sslCertificate, String str) {
        super(i9, sslCertificate, str);
    }

    public static Map<String, Object> toMap(SslError sslError) {
        String str;
        if (sslError == null) {
            return null;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            str = "The certificate is not yet valid";
        } else if (primaryError == 1) {
            str = "The certificate has expired";
        } else if (primaryError == 2) {
            str = "Hostname mismatch";
        } else if (primaryError == 3) {
            str = "The certificate authority is not trusted";
        } else if (primaryError != 4) {
            str = primaryError != 5 ? null : "A generic error occurred";
        } else {
            str = "The date of the certificate is invalid";
        }
        HashMap map = new HashMap();
        map.put("code", primaryError >= 0 ? Integer.valueOf(primaryError) : null);
        map.put("message", str);
        return map;
    }
}
