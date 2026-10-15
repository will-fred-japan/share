package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.w.m;
import cn.jiguang.x.f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public static class a {
        public static void a(Context context, String str, Bundle bundle, Object... objArr) {
            if (bundle == null) {
                f.i("JPushScenarios", "onEvent: bundle is null");
                return;
            }
            String string = bundle.getString("type");
            if (!"start_service".equals(string)) {
                f.c("JPushScenarios", "onEvent: unknown type: " + string);
                return;
            }
            long j = bundle.getLong("jg_time_start_id", 0L);
            long j8 = bundle.getLong("time_id", 0L);
            if (j > 0 && j8 > 0) {
                m.a(context, 0, j, j8);
                return;
            }
            StringBuilder sbH = defpackage.f.h(j, "onEvent: invalid time values, jgTimeStartId=", ", timeId=");
            sbH.append(j8);
            f.i("JPushScenarios", sbH.toString());
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle, Object... objArr) {
        if ("jpush_scenarios".equals(str2)) {
            a.a(context, str, bundle, objArr);
            return;
        }
        f.c("JSendCoreHelper", "onEvent: unknown action: " + str2);
    }
}
