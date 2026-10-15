package com.vivo.push.b;

import com.vivo.push.model.RemoteNotificationContent;
import com.vivo.push.model.RemoteNotificationInfo;
import org.json.JSONArray;

/* JADX INFO: compiled from: OnExtensionPushCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected RemoteNotificationInfo f16513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RemoteNotificationContent f16514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16518f;

    public m() {
        super(2024);
    }

    public final void a(RemoteNotificationContent remoteNotificationContent) {
        this.f16514b = remoteNotificationContent;
    }

    public final void b(long j) {
        this.f16518f = j;
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        String string;
        super.c(dVar);
        this.f16518f = System.currentTimeMillis();
        if (this.f16514b == null) {
            string = "";
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f16514b.getIsShowNotification());
            jSONArray.put(this.f16514b.getTitle());
            jSONArray.put(this.f16514b.getBody());
            jSONArray.put(this.f16514b.getBadgeOperateType());
            jSONArray.put(this.f16514b.getBadgeNum());
            jSONArray.put(this.f16514b.getClickType());
            jSONArray.put(this.f16514b.getClickUrl());
            string = jSONArray.toString();
        }
        dVar.a("extension_msg_v1", string);
        RemoteNotificationContent remoteNotificationContent = this.f16514b;
        if (remoteNotificationContent != null && remoteNotificationContent.getImage() != null) {
            dVar.a("extension_image", this.f16514b.getImage());
        }
        dVar.a("extension_arrive_client_time", this.f16517e);
        dVar.a("extension_send_time", this.f16518f);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String strA = dVar.a("extension_msg_v1");
        this.f16515c = strA;
        RemoteNotificationInfo remoteNotificationInfoB = b(strA);
        this.f16513a = remoteNotificationInfoB;
        if (remoteNotificationInfoB != null) {
            remoteNotificationInfoB.setMsgId(k());
        }
        this.f16517e = System.currentTimeMillis();
        this.f16516d = dVar.b("timeout_time", 10);
        com.vivo.push.util.w.c("OnExtensionPushCommand", "onReceive msgId:" + k());
    }

    public final String e() {
        return this.f16515c;
    }

    public final RemoteNotificationInfo f() {
        return this.f16513a;
    }

    public final long g() {
        return this.f16517e;
    }

    public final int h() {
        return this.f16516d;
    }

    private static RemoteNotificationInfo b(String str) {
        RemoteNotificationInfo remoteNotificationInfo = new RemoteNotificationInfo();
        try {
            JSONArray jSONArray = new JSONArray(str);
            remoteNotificationInfo.setType(jSONArray.getInt(0));
            remoteNotificationInfo.setToken(jSONArray.getString(1));
            remoteNotificationInfo.setTitle(jSONArray.getString(2));
            remoteNotificationInfo.setBody(jSONArray.getString(3));
            remoteNotificationInfo.setImage(jSONArray.getString(4));
            remoteNotificationInfo.setNotifyId(jSONArray.getLong(5));
            remoteNotificationInfo.setClickType(jSONArray.getInt(6));
            if (jSONArray.length() > 7) {
                remoteNotificationInfo.setClickUrl(jSONArray.getString(7));
            }
            if (jSONArray.length() > 8) {
                remoteNotificationInfo.setExtraData(jSONArray.getString(8));
            }
            return remoteNotificationInfo;
        } catch (Exception e9) {
            com.vivo.push.util.w.a("OnExtensionPushCommand", "jsonToNotificationInfo error", e9);
            return null;
        }
    }

    public final void a(long j) {
        this.f16517e = j;
    }
}
