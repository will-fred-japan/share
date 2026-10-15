package com.vivo.push.d;

import com.vivo.push.util.w;

/* JADX INFO: compiled from: NotifyGuideDialogManager.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements com.vivo.push.restructure.request.c<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f16561a;

    public d(c cVar) {
        this.f16561a = cVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        i iVar = (i) bVar;
        if (iVar == null) {
            this.f16561a.f16559b.onStateChanged(10000);
            return;
        }
        w.d("NotifyGuideDialogManage", "onReceiveAck:" + iVar.a());
        this.f16561a.f16559b.onStateChanged(iVar.a());
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i9) {
        w.d("NotifyGuideDialogManage", "onError:".concat(String.valueOf(i9)));
        this.f16561a.f16559b.onStateChanged(i9);
    }
}
