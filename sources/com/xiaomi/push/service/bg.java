package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.jieli.jl_bt_ota.constant.JL_Constant;
import com.starburst.sdk.core.tts.EventType;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static RSAPublicKey f18334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f1078a;

    static {
        byte[] bArr = {48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, 16, 70, -90, 113, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, 49, 13, 16, 50, -27, -82, 18, -28, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, 49, 28, 117, -74, 114, -122, -29, -84, 82, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, -122, 42, -40, -79, 18, -116, -42, 101, JL_Constant.PREFIX_FLAG_THIRD, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, JL_Constant.PREFIX_FLAG_SECOND, -60, -81, 67, -114, 10, 79, EventType.ERROR, 29, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        f1078a = bArr;
        try {
            f18334a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable unused) {
            com.xiaomi.channel.commonutils.logger.c.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, f18334a);
            return Base64.encodeToString(a(cipher, 1, str.getBytes("UTF-8"), f18334a.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(Cipher cipher, int i9, byte[] bArr, int i10) {
        int i11;
        byte[] bArrDoFinal;
        if (cipher == null || bArr == null) {
            return null;
        }
        if (i9 == 2) {
            i11 = i10 / 8;
        } else {
            i11 = (i10 / 8) - 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i12 = 0;
            int i13 = 0;
            while (bArr.length > i12) {
                if (bArr.length - i12 > i11) {
                    bArrDoFinal = cipher.doFinal(bArr, i12, i11);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i12, bArr.length - i12);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i13++;
                i12 = i13 * i11;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new RuntimeException(e9);
        }
    }
}
