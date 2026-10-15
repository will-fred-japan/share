package com.starburst.sdk.core.device.bt.entity;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BleData {
    private byte[] CRC;
    private BlePayload blePayload;
    private BleHeader header;

    public BlePayload getBlePayload() {
        return this.blePayload;
    }

    public byte[] getCRC() {
        return this.CRC;
    }

    public BleHeader getHeader() {
        return this.header;
    }

    public void setBlePayload(BlePayload blePayload) {
        this.blePayload = blePayload;
    }

    public void setCRC(byte[] bArr) {
        this.CRC = bArr;
    }

    public void setHeader(BleHeader bleHeader) {
        this.header = bleHeader;
    }

    public String toString() {
        return "BleData{header=" + this.header + ", blePayload=" + this.blePayload + ", CRC=" + Arrays.toString(this.CRC) + '}';
    }
}
