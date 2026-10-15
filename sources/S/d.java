package S;

/* JADX INFO: compiled from: Pools.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<T> extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4091c;

    public d(int i9) {
        super(i9);
        this.f4091c = new Object();
    }

    @Override // S.c
    public final T d() {
        T t;
        synchronized (this.f4091c) {
            t = (T) super.d();
        }
        return t;
    }

    @Override // S.c
    public final boolean f(T t) {
        boolean zF;
        synchronized (this.f4091c) {
            zF = super.f(t);
        }
        return zF;
    }
}
