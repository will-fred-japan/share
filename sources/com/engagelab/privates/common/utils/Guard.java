package com.engagelab.privates.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Guard {
    public static byte[] guard(byte[] bArr) {
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

    public static String string(byte[] bArr) {
        return new String(guard(bArr));
    }

    public static String test(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrGuard = guard(str.getBytes());
            String string = Arrays.toString(bArrGuard);
            Log.e("xxx", "guard=" + string);
            String str2 = "public static final String " + str.toUpperCase() + " =Guard.string(new byte[]" + string.replace("[", "{").replace("]", "});") + "//" + str;
            Log.e("xxx", str2);
            Log.e("xxx", "reverse=".concat(new String(guard(bArrGuard))));
            return str2;
        } catch (Throwable th) {
            Log.e("xxx", "e:" + th);
            return "";
        }
    }
}
