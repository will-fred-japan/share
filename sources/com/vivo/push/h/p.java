package com.vivo.push.h;

import com.vivo.push.model.RemoteNotificationContent;
import com.vivo.push.model.RemoteNotificationInfo;
import com.vivo.push.sdk.IPushExtensionService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: OnExtensionNotificationArriveTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends ag {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IPushExtensionService f16652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f16654e;

    public p(com.vivo.push.w wVar) {
        super(wVar);
        this.f16653d = -1;
        this.f16654e = new AtomicBoolean(false);
    }

    public final void a(IPushExtensionService iPushExtensionService) {
        this.f16652c = iPushExtensionService;
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        if (wVar == null) {
            com.vivo.push.util.w.a("OnExtensionNotificationArriveTask", "pushCommand is null");
            return;
        }
        com.vivo.push.b.m mVar = (com.vivo.push.b.m) wVar;
        if (this.f16652c == null) {
            com.vivo.push.util.w.a("OnExtensionNotificationArriveTask", "mPushExtensionCallback is null");
            a(2814);
            return;
        }
        com.vivo.push.n.a().a(new com.vivo.push.b.h(String.valueOf(mVar.k())));
        if (com.vivo.push.n.a().g() && !a(com.vivo.push.util.ak.c(this.f16804a), mVar.e(), mVar.l())) {
            a(1021);
            return;
        }
        RemoteNotificationInfo remoteNotificationInfoF = mVar.f();
        if (remoteNotificationInfoF == null) {
            a(2815);
            return;
        }
        com.vivo.push.util.i.a().execute(new q(this, mVar, remoteNotificationInfoF));
        this.f16653d = com.vivo.push.util.f.a().a(new s(this, mVar, remoteNotificationInfoF), ((long) (mVar.h() - 1)) * 1000);
        com.vivo.push.util.w.c("OnExtensionNotificationArriveTask", "dispatch to service:" + mVar.k() + " arriveTime" + mVar.g() + " taskId:" + this.f16653d);
    }

    public static /* synthetic */ void a(p pVar, com.vivo.push.b.m mVar, RemoteNotificationContent remoteNotificationContent) {
        if (pVar.f16654e.get()) {
            com.vivo.push.util.w.c("OnExtensionNotificationArriveTask", "already ack to core");
            return;
        }
        pVar.f16654e.set(true);
        com.vivo.push.b.m mVar2 = new com.vivo.push.b.m();
        mVar2.a(remoteNotificationContent);
        mVar2.c(mVar.k());
        mVar2.a(mVar.g());
        mVar2.b(System.currentTimeMillis());
        com.vivo.push.a.a.a(pVar.f16804a, com.vivo.push.restructure.a.a().e().k(), mVar2);
    }
}
