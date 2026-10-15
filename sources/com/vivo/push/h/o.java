package com.vivo.push.h;

/* JADX INFO: compiled from: OnDispatcherReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends ag {
    public o(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) wVar;
        int iE = lVar.e();
        int iF = lVar.f();
        com.vivo.push.util.ag.c().a("key_dispatch_environment", iE);
        com.vivo.push.util.ag.c().a("key_dispatch_area", iF);
        com.vivo.push.util.w.d("OnDispatcherReceiveTask", "environment  and area=" + iE + "  ; " + iF);
    }
}
