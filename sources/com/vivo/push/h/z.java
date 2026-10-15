package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* JADX INFO: compiled from: OnNotificationArrivedReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class z extends ag {

    /* JADX INFO: compiled from: OnNotificationArrivedReceiveTask.java */
    public interface a {
        void a();

        void b();
    }

    public z(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        if (wVar == null) {
            com.vivo.push.util.w.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        com.vivo.push.b.r rVar = (com.vivo.push.b.r) wVar;
        Context context = this.f16804a;
        boolean zD = com.vivo.push.util.ad.d(context, context.getPackageName());
        if (!zD && !rVar.g()) {
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(2101L);
            HashMap<String, String> map = new HashMap<>();
            map.put(com.heytap.mcssdk.constant.b.f14286c, String.valueOf(rVar.k()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            zVar.a(map);
            com.vivo.push.n.a().a(zVar);
            com.vivo.push.util.w.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f16804a.getPackageName() + " isMsgNoShowOnForeground :" + rVar.k());
            return;
        }
        com.vivo.push.n.a().a(new com.vivo.push.b.h(String.valueOf(rVar.k())));
        if (com.vivo.push.n.a().g() && !a(com.vivo.push.util.ak.c(this.f16804a), rVar.f(), rVar.l())) {
            com.vivo.push.b.z zVar2 = new com.vivo.push.b.z(1021L);
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(com.heytap.mcssdk.constant.b.f14286c, String.valueOf(rVar.k()));
            String strA2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA2)) {
                map2.put("remoteAppId", strA2);
            }
            zVar2.a(map2);
            com.vivo.push.n.a().a(zVar2);
            com.vivo.push.util.w.d("OnNotificationArrivedTask", "vertifyMsg not match =" + rVar.k());
            return;
        }
        InsideNotificationItem insideNotificationItemE = rVar.e();
        if (insideNotificationItemE == null) {
            com.vivo.push.util.w.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.w.c("通知内容为空，" + rVar.k());
            com.vivo.push.util.h.a(rVar.k(), 1027L);
            return;
        }
        com.vivo.push.util.w.d("OnNotificationArrivedTask", "targetType is " + insideNotificationItemE.getTargetType() + " ; target is " + insideNotificationItemE.getTargetContent());
        com.vivo.push.u.b(new aa(this, insideNotificationItemE, rVar, zD));
    }
}
