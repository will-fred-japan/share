package p170v7;

import android.os.Trace;

/* JADX INFO: compiled from: TraceSection.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements AutoCloseable {
    public static String a(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void b(String str) {
        Trace.beginSection(p156u0.a.c(a(str)));
    }
}
