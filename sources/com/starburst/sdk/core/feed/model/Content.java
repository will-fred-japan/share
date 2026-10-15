package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Content {

    @SerializedName("audioUrl")
    private String audioUrl;

    @SerializedName("content")
    private String content;

    @SerializedName("date")
    private String date;

    @SerializedName("from")
    private String from;

    @SerializedName("id")
    private String id;

    @SerializedName("index")
    private int index;

    @SerializedName("title")
    private String title;

    @SerializedName("wallpaperUrl")
    private String wallpaperUrl;

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public String getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWallpaperUrl() {
        return this.wallpaperUrl;
    }

    public void setAudioUrl(String str) {
        this.audioUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIndex(int i9) {
        this.index = i9;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWallpaperUrl(String str) {
        this.wallpaperUrl = str;
    }
}
