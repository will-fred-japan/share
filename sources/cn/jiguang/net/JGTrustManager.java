package cn.jiguang.net;

import defpackage.f;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class JGTrustManager implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private X509TrustManager f10638a;

    public JGTrustManager(String str) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setEntry("ca_root", trustedCertificateEntry, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f10638a = (X509TrustManager) trustManager;
                    return;
                }
            }
            throw new NoSuchAlgorithmException("No X509TrustManager found");
        } catch (Throwable th) {
            f.l("init trustManager failed, error:", "JGTrustManager", th);
            throw th;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        cn.jiguang.x.f.c("JGTrustManager", "checkClientTrusted");
        this.f10638a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        X509Certificate x509Certificate;
        cn.jiguang.x.f.c("JGTrustManager", "checkServerTrusted");
        this.f10638a.checkServerTrusted(x509CertificateArr, str);
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || (x509Certificate = x509CertificateArr[0]) == null) {
            throw new CertificateException("Check Server x509Certificates is empty");
        }
        try {
            x509Certificate.checkValidity();
        } catch (CertificateExpiredException e9) {
            cn.jiguang.x.f.i("JGTrustManager", "checkServerTrusted: CertificateExpiredException:" + e9.getLocalizedMessage());
            throw e9;
        } catch (CertificateNotYetValidException e10) {
            cn.jiguang.x.f.i("JGTrustManager", "checkServerTrusted: CertificateNotYetValidException:" + e10.getLocalizedMessage());
            throw e10;
        } catch (Throwable th) {
            cn.jiguang.x.f.i("JGTrustManager", "checkServerTrusted failed, error" + th.getLocalizedMessage());
            throw new CertificateException("Check Server x509Certificates exception: " + th);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        cn.jiguang.x.f.c("JGTrustManager", "getAcceptedIssuers");
        return this.f10638a.getAcceptedIssuers();
    }
}
