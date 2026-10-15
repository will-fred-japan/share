package S7;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f4230a;

    static {
        String property;
        T7.d dVar;
        int i9 = X7.u.f5171a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            Z7.c cVar = J.f4233a;
            T7.d dVar2 = X7.o.f5165a;
            dVar2.getClass();
            dVar = !(dVar2 instanceof F) ? D.j : dVar2;
        } else {
            dVar = D.j;
        }
        f4230a = dVar;
    }
}
