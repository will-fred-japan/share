package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public final class AudioSessionStorageConfig {
    private String directory;
    private String leftChannelFilePath;
    private String primaryFilePath;
    private String rightChannelFilePath;
    private Boolean saveEnabled;

    public AudioSessionStorageConfig() {
    }

    public String getDirectory() {
        return this.directory;
    }

    public String getLeftChannelFilePath() {
        return this.leftChannelFilePath;
    }

    public String getPrimaryFilePath() {
        return this.primaryFilePath;
    }

    public String getRightChannelFilePath() {
        return this.rightChannelFilePath;
    }

    public Boolean getSaveEnabled() {
        return this.saveEnabled;
    }

    public AudioSessionStorageConfig setDirectory(String str) {
        this.directory = AudioSceneStorageConfig.normalizeAbsolutePath(str, "directory");
        return this;
    }

    public AudioSessionStorageConfig setLeftChannelFilePath(String str) {
        this.leftChannelFilePath = AudioSceneStorageConfig.normalizeAbsolutePath(str, "leftChannelFilePath");
        return this;
    }

    public AudioSessionStorageConfig setPrimaryFilePath(String str) {
        this.primaryFilePath = AudioSceneStorageConfig.normalizeAbsolutePath(str, "primaryFilePath");
        return this;
    }

    public AudioSessionStorageConfig setRightChannelFilePath(String str) {
        this.rightChannelFilePath = AudioSceneStorageConfig.normalizeAbsolutePath(str, "rightChannelFilePath");
        return this;
    }

    public AudioSessionStorageConfig setSaveEnabled(Boolean bool) {
        this.saveEnabled = bool;
        return this;
    }

    public AudioSessionStorageConfig(AudioSessionStorageConfig audioSessionStorageConfig) {
        if (audioSessionStorageConfig == null) {
            return;
        }
        this.saveEnabled = audioSessionStorageConfig.saveEnabled;
        this.directory = audioSessionStorageConfig.directory;
        this.primaryFilePath = audioSessionStorageConfig.primaryFilePath;
        this.leftChannelFilePath = audioSessionStorageConfig.leftChannelFilePath;
        this.rightChannelFilePath = audioSessionStorageConfig.rightChannelFilePath;
    }
}
