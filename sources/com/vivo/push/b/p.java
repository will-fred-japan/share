package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: compiled from: OnMessageReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected UnvarnishedMessage f16523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16524b;

    public p() {
        super(3);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("msg_v1", this.f16523a.unpackToJson());
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String strA = dVar.a("msg_v1");
        this.f16524b = strA;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(this.f16524b);
        this.f16523a = unvarnishedMessage;
        unvarnishedMessage.setMsgId(k());
        this.f16523a.setTransmissionMessageEventType(dVar.b("transmission_message_event_type", 0));
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f16524b)) {
            return this.f16524b;
        }
        UnvarnishedMessage unvarnishedMessage = this.f16523a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }

    public final UnvarnishedMessage f() {
        return this.f16523a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnMessageCommand";
    }
}
