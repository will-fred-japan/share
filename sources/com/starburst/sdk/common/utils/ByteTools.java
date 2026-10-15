package com.starburst.sdk.common.utils;

import com.starburst.sdk.utils.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class ByteTools {
    public static byte[] addBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte bitToByte(String str) {
        if (str == null) {
            return (byte) 0;
        }
        int length = str.length();
        if (length == 4 || length == 8) {
            return (byte) ((length != 8 || str.charAt(0) == '0') ? Integer.parseInt(str, 2) : Integer.parseInt(str, 2) - 256);
        }
        return (byte) 0;
    }

    public static int byte2Int(byte b9) {
        return b9 & 255;
    }

    public static String byte2String(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            int i9 = b9 & 255;
            if (i9 <= 15) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i9));
        }
        j.f("ByteTools", "byte2String = " + ((Object) sb));
        return sb.toString();
    }

    public static long byte4ArrReverseToLong(byte[] bArr) {
        if (bArr.length != 4) {
            return 0L;
        }
        return ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16)) + ((long) ((bArr[3] & 255) << 24));
    }

    public static long byte4ArrToLong(byte[] bArr) {
        if (bArr.length != 4) {
            return 0L;
        }
        return ((long) (bArr[3] & 255)) + ((long) ((bArr[2] & 255) << 8)) + ((long) ((bArr[1] & 255) << 16)) + ((long) ((bArr[0] & 255) << 24));
    }

    public static String byteArrToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            sb.append(byteToHex(Byte.valueOf(b9)));
        }
        return sb.toString();
    }

    public static String byteArrToHexWithLog(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            sb.append(byteToHex(Byte.valueOf(b9)) + " ");
        }
        return sb.toString();
    }

    public static byte[] byteArrayConcat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
        return bArr3;
    }

    public static int byteArrayToUnsignedInt(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            throw new IllegalArgumentException("The byte array must not be null and must be at least 4 bytes long.");
        }
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static String byteToBit(byte b9) {
        return "" + ((int) ((byte) ((b9 >> 7) & 1))) + ((int) ((byte) ((b9 >> 6) & 1))) + ((int) ((byte) ((b9 >> 5) & 1))) + ((int) ((byte) ((b9 >> 4) & 1))) + ((int) ((byte) ((b9 >> 3) & 1))) + ((int) ((byte) ((b9 >> 2) & 1))) + ((int) ((byte) ((b9 >> 1) & 1))) + ((int) ((byte) (b9 & 1)));
    }

    public static String byteToHex(Byte b9) {
        return String.format("%02x", b9).toUpperCase();
    }

    public static String byteTo_16RadixString(byte[] bArr) {
        String string = "0x";
        for (byte b9 : bArr) {
            StringBuilder sbB = p171w.a.b(string);
            sbB.append(Integer.toHexString((b9 & 255) | (-256)).substring(6));
            string = sbB.toString();
        }
        return string;
    }

    public static int bytes2Int(byte[] bArr, int i9) {
        if (i9 == 1) {
            return bArr[0] & 255;
        }
        if (i9 == 2) {
            return ((bArr[0] << 8) & 65280) | (bArr[1] & 255);
        }
        if (i9 == 3) {
            return ((bArr[0] << 16) & 16711680) | (bArr[2] & 255) | ((bArr[1] << 8) & 65280);
        }
        if (i9 != 4) {
            return 0;
        }
        return ((bArr[0] << 24) & 16711680) | (bArr[3] & 255) | (65280 & (bArr[2] << 8)) | ((bArr[1] << 16) & 16711680);
    }

    public static byte[] concatAll(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static byte[] float2ByteArray(float f6) {
        return ByteBuffer.allocate(4).putFloat(f6).array();
    }

    public static boolean getBoolean(byte[] bArr) {
        return bArr[0] == 1;
    }

    public static byte[] getBytes(int i9) {
        return new byte[]{(byte) (((-16777216) & i9) >> 24), (byte) ((16711680 & i9) >> 16), (byte) ((65280 & i9) >> 8), (byte) (i9 & 255)};
    }

    public static float getFloat(byte[] bArr) {
        return Float.intBitsToFloat(getInt(bArr));
    }

    public static int getInt(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
    }

    public static byte[] getIntByte(long j) {
        return getBytes((-2147483648L > j || j > 2147483647L) ? -1 : (int) j);
    }

    public static short getShort(byte[] bArr) {
        return (short) ((bArr[1] & 255) | ((bArr[0] << 8) & 65280));
    }

    public static byte[] getShortByte(long j) {
        return getBytes((-32768 > j || j > 32767) ? (short) -1 : (short) j);
    }

    public static byte[] getSingleByte(long j) {
        byte[] bArr = new byte[1];
        if (-128 > j || j > 127) {
            bArr[0] = -1;
            return bArr;
        }
        bArr[0] = (byte) j;
        return bArr;
    }

    public static String getString(byte[] bArr, int i9, int i10, String str) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i9, bArr2, 0, i10);
        return new String(bArr2, Charset.forName(str));
    }

    public static byte hexToByte(String str) {
        return (byte) Integer.parseInt(str, 16);
    }

    public static byte[] hexToByteArr(String str) {
        byte[] bArr;
        int length = str.length();
        if (isOdd(length) == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0".concat(str);
        } else {
            bArr = new byte[length / 2];
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            int i11 = i9 + 2;
            bArr[i10] = hexToByte(str.substring(i9, i11));
            i10++;
            i9 = i11;
        }
        return bArr;
    }

    public static byte[] int2Bytes(int i9, int i10) {
        byte[] bArr = new byte[i10];
        if (i10 == 1) {
            bArr[0] = (byte) (i9 & 255);
            return bArr;
        }
        if (i10 == 2) {
            bArr[0] = (byte) ((i9 >> 8) & 255);
            bArr[1] = (byte) (i9 & 255);
            return bArr;
        }
        if (i10 == 3) {
            bArr[0] = (byte) ((i9 >> 16) & 255);
            bArr[1] = (byte) ((i9 >> 8) & 255);
            bArr[2] = (byte) (i9 & 255);
            return bArr;
        }
        if (i10 != 4) {
            return bArr;
        }
        bArr[0] = (byte) ((i9 >> 24) & 255);
        bArr[1] = (byte) ((i9 >> 16) & 255);
        bArr[2] = (byte) ((i9 >> 8) & 255);
        bArr[3] = (byte) (i9 & 255);
        return bArr;
    }

    public static int isOdd(int i9) {
        return i9 & 1;
    }

    public static int little_byteToInt(byte b9) {
        return b9 & 255;
    }

    public static int little_bytesToInt(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0] & 255;
        }
        if (bArr.length == 2) {
            return ((bArr[1] << 8) & 65280) | (bArr[0] & 255);
        }
        if (bArr.length == 3) {
            return ((bArr[2] << 16) & 16711680) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280);
        }
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    public static byte[] little_intToByte(int i9, int i10) {
        byte[] bArr = new byte[i10];
        if (i10 == 1) {
            bArr[0] = (byte) (i9 & 255);
            return bArr;
        }
        if (i10 == 2) {
            bArr[0] = (byte) (i9 & 255);
            bArr[1] = (byte) ((i9 & 65280) >> 8);
            return bArr;
        }
        bArr[0] = (byte) (i9 & 255);
        bArr[1] = (byte) ((i9 & 65280) >> 8);
        bArr[2] = (byte) ((16711680 & i9) >> 16);
        bArr[3] = (byte) ((i9 & (-16777216)) >> 24);
        return bArr;
    }

    public static String byteArrToHex(byte[] bArr, int i9, int i10) {
        StringBuilder sb = new StringBuilder();
        while (i9 < i10) {
            sb.append(byteToHex(Byte.valueOf(bArr[i9])));
            i9++;
        }
        return sb.toString();
    }

    public static boolean getBoolean(byte[] bArr, int i9) {
        return bArr[i9] == 1;
    }

    public static byte[] getBytes(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    public static float getFloat(byte[] bArr, int i9) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i9, bArr2, 0, 4);
        return Float.intBitsToFloat(getInt(bArr2));
    }

    public static int getInt(byte[] bArr, int i9) {
        return (bArr[3] & 255) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
    }

    public static short getShort(byte[] bArr, int i9) {
        return (short) ((bArr[i9 + 1] & 255) | ((bArr[i9] << 8) & 65280));
    }

    public static String getString(byte[] bArr, String str) {
        return new String(bArr, Charset.forName(str));
    }

    public static byte[] getBytes(short s8) {
        return new byte[]{(byte) ((65280 & s8) >> 8), (byte) (s8 & 255)};
    }
}
