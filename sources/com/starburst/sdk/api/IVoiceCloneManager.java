package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IVoiceCloneManager {
    String getVoiceCloneText();

    void setVoiceCloneCallback(IVoiceCloneCallback iVoiceCloneCallback);

    void startVoiceClone();

    void stopVoiceClone();
}
