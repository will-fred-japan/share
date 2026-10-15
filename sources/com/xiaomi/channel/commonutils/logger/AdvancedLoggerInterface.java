package com.xiaomi.channel.commonutils.logger;

/* JADX INFO: loaded from: classes.dex */
public interface AdvancedLoggerInterface extends LoggerInterface {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int FATAL = 5;
    public static final int INFO = 0;
    public static final int WARN = 2;

    void log(int i9, String str);

    void log(int i9, String str, Throwable th);
}
