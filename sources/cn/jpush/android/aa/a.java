package cn.jpush.android.aa;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.h;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.d;
import defpackage.f;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cn.jpush.android.aa.b f11017b;

    /* JADX INFO: renamed from: cn.jpush.android.aa.a$a, reason: collision with other inner class name */
    public class C0138a extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f11019b;

        public C0138a(String str) {
            this.f11019b = str;
        }

        @Override // cn.jpush.android.ad.h
        public void a() {
            try {
                if (!TextUtils.isEmpty(this.f11019b)) {
                    a.this.f11017b.a(this.f11019b);
                    return;
                }
                Map<String, Integer> mapA = a.this.f11017b.a();
                if (mapA == null || mapA.size() <= 0) {
                    return;
                }
                Sp.set(a.this.f11016a, Key.LastReportApiStatisticTime().set(Long.valueOf(System.currentTimeMillis())));
                if (d.a(a.this.f11016a, mapA)) {
                    a.this.f11017b.b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f11020a = new a();
    }

    private a() {
    }

    public static final a a() {
        return b.f11020a;
    }

    public void b() {
        long jLongValue = ((Long) Sp.get(this.f11016a, Key.LastReportApiStatisticTime())).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = Math.abs(jCurrentTimeMillis - jLongValue);
        if (jLongValue == 0 || jAbs >= 86400000) {
            JCoreHelper.normalExecutor(this.f11016a, null, new C0138a(""));
            return;
        }
        StringBuilder sbH = f.h(jLongValue, "Less 24 hours since the last report so return. lastTime=", " currentTime=");
        sbH.append(jCurrentTimeMillis);
        sbH.append(" diffTime=");
        sbH.append(jAbs);
        Logger.dd("JPushApiStatistics", sbH.toString());
    }

    public void a(Context context) {
        if (this.f11016a == null || this.f11017b == null) {
            Context applicationContext = context.getApplicationContext();
            this.f11016a = applicationContext;
            this.f11017b = new cn.jpush.android.aa.b(applicationContext);
        }
    }

    public void a(Context context, String str) {
        String str2;
        a(context);
        str.getClass();
        switch (str) {
            case "clear_all_notify":
                str2 = "JPushInterface#clearAllNotifications";
                break;
            case "set_mobile":
                str2 = "JPushInterface#setMobileNumber";
                break;
            case "clear_by_id":
                str2 = "JPushInterface#clearNotificationById";
                break;
            case "is_enable":
                str2 = "JPushInterface#isNotificationEnabled";
                break;
            case "clear_local_notify":
                str2 = "JPushInterface#clearLocalNotifications";
                break;
            case "geo_interval":
                str2 = "JPushInterface#setGeofenceInterval";
                break;
            case "add_local_notify":
                str2 = "JPushInterface#addLocalNotification";
                break;
            case "geo_fence_max_num":
                str2 = "JPushInterface#setMaxGeofenceNumber";
                break;
            case "delete_geo_fence":
                str2 = "JPushInterface#deleteGeofence";
                break;
            case "go_settings":
                str2 = "JPushInterface#goToAppNotificationSettings";
                break;
            case "rm_local_notify":
                str2 = "JPushInterface#removeLocalNotification";
                break;
            case "on_check":
                str2 = "JPushMessageReceiver#onNotificationSettingsCheck";
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Logger.d("JPushApiStatistics", "  statistic api =".concat(str2));
        JCoreHelper.normalExecutor(this.f11016a, null, new C0138a(str2));
    }
}
