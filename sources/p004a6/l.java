package p004a6;

import java.security.InvalidAlgorithmParameterException;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Validators.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    static {
        Pattern.compile("^projects/([0-9a-zA-Z\\-\\.\\_~])+/locations/([0-9a-zA-Z\\-\\.\\_~])+/keyRings/([0-9a-zA-Z\\-\\.\\_~])+/cryptoKeys/([0-9a-zA-Z\\-\\.\\_~])+$", 2);
        Pattern.compile("^projects/([0-9a-zA-Z\\-\\.\\_~])+/locations/([0-9a-zA-Z\\-\\.\\_~])+/keyRings/([0-9a-zA-Z\\-\\.\\_~])+/cryptoKeys/([0-9a-zA-Z\\-\\.\\_~])+/cryptoKeyVersions/([0-9a-zA-Z\\-\\.\\_~])+$", 2);
    }

    public static void a(int i9) throws InvalidAlgorithmParameterException {
        if (i9 != 16 && i9 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i9 * 8)));
        }
    }

    public static String b(String str) {
        if (str.toLowerCase(Locale.US).startsWith("android-keystore://")) {
            return str.substring(19);
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }
}
