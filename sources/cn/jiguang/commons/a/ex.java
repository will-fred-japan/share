package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.starburst.sdk.core.tts.EventType;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public final class ex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10009a = jr.a(new byte[]{96, 89, 98, 99, 101, 89, 76, 106, 38, 96, 116, 66, 83, 112, 103, 120, Utf8.REPLACEMENT_BYTE, 67, 84, 120, 122, 98, 81, 112});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10010b = jr.a(new byte[]{81, 112, 74, 108, 124, 127, 125, 67, 14, 111, 109, EventType.ERROR, 98, 89, 79, 119, 38, 115, 127, 84, 96, 89});

    private static int a(byte[] bArr, byte[] bArr2, int i9) {
        if (bArr != null && bArr2 != null) {
            try {
                if (bArr2.length == 0) {
                    return i9;
                }
                if (i9 < 0 || bArr.length < bArr2.length) {
                    return -1;
                }
                while (i9 <= bArr.length - bArr2.length) {
                    for (int i10 = 0; i10 < bArr2.length; i10++) {
                        if (bArr[i9 + i10] != bArr2[i10]) {
                            i9++;
                        }
                    }
                    return i9;
                }
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return a(bArr, f10009a.getBytes("UTF-8"), f10010b.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int iA;
        int length;
        int length2;
        try {
            int iA2 = a(bArr, bArr2, 0);
            if (iA2 == -1 || (iA = a(bArr, bArr3, bArr2.length + iA2)) == -1 || (length2 = iA - (length = iA2 + bArr2.length)) < 0) {
                return null;
            }
            if (length2 == 0) {
                return "";
            }
            if (length + length2 > bArr.length) {
                return null;
            }
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr, length, bArr4, 0, length2);
            String str = new String(bArr4, "UTF-8");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.trim();
        } catch (Throwable unused) {
            return null;
        }
    }
}
