package com.starburst.sdk.core.opus;

/* JADX INFO: loaded from: classes.dex */
public class OpusCodecConfig {
    public static final int APPLICATION_AUDIO = 2049;
    public static final int APPLICATION_RESTRICTED_LOWDELAY = 2051;
    public static final int APPLICATION_VOIP = 2048;
    private int application;
    private int bitDepth;
    private int channels;
    private int encodedBytesPerFrame;
    private int frameSamples;
    private int sampleRate;

    public OpusCodecConfig() {
        this.sampleRate = 16000;
        this.channels = 1;
        this.bitDepth = 16;
        this.application = APPLICATION_RESTRICTED_LOWDELAY;
        this.frameSamples = 320;
        this.encodedBytesPerFrame = 80;
    }

    public int getApplication() {
        return this.application;
    }

    public int getBitDepth() {
        return this.bitDepth;
    }

    public long getBitrate() {
        int i9 = this.frameSamples;
        if (i9 <= 0) {
            return 0L;
        }
        return ((((long) this.encodedBytesPerFrame) * 8) * ((long) this.sampleRate)) / ((long) i9);
    }

    public int getChannels() {
        return this.channels;
    }

    public int getEncodedBytesPerFrame() {
        return this.encodedBytesPerFrame;
    }

    public int getFrameDurationMs() {
        int i9 = this.sampleRate;
        if (i9 > 0) {
            return (this.frameSamples * 1000) / i9;
        }
        return 0;
    }

    public int getFrameSamples() {
        return this.frameSamples;
    }

    public int getPcmBytesPerFrame() {
        return ((this.frameSamples * this.channels) * this.bitDepth) / 8;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public OpusCodecConfig setApplication(int i9) {
        this.application = i9;
        return this;
    }

    public OpusCodecConfig setBitDepth(int i9) {
        this.bitDepth = i9;
        return this;
    }

    public OpusCodecConfig setChannels(int i9) {
        this.channels = i9;
        return this;
    }

    public OpusCodecConfig setEncodedBytesPerFrame(int i9) {
        this.encodedBytesPerFrame = i9;
        return this;
    }

    public OpusCodecConfig setFrameSamples(int i9) {
        this.frameSamples = i9;
        return this;
    }

    public OpusCodecConfig setSampleRate(int i9) {
        this.sampleRate = i9;
        return this;
    }

    public OpusCodecConfig(OpusCodecConfig opusCodecConfig) {
        this.sampleRate = 16000;
        this.channels = 1;
        this.bitDepth = 16;
        this.application = APPLICATION_RESTRICTED_LOWDELAY;
        this.frameSamples = 320;
        this.encodedBytesPerFrame = 80;
        if (opusCodecConfig == null) {
            return;
        }
        this.sampleRate = opusCodecConfig.sampleRate;
        this.channels = opusCodecConfig.channels;
        this.bitDepth = opusCodecConfig.bitDepth;
        this.application = opusCodecConfig.application;
        this.frameSamples = opusCodecConfig.frameSamples;
        this.encodedBytesPerFrame = opusCodecConfig.encodedBytesPerFrame;
    }
}
