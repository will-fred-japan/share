package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dc implements gu, gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17191a;

    public dc(Context context) {
        this.f17191a = context;
    }

    @Override // com.xiaomi.push.gz
    /* JADX INFO: renamed from: a */
    public boolean mo220a(hd hdVar) {
        return true;
    }

    @Override // com.xiaomi.push.gu
    public void a(hd hdVar) {
        dj.a(this.f17191a);
    }

    @Override // com.xiaomi.push.gu
    public void a(gg ggVar) {
        if (ggVar != null && ggVar.a() == 0 && "PING".equals(ggVar.m408a())) {
            dj.c(this.f17191a);
        } else {
            dj.a(this.f17191a);
        }
    }
}
