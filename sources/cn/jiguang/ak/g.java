package cn.jiguang.ak;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile cn.jiguang.al.i f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9214b = new Object();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cn.jiguang.al.i f9215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final cn.jiguang.al.i f9216b;

        public a(cn.jiguang.al.i iVar, cn.jiguang.al.i iVar2) {
            this.f9216b = iVar;
            this.f9215a = iVar2;
        }
    }

    public cn.jiguang.al.i a() {
        cn.jiguang.al.i iVarClone;
        synchronized (this.f9214b) {
            try {
                iVarClone = this.f9213a != null ? this.f9213a.clone() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVarClone;
    }

    public a b() {
        a aVar;
        synchronized (this.f9214b) {
            try {
                if (this.f9213a != null) {
                    this.f9213a.i();
                }
                cn.jiguang.al.i iVar = this.f9213a;
                this.f9213a = new cn.jiguang.al.i();
                aVar = new a(this.f9213a.clone(), iVar != null ? iVar.clone() : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }
}
