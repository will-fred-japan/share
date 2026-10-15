package com.starburst.sdk.core.device.bt.entity;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class BleHeader {
    private int encrypt;
    private int frameSeq;
    private int frameTotal;
    private int msgId;
    private int msgSplit;
    private String version;

    public int getEncrypt() {
        return this.encrypt;
    }

    public int getFrameSeq() {
        return this.frameSeq;
    }

    public int getFrameTotal() {
        return this.frameTotal;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public int getMsgSplit() {
        return this.msgSplit;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEncrypt(int i9) {
        this.encrypt = i9;
    }

    public void setFrameSeq(int i9) {
        this.frameSeq = i9;
    }

    public void setFrameTotal(int i9) {
        this.frameTotal = i9;
    }

    public void setMsgId(int i9) {
        this.msgId = i9;
    }

    public void setMsgSplit(int i9) {
        this.msgSplit = i9;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleHeader{version='");
        sb.append(this.version);
        sb.append("', encrypt=");
        sb.append(this.encrypt);
        sb.append(", msgSplit=");
        sb.append(this.msgSplit);
        sb.append(", msgId=");
        sb.append(this.msgId);
        sb.append(", frameTotal=");
        sb.append(this.frameTotal);
        sb.append(", frameSeq=");
        return a.a(sb, this.frameSeq, '}');
    }
}
