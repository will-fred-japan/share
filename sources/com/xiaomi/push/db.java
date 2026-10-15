package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class db implements gu, gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17190a;

    public db(Context context) {
        this.f17190a = context;
    }

    @Override // com.xiaomi.push.gz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo220a(hd hdVar) {
        return true;
    }

    @Override // com.xiaomi.push.gu
    public void a(hd hdVar) {
        dj.b(this.f17190a);
    }

    @Override // com.xiaomi.push.gu
    public void a(gg ggVar) {
        if (ggVar != null && ggVar.a() == 0 && "PING".equals(ggVar.m408a())) {
            dj.d(this.f17190a);
        } else {
            dj.b(this.f17190a);
        }
    }
}
