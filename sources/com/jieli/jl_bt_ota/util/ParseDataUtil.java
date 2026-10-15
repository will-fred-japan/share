package com.jieli.jl_bt_ota.util;

import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ParseDataUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16343a = "ParseDataUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f16344b = "0123456789ABCDEF".toCharArray();

    static {
        System.loadLibrary(BluetoothConstant.JL_AUTH);
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr2[i9] = bArr[(bArr.length - i9) - 1];
        }
        return bArr2;
    }

    public static int filterFile(byte[] bArr, int i9, int i10) {
        return nativeFilterFile(bArr, i9, i10, 0);
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i9 = 0; i9 < bArr.length; i9++) {
                char[] cArr = f16344b;
                sb.append(cArr[(bArr[i9] & 255) >> 4]);
                sb.append(cArr[bArr[i9] & 15]);
                if (i9 != bArr.length - 1) {
                    sb.append(Constants.COLON_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }

    private static native int nativeFilterFile(byte[] bArr, int i9, int i10, int i11);

    public static BleScanMessage parseOTAFlagFilterWithBroad(byte[] bArr, String str) {
        BleScanMessage withOTAFlagFilter = null;
        if (bArr != null && bArr.length > 2) {
            int i9 = 0;
            while (true) {
                int i10 = i9 + 2;
                if (i10 <= bArr.length) {
                    int iByteToInt = CHexConver.byteToInt(bArr[i9]);
                    if (iByteToInt != 0) {
                        if (iByteToInt < 1) {
                            break;
                        }
                        int i11 = i9 + 1;
                        if (i11 + iByteToInt >= bArr.length) {
                            break;
                        }
                        if (CHexConver.byteToInt(bArr[i11]) == 255) {
                            int i12 = iByteToInt - 1;
                            byte[] bArr2 = new byte[i12];
                            System.arraycopy(bArr, i10, bArr2, 0, i12);
                            withOTAFlagFilter = parseWithOTAFlagFilter(bArr2, str);
                            if (withOTAFlagFilter != null) {
                                return withOTAFlagFilter;
                            }
                        }
                        i9 += iByteToInt + 1;
                    } else {
                        i9++;
                    }
                } else {
                    break;
                }
            }
        }
        return withOTAFlagFilter;
    }

    public static BleScanMessage parseWithOTAFlagFilter(byte[] bArr, String str) {
        if (bArr == null || str == null || str.length() == 0 || bArr.length <= str.getBytes().length + 2) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        short s8 = byteBufferWrap.getShort();
        byte[] bArr2 = new byte[str.getBytes().length];
        ByteBuffer byteBuffer = byteBufferWrap.get(bArr2);
        byte[] bArrA = a(bArr2);
        if (!Arrays.equals(bArrA, str.getBytes())) {
            JL_Log.i(f16343a, "parseWithOTAFlagFilter", CommonUtil.formatString("flag not match. adv flag : %s, flag : %s", CHexConver.byte2HexStr(bArrA), CHexConver.byte2HexStr(str.getBytes())));
            return null;
        }
        int iByteToInt = CHexConver.byteToInt(byteBuffer.get());
        if (iByteToInt != 1) {
            byte[] bArr3 = new byte[6];
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr3);
            String strHexDataCovetToAddress = hexDataCovetToAddress(a(bArr3));
            byteBuffer2.get(new byte[byteBuffer2.remaining()]);
            return new BleScanMessage().setVid(s8).setOTA(true).setIdentify(str).setVersion(iByteToInt).setOldBleAddress(strHexDataCovetToAddress);
        }
        byte[] bArr4 = new byte[6];
        ByteBuffer byteBuffer3 = byteBuffer.get(bArr4);
        String strHexDataCovetToAddress2 = hexDataCovetToAddress(a(bArr4));
        short s9 = byteBuffer3.getShort();
        short s10 = byteBuffer3.getShort();
        byte b9 = byteBuffer3.get();
        int iByteToInt2 = CHexConver.byteToInt(byteBuffer3.get());
        byteBuffer3.get(new byte[byteBuffer3.remaining()]);
        return new BleScanMessage().setOTA(true).setIdentify(str).setVersion(iByteToInt).setOldBleAddress(strHexDataCovetToAddress2).setVid(s8).setUid(s9).setPid(s10).setDeviceType((b9 >> 4) & 255).setDeviceVersion(b9 & 15).setBattery(iByteToInt2);
    }
}
