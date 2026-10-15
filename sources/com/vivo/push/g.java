package com.vivo.push;

/* JADX INFO: compiled from: ClientSdkQueryResultDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<g> f16602a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16604c;

    public g(com.vivo.push.restructure.request.a.a.a aVar) {
        this.f16603b = aVar.a();
        this.f16604c = aVar.c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f16603b);
        aVar.a(this.f16604c);
        return aVar.e();
    }

    public final String b() {
        return this.f16604c;
    }
}
