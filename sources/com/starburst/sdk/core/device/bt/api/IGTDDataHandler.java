package com.starburst.sdk.core.device.bt.api;

import com.starburst.sdk.core.auth.api.IAuthApi;
import com.starburst.sdk.core.device.bt.domain.SendData;

/* JADX INFO: loaded from: classes.dex */
public interface IGTDDataHandler {
    byte[] handleDispatchId2Data(String str, String str2);

    void handleGTD(SendData sendData, IAuthApi iAuthApi);
}
