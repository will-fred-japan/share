package p049g6;

import A.a;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlutterSecureStorageConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f18951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f18954i;
    public final String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f18956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f18958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap f18959o;

    /* JADX WARN: Code duplicated, block: B:54:0x00ed  */
    public n(Map<String, Object> map) {
        String str;
        this.f18959o = new HashMap(map);
        String strE = e("sharedPreferencesName", map);
        strE = strE == null ? "FlutterSecureStorage" : strE;
        this.f18946a = strE;
        String strE2 = e("preferencesKeyPrefix", map);
        this.f18948c = strE2 == null ? "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIHNlY3VyZSBzdG9yYWdlCg" : strE2;
        this.f18949d = a(false, "resetOnError", map);
        this.f18950e = a(true, "migrateOnAlgorithmChange", map);
        this.f18951f = a(false, "migrateWithBackup", map);
        this.f18952g = a(false, "encryptedSharedPreferences", map);
        this.f18953h = a(false, "enforceBiometrics", map);
        String strE3 = e("biometricType", map);
        strE3 = strE3 == null ? "biometricOrDeviceCredential" : strE3;
        if (!"strongBiometricOnly".equals(strE3) && !"biometricOrDeviceCredential".equals(strE3)) {
            throw new IllegalArgumentException(a.i("Unknown biometricType: '", strE3, "'. Expected one of: strongBiometricOnly, biometricOrDeviceCredential"));
        }
        this.f18954i = "strongBiometricOnly".equals(strE3);
        String strE4 = e("biometricPromptTitle", map);
        if (strE4 == null && (strE4 = e("prefOptionBiometricPromptTitle", map)) == null) {
            strE4 = "Authenticate to access";
        }
        this.j = strE4;
        String strE5 = e("biometricPromptSubtitle", map);
        if (strE5 == null && (strE5 = e("prefOptionBiometricPromptSubtitle", map)) == null) {
            strE5 = "Use biometrics or device credentials";
        }
        this.f18955k = strE5;
        String strE6 = e("biometricPromptNegativeButton", map);
        this.f18956l = strE6 == null ? "Cancel" : strE6;
        String strE7 = e("storageCipherAlgorithm", map);
        this.f18958n = strE7 == null ? "AES_GCM_NoPadding" : strE7;
        String strE8 = e("keyCipherAlgorithm", map);
        this.f18957m = strE8 == null ? "RSA_ECB_OAEPwithSHA_256andMGF1Padding" : strE8;
        if (map.containsKey("storageNamespace")) {
            Object obj = map.get("storageNamespace");
            if (obj instanceof String) {
                str = (String) obj;
                str = str.isEmpty() ? null : str;
            }
        }
        this.f18947b = str;
        if (str == null || "FlutterSecureStorage".equals(strE)) {
            return;
        }
        Log.w("FlutterSecureStorageConfig", "Both storageNamespace ('" + str + "') and sharedPreferencesName ('" + strE + "') are set. storageNamespace takes precedence for data prefs, config, KeyStore aliases, and key storage.");
    }

    public static boolean a(boolean z8, String str, Map map) {
        Object obj = map.get(str);
        return obj instanceof String ? Boolean.parseBoolean((String) obj) : z8;
    }

    public static String e(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof String)) {
            return null;
        }
        String str2 = (String) obj;
        if (str2.isEmpty()) {
            return null;
        }
        return str2;
    }

    public final String b() {
        String str = this.f18947b;
        return str != null ? str : this.f18946a;
    }

    public final String c() {
        String str = this.f18947b;
        if (str == null) {
            return "FlutterSecureKeyStorage";
        }
        return "FlutterSecureKeyStorage:" + str;
    }

    public final String d() {
        String str = this.f18947b;
        if (str == null) {
            return "";
        }
        return "." + str;
    }

    public final boolean f() {
        return this.f18947b != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FlutterSecureStorageConfig{sharedPreferencesName='");
        sb.append(this.f18946a);
        sb.append("', sharedPreferencesKeyPrefix='");
        sb.append(this.f18948c);
        sb.append("', deleteOnFailure=");
        sb.append(this.f18949d);
        sb.append(", migrateOnAlgorithmChange=");
        sb.append(this.f18950e);
        sb.append(", migrateWithBackup=");
        sb.append(this.f18951f);
        sb.append(", enforceBiometrics=");
        sb.append(this.f18953h);
        sb.append(", storageNamespace='");
        return a.j(sb, this.f18947b, "'}");
    }
}
