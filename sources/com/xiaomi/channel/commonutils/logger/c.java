package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.k;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f16920a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Context f0a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f6a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f7b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f3a = "XMPush-" + Process.myPid();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AdvancedLoggerInterface f1a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f4a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, String> f16921b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Integer f2a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicInteger f5a = new AtomicInteger(1);

    public static class a implements AdvancedLoggerInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16922a = c.f3a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f16922a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f16922a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f16922a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
        public void log(int i9, String str) {
            Log.v(this.f16922a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
        public void log(int i9, String str, Throwable th) {
            Log.v(this.f16922a, str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m14a() {
        return false;
    }

    public static void b(String str) {
        if (m15a(0)) {
            a(0, m8a(str));
        }
    }

    public static void c(String str) {
        if (m15a(0)) {
            a(1, m8a(str));
        }
    }

    public static void d(String str) {
        if (m15a(4)) {
            a(4, m8a(str));
        }
    }

    public static void e(String str) {
        if (f6a) {
            m9a(str);
            return;
        }
        Log.w(f3a, m8a(str));
        if (f7b) {
            return;
        }
        m9a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        if (loggerInterface == null) {
            return;
        }
        if (loggerInterface instanceof AdvancedLoggerInterface) {
            f1a = (AdvancedLoggerInterface) loggerInterface;
        } else {
            f1a = new b(loggerInterface);
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m16b(String str, String str2) {
        if (m15a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (m15a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m15a(1)) {
            a(1, a(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f6a) {
            m11a(str, objArr);
            return;
        }
        Log.w(f3a, a(str, objArr));
        if (f7b) {
            return;
        }
        m11a(str, objArr);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m15a(int i9) {
        return i9 >= f16920a || m14a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9a(String str) {
        if (m15a(2)) {
            a(2, m8a(str));
        }
    }

    public static void b(Object... objArr) {
        if (m15a(4)) {
            a(4, a(objArr));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m10a(String str, String str2) {
        if (m15a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m11a(String str, Object... objArr) {
        if (m15a(2)) {
            a(2, a(str, objArr));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m13a(Object... objArr) {
        if (m15a(0)) {
            a(0, a(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (m15a(4)) {
            a(4, m8a(str), th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m12a(Throwable th) {
        if (m15a(4)) {
            a(4, th);
        }
    }

    public static Integer a(String str) {
        if (f16920a <= 1) {
            Integer numValueOf = Integer.valueOf(f5a.incrementAndGet());
            f4a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            f16921b.put(numValueOf, str);
            f1a.log(str + " starts");
            return numValueOf;
        }
        return f2a;
    }

    public static void a(Integer num) {
        if (f16920a <= 1) {
            HashMap<Integer, Long> map = f4a;
            if (map.containsKey(num)) {
                long jLongValue = map.remove(num).longValue();
                String strRemove = f16921b.remove(num);
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                f1a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i9, String str) {
        if (i9 >= f16920a) {
            f1a.log(i9, str);
            return;
        }
        if (m14a()) {
            Log.d("MyLog", "-->log(" + i9 + "): " + str);
        }
    }

    public static void a(int i9, Throwable th) {
        if (i9 >= f16920a) {
            f1a.log(i9, "", th);
        } else if (m14a()) {
            Log.w("MyLog", "-->log(" + i9 + "): ", th);
        }
    }

    public static void a(int i9, String str, Throwable th) {
        if (i9 >= f16920a) {
            f1a.log(i9, str, th);
            return;
        }
        if (m14a()) {
            Log.w("MyLog", "-->log(" + i9 + "): " + str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m8a(String str) {
        return A.a.j(new StringBuilder(), b(), str);
    }

    private static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] [");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i9) {
        if (i9 < 0 || i9 > 5) {
            a(2, "set log level as " + i9);
        }
        f16920a = i9;
    }

    public static int a() {
        return f16920a;
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        if (th != null) {
            th.printStackTrace(new PrintWriter(stringWriter));
        }
        return stringWriter.toString();
    }

    public static void a(Context context) {
        f0a = context;
        if (k.m649a(context)) {
            f6a = true;
        }
        if (k.m648a()) {
            f7b = true;
        }
    }
}
