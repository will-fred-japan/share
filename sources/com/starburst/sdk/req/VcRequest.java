package com.starburst.sdk.req;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class VcRequest {
    private String contextId;
    private String customPrompt;
    private boolean debugEnable;
    private int dialogId;
    private boolean emotion;
    private boolean enableImageIntent;
    private boolean enableOpenClaw;
    private int endWindowSize;
    private OpusExtraInfo extraInfo;
    private String language;
    private String location;
    private boolean memoryEnable;
    private boolean musicEnable;
    private Map<String, String> promptVars;
    private String role;
    private String sampleText;
    private String targetLanguage;
    private QuestionToolkitInfo toolkitInfo;
    private boolean tts;
    private String ttsAudioFormat;
    private int ttsBinaryBurstSize;
    private int ttsSampleRate;
    private String ttsSpeakerId;
    private String ttsSpeakerType;
    private float ttsSpeed;
    private String type;
    private String format = "raw";
    private int sampleRate = 16000;
    private int channel = 1;
    private String codec = "raw";
    private String pictureFormat = "jpeg";

    public int getChannel() {
        return this.channel;
    }

    public String getCodec() {
        return this.codec;
    }

    public String getContextId() {
        return this.contextId;
    }

    public String getCustomPrompt() {
        return this.customPrompt;
    }

    public int getDialogId() {
        return this.dialogId;
    }

    public boolean getEmotion() {
        return this.emotion;
    }

    public int getEndWindowSize() {
        return this.endWindowSize;
    }

    public OpusExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public String getFormat() {
        return this.format;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLocation() {
        return this.location;
    }

    public String getPictureFormat() {
        return this.pictureFormat;
    }

    public Map<String, String> getPromptVars() {
        return this.promptVars;
    }

    public String getRole() {
        return this.role;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public String getSampleText() {
        return this.sampleText;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public QuestionToolkitInfo getToolkitInfo() {
        return this.toolkitInfo;
    }

    public String getTtsAudioFormat() {
        return this.ttsAudioFormat;
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

    public String getType() {
        return this.type;
    }

    public boolean isDebugEnable() {
        return this.debugEnable;
    }

    public boolean isEnableImageIntent() {
        return this.enableImageIntent;
    }

    public boolean isEnableOpenClaw() {
        return this.enableOpenClaw;
    }

    public boolean isMemoryEnable() {
        return this.memoryEnable;
    }

    public boolean isMusicEnable() {
        return this.musicEnable;
    }

    public boolean isTts() {
        return this.tts;
    }

    public void setChannel(int i9) {
        this.channel = i9;
    }

    public void setCodec(String str) {
        this.codec = str;
    }

    public void setContextId(String str) {
        this.contextId = str;
    }

    public void setCustomPrompt(String str) {
        this.customPrompt = str;
    }

    public void setDebugEnable(boolean z8) {
        this.debugEnable = z8;
    }

    public void setDialogId(int i9) {
        this.dialogId = i9;
    }

    public void setEmotion(boolean z8) {
        this.emotion = z8;
    }

    public void setEnableImageIntent(boolean z8) {
        this.enableImageIntent = z8;
    }

    public void setEnableOpenClaw(boolean z8) {
        this.enableOpenClaw = z8;
    }

    public void setEndWindowSize(int i9) {
        this.endWindowSize = i9;
    }

    public void setExtraInfo(OpusExtraInfo opusExtraInfo) {
        this.extraInfo = opusExtraInfo;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMemoryEnable(boolean z8) {
        this.memoryEnable = z8;
    }

    public void setMusicEnable(boolean z8) {
        this.musicEnable = z8;
    }

    public void setPictureFormat(String str) {
        this.pictureFormat = str;
    }

    public void setPromptVars(Map<String, String> map) {
        this.promptVars = map;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setSampleRate(int i9) {
        this.sampleRate = i9;
    }

    public void setSampleText(String str) {
        this.sampleText = str;
    }

    public void setTargetLanguage(String str) {
        this.targetLanguage = str;
    }

    public void setToolkitInfo(QuestionToolkitInfo questionToolkitInfo) {
        this.toolkitInfo = questionToolkitInfo;
    }

    public void setTts(boolean z8) {
        this.tts = z8;
    }

    public void setTtsAudioFormat(String str) {
        this.ttsAudioFormat = str;
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

    public void setTtsSpeed(float f6) {
        this.ttsSpeed = f6;
    }

    public void setType(String str) {
        this.type = str;
    }
}
