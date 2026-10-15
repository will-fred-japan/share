package com.vivo.push.h;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: OnNotificationArrivedReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class ab implements z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f16617a;

    public ab(aa aaVar) {
        this.f16617a = aaVar;
    }

    @Override // com.vivo.push.h.z.a
    public final void a() {
        long jL = com.vivo.push.n.a().l();
        if (jL < 1400 && jL != 1340) {
            com.vivo.push.util.w.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(jL)));
            return;
        }
        HashMap map = new HashMap();
        map.put("srt", "1");
        map.put(MTPushConstants.Message.KEY_MESSAGE_ID, String.valueOf(this.f16617a.f16614b.k()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("app_id", strA);
        }
        map.put("type", "1");
        map.put("dtp", "1");
        com.vivo.push.util.h.a(6L, (HashMap<String, String>) map);
    }

    @Override // com.vivo.push.h.z.a
    public final void b() {
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.f14286c, String.valueOf(this.f16617a.f16614b.k()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        com.vivo.push.util.h.a(2122L, (HashMap<String, String>) map);
    }
}
