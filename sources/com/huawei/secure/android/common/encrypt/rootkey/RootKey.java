package com.huawei.secure.android.common.encrypt.rootkey;

import com.huawei.secure.android.common.encrypt.exception.RootKeyGenException;
import com.huawei.secure.android.common.encrypt.exception.RootKeyParamException;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;

/* JADX INFO: loaded from: classes.dex */
public class RootKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15761a = "RootKey";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15762b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f15763c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f15764d = 32;

    private static int a(int i9, int i10, int i11) {
        if (i10 < i9) {
            i9 = i10;
        }
        return i11 < i9 ? i11 : i9;
    }

    private static boolean b(int i9) {
        return i9 >= 16;
    }

    public static byte[] exportRootKey(RootKeyConfig rootKeyConfig) throws RootKeyGenException, RootKeyParamException {
        byte[] bArrPbkdfBottom;
        a(rootKeyConfig);
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(rootKeyConfig.getFirst());
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(rootKeyConfig.getSecond());
        byte[] bArrHexStr2ByteArray3 = HexUtil.hexStr2ByteArray(rootKeyConfig.getThird());
        int iA = a(bArrHexStr2ByteArray.length, bArrHexStr2ByteArray2.length, bArrHexStr2ByteArray3.length);
        if (!a(iA, rootKeyConfig.getSalt())) {
            throw new RootKeyParamException("key length must be more than 128bit.");
        }
        char[] cArr = new char[iA];
        for (int i9 = 0; i9 < iA; i9++) {
            cArr[i9] = (char) ((bArrHexStr2ByteArray[i9] ^ bArrHexStr2ByteArray2[i9]) ^ bArrHexStr2ByteArray3[i9]);
        }
        if (rootKeyConfig.isSha256()) {
            b.c(f15761a, "exportRootKey: sha256");
            bArrPbkdfBottom = PBKDF2.pbkdfBottom(cArr, rootKeyConfig.getSalt(), rootKeyConfig.getIteration(), rootKeyConfig.getExportLen() * 8, true);
        } else {
            b.c(f15761a, "exportRootKey: sha1");
            bArrPbkdfBottom = PBKDF2.pbkdfBottom(cArr, rootKeyConfig.getSalt(), rootKeyConfig.getIteration(), rootKeyConfig.getExportLen() * 8, false);
        }
        if (bArrPbkdfBottom == null || bArrPbkdfBottom.length == 0) {
            throw new RootKeyGenException("Failed to generate the rootkey.");
        }
        return bArrPbkdfBottom;
    }

    private static boolean a(int i9) {
        return i9 >= 16;
    }

    private static void a(RootKeyConfig rootKeyConfig) throws RootKeyParamException {
        if (rootKeyConfig != null) {
            if (a(rootKeyConfig.getExportLen())) {
                if (rootKeyConfig.getExportLen() < 32) {
                    b.e(f15761a, "It is recommended that the exported length be greater than or equal to 256 bits.");
                }
                if (a(rootKeyConfig.getExportLen(), rootKeyConfig.getFirst())) {
                    if (a(rootKeyConfig.getExportLen(), rootKeyConfig.getSecond())) {
                        if (a(rootKeyConfig.getExportLen(), rootKeyConfig.getThird())) {
                            return;
                        }
                        b.b(f15761a, "material(third) length must be Greater than or equal to export length.");
                        throw new RootKeyParamException("material(third) length must be Greater than or equal to export length.");
                    }
                    b.b(f15761a, "material(second) length must be Greater than or equal to export length.");
                    throw new RootKeyParamException("material(second) length must be Greater than or equal to export length.");
                }
                b.b(f15761a, "material(first) length must be Greater than or equal to export length.");
                throw new RootKeyParamException("material(first) length must be Greater than or equal to export length.");
            }
            b.b(f15761a, "exportLen length must be more than 128bit.");
            throw new RootKeyParamException("exportLen length must be more than 128bit.");
        }
        b.b(f15761a, "rootKeyConfig is null.");
        throw new RootKeyParamException("rootKeyConfig is null.");
    }

    private static boolean a(int i9, byte[] bArr) {
        return b(i9) & a(bArr);
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    private static boolean a(int i9, String str) {
        return str != null && str.length() >= i9;
    }
}
