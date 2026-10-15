package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.vivo.push.model.InsideNotificationItem;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: OnNotificationClickReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f16527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f16529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f16532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16533i;
    private Bundle j;

    public q(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f16525a = str;
        this.f16528d = j;
        this.f16529e = insideNotificationItem;
    }

    public final void a(Uri uri) {
        this.f16532h = uri;
    }

    public final void b(String str) {
        this.f16530f = str;
    }

    public final void c(String str) {
        this.f16531g = str;
    }

    public final void d(String str) {
        this.f16533i = str;
    }

    public final String e() {
        return this.f16525a;
    }

    public final long f() {
        return this.f16528d;
    }

    public final InsideNotificationItem g() {
        return this.f16529e;
    }

    public final String h() {
        return this.f16530f;
    }

    public final String i() {
        return this.f16531g;
    }

    public final String j() {
        return this.f16533i;
    }

    public final Uri k() {
        return this.f16532h;
    }

    public final Bundle l() {
        if (this.j == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.j);
        try {
            bundle.remove("command_type");
            bundle.remove("security_avoid_pull");
            bundle.remove("security_avoid_pull_rsa");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("notify_action");
            bundle.remove("notify_componet_pkg");
            bundle.remove("notify_componet_class_name");
            bundle.remove("notification_v1");
            bundle.remove(com.heytap.mcssdk.constant.b.f14306y);
            bundle.remove(Constants.PACKAGE_NAME);
            bundle.remove("method");
            return bundle;
        } catch (Exception e9) {
            e9.printStackTrace();
            return bundle;
        }
    }

    @Override // com.vivo.push.w
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        dVar.a(Constants.PACKAGE_NAME, this.f16525a);
        dVar.a(MTPushConstants.Notification.KEY_NOTIFY_ID, this.f16528d);
        dVar.a("notification_v1", com.vivo.push.util.x.b(this.f16529e));
        dVar.a("open_pkg_name", this.f16526b);
        dVar.a("open_pkg_name_encode", this.f16527c);
        dVar.a("notify_action", this.f16530f);
        dVar.a("notify_componet_pkg", this.f16531g);
        dVar.a("notify_componet_class_name", this.f16533i);
        Uri uri = this.f16532h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    @Override // com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        this.f16525a = dVar.a(Constants.PACKAGE_NAME);
        this.f16528d = dVar.b(MTPushConstants.Notification.KEY_NOTIFY_ID, -1L);
        this.f16526b = dVar.a("open_pkg_name");
        this.f16527c = dVar.b("open_pkg_name_encode");
        this.f16530f = dVar.a("notify_action");
        this.f16531g = dVar.a("notify_componet_pkg");
        this.f16533i = dVar.a("notify_componet_class_name");
        String strA = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(strA)) {
            this.f16529e = com.vivo.push.util.x.a(strA);
        }
        InsideNotificationItem insideNotificationItem = this.f16529e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f16528d);
        }
        String strA2 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(strA2)) {
            this.f16532h = e(strA2);
        }
        this.j = dVar.b();
    }

    public q() {
        super(5);
    }
}
