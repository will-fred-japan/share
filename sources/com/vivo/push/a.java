package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: compiled from: BasePushClient.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "com.vivo.push.a";

    public void deleteRegid(IPushActionListener iPushActionListener, String str, String str2) {
        com.vivo.push.restructure.a.a().h().a(iPushActionListener, str, str2);
    }

    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        com.vivo.push.util.i.a().execute(new b(this, iPushQueryActionListener));
    }

    public void querySubscribeState(IPushActionListener iPushActionListener) {
        com.vivo.push.util.i.a().execute(new c(this, iPushActionListener));
    }

    public void setIsOpenVivoPhoneCheck(boolean z8) {
        com.vivo.push.util.w.c(TAG, "setIsOpenVivoPhoneCheck:".concat(String.valueOf(z8)));
        n.a().b(z8);
    }
}
