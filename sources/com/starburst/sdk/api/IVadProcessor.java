package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IVadProcessor extends AutoCloseable {
    public static final int FRAME_BYTES = 960;
    public static final int FRAME_SAMPLES = 480;

    @Override // java.lang.AutoCloseable
    void close();

    default VadState process(byte[] bArr) {
        return process(bArr, 0, bArr == null ? 0 : bArr.length);
    }

    VadState process(byte[] bArr, int i9, int i10);

    void reset();
}
