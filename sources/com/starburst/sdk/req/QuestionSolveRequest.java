package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public class QuestionSolveRequest {
    public static final String TYPE_MULTI_START = "multi_start";
    public static final String TYPE_STOP = "stop";
    private String contextId;
    private int dialogId;
    private QuestionToolkitInfo toolkitInfo;
    private String type;
    private String format = "raw";
    private String codec = "raw";
    private boolean tts = false;
    private boolean debugEnable = true;
    private String pictureFormat = "jpeg";

    public String getCodec() {
        return this.codec;
    }

    public String getContextId() {
        return this.contextId;
    }

    public int getDialogId() {
        return this.dialogId;
    }

    public String getFormat() {
        return this.format;
    }

    public String getPictureFormat() {
        return this.pictureFormat;
    }

    public QuestionToolkitInfo getToolkitInfo() {
        return this.toolkitInfo;
    }

    public String getType() {
        return this.type;
    }

    public boolean isDebugEnable() {
        return this.debugEnable;
    }

    public boolean isTts() {
        return this.tts;
    }

    public void setCodec(String str) {
        this.codec = str;
    }

    public void setContextId(String str) {
        this.contextId = str;
    }

    public void setDebugEnable(boolean z8) {
        this.debugEnable = z8;
    }

    public void setDialogId(int i9) {
        this.dialogId = i9;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setPictureFormat(String str) {
        this.pictureFormat = str;
    }

    public void setToolkitInfo(QuestionToolkitInfo questionToolkitInfo) {
        this.toolkitInfo = questionToolkitInfo;
    }

    public void setTts(boolean z8) {
        this.tts = z8;
    }

    public void setType(String str) {
        this.type = str;
    }
}
