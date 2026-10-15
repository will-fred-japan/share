package com.vivo.push.d;

import org.json.JSONException;

/* JADX INFO: compiled from: NotifyGuideInput.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<g> f16567a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16571e;

    public g(int i9, boolean z8) {
        this.f16569c = i9;
        this.f16570d = 1;
        this.f16571e = z8;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f16568b);
        aVar.a(this.f16569c);
        aVar.a(this.f16570d);
        aVar.a(this.f16571e);
    }

    public g(long j, int i9, boolean z8) {
        this.f16568b = j;
        this.f16569c = i9;
        this.f16570d = 2;
        this.f16571e = z8;
    }

    public g(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f16568b = aVar.b();
            this.f16569c = aVar.a();
            this.f16570d = aVar.a();
            this.f16571e = aVar.d();
        } catch (JSONException e9) {
            throw new RuntimeException(e9);
        }
    }
}
