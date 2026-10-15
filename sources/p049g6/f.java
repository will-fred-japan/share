package p049g6;

import A4.c;
import U5.B;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.apm.insight.ICommonParams;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import p057h6.b;
import p057h6.g;
import p144s4.a;
import p144s4.h;

/* JADX INFO: compiled from: FlutterSecureStorage.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f18913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f18915c;

    public f(Context context, ICommonParams iCommonParams, f fVar) {
        this.f18913a = context;
        this.f18914b = iCommonParams;
        this.f18915c = fVar == null ? null : (ICommonParams) fVar.f18914b;
    }

    @Override // p049g6.r
    public void a(Exception exc) {
        ((o.b.a) this.f18914b).a(exc);
    }

    public Map b() {
        Map mapC = c();
        Object obj = mapC.get("aid");
        if ((obj != null ? String.valueOf(obj) : null) == null) {
            mapC.put("aid", 4444);
        }
        return mapC;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0119  */
    /* JADX WARN: Code duplicated, block: B:65:0x0127  */
    /* JADX WARN: Code duplicated, block: B:81:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.HashMap] */
    public Map c() {
        Map<String, Object> map;
        Throwable th;
        ?? map2;
        String strValueOf;
        Class<?> clsI;
        Field field;
        int iIntValue;
        try {
            ICommonParams iCommonParams = (ICommonParams) this.f18915c;
            Map<String, Object> commonParams = iCommonParams != null ? iCommonParams.getCommonParams() : new HashMap();
            try {
                commonParams.putAll(((ICommonParams) this.f18914b).getCommonParams());
                th = null;
                map2 = commonParams;
            } catch (Throwable th2) {
                map = commonParams;
                th = th2;
                Map<String, Object> map3 = map;
                th = th;
                map2 = map3;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        if (map2 == 0) {
            map2 = new HashMap(4);
            if (th != null) {
                try {
                    map2.put("err_info", h.b(th));
                } catch (Throwable unused) {
                }
            }
        }
        boolean zIsEmpty = map2.isEmpty();
        Context context = (Context) this.f18913a;
        if (zIsEmpty || !((map2.containsKey(Constants.EXTRA_KEY_APP_VERSION) || map2.containsKey("version_name")) && map2.containsKey("version_code") && map2.containsKey("update_version_code"))) {
            try {
                PackageInfo packageInfoB = c.b(0, context.getPackageName(), context);
                map2.put("version_name", packageInfoB.versionName);
                map2.put("version_code", Integer.valueOf(packageInfoB.versionCode));
                if (map2.get("update_version_code") == null) {
                    Bundle bundle = packageInfoB.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = map2.get("version_code");
                    }
                    map2.put("update_version_code", obj);
                }
            } catch (Throwable unused2) {
                Class<?> clsI2 = a.i(context);
                if (a.f21231c == null && clsI2 != null) {
                    try {
                        a.f21231c = clsI2.getDeclaredField("VERSION_NAME");
                    } catch (NoSuchFieldException unused3) {
                    }
                }
                Field field2 = a.f21231c;
                if (field2 != null) {
                    try {
                        strValueOf = String.valueOf(field2.get(null));
                    } catch (Throwable unused4) {
                        strValueOf = "";
                        map2.put("version_name", strValueOf);
                        clsI = a.i(context);
                        if (a.f21232d == null && clsI != null) {
                            try {
                                a.f21232d = clsI.getDeclaredField("VERSION_CODE");
                            } catch (NoSuchFieldException unused5) {
                            }
                        }
                        field = a.f21232d;
                        if (field != null) {
                            try {
                                iIntValue = ((Integer) field.get(null)).intValue();
                            } catch (Throwable unused6) {
                                iIntValue = -1;
                                map2.put("version_code", Integer.valueOf(iIntValue));
                                if (map2.get("update_version_code") == null) {
                                    map2.put("update_version_code", map2.get("version_code"));
                                }
                                return map2;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        map2.put("version_code", Integer.valueOf(iIntValue));
                        if (map2.get("update_version_code") == null) {
                            map2.put("update_version_code", map2.get("version_code"));
                        }
                        return map2;
                    }
                } else {
                    strValueOf = "";
                }
                map2.put("version_name", strValueOf);
                clsI = a.i(context);
                if (a.f21232d == null) {
                    a.f21232d = clsI.getDeclaredField("VERSION_CODE");
                }
                field = a.f21232d;
                if (field != null) {
                    iIntValue = ((Integer) field.get(null)).intValue();
                } else {
                    iIntValue = -1;
                }
                map2.put("version_code", Integer.valueOf(iIntValue));
                if (map2.get("update_version_code") == null) {
                    map2.put("update_version_code", map2.get("version_code"));
                }
            }
        } else {
            try {
                String strC = c.c(context);
                String str = (String) Class.forName(context.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);
                if (strC != null && !strC.equals(str)) {
                    map2.put("manifest_version", strC);
                }
            } catch (Throwable unused7) {
            }
        }
        return map2;
    }

    public String d() {
        try {
            return ((ICommonParams) this.f18914b).getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String e() {
        try {
            return String.valueOf(((ICommonParams) this.f18914b).getCommonParams().get("aid"));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    /* JADX WARN: Code duplicated, block: B:124:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x018c A[LOOP:3: B:25:0x00bf->B:60:0x018c, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x018c, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // p049g6.r
    public void onSuccess(Object obj) {
        n nVar;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        String[] strArr;
        SharedPreferences sharedPreferences3;
        SharedPreferences sharedPreferences4;
        SharedPreferences sharedPreferences5;
        int i9;
        g.a[] aVarArr;
        SharedPreferences sharedPreferences6;
        String[] strArr2;
        a aVar;
        SharedPreferences sharedPreferences7;
        SharedPreferences sharedPreferences8;
        ?? r8;
        ?? r9;
        a aVar2;
        ?? r10;
        SharedPreferences sharedPreferences9;
        a aVar3 = (a) this.f18915c;
        aVar3.getClass();
        n nVar2 = (n) this.f18913a;
        String strB = nVar2.b();
        Context context = aVar3.f18882b;
        SharedPreferences sharedPreferences10 = context.getSharedPreferences(strB, 0);
        q qVar = new q(context, nVar2.b());
        g.a[] aVarArr2 = new g.a[2];
        for (int i10 = 0; i10 < 2; i10++) {
            aVarArr2[i10] = new B(g.f19095a[i10], context);
        }
        String strB2 = nVar2.b();
        SharedPreferences sharedPreferences11 = context.getSharedPreferences("FlutterSecureKeyStorage", 0);
        SharedPreferences sharedPreferences12 = context.getSharedPreferences("FlutterSecureKeyStorage:" + strB2, 0);
        boolean zF = nVar2.f();
        HashMap map = nVar2.f18959o;
        if (zF) {
            HashMap map2 = new HashMap(map);
            map2.remove("storageNamespace");
            nVar = new n(map2);
            sharedPreferences = sharedPreferences11;
            sharedPreferences2 = sharedPreferences12;
        } else {
            HashMap map3 = new HashMap(map);
            map3.put("storageNamespace", strB2);
            nVar = new n(map3);
            sharedPreferences = sharedPreferences12;
            sharedPreferences2 = sharedPreferences11;
        }
        String[] strArr3 = g.f19096b;
        int i11 = 0;
        while (true) {
            ?? Contains = 3;
            Contains = 3;
            if (i11 < 3) {
                Contains = sharedPreferences2.contains(strArr3[i11]);
                if (Contains == 0) {
                    i11++;
                }
            } else {
                String str = nVar2.f18948c;
                if (g.c(context, strB2, str) != null) {
                    int i12 = 0;
                    while (true) {
                        if (i12 < Contains) {
                            String str2 = strArr[i12];
                            if (sharedPreferences3.contains(str2)) {
                                sharedPreferences4 = sharedPreferences2;
                                sharedPreferences3 = sharedPreferences;
                                strArr = strArr3;
                                sharedPreferences5 = sharedPreferences10;
                                int i13 = 0;
                                sharedPreferences4 = sharedPreferences4;
                                sharedPreferences3 = sharedPreferences3;
                                strArr = strArr;
                                while (true) {
                                    if (i13 < 2) {
                                        g.a aVar4 = aVarArr2[i13];
                                        i9 = i13;
                                        aVarArr = aVarArr2;
                                        sharedPreferences6 = sharedPreferences4;
                                        strArr2 = strArr;
                                        try {
                                            byte[] bArrDecode = Base64.decode(sharedPreferences3.getString(str2, null), 0);
                                            B b9 = (B) aVar4;
                                            sharedPreferences7 = sharedPreferences3;
                                            try {
                                                b bVar = (b) b9.f4668a;
                                                aVar = aVar3;
                                                Context context2 = (Context) b9.f4669b;
                                                try {
                                                    Key keyC = bVar.f19087a.c(context2, nVar).c(bArrDecode);
                                                    byte[] encoded = keyC.getEncoded();
                                                    if (encoded != null) {
                                                        try {
                                                            if (encoded.length == 16) {
                                                                if (!g.b(context, strB2, str, encoded)) {
                                                                    throw new Exception("Unwrapped key does not decrypt this instance's own data; likely a different instance's key under the same preference name");
                                                                }
                                                                sharedPreferences6.edit().putString(str2, Base64.encodeToString(((b) b9.f4668a).f19087a.c(context2, nVar2).a(keyC), 0)).apply();
                                                                Log.i("LegacyNamespaceKeyRecovery", "Moved wrapped key for namespace '" + strB2 + "'");
                                                                r8 = str2;
                                                                break;
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            sharedPreferences8 = sharedPreferences7;
                                                            if (!(th instanceof VirtualMachineError)) {
                                                                throw th;
                                                            }
                                                            Log.w("LegacyNamespaceKeyRecovery", "Could not move wrapped key for namespace '" + strB2 + "'", th);
                                                            i13 = i9 + 1;
                                                            sharedPreferences3 = sharedPreferences8;
                                                            aVarArr2 = aVarArr;
                                                            sharedPreferences4 = sharedPreferences6;
                                                            strArr = strArr2;
                                                            aVar3 = aVar;
                                                            nVar = nVar;
                                                        }
                                                    }
                                                    StringBuilder sb = new StringBuilder("Unwrapped key is not AES-key-shaped (");
                                                    sb.append(encoded == null ? "null" : encoded.length + " bytes");
                                                    sb.append("); likely the wrong RSA algorithm");
                                                    throw new Exception(sb.toString());
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    sharedPreferences8 = sharedPreferences7;
                                                    if (!(th instanceof VirtualMachineError)) {
                                                        throw th;
                                                    }
                                                    Log.w("LegacyNamespaceKeyRecovery", "Could not move wrapped key for namespace '" + strB2 + "'", th);
                                                    i13 = i9 + 1;
                                                    sharedPreferences3 = sharedPreferences8;
                                                    aVarArr2 = aVarArr;
                                                    sharedPreferences4 = sharedPreferences6;
                                                    strArr = strArr2;
                                                    aVar3 = aVar;
                                                    nVar = nVar;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                aVar = aVar3;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            aVar = aVar3;
                                            sharedPreferences7 = sharedPreferences3;
                                        }
                                    }
                                    Log.w("LegacyNamespaceKeyRecovery", "Could not move wrapped key for namespace '" + strB2 + "'", th);
                                    i13 = i9 + 1;
                                    sharedPreferences3 = sharedPreferences8;
                                    aVarArr2 = aVarArr;
                                    sharedPreferences4 = sharedPreferences6;
                                    strArr = strArr2;
                                    aVar3 = aVar;
                                    nVar = nVar;
                                }
                            } else {
                                sharedPreferences4 = sharedPreferences2;
                                sharedPreferences3 = sharedPreferences;
                                strArr = strArr3;
                                sharedPreferences5 = sharedPreferences10;
                            }
                            i12++;
                            sharedPreferences10 = sharedPreferences5;
                            sharedPreferences3 = sharedPreferences3;
                            aVarArr2 = aVarArr2;
                            sharedPreferences4 = sharedPreferences4;
                            strArr = strArr;
                            aVar3 = aVar3;
                            nVar = nVar;
                            Contains = 3;
                        } else {
                            sharedPreferences4 = sharedPreferences2;
                            sharedPreferences3 = sharedPreferences;
                            strArr = strArr3;
                        }
                    }
                }
            }
            aVar = aVar3;
            sharedPreferences5 = sharedPreferences10;
            r8 = Contains;
            break;
        }
        SharedPreferences sharedPreferences13 = qVar.f18973a;
        boolean z8 = sharedPreferences13.contains("ENCRYPTED_PREFERENCES_MIGRATED") ? sharedPreferences13.getBoolean("ENCRYPTED_PREFERENCES_MIGRATED", false) : qVar.f18974b.getBoolean("ENCRYPTED_PREFERENCES_MIGRATED", false);
        o.b.a aVar5 = (o.b.a) this.f18914b;
        boolean z9 = nVar2.f18952g;
        if (z8 || nVar2.f18951f) {
            r9 = sharedPreferences5;
            aVar2 = aVar;
        } else {
            aVar2 = aVar;
            try {
                p065i6.a aVarM = aVar2.m(context);
                boolean zK = aVar2.k(aVarM);
                boolean z10 = nVar2.f18950e;
                try {
                    if (zK) {
                        Log.w("FlutterSecureStorage", "Found data in EncryptedSharedPreferences (deprecated)");
                        Log.w("FlutterSecureStorage", "EncryptedSharedPreferences is DEPRECATED and will be removed in a later version");
                        Log.w("FlutterSecureStorage", "The Jetpack Security library has been deprecated by Google.");
                        if (!z10) {
                            Log.w("FlutterSecureStorage", "Data found in EncryptedSharedPreferences, but migrateOnAlgorithmChange is set to false.");
                            Log.w("FlutterSecureStorage", "Set migrateOnAlgorithmChange=true to migrate to custom cipher storage.");
                            if (z9) {
                                Log.i("FlutterSecureStorage", "Using EncryptedSharedPreferences (migration disabled).");
                                aVar2.f18883c = aVarM;
                                aVar5.onSuccess(null);
                                return;
                            } else {
                                Log.e("FlutterSecureStorage", "Data exists in EncryptedSharedPreferences but encryptedSharedPreferences=false and migrateOnAlgorithmChange=false.");
                                Log.e("FlutterSecureStorage", "Either set encryptedSharedPreferences=true to use the old data, or set migrateOnAlgorithmChange=true to migrate it.");
                                aVar5.a(new Exception("EncryptedSharedPreferences data found but migration is disabled. Set migrateOnAlgorithmChange=true to migrate."));
                                return;
                            }
                        }
                        Log.i("FlutterSecureStorage", "Migrating data from EncryptedSharedPreferences to custom cipher storage...");
                        if (z9) {
                            Log.w("FlutterSecureStorage", "Your data will be automatically migrated. You can safely remove encryptedSharedPreferences from your config after migration.");
                        }
                        Log.i("FlutterSecureStorage", "Migrating data from EncryptedSharedPreferences to selected custom cipher storage...");
                        SharedPreferences sharedPreferences14 = sharedPreferences5;
                        aVar2.n(qVar, new g(aVar2, aVarM, sharedPreferences14, qVar, aVar5));
                        r8 = sharedPreferences14;
                    } else {
                        sharedPreferences9 = sharedPreferences5;
                        Log.d("FlutterSecureStorage", "No data found in EncryptedSharedPreferences.");
                        if (z9 && !z10) {
                            Log.w("FlutterSecureStorage", "Using EncryptedSharedPreferences (deprecated). Consider migrating to custom ciphers.");
                            aVar2.f18883c = aVarM;
                            aVar5.onSuccess(null);
                            r8 = sharedPreferences9;
                        }
                    }
                    return;
                } catch (Exception e9) {
                    e = e9;
                    r10 = r8;
                    Log.e("FlutterSecureStorage", "EncryptedSharedPreferences initialization failed. Falling back to custom ciphers.", e);
                    r9 = r10;
                }
            } catch (Exception e10) {
                e = e10;
                r10 = sharedPreferences5;
            }
        }
        r9 = sharedPreferences9;
        r9 = sharedPreferences9;
        if (aVar2.f18883c == null) {
            if (z9 && z8) {
                Log.i("FlutterSecureStorage", "Data already migrated, encryptedSharedPreferences ignored and can be safely removed.");
            }
            S1.a aVar6 = new S1.a();
            aVar6.f4104c = aVar2;
            aVar6.f4102a = r9;
            aVar6.f4103b = aVar5;
            aVar2.n(qVar, aVar6);
        }
    }
}
