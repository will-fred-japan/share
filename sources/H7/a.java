package H7;

/* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends G7.a {

    /* JADX INFO: renamed from: H7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
    public static final class C0021a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f2532a;

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
            f2532a = num2;
        }
    }
}
