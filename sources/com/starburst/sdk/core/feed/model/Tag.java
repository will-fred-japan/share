package com.starburst.sdk.core.feed.model;

import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Tag {

    @SerializedName(MTPushConstants.Geofence.KEY_COUNT)
    private int contentTotalNum;

    @SerializedName("timestamp")
    private String date;

    @SerializedName("tagId")
    private String tagId;

    @SerializedName("tagName")
    private String tagName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.tagId.equals(((Tag) obj).tagId);
    }

    public int getContentTotalNum() {
        return this.contentTotalNum;
    }

    public String getDate() {
        return this.date;
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        return this.tagId.hashCode();
    }

    public void setContentTotalNum(int i9) {
        this.contentTotalNum = i9;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
