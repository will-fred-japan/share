package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.au.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;
    private static final String TAG = "ByteBufferUtils";

    private static String generalExtraStr(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (jResponse != null) {
            sb.append(jResponse.toString());
            StringBuilder sb2 = new StringBuilder("|bytebuffer:");
            sb2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            sb.append(sb2.toString());
        }
        d.f(TAG, "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            d.f(TAG, "parse data error stackTrace:" + stringWriter.toString());
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static Byte get(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferOverflowException | BufferUnderflowException | Exception e9) {
            onException(e9.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.code = 10000;
            return null;
        }
    }

    public static int getInt(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getInt();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e9) {
            onException(e9.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return -1;
            }
            jResponse.code = 10000;
            return -1;
        }
    }

    public static long getLong(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getLong();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e9) {
            onException(e9.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return 0L;
            }
            jResponse.code = 10000;
            return 0L;
        }
    }

    public static short getShort(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getShort();
        } catch (BufferOverflowException | BufferUnderflowException | Exception e9) {
            onException(e9.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return (short) -1;
            }
            jResponse.code = 10000;
            return (short) -1;
        }
    }

    private static void onException(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        generalExtraStr(th, jResponse, byteBuffer);
    }

    public static ByteBuffer get(ByteBuffer byteBuffer, byte[] bArr, JResponse jResponse) {
        try {
            return byteBuffer.get(bArr);
        } catch (BufferOverflowException | BufferUnderflowException | Exception e9) {
            onException(e9.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.code = 10000;
            return null;
        }
    }
}
