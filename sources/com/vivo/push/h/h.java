package com.vivo.push.h;

/* JADX INFO: compiled from: OnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class h extends ag {
    public h(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) wVar;
        String strF = iVar.f();
        com.vivo.push.util.w.d("OnBindTask", "doTask,订阅APP结果 = " + iVar.j() + " clientToken= " + strF);
        com.vivo.push.n.a().a(iVar.i(), iVar.j(), strF);
        com.vivo.push.u.a(new i(this, strF, iVar));
    }
}
