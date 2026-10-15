package com.vivo.push.h;

/* JADX INFO: compiled from: OnUnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class ak extends ag {
    public ak(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) wVar;
        com.vivo.push.util.w.c("OnUnBindTask", "doTask,解订阅APP结果 = " + iVar.j() + " clientToken= " + iVar.f());
        com.vivo.push.n.a().a(iVar.i(), iVar.j(), new Object[0]);
        com.vivo.push.u.a(new al(this, iVar));
    }
}
