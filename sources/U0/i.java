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

/* JADX INFO: compiled from: EventV3.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4625l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4626m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4627n;

    public i(String str, String str2) {
        this.f4627n = str;
        this.f4625l = str2;
    }

    @Override // U0.b
    public final b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.f4627n = jSONObject.optString(InAppSlotParams.SLOT_KEY.EVENT, null);
        this.f4625l = jSONObject.optString(com.heytap.mcssdk.constant.b.f14278D, null);
        this.f4626m = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // U0.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.f4627n = cursor.getString(9);
        this.f4625l = cursor.getString(10);
        this.f4626m = cursor.getInt(11) == 1;
    }

    @Override // U0.b
    public final List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList(InAppSlotParams.SLOT_KEY.EVENT, "varchar", com.heytap.mcssdk.constant.b.f14278D, "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // U0.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put(InAppSlotParams.SLOT_KEY.EVENT, this.f4627n);
        contentValues.put(com.heytap.mcssdk.constant.b.f14278D, this.f4625l);
        contentValues.put("is_bav", Integer.valueOf(this.f4626m ? 1 : 0));
    }

    @Override // U0.b
    public final String g() {
        return this.f4625l;
    }

    @Override // U0.b
    public final String i() {
        return this.f4627n;
    }

    @Override // U0.b
    public final String j() {
        return "eventv3";
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
        jSONObject.put(InAppSlotParams.SLOT_KEY.EVENT, this.f4627n);
        if (this.f4626m) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.f4625l)) {
            jSONObject.put(com.heytap.mcssdk.constant.b.f14278D, new JSONObject(this.f4625l));
        }
        int i9 = this.f4603i;
        if (i9 != -1) {
            jSONObject.put("nt", i9);
        }
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.f4602h)) {
            jSONObject.put("ab_sdk_version", this.f4602h);
        }
        return jSONObject;
    }
}
