package R6;

/* JADX INFO: compiled from: FileSelectorAndroidPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements p042f7.a, p050g7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f4036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f7.a.b f4037b;

    @Override // p050g7.a
    public final void onAttachedToActivity(p050g7.b bVar) {
        k kVar = new k(bVar);
        this.f4036a = kVar;
        g.a aVar = g.f4045a;
        p096m7.c cVar = this.f4037b.f18713c;
        aVar.getClass();
        g.a.a(cVar, kVar);
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b bVar) {
        this.f4037b = bVar;
    }

    @Override // p050g7.a
    public final void onDetachedFromActivity() {
        k kVar = this.f4036a;
        if (kVar != null) {
            kVar.f4054b = null;
        }
    }

    @Override // p050g7.a
    public final void onDetachedFromActivityForConfigChanges() {
        k kVar = this.f4036a;
        if (kVar != null) {
            kVar.f4054b = null;
        }
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b bVar) {
        this.f4037b = null;
    }

    @Override // p050g7.a
    public final void onReattachedToActivityForConfigChanges(p050g7.b bVar) {
        k kVar = this.f4036a;
        if (kVar != null) {
            kVar.f4054b = bVar;
            return;
        }
        k kVar2 = new k(bVar);
        this.f4036a = kVar2;
        g.a aVar = g.f4045a;
        p096m7.c cVar = this.f4037b.f18713c;
        aVar.getClass();
        g.a.a(cVar, kVar2);
    }
}
