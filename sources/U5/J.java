package U5;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4697a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static final p012b6.a a(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i9] = (byte) cCharAt;
        }
        return p012b6.a.a(bArr);
    }

    public static boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i9 = 0; i9 < bArr.length; i9++) {
            if (bArr2[i9] != bArr[i9]) {
                return false;
            }
        }
        return true;
    }

    public static final p012b6.a c(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new L4.b("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i9] = (byte) cCharAt;
        }
        return p012b6.a.a(bArr);
    }
}
