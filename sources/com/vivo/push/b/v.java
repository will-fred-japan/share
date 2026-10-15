package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OnTagsReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class v extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f16540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f16541b;

    public v(int i9) {
        super(i9);
        this.f16540a = null;
        this.f16541b = null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f16540a);
        dVar.a("error_msg", this.f16541b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16540a = dVar.c("content");
        this.f16541b = dVar.c("error_msg");
    }

    public final ArrayList<String> e() {
        return this.f16540a;
    }

    public final List<String> f() {
        return this.f16541b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
