package com.vivo.push.h;

import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: compiled from: OnNotifyGuideDialogResultTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class ad extends ag {
    public ad(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        int iE = ((com.vivo.push.b.s) wVar).e();
        PushMessageCallback pushMessageCallback = ((ag) this).f16620b;
        if (pushMessageCallback != null) {
            pushMessageCallback.onNotifyGuideDialogResult(iE);
        }
    }
}
