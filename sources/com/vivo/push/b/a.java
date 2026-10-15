package com.vivo.push.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: AliasCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f16488a;

    public a(boolean z8, String str, ArrayList<String> arrayList) {
        super(z8 ? 2002 : 2003, str);
        this.f16488a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags", this.f16488a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16488a = dVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.w
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
