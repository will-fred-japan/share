package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AudioUrlMap {

    @SerializedName("type")
    private int type;

    @SerializedName("urlMap")
    private Map<String, String> urlMap = new HashMap();

    public void clear() {
        if (this.urlMap == null) {
            this.urlMap = new HashMap();
        }
        this.urlMap.clear();
    }

    public int getType() {
        return this.type;
    }

    public String getUrl(String str) {
        if (this.urlMap == null) {
            this.urlMap = new HashMap();
        }
        return this.urlMap.get(str);
    }

    public Map<String, String> getUrlMap() {
        if (this.urlMap == null) {
            this.urlMap = new HashMap();
        }
        return this.urlMap;
    }

    public void putUrl(String str, String str2) {
        if (this.urlMap == null) {
            this.urlMap = new HashMap();
        }
        this.urlMap.put(str, str2);
    }

    public void removeUrl(String str) {
        if (this.urlMap == null) {
            this.urlMap = new HashMap();
        }
        this.urlMap.remove(str);
    }

    public void setType(int i9) {
        this.type = i9;
    }

    public void setUrlMap(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        this.urlMap = map;
    }
}
