package com.vivo.push.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: OnListTagReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f16519a;

    public n() {
        super(8);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.f16519a);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16519a = dVar.c("tags_list");
    }

    public final ArrayList<String> e() {
        return this.f16519a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnListTagCommand";
    }
}
