package com.starburst.sdk.req;

import com.starburst.sdk.api.AudioSessionStorageConfig;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class VoiceChatStartConfig {
    public static final int DEFAULT_END_WINDOW_SIZE = 900;
    public static final long DEFAULT_IDLE_TIMEOUT_MILLIS = 10000;
    private AudioSessionStorageConfig audioStorageConfig;
    private boolean enableImageIntent;
    private LanguageType language;
    private String location;
    private boolean memoryEnable;
    private boolean musicEnable;
    private LanguageType targetLanguage;
    private boolean enableOpenClaw = false;
    private boolean idleTimeoutEnable = true;
    private long idleTimeoutMillis = 10000;
    private int endWindowSize = DEFAULT_END_WINDOW_SIZE;
    private Map<String, String> promptVars = Collections.EMPTY_MAP;

    public AudioSessionStorageConfig getAudioStorageConfig() {
        AudioSessionStorageConfig audioSessionStorageConfig = this.audioStorageConfig;
        if (audioSessionStorageConfig == null) {
            return null;
        }
        return new AudioSessionStorageConfig(audioSessionStorageConfig);
    }

    public int getEndWindowSize() {
        return this.endWindowSize;
    }

    public long getIdleTimeoutMillis() {
        return this.idleTimeoutMillis;
    }

    public LanguageType getLanguage() {
        return this.language;
    }

    public String getLocation() {
        return this.location;
    }

    public Map<String, String> getPromptVars() {
        return Collections.unmodifiableMap(new LinkedHashMap(this.promptVars));
    }

    public LanguageType getTargetLanguage() {
        return this.targetLanguage;
    }

    public boolean isEnableImageIntent() {
        return this.enableImageIntent;
    }

    public boolean isEnableOpenClaw() {
        return this.enableOpenClaw;
    }

    public boolean isIdleTimeoutEnable() {
        return this.idleTimeoutEnable;
    }

    public boolean isMemoryEnable() {
        return this.memoryEnable;
    }

    public boolean isMusicEnable() {
        return this.musicEnable;
    }

    public VoiceChatStartConfig setAudioStorageConfig(AudioSessionStorageConfig audioSessionStorageConfig) {
        this.audioStorageConfig = audioSessionStorageConfig == null ? null : new AudioSessionStorageConfig(audioSessionStorageConfig);
        return this;
    }

    public VoiceChatStartConfig setEnableImageIntent(boolean z8) {
        this.enableImageIntent = z8;
        return this;
    }

    public VoiceChatStartConfig setEnableOpenClaw(boolean z8) {
        this.enableOpenClaw = z8;
        return this;
    }

    public VoiceChatStartConfig setEndWindowSize(int i9) {
        this.endWindowSize = i9;
        return this;
    }

    public VoiceChatStartConfig setIdleTimeoutEnable(boolean z8) {
        this.idleTimeoutEnable = z8;
        return this;
    }

    public VoiceChatStartConfig setIdleTimeoutMillis(long j) {
        this.idleTimeoutMillis = j;
        return this;
    }

    public VoiceChatStartConfig setLanguage(LanguageType languageType) {
        this.language = languageType;
        return this;
    }

    public VoiceChatStartConfig setLocation(String str) {
        this.location = str;
        return this;
    }

    public VoiceChatStartConfig setMemoryEnable(boolean z8) {
        this.memoryEnable = z8;
        return this;
    }

    public VoiceChatStartConfig setMusicEnable(boolean z8) {
        this.musicEnable = z8;
        return this;
    }

    public VoiceChatStartConfig setPromptVars(Map<String, String> map) {
        this.promptVars = map == null ? Collections.EMPTY_MAP : new LinkedHashMap(map);
        return this;
    }

    public VoiceChatStartConfig setTargetLanguage(LanguageType languageType) {
        this.targetLanguage = languageType;
        return this;
    }
}
