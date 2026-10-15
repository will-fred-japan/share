package K2;

import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CpuNormalExceptionEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p150t2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f2806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2809e;

    @Override // p150t2.b
    public final boolean a() {
        ArrayList arrayList = this.f2809e;
        return arrayList != null && !arrayList.isEmpty() && this.f2805a > 0.0d && this.f2806b > 0.0d;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007d A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #1 {all -> 0x0046, blocks: (B:3:0x000b, B:5:0x0018, B:7:0x0021, B:9:0x002a, B:11:0x0033, B:14:0x0040, B:19:0x0050, B:21:0x0055, B:24:0x0071, B:26:0x0079, B:29:0x0086, B:31:0x008d, B:33:0x0094, B:35:0x009e, B:36:0x00ae, B:38:0x00b4, B:41:0x00bd, B:43:0x00c4, B:45:0x00cc, B:47:0x00d7, B:49:0x00df, B:51:0x00e7, B:53:0x00ef, B:54:0x00f8, B:27:0x007d, B:17:0x0049), top: B:67:0x000b }] */
    @Override // p150t2.b
    public final JSONObject b() {
        Object obj = this.f2807c;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", "cpu_exception_trace");
            jSONObject.put("log_type", "cpu_exception_trace");
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("crash_time", System.currentTimeMillis());
            jSONObject.put("is_main_process", p061i1.h.h());
            jSONObject.put("process_name", p061i1.h.c());
            if (this.f2808d) {
                jSONObject.put("data_type", "back");
            } else {
                jSONObject.put("data_type", "front");
            }
            jSONObject.put("scene", obj);
            jSONObject.put("report_scene", obj);
            jSONObject.put("filters", p158u2.a.a().b());
            if (p061i1.h.f19238k <= p061i1.h.f()) {
                long j = p061i1.h.f19238k;
                if (j != 0) {
                    jSONObject.put("app_launch_start_time", j);
                } else {
                    jSONObject.put("app_launch_start_time", p061i1.h.f());
                }
            } else {
                jSONObject.put("app_launch_start_time", p061i1.h.f());
            }
            jSONObject.put("process_speed_avg", this.f2805a);
            jSONObject.put("process_speed_max", this.f2806b);
            p017c2.i iVar = c2.i.a.f8764a;
            jSONObject.put("battery_temperature", iVar.f8761d);
            jSONObject.put("battery_recharge_state", iVar.f8762e);
            JSONArray jSONArray = new JSONArray();
            for (J2.d dVar : this.f2809e) {
                if (dVar != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("nice", dVar.f2685h);
                    jSONObject2.put("weight", Double.valueOf(dVar.f2682e));
                    jSONObject2.put("cpu_usage", dVar.f2681d);
                    jSONObject2.put(CrashHianalyticsData.THREAD_NAME, dVar.f2679b);
                    jSONObject2.put("thread_back_trace", dVar.f2683f);
                    jSONObject2.put(CrashHianalyticsData.THREAD_ID, dVar.f2678a);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("threads_info", jSONArray);
        } catch (Throwable th) {
            p010b3.b.b("APM-CPU", "cpu_exception_data_assemble", th);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("exception", th.getLocalizedMessage());
                p192y2.a aVar = new p192y2.a();
                aVar.f22367a = "cpu_exception_no_stack";
                aVar.f22368b = jSONObject3;
                p174w2.a.a(aVar);
            } catch (Throwable unused) {
            }
        }
        Log.i("APM-CPU", "exception data: " + jSONObject);
        return jSONObject;
    }

    @Override // p150t2.b
    public final String c() {
        return "cpu_exception_trace";
    }
}
