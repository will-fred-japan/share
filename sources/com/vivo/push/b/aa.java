package com.vivo.push.b;

import com.heytap.msp.push.callback.INotificationPermissionCallback;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: TagCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class aa extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f16489a;

    public aa(boolean z8, String str, ArrayList<String> arrayList) {
        super(z8 ? INotificationPermissionCallback.CODE_FREQUENT : INotificationPermissionCallback.CODE_UNSUPPORT, str);
        this.f16489a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags", (Serializable) this.f16489a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16489a = dVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final String toString() {
        return "TagCommand";
    }
}
