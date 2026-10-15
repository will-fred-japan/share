package com.apm.insight.log.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f11902a = d.f11944a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f11903b = g.f11955a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11904c = e.f11947a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f11905d = c.f11941b.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f11906e = f.f11951b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f11907f = EnumC0151a.f11919b.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ArrayList<String> f11908g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f11909h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f11910i;
    private int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11912l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11913m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11914n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f11915o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f11916p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f11917q;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: com.apm.insight.log.a.a$a, reason: collision with other inner class name */
    public static final class EnumC0151a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0151a f11918a = new EnumC0151a("NONE", 0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0151a f11919b = new EnumC0151a("EC_SECP256K1", 1, 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static EnumC0151a f11920c = new EnumC0151a("EC_SECP256R1", 2, 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f11921d;

        private EnumC0151a(String str, int i9, int i10) {
            super(str, i9);
            this.f11921d = i10;
        }

        public final int a() {
            return this.f11921d;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f11922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11923b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11924c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11925d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11926e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11927f = 2097152;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11928g = 20971520;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f11929h = 7;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f11930i = null;
        private int j = 65536;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f11931k = 196608;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f11932l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f11933m = a.f11902a;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f11934n = a.f11903b;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f11935o = a.f11904c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f11936p = a.f11905d;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f11937q = a.f11906e;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f11938r = a.f11907f;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f11939s = "44817d17adcfd1bc735c022b368acfe0465c4bdbc5c77ca8efd6b578dad1177a65f83813d3f3da839778719efbb83d982737c55597b1a074f105d828a8163b42";

        public b(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.f11922a = applicationContext != null ? applicationContext : context;
        }

        public final b a(int i9) {
            this.f11923b = i9;
            return this;
        }

        public final b b(String str) {
            this.f11926e = str;
            return this;
        }

        public final b c(int i9) {
            this.f11928g = i9;
            return this;
        }

        public final b d(int i9) {
            this.f11929h = i9;
            return this;
        }

        public final b e(int i9) {
            this.j = i9;
            return this;
        }

        public final b f(int i9) {
            this.f11931k = i9;
            return this;
        }

        public final b a(boolean z8) {
            this.f11924c = z8;
            return this;
        }

        public final b b(int i9) {
            this.f11927f = i9;
            return this;
        }

        public final b c(String str) {
            this.f11930i = str;
            return this;
        }

        public final b d(String str) {
            this.f11939s = str;
            return this;
        }

        public final b a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    str = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                }
                if (str.contains(BundleUtil.UNDERLINE_TAG)) {
                    str = str.replace(BundleUtil.UNDERLINE_TAG, "");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f11925d = str;
                }
            }
            return this;
        }

        public final b a(d dVar) {
            this.f11933m = dVar.a();
            return this;
        }

        public final b a(g gVar) {
            this.f11934n = gVar.a();
            return this;
        }

        public final b a(e eVar) {
            this.f11935o = eVar.a();
            return this;
        }

        public final b a(c cVar) {
            this.f11936p = cVar.a();
            return this;
        }

        public final b a(f fVar) {
            this.f11937q = fVar.a();
            return this;
        }

        public final b a(EnumC0151a enumC0151a) {
            this.f11938r = enumC0151a.a();
            return this;
        }

        public final a a() {
            if (this.f11925d == null) {
                this.f11925d = "default";
            }
            synchronized (a.f11908g) {
                try {
                    Iterator it = a.f11908g.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals(this.f11925d)) {
                            return null;
                        }
                    }
                    a.f11908g.add(this.f11925d);
                    if (this.f11926e == null) {
                        this.f11926e = com.apm.insight.log.c.c(this.f11922a).getAbsolutePath();
                    }
                    if (this.f11930i == null) {
                        this.f11930i = com.apm.insight.log.c.d(this.f11922a);
                    }
                    if (this.f11932l == null) {
                        this.f11932l = com.apm.insight.log.c.b(this.f11922a);
                    }
                    int i9 = (this.j / 4096) << 12;
                    this.j = i9;
                    int i10 = (this.f11931k / 4096) << 12;
                    this.f11931k = i10;
                    if (i9 < 4096) {
                        this.j = 4096;
                    }
                    int i11 = this.j;
                    if (i10 < (i11 << 1)) {
                        this.f11931k = i11 << 1;
                    }
                    return new a(this.f11922a, this.f11923b, this.f11924c, this.f11925d, this.f11926e, this.f11927f, this.f11928g, this.f11929h, this.f11930i, this.j, this.f11931k, this.f11932l, this.f11933m, this.f11934n, this.f11935o, this.f11936p, this.f11937q, this.f11938r, this.f11939s);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f11943d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11940a = new c("NONE", 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static c f11942c = new c("ZLIB", 1, 1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f11941b = new c("ZSTD", 2, 2);

        private c(String str, int i9, int i10) {
            super(str, i9);
            this.f11943d = i10;
        }

        public final int a() {
            return this.f11943d;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11946c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static d f11945b = new d("SPEED", 0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11944a = new d("SAFE", 1, 1);

        private d(String str, int i9, int i10) {
            super(str, i9);
            this.f11946c = i10;
        }

        public final int a() {
            return this.f11946c;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11947a = new e("DEFAULT", 0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f11948b = new e("LEGACY", 1, 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11949c;

        private e(String str, int i9, int i10) {
            super(str, i9);
            this.f11949c = i10;
        }

        public final int a() {
            return this.f11949c;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f11950a = new f("NONE", 0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f11951b = new f("TEA_16", 1, 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static f f11952c = new f("TEA_32", 2, 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static f f11953d = new f("TEA_64", 3, 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f11954e;

        private f(String str, int i9, int i10) {
            super(str, i9);
            this.f11954e = i10;
        }

        public final int a() {
            return this.f11954e;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f11955a = new g("RAW", 0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static g f11956b = new g("ISO_8601", 1, 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11957c;

        private g(String str, int i9, int i10) {
            super(str, i9);
            this.f11957c = i10;
        }

        public final int a() {
            return this.f11957c;
        }
    }

    public a(Context context, int i9, boolean z8, String str, String str2, int i10, int i11, int i12, String str3, int i13, int i14, String str4, int i15, int i16, int i17, int i18, int i19, int i20, String str5) {
        this.f11910i = context;
        this.j = i9;
        this.f11911k = str2;
        this.f11912l = str3;
        this.f11913m = i13;
        this.f11914n = i14 / i13;
        this.f11916p = str;
        this.f11917q = a(i9, z8, str, str2, i10, i11, i12, str3, i13, i14, str4, i15, i16, i17, i18, i19, i20, str5);
    }

    private static native long a(int i9, boolean z8, String str, String str2, int i10, int i11, int i12, String str3, int i13, int i14, String str4, int i15, int i16, int i17, int i18, int i19, int i20, String str5);

    public static native void a(long j);

    private static native void a(long j, int i9);

    private static native void a(long j, int i9, String str, String str2);

    private static native void a(long j, int i9, String str, String str2, long j8, long j9);

    private static native void a(long j, boolean z8);

    public static synchronized void a(com.apm.insight.log.a.f fVar) {
        if (f11909h) {
            return;
        }
        fVar.c();
        f11909h = true;
    }

    private static native void b(long j);

    private static native void b(long j, int i9);

    private static native void c(long j);

    private static native void d(long j);

    public static HashMap<String, String> h() {
        return com.apm.insight.log.a.c.a();
    }

    private static native long s();

    private static native long t();

    private static native long u();

    private static native long v();

    public final void b() {
        long j = this.f11917q;
        if (j != 0) {
            b(j);
        }
    }

    public final void c() {
        long j = this.f11917q;
        if (j != 0) {
            c(j);
        }
    }

    public final long d() {
        if (this.f11917q != 0) {
            return s();
        }
        return 0L;
    }

    public final long e() {
        if (this.f11917q != 0) {
            return t();
        }
        return 0L;
    }

    public final long f() {
        if (this.f11917q != 0) {
            return u();
        }
        return 0L;
    }

    public final void finalize() {
        try {
            super.finalize();
        } finally {
            a();
        }
    }

    public final long g() {
        if (this.f11917q != 0) {
            return v();
        }
        return 0L;
    }

    public final String i() {
        String str;
        File file;
        if (!f11909h) {
            return "not inited";
        }
        if (this.f11915o == null) {
            this.f11915o = com.apm.insight.log.c.b();
        }
        String str2 = this.f11915o;
        if (str2 == null) {
            return "get process name failed";
        }
        String strReplace = str2.replace(':', '-');
        File file2 = new File(this.f11912l);
        if (!file2.exists()) {
            return "cache dir not exists";
        }
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles == null) {
            return "cache dir is empty";
        }
        String strJ = A.a.j(p171w.a.c(strReplace, "__"), this.f11916p, ".alog.cache.guard");
        Pattern patternCompile = Pattern.compile("^" + Pattern.quote(strReplace) + "__" + Pattern.quote(this.f11916p) + "__\\d{5}\\.alog\\.cache$");
        int length = fileArrListFiles.length;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i9 < length) {
            File file3 = fileArrListFiles[i9];
            if (file3.getName().equals(strJ)) {
                i10++;
                if (file3.length() >= 24576) {
                    i11++;
                }
                str = strReplace;
            } else {
                String name = file3.getName();
                StringBuilder sbC = p171w.a.c(strReplace, "__");
                str = strReplace;
                sbC.append(this.f11916p);
                sbC.append("__");
                if (name.startsWith(sbC.toString()) && patternCompile.matcher(file3.getName()).find()) {
                    i12++;
                    file = file2;
                    if (file3.length() >= this.f11913m) {
                        i13++;
                    }
                }
                i9++;
                file2 = file;
                strReplace = str;
            }
            file = file2;
            i9++;
            file2 = file;
            strReplace = str;
        }
        String str3 = strReplace;
        File file4 = file2;
        if (i10 <= 0) {
            Log.d("alog_trace", strJ);
            Log.d("alog_trace", file4.getAbsolutePath());
            return "cache guard not exists";
        }
        if (i11 <= 0) {
            return "cache guard size insufficiently";
        }
        int i14 = this.f11914n;
        if (i12 < i14) {
            return "cache block count insufficiently";
        }
        if (i13 < i14) {
            return "cache block size insufficiently";
        }
        File file5 = new File(this.f11911k);
        if (!file5.exists()) {
            return "log dir not exists";
        }
        File[] fileArrListFiles2 = file5.listFiles(new com.apm.insight.log.a.b(this, Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(str3) + "__" + Pattern.quote(this.f11916p) + "\\.vlog$")));
        return (fileArrListFiles2 == null || fileArrListFiles2.length == 0) ? "no log file for current process and instance" : "OK";
    }

    public final long j() {
        return this.f11917q;
    }

    public final void d(String str, String str2) {
        a(3, str, str2);
    }

    public final void e(String str, String str2) {
        a(4, str, str2);
    }

    public final void b(int i9) {
        this.j = i9;
        long j = this.f11917q;
        if (j != 0) {
            b(j, i9);
        }
    }

    public final void c(String str, String str2) {
        a(2, str, str2);
    }

    public final void a() {
        synchronized (this) {
            try {
                long j = this.f11917q;
                if (j != 0) {
                    this.f11910i = null;
                    this.j = 6;
                    d(j);
                    this.f11917q = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str, String str2) {
        a(1, str, str2);
    }

    public final void a(int i9, String str, String str2) {
        long j = this.f11917q;
        if (j == 0 || i9 < this.j || str == null || str2 == null) {
            return;
        }
        a(j, i9, str, str2);
    }

    public final void a(int i9, String str, String str2, long j, long j8) {
        long j9 = this.f11917q;
        if (j9 == 0 || i9 < this.j || str == null || str2 == null) {
            return;
        }
        a(j9, i9, str, str2, j, j8);
    }

    public final void a(int i9) {
        long j = this.f11917q;
        if (j != 0) {
            a(j, i9);
        }
    }

    public final void a(boolean z8) {
        long j = this.f11917q;
        if (j != 0) {
            a(j, z8);
        }
    }

    public final void a(String str, String str2) {
        a(0, str, str2);
    }

    public final File[] a(long j, long j8) throws Throwable {
        if (this.f11915o == null) {
            String strB = com.apm.insight.log.c.b();
            this.f11915o = strB;
            if (strB == null) {
                return new File[0];
            }
        }
        return com.apm.insight.log.a.c.a(this.f11911k, this.f11915o, this.f11916p, j, j8, -1);
    }

    public final File[] a(String str, long j, long j8) {
        return a((String) null, this.f11916p, j, j8);
    }

    public final File[] a(String str, String str2, long j, long j8) {
        return com.apm.insight.log.a.c.a(this.f11911k, str, str2, j, j8, -1);
    }

    public final File[] a(boolean z8, long j, long j8, int i9) throws Throwable {
        String strB = null;
        if (z8) {
            String str = this.f11915o;
            strB = str != null ? str : null;
            if (strB == null) {
                strB = com.apm.insight.log.c.b();
            }
            if (strB == null) {
                return new File[0];
            }
        }
        return com.apm.insight.log.a.c.a(this.f11911k, strB, null, j, j8, i9);
    }
}
