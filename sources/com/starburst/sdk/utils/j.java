package com.starburst.sdk.utils;

import N6.C0344o;
import N6.O;
import android.text.TextUtils;
import android.util.Log;
import com.starburst.sdk.core.AiAgentSdk;
import com.starburst.sdk.core.ntp.NtpTimeSync;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f16452a = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f16462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static O f16463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile FileWriter f16464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile File f16465o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile i f16468r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f16453b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f16454c = Pattern.compile("\"streamPiece\"\\s*:\\s*\"([^\"]*)\"");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f16455d = Pattern.compile("\"data\"\\s*:\\s*\"([^\"]*)\"");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f16456e = Pattern.compile("\"imageBase64Data\"\\s*:\\s*\\[\\s*\"([^\"]*)\"\\s*\\]");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f16457f = Pattern.compile("\"imageBase64Data\"\\s*:\\s*\"([^\"]*)\"");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f16458g = Pattern.compile("(?i)([\"'](?:authorization|access[_-]?token|refresh[_-]?token|token|password|passwd|device[_-]?secret|product[_-]?secret|client[_-]?secret|secret[_-]?key|secret|api[_-]?key|access[_-]?key|session[_-]?key|temporary[_-]?key|business[_-]?sign|signContent|sign|cookie|set-cookie|ds|appId|productKey|deviceName|deviceMac|nonce|sonce|fingerprint|cacheData)[\"']\\s*:\\s*[\"'])((?!<redacted)[^\"']*)([\"'])");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f16459h = Pattern.compile("(?im)^(\\s*(?:authorization|access[_-]?token|refresh[_-]?token|token|password|passwd|device[_-]?secret|product[_-]?secret|client[_-]?secret|secret[_-]?key|secret|api[_-]?key|access[_-]?key|session[_-]?key|temporary[_-]?key|business[_-]?sign|signContent|sign|cookie|set-cookie|ds|appId|productKey|deviceName|deviceMac|nonce|sonce|fingerprint|cacheData)\\s*:\\s*)((?!<redacted)[^\\r\\n]*)(\\s*)$");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f16460i = Pattern.compile("(?i)(\\b(?:authorization|access[_-]?token|refresh[_-]?token|token|password|passwd|device[_-]?secret|product[_-]?secret|client[_-]?secret|secret[_-]?key|secret|api[_-]?key|access[_-]?key|session[_-]?key|temporary[_-]?key|business[_-]?sign|signContent|sign|cookie|set-cookie|ds|appId|productKey|deviceName|deviceMac|nonce|sonce|fingerprint|cacheData)\\b\\s*(?:==>|=>|->|=|:)\\s*[\"']?)((?!<redacted)[^\\s,;&}\\]\"']+)([\"']?)");
    public static volatile boolean j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f16461k = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f16466p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final LinkedBlockingQueue f16467q = new LinkedBlockingQueue(5000);

    public static String a(String str, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (th == null) {
            return str;
        }
        StringBuilder sbC = p171w.a.c(str, "\n");
        sbC.append(Log.getStackTraceString(th));
        return sbC.toString();
    }

    public static void b() throws IOException {
        if (f16465o == null || f16465o.length() <= 52428800) {
            return;
        }
        File file = new File(f16465o.getParent(), "starburst_log_old_" + NtpTimeSync.getAdjustedTime() + ".txt");
        c();
        f16465o.renameTo(file);
        l();
    }

    public static void c() {
        try {
            if (f16464n != null) {
                f16464n.close();
                f16464n = null;
            }
        } catch (IOException e9) {
            Log.e("SobLog", "Close writer failed", e9);
        }
    }

    public static void d(boolean z8, boolean z9) {
        j = !z8;
        f16461k = z9;
        if (!z9 || J6.c.f().f2729a == null) {
            return;
        }
        synchronized (f16466p) {
            try {
                if (f16464n != null && (f16465o == null || !f16465o.exists())) {
                    c();
                    f16465o = null;
                }
                if (f16464n == null) {
                    l();
                }
            } catch (IOException e9) {
                e = e9;
                Log.e("SobLog", "Log file initialization failed", e);
                c();
            } catch (RuntimeException e10) {
                e = e10;
                Log.e("SobLog", "Log file initialization failed", e);
                c();
            }
        }
    }

    public static void e(String str) {
        n("SobLog", str, 3, false);
    }

    public static void f(String str, String str2) {
        n(str, str2, 3, false);
    }

    public static void g(String str, String str2) {
        if (J6.c.f().f2729a == null || !f16461k) {
            return;
        }
        if (!j || 3 >= f16452a) {
            if (str2 == null) {
                str2 = "";
            }
            String strO = o(str2);
            if (!TextUtils.isEmpty(strO)) {
                strO = r(r(strO, f16456e, "\"imageBase64Data\":[\"<image base64 omitted,len=%d>\"]"), f16457f, "\"imageBase64Data\":\"<image base64 omitted,len=%d>\"");
            }
            String strP = p(strO);
            int length = 800 - str.length();
            while (strP.length() > length) {
                t(3, str, strP.substring(0, length));
                strP = strP.substring(length);
            }
            t(3, str, strP);
        }
    }

    public static void h(String tag, String message) {
        O o2 = f16463m;
        if (o2 == null) {
            return;
        }
        if (TextUtils.isEmpty(tag)) {
            tag = "Starburst-SobLog";
        } else if (!tag.startsWith("Starburst-")) {
            tag = "Starburst-".concat(tag);
        }
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(message, "message");
        C0344o c0344o = o2.f3307a;
        c0344o.f3376k.post(new G6.d(c0344o, tag, message, 1));
    }

    public static void i(String str, String str2) {
        n(str, str2, 6, false);
    }

    public static void j(String str, String str2, Throwable th) {
        n(str, a(str2, th), 6, false);
    }

    public static void k(String str, String str2) {
        n(str, str2, 4, false);
    }

    public static void l() throws IOException {
        if (TextUtils.isEmpty(f16462l)) {
            f16462l = AiAgentSdk.getInstance().getSdkPath() + "log/";
        }
        File file = new File(f16462l);
        if (file.exists() || file.mkdirs()) {
            f16465o = new File(file, "starburstsdk_log.txt");
            f16464n = new FileWriter(f16465o, true);
        } else {
            throw new IOException("Cannot create log directory: " + f16462l);
        }
    }

    public static void m(String str, String str2) {
        n(str, str2, 4, true);
    }

    public static void n(String str, String str2, int i9, boolean z8) {
        if (z8 || v(i9)) {
            if (str2 == null) {
                str2 = "";
            }
            String strO = o(str2);
            if (!TextUtils.isEmpty(strO)) {
                strO = r(r(strO, f16456e, "\"imageBase64Data\":[\"<image base64 omitted,len=%d>\"]"), f16457f, "\"imageBase64Data\":\"<image base64 omitted,len=%d>\"");
            }
            String strP = p(strO);
            int length = 800 - str.length();
            while (strP.length() > length) {
                String strSubstring = strP.substring(0, length);
                if (v(i9)) {
                    if (i9 == 4) {
                        Log.i(str, strSubstring);
                    } else if (i9 == 5) {
                        Log.w(str, strSubstring);
                    } else if (i9 != 6) {
                        Log.d(str, strSubstring);
                    } else {
                        Log.e(str, strSubstring);
                    }
                }
                if ((z8 || f16461k) && ((z8 || v(i9)) && J6.c.f().f2729a != null)) {
                    t(i9, str, strSubstring);
                }
                if (f16463m != null && (z8 || v(i9))) {
                    h(str, strSubstring);
                }
                strP = strP.substring(length);
            }
            if (v(i9)) {
                if (i9 == 4) {
                    Log.i(str, strP);
                } else if (i9 == 5) {
                    Log.w(str, strP);
                } else if (i9 != 6) {
                    Log.d(str, strP);
                } else {
                    Log.e(str, strP);
                }
            }
            if (f16463m != null && (z8 || v(i9))) {
                h(str, strP);
            }
            if (z8 || f16461k) {
                if ((z8 || v(i9)) && J6.c.f().f2729a != null) {
                    t(i9, str, strP);
                }
            }
        }
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f16454c.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement("\"streamPiece\":\"<audio omitted,len=" + (matcher.group(1) == null ? 0 : matcher.group(1).length()) + ">\""));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String p(String str) {
        return (!j || TextUtils.isEmpty(str)) ? str : s(s(s(str, f16458g), f16459h), f16460i);
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b9 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b9)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r(String str, Pattern pattern, String str2) {
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(String.format(str2, Integer.valueOf(strGroup == null ? 0 : strGroup.length()))));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String s(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            String strGroup = matcher.group(2);
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            sb.append("<redacted,len=");
            sb.append(strGroup == null ? 0 : strGroup.length());
            sb.append(">");
            sb.append(matcher.group(3));
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(sb.toString()));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static void t(int i9, String str, String str2) {
        String str3;
        String str4 = f16453b.format(new Date());
        if (i9 == 4) {
            str3 = "I";
        } else if (i9 != 5) {
            str3 = i9 != 6 ? "D" : "E";
        } else {
            str3 = "W";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(" [");
        sb.append(str3);
        sb.append("] ");
        sb.append(str);
        String strJ = A.a.j(sb, ": ", str2);
        LinkedBlockingQueue linkedBlockingQueue = f16467q;
        if (!linkedBlockingQueue.offer(strJ)) {
            linkedBlockingQueue.poll();
            linkedBlockingQueue.offer(strJ);
        }
        synchronized (j.class) {
            try {
                if (f16468r == null || !f16468r.isAlive()) {
                    f16468r = new i("LogWriter");
                    f16468r.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void u(String str, String str2) {
        if (!j) {
            n(str, str2, 4, false);
            return;
        }
        String strP = p(str2);
        if (TextUtils.equals(strP, str2)) {
            strP = A.f.i(new StringBuilder("<sensitive data redacted,len="), str2 == null ? 0 : str2.length(), ">");
        }
        n(str, strP, 4, false);
    }

    public static boolean v(int i9) {
        return !j || i9 >= f16452a;
    }

    public static void w(String str, String str2) {
        if (j) {
            return;
        }
        int length = 800 - str.length();
        while (str2.length() > length) {
            Log.d(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        Log.d(str, str2);
        if (f16461k) {
            t(3, str, str2);
        }
        if (f16463m == null || !v(3)) {
            return;
        }
        h(str, str2);
    }

    public static void x(String str, String str2) {
        n(str, str2, 5, false);
    }

    public static void y(String str, String str2, Throwable th) {
        n(str, a(str2, th), 5, false);
    }

    public static void z(ArrayList arrayList) {
        synchronized (f16466p) {
            try {
                try {
                    if (f16464n != null && (f16465o == null || !f16465o.exists())) {
                        c();
                        f16465o = null;
                    }
                    b();
                    if (f16464n == null) {
                        l();
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        f16464n.append((CharSequence) it.next()).append((CharSequence) "\n");
                    }
                    f16464n.flush();
                } catch (IOException e9) {
                    Log.e("SobLog", "Log write failed", e9);
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
