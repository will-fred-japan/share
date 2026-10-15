package com.vivo.push.restructure.a.a;

import com.vivo.push.util.w;

/* JADX INFO: compiled from: NodeListenerImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements i<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f16746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f16747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f16748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f16749d;

    public j(n nVar, k kVar, com.vivo.push.restructure.c.a aVar) {
        this.f16747b = nVar;
        this.f16748c = kVar;
        this.f16749d = aVar;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(a aVar, com.vivo.push.restructure.a.a aVar2, int i9) {
        com.vivo.push.restructure.a.a aVar3 = aVar2;
        if (aVar3 == null) {
            w.d("onNodeError() receivedMsg is null ");
            return;
        }
        w.d("onNodeError() , msgID = " + aVar3.a() + ", nodeName = " + aVar.b());
        com.vivo.push.restructure.c.a aVar4 = this.f16749d;
        if (aVar4 != null) {
            aVar4.a(i9, aVar3.a());
        }
        a2(aVar3);
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.a.a aVar2 = aVar;
        if (aVar2 == null) {
            w.d("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.f16746a == null) {
            w.d("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(aVar2);
        }
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final void a(g gVar) {
        this.f16746a = gVar;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.restructure.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!aVar.e()) {
            w.d("core is not support monitor report");
            return;
        }
        w.d("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + aVar.f());
        if (aVar.f()) {
            n nVar = this.f16747b;
            if (nVar != null) {
                nVar.a(aVar, this.f16746a);
            }
            k kVar = this.f16748c;
            if (kVar != null) {
                kVar.a(aVar, this.f16746a.c().toString());
                w.d("reportNodeMonitorInfo() , report client NodeInfo！！！");
            } else {
                w.d("onNodeError , mReporter is null， can not report");
            }
        }
    }
}
