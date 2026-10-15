package cn.jpush.android.helper;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11424a = 1;

    public static long a() {
        long j = f11424a + 1;
        f11424a = j;
        if (j >= 2147483647L) {
            f11424a = 1L;
        }
        return f11424a;
    }
}
