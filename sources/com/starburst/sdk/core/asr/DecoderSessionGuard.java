package com.starburst.sdk.core.asr;

/* JADX INFO: loaded from: classes.dex */
final class DecoderSessionGuard {
    private DecoderSessionGuard() {
    }

    public static boolean accepts(int i9, int i10, int i11) {
        if (i10 == 0 || i11 != i10) {
            return false;
        }
        return i9 == 0 || i9 == i10;
    }
}
