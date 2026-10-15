package U0;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Terminate.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4657n;

    @Override // U0.b
    public final b a(JSONObject jSONObject) {
        V0.m.b(null);
        return this;
    }

    @Override // U0.b
    public final void d(Cursor cursor) {
        V0.m.b(null);
    }

    @Override // U0.b
    public final List<String> e() {
        return null;
    }

    @Override // U0.b
    public final void f(ContentValues contentValues) {
        V0.m.b(null);
    }

    @Override // U0.b
    public final String i() {
        return String.valueOf(this.f4655l);
    }

    @Override // U0.b
    public final String j() {
        return "terminate";
    }

    @Override // U0.b
    public final JSONObject l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f4596b);
        jSONObject.put("tea_event_index", this.f4597c);
        jSONObject.put("session_id", this.f4598d);
        jSONObject.put("stop_timestamp", this.f4656m / 1000);
        jSONObject.put("duration", this.f4655l / 1000);
        jSONObject.put("datetime", this.j);
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
        if (!TextUtils.isEmpty(this.f4602h)) {
            jSONObject.put("ab_sdk_version", this.f4602h);
        }
        if (!TextUtils.isEmpty(this.f4657n)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.f4657n, this.f4598d)) {
                jSONObject.put("original_session_id", this.f4657n);
            }
        }
        return jSONObject;
    }
}
