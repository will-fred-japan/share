package com.starburst.sdk.core.feed.model;

/* JADX INFO: loaded from: classes.dex */
public class ContentWithTag {
    private Content content;
    private String tagId;
    private String tagName;

    public ContentWithTag() {
    }

    public Content getContent() {
        return this.content;
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public ContentWithTag(Content content, String str, String str2) {
        this.content = content;
        this.tagId = str;
        this.tagName = str2;
    }
}
