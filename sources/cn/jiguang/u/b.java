package cn.jiguang.u;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10793a = "D";

    static {
        try {
            if (b.class.getCanonicalName().startsWith("cn.p.jiguang")) {
                f10793a = "D-P";
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2) {
        a.a(f10793a, str, true, 2, str2, null);
    }

    public static void b(String str, String str2) {
        a.a(f10793a, str, true, 3, str2, null);
    }

    public static void c(String str, String str2) {
        a.a(f10793a, str, false, 3, str2, null);
    }

    public static void d(String str, String str2) {
        a.a(f10793a, str, false, 4, str2, null);
    }

    public static void e(String str, String str2) {
        a.a(f10793a, str, true, 5, str2, null);
    }

    public static void f(String str, String str2) {
        a.a(f10793a, str, false, 5, str2, null);
    }

    public static void g(String str, String str2) {
        a.a(f10793a, str, true, 6, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a.a(f10793a, str, true, 5, str2, th);
    }
}
