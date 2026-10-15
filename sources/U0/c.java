package U0;

/* JADX INFO: compiled from: CacheHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4604a;

    public c(d dVar) {
        this.f4604a = dVar;
    }

    @Override // U0.d.b
    public final boolean a(String str) {
        return V0.o.g(str);
    }

    @Override // U0.d.b
    public final void b(String str) {
        this.f4604a.c("openudid", str);
    }

    @Override // U0.d.b
    public final String c(Object obj, String str, a aVar) {
        String str2 = (String) obj;
        return aVar == null ? str2 : (String) aVar.a(str2, str, new c(aVar));
    }

    @Override // U0.d.b
    public final boolean a(String str, String str2) {
        return V0.o.f(str, str2);
    }

    @Override // U0.d.b
    public final String a() {
        return this.f4604a.d("openudid");
    }
}
