package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TagListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("results")
    private List<TypeTagGroup> results;

    public static class TypeTagGroup {

        @SerializedName("date")
        private String date;

        @SerializedName("tags")
        private List<Tag> tags;

        @SerializedName("type")
        private String type;

        public String getDate() {
            return this.date;
        }

        public List<Tag> getTags() {
            return this.tags;
        }

        public String getType() {
            return this.type;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public void setTags(List<Tag> list) {
            this.tags = list;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public List<TypeTagGroup> getResults() {
        return this.results;
    }

    public boolean isSuccess() {
        return this.code == 200 && this.results != null;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setResults(List<TypeTagGroup> list) {
        this.results = list;
    }
}
