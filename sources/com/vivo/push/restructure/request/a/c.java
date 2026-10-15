package com.vivo.push.restructure.request.a;

import org.json.JSONException;

/* JADX INFO: compiled from: CFToCoreDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<c> f16782a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16786e;

    public c(int i9, int i10) {
        this.f16783b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f16784c = i9;
        this.f16785d = 363L;
        this.f16786e = i10;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f16783b);
        aVar.a(this.f16784c);
        aVar.a(this.f16785d);
        aVar.a(this.f16786e);
    }

    public c(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f16783b = aVar.c();
            this.f16784c = aVar.a();
            this.f16785d = aVar.b();
            this.f16786e = aVar.a();
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }
}
