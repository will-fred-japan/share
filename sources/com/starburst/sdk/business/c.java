package com.starburst.sdk.business;

import com.starburst.sdk.api.IRealtimeVideoCallCallback;
import com.starburst.sdk.api.RealtimeVideoCallState;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RealtimeVideoCallManager f16386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RealtimeVideoCallManager.Session f16387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IRealtimeVideoCallCallback f16388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f16389e;

    public /* synthetic */ c(RealtimeVideoCallManager realtimeVideoCallManager, RealtimeVideoCallManager.Session session, IRealtimeVideoCallCallback iRealtimeVideoCallCallback, Object obj, int i9) {
        this.f16385a = i9;
        this.f16386b = realtimeVideoCallManager;
        this.f16387c = session;
        this.f16388d = iRealtimeVideoCallCallback;
        this.f16389e = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16385a) {
            case 0:
                this.f16386b.lambda$postState$0(this.f16387c, this.f16388d, (RealtimeVideoCallState) this.f16389e);
                break;
            default:
                this.f16386b.lambda$postError$3(this.f16387c, this.f16388d, (String) this.f16389e);
                break;
        }
    }
}
