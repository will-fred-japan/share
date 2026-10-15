package W0;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: OaidModel.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f5018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f5019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f5020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f5021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f5022g;

    public m(String str, String str2, Boolean bool, Long l8, Long l9, Integer num, Long l10) {
        this.f5016a = str;
        this.f5017b = str2;
        this.f5018c = bool;
        this.f5019d = l8;
        this.f5020e = l9;
        this.f5021f = num;
        this.f5022g = l10;
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        String str = k.f5004i;
        String str2 = this.f5016a;
        if (str2 != null) {
            map.put("id", str2);
        }
        String str3 = this.f5017b;
        if (str3 != null) {
            map.put("req_id", str3);
        }
        map.put("is_track_limited", String.valueOf(this.f5018c));
        map.put("take_ms", String.valueOf(this.f5019d));
        map.put(CrashHianalyticsData.TIME, String.valueOf(this.f5020e));
        map.put("query_times", String.valueOf(this.f5021f));
        map.put("hw_id_version_code", String.valueOf(this.f5022g));
        return map;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        k.b(jSONObject, "id", this.f5016a);
        k.b(jSONObject, "req_id", this.f5017b);
        k.b(jSONObject, "is_track_limited", this.f5018c);
        k.b(jSONObject, "take_ms", this.f5019d);
        k.b(jSONObject, CrashHianalyticsData.TIME, this.f5020e);
        k.b(jSONObject, "query_times", this.f5021f);
        k.b(jSONObject, "hw_id_version_code", this.f5022g);
        return jSONObject;
    }

    public final String toString() {
        return b().toString();
    }
}
