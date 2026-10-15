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
public final class CertificateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15918a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static X509Certificate getHwCbgRootCA(Context context) throws Throwable {
        InputStream inputStreamOpen;
        ?? r8 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(h.f15935e);
                inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(h.f15936f);
                    context = inputStreamOpen;
                } catch (IOException e9) {
                    e = e9;
                    e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (RuntimeException e10) {
                    e = e10;
                    e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (KeyStoreException e11) {
                    e = e11;
                    e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (NoSuchAlgorithmException e12) {
                    e = e12;
                    e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (CertificateException e13) {
                    e = e13;
                    e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                }
            } catch (Throwable th) {
                th = th;
                r8 = context;
                d.a((InputStream) r8);
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            inputStreamOpen = null;
            e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (RuntimeException e15) {
            e = e15;
            inputStreamOpen = null;
            e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (KeyStoreException e16) {
            e = e16;
            inputStreamOpen = null;
            e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e17) {
            e = e17;
            inputStreamOpen = null;
            e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (CertificateException e18) {
            e = e18;
            inputStreamOpen = null;
            e.b(f15918a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) r8);
            throw th;
        }
        d.a((InputStream) context);
        return x509Certificate;
    }
}
