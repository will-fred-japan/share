package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class da implements gs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17189a;

    public da(Context context) {
        this.f17189a = context.getApplicationContext();
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar) {
    }

    @Override // com.xiaomi.push.gs
    public void b(gp gpVar) {
        Context context = this.f17189a;
        if (context != null) {
            cy.a(context).m198a();
        }
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar, Exception exc) {
    }

    @Override // com.xiaomi.push.gs
    public void a(gp gpVar, int i9, Exception exc) {
        Context context = this.f17189a;
        if (context != null) {
            cy.a(context).a(i9);
        }
    }
}
