package com.starburst.sdk.core.recorder;

/* JADX INFO: loaded from: classes.dex */
interface VadDetector {
    VadEvent accept(byte[] bArr, int i9);

    void reset();

    default void close() {
    }
}
