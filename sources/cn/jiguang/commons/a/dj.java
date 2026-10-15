package cn.jiguang.commons.a;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class dj {
    @TargetApi(11)
    public static String a(Context context, Uri uri) {
        try {
            String strB = km.b("Oi3ZFT8+schQHSyFZbsdUg==", f.f10031c);
            if (TextUtils.isEmpty(strB)) {
                return "";
            }
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(strB, null, null);
            contentProviderClientAcquireUnstableContentProviderClient.close();
            if (bundleCall.getInt("code", -1) != 0) {
                return bundleCall.getString("message");
            }
            String string = bundleCall.getString("id");
            ee.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get ids-o err:"), "NubiaIdManager");
            return null;
        }
    }
}
