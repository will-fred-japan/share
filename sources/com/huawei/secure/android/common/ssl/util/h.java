package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15932b = "X509CertificateUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15933c = "hmsrootcas.bks";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15934d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f15935e = "bks";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f15936f = "052root";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f15937g = "hmsincas.bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f15938h = "huawei cbg application integration ca";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15939a;

    public h(Context context) {
        this.f15939a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate a(String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        ?? r8 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(f15935e);
                inputStreamOpen = this.f15939a.getAssets().open(str);
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                    str = inputStreamOpen;
                } catch (IOException e9) {
                    e = e9;
                    e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (KeyStoreException e10) {
                    e = e10;
                    e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (NoSuchAlgorithmException e11) {
                    e = e11;
                    e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (CertificateException e12) {
                    e = e12;
                    e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                }
            } catch (Throwable th) {
                th = th;
                r8 = str;
                d.a((InputStream) r8);
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            inputStreamOpen = null;
            e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (KeyStoreException e14) {
            e = e14;
            inputStreamOpen = null;
            e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e15) {
            e = e15;
            inputStreamOpen = null;
            e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (CertificateException e16) {
            e = e16;
            inputStreamOpen = null;
            e.b(f15932b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) r8);
            throw th;
        }
        d.a((InputStream) str);
        return x509Certificate;
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f15936f);
    }

    public X509Certificate a() {
        return a(f15937g, f15938h);
    }
}
