package com.vivo.push.restructure.request.a;

import com.vivo.push.util.w;
import org.json.JSONException;

/* JADX INFO: compiled from: CFToClientDS.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<a> f16772a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16778g;

    public a(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f16773b = aVar.c();
            this.f16774c = aVar.a();
            this.f16776e = aVar.b();
            this.f16777f = aVar.a();
            this.f16775d = aVar.a();
            this.f16778g = aVar.a();
        } catch (JSONException e9) {
            w.a("CFToClientDS", e9);
        }
    }

    public final int a() {
        return this.f16774c;
    }

    public final int b() {
        return this.f16777f;
    }

    public final int c() {
        return this.f16778g;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f16773b);
        aVar.a(this.f16774c);
        aVar.a(this.f16776e);
        aVar.a(this.f16777f);
        aVar.a(this.f16775d);
        aVar.a(this.f16778g);
    }
}
