package p088l7;

import T.G;
import T.L;
import T.Q;
import W5.e;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import androidx.datastore.preferences.protobuf.C0524s;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import io.flutter.plugin.editing.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p096m7.g;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: TextInputChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f.b f20215b;

    /* JADX INFO: compiled from: TextInputChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            Bundle bundle;
            w wVar = w.this;
            if (wVar.f20215b == null) {
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            Object obj = jVar.f20497b;
            switch (str) {
                case "TextInput.setPlatformViewClient":
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        wVar.f20215b.d(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        ((k) dVar).success(null);
                        break;
                    } catch (JSONException e9) {
                        ((k) dVar).error("error", e9.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setEditingState":
                    try {
                        wVar.f20215b.c(d.a((JSONObject) obj));
                        ((k) dVar).success(null);
                        break;
                    } catch (JSONException e10) {
                        ((k) dVar).error("error", e10.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setClient":
                    try {
                        JSONArray jSONArray = (JSONArray) obj;
                        wVar.f20215b.a(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                        ((k) dVar).success(null);
                        break;
                    } catch (NoSuchFieldException | JSONException e11) {
                        ((k) dVar).error("error", e11.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.hide":
                    f fVar = f.this;
                    if (fVar.f19548e.f19561a == f.c.a.f19566d) {
                        fVar.d();
                    } else {
                        fVar.d();
                        fVar.f19545b.hideSoftInputFromWindow(fVar.f19544a.getApplicationWindowToken(), 0);
                    }
                    ((k) dVar).success(null);
                    break;
                case "TextInput.show":
                    f fVar2 = f.this;
                    View view = fVar2.f19544a;
                    b bVar = fVar2.f19549f;
                    InputMethodManager inputMethodManager = fVar2.f19545b;
                    if (bVar == null || bVar.f20223g.f20233a != 11) {
                        view.requestFocus();
                        inputMethodManager.showSoftInput(view, 0);
                    } else {
                        fVar2.d();
                        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                    }
                    ((k) dVar).success(null);
                    break;
                case "TextInput.sendAppPrivateCommand":
                    try {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        f fVar3 = f.this;
                        fVar3.f19545b.sendAppPrivateCommand(fVar3.f19544a, string, bundle);
                        ((k) dVar).success(null);
                        break;
                    } catch (JSONException e12) {
                        ((k) dVar).error("error", e12.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setEditableSizeAndTransform":
                    try {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d9 = jSONObject3.getDouble("width");
                        double d10 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i9 = 0; i9 < 16; i9++) {
                            dArr[i9] = jSONArray2.getDouble(i9);
                        }
                        wVar.f20215b.b(d9, d10, dArr);
                        ((k) dVar).success(null);
                        break;
                    } catch (JSONException e13) {
                        ((k) dVar).error("error", e13.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.finishAutofillContext":
                    f.b bVar2 = wVar.f20215b;
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    AutofillManager autofillManager = f.this.f19546c;
                    if (autofillManager != null) {
                        if (zBooleanValue) {
                            autofillManager.commit();
                        } else {
                            autofillManager.cancel();
                        }
                    }
                    ((k) dVar).success(null);
                    break;
                case "TextInput.clearClient":
                    f fVar4 = f.this;
                    if (fVar4.f19548e.f19561a != f.c.a.f19565c) {
                        fVar4.f19551h.e(fVar4);
                        fVar4.d();
                        fVar4.f19549f = null;
                        fVar4.f19550g = null;
                        fVar4.f19548e = new f.c(f.c.a.f19563a, 0);
                        fVar4.f19555m = null;
                        WeakHashMap<View, L> weakHashMap = G.f4313a;
                        View view2 = fVar4.f19544a;
                        Q qA = G.e.a(view2);
                        if (qA != null && !qA.f4366a.t(8)) {
                            fVar4.f19545b.restartInput(view2);
                        }
                    }
                    ((k) dVar).success(null);
                    break;
                case "TextInput.requestAutofill":
                    f fVar5 = f.this;
                    AutofillManager autofillManager2 = fVar5.f19546c;
                    if (autofillManager2 != null && fVar5.f19550g != null) {
                        String str2 = fVar5.f19549f.j.f20229a;
                        int[] iArr = new int[2];
                        View view3 = fVar5.f19544a;
                        view3.getLocationOnScreen(iArr);
                        Rect rect = new Rect(fVar5.f19555m);
                        rect.offset(iArr[0], iArr[1]);
                        autofillManager2.notifyViewEntered(view3, str2.hashCode(), rect);
                    }
                    ((k) dVar).success(null);
                    break;
                default:
                    ((k) dVar).notImplemented();
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: TextInputChannel.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f20219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f20220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f20221e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20222f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f20223g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f20224h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f20225i;
        public final a j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String[] f20226k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final b[] f20227l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Locale[] f20228m;

        /* JADX INFO: compiled from: TextInputChannel.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f20229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String[] f20230b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final d f20231c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f20232d;

            public a(String str, String[] strArr, String str2, d dVar) {
                this.f20229a = str;
                this.f20230b = strArr;
                this.f20232d = str2;
                this.f20231c = dVar;
            }
        }

        public b(boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i9, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr, Locale[] localeArr) {
            this.f20217a = z8;
            this.f20218b = z9;
            this.f20219c = z10;
            this.f20220d = z11;
            this.f20221e = z12;
            this.f20222f = i9;
            this.f20223g = cVar;
            this.f20224h = num;
            this.f20225i = str;
            this.j = aVar;
            this.f20226k = strArr;
            this.f20227l = bVarArr;
            this.f20228m = localeArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:128:0x027c A[PHI: r18 r21
  0x027c: PHI (r18v42 int) = 
  (r18v5 int)
  (r18v6 int)
  (r18v7 int)
  (r18v8 int)
  (r18v9 int)
  (r18v10 int)
  (r18v11 int)
  (r18v12 int)
  (r18v13 int)
  (r18v14 int)
  (r18v15 int)
  (r18v16 int)
  (r18v17 int)
  (r18v18 int)
  (r18v19 int)
  (r18v20 int)
  (r18v21 int)
  (r18v22 int)
  (r18v23 int)
  (r18v24 int)
  (r18v25 int)
  (r18v26 int)
  (r18v27 int)
  (r18v28 int)
  (r18v29 int)
  (r18v30 int)
  (r18v31 int)
  (r18v32 int)
  (r18v33 int)
  (r18v34 int)
  (r18v35 int)
  (r18v36 int)
  (r18v37 int)
  (r18v38 int)
  (r18v39 int)
  (r18v40 int)
  (r18v43 int)
 binds: [B:270:0x049b, B:266:0x048e, B:262:0x0480, B:258:0x0473, B:255:0x0463, B:250:0x0453, B:246:0x0447, B:242:0x0439, B:238:0x0429, B:234:0x0419, B:230:0x0409, B:226:0x03f9, B:222:0x03e9, B:218:0x03db, B:214:0x03cb, B:210:0x03bd, B:206:0x03ad, B:202:0x039d, B:198:0x038d, B:194:0x037f, B:190:0x0371, B:186:0x0361, B:182:0x0353, B:178:0x0345, B:174:0x0335, B:170:0x0325, B:166:0x0315, B:162:0x0305, B:158:0x02f5, B:154:0x02e7, B:150:0x02d7, B:146:0x02c7, B:142:0x02b7, B:138:0x02a7, B:134:0x0297, B:130:0x0287, B:127:0x027a] A[DONT_GENERATE, DONT_INLINE]
  0x027c: PHI (r21v7 java.lang.String) = 
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v5 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
 binds: [B:270:0x049b, B:266:0x048e, B:262:0x0480, B:258:0x0473, B:255:0x0463, B:250:0x0453, B:246:0x0447, B:242:0x0439, B:238:0x0429, B:234:0x0419, B:230:0x0409, B:226:0x03f9, B:222:0x03e9, B:218:0x03db, B:214:0x03cb, B:210:0x03bd, B:206:0x03ad, B:202:0x039d, B:198:0x038d, B:194:0x037f, B:190:0x0371, B:186:0x0361, B:182:0x0353, B:178:0x0345, B:174:0x0335, B:170:0x0325, B:166:0x0315, B:162:0x0305, B:158:0x02f5, B:154:0x02e7, B:150:0x02d7, B:146:0x02c7, B:142:0x02b7, B:138:0x02a7, B:134:0x0297, B:130:0x0287, B:127:0x027a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:13:0x006d  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        public static b a(JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            int i9;
            int i10;
            b[] bVarArr;
            int i11;
            Locale[] localeArr;
            String str;
            String str2;
            int i12;
            byte b9;
            String str3 = "newPassword";
            String str4 = "creditCardExpirationMonth";
            Object aVar = null;
            int i13 = 4;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            int i14 = 3;
            if (jSONObject.isNull("fields")) {
                i9 = 2;
                i10 = 1;
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                i9 = 2;
                int length = jSONArray.length();
                i10 = 1;
                b[] bVarArr2 = new b[length];
                for (int i15 = 0; i15 < length; i15++) {
                    bVarArr2[i15] = a(jSONArray.getJSONObject(i15));
                }
                bVarArr = bVarArr2;
            }
            int iValueOf = 0;
            switch (string.hashCode()) {
                case -737377923:
                    if (string.equals("TextInputAction.done")) {
                        i11 = 0;
                    } else {
                        i11 = -1;
                    }
                    break;
                case -737089298:
                    if (string.equals("TextInputAction.next")) {
                        i11 = i10;
                    } else {
                        i11 = -1;
                    }
                    break;
                case -737080013:
                    if (string.equals("TextInputAction.none")) {
                        i11 = i9;
                    } else {
                        i11 = -1;
                    }
                    break;
                case -736940669:
                    if (string.equals("TextInputAction.send")) {
                        i11 = 3;
                    } else {
                        i11 = -1;
                    }
                    break;
                case 469250275:
                    if (string.equals("TextInputAction.search")) {
                        i11 = 4;
                    } else {
                        i11 = -1;
                    }
                    break;
                case 1241689507:
                    if (string.equals("TextInputAction.go")) {
                        i11 = 5;
                    } else {
                        i11 = -1;
                    }
                    break;
                case 1539450297:
                    if (string.equals("TextInputAction.newline")) {
                        i11 = 6;
                    } else {
                        i11 = -1;
                    }
                    break;
                case 2110497650:
                    if (string.equals("TextInputAction.previous")) {
                        i11 = 7;
                    } else {
                        i11 = -1;
                    }
                    break;
                default:
                    i11 = -1;
                    break;
            }
            switch (i11) {
                case 0:
                    iValueOf = 6;
                    break;
                case 1:
                    iValueOf = 5;
                    break;
                case 2:
                case 6:
                    iValueOf = Integer.valueOf(i10);
                    break;
                case 3:
                    iValueOf = 4;
                    break;
                case 4:
                    iValueOf = 3;
                    break;
                case 5:
                    iValueOf = Integer.valueOf(i9);
                    break;
                case 7:
                    iValueOf = 7;
                    break;
            }
            Integer num = iValueOf;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    arrayList.add(jSONArray2.optString(i16));
                }
            }
            if (jSONObject.isNull("hintLocales")) {
                localeArr = null;
            } else {
                JSONArray jSONArray3 = jSONObject.getJSONArray("hintLocales");
                Locale[] localeArr2 = new Locale[jSONArray3.length()];
                for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                    localeArr2[i17] = Locale.forLanguageTag(jSONArray3.optString(i17));
                }
                localeArr = localeArr2;
            }
            boolean zOptBoolean = jSONObject.optBoolean("obscureText");
            boolean zOptBoolean2 = jSONObject.optBoolean("autocorrect", i10);
            boolean zOptBoolean3 = jSONObject.optBoolean("enableSuggestions");
            boolean zOptBoolean4 = jSONObject.optBoolean("enableIMEPersonalizedLearning");
            boolean zOptBoolean5 = jSONObject.optBoolean("enableDeltaModel");
            String string2 = jSONObject.getString("textCapitalization");
            int[] iArrC = C0524s.c(4);
            int length2 = iArrC.length;
            int i18 = 0;
            while (i18 < length2) {
                int i19 = i18;
                int i20 = iArrC[i19];
                int i21 = length2;
                if (i20 == 1) {
                    str = "TextCapitalization.characters";
                } else if (i20 == i9) {
                    str = "TextCapitalization.words";
                } else if (i20 == i14) {
                    str = "TextCapitalization.sentences";
                } else {
                    if (i20 != i13) {
                        throw null;
                    }
                    str = "TextCapitalization.none";
                }
                if (str.equals(string2)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.INPUT_TYPE);
                    String string3 = jSONObject2.getString(MTCommonConstants.Network.KEY_NAME);
                    int[] iArrC2 = C0524s.c(13);
                    String str5 = str4;
                    int length3 = iArrC2.length;
                    int i22 = 0;
                    while (i22 < length3) {
                        int i23 = length3;
                        int i24 = iArrC2[i22];
                        switch (i24) {
                            case 1:
                                str2 = "TextInputType.text";
                                break;
                            case 2:
                                str2 = "TextInputType.datetime";
                                break;
                            case 3:
                                str2 = "TextInputType.name";
                                break;
                            case 4:
                                str2 = "TextInputType.address";
                                break;
                            case 5:
                                str2 = "TextInputType.number";
                                break;
                            case 6:
                                str2 = "TextInputType.phone";
                                break;
                            case 7:
                                str2 = "TextInputType.multiline";
                                break;
                            case 8:
                                str2 = "TextInputType.emailAddress";
                                break;
                            case 9:
                                str2 = "TextInputType.url";
                                break;
                            case 10:
                                str2 = "TextInputType.visiblePassword";
                                break;
                            case 11:
                                str2 = "TextInputType.none";
                                break;
                            case 12:
                                str2 = "TextInputType.webSearch";
                                break;
                            case 13:
                                str2 = "TextInputType.twitter";
                                break;
                            default:
                                throw null;
                        }
                        int i25 = i22;
                        if (str2.equals(string3)) {
                            String str6 = str3;
                            c cVar = new c(i24, jSONObject2.optBoolean("signed", false), jSONObject2.optBoolean("decimal", false));
                            String string4 = jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel");
                            if (!jSONObject.isNull("autofill")) {
                                JSONObject jSONObject3 = jSONObject.getJSONObject("autofill");
                                String string5 = jSONObject3.getString("uniqueIdentifier");
                                JSONArray jSONArray4 = jSONObject3.getJSONArray("hints");
                                String string6 = jSONObject3.isNull("hintText") ? null : jSONObject3.getString("hintText");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("editingValue");
                                String[] strArr = new String[jSONArray4.length()];
                                int i26 = 0;
                                while (i26 < jSONArray4.length()) {
                                    String string7 = jSONArray4.getString(i26);
                                    string7.getClass();
                                    switch (string7.hashCode()) {
                                        case -2058889126:
                                            i12 = i26;
                                            if (string7.equals("birthdayYear")) {
                                                b9 = 0;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1917283616:
                                            i12 = i26;
                                            if (string7.equals("oneTimeCode")) {
                                                b9 = 1;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1844815832:
                                            i12 = i26;
                                            if (string7.equals(str5)) {
                                                b9 = 2;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1825589953:
                                            i12 = i26;
                                            if (string7.equals("telephoneNumberNational")) {
                                                b9 = 3;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1821235109:
                                            i12 = i26;
                                            String str7 = str6;
                                            if (string7.equals(str7)) {
                                                str6 = str7;
                                                b9 = 4;
                                            } else {
                                                str6 = str7;
                                                b9 = -1;
                                            }
                                            break;
                                        case -1757573738:
                                            i12 = i26;
                                            if (string7.equals("creditCardSecurityCode")) {
                                                b9 = 5;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1682373820:
                                            i12 = i26;
                                            if (string7.equals("creditCardExpirationDay")) {
                                                b9 = 6;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1658955742:
                                            i12 = i26;
                                            if (string7.equals("fullStreetAddress")) {
                                                b9 = 7;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1567118045:
                                            i12 = i26;
                                            if (string7.equals("telephoneNumberDevice")) {
                                                b9 = 8;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1476752575:
                                            i12 = i26;
                                            if (string7.equals("countryName")) {
                                                b9 = 9;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1413737489:
                                            i12 = i26;
                                            if (string7.equals("middleInitial")) {
                                                b9 = 10;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1377792129:
                                            i12 = i26;
                                            if (string7.equals("addressCity")) {
                                                b9 = 11;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1249512767:
                                            i12 = i26;
                                            if (string7.equals("gender")) {
                                                b9 = 12;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1186060294:
                                            i12 = i26;
                                            if (string7.equals("postalAddressExtendedPostalCode")) {
                                                b9 = 13;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -1151034798:
                                            i12 = i26;
                                            if (string7.equals("creditCardNumber")) {
                                                b9 = 14;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -835992323:
                                            i12 = i26;
                                            if (string7.equals("namePrefix")) {
                                                b9 = 15;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -818219584:
                                            i12 = i26;
                                            if (string7.equals("middleName")) {
                                                b9 = 16;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -747304516:
                                            i12 = i26;
                                            if (string7.equals("nameSuffix")) {
                                                b9 = 17;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -613980922:
                                            i12 = i26;
                                            if (string7.equals("creditCardExpirationDate")) {
                                                b9 = 18;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -613352043:
                                            i12 = i26;
                                            if (string7.equals("creditCardExpirationYear")) {
                                                b9 = 19;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -549230602:
                                            i12 = i26;
                                            if (string7.equals("telephoneNumberCountryCode")) {
                                                b9 = 20;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case -265713450:
                                            i12 = i26;
                                            if (string7.equals(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME)) {
                                                b9 = 21;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 3373707:
                                            i12 = i26;
                                            if (string7.equals(MTCommonConstants.Network.KEY_NAME)) {
                                                b9 = AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 96619420:
                                            i12 = i26;
                                            if (string7.equals("email")) {
                                                b9 = 23;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 253202685:
                                            i12 = i26;
                                            if (string7.equals("addressState")) {
                                                b9 = 24;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 588174851:
                                            i12 = i26;
                                            if (string7.equals("birthdayMonth")) {
                                                b9 = 25;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 798554127:
                                            i12 = i26;
                                            if (string7.equals("familyName")) {
                                                b9 = 26;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 892233837:
                                            i12 = i26;
                                            if (string7.equals("telephoneNumber")) {
                                                b9 = 27;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 991032982:
                                            i12 = i26;
                                            if (string7.equals("newUsername")) {
                                                b9 = 28;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 1069376125:
                                            i12 = i26;
                                            if (string7.equals("birthday")) {
                                                b9 = 29;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 1216985755:
                                            i12 = i26;
                                            if (string7.equals(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD)) {
                                                b9 = 30;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 1469046696:
                                            i12 = i26;
                                            if (string7.equals("givenName")) {
                                                b9 = 31;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 1662667945:
                                            i12 = i26;
                                            if (string7.equals("postalAddress")) {
                                                b9 = 32;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 1921869058:
                                            i12 = i26;
                                            if (string7.equals("postalAddressExtended")) {
                                                b9 = 33;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 2011152728:
                                            i12 = i26;
                                            if (string7.equals("postalCode")) {
                                                b9 = 34;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        case 2011773919:
                                            i12 = i26;
                                            if (string7.equals("birthdayDay")) {
                                                b9 = 35;
                                            } else {
                                                b9 = -1;
                                            }
                                            break;
                                        default:
                                            i12 = i26;
                                            b9 = -1;
                                            break;
                                    }
                                    switch (b9) {
                                        case 0:
                                            string7 = "birthDateYear";
                                            break;
                                        case 1:
                                            string7 = "smsOTPCode";
                                            break;
                                        case 2:
                                            string7 = str5;
                                            break;
                                        case 3:
                                            string7 = "phoneNational";
                                            break;
                                        case 4:
                                            string7 = str6;
                                            break;
                                        case 5:
                                            string7 = "creditCardSecurityCode";
                                            break;
                                        case 6:
                                            string7 = "creditCardExpirationDay";
                                            break;
                                        case 7:
                                            string7 = "streetAddress";
                                            break;
                                        case 8:
                                            string7 = "phoneNumberDevice";
                                            break;
                                        case 9:
                                            string7 = "addressCountry";
                                            break;
                                        case 10:
                                            string7 = "personMiddleInitial";
                                            break;
                                        case 11:
                                            string7 = "addressLocality";
                                            break;
                                        case 12:
                                            string7 = "gender";
                                            break;
                                        case 13:
                                            string7 = "extendedPostalCode";
                                            break;
                                        case 14:
                                            string7 = "creditCardNumber";
                                            break;
                                        case 15:
                                            string7 = "personNamePrefix";
                                            break;
                                        case 16:
                                            string7 = "personMiddleName";
                                            break;
                                        case 17:
                                            string7 = "personNameSuffix";
                                            break;
                                        case 18:
                                            string7 = "creditCardExpirationDate";
                                            break;
                                        case 19:
                                            string7 = "creditCardExpirationYear";
                                            break;
                                        case 20:
                                            string7 = "phoneCountryCode";
                                            break;
                                        case 21:
                                            string7 = URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME;
                                            break;
                                        case 22:
                                            string7 = "personName";
                                            break;
                                        case 23:
                                            string7 = "emailAddress";
                                            break;
                                        case 24:
                                            string7 = "addressRegion";
                                            break;
                                        case 25:
                                            string7 = "birthDateMonth";
                                            break;
                                        case 26:
                                            string7 = "personFamilyName";
                                            break;
                                        case 27:
                                            string7 = "phoneNumber";
                                            break;
                                        case 28:
                                            string7 = "newUsername";
                                            break;
                                        case 29:
                                            string7 = "birthDateFull";
                                            break;
                                        case 30:
                                            string7 = URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD;
                                            break;
                                        case 31:
                                            string7 = "personGivenName";
                                            break;
                                        case 32:
                                            string7 = "postalAddress";
                                            break;
                                        case 33:
                                            string7 = "extendedAddress";
                                            break;
                                        case 34:
                                            string7 = "postalCode";
                                            break;
                                        case 35:
                                            string7 = "birthDateDay";
                                            break;
                                    }
                                    strArr[i12] = string7;
                                    i26 = i12 + 1;
                                }
                                aVar = new a(string5, strArr, string6, d.a(jSONObject4));
                            }
                            return new b(zOptBoolean, zOptBoolean2, zOptBoolean3, zOptBoolean4, zOptBoolean5, i20, cVar, num, string4, aVar, (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr, localeArr);
                        }
                        i22 = i25 + 1;
                        str3 = str3;
                        length3 = i23;
                    }
                    throw new NoSuchFieldException(e.l("No such TextInputType: ", string3));
                }
                i18 = i19 + 1;
                str3 = str3;
                length2 = i21;
                str4 = str4;
                i13 = 4;
                i14 = 3;
                i9 = 2;
            }
            throw new NoSuchFieldException(e.l("No such TextCapitalization: ", string2));
        }
    }

    /* JADX INFO: compiled from: TextInputChannel.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f20235c;

        public c(int i9, boolean z8, boolean z9) {
            this.f20233a = i9;
            this.f20234b = z8;
            this.f20235c = z9;
        }
    }

    /* JADX INFO: compiled from: TextInputChannel.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20240e;

        public d(int i9, int i10, int i11, int i12, String str) {
            if (!(i9 == -1 && i10 == -1) && (i9 < 0 || i10 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + i9 + ", " + i10 + ")");
            }
            if (!(i11 == -1 && i12 == -1) && (i11 < 0 || i11 > i12)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + i11 + ", " + i12 + ")");
            }
            if (i12 > str.length()) {
                throw new IndexOutOfBoundsException(e.i(i11, "invalid composing start: "));
            }
            if (i9 > str.length()) {
                throw new IndexOutOfBoundsException(e.i(i9, "invalid selection start: "));
            }
            if (i10 > str.length()) {
                throw new IndexOutOfBoundsException(e.i(i10, "invalid selection end: "));
            }
            this.f20236a = str;
            this.f20237b = i9;
            this.f20238c = i10;
            this.f20239d = i11;
            this.f20240e = i12;
        }

        public static d a(JSONObject jSONObject) throws JSONException {
            return new d(jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"), jSONObject.getString("text"));
        }
    }

    public w(p013b7.a aVar) {
        a aVar2 = new a();
        l lVar = new l(aVar, "flutter/textinput", g.f20495a, null);
        this.f20214a = lVar;
        lVar.b(aVar2);
    }

    public static HashMap a(int i9, int i10, int i11, int i12, String str) {
        HashMap map = new HashMap();
        map.put("text", str);
        e.p(i9, map, "selectionBase", i10, "selectionExtent");
        e.p(i11, map, "composingBase", i12, "composingExtent");
        return map;
    }
}
