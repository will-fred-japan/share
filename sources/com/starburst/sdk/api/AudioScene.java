package com.starburst.sdk.api;

import com.starburst.sdk.core.recorder.BaseAudioRecorder;

/* JADX INFO: loaded from: classes.dex */
public enum AudioScene {
    CHAT("chat"),
    ASR(BaseAudioRecorder.SCENARIO_ASR),
    TRANSLATE(BaseAudioRecorder.SCENARIO_TRANSLATE),
    CALL("call"),
    A2DP("a2dp");

    private final String directoryName;

    AudioScene(String str) {
        this.directoryName = str;
    }

    public String getDirectoryName() {
        return this.directoryName;
    }
}
