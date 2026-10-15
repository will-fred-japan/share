package com.vivo.push.h;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.WakedResultReceiver;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: NotifyOpenClientClickTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ag {
    public e(com.vivo.push.w wVar) {
        super(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) wVar;
        InsideNotificationItem insideNotificationItemG = qVar.g();
        if (insideNotificationItemG == null) {
            com.vivo.push.util.w.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage uPSNotificationMessageA = com.vivo.push.util.x.a(insideNotificationItemG);
        boolean zEquals = this.f16804a.getPackageName().equals(qVar.e());
        if (zEquals) {
            NotifyAdapterUtil.cancelNotify(this.f16804a);
        }
        if (zEquals) {
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(1030L);
            HashMap<String, String> map = new HashMap<>();
            map.put("type", WakedResultReceiver.WAKE_TYPE_KEY);
            map.put(com.heytap.mcssdk.constant.b.f14286c, String.valueOf(qVar.f()));
            map.put("platform", this.f16804a.getPackageName());
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            zVar.a(map);
            com.vivo.push.n.a().a(zVar);
            com.vivo.push.util.w.d("NotifyOpenClientTask", "notification is clicked by skip type[" + uPSNotificationMessageA.getSkipType() + "]");
            int skipType = uPSNotificationMessageA.getSkipType();
            if (skipType == 1) {
                new Thread(new f(this, this.f16804a, uPSNotificationMessageA.getParams())).start();
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 2) {
                String skipContent = uPSNotificationMessageA.getSkipContent();
                if (!skipContent.startsWith(JPushConstants.HTTP_PRE) && !skipContent.startsWith(JPushConstants.HTTPS_PRE)) {
                    com.vivo.push.util.w.a("NotifyOpenClientTask", "url not legal");
                } else {
                    Uri uri = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.setFlags(268435456);
                    b(intent, uPSNotificationMessageA.getParams());
                    try {
                        this.f16804a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.w.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(uri)));
                    }
                }
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType == 3) {
                a(uPSNotificationMessageA);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.w.a("NotifyOpenClientTask", "illegitmacy skip type error : " + uPSNotificationMessageA.getSkipType());
                return;
            }
            String skipContent2 = uPSNotificationMessageA.getSkipContent();
            try {
                Intent uri2 = Intent.parseUri(skipContent2, 1);
                String str = uri2.getPackage();
                if (!TextUtils.isEmpty(str) && !this.f16804a.getPackageName().equals(str)) {
                    com.vivo.push.util.w.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f16804a.getPackageName() + "; but remote pkgName is " + uri2.getPackage());
                    return;
                }
                String packageName = uri2.getComponent() == null ? null : uri2.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.f16804a.getPackageName().equals(packageName)) {
                    com.vivo.push.util.w.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f16804a.getPackageName() + "; but remote pkgName is " + uri2.getPackage());
                    return;
                }
                uri2.setSelector(null);
                uri2.setPackage(this.f16804a.getPackageName());
                uri2.addFlags(335544320);
                b(uri2, uPSNotificationMessageA.getParams());
                ActivityInfo activityInfoResolveActivityInfo = uri2.resolveActivityInfo(this.f16804a.getPackageManager(), 65536);
                if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                    com.vivo.push.util.w.a("NotifyOpenClientTask", "activity is not exported : " + activityInfoResolveActivityInfo.toString());
                } else {
                    this.f16804a.startActivity(uri2);
                    a(uPSNotificationMessageA);
                }
            } catch (Exception e9) {
                com.vivo.push.util.w.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e9);
            }
        } else {
            com.vivo.push.util.w.a("NotifyOpenClientTask", "notify is " + uPSNotificationMessageA + " ; isMatch is " + zEquals);
        }
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.u.b(new g(this, uPSNotificationMessage));
    }
}
