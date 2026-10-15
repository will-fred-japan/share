package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.analytics.page.PushSA;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.DateUtil;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile r0 f12355d = new r0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12356a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12357b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12358c = false;

    public static r0 a() {
        return f12355d;
    }

    public synchronized void b(Context context) {
        try {
            this.f12358c = true;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f12357b == 0) {
                this.f12357b = g1.c(context);
            }
            if (0 == this.f12356a) {
                this.f12356a = g1.d(context);
            }
            if (jCurrentTimeMillis - this.f12357b < 30000) {
                return;
            }
            this.f12356a = jCurrentTimeMillis;
            g1.b(context, jCurrentTimeMillis);
            b(context, jCurrentTimeMillis);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(Context context) {
        this.f12358c = false;
        if (0 == this.f12356a) {
            MTCommonLog.w("MTActiveBusiness", "toBackground lastToForegroundTime is 0 ");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a(context, jCurrentTimeMillis, this.f12356a);
        this.f12357b = jCurrentTimeMillis;
        g1.a(context, jCurrentTimeMillis);
    }

    public static synchronized void a(Context context, long j, long j8) {
        try {
            String strA = g1.a(context);
            if (TextUtils.isEmpty(strA)) {
                MTCommonLog.d("MTActiveBusiness", "session is null");
                return;
            }
            long j9 = (j - j8) / 1000;
            if (j9 < 0) {
                j9 = 0;
            }
            String todayDateTimeForReport = DateUtil.getTodayDateTimeForReport();
            String str = todayDateTimeForReport.split(BundleUtil.UNDERLINE_TAG)[0];
            String str2 = todayDateTimeForReport.split(BundleUtil.UNDERLINE_TAG)[1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", strA);
            jSONObject.put("date", str);
            jSONObject.put(CrashHianalyticsData.TIME, str2);
            jSONObject.put("duration", j9);
            g1.b(context, jSONObject.toString());
        } catch (Throwable th) {
            MTCommonLog.w("MTActiveBusiness", "processBackground failed " + th.getMessage());
        }
    }

    public static synchronized void b(Context context, long j) {
        try {
            String strB = g1.b(context);
            if (!TextUtils.isEmpty(strB)) {
                MTReporter content = new MTReporter().setType(PushSA.REPORT_ACTIVE_TERMINATE).setContent(new JSONObject(strB).toString());
                Bundle bundle = new Bundle();
                bundle.putParcelable("protocol", content);
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
            }
            String strA = a(context, j);
            if (TextUtils.isEmpty(strA)) {
                MTCommonLog.d("MTActiveBusiness", "session is null");
                return;
            }
            g1.a(context, strA);
            String todayDateTimeForReport = DateUtil.getTodayDateTimeForReport();
            String str = todayDateTimeForReport.split(BundleUtil.UNDERLINE_TAG)[0];
            String str2 = todayDateTimeForReport.split(BundleUtil.UNDERLINE_TAG)[1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", strA);
            jSONObject.put("date", str);
            jSONObject.put(CrashHianalyticsData.TIME, str2);
            MTReporter content2 = new MTReporter().setType(PushSA.REPORT_ACTIVE_LAUNCH).setContent(jSONObject.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("protocol", content2);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle2);
        } catch (Throwable th) {
            MTCommonLog.w("MTActiveBusiness", "processForeground failed " + th.getMessage());
        }
    }

    public static String a(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        String appKey = MTGlobal.getAppKey(context);
        if (!TextUtils.isEmpty(appKey)) {
            sb.append(appKey);
        }
        String deviceId = MTGlobal.getDeviceId(context);
        if (!TextUtils.isEmpty(deviceId)) {
            sb.append(deviceId);
        }
        sb.append(j);
        return StringUtil.get32MD5String(sb.toString());
    }

    public boolean b() {
        return this.f12358c;
    }
}
