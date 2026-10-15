package com.starburst.sdk.core.device.bt.callback;

/* JADX INFO: loaded from: classes.dex */
public interface IFileSendProgressCallback {
    public static final int READYSEND = 1;
    public static final int SEND = 2;
    public static final int SENDFAIL = 4;
    public static final int SENDSUCCESS = 3;

    void onFileSendStateChange(int i9);

    void onProgressChange(int i9);
}
