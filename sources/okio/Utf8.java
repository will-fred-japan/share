package okio;

import K7.l;
import W5.e;
import androidx.datastore.preferences.protobuf.C0524s;
import com.alibaba.fastjson.asm.Opcodes;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import p188x7.k;

/* JADX INFO: compiled from: Utf8.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i9) {
        if (i9 < 0 || i9 >= 32) {
            return 127 <= i9 && i9 < 160;
        }
        return true;
    }

    public static final boolean isUtf8Continuation(byte b9) {
        return (b9 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i9, int i10, l<? super Integer, k> yield) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        int i11 = i9 + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b9 = bArr[i9];
        byte b10 = bArr[i11];
        if ((b10 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        int i12 = (b10 ^ 3968) ^ (b9 << 6);
        if (i12 < 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        yield.invoke(Integer.valueOf(i12));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i9, int i10, l<? super Integer, k> yield) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        int i11 = i9 + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            yield.invoke(numValueOf);
            int i12 = i9 + 1;
            return (i10 <= i12 || (bArr[i12] & 192) != 128) ? 1 : 2;
        }
        byte b9 = bArr[i9];
        byte b10 = bArr[i9 + 1];
        if ((b10 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b11 = bArr[i11];
        if ((b11 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        int i13 = ((b11 ^ (-123008)) ^ (b10 << 6)) ^ (b9 << 12);
        if (i13 < 2048) {
            yield.invoke(numValueOf);
            return 3;
        }
        if (55296 > i13 || i13 >= 57344) {
            yield.invoke(Integer.valueOf(i13));
            return 3;
        }
        yield.invoke(numValueOf);
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i9, int i10, l<? super Integer, k> yield) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        int i11 = i9 + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            yield.invoke(numValueOf);
            int i12 = i9 + 1;
            if (i10 <= i12 || (bArr[i12] & 192) != 128) {
                return 1;
            }
            int i13 = i9 + 2;
            return (i10 <= i13 || (bArr[i13] & 192) != 128) ? 2 : 3;
        }
        byte b9 = bArr[i9];
        byte b10 = bArr[i9 + 1];
        if ((b10 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b11 = bArr[i9 + 2];
        if ((b11 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        byte b12 = bArr[i11];
        if ((b12 & 192) != 128) {
            yield.invoke(numValueOf);
            return 3;
        }
        int i14 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b9 << 18);
        if (i14 > 1114111) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i14 && i14 < 57344) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (i14 < 65536) {
            yield.invoke(numValueOf);
            return 4;
        }
        yield.invoke(Integer.valueOf(i14));
        return 4;
    }

    public static final void processUtf16Chars(byte[] bArr, int i9, int i10, l<? super Character, k> yield) {
        int i11;
        int i12;
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        int i13 = i9;
        while (i13 < i10) {
            byte b9 = bArr[i13];
            if (b9 >= 0) {
                yield.invoke(Character.valueOf((char) b9));
                i13++;
                while (i13 < i10) {
                    byte b10 = bArr[i13];
                    if (b10 < 0) {
                        break;
                    }
                    i13++;
                    yield.invoke(Character.valueOf((char) b10));
                }
            } else if ((b9 >> 5) == -2) {
                int i14 = i13 + 1;
                if (i10 > i14) {
                    byte b11 = bArr[i14];
                    if ((b11 & 192) == 128) {
                        int i15 = (b9 << 6) ^ (b11 ^ 3968);
                        yield.invoke(Character.valueOf(i15 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i15));
                        k kVar = k.f22364a;
                        i13 += i11;
                    }
                }
                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                k kVar2 = k.f22364a;
                i13 += i11;
            } else if ((b9 >> 4) == -2) {
                int i16 = i13 + 2;
                if (i10 <= i16) {
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    k kVar3 = k.f22364a;
                    int i17 = i13 + 1;
                    i11 = (i10 <= i17 || (bArr[i17] & 192) != 128) ? 1 : 2;
                } else {
                    byte b12 = bArr[i13 + 1];
                    if ((b12 & 192) == 128) {
                        byte b13 = bArr[i16];
                        if ((b13 & 192) == 128) {
                            int i18 = (b9 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                            yield.invoke(Character.valueOf((i18 >= 2048 && (55296 > i18 || i18 >= 57344)) ? (char) i18 : (char) REPLACEMENT_CODE_POINT));
                            k kVar4 = k.f22364a;
                            i11 = 3;
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            k kVar5 = k.f22364a;
                        }
                    } else {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        k kVar6 = k.f22364a;
                    }
                }
                i13 += i11;
            } else if ((b9 >> 3) == -2) {
                int i19 = i13 + 3;
                if (i10 <= i19) {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    k kVar7 = k.f22364a;
                    int i20 = i13 + 1;
                    if (i10 <= i20 || (bArr[i20] & 192) != 128) {
                        i12 = 1;
                    } else {
                        int i21 = i13 + 2;
                        i12 = (i10 <= i21 || (bArr[i21] & 192) != 128) ? 2 : 3;
                    }
                } else {
                    byte b14 = bArr[i13 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = bArr[i13 + 2];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i19];
                            if ((b16 & 192) == 128) {
                                int i22 = (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b9 << 18);
                                if (i22 <= 1114111 && ((55296 > i22 || i22 >= 57344) && i22 >= 65536 && i22 != 65533)) {
                                    yield.invoke(Character.valueOf((char) ((i22 >>> 10) + HIGH_SURROGATE_HEADER)));
                                    yield.invoke(Character.valueOf((char) ((i22 & 1023) + LOG_SURROGATE_HEADER)));
                                } else {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                }
                                k kVar8 = k.f22364a;
                                i12 = 4;
                            } else {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                k kVar9 = k.f22364a;
                            }
                        } else {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            k kVar10 = k.f22364a;
                        }
                    } else {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        k kVar11 = k.f22364a;
                        i12 = 1;
                    }
                }
                i13 += i12;
            } else {
                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                i13++;
            }
        }
    }

    public static final void processUtf8Bytes(String str, int i9, int i10, l<? super Byte, k> yield) {
        int i11;
        char cCharAt;
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        while (i9 < i10) {
            char cCharAt2 = str.charAt(i9);
            if (kotlin.jvm.internal.k.f(cCharAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) cCharAt2));
                i9++;
                while (i9 < i10 && kotlin.jvm.internal.k.f(str.charAt(i9), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i9)));
                    i9++;
                }
            } else {
                if (kotlin.jvm.internal.k.f(cCharAt2, OpusCodecConfig.APPLICATION_VOIP) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || cCharAt2 >= 57344) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (kotlin.jvm.internal.k.f(cCharAt2, 56319) > 0 || i10 <= (i11 = i9 + 1) || 56320 > (cCharAt = str.charAt(i11)) || cCharAt >= 57344) {
                    yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = (str.charAt(i11) + (cCharAt2 << '\n')) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i9 += 2;
                }
                i9++;
            }
        }
    }

    public static final void processUtf8CodePoints(byte[] bArr, int i9, int i10, l<? super Integer, k> yield) {
        int i11;
        int i12;
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(yield, "yield");
        int i13 = i9;
        while (i13 < i10) {
            byte b9 = bArr[i13];
            if (b9 >= 0) {
                yield.invoke(Integer.valueOf(b9));
                i13++;
                while (i13 < i10) {
                    byte b10 = bArr[i13];
                    if (b10 < 0) {
                        break;
                    }
                    i13++;
                    yield.invoke(Integer.valueOf(b10));
                }
            } else if ((b9 >> 5) == -2) {
                int i14 = i13 + 1;
                if (i10 > i14) {
                    byte b11 = bArr[i14];
                    if ((b11 & 192) == 128) {
                        int i15 = (b9 << 6) ^ (b11 ^ 3968);
                        yield.invoke(i15 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i15));
                        k kVar = k.f22364a;
                        i13 += i11;
                    }
                }
                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                k kVar2 = k.f22364a;
                i13 += i11;
            } else if ((b9 >> 4) == -2) {
                int i16 = i13 + 2;
                if (i10 <= i16) {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    k kVar3 = k.f22364a;
                    int i17 = i13 + 1;
                    i11 = (i10 <= i17 || (bArr[i17] & 192) != 128) ? 1 : 2;
                } else {
                    byte b12 = bArr[i13 + 1];
                    if ((b12 & 192) == 128) {
                        byte b13 = bArr[i16];
                        if ((b13 & 192) == 128) {
                            int i18 = (b9 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                            yield.invoke((i18 >= 2048 && (55296 > i18 || i18 >= 57344)) ? Integer.valueOf(i18) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                            k kVar4 = k.f22364a;
                            i11 = 3;
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            k kVar5 = k.f22364a;
                        }
                    } else {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        k kVar6 = k.f22364a;
                    }
                }
                i13 += i11;
            } else if ((b9 >> 3) == -2) {
                int i19 = i13 + 3;
                if (i10 <= i19) {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    k kVar7 = k.f22364a;
                    int i20 = i13 + 1;
                    if (i10 <= i20 || (bArr[i20] & 192) != 128) {
                        i12 = 1;
                    } else {
                        int i21 = i13 + 2;
                        i12 = (i10 <= i21 || (bArr[i21] & 192) != 128) ? 2 : 3;
                    }
                } else {
                    byte b14 = bArr[i13 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = bArr[i13 + 2];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i19];
                            if ((b16 & 192) == 128) {
                                int i22 = (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b9 << 18);
                                yield.invoke((i22 <= 1114111 && (55296 > i22 || i22 >= 57344) && i22 >= 65536) ? Integer.valueOf(i22) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                k kVar8 = k.f22364a;
                                i12 = 4;
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                k kVar9 = k.f22364a;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            k kVar10 = k.f22364a;
                        }
                    } else {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        k kVar11 = k.f22364a;
                        i12 = 1;
                    }
                }
                i13 += i12;
            } else {
                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                i13++;
            }
        }
    }

    public static final long size(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i9 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return size(str, i9, i10);
    }

    public static final long size(String str, int i9) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return size$default(str, i9, 0, 2, null);
    }

    public static final long size(String str, int i9, int i10) {
        int i11;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i9 < 0) {
            throw new IllegalArgumentException(e.i(i9, "beginIndex < 0: ").toString());
        }
        if (i10 >= i9) {
            if (i10 > str.length()) {
                StringBuilder sbA = C0524s.a(i10, "endIndex > string.length: ", " > ");
                sbA.append(str.length());
                throw new IllegalArgumentException(sbA.toString().toString());
            }
            long j = 0;
            while (i9 < i10) {
                char cCharAt = str.charAt(i9);
                if (cCharAt < 128) {
                    j++;
                } else {
                    if (cCharAt < 2048) {
                        i11 = 2;
                    } else if (cCharAt < 55296 || cCharAt > 57343) {
                        i11 = 3;
                    } else {
                        int i12 = i9 + 1;
                        char cCharAt2 = i12 < i10 ? str.charAt(i12) : (char) 0;
                        if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                            j++;
                            i9 = i12;
                        } else {
                            j += (long) 4;
                            i9 += 2;
                        }
                    }
                    j += (long) i11;
                }
                i9++;
            }
            return j;
        }
        throw new IllegalArgumentException(e.h(i10, i9, "endIndex < beginIndex: ", " < ").toString());
    }
}
