package com.xiaomi.push;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class gh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17524a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(gg ggVar, byte[] bArr) {
        try {
            byte[] bArrA = gk.a.a(bArr);
            if (f17524a) {
                com.xiaomi.channel.commonutils.logger.c.m10a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + ggVar);
                if (ggVar.f474a == 1) {
                    com.xiaomi.channel.commonutils.logger.c.m10a("BCompressed", "decompress not support upStream");
                    return bArrA;
                }
            }
            return bArrA;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m10a("BCompressed", "decompress error " + e9);
            return bArr;
        }
    }
}
