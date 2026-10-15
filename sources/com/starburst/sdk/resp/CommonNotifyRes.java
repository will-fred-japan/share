package com.starburst.sdk.resp;

/* JADX INFO: loaded from: classes.dex */
public class CommonNotifyRes {
    private String id;
    private String method;
    private Object params;
    private String version;

    public static class ParamsDTO {
        private Integer code;
        private String content;
        private String msg;
        private String name;
        private String traceId;

        public Integer getCode() {
            return this.code;
        }

        public String getContent() {
            return this.content;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getName() {
            return this.name;
        }

        public String getTraceId() {
            return this.traceId;
        }

        public void setCode(Integer num) {
            this.code = num;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setTraceId(String str) {
            this.traceId = str;
        }
    }

    public String getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public Object getParams() {
        return this.params;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(Object obj) {
        this.params = obj;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
