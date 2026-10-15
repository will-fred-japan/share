package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.au.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ProtocolUtil {
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String TAG = "ProtocolUtil";

    public static void fillIntData(byte[] bArr, int i9, int i10) {
        System.arraycopy(int2ByteArray(i9), 0, bArr, i10, 4);
    }

    public static void fillStringData(byte[] bArr, String str, int i9) {
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i9, bytes.length);
    }

    public static byte[] fixedStringToBytes(String str, int i9) {
        byte[] bytes;
        if (str != null && !"".equals(str)) {
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bytes = null;
            }
            if (bytes != null) {
                byte[] defaultByte = getDefaultByte(i9);
                if (bytes.length <= i9) {
                    i9 = bytes.length;
                }
                System.arraycopy(bytes, 0, defaultByte, 0, i9);
                return defaultByte;
            }
        }
        return new byte[]{0, 0, 0, 0};
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytes] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getBytesConsumed(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytesConsumed] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getDefaultByte(int i9) {
        byte[] bArr = new byte[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[0] = 0;
        }
        return bArr;
    }

    public static String getString(ByteBuffer byteBuffer, int i9) {
        byte[] bArr = new byte[i9];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    public static byte[] int2ByteArray(int i9) {
        return new byte[]{(byte) (i9 >>> 24), (byte) (i9 >>> 16), (byte) (i9 >>> 8), (byte) i9};
    }

    public static byte[] long2ByteArray(long j) {
        return new byte[]{(byte) (j >>> 56), (byte) (j >>> 48), (byte) (j >>> 40), (byte) (j >>> 32), (byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) j};
    }

    public static byte[] short2ByteArray(short s8) {
        return new byte[]{(byte) (s8 >>> 8), (byte) s8};
    }

    public static byte[] tlv2ToByteArray(String str) {
        byte[] bytes;
        if (str != null && !"".equals(str)) {
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bytes = null;
            }
            if (bytes != null) {
                short length = (short) bytes.length;
                byte[] bArr = new byte[length + 2];
                System.arraycopy(short2ByteArray(length), 0, bArr, 0, 2);
                System.arraycopy(bytes, 0, bArr, 2, length);
                return bArr;
            }
        }
        return new byte[]{0, 0};
    }

    public static String getTlv2(ByteBuffer byteBuffer, JResponse jResponse) {
        int i9 = ByteBufferUtils.getShort(byteBuffer, jResponse);
        if (i9 < 0) {
            d.c(TAG, "[getTlv2] - ByteBuffer error.");
            return null;
        }
        byte[] bArr = new byte[i9];
        ByteBufferUtils.get(byteBuffer, bArr, jResponse);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
