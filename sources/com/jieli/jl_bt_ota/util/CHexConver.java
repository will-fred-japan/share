package com.jieli.jl_bt_ota.util;

import W5.e;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CHexConver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16323a = "0123456789ABCDEF";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f16324b = f16323a.toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f16325c = 17;

    private static String a(char c5) {
        if (c5 == '0') {
            return "0000";
        }
        if (c5 == '1') {
            return "0001";
        }
        if (c5 == '2') {
            return "0010";
        }
        if (c5 == '3') {
            return "0011";
        }
        if (c5 == '4') {
            return "0100";
        }
        if (c5 == '5') {
            return "0101";
        }
        if (c5 == '6') {
            return "0110";
        }
        if (c5 == '7') {
            return "0111";
        }
        if (c5 == '8') {
            return "1000";
        }
        if (c5 == '9') {
            return "1001";
        }
        if (c5 == 'A' || c5 == 'a') {
            return "1010";
        }
        if (c5 == 'B' || c5 == 'b') {
            return "1011";
        }
        if (c5 == 'C' || c5 == 'c') {
            return "1100";
        }
        if (c5 == 'D' || c5 == 'd') {
            return "1101";
        }
        if (c5 == 'E' || c5 == 'e') {
            return "1110";
        }
        return (c5 == 'F' || c5 == 'f') ? "1111" : "";
    }

    public static byte[] addressCovertToByteArray(String str) {
        if (!checkBluetoothAddress(str)) {
            return new byte[0];
        }
        String strReplace = str.replace(Constants.COLON_SEPARATOR, "");
        int length = strReplace.length() / 2;
        byte[] bArr = new byte[length];
        if (length != 6) {
            return new byte[0];
        }
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            int i11 = i10 + 2;
            if (i11 <= strReplace.length()) {
                try {
                    bArr[i9] = (byte) Integer.valueOf(strReplace.substring(i10, i11), 16).intValue();
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return new byte[0];
                }
            }
        }
        return bArr;
    }

    public static String byte2HexStr(byte[] bArr, int i9) {
        if (bArr == null) {
            return "";
        }
        int iMin = Math.min(bArr.length, i9);
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < iMin; i10++) {
            char[] cArr = f16324b;
            sb.append(cArr[(bArr[i10] & 255) >> 4]);
            sb.append(cArr[bArr[i10] & 15]);
            if (i10 != iMin - 1) {
                sb.append(" ");
            }
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    public static String byteToBit(byte b9) {
        return "" + ((int) ((byte) ((b9 >> 7) & 1))) + ((int) ((byte) ((b9 >> 6) & 1))) + ((int) ((byte) ((b9 >> 5) & 1))) + ((int) ((byte) ((b9 >> 4) & 1))) + ((int) ((byte) ((b9 >> 3) & 1))) + ((int) ((byte) ((b9 >> 2) & 1))) + ((int) ((byte) ((b9 >> 1) & 1))) + ((int) ((byte) (b9 & 1)));
    }

    public static String byteToHexString(byte b9) {
        return intToHexString(b9 & 255);
    }

    public static int byteToInt(byte b9) {
        return b9 & 255;
    }

    public static int bytesLittleToInt(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
    }

    public static int bytesToInt(byte b9, byte b10) {
        return ((b9 & 255) << 8) + (b10 & 255);
    }

    public static long bytesToLong(byte[] bArr, boolean z8) {
        if (bArr == null || bArr.length < 8) {
            return -1L;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(z8 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getLong();
    }

    public static short bytesToShort(byte b9, byte b10) {
        return (short) bytesToInt(b9, b10);
    }

    public static String bytesToStr(byte[] bArr) {
        return bArr == null ? "" : hexStr2ASCII(byte2HexStr(bArr));
    }

    public static boolean checkBitValue(byte b9, int i9) {
        return ((b9 >> i9) & 1) == 1;
    }

    public static boolean checkBluetoothAddress(String str) {
        if (str == null || str.length() != 17) {
            return false;
        }
        for (int i9 = 0; i9 < 17; i9++) {
            char cCharAt = str.charAt(i9);
            int i10 = i9 % 3;
            if (i10 == 0 || i10 == 1) {
                if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'A' || cCharAt > 'F')) {
                    return false;
                }
            } else if (i10 == 2 && cCharAt != ':') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkHexStr(String str) {
        String upperCase;
        int length;
        if (str == null || str.isEmpty() || (length = (upperCase = str.trim().replaceAll("\\s*|\\r|\\n|\\t", "").toUpperCase(Locale.US)).length()) <= 1 || length % 2 != 0) {
            return false;
        }
        int i9 = 0;
        while (i9 < length) {
            int i10 = i9 + 1;
            if (!f16323a.contains(upperCase.substring(i9, i10))) {
                return false;
            }
            i9 = i10;
        }
        return true;
    }

    public static byte decodeBinaryString(String str) {
        if (str == null) {
            return (byte) 0;
        }
        int length = str.length();
        if (length != 4 && length != 8) {
            return (byte) 0;
        }
        int i9 = (length != 8 || str.charAt(0) == '0') ? Integer.parseInt(str, 2) : Integer.parseInt(str, 2) - 256;
        return (byte) i9;
    }

    public static byte decodeHexChar(char c5, char c9) {
        String strA = a(c5);
        String strA2 = a(c9);
        if (TextUtils.isEmpty(strA)) {
            strA = "";
        }
        if (!TextUtils.isEmpty(strA2)) {
            strA = e.u(strA, strA2);
        }
        if (TextUtils.isEmpty(strA)) {
            return (byte) 0;
        }
        return decodeBinaryString(strA);
    }

    public static int getBitByPosition(int i9, int i10) {
        if (i10 < 0 || i10 >= 32) {
            return 0;
        }
        return (i9 >> i10) & 1;
    }

    public static byte[] getBooleanArray(byte b9) {
        byte[] bArr = new byte[8];
        for (int i9 = 7; i9 >= 0; i9--) {
            bArr[i9] = (byte) (b9 & 1);
            b9 = (byte) (b9 >> 1);
        }
        return bArr;
    }

    public static byte[] getBooleanArrayBig(byte b9) {
        byte[] bArr = new byte[8];
        for (int i9 = 0; i9 < 8; i9++) {
            bArr[i9] = (byte) (b9 & 1);
            b9 = (byte) (b9 >> 1);
        }
        return bArr;
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i9 = 0; i9 < bArr.length; i9++) {
                char[] cArr = f16324b;
                sb.append(cArr[(bArr[i9] & 255) >> 4]);
                sb.append(cArr[bArr[i9] & 15]);
                if (i9 != bArr.length - 1) {
                    sb.append(Constants.COLON_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }

    public static String hexStr2ASCII(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.trim().replaceAll("\\s*|\\r|\\n|\\t", "").toUpperCase(Locale.US);
        char[] charArray = upperCase.toCharArray();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            bArr[i9] = (byte) ((f16323a.indexOf(charArray[i10 + 1]) | (f16323a.indexOf(charArray[i10]) << 4)) & 255);
        }
        try {
            return new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e9) {
            e9.printStackTrace();
            return "";
        }
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.trim().replaceAll("\\s*|\\r|\\n|\\t", "").toUpperCase(Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            int i11 = i10 + 1;
            bArr[i9] = (byte) (Integer.decode("0x" + upperCase.substring(i10, i11) + upperCase.substring(i11, i10 + 2)).intValue() & 255);
        }
        return bArr;
    }

    public static String int2HexStr(int i9, int i10) {
        return i10 == 2 ? String.format(Locale.ENGLISH, "%02x", Integer.valueOf(i9)) : byte2HexStr(intToBigBytes(i9));
    }

    public static byte[] int2byte2(int i9) {
        return new byte[]{(byte) ((i9 >> 8) & 255), (byte) (i9 & 255)};
    }

    public static byte[] intToBigBytes(int i9) {
        return new byte[]{(byte) ((i9 >> 24) & 255), (byte) ((i9 >> 16) & 255), (byte) ((i9 >> 8) & 255), (byte) (i9 & 255)};
    }

    public static byte intToByte(int i9) {
        return (byte) i9;
    }

    public static String intToHexString(int i9) {
        return String.format(Locale.ENGLISH, "%02x", Integer.valueOf(i9));
    }

    public static byte[] intToLittleBytes(int i9) {
        return new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255), (byte) ((i9 >> 16) & 255), (byte) ((i9 >> 24) & 255)};
    }

    public static byte[] intToLittleBytes2(int i9) {
        return new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255)};
    }

    public static byte setBitValue(byte b9, int i9, boolean z8) {
        int i10 = 1 << i9;
        return (byte) (z8 ? b9 | i10 : b9 & (~i10));
    }

    public static byte[] shortToBigBytes(short s8) {
        return int2byte2(s8);
    }

    public static byte[] shortToBytes(short s8) {
        return intToLittleBytes2(s8);
    }

    public static String str2HexStr(String str) {
        byte[] bytes = null;
        if (str == null) {
            return null;
        }
        try {
            bytes = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e9) {
            e9.printStackTrace();
        }
        return (bytes == null || bytes.length == 0) ? "" : byte2HexStr(bytes);
    }

    public static String strToUnicode(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            String hexString = Integer.toHexString(cCharAt);
            if (cCharAt > 128) {
                sb.append("\\u");
            } else {
                sb.append("\\u00");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String unicodeToString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 6;
        StringBuilder sb = new StringBuilder();
        int i9 = 0;
        while (i9 < length) {
            int i10 = i9 * 6;
            i9++;
            String strSubstring = str.substring(i10, i9 * 6);
            sb.append(new String(Character.toChars(Integer.valueOf(strSubstring.substring(4), 16).intValue() | (Integer.valueOf(strSubstring.substring(2, 4), 16).intValue() << 8))));
        }
        return sb.toString();
    }

    public static int bytesToInt(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public static short bytesToShort(byte[] bArr, int i9) {
        return (short) bytesToInt(bArr, i9, 2);
    }

    public static int bytesLittleToInt(byte[] bArr, int i9, int i10) {
        if (bArr == null || i9 + i10 > bArr.length) {
            return -1;
        }
        if (i10 == 1) {
            return byteToInt(bArr[i9]);
        }
        if (i10 != 2) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            return bytesLittleToInt(bArr2);
        }
        return bytesToInt(bArr[i9 + 1], bArr[i9]);
    }

    public static int bytesToInt(byte[] bArr, int i9, int i10) {
        if (bArr == null || i9 + i10 > bArr.length) {
            return -1;
        }
        if (i10 == 1) {
            return byteToInt(bArr[i9]);
        }
        if (i10 != 2) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            return bytesToInt(bArr2);
        }
        return bytesToInt(bArr[i9], bArr[i9 + 1]);
    }

    public static long bytesToLong(byte[] bArr) {
        return bytesToLong(bArr, false);
    }

    public static long bytesToLong(byte[] bArr, int i9, int i10) {
        if (bArr == null || i10 < 8 || i10 + i9 > bArr.length) {
            return -1L;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, i9, bArr2, 0, 8);
        return bytesToLong(bArr2);
    }

    public static String byte2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return byte2HexStr(bArr, bArr.length);
        }
        return "";
    }
}
