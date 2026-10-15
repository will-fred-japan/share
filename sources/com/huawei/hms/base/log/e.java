package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: LogRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14872d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14877i;
    private int j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f14869a = new StringBuilder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f14873e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f14874f = 0;

    public e(int i9, String str, int i10, String str2) {
        this.f14871c = "HMS";
        this.j = i9;
        this.f14870b = str;
        this.f14872d = i10;
        if (str2 != null) {
            this.f14871c = str2;
        }
        b();
    }

    public static String a(int i9) {
        if (i9 == 3) {
            return "D";
        }
        if (i9 == 4) {
            return "I";
        }
        if (i9 != 5) {
            return i9 != 6 ? String.valueOf(i9) : "E";
        }
        return "W";
    }

    private e b() {
        this.f14873e = System.currentTimeMillis();
        Thread threadCurrentThread = Thread.currentThread();
        this.f14874f = threadCurrentThread.getId();
        this.f14876h = Process.myPid();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        int length = stackTrace.length;
        int i9 = this.j;
        if (length > i9) {
            StackTraceElement stackTraceElement = stackTrace[i9];
            this.f14875g = stackTraceElement.getFileName();
            this.f14877i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> e a(T t) {
        this.f14869a.append(t);
        return this;
    }

    public e a(Throwable th) {
        a('\n').a(Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    private StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f14873e)));
        String strA = a(this.f14872d);
        sb.append(' ');
        sb.append(strA);
        sb.append('/');
        sb.append(this.f14871c);
        sb.append('/');
        sb.append(this.f14870b);
        sb.append(' ');
        sb.append(this.f14876h);
        sb.append(':');
        sb.append(this.f14874f);
        sb.append(' ');
        sb.append(this.f14875g);
        sb.append(':');
        sb.append(this.f14877i);
        sb.append(']');
        return sb;
    }

    private StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.f14869a.toString());
        return sb;
    }
}
