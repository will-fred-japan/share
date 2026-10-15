package com.starburst.sdk.core.device.bt.api;

/* JADX INFO: loaded from: classes.dex */
public interface IAliBt extends IAliBtSender {
    public static final int ERROR_CODE_NO_PERMISSION = 1001;

    void setBtDataUploadCallback(IBtDataUploadCallback iBtDataUploadCallback);
}
