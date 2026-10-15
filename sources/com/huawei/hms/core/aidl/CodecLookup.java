package com.huawei.hms.core.aidl;

/* JADX INFO: loaded from: classes.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i9) {
        return i9 == 2 ? new MessageCodecV2() : new MessageCodec();
    }
}
