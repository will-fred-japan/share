package com.starburst.sdk.utils;

import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static byte[] a(String str) {
        j.e("decode data ==> " + str);
        String strReplaceAll = str.replaceAll("[\\t\\n\\r]", "");
        j.e("decode result ====> " + strReplaceAll);
        f8.a aVar = new f8.a();
        byte[] bytes = strReplaceAll == null ? null : strReplaceAll.getBytes(e8.a.f18640a);
        if (bytes == null || bytes.length == 0) {
            return bytes;
        }
        f8.b.a aVar2 = new f8.b.a();
        aVar.b(bytes, bytes.length, aVar2);
        aVar.b(bytes, -1, aVar2);
        int i9 = aVar2.f18721c;
        byte[] bArr = new byte[i9];
        if (aVar2.f18720b != null) {
            int iMin = Math.min(i9 - aVar2.f18722d, i9);
            System.arraycopy(aVar2.f18720b, aVar2.f18722d, bArr, 0, iMin);
            int i10 = aVar2.f18722d + iMin;
            aVar2.f18722d = i10;
            if (i10 >= aVar2.f18721c) {
                aVar2.f18720b = null;
            }
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        return Base64.getEncoder().encodeToString(bArr);
    }
}
