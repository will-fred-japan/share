package p188x7;

import F7.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f22363a = new j();

    public static void a(Throwable th, Throwable exception) {
        k.e(th, "<this>");
        k.e(exception, "exception");
        if (th != exception) {
            b.f2051a.a(th, exception);
        }
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        k.d(string, "toString(...)");
        return string;
    }
}
