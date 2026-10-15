package com.starburst.sdk.core.tts;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class WsMessage {
    public static final Companion Companion = new Companion(null);
    private final byte eventType;
    private final byte msgType;
    private final byte[] payload;
    private final int seq;
    private final byte status;
    private final byte version;

    public static final class Companion {
        private Companion() {
        }

        public final WsMessage decode(ByteString bytes) {
            k.e(bytes, "bytes");
            ByteBuffer byteBufferAsByteBuffer = bytes.asByteBuffer();
            byteBufferAsByteBuffer.order(ByteOrder.BIG_ENDIAN);
            byte b9 = byteBufferAsByteBuffer.get();
            byte b10 = byteBufferAsByteBuffer.get();
            byte b11 = byteBufferAsByteBuffer.get();
            byte b12 = byteBufferAsByteBuffer.get();
            int i9 = byteBufferAsByteBuffer.getInt();
            int i10 = byteBufferAsByteBuffer.getInt();
            byte[] bArr = new byte[i10 < 0 ? 0 : i10];
            if (i10 > 0) {
                byteBufferAsByteBuffer.get(bArr);
            }
            return new WsMessage(b9, b10, b11, b12, i9, bArr);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public WsMessage(byte b9, byte b10, byte b11, byte b12, int i9, byte[] payload) {
        k.e(payload, "payload");
        this.version = b9;
        this.msgType = b10;
        this.eventType = b11;
        this.status = b12;
        this.seq = i9;
        this.payload = payload;
    }

    public static /* synthetic */ WsMessage copy$default(WsMessage wsMessage, byte b9, byte b10, byte b11, byte b12, int i9, byte[] bArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b9 = wsMessage.version;
        }
        if ((i10 & 2) != 0) {
            b10 = wsMessage.msgType;
        }
        if ((i10 & 4) != 0) {
            b11 = wsMessage.eventType;
        }
        if ((i10 & 8) != 0) {
            b12 = wsMessage.status;
        }
        if ((i10 & 16) != 0) {
            i9 = wsMessage.seq;
        }
        if ((i10 & 32) != 0) {
            bArr = wsMessage.payload;
        }
        int i11 = i9;
        byte[] bArr2 = bArr;
        return wsMessage.copy(b9, b10, b11, b12, i11, bArr2);
    }

    public final byte component1() {
        return this.version;
    }

    public final byte component2() {
        return this.msgType;
    }

    public final byte component3() {
        return this.eventType;
    }

    public final byte component4() {
        return this.status;
    }

    public final int component5() {
        return this.seq;
    }

    public final byte[] component6() {
        return this.payload;
    }

    public final WsMessage copy(byte b9, byte b10, byte b11, byte b12, int i9, byte[] payload) {
        k.e(payload, "payload");
        return new WsMessage(b9, b10, b11, b12, i9, payload);
    }

    public final ByteString encode() {
        int length = this.payload.length;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(this.version);
        byteBufferAllocate.put(this.msgType);
        byteBufferAllocate.put(this.eventType);
        byteBufferAllocate.put(this.status);
        byteBufferAllocate.putInt(this.seq);
        byteBufferAllocate.putInt(length);
        if (length > 0) {
            byteBufferAllocate.put(this.payload);
        }
        byteBufferAllocate.flip();
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArrArray = byteBufferAllocate.array();
        k.d(bArrArray, "array(...)");
        return companion.of(Arrays.copyOf(bArrArray, bArrArray.length));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WsMessage)) {
            return false;
        }
        WsMessage wsMessage = (WsMessage) obj;
        return this.version == wsMessage.version && this.msgType == wsMessage.msgType && this.eventType == wsMessage.eventType && this.status == wsMessage.status && this.seq == wsMessage.seq && k.a(this.payload, wsMessage.payload);
    }

    public final byte getEventType() {
        return this.eventType;
    }

    public final byte getMsgType() {
        return this.msgType;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final int getSeq() {
        return this.seq;
    }

    public final byte getStatus() {
        return this.status;
    }

    public final byte getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Arrays.hashCode(this.payload) + ((Integer.hashCode(this.seq) + ((Byte.hashCode(this.status) + ((Byte.hashCode(this.eventType) + ((Byte.hashCode(this.msgType) + (Byte.hashCode(this.version) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "WsMessage(version=" + ((int) this.version) + ", msgType=" + ((int) this.msgType) + ", eventType=" + ((int) this.eventType) + ", status=" + ((int) this.status) + ", seq=" + this.seq + ", payload=" + Arrays.toString(this.payload) + ')';
    }

    public /* synthetic */ WsMessage(byte b9, byte b10, byte b11, byte b12, int i9, byte[] bArr, int i10, f fVar) {
        this((i10 & 1) != 0 ? (byte) 1 : b9, b10, b11, (i10 & 8) != 0 ? (byte) 0 : b12, (i10 & 16) != 0 ? 0 : i9, (i10 & 32) != 0 ? new byte[0] : bArr);
    }
}
