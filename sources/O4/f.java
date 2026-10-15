package O4;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.errorprone.annotations.RestrictedInheritance;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f3478a;

    public static final n a(PackageInfo packageInfo, n... nVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            o oVar = new o(packageInfo.signatures[0].toByteArray());
            for (int i9 = 0; i9 < nVarArr.length; i9++) {
                if (nVarArr[i9].equals(oVar)) {
                    return nVarArr[i9];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b A[RETURN] */
    public static final boolean b(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z8;
        n nVarA;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z8 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
                packageInfo2 = packageInfo;
            } else {
                packageInfo2 = packageInfo;
            }
            if (packageInfo != null && packageInfo2.signatures != null) {
                if (z8) {
                    nVarA = a(packageInfo2, q.f3490a);
                } else {
                    nVarA = a(packageInfo2, q.f3490a[0]);
                }
                if (nVarA != null) {
                    return true;
                }
            }
            return false;
        }
        packageInfo2 = null;
        z8 = true;
        if (packageInfo != null) {
            if (z8) {
                nVarA = a(packageInfo2, q.f3490a);
            } else {
                nVarA = a(packageInfo2, q.f3490a[0]);
            }
            if (nVarA != null) {
                return true;
            }
        }
        return false;
    }
}
