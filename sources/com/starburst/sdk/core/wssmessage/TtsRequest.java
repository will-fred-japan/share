package com.starburst.sdk.core.wssmessage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class TtsRequest {

    @SerializedName("DebugEnable")
    private boolean debugEnable;
    private long dialogId;
    private String sampleText;
    private String ttsAudioFormat;
    private int ttsBinaryBurstDelay;
    private int ttsBinaryBurstSize;
    private int ttsSampleRate;
    private String ttsSpeakerId;
    private String ttsSpeakerType;
    private double ttsSpeed;
    private String type;

    public long getDialogId() {
        return this.dialogId;
    }

    public String getSampleText() {
        return this.sampleText;
    }

    public String getTtsAudioFormat() {
        return this.ttsAudioFormat;
    }

    public int getTtsBinaryBurstDelay() {
        return this.ttsBinaryBurstDelay;
    }

    public int getTtsBinaryBurstSize() {
        return this.ttsBinaryBurstSize;
    }

    public int getTtsSampleRate() {
        return this.ttsSampleRate;
    }

    public String getTtsSpeakerId() {
        return this.ttsSpeakerId;
    }

    public String getTtsSpeakerType() {
        return this.ttsSpeakerType;
    }

    public double getTtsSpeed() {
        return this.ttsSpeed;
    }

    public String getType() {
        return this.type;
    }

    public boolean isDebugEnable() {
        return this.debugEnable;
    }

    public void setDebugEnable(boolean z8) {
        this.debugEnable = z8;
    }

    public void setDialogId(long j) {
        this.dialogId = j;
    }

    public void setSampleText(String str) {
        this.sampleText = str;
    }

    public void setTtsAudioFormat(String str) {
        this.ttsAudioFormat = str;
    }

    public void setTtsBinaryBurstDelay(int i9) {
        this.ttsBinaryBurstDelay = i9;
    }

    public void setTtsBinaryBurstSize(int i9) {
        this.ttsBinaryBurstSize = i9;
    }

    public void setTtsSampleRate(int i9) {
        this.ttsSampleRate = i9;
    }

    public void setTtsSpeakerId(String str) {
        this.ttsSpeakerId = str;
    }

    public void setTtsSpeakerType(String str) {
        this.ttsSpeakerType = str;
    }

    public void setTtsSpeed(double d9) {
        this.ttsSpeed = d9;
    }

    public void setType(String str) {
        this.type = str;
    }
}
