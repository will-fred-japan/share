package G7;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a extends F7.a {

    /* JADX INFO: renamed from: G7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
    public static final class C0020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f2341a;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f2341a = num2;
        }
    }

    @Override // F7.a
    public final void a(Throwable cause, Throwable exception) {
        k.e(cause, "cause");
        k.e(exception, "exception");
        Integer num = C0020a.f2341a;
        if (num == null || num.intValue() >= 19) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
