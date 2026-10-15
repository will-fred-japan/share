package com.xiaomi.push;

import android.system.Os;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class cn {
    public static long a(String str) {
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return 0L;
        }
    }
}
