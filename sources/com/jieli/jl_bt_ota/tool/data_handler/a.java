package com.jieli.jl_bt_ota.tool.data_handler;

import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.data.SendDataInfo;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SendDataInfo f16305c;

    public /* synthetic */ a(Object obj, SendDataInfo sendDataInfo, int i9) {
        this.f16303a = i9;
        this.f16304b = obj;
        this.f16305c = sendDataInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16303a) {
            case 0:
                DataHandler.DataHandlerThread.a((CommandCallback) this.f16304b, this.f16305c);
                break;
            case 1:
                RcspDataHandler.a((CommandCallback) this.f16304b, this.f16305c);
                break;
            default:
                ((RcspDataHandler) this.f16304b).b(this.f16305c);
                break;
        }
    }
}
