package p011b4;

/* JADX INFO: loaded from: classes.dex */
public final class k extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f8573c;

    public k(j jVar) {
        this.f8573c = jVar;
    }

    @Override // p011b4.g
    public final void a(String str) {
        this.f8573c.j = str;
        this.f8540a = true;
        j.c(this.f8573c, true, g.f8539b);
    }

    @Override // p011b4.g
    public final void b() {
        this.f8540a = false;
        j jVar = this.f8573c;
        jVar.f8549a++;
        j.c(jVar, false, g.f8539b);
        j jVar2 = this.f8573c;
        jVar2.f8557i = jVar2.j;
        jVar2.j = "no message running";
    }
}
