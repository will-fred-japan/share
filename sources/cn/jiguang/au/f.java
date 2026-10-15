package cn.jiguang.au;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b9 : bArr) {
            a(stringBuffer, b9);
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b9) {
        stringBuffer.append("0123456789ABCDEF".charAt((b9 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b9 & 15));
    }
}
