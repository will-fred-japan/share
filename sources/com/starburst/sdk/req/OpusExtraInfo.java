package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public class OpusExtraInfo {
    private boolean decodeOpus;
    private int opusInputPackageSize;
    private int opusOutputPackageSize;

    public int getOpusInputPackageSize() {
        return this.opusInputPackageSize;
    }

    public int getOpusOutputPackageSize() {
        return this.opusOutputPackageSize;
    }

    public boolean isDecodeOpus() {
        return this.decodeOpus;
    }

    public void setDecodeOpus(boolean z8) {
        this.decodeOpus = z8;
    }

    public void setOpusInputPackageSize(int i9) {
        this.opusInputPackageSize = i9;
    }

    public void setOpusOutputPackageSize(int i9) {
        this.opusOutputPackageSize = i9;
    }
}
