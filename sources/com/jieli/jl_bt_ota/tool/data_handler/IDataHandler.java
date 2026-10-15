package com.jieli.jl_bt_ota.tool.data_handler;

import com.jieli.jl_bt_ota.model.data.ReceivedDataInfo;
import com.jieli.jl_bt_ota.model.data.SendDataInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IDataHandler {
    void addRecvData(ReceivedDataInfo receivedDataInfo);

    void addSendData(SendDataInfo<?> sendDataInfo);

    void release();
}
