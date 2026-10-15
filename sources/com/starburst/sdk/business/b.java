package com.starburst.sdk.business;

import com.starburst.sdk.api.IRealtimeVideoCallCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RealtimeVideoCallManager f16380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RealtimeVideoCallManager.Session f16381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IRealtimeVideoCallCallback f16382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f16383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f16384f;

    public /* synthetic */ b(RealtimeVideoCallManager realtimeVideoCallManager, RealtimeVideoCallManager.Session session, IRealtimeVideoCallCallback iRealtimeVideoCallCallback, String str, boolean z8, int i9) {
        this.f16379a = i9;
        this.f16380b = realtimeVideoCallManager;
        this.f16381c = session;
        this.f16382d = iRealtimeVideoCallCallback;
        this.f16383e = str;
        this.f16384f = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16379a) {
            case 0:
                this.f16380b.lambda$postUserText$1(this.f16381c, this.f16382d, this.f16383e, this.f16384f);
                break;
            default:
                this.f16380b.lambda$postAssistantText$2(this.f16381c, this.f16382d, this.f16383e, this.f16384f);
                break;
        }
    }
}
