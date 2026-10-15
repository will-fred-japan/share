package N1;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.services.apm.api.HttpResponse;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SlardarConfigFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements r2.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f3164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f3165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f3166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f3167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f3168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f3169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f3170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f3171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SharedPreferences f3172i;
    public p090m1.b j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f3173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3177o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f3178p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3180r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CopyOnWriteArrayList f3181s;

    /* JADX INFO: compiled from: SlardarConfigFetcher.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f3182a;

        public a(boolean z8) {
            this.f3182a = z8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p090m1.b bVar;
            h hVar = h.this;
            boolean z8 = this.f3182a;
            if (hVar.f3180r || hVar.f3179q) {
                if (!z8) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = hVar.f3176n;
                    if (j > 15000) {
                        if (jCurrentTimeMillis - hVar.f3177o <= j) {
                            return;
                        }
                    } else if (jCurrentTimeMillis - hVar.f3175m <= hVar.f3170g * 1000) {
                        return;
                    }
                }
                if (p099n1.d.a(p061i1.h.f19229a) && (bVar = hVar.j) != null) {
                    if (p061i1.h.e() != null) {
                        ((D4.e.a) hVar.j).getClass();
                        if (((HashMap) p061i1.h.e()).isEmpty()) {
                            return;
                        }
                        hVar.f3177o = System.currentTimeMillis();
                        boolean zE = false;
                        for (String str : hVar.f3169f) {
                            byte[] bArrA = p039f3.d.a(h.a());
                            HashMap map = new HashMap();
                            ((D4.e.a) hVar.j).getClass();
                            String strL = A1.b.l(str, p061i1.h.e());
                            if (bArrA.length > 128) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                try {
                                    try {
                                        gZIPOutputStream.write(bArrA);
                                        gZIPOutputStream.close();
                                        bArrA = byteArrayOutputStream.toByteArray();
                                        map.put("Content-Encoding", "gzip");
                                    } catch (IOException e9) {
                                        throw e9;
                                    }
                                } catch (Throwable th) {
                                    gZIPOutputStream.close();
                                    throw th;
                                }
                            }
                            map.put("Content-Type", "application/json; charset=utf-8");
                            zE = hVar.e(p061i1.h.f19235g.doPost(strL, bArrA, map));
                            if (zE) {
                                break;
                            }
                        }
                        if (zE) {
                            hVar.f3176n = 15000L;
                        } else {
                            hVar.f3176n = Math.min(hVar.f3176n * 2, 300000L);
                        }
                    }
                }
            }
        }
    }

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", p061i1.h.d().optString("aid"));
            jSONObject.put("os", p061i1.h.d().optString("os"));
            jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, p061i1.h.d().optString(Constants.EXTRA_KEY_APP_VERSION));
            jSONObject.put("update_version_code", p061i1.h.d().optString("update_version_code"));
            jSONObject.put("channel", p061i1.h.d().optString("channel"));
            jSONObject.put("device_id", p061i1.h.d().optString("device_id"));
            jSONObject.put("os_version", p061i1.h.d().optString("os_version"));
            jSONObject.put("device_model", p061i1.h.d().optString("device_model"));
            if (!TextUtils.isEmpty(p061i1.h.f19249w)) {
                jSONObject.put("x-auth-token", p061i1.h.f19249w);
            }
            p090m1.a aVar = p061i1.h.f19233e;
            if (aVar != null && !TextUtils.isEmpty(aVar.getUserId())) {
                jSONObject.put(MTCoreConstants.Register.KEY_USER_ID, p061i1.h.f19233e.getUserId());
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray.toString();
    }

    @Override // r2.b.d
    public final void b(long j) {
        d(false);
    }

    public final void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        if (A1.b.w0(jSONObject)) {
            return;
        }
        if (p061i1.h.f19230b) {
            Log.d("ApmInsight", p199z2.b.f(new String[]{"FinalSetting:\n" + jSONObject.toString()}));
        }
        JSONObject jSONObjectU = A1.b.u("general", "slardar_api_settings", jSONObject);
        if (jSONObjectU != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectU.optJSONObject("fetch_setting");
            if (jSONObjectOptJSONObject2 != null) {
                this.f3170g = jSONObjectOptJSONObject2.optLong("fetch_setting_interval", 1200L);
                try {
                    this.f3171h = new SecureRandom().nextInt(jSONObjectOptJSONObject2.optInt("random_scatter_threshold", 30));
                } catch (Throwable unused) {
                }
            }
            if (this.f3170g < 600) {
                this.f3170g = 600L;
            }
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("custom_event_settings");
        if (jSONObjectOptJSONObject3 != null) {
            this.f3166c = jSONObjectOptJSONObject3.optJSONObject("allow_log_type");
            this.f3167d = jSONObjectOptJSONObject3.optJSONObject("allow_metric_type");
            this.f3168e = jSONObjectOptJSONObject3.optJSONObject("allow_service_name");
        }
        this.f3173k = jSONObject;
        JSONObject jSONObject3 = (TextUtils.isEmpty("exception_modules") || (jSONObject2 = this.f3173k) == null) ? new JSONObject() : jSONObject2.optJSONObject("exception_modules");
        if (jSONObject3 == null || (jSONObjectOptJSONObject = jSONObject3.optJSONObject("exception")) == null) {
            return;
        }
        this.f3165b = jSONObjectOptJSONObject.optInt("enable_upload") == 1;
    }

    public final void d(boolean z8) {
        p133r2.b.f21107i.b(new a(z8), ((long) this.f3171h) * 1000);
        if (p061i1.h.f19230b) {
            Log.d("ApmInsight", p199z2.b.f(new String[]{"queryFromNet:" + this.f3171h}));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x035f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0363 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0367  */
    /* JADX WARN: Code duplicated, block: B:107:0x036a  */
    /* JADX WARN: Code duplicated, block: B:108:0x038f  */
    /* JADX WARN: Code duplicated, block: B:111:0x039e  */
    /* JADX WARN: Code duplicated, block: B:112:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:114:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:115:0x0437  */
    /* JADX WARN: Code duplicated, block: B:117:0x0449  */
    /* JADX WARN: Code duplicated, block: B:119:0x0454  */
    /* JADX WARN: Code duplicated, block: B:121:0x045e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0466  */
    /* JADX WARN: Code duplicated, block: B:126:0x0474  */
    /* JADX WARN: Code duplicated, block: B:127:0x048a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0495  */
    /* JADX WARN: Code duplicated, block: B:131:0x049f  */
    /* JADX WARN: Code duplicated, block: B:134:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:135:0x04af  */
    /* JADX WARN: Code duplicated, block: B:137:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:138:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:141:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:142:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:145:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:147:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:150:0x0501  */
    /* JADX WARN: Code duplicated, block: B:151:0x050b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0538  */
    /* JADX WARN: Code duplicated, block: B:155:0x0542  */
    /* JADX WARN: Code duplicated, block: B:158:0x054a  */
    /* JADX WARN: Code duplicated, block: B:159:0x0554  */
    /* JADX WARN: Code duplicated, block: B:161:0x059e  */
    /* JADX WARN: Code duplicated, block: B:164:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:166:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:167:0x0604  */
    /* JADX WARN: Code duplicated, block: B:170:0x0620  */
    /* JADX WARN: Code duplicated, block: B:176:0x0654  */
    /* JADX WARN: Code duplicated, block: B:182:0x0661  */
    /* JADX WARN: Code duplicated, block: B:187:0x066c  */
    /* JADX WARN: Code duplicated, block: B:193:0x068d  */
    /* JADX WARN: Code duplicated, block: B:198:0x0698  */
    /* JADX WARN: Code duplicated, block: B:203:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:210:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:224:0x072e A[Catch: Exception -> 0x0768, TryCatch #11 {Exception -> 0x0768, blocks: (B:222:0x0724, B:224:0x072e, B:229:0x0747, B:234:0x075a, B:235:0x0760, B:230:0x074e), top: B:304:0x0724 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x074e A[Catch: Exception -> 0x0768, TryCatch #11 {Exception -> 0x0768, blocks: (B:222:0x0724, B:224:0x072e, B:229:0x0747, B:234:0x075a, B:235:0x0760, B:230:0x074e), top: B:304:0x0724 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0760 A[Catch: Exception -> 0x0768, TRY_LEAVE, TryCatch #11 {Exception -> 0x0768, blocks: (B:222:0x0724, B:224:0x072e, B:229:0x0747, B:234:0x075a, B:235:0x0760, B:230:0x074e), top: B:304:0x0724 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x0771  */
    /* JADX WARN: Code duplicated, block: B:244:0x0779  */
    /* JADX WARN: Code duplicated, block: B:255:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:258:0x07e3 A[LOOP:1: B:256:0x07dd->B:258:0x07e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e8 A[EDGE_INSN: B:48:0x00e8->B:49:0x00e9 BREAK  A[LOOP:0: B:40:0x00c8->B:47:0x00e5]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0188  */
    /* JADX WARN: Code duplicated, block: B:53:0x0212  */
    /* JADX WARN: Code duplicated, block: B:54:0x0215  */
    /* JADX WARN: Code duplicated, block: B:57:0x0235  */
    /* JADX WARN: Code duplicated, block: B:61:0x0249  */
    /* JADX WARN: Code duplicated, block: B:63:0x0273  */
    /* JADX WARN: Code duplicated, block: B:65:0x0279  */
    /* JADX WARN: Code duplicated, block: B:67:0x0287  */
    /* JADX WARN: Code duplicated, block: B:68:0x028e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0297  */
    /* JADX WARN: Code duplicated, block: B:72:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:73:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:75:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:76:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:80:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x0308  */
    /* JADX WARN: Code duplicated, block: B:83:0x030f  */
    /* JADX WARN: Code duplicated, block: B:85:0x031e  */
    /* JADX WARN: Code duplicated, block: B:86:0x032e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0338  */
    /* JADX WARN: Code duplicated, block: B:95:0x0343  */
    /* JADX WARN: Code duplicated, block: B:97:0x034a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0356  */
    public final boolean e(HttpResponse httpResponse) throws JSONException {
        byte[] responseBytes;
        boolean z8;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObject;
        int i9;
        int iOptDouble;
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        JSONObject jSONObject2;
        String str;
        String str2;
        int i10;
        int i11;
        String str3;
        JSONObject jSONObject3;
        String str4;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iOptInt4;
        int i20;
        int iOptInt5;
        int i21;
        int iOptInt6;
        int i22;
        int i23;
        int i24;
        int iOptInt7;
        int iOptInt8;
        int iOptInt9;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        String str5;
        String str6;
        JSONObject jSONObject4;
        JSONObject jSONObjectOptJSONObject10;
        CopyOnWriteArrayList copyOnWriteArrayList;
        Iterator it;
        JSONObject jSONObjectD;
        JSONObject jSONObjectOptJSONObject11;
        int i51;
        int i52;
        boolean z9;
        JSONObject jSONObjectOptJSONObject12;
        JSONObject jSONObjectOptJSONObject13;
        JSONObject jSONObjectOptJSONObject14;
        JSONObject jSONObjectOptJSONObject15;
        JSONObject jSONObjectOptJSONObject16;
        JSONObject jSONObjectOptJSONObject17;
        JSONObject jSONObjectOptJSONObject18;
        JSONObject jSONObjectOptJSONObject19;
        JSONObject jSONObjectOptJSONObject20;
        JSONObject jSONObjectOptJSONObject21;
        JSONObject jSONObjectOptJSONObject22;
        JSONObject jSONObjectOptJSONObject23;
        JSONObject jSONObjectOptJSONObject24;
        JSONObject jSONObjectOptJSONObject25;
        JSONObject jSONObjectOptJSONObject26;
        int iOptInt10;
        int i53;
        int i54;
        int i55;
        int iOptInt11;
        int iOptInt12;
        int iOptInt13;
        int iOptInt14;
        int iOptInt15;
        int iOptInt16;
        int iOptInt17;
        int iOptInt18;
        int i56;
        int i57;
        int i58;
        String str7;
        String strOptString;
        int iOptInt19;
        int iOptInt20;
        JSONObject jSONObjectOptJSONObject27;
        int iOptInt21;
        int iOptInt22;
        int iOptInt23;
        int iOptInt24;
        int iOptInt25;
        int iOptInt26;
        int iOptInt27;
        boolean z10;
        boolean z11;
        int iOptInt28;
        int iOptInt29;
        JSONObject jSONObjectOptJSONObject28;
        int iOptInt30;
        int iOptInt31;
        JSONObject jSONObjectOptJSONObject29;
        String strOptString2;
        int iOptInt32;
        JSONObject jSONObjectOptJSONObject30;
        int iOptInt33;
        JSONObject jSONObjectOptJSONObject31;
        int iOptInt34;
        boolean z12;
        int i59;
        JSONArray jSONArrayOptJSONArray;
        if (httpResponse == null || httpResponse.getStatusCode() != 200 || (responseBytes = httpResponse.getResponseBytes()) == null) {
            return false;
        }
        JSONObject jSONObject5 = new JSONObject(new String(responseBytes));
        if (p061i1.h.f19230b) {
            try {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"FetchSetting:\n" + jSONObject5.toString()}));
                Map<String, String> headers = httpResponse.getHeaders();
                if (headers == null || headers.isEmpty()) {
                    z8 = true;
                } else {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("FetchSetting:: headers=");
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            for (String str8 : headers.keySet()) {
                                z8 = true;
                                try {
                                    if (!TextUtils.isEmpty(str8)) {
                                        jSONObject6.put(str8, headers.get(str8));
                                    }
                                } catch (JSONException e9) {
                                    e = e9;
                                    e.printStackTrace();
                                    sb.append(jSONObject6.toString());
                                    Log.d("ApmInsight", p199z2.b.f(new String[]{sb.toString()}));
                                    if (jSONObject5.optInt("error_no") != 0) {
                                        jSONObjectOptJSONObject = null;
                                        break;
                                    }
                                    jSONObjectOptJSONObject = null;
                                    break;
                                    JSONObject jSONObject7 = new JSONObject("{\n  \"ret\": {\n    \"custom_event_settings\": {\n      \"max_utm_thread_ignore\": [],\n      \"npth_simple_setting\": {\n        \"anr_atribute_long_message_time\": 1000,\n        \"crash_limit_all\": 100,\n        \"crash_limit_issue\": 50,\n        \"max_utm_thread_ignore\": [\n          \"1\",\n          \"^main$\",\n          \"^default_npth_thread$\",\n          \"^RenderThread$\",\n          \"^Jit thread pool worker thread.*$\"\n        ],\n        \"native_heap_collect_size_mb\": 500,\n        \"native_heap_poll_seconds\": 60,\n        \"native_heap_water_line_mb\": 300,\n        \"upload_core_dump\": 1\n      }\n    },\n    \"exception_modules\": {\n      \"exception\": {\n        \"crash_limit_all\": 200,\n        \"crash_limit_issue\": 50\n      },\n      \"npth\": \"\",\n      \"npth_config\": \"\",\n      \"oom_callback\": 1,\n      \"tset\": {\n        \"555\": 5,\n        \"coredump_types\": {\n          \"disable\": [],\n          \"enable\": {\n            \"header_os_api\": {\n              \"in\": []\n            }\n          }\n        },\n        \"npth\": \"\",\n        \"t1\": 1,\n        \"t2\": 2,\n        \"t3\": 1,\n        \"t4\": 3,\n        \"t5\": 2,\n        \"t6\": 3,\n        \"test\": 3,\n        \"test1\": 1,\n        \"test2\": \"\"\n      },\n      \"tt\": 1\n    },\n    \"general\": {\n      \"cleanup\": {\n        \"log_max_size_mb\": 50,\n        \"log_reserve_days\": 5\n      },\n      \"enable_active_upload_alog\": true,\n      \"slardar_api_settings\": {\n        \"fetch_setting\": {\n          \"fetch_setting_interval\": 3600\n        },\n        \"report_setting\": {\n          \"base_polling_interval_seconds\": 30,\n          \"apm6_uploading_interval\": 60,\n          \"enable_encrypt\": true,\n          \"hosts\": [],\n          \"local_monitor_min_free_disk_mb\": 150,\n          \"local_monitor_switch\": true,\n          \"log_remove_switch\": false,\n          \"low_memory_threshold_kb\": 20480,\n          \"max_retry_count\": 4,\n          \"memory_store_cache_max_count\": 500,\n          \"more_channel_stop_interval\": 15,\n          \"once_max_count\": 100,\n          \"once_max_count_degrade\": 10,\n          \"once_max_size_kb\": 500,\n          \"report_fail_base_interval\": 15,\n          \"uploading_interval\": 30,\n          \"uploading_interval_background\": 30\n        }\n      }\n    },\n    \"network_image_modules\": {\n      \"image\": {\n        \"enable_upload\": 1,\n        \"image_sample_interval\": 120,\n        \"image_sla_switch\": false\n      },\n      \"network\": {\n        \"filter_info\": \"\",\n        \"enable_success_net_sample\": 1,\n        \"enable_net_monitor\": 1,\n        \"enable_net_monitor_with_net_disable\": 1\n      }\n    },\n    \"performance_modules\": {\n      \"battery\": {\n        \"enable_upload\": 0,\n        \"sample_interval\": 5,\n        \"background_enable\": 0,\n        \"trace_enable\": 1,\n        \"exception_enable_upload\": 1,\n        \"max_normal_alarm_invoke_count\": 10,\n        \"max_single_loc_request_time_second\": 120,\n        \"max_single_wake_lock_hold_time_second\": 120,\n        \"max_total_loc_request_count\": 5,\n        \"max_total_loc_request_time_second\": 240,\n        \"max_total_wake_lock_acquire_count\": 5,\n        \"max_total_wake_lock_hold_time_second\": 240,\n        \"max_wake_up_alarm_invoke_count\": 5\n      },\n      \"cpu\": {\n        \"enable_upload\": 0,\n        \"front_collect_interval\": 120,\n        \"back_collect_interval\": 600,\n        \"monitor_interval\": 120,\n        \"enable_open\": 0,\n        \"exception_process_back_max_speed\": 3,\n        \"exception_thread_max_usage\": 0.05,\n        \"exception_collect_all_process\": 1,\n        \"main_thread_collect_enabled\": 1,\n        \"exception_process_fore_max_speed\": 6\n      },\n      \"disk\": {\n        \"enable_upload\": 1,\n        \"abnormal_folder_size\": 20,\n        \"disk_customed_paths\": {\n        },\n        \"dump_switch\": true,\n        \"dump_threshold\": 100,\n        \"dump_top_count\": 20,\n        \"ignored_relative_paths\": [],\n        \"outdated_days\": 30,\n        \"outdated_size_threshold\": 1000\n      },\n      \"fd\": {\n        \"collect_interval\": 20,\n        \"fd_collect_interval\": 20,\n        \"fd_count_threshold\": 800\n      },\n      \"memory\": {\n        \"collect_interval\": 120,\n        \"enable_clear_memory\": false,\n        \"memory_reachtop_check_interval\": 120,\n        \"memory_strategy\": 1,\n        \"enable_upload\": 1,\n        \"enable_widget_memory\": 1,\n        \"memory_suicide_interval\": 0,\n        \"rate_memory_occupied\": 80,\n        \"reach_top\": 0,\n        \"reach_top_memory_rate\": 0.8\n      },\n      \"smooth\": {\n        \"block_dump_stack_enable\": 1,\n        \"block_monitor_mode\": 1001,\n        \"block_threshold\": 2500,\n        \"block_enable_upload\": 1,\n        \"enable_upload\": 1,\n        \"drop_enable_upload\": 1,\n        \"drop_slow_method_switch\": true,\n        \"drop_threshold\": 1000,\n        \"serious_block_enable_upload\": 1,\n        \"serious_block_threshold\": 4000,\n        \"slow_method_enable_upload\": 1\n      },\n      \"start_trace\": {\n        \"enable_perf_data_collect\": 1,\n        \"update_as_first_launch\": 1,\n        \"enable_upload\": 1\n      },\n      \"page_load_trace\": {\n        \"enable_upload\": 1\n      },\n      \"thread\": {\n        \"collect_interval\": 20,\n        \"thread_collect_interval\": 20,\n        \"thread_count_threshold\": 200\n      },\n      \"user_indicator_module\": {\n        \"background_rate\": 0,\n        \"foreground_rate\": 0\n      },\n      \"traffic\": {\n        \"alog_record_threshold\": 100,\n        \"cause_analysis\": 1,\n        \"enable_collect\": 1,\n        \"enable_exception_collect\": 1,\n        \"enable_exception_upload\": 1,\n        \"enable_upload\": 1,\n        \"enable_upload_cause_analysis\": 1,\n        \"enable_upload_high_freq\": 1,\n        \"enable_upload_large_request\": 1,\n        \"exception_threshold_bg_mb\": 50,\n        \"exception_threshold_mb\": 500,\n        \"high_freq_threshold\": 200,\n        \"record_usage_kb\": 0,\n        \"large_usage_threshold_mb\": 10\n      }\n    },\n    \"tracing\": {\n      \"enable_open\": 1\n    },\n    \"custom_event_settings\": {\n      \"allow_service_name\":{\n        \"apmplus_activity_leak_switch\":1,\n        \"apmplus_activity_fixer_switch\":0\n      },\n      \"allow_log_type\":{\n        \"hybrid\":1,\n        \"hybrid_v2\":1\n      }\n    }\n  },\n  \"status\": \"ok\"\n}");
                                    jSONObjectOptJSONObject2 = jSONObject7.optJSONObject("ret");
                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("performance_modules");
                                    jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("general");
                                    jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("custom_event_settings");
                                    JSONObject jSONObjectOptJSONObject32 = jSONObjectOptJSONObject2.optJSONObject("network_image_modules");
                                    JSONObject jSONObjectOptJSONObject33 = jSONObjectOptJSONObject3.optJSONObject("smooth");
                                    JSONObject jSONObjectOptJSONObject34 = jSONObjectOptJSONObject3.optJSONObject("start_trace");
                                    JSONObject jSONObjectOptJSONObject35 = jSONObjectOptJSONObject3.optJSONObject("page_load_trace");
                                    JSONObject jSONObjectOptJSONObject36 = jSONObjectOptJSONObject3.optJSONObject("memory");
                                    jSONObjectOptJSONObject6 = jSONObjectOptJSONObject3.optJSONObject("battery");
                                    jSONObjectOptJSONObject7 = jSONObjectOptJSONObject3.optJSONObject("disk");
                                    jSONObjectOptJSONObject8 = jSONObjectOptJSONObject3.optJSONObject("traffic");
                                    jSONObjectOptJSONObject9 = jSONObjectOptJSONObject3.optJSONObject("user_indicator_module");
                                    jSONObject = new JSONObject();
                                    i9 = 2500;
                                    iOptDouble = 4000;
                                    iOptInt = 3600;
                                    iOptInt2 = 60;
                                    iOptInt3 = 100;
                                    if (jSONObjectOptJSONObject != null) {
                                        jSONObjectOptJSONObject12 = jSONObjectOptJSONObject.optJSONObject("lag_module");
                                        jSONObjectOptJSONObject13 = jSONObjectOptJSONObject.optJSONObject("experience_module");
                                        jSONObjectOptJSONObject14 = jSONObjectOptJSONObject.optJSONObject("memory_module");
                                        jSONObjectOptJSONObject15 = jSONObjectOptJSONObject.optJSONObject("over_all");
                                        jSONObjectOptJSONObject16 = jSONObjectOptJSONObject.optJSONObject("file_module");
                                        jSONObjectOptJSONObject17 = jSONObjectOptJSONObject.optJSONObject("page_analysis_module");
                                        jSONObjectOptJSONObject18 = jSONObjectOptJSONObject.optJSONObject("web_view_v2");
                                        jSONObjectOptJSONObject19 = jSONObjectOptJSONObject.optJSONObject("net_module");
                                        jSONObjectOptJSONObject20 = jSONObjectOptJSONObject.optJSONObject("event_module");
                                        jSONObjectOptJSONObject21 = jSONObjectOptJSONObject.optJSONObject("battery_module");
                                        jSONObjectOptJSONObject22 = jSONObjectOptJSONObject.optJSONObject("dart_module");
                                        jSONObjectOptJSONObject23 = jSONObjectOptJSONObject.optJSONObject("cpu_module");
                                        jSONObjectOptJSONObject24 = jSONObjectOptJSONObject.optJSONObject("disk_module");
                                        jSONObjectOptJSONObject25 = jSONObjectOptJSONObject.optJSONObject("traffic_module");
                                        jSONObjectOptJSONObject26 = jSONObjectOptJSONObject.optJSONObject("user_indicator_module");
                                        iOptInt10 = jSONObjectOptJSONObject.optInt("status", 0);
                                        if (iOptInt10 == 4) {
                                            p061i1.h.f19250x = false;
                                        } else {
                                            p061i1.h.f19250x = z8;
                                        }
                                        W1.b.a.f5047a.f5046a.edit().putInt("monitor_status_value", iOptInt10).apply();
                                        i53 = 30;
                                        int iOptInt35 = jSONObjectOptJSONObject.optInt("random_scatter_threshold", 30);
                                        if (jSONObjectOptJSONObject12 != null) {
                                            iOptInt34 = jSONObjectOptJSONObject12.optInt("switcher");
                                            int iOptInt36 = jSONObjectOptJSONObject12.optInt("lag_sampling_rate");
                                            z12 = z8;
                                            if (iOptInt34 == z12) {
                                                i59 = 0;
                                            } else {
                                                i59 = 0;
                                            }
                                            int iOptDouble2 = (int) (jSONObjectOptJSONObject12.optDouble("lag_threshold") * 1000.0d);
                                            int iOptDouble3 = (int) (jSONObjectOptJSONObject12.optDouble("block_max_time") * 1000.0d);
                                            iOptDouble = (int) (jSONObjectOptJSONObject12.optDouble("lag_serious_threshold") * 1000.0d);
                                            i9 = iOptDouble2;
                                            i54 = i59;
                                            i53 = iOptDouble3;
                                        } else {
                                            i54 = 0;
                                        }
                                        if (jSONObjectOptJSONObject13 != null) {
                                            iOptInt6 = jSONObjectOptJSONObject13.optInt("switcher");
                                            jSONObjectOptJSONObject30 = jSONObjectOptJSONObject13.optJSONObject("page_module");
                                            i55 = i53;
                                            if (jSONObjectOptJSONObject30 != null) {
                                                iOptInt33 = jSONObjectOptJSONObject30.optInt("page_sampling_rate");
                                            } else {
                                                iOptInt33 = 0;
                                            }
                                            jSONObjectOptJSONObject31 = jSONObjectOptJSONObject13.optJSONObject("startup_module");
                                            if (jSONObjectOptJSONObject31 != null) {
                                                iOptInt11 = jSONObjectOptJSONObject31.optInt("update_as_first_launch");
                                                i24 = iOptInt33;
                                                iOptInt7 = jSONObjectOptJSONObject31.optInt("startup_sampling_rate");
                                            } else {
                                                i24 = iOptInt33;
                                                iOptInt7 = 0;
                                                iOptInt11 = 1;
                                            }
                                        } else {
                                            i55 = i53;
                                            iOptInt7 = 0;
                                            iOptInt6 = 0;
                                            iOptInt11 = 1;
                                            i24 = 0;
                                        }
                                        if (jSONObjectOptJSONObject14 != null) {
                                            iOptInt9 = jSONObjectOptJSONObject14.optInt("switcher");
                                            iOptInt3 = jSONObjectOptJSONObject14.optInt("memory_rate");
                                            iOptInt13 = jSONObjectOptJSONObject14.optInt("oom_sampling_rate");
                                            iOptInt14 = jSONObjectOptJSONObject14.optInt("memory_metrics_sampling_rate");
                                            iOptInt15 = jSONObjectOptJSONObject14.optInt("leak_detect_sampling_rate");
                                            iOptInt12 = jSONObjectOptJSONObject14.optInt("leak_fixer_sampling_rate");
                                        } else {
                                            iOptInt12 = 0;
                                            iOptInt9 = 0;
                                            iOptInt13 = 0;
                                            iOptInt14 = 0;
                                            iOptInt15 = 1;
                                        }
                                        if (jSONObjectOptJSONObject15 != null) {
                                            iOptInt = jSONObjectOptJSONObject15.optInt("get_settings_interval");
                                            iOptInt2 = jSONObjectOptJSONObject15.optInt("uploading_interval");
                                        }
                                        if (jSONObjectOptJSONObject16 != null) {
                                            iOptInt17 = jSONObjectOptJSONObject16.optInt("switcher", 1);
                                            iOptInt16 = jSONObjectOptJSONObject16.optInt("alog_upload", 1);
                                            iOptInt18 = jSONObjectOptJSONObject16.optInt("enable_apmplus_alog", 0);
                                        } else {
                                            iOptInt16 = 1;
                                            iOptInt17 = 1;
                                            iOptInt18 = 0;
                                        }
                                        if (jSONObjectOptJSONObject17 != null) {
                                            iOptInt31 = jSONObjectOptJSONObject17.optInt("switcher");
                                            i56 = iOptInt16;
                                            jSONObjectOptJSONObject29 = jSONObjectOptJSONObject17.optJSONObject("web_view");
                                            if (jSONObjectOptJSONObject29 != null) {
                                                iOptInt32 = jSONObjectOptJSONObject29.optInt("web_view_sampling_rate");
                                                strOptString2 = jSONObjectOptJSONObject29.optString("key");
                                            } else {
                                                strOptString2 = null;
                                                iOptInt32 = 0;
                                            }
                                            if (!TextUtils.isEmpty(strOptString2)) {
                                                p061i1.h.t = strOptString2;
                                            }
                                            if (iOptInt31 != 1) {
                                            }
                                            if (jSONObjectOptJSONObject18 != null) {
                                                iOptInt29 = jSONObjectOptJSONObject18.optInt("switcher");
                                                jSONObjectOptJSONObject28 = jSONObjectOptJSONObject18.optJSONObject("web_view_v2");
                                                if (jSONObjectOptJSONObject28 != null) {
                                                    iOptInt30 = jSONObjectOptJSONObject28.optInt("web_view_v2_sampling_rate");
                                                } else {
                                                    iOptInt30 = 0;
                                                }
                                                if (iOptInt29 == 1) {
                                                    i58 = 0;
                                                } else {
                                                    i58 = 0;
                                                }
                                            } else {
                                                i58 = 0;
                                            }
                                            if (jSONObjectOptJSONObject19 != null) {
                                                iOptInt8 = jSONObjectOptJSONObject19.optInt("switcher");
                                                iOptInt4 = jSONObjectOptJSONObject19.optInt("net_sampling_rate");
                                                iOptInt20 = jSONObjectOptJSONObject19.optInt("no_net_server_collect_flag");
                                                strOptString = jSONObjectOptJSONObject19.optString("req_collect_filter");
                                                str7 = "ignore_neterror_sampling";
                                                iOptInt19 = jSONObjectOptJSONObject19.optInt(str7);
                                            } else {
                                                str7 = "ignore_neterror_sampling";
                                                strOptString = "";
                                                iOptInt19 = 0;
                                                iOptInt8 = 0;
                                                iOptInt4 = 0;
                                                iOptInt20 = 0;
                                            }
                                            i23 = i57;
                                            if (jSONObjectOptJSONObject20 != null) {
                                                iOptInt21 = jSONObjectOptJSONObject20.optInt("switcher");
                                                jSONObjectOptJSONObject27 = jSONObjectOptJSONObject20.optJSONObject("allow_event");
                                            } else {
                                                jSONObjectOptJSONObject27 = jSONObject;
                                                iOptInt21 = 0;
                                            }
                                            if (jSONObjectOptJSONObject21 != null) {
                                                iOptInt5 = jSONObjectOptJSONObject21.optInt("switcher");
                                                iOptInt23 = jSONObjectOptJSONObject21.optInt("battery_background_enable");
                                                iOptInt24 = jSONObjectOptJSONObject21.optInt("battery_enable_upload");
                                                iOptInt22 = jSONObjectOptJSONObject21.optInt("battery_sample_interval");
                                                jSONObject2 = jSONObjectOptJSONObject6;
                                                jSONObject2.put("exception_enable_upload", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                                                jSONObject2.put("trace_enable", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                                                jSONObject2.put("max_single_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_single_wake_lock_hold_time_second"));
                                                jSONObject2.put("max_total_wake_lock_acquire_count", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_acquire_count"));
                                                jSONObject2.put("max_total_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_hold_time_second"));
                                                jSONObject2.put("max_single_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_single_loc_request_time_second"));
                                                jSONObject2.put("max_total_loc_request_count", jSONObjectOptJSONObject21.optInt("max_total_loc_request_count"));
                                                jSONObject2.put("max_total_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_total_loc_request_time_second"));
                                                jSONObject2.put("max_wake_up_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_wake_up_alarm_invoke_count"));
                                                jSONObject2.put("max_normal_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_normal_alarm_invoke_count"));
                                            } else {
                                                jSONObject2 = jSONObjectOptJSONObject6;
                                                iOptInt22 = 5;
                                                iOptInt5 = 0;
                                                iOptInt23 = 0;
                                                iOptInt24 = 0;
                                            }
                                            if (jSONObjectOptJSONObject22 != null) {
                                                jSONObjectOptJSONObject2.put("dart_module", jSONObjectOptJSONObject22);
                                            }
                                            if (jSONObjectOptJSONObject23 != null) {
                                                iOptInt28 = jSONObjectOptJSONObject23.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt28 = 0;
                                                }
                                                i22 = i54;
                                                if (iOptInt28 == 1) {
                                                    jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                                                    str = "enable_upload";
                                                } else {
                                                    iOptInt6 = iOptInt6;
                                                    str = "enable_upload";
                                                    jSONObjectOptJSONObject23.put(str, 0);
                                                    jSONObjectOptJSONObject23.put("enable_open", 0);
                                                    jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                                                }
                                                if (jSONObjectOptJSONObject24 != null) {
                                                    iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                                                    if (!p061i1.h.f19250x) {
                                                        iOptInt27 = 0;
                                                    }
                                                    if (iOptInt27 != 1) {
                                                        jSONObjectOptJSONObject7.put(str, false);
                                                        jSONObjectOptJSONObject7.put("dump_switch", false);
                                                    } else {
                                                        if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                                                            z10 = true;
                                                        } else {
                                                            z10 = false;
                                                        }
                                                        jSONObjectOptJSONObject7.put(str, z10);
                                                        if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                                                            z11 = true;
                                                        } else {
                                                            z11 = false;
                                                        }
                                                        jSONObjectOptJSONObject7.put("dump_switch", z11);
                                                        jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                                                        jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                                                        jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                                                        jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                                                    }
                                                }
                                                if (jSONObjectOptJSONObject25 != null) {
                                                    iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                                                    if (!p061i1.h.f19250x) {
                                                        iOptInt26 = 0;
                                                    }
                                                    if (iOptInt26 != 1) {
                                                        jSONObjectOptJSONObject8.put("enable_collect", 0);
                                                        jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                                                    } else {
                                                        jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                                                        jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                                                        jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                                                        jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                                                        jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                                                    }
                                                }
                                                if (jSONObjectOptJSONObject26 != null) {
                                                    iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                                                    if (!p061i1.h.f19250x) {
                                                        iOptInt25 = 0;
                                                    }
                                                    if (iOptInt25 != 1) {
                                                        jSONObjectOptJSONObject9.put("background_rate", 0);
                                                        jSONObjectOptJSONObject9.put("foreground_rate", 0);
                                                    } else {
                                                        jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                                                        jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                                                    }
                                                }
                                                int i60 = iOptInt3;
                                                str2 = str7;
                                                i10 = i60;
                                                i31 = iOptDouble;
                                                i12 = iOptInt;
                                                i13 = iOptInt2;
                                                i19 = iOptInt20;
                                                i21 = iOptInt19;
                                                jSONObject3 = jSONObjectOptJSONObject27;
                                                str4 = strOptString;
                                                i16 = iOptInt13;
                                                i15 = iOptInt14;
                                                i28 = iOptInt15;
                                                i25 = iOptInt12;
                                                i27 = i56;
                                                i26 = iOptInt17;
                                                i18 = iOptInt23;
                                                i17 = iOptInt24;
                                                i34 = iOptInt18;
                                                i29 = iOptInt35;
                                                i30 = i9;
                                                i11 = i55;
                                                i33 = i58;
                                                str3 = "random_scatter_threshold";
                                                i20 = iOptInt21;
                                                i14 = iOptInt22;
                                                i32 = iOptInt11;
                                            } else {
                                                str = "enable_upload";
                                                i22 = i54;
                                            }
                                            if (jSONObjectOptJSONObject24 != null) {
                                                iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt27 = 0;
                                                }
                                                if (iOptInt27 != 1) {
                                                    jSONObjectOptJSONObject7.put(str, false);
                                                    jSONObjectOptJSONObject7.put("dump_switch", false);
                                                } else {
                                                    if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                                                        z10 = true;
                                                    } else {
                                                        z10 = false;
                                                    }
                                                    jSONObjectOptJSONObject7.put(str, z10);
                                                    if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    jSONObjectOptJSONObject7.put("dump_switch", z11);
                                                    jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                                                    jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                                                    jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                                                    jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                                                }
                                            }
                                            if (jSONObjectOptJSONObject25 != null) {
                                                iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt26 = 0;
                                                }
                                                if (iOptInt26 != 1) {
                                                    jSONObjectOptJSONObject8.put("enable_collect", 0);
                                                    jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                                                } else {
                                                    jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                                                    jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                                                    jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                                                    jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                                                    jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                                                }
                                            }
                                            if (jSONObjectOptJSONObject26 != null) {
                                                iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt25 = 0;
                                                }
                                                if (iOptInt25 != 1) {
                                                    jSONObjectOptJSONObject9.put("background_rate", 0);
                                                    jSONObjectOptJSONObject9.put("foreground_rate", 0);
                                                } else {
                                                    jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                                                    jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                                                }
                                            }
                                            int i61 = iOptInt3;
                                            str2 = str7;
                                            i10 = i61;
                                            i31 = iOptDouble;
                                            i12 = iOptInt;
                                            i13 = iOptInt2;
                                            i19 = iOptInt20;
                                            i21 = iOptInt19;
                                            jSONObject3 = jSONObjectOptJSONObject27;
                                            str4 = strOptString;
                                            i16 = iOptInt13;
                                            i15 = iOptInt14;
                                            i28 = iOptInt15;
                                            i25 = iOptInt12;
                                            i27 = i56;
                                            i26 = iOptInt17;
                                            i18 = iOptInt23;
                                            i17 = iOptInt24;
                                            i34 = iOptInt18;
                                            i29 = iOptInt35;
                                            i30 = i9;
                                            i11 = i55;
                                            i33 = i58;
                                            str3 = "random_scatter_threshold";
                                            i20 = iOptInt21;
                                            i14 = iOptInt22;
                                            i32 = iOptInt11;
                                        } else {
                                            i56 = iOptInt16;
                                            iOptInt17 = iOptInt17;
                                        }
                                        i57 = 0;
                                        if (jSONObjectOptJSONObject18 != null) {
                                            iOptInt29 = jSONObjectOptJSONObject18.optInt("switcher");
                                            jSONObjectOptJSONObject28 = jSONObjectOptJSONObject18.optJSONObject("web_view_v2");
                                            if (jSONObjectOptJSONObject28 != null) {
                                                iOptInt30 = jSONObjectOptJSONObject28.optInt("web_view_v2_sampling_rate");
                                            } else {
                                                iOptInt30 = 0;
                                            }
                                            if (iOptInt29 == 1) {
                                                i58 = 0;
                                            } else {
                                                i58 = 0;
                                            }
                                        } else {
                                            i58 = 0;
                                        }
                                        if (jSONObjectOptJSONObject19 != null) {
                                            iOptInt8 = jSONObjectOptJSONObject19.optInt("switcher");
                                            iOptInt4 = jSONObjectOptJSONObject19.optInt("net_sampling_rate");
                                            iOptInt20 = jSONObjectOptJSONObject19.optInt("no_net_server_collect_flag");
                                            strOptString = jSONObjectOptJSONObject19.optString("req_collect_filter");
                                            str7 = "ignore_neterror_sampling";
                                            iOptInt19 = jSONObjectOptJSONObject19.optInt(str7);
                                        } else {
                                            str7 = "ignore_neterror_sampling";
                                            strOptString = "";
                                            iOptInt19 = 0;
                                            iOptInt8 = 0;
                                            iOptInt4 = 0;
                                            iOptInt20 = 0;
                                        }
                                        i23 = i57;
                                        if (jSONObjectOptJSONObject20 != null) {
                                            iOptInt21 = jSONObjectOptJSONObject20.optInt("switcher");
                                            jSONObjectOptJSONObject27 = jSONObjectOptJSONObject20.optJSONObject("allow_event");
                                        } else {
                                            jSONObjectOptJSONObject27 = jSONObject;
                                            iOptInt21 = 0;
                                        }
                                        if (jSONObjectOptJSONObject21 != null) {
                                            iOptInt5 = jSONObjectOptJSONObject21.optInt("switcher");
                                            iOptInt23 = jSONObjectOptJSONObject21.optInt("battery_background_enable");
                                            iOptInt24 = jSONObjectOptJSONObject21.optInt("battery_enable_upload");
                                            iOptInt22 = jSONObjectOptJSONObject21.optInt("battery_sample_interval");
                                            jSONObject2 = jSONObjectOptJSONObject6;
                                            jSONObject2.put("exception_enable_upload", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                                            jSONObject2.put("trace_enable", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                                            jSONObject2.put("max_single_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_single_wake_lock_hold_time_second"));
                                            jSONObject2.put("max_total_wake_lock_acquire_count", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_acquire_count"));
                                            jSONObject2.put("max_total_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_hold_time_second"));
                                            jSONObject2.put("max_single_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_single_loc_request_time_second"));
                                            jSONObject2.put("max_total_loc_request_count", jSONObjectOptJSONObject21.optInt("max_total_loc_request_count"));
                                            jSONObject2.put("max_total_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_total_loc_request_time_second"));
                                            jSONObject2.put("max_wake_up_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_wake_up_alarm_invoke_count"));
                                            jSONObject2.put("max_normal_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_normal_alarm_invoke_count"));
                                        } else {
                                            jSONObject2 = jSONObjectOptJSONObject6;
                                            iOptInt22 = 5;
                                            iOptInt5 = 0;
                                            iOptInt23 = 0;
                                            iOptInt24 = 0;
                                        }
                                        if (jSONObjectOptJSONObject22 != null) {
                                            jSONObjectOptJSONObject2.put("dart_module", jSONObjectOptJSONObject22);
                                        }
                                        if (jSONObjectOptJSONObject23 != null) {
                                            iOptInt28 = jSONObjectOptJSONObject23.optInt("switcher");
                                            if (!p061i1.h.f19250x) {
                                                iOptInt28 = 0;
                                            }
                                            i22 = i54;
                                            if (iOptInt28 == 1) {
                                                jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                                                str = "enable_upload";
                                            } else {
                                                iOptInt6 = iOptInt6;
                                                str = "enable_upload";
                                                jSONObjectOptJSONObject23.put(str, 0);
                                                jSONObjectOptJSONObject23.put("enable_open", 0);
                                                jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                                            }
                                            if (jSONObjectOptJSONObject24 != null) {
                                                iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt27 = 0;
                                                }
                                                if (iOptInt27 != 1) {
                                                    jSONObjectOptJSONObject7.put(str, false);
                                                    jSONObjectOptJSONObject7.put("dump_switch", false);
                                                } else {
                                                    if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                                                        z10 = true;
                                                    } else {
                                                        z10 = false;
                                                    }
                                                    jSONObjectOptJSONObject7.put(str, z10);
                                                    if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    jSONObjectOptJSONObject7.put("dump_switch", z11);
                                                    jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                                                    jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                                                    jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                                                    jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                                                }
                                            }
                                            if (jSONObjectOptJSONObject25 != null) {
                                                iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt26 = 0;
                                                }
                                                if (iOptInt26 != 1) {
                                                    jSONObjectOptJSONObject8.put("enable_collect", 0);
                                                    jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                                                } else {
                                                    jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                                                    jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                                                    jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                                                    jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                                                    jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                                                }
                                            }
                                            if (jSONObjectOptJSONObject26 != null) {
                                                iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                                                if (!p061i1.h.f19250x) {
                                                    iOptInt25 = 0;
                                                }
                                                if (iOptInt25 != 1) {
                                                    jSONObjectOptJSONObject9.put("background_rate", 0);
                                                    jSONObjectOptJSONObject9.put("foreground_rate", 0);
                                                } else {
                                                    jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                                                    jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                                                }
                                            }
                                            int i62 = iOptInt3;
                                            str2 = str7;
                                            i10 = i62;
                                            i31 = iOptDouble;
                                            i12 = iOptInt;
                                            i13 = iOptInt2;
                                            i19 = iOptInt20;
                                            i21 = iOptInt19;
                                            jSONObject3 = jSONObjectOptJSONObject27;
                                            str4 = strOptString;
                                            i16 = iOptInt13;
                                            i15 = iOptInt14;
                                            i28 = iOptInt15;
                                            i25 = iOptInt12;
                                            i27 = i56;
                                            i26 = iOptInt17;
                                            i18 = iOptInt23;
                                            i17 = iOptInt24;
                                            i34 = iOptInt18;
                                            i29 = iOptInt35;
                                            i30 = i9;
                                            i11 = i55;
                                            i33 = i58;
                                            str3 = "random_scatter_threshold";
                                            i20 = iOptInt21;
                                            i14 = iOptInt22;
                                            i32 = iOptInt11;
                                        } else {
                                            str = "enable_upload";
                                            i22 = i54;
                                        }
                                        if (jSONObjectOptJSONObject24 != null) {
                                            iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                                            if (!p061i1.h.f19250x) {
                                                iOptInt27 = 0;
                                            }
                                            if (iOptInt27 != 1) {
                                                jSONObjectOptJSONObject7.put(str, false);
                                                jSONObjectOptJSONObject7.put("dump_switch", false);
                                            } else {
                                                if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                                                    z10 = true;
                                                } else {
                                                    z10 = false;
                                                }
                                                jSONObjectOptJSONObject7.put(str, z10);
                                                if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                jSONObjectOptJSONObject7.put("dump_switch", z11);
                                                jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                                                jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                                                jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                                                jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                                            }
                                        }
                                        if (jSONObjectOptJSONObject25 != null) {
                                            iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                                            if (!p061i1.h.f19250x) {
                                                iOptInt26 = 0;
                                            }
                                            if (iOptInt26 != 1) {
                                                jSONObjectOptJSONObject8.put("enable_collect", 0);
                                                jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                                            } else {
                                                jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                                                jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                                                jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                                                jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                                                jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                                            }
                                        }
                                        if (jSONObjectOptJSONObject26 != null) {
                                            iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                                            if (!p061i1.h.f19250x) {
                                                iOptInt25 = 0;
                                            }
                                            if (iOptInt25 != 1) {
                                                jSONObjectOptJSONObject9.put("background_rate", 0);
                                                jSONObjectOptJSONObject9.put("foreground_rate", 0);
                                            } else {
                                                jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                                                jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                                            }
                                        }
                                        int i63 = iOptInt3;
                                        str2 = str7;
                                        i10 = i63;
                                        i31 = iOptDouble;
                                        i12 = iOptInt;
                                        i13 = iOptInt2;
                                        i19 = iOptInt20;
                                        i21 = iOptInt19;
                                        jSONObject3 = jSONObjectOptJSONObject27;
                                        str4 = strOptString;
                                        i16 = iOptInt13;
                                        i15 = iOptInt14;
                                        i28 = iOptInt15;
                                        i25 = iOptInt12;
                                        i27 = i56;
                                        i26 = iOptInt17;
                                        i18 = iOptInt23;
                                        i17 = iOptInt24;
                                        i34 = iOptInt18;
                                        i29 = iOptInt35;
                                        i30 = i9;
                                        i11 = i55;
                                        i33 = i58;
                                        str3 = "random_scatter_threshold";
                                        i20 = iOptInt21;
                                        i14 = iOptInt22;
                                        i32 = iOptInt11;
                                    } else {
                                        jSONObject2 = jSONObjectOptJSONObject6;
                                        str = "enable_upload";
                                        str2 = "ignore_neterror_sampling";
                                        i10 = 100;
                                        i11 = 30;
                                        str3 = "random_scatter_threshold";
                                        jSONObject3 = jSONObject;
                                        str4 = "";
                                        i12 = 3600;
                                        i13 = 60;
                                        i14 = 5;
                                        i15 = 0;
                                        i16 = 0;
                                        i17 = 0;
                                        i18 = 0;
                                        i19 = 0;
                                        iOptInt4 = 0;
                                        i20 = 0;
                                        iOptInt5 = 0;
                                        i21 = 0;
                                        iOptInt6 = 0;
                                        i22 = 0;
                                        i23 = 0;
                                        i24 = 0;
                                        iOptInt7 = 0;
                                        iOptInt8 = 0;
                                        iOptInt9 = 0;
                                        i25 = 0;
                                        i26 = 1;
                                        i27 = 1;
                                        i28 = 1;
                                        i29 = 30;
                                        i30 = 2500;
                                        i31 = 4000;
                                        i32 = 1;
                                        i33 = 0;
                                        i34 = 0;
                                    }
                                    if (p061i1.h.f19250x) {
                                        i19 = i19;
                                        iOptInt4 = iOptInt4;
                                        i35 = i20;
                                        i36 = i33;
                                        i37 = iOptInt6;
                                        i38 = i22;
                                        i39 = i23;
                                        i40 = i24;
                                        i41 = iOptInt7;
                                        i42 = iOptInt8;
                                        i43 = iOptInt9;
                                    } else {
                                        if (p061i1.h.f19230b) {
                                            Log.d("ApmInsight", p199z2.b.f(new String[]{"can not report,close settings"}));
                                        }
                                        i40 = 0;
                                        i37 = 0;
                                        i41 = 0;
                                        i38 = 0;
                                        i43 = 0;
                                        iOptInt5 = 0;
                                        i42 = 0;
                                        i35 = 0;
                                        i39 = 0;
                                        i36 = 0;
                                    }
                                    int i64 = i17;
                                    jSONObjectOptJSONObject33.put("block_enable_upload", i38);
                                    jSONObjectOptJSONObject33.put("serious_block_enable_upload", i38);
                                    if (i41 == 1) {
                                        i44 = 0;
                                    } else {
                                        i44 = 0;
                                    }
                                    jSONObjectOptJSONObject34.put(str, i44);
                                    if (i43 == 1) {
                                        i45 = 0;
                                    } else {
                                        i45 = 0;
                                    }
                                    jSONObjectOptJSONObject36.put(str, i45);
                                    if (i43 == 1) {
                                        i46 = 0;
                                    } else {
                                        i46 = 0;
                                    }
                                    jSONObjectOptJSONObject36.put("enable_widget_memory", i46);
                                    jSONObjectOptJSONObject36.put("rate_memory_occupied", i10);
                                    jSONObjectOptJSONObject33.put("block_threshold", i30);
                                    jSONObjectOptJSONObject33.put("block_max_time", i11);
                                    jSONObjectOptJSONObject33.put("serious_block_threshold", i31);
                                    if (i40 == 1) {
                                        i47 = 0;
                                    } else {
                                        i47 = 0;
                                    }
                                    jSONObjectOptJSONObject35.put(str, i47);
                                    if (i40 == 1) {
                                        i48 = 0;
                                    } else {
                                        i48 = 0;
                                    }
                                    jSONObjectOptJSONObject33.put(str, i48);
                                    if (i40 == 1) {
                                        i49 = 0;
                                    } else {
                                        i49 = 0;
                                    }
                                    jSONObjectOptJSONObject33.put("drop_enable_upload", i49);
                                    jSONObjectOptJSONObject34.put("update_as_first_launch", i32);
                                    if (iOptInt5 == 1) {
                                        i50 = 0;
                                    } else {
                                        i50 = 0;
                                    }
                                    JSONObject jSONObject8 = jSONObject2;
                                    jSONObject8.put(str, i50);
                                    jSONObject8.put("sample_interval", i14);
                                    jSONObject8.put("background_enable", i18);
                                    JSONObject jSONObjectOptJSONObject37 = jSONObjectOptJSONObject32.optJSONObject("network");
                                    jSONObjectOptJSONObject37.put("enable_net_monitor", i42);
                                    jSONObjectOptJSONObject37.put("enable_success_net_sample", iOptInt4);
                                    jSONObjectOptJSONObject37.put("enable_net_monitor_with_net_disable", i19);
                                    jSONObjectOptJSONObject37.put(str2, i21);
                                    jSONObjectOptJSONObject37.put("filter_info", str4);
                                    str5 = "fetch_setting";
                                    try {
                                        jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str5).put("fetch_setting_interval", i12);
                                    } catch (Exception unused) {
                                    }
                                    jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str5).put(str3, i29);
                                    str6 = "report_setting";
                                    try {
                                        jSONObjectOptJSONObject11 = jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str6);
                                        i51 = i13;
                                        if (i51 > 10) {
                                            jSONObjectOptJSONObject11.put("apm6_uploading_interval", i51);
                                            jSONObjectOptJSONObject11.put("uploading_interval_background", i51);
                                            jSONObjectOptJSONObject11.put("uploading_interval", i51);
                                        }
                                        i52 = i26;
                                        if (i52 == 1) {
                                            z9 = false;
                                            jSONObjectOptJSONObject4.put("enable_active_upload_alog", false);
                                        } else {
                                            z9 = false;
                                            jSONObjectOptJSONObject4.put("enable_active_upload_alog", false);
                                        }
                                        if (i52 == 1) {
                                            jSONObjectOptJSONObject4.put("enable_apmplus_alog", z9);
                                        } else {
                                            jSONObjectOptJSONObject4.put("enable_apmplus_alog", z9);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                    Application application = p061i1.h.f19229a;
                                    if (i35 == 1) {
                                        jSONObject4 = jSONObjectOptJSONObject5;
                                        try {
                                            jSONObject4.put("allow_service_name", jSONObject3);
                                        } catch (Exception unused3) {
                                        }
                                    } else {
                                        jSONObject4 = jSONObjectOptJSONObject5;
                                    }
                                    jSONObject4.optJSONObject("allow_service_name").put("apmplus_activity_leak_switch", i28);
                                    jSONObject4.optJSONObject("allow_service_name").put("apmplus_activity_fixer_switch", i25);
                                    jSONObject4.optJSONObject("allow_log_type").put("hybrid", i39);
                                    jSONObject4.optJSONObject("allow_log_type").put("hybrid_v2", i36);
                                    if (p061i1.h.f19230b) {
                                        jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str6).put("enable_encrypt", jSONObjectD.optBoolean("enable_encrypt", true));
                                    }
                                    jSONObjectOptJSONObject10 = jSONObject7.optJSONObject("ret");
                                    this.f3174l = false;
                                    c(jSONObjectOptJSONObject10);
                                    copyOnWriteArrayList = this.f3181s;
                                    if (copyOnWriteArrayList != null) {
                                        it = copyOnWriteArrayList.iterator();
                                        while (it.hasNext()) {
                                            ((p175w3.a) it.next()).onRefresh(jSONObjectOptJSONObject10, false);
                                        }
                                    }
                                    f();
                                    this.f3175m = System.currentTimeMillis();
                                    p061i1.h.b("config_time", this.f3175m + "");
                                    N2.a.f3197Z = this.f3175m;
                                    JSONObject jSONObjectOptJSONObject38 = jSONObject7.optJSONObject("ret");
                                    String strOptString3 = jSONObject7.optString(MTCommonConstants.Network.KEY_NAME);
                                    SharedPreferences.Editor editorEdit = this.f3172i.edit();
                                    editorEdit.putString("monitor_net_config", jSONObjectOptJSONObject38.toString());
                                    editorEdit.putInt("setting_version", 3);
                                    editorEdit.putString("monitor_net_config_name", strOptString3);
                                    editorEdit.putLong("monitor_configure_refresh_time", this.f3175m);
                                    editorEdit.commit();
                                    p133r2.b.f21107i.b(new g(0), 1000L);
                                    return true;
                                }
                            }
                            z8 = true;
                        } catch (JSONException e10) {
                            e = e10;
                            z8 = true;
                        }
                        sb.append(jSONObject6.toString());
                        Log.d("ApmInsight", p199z2.b.f(new String[]{sb.toString()}));
                    } catch (Exception unused4) {
                    }
                }
            } catch (Exception unused5) {
            }
        } else {
            z8 = true;
        }
        try {
            if (jSONObject5.optInt("error_no") != 0 || (jSONArrayOptJSONArray = jSONObject5.optJSONArray("data")) == null || jSONArrayOptJSONArray.length() <= 0) {
                jSONObjectOptJSONObject = null;
                break;
            }
            int i65 = 0;
            while (true) {
                if (i65 >= jSONArrayOptJSONArray.length()) {
                    jSONObjectOptJSONObject = null;
                    break;
                }
                JSONObject jSONObjectOptJSONObject39 = jSONArrayOptJSONArray.optJSONObject(i65);
                if (jSONObjectOptJSONObject39 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject39.optJSONObject(p061i1.h.d().getString("aid"))) != null) {
                    break;
                }
                i65++;
            }
        } catch (Exception unused6) {
        }
        JSONObject jSONObject9 = new JSONObject("{\n  \"ret\": {\n    \"custom_event_settings\": {\n      \"max_utm_thread_ignore\": [],\n      \"npth_simple_setting\": {\n        \"anr_atribute_long_message_time\": 1000,\n        \"crash_limit_all\": 100,\n        \"crash_limit_issue\": 50,\n        \"max_utm_thread_ignore\": [\n          \"1\",\n          \"^main$\",\n          \"^default_npth_thread$\",\n          \"^RenderThread$\",\n          \"^Jit thread pool worker thread.*$\"\n        ],\n        \"native_heap_collect_size_mb\": 500,\n        \"native_heap_poll_seconds\": 60,\n        \"native_heap_water_line_mb\": 300,\n        \"upload_core_dump\": 1\n      }\n    },\n    \"exception_modules\": {\n      \"exception\": {\n        \"crash_limit_all\": 200,\n        \"crash_limit_issue\": 50\n      },\n      \"npth\": \"\",\n      \"npth_config\": \"\",\n      \"oom_callback\": 1,\n      \"tset\": {\n        \"555\": 5,\n        \"coredump_types\": {\n          \"disable\": [],\n          \"enable\": {\n            \"header_os_api\": {\n              \"in\": []\n            }\n          }\n        },\n        \"npth\": \"\",\n        \"t1\": 1,\n        \"t2\": 2,\n        \"t3\": 1,\n        \"t4\": 3,\n        \"t5\": 2,\n        \"t6\": 3,\n        \"test\": 3,\n        \"test1\": 1,\n        \"test2\": \"\"\n      },\n      \"tt\": 1\n    },\n    \"general\": {\n      \"cleanup\": {\n        \"log_max_size_mb\": 50,\n        \"log_reserve_days\": 5\n      },\n      \"enable_active_upload_alog\": true,\n      \"slardar_api_settings\": {\n        \"fetch_setting\": {\n          \"fetch_setting_interval\": 3600\n        },\n        \"report_setting\": {\n          \"base_polling_interval_seconds\": 30,\n          \"apm6_uploading_interval\": 60,\n          \"enable_encrypt\": true,\n          \"hosts\": [],\n          \"local_monitor_min_free_disk_mb\": 150,\n          \"local_monitor_switch\": true,\n          \"log_remove_switch\": false,\n          \"low_memory_threshold_kb\": 20480,\n          \"max_retry_count\": 4,\n          \"memory_store_cache_max_count\": 500,\n          \"more_channel_stop_interval\": 15,\n          \"once_max_count\": 100,\n          \"once_max_count_degrade\": 10,\n          \"once_max_size_kb\": 500,\n          \"report_fail_base_interval\": 15,\n          \"uploading_interval\": 30,\n          \"uploading_interval_background\": 30\n        }\n      }\n    },\n    \"network_image_modules\": {\n      \"image\": {\n        \"enable_upload\": 1,\n        \"image_sample_interval\": 120,\n        \"image_sla_switch\": false\n      },\n      \"network\": {\n        \"filter_info\": \"\",\n        \"enable_success_net_sample\": 1,\n        \"enable_net_monitor\": 1,\n        \"enable_net_monitor_with_net_disable\": 1\n      }\n    },\n    \"performance_modules\": {\n      \"battery\": {\n        \"enable_upload\": 0,\n        \"sample_interval\": 5,\n        \"background_enable\": 0,\n        \"trace_enable\": 1,\n        \"exception_enable_upload\": 1,\n        \"max_normal_alarm_invoke_count\": 10,\n        \"max_single_loc_request_time_second\": 120,\n        \"max_single_wake_lock_hold_time_second\": 120,\n        \"max_total_loc_request_count\": 5,\n        \"max_total_loc_request_time_second\": 240,\n        \"max_total_wake_lock_acquire_count\": 5,\n        \"max_total_wake_lock_hold_time_second\": 240,\n        \"max_wake_up_alarm_invoke_count\": 5\n      },\n      \"cpu\": {\n        \"enable_upload\": 0,\n        \"front_collect_interval\": 120,\n        \"back_collect_interval\": 600,\n        \"monitor_interval\": 120,\n        \"enable_open\": 0,\n        \"exception_process_back_max_speed\": 3,\n        \"exception_thread_max_usage\": 0.05,\n        \"exception_collect_all_process\": 1,\n        \"main_thread_collect_enabled\": 1,\n        \"exception_process_fore_max_speed\": 6\n      },\n      \"disk\": {\n        \"enable_upload\": 1,\n        \"abnormal_folder_size\": 20,\n        \"disk_customed_paths\": {\n        },\n        \"dump_switch\": true,\n        \"dump_threshold\": 100,\n        \"dump_top_count\": 20,\n        \"ignored_relative_paths\": [],\n        \"outdated_days\": 30,\n        \"outdated_size_threshold\": 1000\n      },\n      \"fd\": {\n        \"collect_interval\": 20,\n        \"fd_collect_interval\": 20,\n        \"fd_count_threshold\": 800\n      },\n      \"memory\": {\n        \"collect_interval\": 120,\n        \"enable_clear_memory\": false,\n        \"memory_reachtop_check_interval\": 120,\n        \"memory_strategy\": 1,\n        \"enable_upload\": 1,\n        \"enable_widget_memory\": 1,\n        \"memory_suicide_interval\": 0,\n        \"rate_memory_occupied\": 80,\n        \"reach_top\": 0,\n        \"reach_top_memory_rate\": 0.8\n      },\n      \"smooth\": {\n        \"block_dump_stack_enable\": 1,\n        \"block_monitor_mode\": 1001,\n        \"block_threshold\": 2500,\n        \"block_enable_upload\": 1,\n        \"enable_upload\": 1,\n        \"drop_enable_upload\": 1,\n        \"drop_slow_method_switch\": true,\n        \"drop_threshold\": 1000,\n        \"serious_block_enable_upload\": 1,\n        \"serious_block_threshold\": 4000,\n        \"slow_method_enable_upload\": 1\n      },\n      \"start_trace\": {\n        \"enable_perf_data_collect\": 1,\n        \"update_as_first_launch\": 1,\n        \"enable_upload\": 1\n      },\n      \"page_load_trace\": {\n        \"enable_upload\": 1\n      },\n      \"thread\": {\n        \"collect_interval\": 20,\n        \"thread_collect_interval\": 20,\n        \"thread_count_threshold\": 200\n      },\n      \"user_indicator_module\": {\n        \"background_rate\": 0,\n        \"foreground_rate\": 0\n      },\n      \"traffic\": {\n        \"alog_record_threshold\": 100,\n        \"cause_analysis\": 1,\n        \"enable_collect\": 1,\n        \"enable_exception_collect\": 1,\n        \"enable_exception_upload\": 1,\n        \"enable_upload\": 1,\n        \"enable_upload_cause_analysis\": 1,\n        \"enable_upload_high_freq\": 1,\n        \"enable_upload_large_request\": 1,\n        \"exception_threshold_bg_mb\": 50,\n        \"exception_threshold_mb\": 500,\n        \"high_freq_threshold\": 200,\n        \"record_usage_kb\": 0,\n        \"large_usage_threshold_mb\": 10\n      }\n    },\n    \"tracing\": {\n      \"enable_open\": 1\n    },\n    \"custom_event_settings\": {\n      \"allow_service_name\":{\n        \"apmplus_activity_leak_switch\":1,\n        \"apmplus_activity_fixer_switch\":0\n      },\n      \"allow_log_type\":{\n        \"hybrid\":1,\n        \"hybrid_v2\":1\n      }\n    }\n  },\n  \"status\": \"ok\"\n}");
        jSONObjectOptJSONObject2 = jSONObject9.optJSONObject("ret");
        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("performance_modules");
        jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("general");
        jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("custom_event_settings");
        JSONObject jSONObjectOptJSONObject310 = jSONObjectOptJSONObject2.optJSONObject("network_image_modules");
        JSONObject jSONObjectOptJSONObject311 = jSONObjectOptJSONObject3.optJSONObject("smooth");
        JSONObject jSONObjectOptJSONObject312 = jSONObjectOptJSONObject3.optJSONObject("start_trace");
        JSONObject jSONObjectOptJSONObject313 = jSONObjectOptJSONObject3.optJSONObject("page_load_trace");
        JSONObject jSONObjectOptJSONObject314 = jSONObjectOptJSONObject3.optJSONObject("memory");
        jSONObjectOptJSONObject6 = jSONObjectOptJSONObject3.optJSONObject("battery");
        jSONObjectOptJSONObject7 = jSONObjectOptJSONObject3.optJSONObject("disk");
        jSONObjectOptJSONObject8 = jSONObjectOptJSONObject3.optJSONObject("traffic");
        jSONObjectOptJSONObject9 = jSONObjectOptJSONObject3.optJSONObject("user_indicator_module");
        jSONObject = new JSONObject();
        i9 = 2500;
        iOptDouble = 4000;
        iOptInt = 3600;
        iOptInt2 = 60;
        iOptInt3 = 100;
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject12 = jSONObjectOptJSONObject.optJSONObject("lag_module");
            jSONObjectOptJSONObject13 = jSONObjectOptJSONObject.optJSONObject("experience_module");
            jSONObjectOptJSONObject14 = jSONObjectOptJSONObject.optJSONObject("memory_module");
            jSONObjectOptJSONObject15 = jSONObjectOptJSONObject.optJSONObject("over_all");
            jSONObjectOptJSONObject16 = jSONObjectOptJSONObject.optJSONObject("file_module");
            jSONObjectOptJSONObject17 = jSONObjectOptJSONObject.optJSONObject("page_analysis_module");
            jSONObjectOptJSONObject18 = jSONObjectOptJSONObject.optJSONObject("web_view_v2");
            jSONObjectOptJSONObject19 = jSONObjectOptJSONObject.optJSONObject("net_module");
            jSONObjectOptJSONObject20 = jSONObjectOptJSONObject.optJSONObject("event_module");
            jSONObjectOptJSONObject21 = jSONObjectOptJSONObject.optJSONObject("battery_module");
            jSONObjectOptJSONObject22 = jSONObjectOptJSONObject.optJSONObject("dart_module");
            jSONObjectOptJSONObject23 = jSONObjectOptJSONObject.optJSONObject("cpu_module");
            jSONObjectOptJSONObject24 = jSONObjectOptJSONObject.optJSONObject("disk_module");
            jSONObjectOptJSONObject25 = jSONObjectOptJSONObject.optJSONObject("traffic_module");
            jSONObjectOptJSONObject26 = jSONObjectOptJSONObject.optJSONObject("user_indicator_module");
            iOptInt10 = jSONObjectOptJSONObject.optInt("status", 0);
            if (iOptInt10 == 4) {
                p061i1.h.f19250x = false;
            } else {
                p061i1.h.f19250x = z8;
            }
            W1.b.a.f5047a.f5046a.edit().putInt("monitor_status_value", iOptInt10).apply();
            i53 = 30;
            int iOptInt37 = jSONObjectOptJSONObject.optInt("random_scatter_threshold", 30);
            if (jSONObjectOptJSONObject12 != null) {
                iOptInt34 = jSONObjectOptJSONObject12.optInt("switcher");
                int iOptInt38 = jSONObjectOptJSONObject12.optInt("lag_sampling_rate");
                z12 = z8;
                if (iOptInt34 == z12 || iOptInt38 != z12) {
                    i59 = 0;
                } else {
                    i59 = 1;
                }
                int iOptDouble4 = (int) (jSONObjectOptJSONObject12.optDouble("lag_threshold") * 1000.0d);
                int iOptDouble5 = (int) (jSONObjectOptJSONObject12.optDouble("block_max_time") * 1000.0d);
                iOptDouble = (int) (jSONObjectOptJSONObject12.optDouble("lag_serious_threshold") * 1000.0d);
                i9 = iOptDouble4;
                i54 = i59;
                i53 = iOptDouble5;
            } else {
                i54 = 0;
            }
            if (jSONObjectOptJSONObject13 != null) {
                iOptInt6 = jSONObjectOptJSONObject13.optInt("switcher");
                jSONObjectOptJSONObject30 = jSONObjectOptJSONObject13.optJSONObject("page_module");
                i55 = i53;
                if (jSONObjectOptJSONObject30 != null) {
                    iOptInt33 = jSONObjectOptJSONObject30.optInt("page_sampling_rate");
                } else {
                    iOptInt33 = 0;
                }
                jSONObjectOptJSONObject31 = jSONObjectOptJSONObject13.optJSONObject("startup_module");
                if (jSONObjectOptJSONObject31 != null) {
                    iOptInt11 = jSONObjectOptJSONObject31.optInt("update_as_first_launch");
                    i24 = iOptInt33;
                    iOptInt7 = jSONObjectOptJSONObject31.optInt("startup_sampling_rate");
                } else {
                    i24 = iOptInt33;
                    iOptInt7 = 0;
                    iOptInt11 = 1;
                }
            } else {
                i55 = i53;
                iOptInt7 = 0;
                iOptInt6 = 0;
                iOptInt11 = 1;
                i24 = 0;
            }
            if (jSONObjectOptJSONObject14 != null) {
                iOptInt9 = jSONObjectOptJSONObject14.optInt("switcher");
                iOptInt3 = jSONObjectOptJSONObject14.optInt("memory_rate");
                iOptInt13 = jSONObjectOptJSONObject14.optInt("oom_sampling_rate");
                iOptInt14 = jSONObjectOptJSONObject14.optInt("memory_metrics_sampling_rate");
                iOptInt15 = jSONObjectOptJSONObject14.optInt("leak_detect_sampling_rate");
                iOptInt12 = jSONObjectOptJSONObject14.optInt("leak_fixer_sampling_rate");
            } else {
                iOptInt12 = 0;
                iOptInt9 = 0;
                iOptInt13 = 0;
                iOptInt14 = 0;
                iOptInt15 = 1;
            }
            if (jSONObjectOptJSONObject15 != null) {
                iOptInt = jSONObjectOptJSONObject15.optInt("get_settings_interval");
                iOptInt2 = jSONObjectOptJSONObject15.optInt("uploading_interval");
            }
            if (jSONObjectOptJSONObject16 != null) {
                iOptInt17 = jSONObjectOptJSONObject16.optInt("switcher", 1);
                iOptInt16 = jSONObjectOptJSONObject16.optInt("alog_upload", 1);
                iOptInt18 = jSONObjectOptJSONObject16.optInt("enable_apmplus_alog", 0);
            } else {
                iOptInt16 = 1;
                iOptInt17 = 1;
                iOptInt18 = 0;
            }
            if (jSONObjectOptJSONObject17 != null) {
                iOptInt31 = jSONObjectOptJSONObject17.optInt("switcher");
                i56 = iOptInt16;
                jSONObjectOptJSONObject29 = jSONObjectOptJSONObject17.optJSONObject("web_view");
                if (jSONObjectOptJSONObject29 != null) {
                    iOptInt32 = jSONObjectOptJSONObject29.optInt("web_view_sampling_rate");
                    strOptString2 = jSONObjectOptJSONObject29.optString("key");
                } else {
                    strOptString2 = null;
                    iOptInt32 = 0;
                }
                if (!TextUtils.isEmpty(strOptString2)) {
                    p061i1.h.t = strOptString2;
                }
                if (iOptInt31 != 1 && iOptInt32 == 1) {
                    i57 = 1;
                }
                if (jSONObjectOptJSONObject18 != null) {
                    iOptInt29 = jSONObjectOptJSONObject18.optInt("switcher");
                    jSONObjectOptJSONObject28 = jSONObjectOptJSONObject18.optJSONObject("web_view_v2");
                    if (jSONObjectOptJSONObject28 != null) {
                        iOptInt30 = jSONObjectOptJSONObject28.optInt("web_view_v2_sampling_rate");
                    } else {
                        iOptInt30 = 0;
                    }
                    if (iOptInt29 == 1 || iOptInt30 != 1) {
                        i58 = 0;
                    } else {
                        i58 = 1;
                    }
                } else {
                    i58 = 0;
                }
                if (jSONObjectOptJSONObject19 != null) {
                    iOptInt8 = jSONObjectOptJSONObject19.optInt("switcher");
                    iOptInt4 = jSONObjectOptJSONObject19.optInt("net_sampling_rate");
                    iOptInt20 = jSONObjectOptJSONObject19.optInt("no_net_server_collect_flag");
                    strOptString = jSONObjectOptJSONObject19.optString("req_collect_filter");
                    str7 = "ignore_neterror_sampling";
                    iOptInt19 = jSONObjectOptJSONObject19.optInt(str7);
                } else {
                    str7 = "ignore_neterror_sampling";
                    strOptString = "";
                    iOptInt19 = 0;
                    iOptInt8 = 0;
                    iOptInt4 = 0;
                    iOptInt20 = 0;
                }
                i23 = i57;
                if (jSONObjectOptJSONObject20 != null) {
                    iOptInt21 = jSONObjectOptJSONObject20.optInt("switcher");
                    jSONObjectOptJSONObject27 = jSONObjectOptJSONObject20.optJSONObject("allow_event");
                } else {
                    jSONObjectOptJSONObject27 = jSONObject;
                    iOptInt21 = 0;
                }
                if (jSONObjectOptJSONObject21 != null) {
                    iOptInt5 = jSONObjectOptJSONObject21.optInt("switcher");
                    iOptInt23 = jSONObjectOptJSONObject21.optInt("battery_background_enable");
                    iOptInt24 = jSONObjectOptJSONObject21.optInt("battery_enable_upload");
                    iOptInt22 = jSONObjectOptJSONObject21.optInt("battery_sample_interval");
                    jSONObject2 = jSONObjectOptJSONObject6;
                    jSONObject2.put("exception_enable_upload", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                    jSONObject2.put("trace_enable", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                    jSONObject2.put("max_single_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_single_wake_lock_hold_time_second"));
                    jSONObject2.put("max_total_wake_lock_acquire_count", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_acquire_count"));
                    jSONObject2.put("max_total_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_hold_time_second"));
                    jSONObject2.put("max_single_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_single_loc_request_time_second"));
                    jSONObject2.put("max_total_loc_request_count", jSONObjectOptJSONObject21.optInt("max_total_loc_request_count"));
                    jSONObject2.put("max_total_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_total_loc_request_time_second"));
                    jSONObject2.put("max_wake_up_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_wake_up_alarm_invoke_count"));
                    jSONObject2.put("max_normal_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_normal_alarm_invoke_count"));
                } else {
                    jSONObject2 = jSONObjectOptJSONObject6;
                    iOptInt22 = 5;
                    iOptInt5 = 0;
                    iOptInt23 = 0;
                    iOptInt24 = 0;
                }
                if (jSONObjectOptJSONObject22 != null) {
                    jSONObjectOptJSONObject2.put("dart_module", jSONObjectOptJSONObject22);
                }
                if (jSONObjectOptJSONObject23 != null) {
                    iOptInt28 = jSONObjectOptJSONObject23.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt28 = 0;
                    }
                    i22 = i54;
                    if (iOptInt28 == 1) {
                        jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                        str = "enable_upload";
                    } else {
                        iOptInt6 = iOptInt6;
                        str = "enable_upload";
                        jSONObjectOptJSONObject23.put(str, 0);
                        jSONObjectOptJSONObject23.put("enable_open", 0);
                        jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                    }
                    if (jSONObjectOptJSONObject24 != null) {
                        iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                        if (!p061i1.h.f19250x) {
                            iOptInt27 = 0;
                        }
                        if (iOptInt27 != 1) {
                            jSONObjectOptJSONObject7.put(str, false);
                            jSONObjectOptJSONObject7.put("dump_switch", false);
                        } else {
                            if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            jSONObjectOptJSONObject7.put(str, z10);
                            if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            jSONObjectOptJSONObject7.put("dump_switch", z11);
                            jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                            jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                            jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                            jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                        }
                    }
                    if (jSONObjectOptJSONObject25 != null) {
                        iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                        if (!p061i1.h.f19250x) {
                            iOptInt26 = 0;
                        }
                        if (iOptInt26 != 1) {
                            jSONObjectOptJSONObject8.put("enable_collect", 0);
                            jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                        } else {
                            jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                            jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                            jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                            jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                            jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                        }
                    }
                    if (jSONObjectOptJSONObject26 != null) {
                        iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                        if (!p061i1.h.f19250x) {
                            iOptInt25 = 0;
                        }
                        if (iOptInt25 != 1) {
                            jSONObjectOptJSONObject9.put("background_rate", 0);
                            jSONObjectOptJSONObject9.put("foreground_rate", 0);
                        } else {
                            jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                            jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                        }
                    }
                    int i66 = iOptInt3;
                    str2 = str7;
                    i10 = i66;
                    i31 = iOptDouble;
                    i12 = iOptInt;
                    i13 = iOptInt2;
                    i19 = iOptInt20;
                    i21 = iOptInt19;
                    jSONObject3 = jSONObjectOptJSONObject27;
                    str4 = strOptString;
                    i16 = iOptInt13;
                    i15 = iOptInt14;
                    i28 = iOptInt15;
                    i25 = iOptInt12;
                    i27 = i56;
                    i26 = iOptInt17;
                    i18 = iOptInt23;
                    i17 = iOptInt24;
                    i34 = iOptInt18;
                    i29 = iOptInt37;
                    i30 = i9;
                    i11 = i55;
                    i33 = i58;
                    str3 = "random_scatter_threshold";
                    i20 = iOptInt21;
                    i14 = iOptInt22;
                    i32 = iOptInt11;
                } else {
                    str = "enable_upload";
                    i22 = i54;
                }
                if (jSONObjectOptJSONObject24 != null) {
                    iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt27 = 0;
                    }
                    if (iOptInt27 != 1) {
                        jSONObjectOptJSONObject7.put(str, false);
                        jSONObjectOptJSONObject7.put("dump_switch", false);
                    } else {
                        if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        jSONObjectOptJSONObject7.put(str, z10);
                        if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        jSONObjectOptJSONObject7.put("dump_switch", z11);
                        jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                        jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                        jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                        jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                    }
                }
                if (jSONObjectOptJSONObject25 != null) {
                    iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt26 = 0;
                    }
                    if (iOptInt26 != 1) {
                        jSONObjectOptJSONObject8.put("enable_collect", 0);
                        jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                    } else {
                        jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                        jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                        jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                        jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                        jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                    }
                }
                if (jSONObjectOptJSONObject26 != null) {
                    iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt25 = 0;
                    }
                    if (iOptInt25 != 1) {
                        jSONObjectOptJSONObject9.put("background_rate", 0);
                        jSONObjectOptJSONObject9.put("foreground_rate", 0);
                    } else {
                        jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                        jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                    }
                }
                int i67 = iOptInt3;
                str2 = str7;
                i10 = i67;
                i31 = iOptDouble;
                i12 = iOptInt;
                i13 = iOptInt2;
                i19 = iOptInt20;
                i21 = iOptInt19;
                jSONObject3 = jSONObjectOptJSONObject27;
                str4 = strOptString;
                i16 = iOptInt13;
                i15 = iOptInt14;
                i28 = iOptInt15;
                i25 = iOptInt12;
                i27 = i56;
                i26 = iOptInt17;
                i18 = iOptInt23;
                i17 = iOptInt24;
                i34 = iOptInt18;
                i29 = iOptInt37;
                i30 = i9;
                i11 = i55;
                i33 = i58;
                str3 = "random_scatter_threshold";
                i20 = iOptInt21;
                i14 = iOptInt22;
                i32 = iOptInt11;
            } else {
                i56 = iOptInt16;
                iOptInt17 = iOptInt17;
            }
            i57 = 0;
            if (jSONObjectOptJSONObject18 != null) {
                iOptInt29 = jSONObjectOptJSONObject18.optInt("switcher");
                jSONObjectOptJSONObject28 = jSONObjectOptJSONObject18.optJSONObject("web_view_v2");
                if (jSONObjectOptJSONObject28 != null) {
                    iOptInt30 = jSONObjectOptJSONObject28.optInt("web_view_v2_sampling_rate");
                } else {
                    iOptInt30 = 0;
                }
                if (iOptInt29 == 1) {
                    i58 = 0;
                } else {
                    i58 = 0;
                }
            } else {
                i58 = 0;
            }
            if (jSONObjectOptJSONObject19 != null) {
                iOptInt8 = jSONObjectOptJSONObject19.optInt("switcher");
                iOptInt4 = jSONObjectOptJSONObject19.optInt("net_sampling_rate");
                iOptInt20 = jSONObjectOptJSONObject19.optInt("no_net_server_collect_flag");
                strOptString = jSONObjectOptJSONObject19.optString("req_collect_filter");
                str7 = "ignore_neterror_sampling";
                iOptInt19 = jSONObjectOptJSONObject19.optInt(str7);
            } else {
                str7 = "ignore_neterror_sampling";
                strOptString = "";
                iOptInt19 = 0;
                iOptInt8 = 0;
                iOptInt4 = 0;
                iOptInt20 = 0;
            }
            i23 = i57;
            if (jSONObjectOptJSONObject20 != null) {
                iOptInt21 = jSONObjectOptJSONObject20.optInt("switcher");
                jSONObjectOptJSONObject27 = jSONObjectOptJSONObject20.optJSONObject("allow_event");
            } else {
                jSONObjectOptJSONObject27 = jSONObject;
                iOptInt21 = 0;
            }
            if (jSONObjectOptJSONObject21 != null) {
                iOptInt5 = jSONObjectOptJSONObject21.optInt("switcher");
                iOptInt23 = jSONObjectOptJSONObject21.optInt("battery_background_enable");
                iOptInt24 = jSONObjectOptJSONObject21.optInt("battery_enable_upload");
                iOptInt22 = jSONObjectOptJSONObject21.optInt("battery_sample_interval");
                jSONObject2 = jSONObjectOptJSONObject6;
                jSONObject2.put("exception_enable_upload", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                jSONObject2.put("trace_enable", jSONObjectOptJSONObject21.optInt("exception_enable_upload"));
                jSONObject2.put("max_single_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_single_wake_lock_hold_time_second"));
                jSONObject2.put("max_total_wake_lock_acquire_count", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_acquire_count"));
                jSONObject2.put("max_total_wake_lock_hold_time_second", jSONObjectOptJSONObject21.optInt("max_total_wake_lock_hold_time_second"));
                jSONObject2.put("max_single_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_single_loc_request_time_second"));
                jSONObject2.put("max_total_loc_request_count", jSONObjectOptJSONObject21.optInt("max_total_loc_request_count"));
                jSONObject2.put("max_total_loc_request_time_second", jSONObjectOptJSONObject21.optInt("max_total_loc_request_time_second"));
                jSONObject2.put("max_wake_up_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_wake_up_alarm_invoke_count"));
                jSONObject2.put("max_normal_alarm_invoke_count", jSONObjectOptJSONObject21.optInt("max_normal_alarm_invoke_count"));
            } else {
                jSONObject2 = jSONObjectOptJSONObject6;
                iOptInt22 = 5;
                iOptInt5 = 0;
                iOptInt23 = 0;
                iOptInt24 = 0;
            }
            if (jSONObjectOptJSONObject22 != null) {
                jSONObjectOptJSONObject2.put("dart_module", jSONObjectOptJSONObject22);
            }
            if (jSONObjectOptJSONObject23 != null) {
                iOptInt28 = jSONObjectOptJSONObject23.optInt("switcher");
                if (!p061i1.h.f19250x) {
                    iOptInt28 = 0;
                }
                i22 = i54;
                if (iOptInt28 == 1) {
                    jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                    str = "enable_upload";
                } else {
                    iOptInt6 = iOptInt6;
                    str = "enable_upload";
                    jSONObjectOptJSONObject23.put(str, 0);
                    jSONObjectOptJSONObject23.put("enable_open", 0);
                    jSONObjectOptJSONObject3.put("cpu", jSONObjectOptJSONObject23);
                }
                if (jSONObjectOptJSONObject24 != null) {
                    iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt27 = 0;
                    }
                    if (iOptInt27 != 1) {
                        jSONObjectOptJSONObject7.put(str, false);
                        jSONObjectOptJSONObject7.put("dump_switch", false);
                    } else {
                        if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        jSONObjectOptJSONObject7.put(str, z10);
                        if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        jSONObjectOptJSONObject7.put("dump_switch", z11);
                        jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                        jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                        jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                        jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                    }
                }
                if (jSONObjectOptJSONObject25 != null) {
                    iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt26 = 0;
                    }
                    if (iOptInt26 != 1) {
                        jSONObjectOptJSONObject8.put("enable_collect", 0);
                        jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                    } else {
                        jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                        jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                        jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                        jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                        jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                    }
                }
                if (jSONObjectOptJSONObject26 != null) {
                    iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                    if (!p061i1.h.f19250x) {
                        iOptInt25 = 0;
                    }
                    if (iOptInt25 != 1) {
                        jSONObjectOptJSONObject9.put("background_rate", 0);
                        jSONObjectOptJSONObject9.put("foreground_rate", 0);
                    } else {
                        jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                        jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                    }
                }
                int i68 = iOptInt3;
                str2 = str7;
                i10 = i68;
                i31 = iOptDouble;
                i12 = iOptInt;
                i13 = iOptInt2;
                i19 = iOptInt20;
                i21 = iOptInt19;
                jSONObject3 = jSONObjectOptJSONObject27;
                str4 = strOptString;
                i16 = iOptInt13;
                i15 = iOptInt14;
                i28 = iOptInt15;
                i25 = iOptInt12;
                i27 = i56;
                i26 = iOptInt17;
                i18 = iOptInt23;
                i17 = iOptInt24;
                i34 = iOptInt18;
                i29 = iOptInt37;
                i30 = i9;
                i11 = i55;
                i33 = i58;
                str3 = "random_scatter_threshold";
                i20 = iOptInt21;
                i14 = iOptInt22;
                i32 = iOptInt11;
            } else {
                str = "enable_upload";
                i22 = i54;
            }
            if (jSONObjectOptJSONObject24 != null) {
                iOptInt27 = jSONObjectOptJSONObject24.optInt("switcher");
                if (!p061i1.h.f19250x) {
                    iOptInt27 = 0;
                }
                if (iOptInt27 != 1) {
                    jSONObjectOptJSONObject7.put(str, false);
                    jSONObjectOptJSONObject7.put("dump_switch", false);
                } else {
                    if (jSONObjectOptJSONObject24.optInt(str) == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    jSONObjectOptJSONObject7.put(str, z10);
                    if (jSONObjectOptJSONObject24.optInt("dump_switch") == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    jSONObjectOptJSONObject7.put("dump_switch", z11);
                    jSONObjectOptJSONObject7.put("dump_threshold", jSONObjectOptJSONObject24.optInt("dump_threshold"));
                    jSONObjectOptJSONObject7.put("abnormal_folder_size", jSONObjectOptJSONObject24.optInt("abnormal_folder_size"));
                    jSONObjectOptJSONObject7.put("dump_top_count", jSONObjectOptJSONObject24.optInt("dump_top_count"));
                    jSONObjectOptJSONObject7.put("outdated_days", jSONObjectOptJSONObject24.optInt("outdated_days"));
                }
            }
            if (jSONObjectOptJSONObject25 != null) {
                iOptInt26 = jSONObjectOptJSONObject25.optInt("switcher");
                if (!p061i1.h.f19250x) {
                    iOptInt26 = 0;
                }
                if (iOptInt26 != 1) {
                    jSONObjectOptJSONObject8.put("enable_collect", 0);
                    jSONObjectOptJSONObject8.put("enable_exception_collect", 0);
                } else {
                    jSONObjectOptJSONObject8.put("enable_collect", jSONObjectOptJSONObject25.optInt("enable_collect"));
                    jSONObjectOptJSONObject8.put("enable_exception_collect", jSONObjectOptJSONObject25.optInt("enable_exception_collect"));
                    jSONObjectOptJSONObject8.put("exception_threshold_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_mb"));
                    jSONObjectOptJSONObject8.put("exception_threshold_bg_mb", jSONObjectOptJSONObject25.optInt("exception_threshold_bg_mb"));
                    jSONObjectOptJSONObject8.put("record_usage_kb", jSONObjectOptJSONObject25.optInt("record_usage_kb"));
                }
            }
            if (jSONObjectOptJSONObject26 != null) {
                iOptInt25 = jSONObjectOptJSONObject26.optInt("switcher");
                if (!p061i1.h.f19250x) {
                    iOptInt25 = 0;
                }
                if (iOptInt25 != 1) {
                    jSONObjectOptJSONObject9.put("background_rate", 0);
                    jSONObjectOptJSONObject9.put("foreground_rate", 0);
                } else {
                    jSONObjectOptJSONObject9.put("background_rate", jSONObjectOptJSONObject26.optInt("background_rate"));
                    jSONObjectOptJSONObject9.put("foreground_rate", jSONObjectOptJSONObject26.optInt("foreground_rate"));
                }
            }
            int i69 = iOptInt3;
            str2 = str7;
            i10 = i69;
            i31 = iOptDouble;
            i12 = iOptInt;
            i13 = iOptInt2;
            i19 = iOptInt20;
            i21 = iOptInt19;
            jSONObject3 = jSONObjectOptJSONObject27;
            str4 = strOptString;
            i16 = iOptInt13;
            i15 = iOptInt14;
            i28 = iOptInt15;
            i25 = iOptInt12;
            i27 = i56;
            i26 = iOptInt17;
            i18 = iOptInt23;
            i17 = iOptInt24;
            i34 = iOptInt18;
            i29 = iOptInt37;
            i30 = i9;
            i11 = i55;
            i33 = i58;
            str3 = "random_scatter_threshold";
            i20 = iOptInt21;
            i14 = iOptInt22;
            i32 = iOptInt11;
        } else {
            jSONObject2 = jSONObjectOptJSONObject6;
            str = "enable_upload";
            str2 = "ignore_neterror_sampling";
            i10 = 100;
            i11 = 30;
            str3 = "random_scatter_threshold";
            jSONObject3 = jSONObject;
            str4 = "";
            i12 = 3600;
            i13 = 60;
            i14 = 5;
            i15 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            iOptInt4 = 0;
            i20 = 0;
            iOptInt5 = 0;
            i21 = 0;
            iOptInt6 = 0;
            i22 = 0;
            i23 = 0;
            i24 = 0;
            iOptInt7 = 0;
            iOptInt8 = 0;
            iOptInt9 = 0;
            i25 = 0;
            i26 = 1;
            i27 = 1;
            i28 = 1;
            i29 = 30;
            i30 = 2500;
            i31 = 4000;
            i32 = 1;
            i33 = 0;
            i34 = 0;
        }
        if (p061i1.h.f19250x) {
            if (p061i1.h.f19230b) {
                Log.d("ApmInsight", p199z2.b.f(new String[]{"can not report,close settings"}));
            }
            i40 = 0;
            i37 = 0;
            i41 = 0;
            i38 = 0;
            i43 = 0;
            iOptInt5 = 0;
            i42 = 0;
            i35 = 0;
            i39 = 0;
            i36 = 0;
        } else {
            i19 = i19;
            iOptInt4 = iOptInt4;
            i35 = i20;
            i36 = i33;
            i37 = iOptInt6;
            i38 = i22;
            i39 = i23;
            i40 = i24;
            i41 = iOptInt7;
            i42 = iOptInt8;
            i43 = iOptInt9;
        }
        int i610 = i17;
        jSONObjectOptJSONObject311.put("block_enable_upload", i38);
        jSONObjectOptJSONObject311.put("serious_block_enable_upload", i38);
        if (i41 == 1 || i37 != 1) {
            i44 = 0;
        } else {
            i44 = 1;
        }
        jSONObjectOptJSONObject312.put(str, i44);
        if (i43 == 1 || i15 != 1) {
            i45 = 0;
        } else {
            i45 = 1;
        }
        jSONObjectOptJSONObject314.put(str, i45);
        if (i43 == 1 || i16 != 1) {
            i46 = 0;
        } else {
            i46 = 1;
        }
        jSONObjectOptJSONObject314.put("enable_widget_memory", i46);
        jSONObjectOptJSONObject314.put("rate_memory_occupied", i10);
        jSONObjectOptJSONObject311.put("block_threshold", i30);
        jSONObjectOptJSONObject311.put("block_max_time", i11);
        jSONObjectOptJSONObject311.put("serious_block_threshold", i31);
        if (i40 == 1 || i37 != 1) {
            i47 = 0;
        } else {
            i47 = 1;
        }
        jSONObjectOptJSONObject313.put(str, i47);
        if (i40 == 1 || i37 != 1) {
            i48 = 0;
        } else {
            i48 = 1;
        }
        jSONObjectOptJSONObject311.put(str, i48);
        if (i40 == 1 || i37 != 1) {
            i49 = 0;
        } else {
            i49 = 1;
        }
        jSONObjectOptJSONObject311.put("drop_enable_upload", i49);
        jSONObjectOptJSONObject312.put("update_as_first_launch", i32);
        if (iOptInt5 == 1 || i610 != 1) {
            i50 = 0;
        } else {
            i50 = 1;
        }
        JSONObject jSONObject10 = jSONObject2;
        jSONObject10.put(str, i50);
        jSONObject10.put("sample_interval", i14);
        jSONObject10.put("background_enable", i18);
        try {
            JSONObject jSONObjectOptJSONObject315 = jSONObjectOptJSONObject310.optJSONObject("network");
            jSONObjectOptJSONObject315.put("enable_net_monitor", i42);
            jSONObjectOptJSONObject315.put("enable_success_net_sample", iOptInt4);
            jSONObjectOptJSONObject315.put("enable_net_monitor_with_net_disable", i19);
            jSONObjectOptJSONObject315.put(str2, i21);
            jSONObjectOptJSONObject315.put("filter_info", str4);
        } catch (Exception unused7) {
        }
        try {
            str5 = "fetch_setting";
            jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str5).put("fetch_setting_interval", i12);
        } catch (Exception unused8) {
            str5 = "fetch_setting";
        }
        try {
            jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str5).put(str3, i29);
        } catch (Exception unused9) {
        }
        try {
            str6 = "report_setting";
            jSONObjectOptJSONObject11 = jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str6);
            i51 = i13;
            if (i51 > 10) {
                jSONObjectOptJSONObject11.put("apm6_uploading_interval", i51);
                jSONObjectOptJSONObject11.put("uploading_interval_background", i51);
                jSONObjectOptJSONObject11.put("uploading_interval", i51);
            }
            i52 = i26;
            if (i52 == 1 || i27 != 1) {
                z9 = false;
                jSONObjectOptJSONObject4.put("enable_active_upload_alog", false);
            } else {
                jSONObjectOptJSONObject4.put("enable_active_upload_alog", true);
                z9 = false;
            }
            if (i52 == 1 || i34 != 1) {
                jSONObjectOptJSONObject4.put("enable_apmplus_alog", z9);
            } else {
                jSONObjectOptJSONObject4.put("enable_apmplus_alog", true);
            }
        } catch (Exception unused10) {
            str6 = "report_setting";
        }
        try {
            Application application2 = p061i1.h.f19229a;
        } catch (Exception unused11) {
        }
        if (i35 == 1) {
            jSONObject4 = jSONObjectOptJSONObject5;
            jSONObject4.put("allow_service_name", jSONObject3);
        } else {
            jSONObject4 = jSONObjectOptJSONObject5;
        }
        try {
            jSONObject4.optJSONObject("allow_service_name").put("apmplus_activity_leak_switch", i28);
            jSONObject4.optJSONObject("allow_service_name").put("apmplus_activity_fixer_switch", i25);
        } catch (Exception unused12) {
        }
        try {
            jSONObject4.optJSONObject("allow_log_type").put("hybrid", i39);
            jSONObject4.optJSONObject("allow_log_type").put("hybrid_v2", i36);
        } catch (Exception unused13) {
        }
        try {
            if (p061i1.h.f19230b && (jSONObjectD = p061i1.h.d()) != null) {
                jSONObjectOptJSONObject4.optJSONObject("slardar_api_settings").optJSONObject(str6).put("enable_encrypt", jSONObjectD.optBoolean("enable_encrypt", true));
            }
        } catch (Exception unused14) {
        }
        jSONObjectOptJSONObject10 = jSONObject9.optJSONObject("ret");
        this.f3174l = false;
        c(jSONObjectOptJSONObject10);
        copyOnWriteArrayList = this.f3181s;
        if (copyOnWriteArrayList != null) {
            it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((p175w3.a) it.next()).onRefresh(jSONObjectOptJSONObject10, false);
            }
        }
        f();
        this.f3175m = System.currentTimeMillis();
        p061i1.h.b("config_time", this.f3175m + "");
        N2.a.f3197Z = this.f3175m;
        try {
            JSONObject jSONObjectOptJSONObject316 = jSONObject9.optJSONObject("ret");
            String strOptString4 = jSONObject9.optString(MTCommonConstants.Network.KEY_NAME);
            SharedPreferences.Editor editorEdit2 = this.f3172i.edit();
            editorEdit2.putString("monitor_net_config", jSONObjectOptJSONObject316.toString());
            editorEdit2.putInt("setting_version", 3);
            editorEdit2.putString("monitor_net_config_name", strOptString4);
            editorEdit2.putLong("monitor_configure_refresh_time", this.f3175m);
            editorEdit2.commit();
        } catch (Exception unused15) {
        }
        p133r2.b.f21107i.b(new g(0), 1000L);
        return true;
    }

    public final void f() {
        if (this.f3164a) {
            return;
        }
        this.f3164a = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f3181s;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((p175w3.a) it.next()).onReady();
            }
        }
    }

    public final boolean g() {
        String string = this.f3172i.getString("monitor_net_config", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.f3174l = true;
                this.f3175m = this.f3172i.getLong("monitor_configure_refresh_time", 0L);
                p061i1.h.b("config_time", this.f3175m + "");
                N2.a.f3197Z = this.f3175m;
                c(jSONObject);
                CopyOnWriteArrayList copyOnWriteArrayList = this.f3181s;
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((p175w3.a) it.next()).onRefresh(jSONObject, true);
                    }
                }
                f();
                return false;
            } catch (Exception unused) {
                Log.e("<monitor><setting>", p199z2.b.f(new String[]{"配置信息读取失败"}));
            }
        }
        return true;
    }
}
