package com.starburst.sdk.req;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextRequest {
    private String contextId;
    private String customPrompt;
    private int dialogId;
    private boolean enableOpenClaw;
    private String language;
    private boolean memoryEnable;
    private boolean musicEnable;
    private Map<String, String> promptVars;
    private String role;
    private String targetLanguage;
    private String text;
    private boolean tts;
    private int ttsSampleRate;
    private String ttsSpeakerId;
    private String ttsSpeakerType;
    private float ttsSpeed;
    private String type = "ext_chat";

    public String getContextId() {
        return this.contextId;
    }

    public String getCustomPrompt() {
        return this.customPrompt;
    }

    public int getDialogId() {
        return this.dialogId;
    }

    public String getLanguage() {
        return this.language;
    }

    public Map<String, String> getPromptVars() {
        return this.promptVars;
    }

    public String getRole() {
        return this.role;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getText() {
        return this.text;
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

    public float getTtsSpeed() {
        return this.ttsSpeed;
    }

    public String getType() {
        return this.type;
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

    public void setContextId(String str) {
        this.contextId = str;
    }

    public void setCustomPrompt(String str) {
        this.customPrompt = str;
    }

    public void setDialogId(int i9) {
        this.dialogId = i9;
    }

    public void setEnableOpenClaw(boolean z8) {
        this.enableOpenClaw = z8;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMemoryEnable(boolean z8) {
        this.memoryEnable = z8;
    }

    public void setMusicEnable(boolean z8) {
        this.musicEnable = z8;
    }

    public void setPromptVars(Map<String, String> map) {
        this.promptVars = map;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setTargetLanguage(String str) {
        this.targetLanguage = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTts(boolean z8) {
        this.tts = z8;
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
