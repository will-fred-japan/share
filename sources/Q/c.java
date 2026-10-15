package Q;

/* JADX INFO: compiled from: CallbackWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K.d.a f3649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P.c f3650b;

    public c(K.d.a aVar, P.c cVar) {
        this.f3649a = aVar;
        this.f3650b = cVar;
    }

    public final void a(k.a aVar) {
        int i9 = aVar.f3678b;
        P.c cVar = this.f3650b;
        K.d.a aVar2 = this.f3649a;
        if (i9 != 0) {
            cVar.execute(new b(aVar2, i9));
        } else {
            cVar.execute(new a(0, aVar2, aVar.f3677a));
        }
    }
}
