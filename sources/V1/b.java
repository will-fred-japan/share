package V1;

import android.app.Application;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: compiled from: SignatureUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4828a = "";

    public static String a(Application application) {
        try {
            if (!TextUtils.isEmpty(f4828a)) {
                return f4828a;
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(application.getPackageManager().getPackageInfo(application.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                String upperCase = Integer.toHexString(b9 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(Constants.COLON_SEPARATOR);
            }
            String string = stringBuffer.toString();
            String strSubstring = string.substring(0, string.length() - 1);
            f4828a = strSubstring;
            return strSubstring;
        } catch (PackageManager.NameNotFoundException e9) {
            e9.printStackTrace();
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
