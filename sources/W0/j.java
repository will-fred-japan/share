package W0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: NubiaOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements l {
    @Override // W0.l
    public final l.a a(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient != null) {
                Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                contentProviderClientAcquireContentProviderClient.close();
                if (bundleCall != null) {
                    if (bundleCall.getInt("code", -1) == 0) {
                        l.a aVar = new l.a();
                        aVar.f5014a = bundleCall.getString("id");
                        return aVar;
                    }
                    String string = bundleCall.getString("message");
                    if (!TextUtils.isEmpty(string) && string != null) {
                        Log.e("Logger", string);
                    }
                }
            }
            return null;
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    @Override // W0.l
    public final boolean b(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
