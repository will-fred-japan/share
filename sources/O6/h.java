package O6;

/* JADX INFO: compiled from: DatabaseTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f3516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f3517b;

    public h(j.a aVar, Runnable runnable) {
        this.f3516a = aVar;
        this.f3517b = runnable;
    }

    public final Integer a() {
        j.a aVar = this.f3516a;
        if (aVar != null) {
            return Integer.valueOf(aVar.f3524a.f3506c);
        }
        return null;
    }
}
