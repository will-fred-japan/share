package com.google.android.material.internal;

import android.graphics.Typeface;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements E5.a.InterfaceC0013a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f13469a;

    public a(b bVar) {
        this.f13469a = bVar;
    }

    @Override // E5.a.InterfaceC0013a
    public final void a(Typeface typeface) {
        b bVar = this.f13469a;
        if (bVar.j(typeface)) {
            bVar.h(false);
        }
    }
}
