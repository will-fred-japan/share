package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class LogsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f15949a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f15950b = '*';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f15951c = 2;

    public static class a extends Throwable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f15952d = 7129050843360571879L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Throwable f15954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Throwable f15955c;

        public a(Throwable th) {
            this.f15955c = th;
        }

        public void a(Throwable th) {
            this.f15954b = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f15954b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f15953a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f15955c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f15953a == null) {
                return name;
            }
            String strConcat = name.concat(": ");
            if (this.f15953a.startsWith(strConcat)) {
                return this.f15953a;
            }
            StringBuilder sbB = p171w.a.b(strConcat);
            sbB.append(this.f15953a);
            return sbB.toString();
        }

        public void a(String str) {
            this.f15953a = str;
        }
    }

    private static String a(String str, boolean z8) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z8) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i9 = 0; i9 < charArray.length; i9++) {
            if (i9 % 2 == 0) {
                charArray[i9] = f15950b;
            }
        }
        return new String(charArray);
    }

    public static void d(String str, String str2, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, z8));
    }

    public static void e(String str, String str2, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, z8));
    }

    public static Throwable getNewThrowable(Throwable th) {
        if (th == null) {
            return null;
        }
        a aVar = new a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.a(b(th.getMessage()));
        Throwable cause = th.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(b(cause.getMessage()));
            aVar2.a(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static void i(String str, String str2, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, a(str2, z8));
    }

    public static void w(String str, String str2, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(str, a(str2, z8));
    }

    public static void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.d(str, a(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.e(str, a(str2, str3));
    }

    public static void i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.i(str, a(str2, str3));
    }

    public static void w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.w(str, a(str2, str3));
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.d(str, a(str2, str3), getNewThrowable(th));
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.e(str, a(str2, str3), getNewThrowable(th));
    }

    public static void i(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.i(str, a(str2, str3), getNewThrowable(th));
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.w(str, a(str2, str3), getNewThrowable(th));
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, false));
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, false));
    }

    public static void i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, a(str2, false));
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(str, a(str2, false));
    }

    public static void d(String str, String str2, Throwable th, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, z8), getNewThrowable(th));
    }

    public static void e(String str, String str2, Throwable th, boolean z8) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.e(str, a(str2, z8), getNewThrowable(th));
    }

    public static void i(String str, String str2, Throwable th, boolean z8) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.i(str, a(str2, z8), getNewThrowable(th));
    }

    public static void w(String str, String str2, Throwable th, boolean z8) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.w(str, a(str2, z8), getNewThrowable(th));
    }

    public static void d(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.d(str, a(str2, false), getNewThrowable(th));
    }

    public static void e(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.e(str, a(str2, false), getNewThrowable(th));
    }

    public static void i(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.i(str, a(str2, false), getNewThrowable(th));
    }

    public static void w(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        Log.w(str, a(str2, false), getNewThrowable(th));
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i9 = 1;
        if (1 == length) {
            return String.valueOf(f15950b);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (f15949a.matcher(String.valueOf(cCharAt)).matches()) {
                if (i9 % 2 == 0) {
                    cCharAt = '*';
                }
                i9++;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}
