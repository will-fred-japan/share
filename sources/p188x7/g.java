package p188x7;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final f.a a(Throwable exception) {
        k.e(exception, "exception");
        return new f.a(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof f.a) {
            throw ((f.a) obj).f22356a;
        }
    }
}
