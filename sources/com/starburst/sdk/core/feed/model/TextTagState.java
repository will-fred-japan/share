package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class TextTagState {

    @SerializedName("tag")
    private Tag tag;

    @SerializedName("totalCount")
    private int totalCount;

    @SerializedName("readCount")
    private int readCount = 0;

    @SerializedName("readPageNum")
    private int readPageNum = 0;

    @SerializedName("currentPageReadCount")
    private int currentPageReadCount = 0;

    @SerializedName("cloudUpdateDate")
    private String cloudUpdateDate = "";

    public TextTagState(Tag tag) {
        this.tag = tag;
        this.totalCount = tag.getContentTotalNum();
    }

    public String getCloudUpdateDate() {
        return this.cloudUpdateDate;
    }

    public int getCurrentPageReadCount() {
        return this.currentPageReadCount;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public int getReadPageNum() {
        return this.readPageNum;
    }

    public Tag getTag() {
        return this.tag;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void resetState() {
        this.readCount = 0;
        this.readPageNum = 0;
        this.currentPageReadCount = 0;
    }

    public void setCloudUpdateDate(String str) {
        this.cloudUpdateDate = str;
    }

    public void setCurrentPageReadCount(int i9) {
        this.currentPageReadCount = i9;
    }

    public void setReadCount(int i9) {
        this.readCount = i9;
    }

    public void setReadPageNum(int i9) {
        this.readPageNum = i9;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setTotalCount(int i9) {
        this.totalCount = i9;
    }
}
