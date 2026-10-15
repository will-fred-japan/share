package com.starburst.sdk.api;

import com.starburst.sdk.req.RealtimeVideoCallConfig;

/* JADX INFO: loaded from: classes.dex */
public interface IRealtimeVideoCallManager {
    boolean isRunning();

    boolean isSessionReady();

    boolean sendImage(byte[] bArr);

    void start(RealtimeVideoCallConfig realtimeVideoCallConfig, IRealtimeVideoCallCallback iRealtimeVideoCallCallback);

    void stop();
}
