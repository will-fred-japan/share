package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        k.e(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        k.d(loggerName, "record.loggerName");
        int androidLevel = AndroidLogKt.getAndroidLevel(record);
        String message = record.getMessage();
        k.d(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, record.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
