package com.starburst.sdk.core.asr;

import com.starburst.sdk.core.device.bt.BleMsgManager;
import com.starburst.sdk.core.device.bt.ConnectedDeviceManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b89 {
    public static void a56(BleMsgManager bleMsgManager, int i9, byte[] bArr) {
        bleMsgManager.sendRequestMsgNoEncryption(ConnectedDeviceManager.getInstance().getMasterDevice(), i9, bArr);
    }
}
