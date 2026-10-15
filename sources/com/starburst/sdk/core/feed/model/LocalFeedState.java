package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocalFeedState {

    @SerializedName("newsTagStates")
    private List<TextTagState> newsTagStates = new ArrayList();

    @SerializedName("jokeTagStates")
    private List<TextTagState> jokeTagStates = new ArrayList();

    @SerializedName("wallpaperTagStates")
    private List<ImageTagState> wallpaperTagStates = new ArrayList();

    @SerializedName("lastTagSyncTime")
    private String lastTagSyncTime = "";

    public List<TextTagState> getJokeTagStates() {
        return this.jokeTagStates;
    }

    public String getLastTagSyncTime() {
        return this.lastTagSyncTime;
    }

    public List<TextTagState> getNewsTagStates() {
        return this.newsTagStates;
    }

    public List<ImageTagState> getWallpaperTagStates() {
        return this.wallpaperTagStates;
    }

    public void setJokeTagStates(List<TextTagState> list) {
        this.jokeTagStates = list;
    }

    public void setLastTagSyncTime(String str) {
        this.lastTagSyncTime = str;
    }

    public void setNewsTagStates(List<TextTagState> list) {
        this.newsTagStates = list;
    }

    public void setWallpaperTagStates(List<ImageTagState> list) {
        this.wallpaperTagStates = list;
    }
}
