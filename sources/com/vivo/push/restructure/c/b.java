package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.z;
import com.vivo.push.n;
import com.vivo.push.util.w;
import java.util.HashMap;

/* JADX INFO: compiled from: ReportImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f16769a;

    public b(com.vivo.push.restructure.b.a aVar) {
        this.f16769a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i9, String str) {
        w.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i9);
        if (i9 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        z zVar = new z(i9);
        HashMap<String, String> map = new HashMap<>();
        map.put(com.heytap.mcssdk.constant.b.f14286c, str);
        com.vivo.push.restructure.b.a aVar = this.f16769a;
        if (aVar != null) {
            String strA = aVar.a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
        }
        zVar.a(map);
        n.a().a(zVar);
    }
}
