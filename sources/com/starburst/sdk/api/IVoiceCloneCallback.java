package com.starburst.sdk.api;

import com.starburst.sdk.req.VcSpeaker;

/* JADX INFO: loaded from: classes.dex */
public interface IVoiceCloneCallback {
    void onError(int i9, String str);

    void onSuccess(VcSpeaker vcSpeaker);
}
