package com.jieli.jl_bt_ota.tool.data_handler;

import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.data.DataInfo;
import com.jieli.jl_bt_ota.model.data.ReceivedDataInfo;
import com.jieli.jl_bt_ota.model.data.SendDataInfo;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataInfo f16315c;

    public /* synthetic */ e(Object obj, DataInfo dataInfo, int i9) {
        this.f16313a = i9;
        this.f16314b = obj;
        this.f16315c = dataInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16313a) {
            case 0:
                DataHandler.DataHandlerThread.b((CommandCallback) this.f16314b, (SendDataInfo) this.f16315c);
                break;
            default:
                ((RcspDataHandler) this.f16314b).a((ReceivedDataInfo) this.f16315c);
                break;
        }
    }
}
