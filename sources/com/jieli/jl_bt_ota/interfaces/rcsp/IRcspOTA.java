package com.jieli.jl_bt_ota.interfaces.rcsp;

import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.FileOffset;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public interface IRcspOTA {
    void changeCommunicationWay(int i9, int i10, IActionCallback<Integer> iActionCallback);

    void enterUpdateMode(IActionCallback<Integer> iActionCallback);

    void exitUpdateMode(IActionCallback<Integer> iActionCallback);

    void inquiryDeviceCanOTA(byte[] bArr, IActionCallback<Integer> iActionCallback);

    void queryUpdateResult(IActionCallback<Integer> iActionCallback);

    void readUpgradeFileFlag(IActionCallback<FileOffset> iActionCallback);

    void rebootDevice(IActionCallback<Boolean> iActionCallback);

    <T extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> void sendCommandResponse(T t);

    <T extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> void sendCommandResponse(T t, CommandCallback<T> commandCallback);

    void stopADVInfo(IActionCallback<Boolean> iActionCallback);
}
