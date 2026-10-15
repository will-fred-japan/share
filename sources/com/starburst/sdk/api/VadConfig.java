package com.starburst.sdk.api;

import com.starburst.sdk.req.VoiceChatStartConfig;

/* JADX INFO: loaded from: classes.dex */
public class VadConfig {
    public int endSilenceMs;
    public int energyThreshold;
    public int longSpeechEndSilenceMs;
    public int minSpeechMs;
    public int resetSilenceMs;
    public int silenceDetectMs;
    public int silenceThreshold;

    public VadConfig() {
        this.silenceThreshold = 63;
        this.energyThreshold = 10000;
        this.minSpeechMs = 240;
        this.silenceDetectMs = 500;
        this.resetSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
        this.endSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
        this.longSpeechEndSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
    }

    public VadConfig setEndSilenceMs(int i9) {
        this.endSilenceMs = i9;
        return this;
    }

    public VadConfig setEnergyThreshold(int i9) {
        this.energyThreshold = i9;
        return this;
    }

    public VadConfig setLongSpeechEndSilenceMs(int i9) {
        this.longSpeechEndSilenceMs = i9;
        return this;
    }

    public VadConfig setMinSpeechMs(int i9) {
        this.minSpeechMs = i9;
        return this;
    }

    public VadConfig setResetSilenceMs(int i9) {
        this.resetSilenceMs = i9;
        return this;
    }

    public VadConfig setSilenceDetectMs(int i9) {
        this.silenceDetectMs = i9;
        return this;
    }

    public VadConfig setSilenceThreshold(int i9) {
        this.silenceThreshold = i9;
        return this;
    }

    public VadConfig(VadConfig vadConfig) {
        this.silenceThreshold = 63;
        this.energyThreshold = 10000;
        this.minSpeechMs = 240;
        this.silenceDetectMs = 500;
        this.resetSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
        this.endSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
        this.longSpeechEndSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
        if (vadConfig == null) {
            return;
        }
        this.silenceThreshold = vadConfig.silenceThreshold;
        this.energyThreshold = vadConfig.energyThreshold;
        this.minSpeechMs = vadConfig.minSpeechMs;
        this.silenceDetectMs = vadConfig.silenceDetectMs;
        this.resetSilenceMs = vadConfig.resetSilenceMs;
        this.endSilenceMs = vadConfig.endSilenceMs;
        this.longSpeechEndSilenceMs = vadConfig.longSpeechEndSilenceMs;
    }
}
