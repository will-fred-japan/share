package com.vivo.push;

/* JADX INFO: compiled from: ClientSdkQueryParemeterDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.vivo.push.restructure.request.a.a.c.a<e> f16574a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16579f;

    public e(int i9, String str, String str2, String str3, String str4) {
        this.f16575b = i9;
        this.f16576c = str;
        this.f16577d = str2;
        this.f16578e = str3;
        this.f16579f = str4;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f16575b);
        aVar.a(this.f16576c);
        aVar.a(this.f16577d);
        aVar.a(this.f16578e);
        aVar.a(this.f16579f);
        return aVar.e();
    }

    public e(com.vivo.push.restructure.request.a.a.a aVar) {
        this.f16575b = aVar.a();
        this.f16576c = aVar.c();
        this.f16577d = aVar.c();
        this.f16578e = aVar.c();
        this.f16579f = aVar.c();
    }
}
