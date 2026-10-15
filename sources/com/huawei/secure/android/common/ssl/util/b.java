package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15920a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15921b = 5;

    public static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e9) {
            e.b(f15920a, "generateX509FromStr: CertificateException" + e9.getMessage());
            return null;
        }
    }

    public static boolean b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e9) {
                e = e9;
                e.b(f15920a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e10) {
                e = e10;
                e.b(f15920a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e11) {
                e.b(f15920a, "verifyCertificateDate : exception : " + e11.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) {
        return !a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr);
    }

    public static boolean a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates != null && !revokedCertificates.isEmpty()) {
                Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
                while (it.hasNext()) {
                    if (arrayList.contains(it.next().getSerialNumber())) {
                        e.b(f15920a, "verify: certificate revoked");
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e9) {
            e.b(f15920a, "verify: revoked verify exception : " + e9.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        e.b(f15920a, "verify: subject name is error");
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            e.b(f15920a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e9) {
            e.b(f15920a, "verify: publickey InvalidKeyException " + e9.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e10) {
            e.b(f15920a, "verify: publickey NoSuchAlgorithmException " + e10.getMessage());
            return false;
        } catch (NoSuchProviderException e11) {
            e.b(f15920a, "verify: publickey NoSuchProviderException " + e11.getMessage());
            return false;
        } catch (SignatureException e12) {
            e.b(f15920a, "verify: publickey SignatureException " + e12.getMessage());
            return false;
        } catch (CertificateException e13) {
            e.b(f15920a, "verify: publickey CertificateException " + e13.getMessage());
            return false;
        } catch (Exception e14) {
            e.b(f15920a, "verify: Exception " + e14.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Principal principal = null;
        int i9 = 0;
        while (i9 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i9];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i9].verify(x509CertificateArr[i9 - 1].getPublicKey());
                } else {
                    e.b(f15920a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i9++;
            principal = subjectDN;
        }
        return a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr);
    }

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray == null) {
            return null;
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
        } catch (CertificateException e9) {
            e.a(f15920a, "exception", e9);
            return null;
        }
    }

    public static boolean a(X509Certificate[] x509CertificateArr) {
        for (int i9 = 0; i9 < x509CertificateArr.length - 1; i9++) {
            if (!a(x509CertificateArr[i9])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
