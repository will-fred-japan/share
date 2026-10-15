package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dh implements gs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17229a;

    public dh(Context context) {
        this.f17229a = context;
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar) {
    }

    @Override // com.xiaomi.push.gs
    public void b(gp gpVar) {
        dd.m222a(this.f17229a);
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar, Exception exc) {
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar, int i9, Exception exc) {
        dd.a(this.f17229a, gpVar.mo432a(), i9);
    }
}
