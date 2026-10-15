package cn.jiguang.commons.j;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.commons.a.eb;
import cn.jiguang.commons.a.ec;
import java.util.LinkedHashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static LinkedHashSet<c> bs = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static eb f10456c = new ec();

    public static void a(c cVar) {
        bs.add(cVar);
    }

    public static void b(Bundle bundle) {
        for (c cVar : bs) {
            if (cVar != null) {
                cVar.c(bundle);
            }
        }
    }

    public static Object e(int i9, String str, Bundle bundle, Object... objArr) {
        return f10456c.a(null, i9, str, bundle, objArr);
    }

    public static Object e(Context context, int i9, String str, Bundle bundle, Object... objArr) {
        return f10456c.a(context, i9, str, bundle, objArr);
    }

    public static void e(JSONObject jSONObject) {
        try {
            for (c cVar : bs) {
                if (cVar != null) {
                    cVar.r(jSONObject);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
