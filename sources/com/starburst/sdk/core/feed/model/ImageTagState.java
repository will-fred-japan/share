package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ImageTagState {

    @SerializedName("tag")
    private Tag tag;

    @SerializedName("totalCount")
    private int totalCount;

    @SerializedName("readContentIds")
    private Set<String> readContentIds = new HashSet();

    @SerializedName("cloudUpdateDate")
    private String cloudUpdateDate = "";

    public ImageTagState(Tag tag) {
        this.tag = tag;
        this.totalCount = tag.getContentTotalNum();
    }

    public String getCloudUpdateDate() {
        return this.cloudUpdateDate;
    }

    public Set<String> getReadContentIds() {
        return this.readContentIds;
    }

    public int getReadCount() {
        Set<String> set = this.readContentIds;
        if (set != null) {
            return set.size();
        }
        return 0;
    }

    public Tag getTag() {
        return this.tag;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public boolean isContentRead(String str) {
        Set<String> set = this.readContentIds;
        return set != null && set.contains(str);
    }

    public void markContentRead(String str) {
        Set<String> set = this.readContentIds;
        if (set == null || str == null) {
            return;
        }
        set.add(str);
    }

    public void resetState() {
        Set<String> set = this.readContentIds;
        if (set != null) {
            set.clear();
        }
    }

    public void setCloudUpdateDate(String str) {
        this.cloudUpdateDate = str;
    }

    public void setReadContentIds(Set<String> set) {
        this.readContentIds = set;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setTotalCount(int i9) {
        this.totalCount = i9;
    }
}
