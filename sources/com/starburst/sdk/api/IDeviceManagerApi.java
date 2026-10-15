package com.starburst.sdk.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;
import com.starburst.sdk.core.device.bt.api.IBtMsgCallback;
import com.starburst.sdk.core.device.bt.api.IOnBtInitStateListener;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceManagerApi {
    String getCurrentTcId();

    void getDeviceAudioFiles(int i9, IGetFileCallback iGetFileCallback);

    void getTcFeatureList(ITcFeatureConfigCallback iTcFeatureConfigCallback);

    void initBtHandler(BluetoothDeviceBean bluetoothDeviceBean, IOnBtInitStateListener iOnBtInitStateListener);

    boolean isBleRecordFileSaveEnabled();

    boolean isTcFeatureEnabled(String str);

    boolean isTcFeatureEnabled(String str, String str2);

    void setBleRecordFileSaveEnabled(boolean z8);

    void setBtMsgCallBack(IBtMsgCallback iBtMsgCallback);

    void setOnDeviceRecordStateListener(OnDeviceRecordStateListener onDeviceRecordStateListener);
}
