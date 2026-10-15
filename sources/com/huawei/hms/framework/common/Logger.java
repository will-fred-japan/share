package com.huawei.hms.framework.common;

import W5.e;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static final String CLASSNAME_COMMON_PRE_FK = "com.huawei.hms.framework.";
    private static final String CLASSNAME_COMMON_PRE_NK = "com.huawei.hms.network.";
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NK_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NK_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;
    private static int minLogEnableLevel = 2;

    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void setCause(Throwable th) {
            this.thisCause = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.thisCause;
            if (th == this) {
                th = null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.message == null) {
                return name;
            }
            String strConcat = name.concat(": ");
            if (this.message.startsWith(strConcat)) {
                return this.message;
            }
            StringBuilder sbB = p171w.a.b(strConcat);
            sbB.append(this.message);
            return sbB.toString();
        }

        private ThrowableWrapper(Throwable th) {
            this.ownerThrowable = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i9 = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i9) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i9));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }
    }

    private static String complexAppTag(String str) {
        return e.l(TAG_NETWORK_SDK_PRE, str);
    }

    private static String complexMsg(String str, int i9) {
        if (TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i9);
        }
        String callMethodInfo = getCallMethodInfo(i9);
        return TextUtils.isEmpty(callMethodInfo) ? str : p171w.a.a(callMethodInfo, "|", str);
    }

    private static String complexTag(String str) {
        return e.l(TAG_NETWORKKIT_PRE, str);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void extLogPrintln(int i9, String str, String str2) {
        if (i9 == 2) {
            extLogger.v(str, str2);
            return;
        }
        if (i9 == 3) {
            extLogger.d(str, str2);
            return;
        }
        if (i9 == 4) {
            extLogger.i(str, str2);
        } else if (i9 == 5) {
            extLogger.w(str, str2);
        } else {
            if (i9 != 6) {
                return;
            }
            extLogger.e(str, str2);
        }
    }

    private static String getBriefCallMethodInfo(int i9) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i9) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i9];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getClassName().replace(CLASSNAME_COMMON_PRE_NK, "").replace(CLASSNAME_COMMON_PRE_FK, "") + "|" + stackTraceElement.getLineNumber();
    }

    private static String getCallMethodInfo(int i9) {
        return !Log.isLoggable(TAG_NETWORKKIT_PRE, 3) ? getBriefCallMethodInfo(i9 + 1) : getVerboseCallMethodInfo(i9 + 1);
    }

    private static Throwable getNewThrowable(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th);
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    private static String getVerboseCallMethodInfo(int i9) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i9) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i9];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    private static boolean isAPPLoggable(int i9) {
        return extLogger != null && i9 >= 3;
    }

    private static boolean isKitLoggable(int i9) {
        return kitPrint && isLoggable(i9);
    }

    public static boolean isLoggable(int i9) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i9);
    }

    private static int logPrintln(int i9, String str, String str2) {
        if (i9 < minLogEnableLevel) {
            return 1;
        }
        if (isAPPLoggable(i9)) {
            extLogPrintln(i9, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i9)) {
            return Log.println(i9, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i9, String str, Object obj) {
        if (i9 < 3) {
            return;
        }
        logPrintln(i9, str, obj == null ? "null" : obj.toString());
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z8) {
        extLogger = extLogger2;
        kitPrint = z8;
        i(TAG, "logger = " + extLogger2 + z8);
    }

    public static void setLogEnableLevel(int i9) {
        minLogEnableLevel = i9;
        Log.i(TAG, "setLogEnableLevel: " + i9);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i9, String str, String str2, Object... objArr) {
        if (i9 < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(TAG, "format is null, not log");
            return;
        }
        try {
            logPrintln(i9, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e9) {
            w(TAG, "log format error".concat(str2), e9);
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        if (6 < minLogEnableLevel) {
            return;
        }
        if (isAPPLoggable(6)) {
            extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (5 < minLogEnableLevel) {
            return;
        }
        if (isAPPLoggable(5)) {
            extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }
}
