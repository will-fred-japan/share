package com.vivo.push.e;

/* JADX INFO: compiled from: ProfileInfoDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<b> f16584a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16585b;

    public b(String str) {
        this.f16585b = str;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f16585b);
        return aVar.e();
    }

    public final String b() {
        return this.f16585b;
    }

    public b(com.vivo.push.restructure.request.a.a.a aVar) {
        this.f16585b = aVar.c();
    }
}
