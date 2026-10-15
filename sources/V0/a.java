package V0;

/* JADX INFO: compiled from: AbsSingleton.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f4802b;

    public abstract Object a(Object... objArr);

    public final Object b(Object... objArr) {
        switch (this.f4801a) {
            case 0:
                if (this.f4802b == null) {
                    synchronized (this) {
                        try {
                            if (this.f4802b == null) {
                                this.f4802b = a(objArr);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                return this.f4802b;
            default:
                if (this.f4802b == null) {
                    synchronized (this) {
                        try {
                            if (this.f4802b == null) {
                                this.f4802b = a(objArr);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return this.f4802b;
        }
    }
}
