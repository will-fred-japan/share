package com.vivo.push;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes.dex */
final class q implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f16719a;

    public q(n nVar) {
        this.f16719a = nVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i9) {
        if (i9 == 0) {
            com.vivo.push.restructure.a.a().h().b("");
        } else {
            com.vivo.push.restructure.a.a().h().c("");
        }
    }
}
