package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public class RealtimeVideoCallConfig {
    public static final String DEFAULT_INSTRUCTIONS = "你是一位支持实时视频理解的中文助手。回答简洁自然，主动结合摄像头画面。";
    public static final String DEFAULT_MODEL = "1.3.0.0";
    public static final String DEFAULT_PPE_ENV = "ppe_realtime_call_openai";
    public static final String DEFAULT_SPEAKER = "zh_female_wenroutaozi_call_v3_uranus_bigtts";
    private String appKey = "";
    private String accessKey = "";
    private String ppeEnv = DEFAULT_PPE_ENV;
    private String model = DEFAULT_MODEL;
    private String speaker = DEFAULT_SPEAKER;
    private String instructions = DEFAULT_INSTRUCTIONS;

    private static String valueOrEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public RealtimeVideoCallConfig copy() {
        return new RealtimeVideoCallConfig().setAppKey(this.appKey).setAccessKey(this.accessKey).setPpeEnv(this.ppeEnv).setModel(this.model).setSpeaker(this.speaker).setInstructions(this.instructions);
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getModel() {
        return this.model;
    }

    public String getPpeEnv() {
        return this.ppeEnv;
    }

    public String getSpeaker() {
        return this.speaker;
    }

    public RealtimeVideoCallConfig setAccessKey(String str) {
        this.accessKey = valueOrEmpty(str);
        return this;
    }

    public RealtimeVideoCallConfig setAppKey(String str) {
        this.appKey = valueOrEmpty(str);
        return this;
    }

    public RealtimeVideoCallConfig setInstructions(String str) {
        this.instructions = valueOrEmpty(str);
        return this;
    }

    public RealtimeVideoCallConfig setModel(String str) {
        this.model = valueOrEmpty(str);
        return this;
    }

    public RealtimeVideoCallConfig setPpeEnv(String str) {
        this.ppeEnv = valueOrEmpty(str);
        return this;
    }

    public RealtimeVideoCallConfig setSpeaker(String str) {
        this.speaker = valueOrEmpty(str);
        return this;
    }
}
