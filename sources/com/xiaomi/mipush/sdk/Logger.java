package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        LoggerInterface loggerInterface = sUserLogger;
        boolean z8 = loggerInterface != null;
        boolean z9 = sDisablePushLog;
        if (!(z9 ? false : z8)) {
            loggerInterface = null;
        }
        com.xiaomi.channel.commonutils.logger.c.a(new ds(loggerInterface, z9 ? null : dt.a(context)));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z8) {
    }
}
