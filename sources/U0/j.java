package U0;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Launch.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4631o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4632p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final JSONObject f4633q = new JSONObject();

    @Override // U0.b
    public final b a(JSONObject jSONObject) {
        V0.m.b(null);
        return null;
    }

    @Override // U0.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.f4629m = cursor.getString(9);
        this.f4628l = cursor.getInt(10);
        this.f4631o = cursor.getString(11);
        this.f4632p = cursor.getInt(12);
    }

    @Override // U0.b
    public final List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer"));
        return arrayList;
    }

    @Override // U0.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put("ver_name", this.f4629m);
        contentValues.put("ver_code", Integer.valueOf(this.f4628l));
        contentValues.put("last_session", this.f4631o);
        contentValues.put("is_first_time", Integer.valueOf(this.f4632p));
    }

    @Override // U0.b
    public final String i() {
        return this.f4630n ? "bg" : "fg";
    }

    @Override // U0.b
    public final String j() {
        return "launch";
    }

    @Override // U0.b
    public final JSONObject l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f4596b);
        jSONObject.put("tea_event_index", this.f4597c);
        jSONObject.put("session_id", this.f4598d);
        long j = this.f4599e;
        if (j > 0) {
            jSONObject.put(MTCoreConstants.Register.KEY_USER_ID, j);
        }
        if (!TextUtils.isEmpty(this.f4600f)) {
            jSONObject.put("user_unique_id", this.f4600f);
        }
        if (!TextUtils.isEmpty(this.f4601g)) {
            jSONObject.put("ssid", this.f4601g);
        }
        boolean z8 = this.f4630n;
        if (z8) {
            jSONObject.put("is_background", z8);
        }
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.f4602h)) {
            jSONObject.put("ab_sdk_version", this.f4602h);
        }
        if (!TextUtils.isEmpty(this.f4631o)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.f4631o);
        }
        if (this.f4632p == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        JSONObject jSONObject2 = this.f4633q;
        if (jSONObject2 != null) {
            jSONObject.put("pv_filters", jSONObject2);
        }
        return jSONObject;
    }
}
