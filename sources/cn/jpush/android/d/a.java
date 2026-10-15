package cn.jpush.android.d;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {
    private static final long serialVersionUID = -942487107643335186L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11286c;

    public a() {
        this.f11286c = -1;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString("msg_id"), jSONObject.optString("override_msg_id"), jSONObject.optInt("msg_type", -1));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!a(this.f11284a, aVar.f11284a)) {
            return false;
        }
        int i9 = this.f11286c;
        return (i9 == -1 || i9 == aVar.f11286c) && a(this.f11285b, aVar.f11285b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EntityKey{msg_id='");
        sb.append(this.f11284a);
        sb.append("', override_msg_id='");
        sb.append(this.f11285b);
        sb.append("', msgType=");
        return H2.a.a(sb, this.f11286c, '}');
    }

    public a(d dVar) {
        this.f11286c = -1;
        this.f11284a = dVar.f11320d;
        this.f11285b = dVar.f11324h;
        this.f11286c = dVar.f11317a;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", this.f11284a);
            jSONObject.put("override_msg_id", this.f11285b);
            jSONObject.put("msg_type", this.f11286c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public a(String str, String str2, int i9) {
        this.f11284a = str;
        this.f11285b = str2;
        this.f11286c = i9;
    }

    private static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return str != null && str.equals(str2);
    }
}
