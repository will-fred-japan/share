package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.asm.Opcodes;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    static final char[] digits;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];
    public static final boolean[] identifierFlags = new boolean[256];

    static {
        char c5 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c5 >= zArr.length) {
                break;
            }
            if (c5 >= 'A' && c5 <= 'Z') {
                zArr[c5] = true;
            } else if (c5 >= 'a' && c5 <= 'z') {
                zArr[c5] = true;
            } else if (c5 == '_' || c5 == '$') {
                zArr[c5] = true;
            }
            c5 = (char) (c5 + 1);
        }
        char c9 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c9 < zArr2.length) {
                if (c9 >= 'A' && c9 <= 'Z') {
                    zArr2[c9] = true;
                } else if (c9 >= 'a' && c9 <= 'z') {
                    zArr2[c9] = true;
                } else if (c9 == '_') {
                    zArr2[c9] = true;
                } else if (c9 >= '0' && c9 <= '9') {
                    zArr2[c9] = true;
                }
                c9 = (char) (c9 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[Opcodes.IF_ICMPLT];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[Opcodes.IF_ICMPLT];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[Opcodes.IF_ICMPLT];
        specicalFlags_singleQuotesFlags = new boolean[Opcodes.IF_ICMPLT];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i9 = 14; i9 <= 31; i9++) {
            specicalFlags_doubleQuotes[i9] = 4;
            specicalFlags_singleQuotes[i9] = 4;
        }
        for (int i10 = 127; i10 < 160; i10++) {
            specicalFlags_doubleQuotes[i10] = 4;
            specicalFlags_singleQuotes[i10] = 4;
        }
        for (int i11 = 0; i11 < 161; i11++) {
            specicalFlags_doubleQuotesFlags[i11] = specicalFlags_doubleQuotes[i11] != 0;
            specicalFlags_singleQuotesFlags[i11] = specicalFlags_singleQuotes[i11] != 0;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i12 = 0; i12 < length; i12++) {
            IA[CA[i12]] = i12;
        }
        IA[61] = 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e9) {
            throw new JSONException("utf8 decode error, " + e9.getMessage(), e9);
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i9, int i10) {
        int i11;
        int i12;
        int i13 = 0;
        if (i10 == 0) {
            return new byte[0];
        }
        int i14 = (i9 + i10) - 1;
        int i15 = i9;
        while (i15 < i14 && IA[cArr[i15]] < 0) {
            i15++;
        }
        while (i14 > 0 && IA[cArr[i14]] < 0) {
            i14--;
        }
        if (cArr[i14] == '=') {
            i11 = cArr[i14 + (-1)] == '=' ? 2 : 1;
        } else {
            i11 = 0;
        }
        int i16 = (i14 - i15) + 1;
        if (i10 > 76) {
            i12 = (cArr[76] == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i11;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i15 + 4;
            int i22 = iArr[cArr[i15 + 3]] | (iArr[cArr[i15 + 1]] << 12) | (iArr[cArr[i15]] << 18) | (iArr[cArr[i15 + 2]] << 6);
            bArr[i19] = (byte) (i22 >> 16);
            int i23 = i19 + 2;
            bArr[i19 + 1] = (byte) (i22 >> 8);
            i19 += 3;
            bArr[i23] = (byte) i22;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i15 = i21;
            } else {
                i15 += 6;
                i20 = 0;
            }
        }
        if (i19 < i17) {
            int i24 = 0;
            while (i15 <= i14 - i11) {
                i13 |= IA[cArr[i15]] << (18 - (i24 * 6));
                i24++;
                i15++;
            }
            int i25 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i13 >> i25);
                i25 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    public static int decodeUTF8(byte[] bArr, int i9, int i10, char[] cArr) {
        int i11 = i9 + i10;
        int iMin = Math.min(i10, cArr.length);
        int i12 = 0;
        while (i12 < iMin) {
            byte b9 = bArr[i9];
            if (b9 < 0) {
                break;
            }
            i9++;
            cArr[i12] = (char) b9;
            i12++;
        }
        while (i9 < i11) {
            int i13 = i9 + 1;
            byte b10 = bArr[i9];
            if (b10 >= 0) {
                cArr[i12] = (char) b10;
                i12++;
                i9 = i13;
            } else {
                if ((b10 >> 5) != -2 || (b10 & 30) == 0) {
                    if ((b10 >> 4) == -2) {
                        int i14 = i9 + 2;
                        if (i14 < i11) {
                            byte b11 = bArr[i13];
                            i9 += 3;
                            byte b12 = bArr[i14];
                            if ((b10 != -32 || (b11 & 224) != 128) && (b11 & 192) == 128 && (b12 & 192) == 128) {
                                char c5 = (char) (((b11 << 6) ^ (b10 << 12)) ^ ((-123008) ^ b12));
                                if (c5 >= 55296 && c5 < 57344) {
                                    return -1;
                                }
                                cArr[i12] = c5;
                                i12++;
                            }
                        }
                        return -1;
                    }
                    if ((b10 >> 3) == -2 && i9 + 3 < i11) {
                        byte b13 = bArr[i13];
                        int i15 = i9 + 3;
                        byte b14 = bArr[i9 + 2];
                        i9 += 4;
                        byte b15 = bArr[i15];
                        int i16 = (((b10 << 18) ^ (b13 << 12)) ^ (b14 << 6)) ^ (3678080 ^ b15);
                        if ((b13 & 192) == 128 && (b14 & 192) == 128 && (b15 & 192) == 128 && i16 >= 65536 && i16 < 1114112) {
                            int i17 = i12 + 1;
                            cArr[i12] = (char) ((i16 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            i12 += 2;
                            cArr[i17] = (char) ((i16 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        }
                    }
                    return -1;
                }
                if (i13 >= i11) {
                    return -1;
                }
                i9 += 2;
                byte b16 = bArr[i13];
                if ((b16 & 192) != 128) {
                    return -1;
                }
                cArr[i12] = (char) ((b16 ^ (b10 << 6)) ^ Utf8.MASK_2BYTES);
                i12++;
            }
        }
        return i12;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [char, int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static int encodeUTF8(char[] cArr, int i9, int i10, byte[] bArr) {
        int i11;
        char c5;
        int i12 = i9 + i10;
        int iMin = Math.min(i10, bArr.length);
        int i13 = 0;
        while (i13 < iMin && (c5 = cArr[i9]) < 128) {
            i9++;
            bArr[i13] = (byte) c5;
            i13++;
        }
        while (i9 < i12) {
            int i14 = i9 + 1;
            char c9 = cArr[i9];
            if (c9 < 128) {
                i11 = i13 + 1;
                bArr[i13] = (byte) c9;
            } else {
                if (c9 < 2048) {
                    int i15 = i13 + 1;
                    bArr[i13] = (byte) ((c9 >> 6) | Opcodes.CHECKCAST);
                    i13 += 2;
                    bArr[i15] = (byte) ((c9 & 63) | 128);
                } else if (c9 < 55296 || c9 >= 57344) {
                    bArr[i13] = (byte) ((c9 >> 12) | 224);
                    int i16 = i13 + 2;
                    bArr[i13 + 1] = (byte) ((63 & (c9 >> 6)) | 128);
                    i13 += 3;
                    bArr[i16] = (byte) ((c9 & 63) | 128);
                } else if (c9 >= 55296 && c9 < 56320) {
                    if (i12 - i9 < 2) {
                        c9 = -1;
                    } else {
                        char c10 = cArr[i9 + 1];
                        if (c10 < 56320 || c10 >= 57344) {
                            i11 = i13 + 1;
                            bArr[i13] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            c9 = ((c9 << 10) + c10) - 56613888;
                        }
                    }
                    if (c9 < 0) {
                        i11 = i13 + 1;
                        bArr[i13] = Utf8.REPLACEMENT_BYTE;
                    } else {
                        bArr[i13] = (byte) ((c9 >> 18) | 240);
                        bArr[i13 + 1] = (byte) (((c9 >> 12) & 63) | 128);
                        bArr[i13 + 2] = (byte) ((63 & (c9 >> 6)) | 128);
                        bArr[i13 + 3] = (byte) ((c9 & 63) | 128);
                        i14 = i9 + 2;
                        i11 = i13 + 4;
                    }
                } else if (c9 >= 56320 && c9 < 57344) {
                    i11 = i13 + 1;
                    bArr[i13] = Utf8.REPLACEMENT_BYTE;
                } else if (c9 < 0) {
                    i11 = i13 + 1;
                    bArr[i13] = Utf8.REPLACEMENT_BYTE;
                } else {
                    bArr[i13] = (byte) ((c9 >> 18) | 240);
                    bArr[i13 + 1] = (byte) (((c9 >> 12) & 63) | 128);
                    bArr[i13 + 2] = (byte) ((63 & (c9 >> 6)) | 128);
                    bArr[i13 + 3] = (byte) ((c9 & 63) | 128);
                    i14 = i9 + 2;
                    i11 = i13 + 4;
                }
                i9 = i14;
            }
            i13 = i11;
            i9 = i14;
        }
        return i13;
    }

    public static boolean firstIdentifier(char c5) {
        boolean[] zArr = firstIdentifierFlags;
        return c5 < zArr.length && zArr[c5];
    }

    public static void getChars(long j, int i9, char[] cArr) {
        char c5;
        if (j < 0) {
            j = -j;
            c5 = '-';
        } else {
            c5 = 0;
        }
        while (j > 2147483647L) {
            long j8 = j / 100;
            int i10 = (int) (j - (((j8 << 6) + (j8 << 5)) + (j8 << 2)));
            cArr[i9 - 1] = DigitOnes[i10];
            i9 -= 2;
            cArr[i9] = DigitTens[i10];
            j = j8;
        }
        int i11 = (int) j;
        while (i11 >= 65536) {
            int i12 = i11 / 100;
            int i13 = i11 - (((i12 << 6) + (i12 << 5)) + (i12 << 2));
            cArr[i9 - 1] = DigitOnes[i13];
            i9 -= 2;
            cArr[i9] = DigitTens[i13];
            i11 = i12;
        }
        while (true) {
            int i14 = (52429 * i11) >>> 19;
            int i15 = i9 - 1;
            cArr[i15] = digits[i11 - ((i14 << 3) + (i14 << 1))];
            if (i14 == 0) {
                break;
            }
            i11 = i14;
            i9 = i15;
        }
        if (c5 != 0) {
            cArr[i9 - 2] = c5;
        }
    }

    public static String getStringProperty(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? DEFAULT_PROPERTIES.getProperty(str) : property;
    }

    public static boolean isIdent(char c5) {
        boolean[] zArr = identifierFlags;
        return c5 < zArr.length && zArr[c5];
    }

    public static boolean isValidJsonpQueryParam(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt != '.' && !isIdent(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader != null ? contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES) : ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[OpusCodecConfig.APPLICATION_VOIP];
            while (true) {
                int i9 = reader.read(cArr, 0, OpusCodecConfig.APPLICATION_VOIP);
                if (i9 < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i9);
            }
        } catch (Exception e9) {
            throw new JSONException("read string from reader error", e9);
        }
    }

    public static int stringSize(long j) {
        long j8 = 10;
        for (int i9 = 1; i9 < 19; i9++) {
            if (j < j8) {
                return i9;
            }
            j8 *= 10;
        }
        return 19;
    }

    public static int stringSize(int i9) {
        int i10 = 0;
        while (i9 > sizeTable[i10]) {
            i10++;
        }
        return i10 + 1;
    }

    public static void getChars(int i9, int i10, char[] cArr) {
        char c5;
        if (i9 < 0) {
            i9 = -i9;
            c5 = '-';
        } else {
            c5 = 0;
        }
        while (i9 >= 65536) {
            int i11 = i9 / 100;
            int i12 = i9 - (((i11 << 6) + (i11 << 5)) + (i11 << 2));
            cArr[i10 - 1] = DigitOnes[i12];
            i10 -= 2;
            cArr[i10] = DigitTens[i12];
            i9 = i11;
        }
        while (true) {
            int i13 = (52429 * i9) >>> 19;
            int i14 = i10 - 1;
            cArr[i14] = digits[i9 - ((i13 << 3) + (i13 << 1))];
            if (i13 == 0) {
                break;
            }
            i9 = i13;
            i10 = i14;
        }
        if (c5 != 0) {
            cArr[i10 - 2] = c5;
        }
    }

    public static byte[] decodeBase64(String str, int i9, int i10) {
        int i11;
        int i12;
        if (i10 == 0) {
            return new byte[0];
        }
        int i13 = (i9 + i10) - 1;
        int i14 = i9;
        while (i14 < i13 && IA[str.charAt(i14)] < 0) {
            i14++;
        }
        while (i13 > 0 && IA[str.charAt(i13)] < 0) {
            i13--;
        }
        if (str.charAt(i13) == '=') {
            i11 = str.charAt(i13 + (-1)) == '=' ? 2 : 1;
        } else {
            i11 = 0;
        }
        int i15 = (i13 - i14) + 1;
        if (i10 > 76) {
            i12 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i16 = (((i15 - i12) * 6) >> 3) - i11;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = IA;
            int i20 = i14 + 4;
            int i21 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i18] = (byte) (i21 >> 16);
            int i22 = i18 + 2;
            bArr[i18 + 1] = (byte) (i21 >> 8);
            i18 += 3;
            bArr[i22] = (byte) i21;
            if (i12 <= 0 || (i19 = i19 + 1) != 19) {
                i14 = i20;
            } else {
                i14 += 6;
                i19 = 0;
            }
        }
        if (i18 < i16) {
            int i23 = 0;
            int i24 = 0;
            while (i14 <= i13 - i11) {
                i23 |= IA[str.charAt(i14)] << (18 - (i24 * 6));
                i24++;
                i14++;
            }
            int i25 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i23 >> i25);
                i25 -= 8;
                i18++;
            }
        }
        return bArr;
    }

    public static void getChars(byte b9, int i9, char[] cArr) {
        char c5;
        int i10;
        if (b9 < 0) {
            c5 = '-';
            i10 = -b9;
        } else {
            c5 = 0;
            i10 = b9;
        }
        while (true) {
            int i11 = (52429 * i10) >>> 19;
            int i12 = i9 - 1;
            cArr[i12] = digits[i10 - ((i11 << 3) + (i11 << 1))];
            if (i11 == 0) {
                break;
            }
            i10 = i11;
            i9 = i12;
        }
        if (c5 != 0) {
            cArr[i9 - 2] = c5;
        }
    }

    public static byte[] decodeBase64(String str) {
        int i9;
        int i10;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i11 = length - 1;
        int i12 = 0;
        while (i12 < i11 && IA[str.charAt(i12) & 255] < 0) {
            i12++;
        }
        while (i11 > 0 && IA[str.charAt(i11) & 255] < 0) {
            i11--;
        }
        if (str.charAt(i11) == '=') {
            i9 = str.charAt(i11 + (-1)) == '=' ? 2 : 1;
        } else {
            i9 = 0;
        }
        int i13 = (i11 - i12) + 1;
        if (length > 76) {
            i10 = (str.charAt(76) == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i9;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = IA;
            int i18 = i12 + 4;
            int i19 = iArr[str.charAt(i12 + 3)] | (iArr[str.charAt(i12 + 1)] << 12) | (iArr[str.charAt(i12)] << 18) | (iArr[str.charAt(i12 + 2)] << 6);
            bArr[i16] = (byte) (i19 >> 16);
            int i20 = i16 + 2;
            bArr[i16 + 1] = (byte) (i19 >> 8);
            i16 += 3;
            bArr[i20] = (byte) i19;
            if (i10 <= 0 || (i17 = i17 + 1) != 19) {
                i12 = i18;
            } else {
                i12 += 6;
                i17 = 0;
            }
        }
        if (i16 < i14) {
            int i21 = 0;
            int i22 = 0;
            while (i12 <= i11 - i9) {
                i21 |= IA[str.charAt(i12)] << (18 - (i22 * 6));
                i22++;
                i12++;
            }
            int i23 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i21 >> i23);
                i23 -= 8;
                i16++;
            }
        }
        return bArr;
    }
}
