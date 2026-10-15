package com.starburst.sdk.core.asr;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class TtsPlayProtocol600001 {

    @SerializedName("code")
    public Integer code;

    @SerializedName("failReason")
    public String failReason;

    @SerializedName("msg")
    public String msg;

    @SerializedName("playAudioBit")
    public String playAudioBit;

    @SerializedName("playAudioSampleRate")
    public Integer playAudioSampleRate;

    @SerializedName("requestId")
    public String requestId;
}
