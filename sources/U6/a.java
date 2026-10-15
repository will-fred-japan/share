package U6;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.jvm.internal.k;
import p096m7.j;
import p096m7.l;
import y7.g;

/* JADX INFO: compiled from: PackageInfoPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements l.c, p042f7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f4746b;

    public static String b(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        k.b(bArrDigest);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArrDigest.length * 2];
        int length = bArrDigest.length;
        for (int i9 = 0; i9 < length; i9++) {
            byte b9 = bArrDigest[i9];
            int i10 = i9 * 2;
            cArr2[i10] = cArr[(b9 & 255) >>> 4];
            cArr2[i10 + 1] = cArr[b9 & 15];
        }
        return new String(cArr2);
    }

    public final String a(PackageManager packageManager) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Context context = this.f4745a;
                k.b(context);
                Signature[] signatureArr = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
                if (signatureArr != null && signatureArr.length != 0 && g.l(signatureArr) != null) {
                    byte[] byteArray = ((Signature) g.l(signatureArr)).toByteArray();
                    k.d(byteArray, "toByteArray(...)");
                    return b(byteArray);
                }
                return null;
            }
            Context context2 = this.f4745a;
            k.b(context2);
            SigningInfo signingInfo = packageManager.getPackageInfo(context2.getPackageName(), 134217728).signingInfo;
            if (signingInfo == null) {
                return null;
            }
            if (signingInfo.hasMultipleSigners()) {
                Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                k.d(apkContentsSigners, "getApkContentsSigners(...)");
                byte[] byteArray2 = ((Signature) g.l(apkContentsSigners)).toByteArray();
                k.d(byteArray2, "toByteArray(...)");
                return b(byteArray2);
            }
            Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
            k.d(signingCertificateHistory, "getSigningCertificateHistory(...)");
            byte[] byteArray3 = ((Signature) g.l(signingCertificateHistory)).toByteArray();
            k.d(byteArray3, "toByteArray(...)");
            return b(byteArray3);
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b binding) {
        k.e(binding, "binding");
        this.f4745a = binding.f18711a;
        l lVar = new l(binding.f18713c, "dev.fluttercommunity.plus/package_info");
        this.f4746b = lVar;
        lVar.b(this);
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b binding) {
        k.e(binding, "binding");
        this.f4745a = null;
        l lVar = this.f4746b;
        k.b(lVar);
        lVar.b(null);
        this.f4746b = null;
    }

    @Override // m7.l.c
    public final void onMethodCall(j call, l.d dVar) {
        String string;
        CharSequence charSequenceLoadLabel;
        k.e(call, "call");
        try {
            if (!k.a(call.f20496a, "getAll")) {
                ((p096m7.k) dVar).notImplemented();
                return;
            }
            Context context = this.f4745a;
            k.b(context);
            PackageManager packageManager = context.getPackageManager();
            Context context2 = this.f4745a;
            k.b(context2);
            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
            String strA = a(packageManager);
            Context context3 = this.f4745a;
            k.b(context3);
            PackageManager packageManager2 = context3.getPackageManager();
            Context context4 = this.f4745a;
            k.b(context4);
            String packageName = context4.getPackageName();
            int i9 = Build.VERSION.SDK_INT;
            String initiatingPackageName = i9 >= 30 ? packageManager2.getInstallSourceInfo(packageName).getInitiatingPackageName() : packageManager2.getInstallerPackageName(packageName);
            long j = packageInfo.firstInstallTime;
            long j8 = packageInfo.lastUpdateTime;
            HashMap map = new HashMap();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String str = "";
            if (applicationInfo == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null || (string = charSequenceLoadLabel.toString()) == null) {
                string = "";
            }
            map.put("appName", string);
            Context context5 = this.f4745a;
            k.b(context5);
            map.put("packageName", context5.getPackageName());
            String str2 = packageInfo.versionName;
            if (str2 != null) {
                str = str2;
            }
            map.put("version", str);
            map.put("buildNumber", String.valueOf(i9 >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode));
            if (strA != null) {
                map.put("buildSignature", strA);
            }
            if (initiatingPackageName != null) {
                map.put("installerStore", initiatingPackageName);
            }
            map.put("installTime", String.valueOf(j));
            map.put("updateTime", String.valueOf(j8));
            ((p096m7.k) dVar).success(map);
        } catch (PackageManager.NameNotFoundException e9) {
            ((p096m7.k) dVar).error("Name not found", e9.getMessage(), null);
        }
    }
}
