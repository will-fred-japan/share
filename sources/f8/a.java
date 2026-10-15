package f8;

import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f18716b = {13, 10};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f18717c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18718a;

    public a() {
        byte[] bArr = f18716b;
        for (int i9 = 0; i9 < 2; i9++) {
            byte b9 = bArr[i9];
            if (61 != b9) {
                if (b9 >= 0) {
                    byte[] bArr2 = f18717c;
                    if (b9 >= 123 || bArr2[b9] == -1) {
                    }
                }
            }
            throw new IllegalArgumentException(A.a.i("lineSeparator must not contain base64 characters: [", new String(bArr, e8.a.f18640a), "]"));
        }
        this.f18718a = 3;
    }

    public final void b(byte[] bArr, int i9, b.a aVar) {
        int i10;
        byte b9;
        if (aVar.f18723e) {
            return;
        }
        if (i9 < 0) {
            aVar.f18723e = true;
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f18718a;
            if (i11 >= i9) {
                break;
            }
            byte[] bArrA = b.a(i10, aVar);
            int i13 = i12 + 1;
            byte b10 = bArr[i12];
            if (b10 == 61) {
                aVar.f18723e = true;
                break;
            }
            if (b10 >= 0) {
                byte[] bArr2 = f18717c;
                if (b10 < 123 && (b9 = bArr2[b10]) >= 0) {
                    int i14 = (aVar.f18724f + 1) % 4;
                    aVar.f18724f = i14;
                    int i15 = (aVar.f18719a << 6) + b9;
                    aVar.f18719a = i15;
                    if (i14 == 0) {
                        int i16 = aVar.f18721c;
                        bArrA[i16] = (byte) ((i15 >> 16) & 255);
                        bArrA[i16 + 1] = (byte) ((i15 >> 8) & 255);
                        aVar.f18721c = i16 + 3;
                        bArrA[i16 + 2] = (byte) (i15 & 255);
                    }
                }
            }
            i11++;
            i12 = i13;
        }
        if (!aVar.f18723e || aVar.f18724f == 0) {
            return;
        }
        byte[] bArrA2 = b.a(i10, aVar);
        int i17 = aVar.f18724f;
        if (i17 != 1) {
            if (i17 == 2) {
                int i18 = aVar.f18719a >> 4;
                aVar.f18719a = i18;
                int i19 = aVar.f18721c;
                aVar.f18721c = i19 + 1;
                bArrA2[i19] = (byte) (i18 & 255);
                return;
            }
            if (i17 != 3) {
                throw new IllegalStateException("Impossible modulus " + aVar.f18724f);
            }
            int i20 = aVar.f18719a;
            int i21 = i20 >> 2;
            aVar.f18719a = i21;
            int i22 = aVar.f18721c;
            bArrA2[i22] = (byte) ((i20 >> 10) & 255);
            aVar.f18721c = i22 + 2;
            bArrA2[i22 + 1] = (byte) (i21 & 255);
        }
    }
}
