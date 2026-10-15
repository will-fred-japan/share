package K1;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LooperMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f2783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<L1.a> f2784c = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static M1.c f2785d;

    /* JADX INFO: compiled from: LooperMonitor.java */
    public class a implements Printer {
        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.charAt(0) == '>') {
                d.b(true, str);
            } else if (str.charAt(0) == '<') {
                d.b(false, str);
            }
        }
    }

    public static void a() {
        Printer printer;
        if (f2782a) {
            return;
        }
        f2782a = true;
        f2783b = new a();
        if (!A4.a.f1453b) {
            A4.a.f1453b = true;
            A4.a.C0000a c0000a = new A4.a.C0000a();
            c0000a.f1454a = new ArrayList();
            new ArrayList();
            c0000a.f1455b = new ArrayList();
            c0000a.f1456c = false;
            A4.a.f1452a = c0000a;
            try {
                Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
                declaredField.setAccessible(true);
                printer = (Printer) declaredField.get(Looper.getMainLooper());
            } catch (Exception unused) {
                printer = null;
            }
            if (printer != null) {
                A4.a.f1452a.f1454a.add(printer);
            }
            Looper.getMainLooper().setMessageLogging(A4.a.f1452a);
        }
        a aVar = f2783b;
        if (aVar == null || A4.a.f1452a.f1455b.contains(aVar)) {
            return;
        }
        A4.a.f1452a.f1455b.add(aVar);
        A4.a.f1452a.f1456c = true;
    }

    public static void b(boolean z8, String str) {
        M1.c cVar;
        M1.c cVar2;
        if (z8 && (cVar2 = f2785d) != null && cVar2.f2879b.f2885a) {
            f2785d.b(str);
        }
        for (L1.a aVar : f2784c) {
            if (aVar.c()) {
                if (z8) {
                    if (!aVar.f2831a) {
                        aVar.b(str);
                    }
                } else if (aVar.f2831a) {
                    aVar.a();
                }
            } else if (!z8 && aVar.f2831a) {
                aVar.a();
            }
        }
        if (z8 || (cVar = f2785d) == null || !cVar.f2879b.f2885a) {
            return;
        }
        f2785d.a();
    }
}
