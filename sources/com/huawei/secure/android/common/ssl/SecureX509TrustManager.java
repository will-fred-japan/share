package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import defpackage.f;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15859c = "SX509TM";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15860d = "hmsrootcas.bks";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15861e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15862f = "X509";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15863g = "bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15864h = "AndroidCAStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<X509TrustManager> f15865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private X509Certificate[] f15866b;

    public SecureX509TrustManager(Context context) {
        this(context, false);
    }

    private void a() {
        e.c(f15859c, "loadSystemCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f15864h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f15862f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f15865a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e9) {
            e.b(f15859c, "loadSystemCA: exception : " + e9.getMessage());
        }
        f.j(jCurrentTimeMillis, new StringBuilder("loadSystemCA: cost : "), " ms", f15859c);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f15859c, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f15865a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e9) {
                e.b(f15859c, "checkServerTrusted CertificateException" + e9.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        e.c(f15859c, "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size = this.f15865a.size();
        for (int i9 = 0; i9 < size; i9++) {
            try {
                e.c(f15859c, "check server i=" + i9);
                X509TrustManager x509TrustManager = this.f15865a.get(i9);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    e.c(f15859c, "client root ca size=" + acceptedIssuers.length);
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                e.c(f15859c, "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e9) {
                e.b(f15859c, "checkServerTrusted error :" + e9.getMessage() + " , time : " + i9);
                if (i9 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        e.b(f15859c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e9;
                }
            }
        }
        f.j(jCurrentTimeMillis, new StringBuilder("checkServerTrusted: cost : "), " ms", f15859c);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f15865a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e9) {
            e.b(f15859c, "getAcceptedIssuers exception : " + e9.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f15866b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f15865a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f15866b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f15865a = list;
    }

    public SecureX509TrustManager(Context context, boolean z8) throws CertificateException {
        this.f15865a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        ContextUtil.setContext(context);
        a(context);
        if (z8) {
            a();
        }
        if (this.f15865a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) {
        this.f15865a = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z8) throws Throwable {
        FileInputStream fileInputStream;
        this.f15865a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, "");
                d.a((InputStream) fileInputStream);
                if (z8) {
                    a();
                }
            } catch (Throwable th) {
                th = th;
                d.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private void a(Context context) {
        e.c(f15859c, "loadBksCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                e.c(f15859c, "get bks not from assets");
                a(filesBksIS);
                if (filesBksIS == null) {
                    e.c(f15859c, " get bks from assets ");
                    a(context.getAssets().open("hmsrootcas.bks"));
                }
            } catch (IOException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e9) {
                e.b(f15859c, "loadBksCA: exception : " + e9.getMessage());
            }
        } else if (filesBksIS == null) {
            e.c(f15859c, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
        f.j(jCurrentTimeMillis, new StringBuilder("loadBksCA: cost : "), " ms", f15859c);
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z8) {
        this.f15865a = new ArrayList();
        a(inputStream, str);
        if (z8) {
            a();
        }
    }

    private void a(InputStream inputStream) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f15862f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f15865a.add((X509TrustManager) trustManager);
                }
            }
            d.a(inputStream);
        } catch (Throwable th) {
            d.a(inputStream);
            throw th;
        }
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f15862f);
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (TrustManager trustManager : trustManagers) {
                        if (trustManager instanceof X509TrustManager) {
                            this.f15865a.add((X509TrustManager) trustManager);
                        }
                    }
                    d.a(inputStream);
                } catch (Throwable th) {
                    d.a(inputStream);
                    throw th;
                }
            } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e9) {
                e.b(f15859c, "loadInputStream: exception : " + e9.getMessage());
                d.a(inputStream);
            }
            f.j(jCurrentTimeMillis, new StringBuilder("loadInputStream: cost : "), " ms", f15859c);
            return;
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
