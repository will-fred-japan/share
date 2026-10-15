package com.alibaba.fastjson.util;

import com.alibaba.fastjson.asm.Opcodes;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        ByteBuffer byteBuffer2;
        CharBuffer charBuffer2;
        int i9;
        int i10;
        int i11;
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iLimit = byteBuffer.limit() + byteBuffer.arrayOffset();
        char[] cArrArray = charBuffer.array();
        int iPosition2 = charBuffer.position() + charBuffer.arrayOffset();
        int iLimit2 = charBuffer.limit() + charBuffer.arrayOffset();
        int iMin = Math.min(iLimit - iPosition, iLimit2 - iPosition2) + iPosition2;
        while (iPosition2 < iMin) {
            byte b9 = bArrArray[iPosition];
            if (b9 < 0) {
                break;
            }
            iPosition++;
            cArrArray[iPosition2] = (char) b9;
            iPosition2++;
        }
        int i12 = iPosition2;
        while (iPosition < iLimit) {
            byte b10 = bArrArray[iPosition];
            if (b10 < 0) {
                byteBuffer2 = byteBuffer;
                charBuffer2 = charBuffer;
                i9 = iLimit2;
                int i13 = iPosition;
                if ((b10 >> 5) == -2) {
                    if (iLimit - i13 < 2 || i12 >= i9) {
                        return xflow(byteBuffer2, i13, iLimit, charBuffer2, i12, 2);
                    }
                    byte b11 = bArrArray[i13 + 1];
                    if (isMalformed2(b10, b11)) {
                        return malformed(byteBuffer2, i13, charBuffer2, i12, 2);
                    }
                    i10 = i12 + 1;
                    cArrArray[i12] = (char) ((b11 ^ (b10 << 6)) ^ Utf8.MASK_2BYTES);
                    i11 = i13 + 2;
                } else if ((b10 >> 4) == -2) {
                    if (iLimit - i13 < 3 || i12 >= i9) {
                        return xflow(byteBuffer2, i13, iLimit, charBuffer2, i12, 3);
                    }
                    byte b12 = bArrArray[i13 + 1];
                    byte b13 = bArrArray[i13 + 2];
                    if (isMalformed3(b10, b12, b13)) {
                        return malformed(byteBuffer2, i13, charBuffer2, i12, 3);
                    }
                    i10 = i12 + 1;
                    cArrArray[i12] = (char) ((((b12 << 6) ^ (b10 << 12)) ^ b13) ^ 8064);
                    i11 = i13 + 3;
                } else {
                    if ((b10 >> 3) != -2) {
                        return malformed(byteBuffer2, i13, charBuffer2, i12, 1);
                    }
                    if (iLimit - i13 < 4 || i9 - i12 < 2) {
                        return xflow(byteBuffer2, i13, iLimit, charBuffer2, i12, 4);
                    }
                    byte b14 = bArrArray[i13 + 1];
                    byte b15 = bArrArray[i13 + 2];
                    byte b16 = bArrArray[i13 + 3];
                    int i14 = ((b10 & 7) << 18) | ((b14 & Utf8.REPLACEMENT_BYTE) << 12) | ((b15 & Utf8.REPLACEMENT_BYTE) << 6) | (b16 & Utf8.REPLACEMENT_BYTE);
                    if (isMalformed4(b14, b15, b16) || i14 < 65536 || i14 > 1114111) {
                        return malformed(byteBuffer2, i13, charBuffer2, i12, 4);
                    }
                    int i15 = i12 + 1;
                    int i16 = i14 - 65536;
                    cArrArray[i12] = (char) (((i16 >> 10) & 1023) | 55296);
                    i12 += 2;
                    cArrArray[i15] = (char) (56320 | (i16 & 1023));
                    iPosition = i13 + 4;
                }
                i12 = i10;
                iPosition = i11;
            } else {
                if (i12 >= iLimit2) {
                    return xflow(byteBuffer, iPosition, iLimit, charBuffer, i12, 1);
                }
                byteBuffer2 = byteBuffer;
                charBuffer2 = charBuffer;
                i9 = iLimit2;
                cArrArray[i12] = (char) b10;
                iPosition++;
                i12++;
            }
            iLimit2 = i9;
            byteBuffer = byteBuffer2;
            charBuffer = charBuffer2;
        }
        return xflow(byteBuffer, iPosition, iLimit, charBuffer, i12, 0);
    }

    private static boolean isMalformed2(int i9, int i10) {
        return (i9 & 30) == 0 || (i10 & Opcodes.CHECKCAST) != 128;
    }

    private static boolean isMalformed3(int i9, int i10, int i11) {
        return ((i9 != -32 || (i10 & 224) != 128) && (i10 & Opcodes.CHECKCAST) == 128 && (i11 & Opcodes.CHECKCAST) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i9, int i10, int i11) {
        return ((i9 & Opcodes.CHECKCAST) == 128 && (i10 & Opcodes.CHECKCAST) == 128 && (i11 & Opcodes.CHECKCAST) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i9) {
        return (i9 & Opcodes.CHECKCAST) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i9) {
        for (int i10 = 1; i10 < i9; i10++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i10);
            }
        }
        return CoderResult.malformedForLength(i9);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i9, CharBuffer charBuffer, int i10, int i11) {
        byteBuffer.position(i9 - byteBuffer.arrayOffset());
        CoderResult coderResultMalformedN = malformedN(byteBuffer, i11);
        byteBuffer.position(i9);
        charBuffer.position(i10);
        return coderResultMalformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i9) {
        int i10 = 1;
        if (i9 == 1) {
            byte b9 = byteBuffer.get();
            if ((b9 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b9 >> 1) == -2) {
                return byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i9 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i9 == 3) {
            byte b10 = byteBuffer.get();
            byte b11 = byteBuffer.get();
            if ((b10 != -32 || (b11 & 224) != 128) && !isNotContinuation(b11)) {
                i10 = 2;
            }
            return CoderResult.malformedForLength(i10);
        }
        if (i9 != 4) {
            throw new IllegalStateException();
        }
        int i11 = byteBuffer.get() & 255;
        byte b12 = byteBuffer.get();
        int i12 = b12 & 255;
        if (i11 > 244 || ((i11 == 240 && (i12 < 144 || i12 > 191)) || ((i11 == 244 && (b12 & 240) != 128) || isNotContinuation(i12)))) {
            return CoderResult.malformedForLength(1);
        }
        return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
    }

    private static CoderResult xflow(Buffer buffer, int i9, int i10, Buffer buffer2, int i11, int i12) {
        buffer.position(i9);
        buffer2.position(i11);
        return (i12 == 0 || i10 - i9 < i12) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
