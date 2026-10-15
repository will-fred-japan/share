package com.vivo.push.h;

import com.vivo.push.model.UPSNotificationMessage;

/* JADX INFO: compiled from: NotifyOpenClientClickTask.java */
/* JADX INFO: loaded from: classes.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f16637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f16638b;

    public g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f16638b = eVar;
        this.f16637a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.f16638b;
        ((ag) eVar).f16620b.onNotificationMessageClicked(((com.vivo.push.t) eVar).f16804a, this.f16637a);
    }
}
