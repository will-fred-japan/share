package p096m7;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StringCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f20512a = Charset.forName("UTF8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f20513b = new t();

    public static String c(ByteBuffer byteBuffer) {
        byte[] bArrArray;
        int iArrayOffset;
        if (byteBuffer == null) {
            return null;
        }
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset();
        } else {
            bArrArray = new byte[iRemaining];
            byteBuffer.get(bArrArray);
            iArrayOffset = 0;
        }
        return new String(bArrArray, iArrayOffset, iRemaining, f20512a);
    }

    public static ByteBuffer d(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f20512a);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytes.length);
        byteBufferAllocateDirect.put(bytes);
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.i
    public final /* bridge */ /* synthetic */ ByteBuffer a(String str) {
        return d(str);
    }

    @Override // p096m7.i
    public final /* bridge */ /* synthetic */ String b(ByteBuffer byteBuffer) {
        return c(byteBuffer);
    }
}
