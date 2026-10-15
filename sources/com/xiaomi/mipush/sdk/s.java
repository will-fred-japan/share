package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bh;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a aVarA = g.a(dVar);
        if (aVarA == null || TextUtils.isEmpty(aVarA.f16977a) || TextUtils.isEmpty(aVarA.f16978b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(aVarA.f16977a, aVarA.f16978b, context);
    }
}
