package com.starburst.sdk.core.device.bt.entity;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BlePayload {
    private int cmdType;
    private int dataType;
    private byte[] datas;

    public int getCmdType() {
        return this.cmdType;
    }

    public int getDataType() {
        return this.dataType;
    }

    public byte[] getDatas() {
        return this.datas;
    }

    public void setCmdType(int i9) {
        this.cmdType = i9;
    }

    public void setDataType(int i9) {
        this.dataType = i9;
    }

    public void setDatas(byte[] bArr) {
        this.datas = bArr;
    }

    public String toString() {
        return "BlePayload{cmdType=" + this.cmdType + ", dataType=" + this.dataType + ", datas=" + Arrays.toString(this.datas) + '}';
    }
}
