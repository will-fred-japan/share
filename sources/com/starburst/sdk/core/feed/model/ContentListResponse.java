package com.starburst.sdk.core.feed.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContentListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("results")
    private List<TagContentGroup> results;

    public static class TagContentGroup {

        @SerializedName("contents")
        private List<Content> contents;

        @SerializedName("date")
        private String date;

        @SerializedName("pageNum")
        private int pageNum;

        @SerializedName("pageSize")
        private int pageSize;

        @SerializedName("tagId")
        private String tagId;

        @SerializedName("tagName")
        private String tagName;

        @SerializedName("total")
        private int total;

        @SerializedName("type")
        private String type;

        public List<Content> getContents() {
            return this.contents;
        }

        public String getDate() {
            return this.date;
        }

        public int getPageNum() {
            return this.pageNum;
        }

        public int getPageSize() {
            return this.pageSize;
        }

        public String getTagId() {
            return this.tagId;
        }

        public String getTagName() {
            return this.tagName;
        }

        public int getTotal() {
            return this.total;
        }

        public String getType() {
            return this.type;
        }

        public void setContents(List<Content> list) {
            this.contents = list;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public void setPageNum(int i9) {
            this.pageNum = i9;
        }

        public void setPageSize(int i9) {
            this.pageSize = i9;
        }

        public void setTagId(String str) {
            this.tagId = str;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }

        public void setTotal(int i9) {
            this.total = i9;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public TagContentGroup getFirstTagContent() {
        List<TagContentGroup> list = this.results;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.results.get(0);
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public List<TagContentGroup> getResults() {
        return this.results;
    }

    public boolean isSuccess() {
        List<TagContentGroup> list;
        return (this.code != 200 || (list = this.results) == null || list.isEmpty()) ? false : true;
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

    public void setResults(List<TagContentGroup> list) {
        this.results = list;
    }
}
