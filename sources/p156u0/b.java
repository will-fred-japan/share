package p156u0;

import android.os.Trace;

/* JADX INFO: compiled from: TraceApi29Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(int i9, String str) {
        Trace.beginAsyncSection(str, i9);
    }

    public static void b(int i9, String str) {
        Trace.endAsyncSection(str, i9);
    }

    public static boolean c() {
        return Trace.isEnabled();
    }
}
