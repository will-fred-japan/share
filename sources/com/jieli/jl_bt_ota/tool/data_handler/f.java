package com.jieli.jl_bt_ota.tool.data_handler;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return RcspDataHandler.a(message);
    }
}
