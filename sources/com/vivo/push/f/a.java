package com.vivo.push.f;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;
import com.vivo.push.util.ad;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: ConfigSecureUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Boolean f16600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Boolean f16601b = null;

    private synchronized boolean c(Context context) {
        if (this.f16601b != null) {
            return this.f16601b.booleanValue();
        }
        boolean z8 = true;
        if (context == null) {
            return true;
        }
        boolean zD = ad.d(context, context.getPackageName());
        if (!ad.c(context, context.getPackageName()) && !zD) {
            z8 = false;
        }
        this.f16601b = Boolean.valueOf(z8);
        return this.f16601b.booleanValue();
    }

    private synchronized boolean d(Context context) {
        if (this.f16600a != null) {
            return this.f16600a.booleanValue();
        }
        if (context == null) {
            w.c("ConfigSecureUtil", "checkHasService paramContext is empty ");
            return true;
        }
        try {
            String str = ad.c(context, context.getPackageName()) ? "com.vivo.push.sdk.service.CommandClientService" : "com.vivo.push.sdk.service.CommandService";
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                w.c("ConfigSecureUtil", "checkHasService serviceInfos is empty ");
                this.f16600a = Boolean.TRUE;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (str.equals(((ComponentInfo) serviceInfo).name)) {
                    this.f16600a = Boolean.TRUE;
                    return this.f16600a.booleanValue();
                }
            }
            this.f16600a = Boolean.FALSE;
        } catch (Exception e9) {
            w.a("ConfigSecureUtil", "checkHasService error " + e9.getMessage());
            this.f16600a = Boolean.TRUE;
        }
        return this.f16600a.booleanValue();
    }

    public final synchronized byte[] a(Context context) {
        byte[] bArr;
        try {
            bArr = new byte[16];
            bArr[0] = 34;
            bArr[1] = 32;
            bArr[2] = 33;
            bArr[3] = 37;
            if (d(context)) {
                bArr[4] = 33;
                bArr[5] = 34;
                bArr[6] = 32;
                bArr[7] = 33;
            }
            bArr[8] = 33;
            bArr[9] = 33;
            bArr[10] = 34;
            bArr[11] = 41;
            if (c(context)) {
                bArr[12] = 35;
                bArr[13] = 32;
                bArr[14] = 32;
                bArr[15] = 32;
            }
        } catch (Throwable th) {
            throw th;
        }
        return bArr;
    }

    public final synchronized byte[] b(Context context) {
        byte[] bArr;
        try {
            bArr = new byte[16];
            bArr[0] = 33;
            bArr[1] = 34;
            bArr[2] = 35;
            bArr[3] = 36;
            if (d(context)) {
                bArr[4] = 37;
                bArr[5] = 38;
                bArr[6] = 39;
                bArr[7] = 40;
            }
            bArr[8] = 41;
            bArr[9] = 32;
            bArr[10] = 38;
            bArr[11] = 37;
            if (c(context)) {
                bArr[12] = 36;
                bArr[13] = 35;
                bArr[14] = 34;
                bArr[15] = 33;
            }
        } catch (Throwable th) {
            throw th;
        }
        return bArr;
    }
}
