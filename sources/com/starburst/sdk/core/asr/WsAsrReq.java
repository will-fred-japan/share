package com.starburst.sdk.core.asr;

import com.starburst.sdk.req.OpusExtraInfo;

/* JADX INFO: loaded from: classes.dex */
public class WsAsrReq {
    public static final String TYPE_DATA = "data";
    public static final String TYPE_START = "start";
    public static final String TYPE_STOP = "stop";
    private String data;
    private boolean enableTranslateImprove;
    private int endWindowSize;
    private OpusExtraInfo extraInfo;
    private String featureId;
    private String fileId;
    private String language;
    private boolean llmTranslate;
    private boolean summary;
    private String targetLanguage;
    private String text;
    private boolean translate;
    private boolean tts;
    private String ttsAudioFormat;
    private String ttsSpeakerId;
    private float ttsSpeed;
    private String ttsType;
    private String type;
    private String format = "raw";
    private int sampleRate = 16000;
    private int ttsSampleRate = 16000;
    private int channel = 1;
    private String codec = "raw";
    private boolean enableItn = true;
    private boolean speakerSeparate = false;

    public int getChannel() {
        return this.channel;
    }

    public String getCodec() {
        return this.codec;
    }

    public String getData() {
        return this.data;
    }

    public int getEndWindowSize() {
        return this.endWindowSize;
    }

    public OpusExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public String getFeatureId() {
        return this.featureId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFormat() {
        return this.format;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getText() {
        return this.text;
    }

    public String getTtsAudioFormat() {
        return this.ttsAudioFormat;
    }

    public int getTtsSampleRate() {
        return this.ttsSampleRate;
    }

    public String getTtsSpeaker() {
        return this.ttsSpeakerId;
    }

    public String getTtsType() {
        return this.ttsType;
    }

    public String getType() {
        return this.type;
    }

    public boolean isEnableItn() {
        return this.enableItn;
    }

    public boolean isEnableTranslateImprove() {
        return this.enableTranslateImprove;
    }

    public boolean isLlmTranslate() {
        return this.llmTranslate;
    }

    public boolean isSpeakerSeparate() {
        return this.speakerSeparate;
    }

    public boolean isSummary() {
        return this.summary;
    }

    public boolean isTranslate() {
        return this.translate;
    }

    public boolean isTts() {
        return this.tts;
    }

    public void setChannel(int i9) {
        this.channel = i9;
    }

    public void setCodec(String str) {
        this.codec = str;
        if ("opus".equalsIgnoreCase(str)) {
            return;
        }
        this.extraInfo = null;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEnableItn(boolean z8) {
        this.enableItn = z8;
    }

    public void setEnableTranslateImprove(boolean z8) {
        this.enableTranslateImprove = z8;
    }

    public void setEndWindowSize(int i9) {
        this.endWindowSize = i9;
    }

    public void setExtraInfo(OpusExtraInfo opusExtraInfo) {
        if (!"opus".equalsIgnoreCase(this.codec)) {
            opusExtraInfo = null;
        }
        this.extraInfo = opusExtraInfo;
    }

    public void setFeatureId(String str) {
        this.featureId = str;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLlmTranslate(boolean z8) {
        this.llmTranslate = z8;
    }

    public void setSampleRate(int i9) {
        this.sampleRate = i9;
    }

    public void setSpeakerSeparate(boolean z8) {
        this.speakerSeparate = z8;
    }

    public void setSummary(boolean z8) {
        this.summary = z8;
    }

    public void setTargetLanguage(String str) {
        this.targetLanguage = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTranslate(boolean z8) {
        this.translate = z8;
    }

    public void setTts(boolean z8) {
        this.tts = z8;
    }

    public void setTtsAudioFormat(String str) {
        this.ttsAudioFormat = str;
    }

    public void setTtsSampleRate(int i9) {
        this.ttsSampleRate = i9;
    }

    public void setTtsSpeaker(String str) {
        this.ttsSpeakerId = str;
    }

    public void setTtsSpeed(float f6) {
        this.ttsSpeed = f6;
    }

    public void setTtsType(String str) {
        this.ttsType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
