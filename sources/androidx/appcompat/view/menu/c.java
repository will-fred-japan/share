package androidx.appcompat.view.menu;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.d f6107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f6108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f6109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b.c f6110d;

    public c(b.c cVar, b.d dVar, h hVar, f fVar) {
        this.f6110d = cVar;
        this.f6107a = dVar;
        this.f6108b = hVar;
        this.f6109c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.d dVar = this.f6107a;
        if (dVar != null) {
            b.c cVar = this.f6110d;
            b.this.f6100z = true;
            dVar.f6105b.c(false);
            b.this.f6100z = false;
        }
        h hVar = this.f6108b;
        if (hVar.isEnabled() && hVar.hasSubMenu()) {
            this.f6109c.q(hVar, null, 4);
        }
    }
}
