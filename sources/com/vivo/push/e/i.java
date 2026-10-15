package com.vivo.push.e;

import com.vivo.push.util.w;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f16596a;

    public i(h hVar) {
        this.f16596a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        com.vivo.push.e.a.b bVar2 = (com.vivo.push.e.a.b) bVar;
        if (this.f16596a.f16594a != null) {
            w.e("query success");
            this.f16596a.f16594a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i9) {
        if (this.f16596a.f16594a != null) {
            w.e("query err : ".concat(String.valueOf(i9)));
            this.f16596a.f16594a.onError(i9);
        }
    }
}
