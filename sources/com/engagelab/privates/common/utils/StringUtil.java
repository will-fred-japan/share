package com.engagelab.privates.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    private static final String HEX = "0123456789ABCDEF";
    public static final String MD5 = Guard.string(new byte[]{91, 85, 5});
    public static final String sha1 = Guard.string(new byte[]{66, 120, 97, 40});
    private static final String HMAC_SHA_256 = Guard.string(new byte[]{89, 93, 65, 122, 91, 94, 80, 2, 21, 47});

    public static String HMAC(String str, String str2) {
        try {
            String str3 = HMAC_SHA_256;
            Mac mac = Mac.getInstance(str3);
            mac.init(new SecretKeySpec(str.getBytes(MTCommonConstants.UTF_8), str3));
            return toHex(mac.doFinal(str2.getBytes(MTCommonConstants.UTF_8))).toLowerCase();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String decodeToString(String str) {
        try {
            return new String(Base64.decode(str.getBytes(MTCommonConstants.UTF_8), 2));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String encodeToString(String str) {
        try {
            return Base64.encodeToString(str.getBytes(MTCommonConstants.UTF_8), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String filterSpecialCharacter(String str) {
        return TextUtils.isEmpty(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static String get16MD5String(String str) {
        return get32MD5String(str).substring(8, 24);
    }

    public static String get32MD5String(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i9 = 0; i9 < charArray.length; i9++) {
                bArr[i9] = (byte) charArray[i9];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                int i10 = b9 & 255;
                if (i10 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i10));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getBytesMD5(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(MD5).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i9));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getBytesSHA1(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(sha1).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i9));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getMD5Utf8(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(MD5).digest(str.getBytes(MTCommonConstants.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i9));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return "";
        }
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, MTCommonConstants.UTF_8);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] stringToUtf8Bytes(String str) {
        try {
            return TextUtils.isEmpty(str) ? new byte[0] : str.getBytes(MTCommonConstants.UTF_8);
        } catch (Throwable unused) {
            return str.getBytes();
        }
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            sb.append(HEX.charAt((b9 >> 4) & 15));
            sb.append(HEX.charAt(b9 & 15));
        }
        return sb.toString();
    }

    public static String toMD5(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(str.getBytes());
            return toHex(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getBytesSHA1(String str) {
        try {
            return TextUtils.isEmpty(str) ? str : getBytesSHA1(str.getBytes(MTCommonConstants.UTF_8));
        } catch (Throwable unused) {
            return str;
        }
    }
}
