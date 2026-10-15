package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public class VcData {
    private String msg;
    private int type;

    public VcData(int i9, String str) {
        this.type = i9;
        this.msg = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getType() {
        return this.type;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setType(int i9) {
        this.type = i9;
    }
}
