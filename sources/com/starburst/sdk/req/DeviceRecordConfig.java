package com.starburst.sdk.req;

import com.starburst.sdk.api.AudioSessionStorageConfig;
import com.starburst.sdk.core.opus.OpusCodecConfig;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRecordConfig {
    private AudioSessionStorageConfig audioStorageConfig;
    private boolean continueTtsAfterStop;
    private LanguageType language;
    private ChannelConfig leftChannel;
    private OpusCodecConfig opusCodecConfig;
    private String rawSavePath;
    private PacketPolicy recordUploadPolicy;
    private ChannelConfig rightChannel;
    private LanguageType targetLanguage;
    private boolean translate;
    private PacketPolicy ttsDownlinkPolicy;
    private boolean ttsEnabled;
    private TTsFormat ttsFormat;
    private String ttsSpeaker;
    private float ttsSpeed;
    private TTsType ttsType;
    private int type;

    public static class ChannelConfig {
        private LanguageType fromLanguage;
        private LanguageType toLanguage;

        public ChannelConfig() {
        }

        public LanguageType getFromLanguage() {
            return this.fromLanguage;
        }

        public LanguageType getToLanguage() {
            return this.toLanguage;
        }

        public ChannelConfig setFromLanguage(LanguageType languageType) {
            this.fromLanguage = languageType;
            return this;
        }

        public ChannelConfig setToLanguage(LanguageType languageType) {
            this.toLanguage = languageType;
            return this;
        }

        public ChannelConfig(ChannelConfig channelConfig) {
            if (channelConfig != null) {
                this.fromLanguage = channelConfig.fromLanguage;
                this.toLanguage = channelConfig.toLanguage;
            }
        }

        public ChannelConfig(LanguageType languageType, LanguageType languageType2) {
            this.fromLanguage = languageType;
            this.toLanguage = languageType2;
        }
    }

    public static class PacketPolicy {
        private int intervalMs;
        private int packetSizeBytes;

        public PacketPolicy() {
            this.packetSizeBytes = 240;
            this.intervalMs = 60;
        }

        public int getIntervalMs() {
            return this.intervalMs;
        }

        public int getPacketSizeBytes() {
            return this.packetSizeBytes;
        }

        public PacketPolicy setIntervalMs(int i9) {
            this.intervalMs = i9;
            return this;
        }

        public PacketPolicy setPacketSizeBytes(int i9) {
            this.packetSizeBytes = i9;
            return this;
        }

        public PacketPolicy(int i9, int i10) {
            this.packetSizeBytes = i9;
            this.intervalMs = i10;
        }

        public PacketPolicy(PacketPolicy packetPolicy) {
            this.packetSizeBytes = 240;
            this.intervalMs = 60;
            if (packetPolicy != null) {
                this.packetSizeBytes = packetPolicy.packetSizeBytes;
                this.intervalMs = packetPolicy.intervalMs;
            }
        }
    }

    public DeviceRecordConfig() {
        this.type = 1;
        this.ttsFormat = TTsFormat.PCM;
        this.ttsType = TTsType.STREAM;
        this.ttsSpeed = 1.0f;
        this.continueTtsAfterStop = true;
        this.language = LanguageType.ZH_CN;
        this.targetLanguage = LanguageType.EN_US;
        this.opusCodecConfig = new OpusCodecConfig();
        this.recordUploadPolicy = new PacketPolicy();
        this.ttsDownlinkPolicy = new PacketPolicy();
    }

    public AudioSessionStorageConfig getAudioStorageConfig() {
        AudioSessionStorageConfig audioSessionStorageConfig = this.audioStorageConfig;
        if (audioSessionStorageConfig == null) {
            return null;
        }
        return new AudioSessionStorageConfig(audioSessionStorageConfig);
    }

    public LanguageType getLanguage() {
        return this.language;
    }

    public ChannelConfig getLeftChannel() {
        return this.leftChannel;
    }

    public OpusCodecConfig getOpusCodecConfig() {
        return this.opusCodecConfig;
    }

    public String getRawSavePath() {
        return this.rawSavePath;
    }

    public PacketPolicy getRecordUploadPolicy() {
        return this.recordUploadPolicy;
    }

    public ChannelConfig getRightChannel() {
        return this.rightChannel;
    }

    public LanguageType getTargetLanguage() {
        return this.targetLanguage;
    }

    public PacketPolicy getTtsDownlinkPolicy() {
        return this.ttsDownlinkPolicy;
    }

    public TTsFormat getTtsFormat() {
        return this.ttsFormat;
    }

    public String getTtsSpeaker() {
        return this.ttsSpeaker;
    }

    public float getTtsSpeed() {
        return this.ttsSpeed;
    }

    public TTsType getTtsType() {
        return this.ttsType;
    }

    public int getType() {
        return this.type;
    }

    public boolean isContinueTtsAfterStop() {
        return this.continueTtsAfterStop;
    }

    public boolean isTranslate() {
        return this.translate;
    }

    public boolean isTtsEnabled() {
        return this.ttsEnabled;
    }

    public DeviceRecordConfig setAudioStorageConfig(AudioSessionStorageConfig audioSessionStorageConfig) {
        this.audioStorageConfig = audioSessionStorageConfig == null ? null : new AudioSessionStorageConfig(audioSessionStorageConfig);
        return this;
    }

    public DeviceRecordConfig setContinueTtsAfterStop(boolean z8) {
        this.continueTtsAfterStop = z8;
        return this;
    }

    public DeviceRecordConfig setLanguage(LanguageType languageType) {
        if (languageType == null) {
            languageType = LanguageType.ZH_CN;
        }
        this.language = languageType;
        return this;
    }

    public DeviceRecordConfig setLeftChannel(ChannelConfig channelConfig) {
        this.leftChannel = channelConfig;
        return this;
    }

    public DeviceRecordConfig setOpusCodecConfig(OpusCodecConfig opusCodecConfig) {
        this.opusCodecConfig = opusCodecConfig;
        return this;
    }

    public DeviceRecordConfig setRawSavePath(String str) {
        this.rawSavePath = str;
        return this;
    }

    public DeviceRecordConfig setRecordUploadPolicy(PacketPolicy packetPolicy) {
        this.recordUploadPolicy = packetPolicy;
        return this;
    }

    public DeviceRecordConfig setRightChannel(ChannelConfig channelConfig) {
        this.rightChannel = channelConfig;
        return this;
    }

    public DeviceRecordConfig setTargetLanguage(LanguageType languageType) {
        if (languageType == null) {
            languageType = LanguageType.EN_US;
        }
        this.targetLanguage = languageType;
        return this;
    }

    public DeviceRecordConfig setTranslate(boolean z8) {
        this.translate = z8;
        return this;
    }

    public DeviceRecordConfig setTtsDownlinkPolicy(PacketPolicy packetPolicy) {
        this.ttsDownlinkPolicy = packetPolicy;
        return this;
    }

    public DeviceRecordConfig setTtsEnabled(boolean z8) {
        this.ttsEnabled = z8;
        return this;
    }

    public DeviceRecordConfig setTtsFormat(TTsFormat tTsFormat) {
        this.ttsFormat = tTsFormat;
        return this;
    }

    public DeviceRecordConfig setTtsSpeaker(String str) {
        this.ttsSpeaker = str;
        return this;
    }

    public DeviceRecordConfig setTtsSpeed(float f6) {
        this.ttsSpeed = f6;
        return this;
    }

    public DeviceRecordConfig setTtsType(TTsType tTsType) {
        this.ttsType = tTsType;
        return this;
    }

    public DeviceRecordConfig setType(int i9) {
        this.type = i9;
        return this;
    }

    public DeviceRecordConfig(int i9) {
        this.type = 1;
        this.ttsFormat = TTsFormat.PCM;
        this.ttsType = TTsType.STREAM;
        this.ttsSpeed = 1.0f;
        this.continueTtsAfterStop = true;
        this.language = LanguageType.ZH_CN;
        this.targetLanguage = LanguageType.EN_US;
        this.opusCodecConfig = new OpusCodecConfig();
        this.recordUploadPolicy = new PacketPolicy();
        this.ttsDownlinkPolicy = new PacketPolicy();
        this.type = i9;
        if (i9 == 4) {
            this.translate = true;
            this.ttsEnabled = true;
        }
    }

    public DeviceRecordConfig(DeviceRecordConfig deviceRecordConfig) {
        this.type = 1;
        this.ttsFormat = TTsFormat.PCM;
        this.ttsType = TTsType.STREAM;
        this.ttsSpeed = 1.0f;
        this.continueTtsAfterStop = true;
        LanguageType languageType = LanguageType.ZH_CN;
        this.language = languageType;
        LanguageType languageType2 = LanguageType.EN_US;
        this.targetLanguage = languageType2;
        this.opusCodecConfig = new OpusCodecConfig();
        this.recordUploadPolicy = new PacketPolicy();
        this.ttsDownlinkPolicy = new PacketPolicy();
        if (deviceRecordConfig == null) {
            return;
        }
        this.type = deviceRecordConfig.type;
        this.translate = deviceRecordConfig.translate;
        this.ttsEnabled = deviceRecordConfig.ttsEnabled;
        this.ttsFormat = deviceRecordConfig.ttsFormat;
        this.ttsType = deviceRecordConfig.ttsType;
        this.ttsSpeaker = deviceRecordConfig.ttsSpeaker;
        this.ttsSpeed = deviceRecordConfig.ttsSpeed;
        this.continueTtsAfterStop = deviceRecordConfig.continueTtsAfterStop;
        this.rawSavePath = deviceRecordConfig.rawSavePath;
        LanguageType languageType3 = deviceRecordConfig.language;
        this.language = languageType3 != null ? languageType3 : languageType;
        LanguageType languageType4 = deviceRecordConfig.targetLanguage;
        this.targetLanguage = languageType4 != null ? languageType4 : languageType2;
        ChannelConfig channelConfig = deviceRecordConfig.leftChannel;
        this.leftChannel = channelConfig == null ? null : new ChannelConfig(channelConfig);
        ChannelConfig channelConfig2 = deviceRecordConfig.rightChannel;
        this.rightChannel = channelConfig2 == null ? null : new ChannelConfig(channelConfig2);
        OpusCodecConfig opusCodecConfig = deviceRecordConfig.opusCodecConfig;
        this.opusCodecConfig = opusCodecConfig == null ? null : new OpusCodecConfig(opusCodecConfig);
        PacketPolicy packetPolicy = deviceRecordConfig.recordUploadPolicy;
        this.recordUploadPolicy = packetPolicy == null ? null : new PacketPolicy(packetPolicy);
        PacketPolicy packetPolicy2 = deviceRecordConfig.ttsDownlinkPolicy;
        this.ttsDownlinkPolicy = packetPolicy2 == null ? null : new PacketPolicy(packetPolicy2);
        AudioSessionStorageConfig audioSessionStorageConfig = deviceRecordConfig.audioStorageConfig;
        this.audioStorageConfig = audioSessionStorageConfig != null ? new AudioSessionStorageConfig(audioSessionStorageConfig) : null;
    }
}
