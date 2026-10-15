package com.starburst.sdk.core.device.bt.domain;

/* JADX INFO: loaded from: classes.dex */
public class SendData {
    private String data;
    private String sid;
    private long ver;

    public SendData(String str, String str2) {
        this.sid = str;
        this.data = str2;
    }

    public String getData() {
        return this.data;
    }

    public String getSid() {
        return this.sid;
    }

    public long getVer() {
        return this.ver;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setVer(long j) {
        this.ver = j;
    }

    public String toString() {
        return "SendData{sid='" + this.sid + "', data='" + this.data + "', ver=" + this.ver + '}';
    }
}
