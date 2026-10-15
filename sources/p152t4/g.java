package p152t4;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g f21424d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21425a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f21426b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21427c = new ArrayList();

    public static class a implements Printer {
        @Override // android.util.Printer
        public final void println(String str) {
            if (str == null) {
                return;
            }
            if (str.charAt(0) == '>') {
                g gVarA = g.a();
                gVarA.f21425a = -1L;
                try {
                    g.b(str, gVarA.f21426b);
                    return;
                } catch (Exception e9) {
                    j.f(e9);
                    return;
                }
            }
            if (str.charAt(0) == '<') {
                g gVarA2 = g.a();
                gVarA2.getClass();
                gVarA2.f21425a = SystemClock.uptimeMillis();
                try {
                    g.b(str, gVarA2.f21427c);
                } catch (Exception e10) {
                    j.m(e10);
                }
            }
        }
    }

    public static g a() {
        if (f21424d == null) {
            synchronized (g.class) {
                try {
                    if (f21424d == null) {
                        f21424d = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21424d;
    }

    public static void b(String str, ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        try {
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                Printer printer = (Printer) arrayList.get(i9);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            j.f(th);
        }
    }
}
