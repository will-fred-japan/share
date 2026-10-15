package okio.internal;

import R7.i;
import com.alibaba.fastjson.asm.Opcodes;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import okio.Utf8;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i9;
        char cCharAt;
        k.e(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char cCharAt2 = str.charAt(i10);
            if (k.f(cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i11 = i10;
                while (i10 < length2) {
                    char cCharAt3 = str.charAt(i10);
                    if (k.f(cCharAt3, 128) < 0) {
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) cCharAt3;
                        i10++;
                        while (true) {
                            i11 = i12;
                            if (i10 >= length2 || k.f(str.charAt(i10), 128) >= 0) {
                                break;
                            }
                            i12 = i11 + 1;
                            bArr[i11] = (byte) str.charAt(i10);
                            i10++;
                        }
                    } else {
                        if (k.f(cCharAt3, OpusCodecConfig.APPLICATION_VOIP) < 0) {
                            bArr[i11] = (byte) ((cCharAt3 >> 6) | Opcodes.CHECKCAST);
                            i11 += 2;
                            bArr[i11 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i11] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i11 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i11 += 3;
                            bArr[i11 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (k.f(cCharAt3, 56319) > 0 || length2 <= (i9 = i10 + 1) || 56320 > (cCharAt = str.charAt(i9)) || cCharAt >= 57344) {
                            bArr[i11] = Utf8.REPLACEMENT_BYTE;
                            i10++;
                            i11++;
                        } else {
                            int iCharAt = (str.charAt(i9) + (cCharAt3 << '\n')) - 56613888;
                            bArr[i11] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i11 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i11 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i11 += 4;
                            bArr[i11 + 3] = (byte) ((iCharAt & 63) | 128);
                            i10 += 2;
                        }
                        i10++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
                k.d(bArrCopyOf, "copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i10] = (byte) cCharAt2;
            i10++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        k.d(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static final String commonToUtf8String(byte[] bArr, int i9, int i10) {
        byte b9;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i9;
        int i17 = 2;
        k.e(bArr, "<this>");
        if (i16 < 0 || i10 > bArr.length || i16 > i10) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i16 + " endIndex=" + i10);
        }
        char[] cArr = new char[i10 - i16];
        int i18 = 0;
        while (i16 < i10) {
            byte b10 = bArr[i16];
            if (b10 >= 0) {
                int i19 = i18 + 1;
                cArr[i18] = (char) b10;
                i16++;
                while (true) {
                    i18 = i19;
                    if (i16 >= i10 || (b9 = bArr[i16]) < 0) {
                        break;
                    }
                    i16++;
                    i19 = i18 + 1;
                    cArr[i18] = (char) b9;
                }
            } else if ((b10 >> 5) == -2) {
                int i20 = i16 + 1;
                if (i10 <= i20) {
                    i11 = i18 + 1;
                    cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b11 = bArr[i20];
                    if ((b11 & 192) == 128) {
                        int i21 = (b10 << 6) ^ (b11 ^ 3968);
                        if (i21 < 128) {
                            i11 = i18 + 1;
                            cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i11 = i18 + 1;
                            cArr[i18] = (char) i21;
                        }
                        p188x7.k kVar = p188x7.k.f22364a;
                        i12 = i17;
                    } else {
                        i11 = i18 + 1;
                        cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                    i18 = i11;
                    i16 += i12;
                }
                p188x7.k kVar2 = p188x7.k.f22364a;
                i12 = 1;
                i18 = i11;
                i16 += i12;
            } else if ((b10 >> 4) == -2) {
                int i22 = i16 + 2;
                if (i10 <= i22) {
                    int i23 = i18 + 1;
                    cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    p188x7.k kVar3 = p188x7.k.f22364a;
                    int i24 = i16 + 1;
                    i14 = (i10 <= i24 || (bArr[i24] & 192) != 128) ? 1 : i17;
                    i18 = i23;
                } else {
                    byte b12 = bArr[i16 + 1];
                    if ((b12 & 192) == 128) {
                        byte b13 = bArr[i22];
                        if ((b13 & 192) == 128) {
                            int i25 = ((b13 ^ (-123008)) ^ (b12 << 6)) ^ (b10 << 12);
                            if (i25 < 2048) {
                                i15 = i18 + 1;
                                cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 > i25 || i25 >= 57344) {
                                char c5 = (char) i25;
                                i15 = i18 + 1;
                                cArr[i18] = c5;
                            } else {
                                i15 = i18 + 1;
                                cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            }
                            p188x7.k kVar4 = p188x7.k.f22364a;
                            i18 = i15;
                            i14 = 3;
                        } else {
                            cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            p188x7.k kVar5 = p188x7.k.f22364a;
                            i18++;
                            i14 = i17;
                        }
                    } else {
                        cArr[i18] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        p188x7.k kVar6 = p188x7.k.f22364a;
                        i18++;
                        i14 = 1;
                    }
                }
                i16 += i14;
            } else if ((b10 >> 3) == -2) {
                int i26 = i16 + 3;
                if (i10 <= i26) {
                    int i27 = i18 + 1;
                    cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                    p188x7.k kVar7 = p188x7.k.f22364a;
                    int i28 = i16 + 1;
                    if (i10 <= i28 || (bArr[i28] & 192) != 128) {
                        i18 = i27;
                        i17 = 1;
                    } else {
                        int i29 = i16 + 2;
                        if (i10 <= i29 || (bArr[i29] & 192) != 128) {
                            i18 = i27;
                            i17 = i17;
                        } else {
                            i18 = i27;
                            i17 = i17;
                            i17 = 3;
                        }
                    }
                } else {
                    byte b14 = bArr[i16 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = bArr[i16 + 2];
                        i17 = i17;
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i26];
                            if ((b16 & 192) == 128) {
                                int i30 = (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b10 << 18);
                                if (i30 > 1114111) {
                                    i13 = i18 + 1;
                                    cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                                } else if ((55296 > i30 || i30 >= 57344) && i30 >= 65536 && i30 != 65533) {
                                    cArr[i18] = (char) ((i30 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                    cArr[i18 + 1] = (char) ((i30 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                    i13 = i18 + 2;
                                } else {
                                    i13 = i18 + 1;
                                    cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                                }
                                p188x7.k kVar8 = p188x7.k.f22364a;
                                i18 = i13;
                                i17 = 4;
                            } else {
                                cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                                p188x7.k kVar9 = p188x7.k.f22364a;
                                i18++;
                                i17 = 3;
                            }
                        } else {
                            cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                            p188x7.k kVar10 = p188x7.k.f22364a;
                            i18++;
                            i17 = i17;
                        }
                    } else {
                        cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                        p188x7.k kVar11 = p188x7.k.f22364a;
                        i18++;
                        i17 = 1;
                    }
                }
                i16 += i17;
                i17 = i17;
            } else {
                cArr[i18] = Utf8.REPLACEMENT_CHARACTER;
                i16++;
                i18++;
            }
        }
        return i.F(cArr, 0, i18);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i9 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = bArr.length;
        }
        return commonToUtf8String(bArr, i9, i10);
    }
}
