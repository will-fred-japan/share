package com.starburst.sdk.resp;

/* JADX INFO: loaded from: classes.dex */
public class FileTaskRes {
    private String failReason;
    private int statusCode;
    private String statusMsg;
    private String taskId;
    private String taskType;

    public String getFailReason() {
        return this.failReason;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setStatusCode(int i9) {
        this.statusCode = i9;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTaskType(String str) {
        this.taskType = str;
    }
}
