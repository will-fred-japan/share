package V0;

import android.util.Log;

/* JADX INFO: compiled from: TLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static T1.d.a f4821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4822b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4823c;

    static {
        if (String.valueOf(20590).charAt(0) >= '4') {
            f4823c = 10020189;
        } else {
            f4823c = 20590;
        }
    }

    public static void a(String str, Throwable th) {
        T1.d.a aVar = f4821a;
        if (aVar != null) {
            if (T1.d.this.f4478a.isDebug()) {
                Log.i("AppLog", str, th);
            }
        } else if (f4822b) {
            Log.d("AppLog", str, th);
        }
    }

    public static void b(Throwable th) {
        a("U SHALL NOT PASS!", th);
    }
}
