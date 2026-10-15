package com.apm.insight.log;

import W5.e;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.apm.insight.log.a.g;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11879a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static VLogConfig f11880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f11881c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Set<String> f11882d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f11883e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.apm.insight.log.a.a f11884f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HandlerThread f11886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Handler f11887i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static HashMap<String, com.apm.insight.log.a.a> f11885g = new HashMap<>();
    private static long j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f11888k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Object f11889l = new Object();

    /* JADX INFO: renamed from: com.apm.insight.log.a$a, reason: collision with other inner class name */
    public static class C0150a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final Object f11890i = new Object();
        private static C0150a j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static int f11891k;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f11895d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11896e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f11897f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f11898g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f11899h;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private C0150a f11900l;

        private C0150a() {
        }

        public static C0150a a() {
            synchronized (f11890i) {
                try {
                    C0150a c0150a = j;
                    if (c0150a == null) {
                        return new C0150a();
                    }
                    j = c0150a.f11900l;
                    c0150a.f11900l = null;
                    f11891k--;
                    return c0150a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void b() {
            this.f11893b = null;
            this.f11894c = null;
            this.f11895d = null;
            this.f11896e = 0;
            this.f11897f = null;
            this.f11898g = -1L;
            this.f11899h = 0L;
            this.f11900l = null;
            synchronized (f11890i) {
                try {
                    int i9 = f11891k;
                    if (i9 < 50) {
                        this.f11900l = j;
                        j = this;
                        f11891k = i9 + 1;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class b implements ILog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.apm.insight.log.a.a f11901a;

        public b(com.apm.insight.log.a.a aVar) {
            this.f11901a = aVar;
        }

        @Override // com.apm.insight.log.ILog
        public final void asyncFlush() {
            this.f11901a.b();
        }

        @Override // com.apm.insight.log.ILog
        public final void d(String str, String str2) {
            if (a.b(3, str)) {
                this.f11901a.b(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void e(String str, String str2) {
            if (a.b(6, str)) {
                this.f11901a.e(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final List<String> getFiles(long j, long j8) throws Throwable {
            ArrayList arrayList = new ArrayList();
            try {
                File[] fileArrA = this.f11901a.a(j * 1000, j8 * 1000);
                for (File file : fileArrA) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // com.apm.insight.log.ILog
        public final List<String> getFilesOfAllProcesses(long j, long j8) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] fileArrA = this.f11901a.a((String) null, j * 1000, j8 * 1000);
                for (File file : fileArrA) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // com.apm.insight.log.ILog
        public final long getNativeRef() {
            return this.f11901a.j();
        }

        @Override // com.apm.insight.log.ILog
        public final void i(String str, String str2) {
            if (a.b(4, str)) {
                this.f11901a.c(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void syncFlush() {
            this.f11901a.c();
        }

        @Override // com.apm.insight.log.ILog
        public final void timedSyncFlush(int i9) {
            this.f11901a.a(i9);
        }

        @Override // com.apm.insight.log.ILog
        public final void v(String str, String str2) {
            if (a.b(2, str)) {
                this.f11901a.a(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void w(String str, String str2) {
            if (a.b(5, str)) {
                this.f11901a.d(str, str2);
            }
        }
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
    }

    public static Set<String> b() {
        return f11882d;
    }

    public static void c(String str, String str2) {
        if (b(4, str)) {
            boolean zA = c.a();
            if (zA && f11887i != null) {
                a(4, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = f11884f;
            if (aVar == null || !zA) {
                g.c(str, str2);
            } else {
                aVar.c(str, str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (b(5, str)) {
            boolean zA = c.a();
            if (zA && f11887i != null) {
                a(5, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = f11884f;
            if (aVar == null || !zA) {
                g.d(str, str2);
            } else {
                aVar.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (b(6, str)) {
            boolean zA = c.a();
            if (zA && f11887i != null) {
                a(6, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = f11884f;
            if (aVar == null || !zA) {
                g.e(str, str2);
            } else {
                aVar.e(str, str2);
            }
        }
    }

    public static void f() {
        g.a();
        com.apm.insight.log.a.a aVar = f11884f;
        if (aVar != null) {
            aVar.a();
        }
        if (f11887i != null) {
            f11886h.quit();
            f11886h = null;
            f11887i = null;
        }
    }

    public static void g() {
        g.a();
        com.apm.insight.log.a.a aVar = f11884f;
        if (aVar != null) {
            aVar.a();
        }
        if (f11887i != null) {
            f11886h.quit();
            f11886h = null;
            f11887i = null;
        }
    }

    public static long h() {
        return g.e();
    }

    public static long i() {
        return g.f();
    }

    public static long j() {
        return g.g();
    }

    public static long k() {
        return g.h();
    }

    private static void l() {
        if (j == -1) {
            j = Process.myTid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i9, String str) {
        if (i9 < f11879a) {
            return false;
        }
        return f11882d == null || TextUtils.isEmpty(str) || !f11882d.contains(str);
    }

    public static boolean a(VLogConfig vLogConfig) {
        boolean z8 = false;
        if (vLogConfig == null) {
            return false;
        }
        f11880b = vLogConfig;
        try {
            com.apm.insight.log.a.a.a(new c());
            synchronized (f11889l) {
                try {
                    if (f11888k) {
                        return false;
                    }
                    f11888k = true;
                    f11879a = vLogConfig.getLevel();
                    boolean zA = c.a(vLogConfig.getContext());
                    boolean zIsOffloadMainThreadWrite = vLogConfig.isOffloadMainThreadWrite();
                    if (!zIsOffloadMainThreadWrite && vLogConfig.isMainThreadSpeedUp() && zA) {
                        z8 = true;
                    }
                    if (!zA) {
                        vLogConfig.setMaxDirSize((int) (vLogConfig.getSubProcessMaxDirSizeRatio() * vLogConfig.getMaxDirSize()));
                    }
                    com.apm.insight.log.a.a.b bVarF = new com.apm.insight.log.a.a.b(vLogConfig.getContext()).a("default").a(vLogConfig.getLevel() - 2).a(f11881c).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize()).c(z8 ? (vLogConfig.getMaxDirSize() / 3) << 1 : vLogConfig.getMaxDirSize()).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(zA ? 65536 : 32768).f(zA ? 196608 : 65536);
                    com.apm.insight.log.a.a.d dVar = com.apm.insight.log.a.a.d.f11944a;
                    com.apm.insight.log.a.a.b bVarA = bVarF.a(dVar);
                    com.apm.insight.log.a.a.g gVar = com.apm.insight.log.a.a.g.f11955a;
                    com.apm.insight.log.a.a.b bVarA2 = bVarA.a(gVar);
                    com.apm.insight.log.a.a.e eVar = com.apm.insight.log.a.a.e.f11948b;
                    g.a(bVarA2.a(eVar).a(vLogConfig.isCompress() ? com.apm.insight.log.a.a.c.f11941b : com.apm.insight.log.a.a.c.f11940a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.f.f11951b : com.apm.insight.log.a.a.f.f11950a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.EnumC0151a.f11919b : com.apm.insight.log.a.a.EnumC0151a.f11918a).d(vLogConfig.getPubKey()).a());
                    if (zIsOffloadMainThreadWrite && zA) {
                        HandlerThread handlerThread = new HandlerThread("volc_log_delegate");
                        f11886h = handlerThread;
                        handlerThread.start();
                        f11887i = new com.apm.insight.log.b(f11886h.getLooper());
                    }
                    if (z8) {
                        f11884f = new com.apm.insight.log.a.a.b(vLogConfig.getContext()).a("main").a(vLogConfig.getLevel() - 2).a(f11881c).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize() / 2).c(vLogConfig.getMaxDirSize() / 3).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(32768).f(98304).a(dVar).a(gVar).a(eVar).a(vLogConfig.isCompress() ? com.apm.insight.log.a.a.c.f11941b : com.apm.insight.log.a.a.c.f11940a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.f.f11951b : com.apm.insight.log.a.a.f.f11950a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.EnumC0151a.f11919b : com.apm.insight.log.a.a.EnumC0151a.f11918a).d(vLogConfig.getPubKey()).a();
                    }
                    vLogConfig.getBufferDirPath();
                    vLogConfig.getLogDirPath();
                    f11883e = true;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(String str, String str2) {
        if (b(3, str)) {
            boolean zA = c.a();
            if (zA && f11887i != null) {
                a(3, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = f11884f;
            if (aVar != null && zA) {
                aVar.b(str, str2);
            } else {
                g.b(str, str2);
            }
        }
    }

    public static void c() {
        Handler handler = f11887i;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        g.b();
        com.apm.insight.log.a.a aVar = f11884f;
        if (aVar != null) {
            aVar.b();
        }
        Iterator<com.apm.insight.log.a.a> it = f11885g.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public static HashMap<String, String> d() {
        return g.c();
    }

    public static String e() {
        try {
            return g.d();
        } catch (Exception unused) {
            return "getStatus exception";
        }
    }

    public static void a(boolean z8) {
        f11881c = z8;
        g.a(z8);
        com.apm.insight.log.a.a aVar = f11884f;
        if (aVar != null) {
            aVar.a(f11881c);
        }
    }

    public static boolean a() {
        return f11883e;
    }

    public static void a(Set<String> set) {
        f11882d = Collections.unmodifiableSet(set);
    }

    public static void a(String str, String str2) {
        if (b(2, str)) {
            boolean zA = c.a();
            if (zA && f11887i != null) {
                a(2, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = f11884f;
            if (aVar != null && zA) {
                aVar.a(str, str2);
            } else {
                g.a(str, str2);
            }
        }
    }

    public static void a(int i9) {
        f11879a = i9;
        int i10 = i9 - 2;
        g.a(i10);
        com.apm.insight.log.a.a aVar = f11884f;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    private static void a(int i9, String str, String str2) {
        a(i9, str, str2, null, 0, null);
    }

    private static void a(int i9, String str, String str2, Throwable th, int i10, Object obj) {
        l();
        C0150a c0150aA = C0150a.a();
        c0150aA.f11892a = i9;
        c0150aA.f11893b = str;
        c0150aA.f11894c = str2;
        c0150aA.f11895d = null;
        c0150aA.f11896e = 0;
        c0150aA.f11897f = null;
        c0150aA.f11898g = j;
        c0150aA.f11899h = System.currentTimeMillis();
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = c0150aA;
        f11887i.sendMessage(messageObtain);
    }

    public static b a(String str) {
        com.apm.insight.log.a.a aVar = f11885g.get(str);
        if (aVar == null) {
            return null;
        }
        return new b(aVar);
    }

    public static b a(String str, VLogConfig vLogConfig) {
        if (vLogConfig == null) {
            return null;
        }
        if (!f11883e) {
            try {
                com.apm.insight.log.a.a.a(new c());
            } catch (Throwable unused) {
                return null;
            }
        }
        if (!c.a(vLogConfig.getContext())) {
            vLogConfig.setMaxDirSize((int) (vLogConfig.getSubProcessMaxDirSizeRatio() * vLogConfig.getMaxDirSize()));
        }
        com.apm.insight.log.a.a aVarA = new com.apm.insight.log.a.a.b(vLogConfig.getContext()).a(str).a(vLogConfig.getLevel() - 2).a(f11881c).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize()).c(vLogConfig.getMaxDirSize()).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(65536).f(196608).a(com.apm.insight.log.a.a.d.f11944a).a(com.apm.insight.log.a.a.g.f11955a).a(com.apm.insight.log.a.a.e.f11948b).a(vLogConfig.isCompress() ? com.apm.insight.log.a.a.c.f11941b : com.apm.insight.log.a.a.c.f11940a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.f.f11951b : com.apm.insight.log.a.a.f.f11950a).a(vLogConfig.isEncrypt() ? com.apm.insight.log.a.a.EnumC0151a.f11919b : com.apm.insight.log.a.a.EnumC0151a.f11918a).d(vLogConfig.getPubKey()).a();
        if (aVarA == null) {
            return null;
        }
        f11885g.put(str, aVarA);
        return new b(aVarA);
    }

    public static void a(String str, Context context, boolean z8) {
        String strD;
        String logDirPath;
        String strB = c.b();
        if (strB == null || strB.contains(Constants.COLON_SEPARATOR)) {
            return;
        }
        if (!z8) {
            strB = strB.concat(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        VLogConfig vLogConfig = f11880b;
        if (vLogConfig != null) {
            logDirPath = vLogConfig.getLogDirPath();
            strD = f11880b.getBufferDirPath();
        } else {
            String absolutePath = c.c(context).getAbsolutePath();
            strD = c.d(context);
            logDirPath = absolutePath;
        }
        File file = new File(logDirPath);
        if (file.exists() && file.isDirectory()) {
            String strI = A.a.i("__", str, ".alog.hot");
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name != null && name.endsWith(strI) && name.contains(strB)) {
                    file2.delete();
                }
            }
            File file3 = new File(strD);
            if (file3.exists() && file3.isDirectory()) {
                String strL = e.l("__", str);
                for (File file4 : file3.listFiles()) {
                    String name2 = file4.getName();
                    if (name2 != null && name2.contains(strL) && name2.contains(strB)) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public static /* synthetic */ void a(C0150a c0150a) {
        int i9 = c0150a.f11892a - 2;
        String string = "";
        if (c0150a.f11896e == 0) {
            if (c0150a.f11895d == null) {
                string = c0150a.f11894c;
            } else {
                StringBuilder sbB = p171w.a.b(c0150a.f11894c != null ? A.a.j(new StringBuilder(), c0150a.f11894c, "\n") : "");
                sbB.append(c.a(c0150a.f11895d));
                string = sbB.toString();
            }
        }
        g.a(i9, c0150a.f11893b, string, c0150a.f11898g, c0150a.f11899h);
        c0150a.b();
    }
}
