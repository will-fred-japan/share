package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Cdo f17265a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.c.d("ERROR: Context cannot be null.");
            return null;
        }
        Cdo cdo = f17265a;
        if (cdo != null) {
            return cdo.a(context);
        }
        com.xiaomi.channel.commonutils.logger.c.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
