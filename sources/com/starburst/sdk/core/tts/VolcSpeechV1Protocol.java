package com.starburst.sdk.core.tts;

import R7.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import okio.ByteString;
import y7.f;

/* JADX INFO: loaded from: classes.dex */
public final class VolcSpeechV1Protocol {
    private static final int COMPRESSION_NONE = 0;
    private static final int HEADER_SIZE_WORDS = 3;
    public static final VolcSpeechV1Protocol INSTANCE = new VolcSpeechV1Protocol();
    public static final int MSG_TYPE_AUDIO_ONLY_CLIENT = 4;
    public static final int MSG_TYPE_AUDIO_ONLY_SERVER = 6;
    public static final int MSG_TYPE_FINISH_CONNECTION = 3;
    public static final int MSG_TYPE_FULL_CLIENT_REQUEST = 1;
    public static final int MSG_TYPE_FULL_SERVER_RESPONSE = 5;
    public static final int MSG_TYPE_START_CONNECTION = 2;
    private static final int SERIALIZATION_JSON = 1;
    private static final String TAG = "VolcSpeechV1";
    public static final int VERSION = 1;

    public static final class ParsedFrame {
        private final byte[] body;
        private final int bodySize;
        private final int compression;
        private final int ext;
        private final int flags;
        private final int headerSizeWords;
        private final int msgType;
        private final int serialization;
        private final int version;

        public ParsedFrame(int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, byte[] body) {
            k.e(body, "body");
            this.version = i9;
            this.headerSizeWords = i10;
            this.msgType = i11;
            this.flags = i12;
            this.serialization = i13;
            this.compression = i14;
            this.bodySize = i15;
            this.ext = i16;
            this.body = body;
        }

        public static /* synthetic */ ParsedFrame copy$default(ParsedFrame parsedFrame, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, byte[] bArr, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i9 = parsedFrame.version;
            }
            if ((i17 & 2) != 0) {
                i10 = parsedFrame.headerSizeWords;
            }
            if ((i17 & 4) != 0) {
                i11 = parsedFrame.msgType;
            }
            if ((i17 & 8) != 0) {
                i12 = parsedFrame.flags;
            }
            if ((i17 & 16) != 0) {
                i13 = parsedFrame.serialization;
            }
            if ((i17 & 32) != 0) {
                i14 = parsedFrame.compression;
            }
            if ((i17 & 64) != 0) {
                i15 = parsedFrame.bodySize;
            }
            if ((i17 & 128) != 0) {
                i16 = parsedFrame.ext;
            }
            if ((i17 & 256) != 0) {
                bArr = parsedFrame.body;
            }
            int i18 = i16;
            byte[] bArr2 = bArr;
            int i19 = i14;
            int i20 = i15;
            int i21 = i13;
            int i22 = i11;
            return parsedFrame.copy(i9, i10, i22, i12, i21, i19, i20, i18, bArr2);
        }

        public final int component1() {
            return this.version;
        }

        public final int component2() {
            return this.headerSizeWords;
        }

        public final int component3() {
            return this.msgType;
        }

        public final int component4() {
            return this.flags;
        }

        public final int component5() {
            return this.serialization;
        }

        public final int component6() {
            return this.compression;
        }

        public final int component7() {
            return this.bodySize;
        }

        public final int component8() {
            return this.ext;
        }

        public final byte[] component9() {
            return this.body;
        }

        public final ParsedFrame copy(int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, byte[] body) {
            k.e(body, "body");
            return new ParsedFrame(i9, i10, i11, i12, i13, i14, i15, i16, body);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParsedFrame)) {
                return false;
            }
            ParsedFrame parsedFrame = (ParsedFrame) obj;
            return this.version == parsedFrame.version && this.headerSizeWords == parsedFrame.headerSizeWords && this.msgType == parsedFrame.msgType && this.flags == parsedFrame.flags && this.serialization == parsedFrame.serialization && this.compression == parsedFrame.compression && this.bodySize == parsedFrame.bodySize && this.ext == parsedFrame.ext && k.a(this.body, parsedFrame.body);
        }

        public final byte[] getBody() {
            return this.body;
        }

        public final int getBodySize() {
            return this.bodySize;
        }

        public final int getCompression() {
            return this.compression;
        }

        public final int getExt() {
            return this.ext;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getHeaderSizeWords() {
            return this.headerSizeWords;
        }

        public final int getMsgType() {
            return this.msgType;
        }

        public final int getSerialization() {
            return this.serialization;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return Arrays.hashCode(this.body) + ((Integer.hashCode(this.ext) + ((Integer.hashCode(this.bodySize) + ((Integer.hashCode(this.compression) + ((Integer.hashCode(this.serialization) + ((Integer.hashCode(this.flags) + ((Integer.hashCode(this.msgType) + ((Integer.hashCode(this.headerSizeWords) + (Integer.hashCode(this.version) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "ParsedFrame(version=" + this.version + ", headerSizeWords=" + this.headerSizeWords + ", msgType=" + this.msgType + ", flags=" + this.flags + ", serialization=" + this.serialization + ", compression=" + this.compression + ", bodySize=" + this.bodySize + ", ext=" + this.ext + ", body=" + Arrays.toString(this.body) + ')';
        }
    }

    private VolcSpeechV1Protocol() {
    }

    public final ByteString encodeJsonFullClientRequest(String json) {
        k.e(json, "json");
        byte[] bytes = json.getBytes(a.f4067b);
        k.d(bytes, "getBytes(...)");
        int length = bytes.length;
        byte[] bArr = new byte[length + 12];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        byteBufferWrap.put((byte) 19);
        byte b9 = (byte) 16;
        byteBufferWrap.put(b9);
        byteBufferWrap.put(b9);
        byteBufferWrap.put((byte) 0);
        byteBufferWrap.putInt(length);
        byteBufferWrap.putInt(0);
        byteBufferWrap.put(bytes);
        f.f(0, 12, bArr);
        return ByteString.Companion.of$default(ByteString.Companion, bArr, 0, 0, 3, null);
    }

    public final ParsedFrame parseFrame(byte[] bytes) {
        k.e(bytes, "bytes");
        if (bytes.length < 12) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        byte b9 = byteBufferWrap.get();
        byte b10 = byteBufferWrap.get();
        byte b11 = byteBufferWrap.get();
        byteBufferWrap.get();
        int i9 = ((b9 & 255) >>> 4) & 15;
        int i10 = b9 & 15;
        int i11 = ((b10 & 255) >>> 4) & 15;
        int i12 = b10 & 15;
        int i13 = ((b11 & 255) >>> 4) & 15;
        int i14 = b11 & 15;
        int i15 = byteBufferWrap.getInt();
        int i16 = byteBufferWrap.getInt();
        int i17 = i10 * 4;
        if (bytes.length < i17) {
            return null;
        }
        return new ParsedFrame(i9, i10, i11, i12, i13, i14, i15, i16, f.f(i17, bytes.length, bytes));
    }
}
