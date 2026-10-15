package pl.droidsonroids.gif;

/* JADX INFO: compiled from: GifDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f20842b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, d dVar2) {
        super(dVar2);
        this.f20842b = dVar;
    }

    @Override // pl.droidsonroids.gif.m
    public final void a() {
        d dVar = this.f20842b;
        if (dVar.f20849g.p()) {
            dVar.start();
        }
    }
}
