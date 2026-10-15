package V0;

/* JADX INFO: compiled from: EventsSenderUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4813a;

    static {
        g gVar;
        try {
            Object objInvoke = Class.forName("com.bytedance.applog.et_verify.EventVerify").getMethod("inst", new Class[0]).invoke(null, new Object[0]);
            gVar = objInvoke instanceof g ? (g) objInvoke : null;
            if (gVar == null) {
                m.a("can't find event verify, should compile with ET", null);
            } else {
                m.a(gVar.toString(), null);
            }
        } catch (Exception unused) {
            gVar = null;
        } catch (Throwable th) {
            m.a("can't find event verify, should compile with ET", null);
            throw th;
        }
        f4813a = gVar;
    }
}
