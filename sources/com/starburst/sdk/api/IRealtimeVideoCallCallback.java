package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IRealtimeVideoCallCallback {
    void onAssistantText(String str, boolean z8);

    void onError(String str);

    void onStateChanged(RealtimeVideoCallState realtimeVideoCallState);

    void onUserText(String str, boolean z8);
}
