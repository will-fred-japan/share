package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AigcCreateResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("imageList")
    private List<String> imageList;

    @SerializedName("msg")
    private String msg;

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("taskId")
    private String taskId;

    public int getCode() {
        return this.code;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }
}
