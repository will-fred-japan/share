package com.starburst.sdk.core.feed.model;

import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AigcQueryResponse {

    @SerializedName(MTPushConstants.Geofence.KEY_COUNT)
    private int count;

    @SerializedName("imageList")
    private List<String> imageList;

    @SerializedName("prompt")
    private String prompt;

    @SerializedName(HiAnalyticsConstant.HaKey.BI_KEY_RESULT)
    private int statusCode;

    @SerializedName("statusDesc")
    private String statusDesc;

    @SerializedName("style")
    private String style;

    @SerializedName("taskId")
    private String taskId;

    @SerializedName("width")
    private int width;

    public int getCount() {
        return this.count;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }

    public String getStyle() {
        return this.style;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isProcessing() {
        int i9 = this.statusCode;
        if (i9 == 202) {
            return true;
        }
        if (i9 != 0) {
            return false;
        }
        String str = this.taskId;
        if (str != null && !str.isEmpty()) {
            return false;
        }
        List<String> list = this.imageList;
        return list == null || list.isEmpty();
    }

    public boolean isSuccess() {
        List<String> list;
        return (this.statusCode != 200 || (list = this.imageList) == null || list.isEmpty()) ? false : true;
    }

    public void setCount(int i9) {
        this.count = i9;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public void setPrompt(String str) {
        this.prompt = str;
    }

    public void setStatusCode(int i9) {
        this.statusCode = i9;
    }

    public void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setWidth(int i9) {
        this.width = i9;
    }
}
