package O4;

import S4.B;
import S4.C0376g;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.ikaile.ruoshui.client.R;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3474a;

    static {
        AtomicBoolean atomicBoolean = e.f3476a;
        f3474a = 12451000;
        new c();
    }

    public Intent a(int i9, String str, Context context) {
        if (i9 != 1 && i9 != 2) {
            if (i9 != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && b5.a.b(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(f3474a);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            try {
                p027d5.b bVarA = p027d5.c.a(context);
                sb.append(bVarA.f18524a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(MiPushSdk.FLAG_SUPPORT_CALLKIT);
        return intent3;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0196  */
    /* JADX WARN: Code duplicated, block: B:103:0x019b  */
    /* JADX WARN: Code duplicated, block: B:105:0x019f  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:92:0x016c  */
    /* JADX WARN: Code duplicated, block: B:97:0x018f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0194  */
    /* JADX WARN: Instruction removed from duplicated block: B:105:0x019f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:97:0x018f, please report this as an issue */
    public int b(Context context, int i9) {
        boolean z8;
        PackageInfo packageInfo;
        int i10;
        int i11;
        ApplicationInfo applicationInfo;
        boolean z9 = false;
        AtomicBoolean atomicBoolean = e.f3476a;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !e.f3477b.get()) {
            synchronized (B.f4119a) {
                try {
                    if (!B.f4120b) {
                        B.f4120b = true;
                        try {
                            Bundle bundle = p027d5.c.a(context).f18524a.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle != null) {
                                bundle.getString("com.google.app.id");
                                B.f4121c = bundle.getInt("com.google.android.gms.version");
                            }
                        } catch (PackageManager.NameNotFoundException e9) {
                            Log.wtf("MetadataValueReader", "This should never happen.", e9);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i12 = B.f4121c;
            if (i12 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (i12 != 12451000) {
                throw new GooglePlayServicesIncorrectManifestValueException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f3474a + " but found " + i12 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        if (b5.a.b(context)) {
            z8 = false;
        } else {
            if (b5.a.f8587c == null) {
                b5.a.f8587c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (b5.a.f8587c.booleanValue()) {
                z8 = false;
            } else {
                z8 = true;
            }
        }
        if (i9 < 0) {
            throw new IllegalArgumentException();
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        int i13 = 9;
        if (z8) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            synchronized (f.class) {
                if (f.f3478a == null) {
                    m mVar = r.f3491a;
                    synchronized (r.class) {
                        if (r.f3493c == null) {
                            r.f3493c = context.getApplicationContext();
                        } else {
                            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                        }
                    }
                    f fVar = new f();
                    context.getApplicationContext();
                    f.f3478a = fVar;
                }
            }
            if (!f.b(packageInfo2)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else if (z8) {
                C0376g.e(packageInfo);
                if (!f.b(packageInfo)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else if (z8 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    i10 = packageInfo2.versionCode;
                    if (i10 == -1) {
                        i11 = -1;
                    } else {
                        i11 = i10 / 1000;
                    }
                    if (i11 < (i9 != -1 ? i9 / 1000 : -1)) {
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i9 + " but found " + i10);
                        i13 = 2;
                    } else {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e10) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e10);
                                i13 = 1;
                            }
                        }
                        if (applicationInfo.enabled) {
                            i13 = 0;
                        } else {
                            i13 = 3;
                        }
                    }
                } else {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            } else if (z8) {
                i10 = packageInfo2.versionCode;
                if (i10 == -1) {
                    i11 = -1;
                } else {
                    i11 = i10 / 1000;
                }
                if (i11 < (i9 != -1 ? i9 / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i9 + " but found " + i10);
                    i13 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i13 = 3;
                    } else {
                        i13 = 0;
                    }
                }
            } else {
                i10 = packageInfo2.versionCode;
                if (i10 == -1) {
                    i11 = -1;
                } else {
                    i11 = i10 / 1000;
                }
                if (i11 < (i9 != -1 ? i9 / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i9 + " but found " + i10);
                    i13 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i13 = 3;
                    } else {
                        i13 = 0;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
        }
        if (i13 == 18) {
            z9 = true;
        } else if (i13 == 1) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                do {
                    if (!it.hasNext()) {
                        z9 = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                    }
                } while (!"com.google.android.gms".equals(it.next().getAppPackageName()));
                z9 = true;
            } catch (PackageManager.NameNotFoundException | Exception unused4) {
            }
        }
        if (z9) {
            return 18;
        }
        return i13;
    }
}
