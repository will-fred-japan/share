package okhttp3.internal.platform.android;

import R7.l;
import R7.m;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import p171w.a;
import y7.u;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressSignatureCheck
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r8 = OkHttpClient.class.getPackage();
        String name = r8 != null ? r8.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = u.I(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            k.d(logger, "logger");
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 != null ? str2 : m.e0(23, str);
    }

    public final void androidLog$okhttp(String loggerName, int i9, String message, Throwable th) {
        int iMin;
        k.e(loggerName, "loggerName");
        k.e(message, "message");
        String strLoggerTag = loggerTag(loggerName);
        if (Log.isLoggable(strLoggerTag, i9)) {
            if (th != null) {
                StringBuilder sbC = a.c(message, "\n");
                sbC.append(Log.getStackTraceString(th));
                message = sbC.toString();
            }
            int length = message.length();
            int i10 = 0;
            while (i10 < length) {
                int iS = l.S(message, '\n', i10, 4);
                if (iS == -1) {
                    iS = length;
                }
                while (true) {
                    iMin = Math.min(iS, i10 + MAX_LOG_LENGTH);
                    String strSubstring = message.substring(i10, iMin);
                    k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i9, strLoggerTag, strSubstring);
                    if (iMin >= iS) {
                        break;
                    } else {
                        i10 = iMin;
                    }
                }
                i10 = iMin + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
