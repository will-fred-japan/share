package com.xiaomi.push.service.logupload;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static boolean a(Context context, int i9) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("MarketCallerVerifier", "context is invalid when varifying market package.");
            return false;
        }
        try {
            String nameForUid = context.getPackageManager().getNameForUid(i9);
            if (nameForUid == null) {
                com.xiaomi.channel.commonutils.logger.c.m10a("MarketCallerVerifier", "caller package is null for uid when upload log: " + i9);
                return false;
            }
            if ("com.xiaomi.market".equals(nameForUid)) {
                return true;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("MarketCallerVerifier", "caller is not market when upload log: ".concat(nameForUid));
            return false;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("MarketCallerVerifier", "market package name verify failed: " + e9.getMessage());
            return false;
        }
    }
}
