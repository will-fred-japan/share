package com.vivo.push.e;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {
    public static /* synthetic */ void a(d dVar, String str, IPushRequestCallback iPushRequestCallback, int i9) {
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            w.e("core not support sync profileInfo");
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context contextB = com.vivo.push.restructure.a.a().b();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new b(str));
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(contextB.getPackageName(), arrayList, i9)), new j(dVar, iPushRequestCallback, i9), 20000L));
    }

    @Override // com.vivo.push.e.a
    public final void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.i.a().execute(new e(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.i.a().execute(new g(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.i.a().execute(new f(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        com.vivo.push.util.i.a().execute(new h(this, iPushRequestCallback));
    }
}
