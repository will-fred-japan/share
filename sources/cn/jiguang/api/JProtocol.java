package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.au.c;
import cn.jiguang.au.d;
import cn.jiguang.au.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class JProtocol {
    public static final int DEFAULT_RESP_CODE = 0;
    public static final int DEFAULT_RID = 0;
    public static final int DEFAULT_SID = 0;
    public static final int NO_JUID = -1;
    public static final int NO_RESP_CODE = -1;
    public static final int NO_SID = -1;
    private static final int PACKET_SIZE = 7168;
    private static final String TAG = "JProtocol";
    protected ByteBuffer body;
    protected c head;
    private boolean isRequest;

    public JProtocol(boolean z8, int i9, int i10, long j) {
        this.isRequest = z8;
        this.head = new c(z8, i9, i10, j);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public static byte[] parseHead(Object obj) {
        String str;
        if (obj == null) {
            str = "object was null";
        } else {
            if (obj instanceof c) {
                return ((c) obj).f();
            }
            str = "unknow Object";
        }
        d.c(TAG, str);
        return null;
    }

    private final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = ProtocolUtil.getBytes(this.body);
        if (bytes == null) {
            d.c(TAG, "toBytes bodyBytes  is  null");
            return null;
        }
        this.head.a((this.isRequest ? 24 : 20) + bytes.length);
        try {
            byteArrayOutputStream.write(this.head.f());
            byteArrayOutputStream.write(bytes);
        } catch (Exception unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        d.b(TAG, "Final - len:" + byteArray.length + ", bytes: " + f.a(byteArray));
        return byteArray;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.head.a();
    }

    public c getHead() {
        return this.head;
    }

    public long getJuid() {
        return this.head.c();
    }

    public abstract String getName();

    public Long getRid() {
        return this.head.b();
    }

    public int getSid() {
        return this.head.d();
    }

    public int getVersion() {
        return this.head.e();
    }

    public abstract boolean isNeedParseeErrorMsg();

    public abstract void parseBody();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.isRequest ? "[Request]" : "[Response]");
        sb.append(" - ");
        sb.append(this.head.toString());
        return sb.toString();
    }

    public abstract void writeBody();

    public final byte[] writeBodyAndToBytes() {
        this.body.clear();
        writeBody();
        this.body.flip();
        return toBytes();
    }

    public void writeBytes(byte[] bArr) {
        this.body.put(bArr);
    }

    public void writeInt1(int i9) {
        this.body.put((byte) i9);
    }

    public void writeInt2(int i9) {
        this.body.putShort((short) i9);
    }

    public void writeInt4(int i9) {
        this.body.putInt(i9);
    }

    public void writeLong8(long j) {
        this.body.putLong(j);
    }

    public void writeTlv2(String str) {
        this.body.put(ProtocolUtil.tlv2ToByteArray(str));
    }

    public JProtocol(boolean z8, int i9, int i10, long j, int i11, long j8) {
        this.isRequest = z8;
        this.head = new c(z8, 0, i9, i10, j, i11, j8);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public JProtocol(boolean z8, Object obj, ByteBuffer byteBuffer) {
        this.isRequest = z8;
        this.head = (c) obj;
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
        } else {
            this.body = byteBuffer;
            parseBody();
        }
    }

    public JProtocol(boolean z8, ByteBuffer byteBuffer, byte[] bArr) {
        this.isRequest = z8;
        try {
            this.head = new c(z8, bArr);
        } catch (Exception e9) {
            d.c(TAG, "create JHead failed:" + e9.getMessage());
        }
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
        } else {
            this.body = byteBuffer;
            parseBody();
        }
    }
}
