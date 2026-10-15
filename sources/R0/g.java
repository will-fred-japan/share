package R0;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f3934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f3935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f3936c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedPreferences f3939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V0.c f3940g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<c> f3938e = new ArrayList<>(32);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3941h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f3937d = new JSONObject();

    public g(Application application, f fVar) {
        this.f3935b = application;
        this.f3936c = fVar;
        this.f3939f = fVar.f3925e;
        i iVar = i.f3947c.get(fVar);
        if (iVar == null) {
            synchronized (i.class) {
                try {
                    iVar = i.f3947c.get(fVar);
                    if (iVar == null) {
                        if (application == null) {
                            throw new IllegalArgumentException("context == null");
                        }
                        iVar = new i();
                        iVar.f3949b = new U0.a(application);
                        if (iVar.f3948a == null) {
                            iVar.f3948a = new V0.c(application, fVar, iVar.f3949b);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f3940g = iVar.f3948a;
        HashMap map = fVar.f3922b.f5250k;
        JSONObject jSONObject = null;
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f3934a) {
                jSONObject = this.f3937d.optJSONObject("custom");
            } else {
                try {
                    jSONObject = new JSONObject(fVar.f3923c.getString("header_custom_info", null));
                } catch (Exception unused) {
                }
            }
            if (jSONObject != null) {
                V0.o.d(jSONObject2, jSONObject);
            }
            try {
                for (Map.Entry entry : map.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e9) {
                V0.m.a("", e9);
            }
            jSONObject = jSONObject2;
        }
        if (c(jSONObject, "custom")) {
            this.f3936c.f3923c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }

    public static void b(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public final String a() {
        return this.f3937d.optString("aid", this.f3936c.f3922b.f5241a);
    }

    public final boolean c(Object obj, String str) {
        boolean z8;
        Object objOpt = this.f3937d.opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z8 = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f3937d;
                    JSONObject jSONObject2 = new JSONObject();
                    V0.o.d(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f3937d = jSONObject2;
                } catch (JSONException e9) {
                    V0.m.b(e9);
                }
            }
            z8 = true;
        }
        V0.m.a("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z8;
    }

    public final JSONObject d() {
        if (this.f3934a) {
            return this.f3937d;
        }
        return null;
    }

    public final int e() {
        String strOptString = this.f3937d.optString("device_id", "");
        String strOptString2 = this.f3937d.optString("install_id", "");
        String strOptString3 = this.f3937d.optString("bd_did", "");
        if ((V0.o.e(strOptString) || V0.o.e(strOptString3)) && V0.o.e(strOptString2)) {
            return this.f3939f.getInt("version_code", 0) == this.f3937d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public final int f() {
        int iOptInt = this.f3934a ? this.f3937d.optInt("version_code", -1) : -1;
        for (int i9 = 0; i9 < 3 && iOptInt == -1; i9++) {
            h();
            iOptInt = this.f3934a ? this.f3937d.optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public final String g() {
        String strOptString = this.f3934a ? this.f3937d.optString(Constants.EXTRA_KEY_APP_VERSION, null) : null;
        for (int i9 = 0; i9 < 3 && strOptString == null; i9++) {
            h();
            strOptString = this.f3934a ? this.f3937d.optString(Constants.EXTRA_KEY_APP_VERSION, null) : null;
        }
        return strOptString;
    }

    public final boolean h() {
        synchronized (this.f3938e) {
            try {
                boolean z8 = false;
                boolean z9 = true;
                if (this.f3938e.size() == 0) {
                    this.f3938e.add(new d(true, false));
                    this.f3938e.add(new e(this.f3935b, this.f3936c));
                    if (Y3.a.f5233o) {
                        this.f3938e.add(new j(this.f3935b));
                    }
                    this.f3938e.add(new p(true, false));
                    this.f3938e.add(new k(this.f3935b));
                    this.f3938e.add(new n(this.f3935b, this.f3936c));
                    this.f3938e.add(new o(true, false));
                    this.f3938e.add(new a(this.f3936c));
                    this.f3938e.add(new k(1, this.f3935b));
                    if (Y3.a.f5236r) {
                        this.f3938e.add(new a(this.f3935b));
                        this.f3938e.add(new q(this.f3935b));
                    }
                    this.f3938e.add(new h(this.f3935b, this));
                    ArrayList<c> arrayList = this.f3938e;
                    Application application = this.f3935b;
                    l lVar = new l(true, false);
                    lVar.f3953d = application;
                    arrayList.add(lVar);
                    if (Y3.a.f5230l) {
                        this.f3938e.add(new m(this.f3935b, this.f3936c));
                    }
                    this.f3938e.add(new k(2, this.f3936c));
                    ArrayList<c> arrayList2 = this.f3938e;
                    Application application2 = this.f3935b;
                    a aVar = new a(z9, z8);
                    aVar.f3913e = application2;
                    arrayList2.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        JSONObject jSONObject = this.f3937d;
        JSONObject jSONObject2 = new JSONObject();
        V0.o.d(jSONObject2, jSONObject);
        int i9 = 0;
        int i10 = 0;
        boolean z10 = true;
        for (c cVar : this.f3938e) {
            if (!cVar.f3916a || cVar.f3918c) {
                try {
                    cVar.f3916a = cVar.a(jSONObject2);
                } catch (SecurityException e9) {
                    if (!cVar.f3917b) {
                        i9++;
                        StringBuilder sbF = p027d5.a.f("loadHeader, ");
                        sbF.append(this.f3941h);
                        V0.m.a(sbF.toString(), e9);
                        if (!cVar.f3916a && this.f3941h > 10) {
                            cVar.f3916a = true;
                        }
                    }
                } catch (JSONException e10) {
                    V0.m.b(e10);
                }
                if (!cVar.f3916a && !cVar.f3917b) {
                    i10++;
                }
            } else {
                this.f3936c.b();
                V0.m.a("needSyncFromSub " + cVar + " false", null);
            }
            z10 &= cVar.f3916a || cVar.f3917b;
        }
        JSONObject jSONObject3 = this.f3937d;
        this.f3937d = jSONObject2;
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(jSONObject3.opt(next), next);
        }
        this.f3934a = z10;
        if (V0.m.f4822b) {
            StringBuilder sbF2 = p027d5.a.f("loadHeader, ");
            sbF2.append(this.f3934a);
            sbF2.append(", ");
            sbF2.append(this.f3941h);
            sbF2.append(", ");
            sbF2.append(this.f3937d.toString());
            V0.m.a(sbF2.toString(), null);
        } else {
            StringBuilder sbF3 = p027d5.a.f("loadHeader, ");
            sbF3.append(this.f3934a);
            sbF3.append(", ");
            sbF3.append(this.f3941h);
            V0.m.a(sbF3.toString(), null);
        }
        if (i9 > 0 && i9 == i10) {
            this.f3941h++;
            if (e() != 0) {
                this.f3941h += 10;
            }
        }
        if (this.f3934a) {
            V0.b.c(a()).a(Y3.a.c(this.f3936c.f3922b.f5241a).b(), this.f3937d.optString("install_id", ""), this.f3937d.optString("ssid", ""));
        }
        return this.f3934a;
    }
}
