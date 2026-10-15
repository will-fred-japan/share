package cn.jiguang.ad;

/* JADX INFO: loaded from: classes.dex */
public class m extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g f9006h;

    @Override // cn.jiguang.ad.i
    public void a(b bVar) {
        this.f9003e = bVar.g();
        this.f9004f = bVar.g();
        this.f9005g = bVar.g();
        this.f9006h = new g(bVar);
    }

    @Override // cn.jiguang.ad.i
    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f9003e + " ");
        stringBuffer.append(this.f9004f + " ");
        stringBuffer.append(this.f9005g + " ");
        stringBuffer.append(this.f9006h);
        return stringBuffer.toString();
    }

    public int j() {
        return this.f9005g;
    }

    public g k() {
        return this.f9006h;
    }

    @Override // cn.jiguang.ad.i
    public void a(c cVar, a aVar, boolean z8) {
        cVar.c(this.f9003e);
        cVar.c(this.f9004f);
        cVar.c(this.f9005g);
        this.f9006h.a(cVar, (a) null, z8);
    }
}
