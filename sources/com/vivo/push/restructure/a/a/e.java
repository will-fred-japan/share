package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: DispatchNode.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends a<com.vivo.push.restructure.a.a> {
    public e(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("ClientDispatchNode", aVar, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        if (aVar == null) {
            w.a("DispatchNode", "receivedMsg is null");
            return 2808;
        }
        int i9 = 0;
        if (aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        int iL = aVar.l();
        String strM = aVar.m();
        if (iL == 3) {
            String strI = com.vivo.push.n.a().i();
            if (TextUtils.isEmpty(strI) || !TextUtils.equals(strI, strM)) {
                i9 = 2810;
            }
        } else if (iL == 4) {
            com.vivo.push.n.a();
            if (!com.vivo.push.n.c().contains(strM)) {
                i9 = 2811;
            }
        }
        if (i9 != 0) {
            com.vivo.push.util.i.a().execute(new f(this, iL, strM));
            return i9;
        }
        try {
            return com.vivo.push.n.a().a(aVar.b());
        } catch (Exception e9) {
            w.a("DispatchNode", "dispatch node happen exception", e9);
            return 2808;
        }
    }
}
