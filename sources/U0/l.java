package U0;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Page.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4647m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4648n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4649o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f4650p;

    @Override // U0.b
    public final b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.f4648n = jSONObject.optString("page_key", null);
        this.f4647m = jSONObject.optString("refer_page_key", null);
        this.f4646l = jSONObject.optLong("duration", 0L);
        this.f4649o = jSONObject.optInt("is_back", 0);
        return this;
    }

    @Override // U0.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.f4648n = cursor.getString(9);
        this.f4647m = cursor.getString(10);
        this.f4646l = cursor.getLong(11);
        this.f4649o = cursor.getInt(12);
        this.f4650p = cursor.getString(13);
    }

    @Override // U0.b
    public final List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar"));
        return arrayList;
    }

    @Override // U0.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put("page_key", this.f4648n);
        contentValues.put("refer_page_key", this.f4647m);
        contentValues.put("duration", Long.valueOf(this.f4646l));
        contentValues.put("is_back", Integer.valueOf(this.f4649o));
        contentValues.put("last_session", this.f4650p);
    }

    @Override // U0.b
    public final String i() {
        return this.f4648n + ", " + this.f4646l;
    }

    @Override // U0.b
    public final String j() {
        return "page";
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
        jSONObject.put(InAppSlotParams.SLOT_KEY.EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", this.f4648n);
        jSONObject2.put("refer_page_key", this.f4647m);
        jSONObject2.put("is_back", this.f4649o);
        jSONObject2.put("duration", this.f4646l);
        jSONObject.put(com.heytap.mcssdk.constant.b.f14278D, jSONObject2);
        jSONObject.put("datetime", this.j);
        return jSONObject;
    }
}
