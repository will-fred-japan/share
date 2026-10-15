package I1;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: compiled from: WakeLockInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2558h;

    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("flags", this.f2557g);
            jSONObject.put("tag", this.f2558h);
            jSONObject.put("start_time", this.f2550a);
            jSONObject.put("end_time", this.f2551b);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.f2552c);
            jSONObject.put("thread_stack", a());
            jSONObject.put("scene", this.f2554e);
            jSONObject.put("filters", this.f2555f);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WakeLockInfo{flags=");
        sb.append(this.f2557g);
        sb.append(", tag=");
        sb.append(this.f2558h);
        sb.append(", startTime=");
        sb.append(this.f2550a);
        sb.append(", endTime=");
        sb.append(this.f2551b);
        sb.append(", threadName=");
        sb.append(this.f2552c);
        sb.append(", threadStack=");
        sb.append(a());
        sb.append(", sense=");
        sb.append(this.f2554e);
        sb.append(", filter=");
        JSONObject jSONObject = this.f2555f;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        sb.append('}');
        return sb.toString();
    }
}
