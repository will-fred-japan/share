package com.jieli.jl_bt_ota.tool.callback;

import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16245c;

    public /* synthetic */ c(boolean z8, boolean z9, int i9) {
        this.f16243a = i9;
        this.f16244b = z8;
        this.f16245c = z9;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        switch (this.f16243a) {
            case 0:
                ((OnBtAssistantCallback) obj).onAdapterStatus(this.f16244b, this.f16245c);
                break;
            default:
                ((IBluetoothCallback) obj).onAdapterStatus(this.f16244b, this.f16245c);
                break;
        }
    }
}
