package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IPodcastCallback {
    void onClosed();

    void onError(int i9, String str);

    void onOpen();

    void onPodcastEnd(String str, String str2);

    void onRoundAudioData(int i9, byte[] bArr);

    void onRoundEnd(int i9, boolean z8);

    void onRoundStart(int i9, String str, String str2);

    void onSessionFinished();

    void onSessionStarted(String str);
}
