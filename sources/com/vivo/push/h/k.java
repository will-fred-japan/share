package com.vivo.push.h;

/* JADX INFO: compiled from: OnClearCacheReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class k extends ag {
    public k(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.util.w.d("OnClearCacheTask", "delete push info " + this.f16804a.getPackageName());
        com.vivo.push.util.ai.b(this.f16804a).a();
    }
}
