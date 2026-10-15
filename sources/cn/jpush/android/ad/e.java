package cn.jpush.android.ad;

import com.jieli.jl_bt_ota.constant.AttrAndFunCode;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i9 = 0; i9 < bArr.length; i9++) {
                bArr3[i9] = (byte) (bArr[i9] ^ bArr2[(bArr.length + i9) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }
}
