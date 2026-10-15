package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: OnNotifyArrivedReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InsideNotificationItem f16534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16535b;

    public r() {
        super(4);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        String strB = com.vivo.push.util.x.b(this.f16534a);
        this.f16535b = strB;
        dVar.a("notification_v1", strB);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String strA = dVar.a("notification_v1");
        this.f16535b = strA;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        InsideNotificationItem insideNotificationItemA = com.vivo.push.util.x.a(this.f16535b);
        this.f16534a = insideNotificationItemA;
        if (insideNotificationItemA != null) {
            insideNotificationItemA.setMsgId(k());
        }
    }

    public final InsideNotificationItem e() {
        return this.f16534a;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.f16535b)) {
            return this.f16535b;
        }
        InsideNotificationItem insideNotificationItem = this.f16534a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.x.b(insideNotificationItem);
    }

    public final boolean g() {
        InsideNotificationItem insideNotificationItem = this.f16534a;
        return insideNotificationItem != null && insideNotificationItem.isNoShowOnForeground();
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
