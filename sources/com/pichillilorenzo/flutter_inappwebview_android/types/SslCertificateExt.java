package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.net.http.SslCertificate;
import android.os.Build;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SslCertificateExt extends SslCertificate {
    private SslCertificateExt(X509Certificate x509Certificate) {
        super(x509Certificate);
    }

    public static Map<String, Object> toMap(SslCertificate sslCertificate) {
        HashMap map;
        HashMap map2;
        byte[] encoded = null;
        if (sslCertificate == null) {
            return null;
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            map = new HashMap();
            map.put("CName", issuedBy.getCName());
            map.put("DName", issuedBy.getDName());
            map.put("OName", issuedBy.getOName());
            map.put("UName", issuedBy.getUName());
        } else {
            map = null;
        }
        SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
        if (issuedTo != null) {
            map2 = new HashMap();
            map2.put("CName", issuedTo.getCName());
            map2.put("DName", issuedTo.getDName());
            map2.put("OName", issuedTo.getOName());
            map2.put("UName", issuedTo.getUName());
        } else {
            map2 = null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                X509Certificate x509Certificate = sslCertificate.getX509Certificate();
                if (x509Certificate != null) {
                    encoded = x509Certificate.getEncoded();
                }
            } catch (CertificateEncodingException e9) {
                e9.printStackTrace();
            }
        } else {
            try {
                encoded = Util.getX509CertFromSslCertHack(sslCertificate).getEncoded();
            } catch (CertificateEncodingException e10) {
                e10.printStackTrace();
            }
        }
        long time = sslCertificate.getValidNotAfterDate().getTime();
        long time2 = sslCertificate.getValidNotBeforeDate().getTime();
        HashMap map3 = new HashMap();
        map3.put("issuedBy", map);
        map3.put("issuedTo", map2);
        map3.put("validNotAfterDate", Long.valueOf(time));
        map3.put("validNotBeforeDate", Long.valueOf(time2));
        map3.put("x509Certificate", encoded);
        return map3;
    }
}
