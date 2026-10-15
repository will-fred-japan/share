package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import java.security.PublicKey;
import java.util.HashMap;

/* JADX INFO: compiled from: OnReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ag extends com.vivo.push.t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PushMessageCallback f16620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16621c;

    public ag(com.vivo.push.w wVar) {
        super(wVar);
        this.f16621c = 0;
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.f16620b = pushMessageCallback;
    }

    public final int b() {
        return this.f16621c;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!com.vivo.push.n.a().d()) {
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
        try {
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
            if (com.vivo.push.util.ae.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify id is success");
                return true;
            }
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
            com.vivo.push.util.w.c("vertify fail srcDigest is ".concat(str));
            return false;
        } catch (Exception e9) {
            e9.printStackTrace();
            com.vivo.push.util.w.d("OnVerifyCallBackCommand", "vertify exception");
            return false;
        }
    }

    public final int a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            com.vivo.push.util.w.b("OnVerifyCallBackCommand", "pkg name : " + this.f16804a.getPackageName() + " 应用到达回调返回值为空，不做处理");
            com.vivo.push.util.w.b("应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
            return 2163;
        }
        if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        }
        com.vivo.push.util.w.b("OnVerifyCallBackCommand", "pkg name : " + this.f16804a.getPackageName() + " 应用主动拦截通知");
        com.vivo.push.util.w.b("应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
        return 2120;
    }

    public final HashMap<String, String> a(long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put(com.heytap.mcssdk.constant.b.f14286c, String.valueOf(j));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        Context context = this.f16804a;
        map.put("clientsdkver", String.valueOf(com.vivo.push.util.ak.c(context, context.getPackageName())));
        return map;
    }

    public final void a(int i9) {
        this.f16621c = i9;
    }
}
