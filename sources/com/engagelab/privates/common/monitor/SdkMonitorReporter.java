package com.engagelab.privates.common.monitor;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.sentry.MTCommonReporter;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SdkMonitorReporter {
    private static final String SDK_TYPE_MT_PUSH = "MTPush";
    private static final String TAG = "SdkMonitorReporter";
    private static final String TYPE_SDK_MONITOR = "sdk_monitor";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f12309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f12311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f12312e;

        public a(int i9, long j, int i10, long j8, Context context) {
            this.f12308a = i9;
            this.f12309b = j;
            this.f12310c = i10;
            this.f12311d = j8;
            this.f12312e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                JSONArray jSONArray = new JSONArray();
                if (this.f12308a > 0) {
                    long jCurrentTimeMillis2 = this.f12309b;
                    if (jCurrentTimeMillis2 <= 0) {
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                    }
                    jSONArray.put(SdkMonitorReporter.buildItem("EX_CRASH", jCurrentTimeMillis2, SdkMonitorReporter.buildCrashExtra(this.f12308a)));
                }
                if (this.f12310c > 0) {
                    long jCurrentTimeMillis3 = this.f12311d;
                    if (jCurrentTimeMillis3 <= 0) {
                        jCurrentTimeMillis3 = System.currentTimeMillis();
                    }
                    jSONArray.put(SdkMonitorReporter.buildItem("EX_ANR", jCurrentTimeMillis3, SdkMonitorReporter.buildCrashExtra(this.f12310c)));
                }
                if (jSONArray.length() == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("itime", jCurrentTimeMillis);
                jSONObject.put("data", jSONArray);
                SdkMonitorReporter.send(this.f12312e, jSONObject);
            } catch (Throwable th) {
                MTCommonLog.e(SdkMonitorReporter.TAG, "reportCrashANR error: " + th.getMessage());
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f12313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f12315c;

        public b(long j, int i9, Context context) {
            this.f12313a = j;
            this.f12314b = i9;
            this.f12315c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                long jCurrentTimeMillis2 = this.f12313a;
                if (jCurrentTimeMillis2 <= 0) {
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, this.f12314b);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(SdkMonitorReporter.buildItem("COLD_BOOT_APP", jCurrentTimeMillis2, jSONObject));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("itime", jCurrentTimeMillis);
                jSONObject2.put("data", jSONArray);
                SdkMonitorReporter.send(this.f12315c, jSONObject2);
            } catch (Throwable th) {
                MTCommonLog.e(SdkMonitorReporter.TAG, "reportColdStart error: " + th.getMessage());
            }
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f12317b;

        public c(JSONObject jSONObject, Context context) {
            this.f12316a = jSONObject;
            this.f12317b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12316a.put("itime", System.currentTimeMillis() / 1000);
                SdkMonitorReporter.send(this.f12317b, this.f12316a);
            } catch (Throwable th) {
                MTCommonLog.e(SdkMonitorReporter.TAG, "reportTcpTiming error: " + th.getMessage());
            }
        }
    }

    private static Bundle buildBundle(JSONObject jSONObject) {
        try {
            MTCommonReporter mTCommonReporter = new MTCommonReporter();
            mTCommonReporter.setType(TYPE_SDK_MONITOR);
            mTCommonReporter.setContent(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(MTCommonConstants.Protocol.KEY_COMMON_REPORTER, mTCommonReporter);
            return bundle;
        } catch (Throwable th) {
            MTCommonLog.e(TAG, "buildBundle failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject buildCrashExtra(int i9) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HianalyticsBaseData.SDK_TYPE, SDK_TYPE_MT_PUSH);
        jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, i9);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject buildItem(String str, long j, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("monitor_type", str);
        jSONObject2.put("monitor_id", UUID.randomUUID().toString());
        jSONObject2.put("timestamp", j);
        jSONObject2.put(JThirdPlatFormInterface.KEY_EXTRA, jSONObject);
        return jSONObject2;
    }

    public static void reportColdStart(Context context, int i9, long j) {
        if (i9 <= 0) {
            return;
        }
        new Thread(new b(j, i9, context), "SdkMonitorColdStart").start();
    }

    public static void reportCrashANR(Context context, int i9, long j, int i10, long j8) {
        new Thread(new a(i9, j, i10, j8, context), "SdkMonitorCrash").start();
    }

    public static void reportTcpTiming(Context context, JSONObject jSONObject) {
        new Thread(new c(jSONObject, context), "SdkMonitorTcpTiming").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void send(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("type", TYPE_SDK_MONITOR);
            Bundle bundleBuildBundle = buildBundle(jSONObject);
            if (bundleBuildBundle == null) {
                return;
            }
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.ON_REPORT, bundleBuildBundle);
        } catch (Throwable th) {
            MTCommonLog.e(TAG, "send error: " + th.getMessage());
        }
    }
}
