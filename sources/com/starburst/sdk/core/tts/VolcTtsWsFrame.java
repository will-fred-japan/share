package com.starburst.sdk.core.tts;

import R7.a;
import kotlin.jvm.internal.k;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class VolcTtsWsFrame {
    private static final int COMPRESSION_NONE = 0;
    private static final int HEADER_SIZE_WORDS = 2;
    public static final VolcTtsWsFrame INSTANCE = new VolcTtsWsFrame();
    private static final int MESSAGE_TYPE_FULL_CLIENT_REQ = 1;
    private static final int MSG_FLAGS_NONE = 0;
    private static final int PROTOCOL_VERSION = 1;
    private static final int SERIALIZATION_JSON = 1;

    private VolcTtsWsFrame() {
    }

    private final void writeUint32BE(byte[] bArr, int i9, int i10) {
        bArr[i9] = (byte) ((i10 >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i9 + 3] = (byte) (i10 & 255);
    }

    public final ByteString encodeJsonRequest(String json) {
        k.e(json, "json");
        byte[] bytes = json.getBytes(a.f4067b);
        k.d(bytes, "getBytes(...)");
        byte[] bArr = {18, 16, 16, 0, 0, 0, 0, 0};
        writeUint32BE(bArr, 4, bytes.length);
        byte[] bArr2 = new byte[bytes.length + 8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        System.arraycopy(bytes, 0, bArr2, 8, bytes.length);
        return ByteString.Companion.of$default(ByteString.Companion, bArr2, 0, 0, 3, null);
    }
}
