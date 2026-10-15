package cn.jpush.android.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.e.c;
import cn.jpush.android.f.f;
import cn.jpush.android.i.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            b.g("PushPlatformManager", "appId is empty");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f11391b, "", "appId is empty"));
                return;
            }
            return;
        }
        if (str.length() != 24) {
            b.g("PushPlatformManager", "Invalid appId : " + str + ", Please check your appId again!");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f11391b, "", "Invalid appId"));
                return;
            }
            return;
        }
        try {
            cn.jpush.android.f.c.f11379b = str;
            b.b("PushPlatformManager", "register: appId - ".concat(str));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("JPUSH_APPKEY", str);
            jSONObject.put("FIRST_REQUESTA", cn.jpush.android.a.b.c(context));
            cn.jpush.android.a.b.d(context);
            long jA = cn.jpush.android.f.c.a();
            cn.jpush.android.f.a.a(new cn.jpush.android.f.b("ups.register", jA), cVar);
            cn.jpush.android.f.c.a(context, "ups.register", jA, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
