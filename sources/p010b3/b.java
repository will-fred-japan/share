package p010b3;

import android.util.Log;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f8497a = new a();

    public static void a(String str, String str2) {
        if (f8497a == null || !A1.b.f1393A) {
            return;
        }
        Log.d(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        a aVar = f8497a;
        if (aVar != null) {
            aVar.a(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        a aVar = f8497a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f8497a == null || !A1.b.f1393A) {
            return;
        }
        Log.i(str, str2);
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class a implements p010b3.a {
        @Override // p010b3.a
        public void a(String str, String str2) {
            if (A1.b.f1393A) {
                Log.e(str, str2);
            }
        }

        @Override // p010b3.a
        public void a(String str, String str2, Throwable th) {
            if (A1.b.f1393A) {
                Log.e(str, str2, th);
            }
        }
    }
}
