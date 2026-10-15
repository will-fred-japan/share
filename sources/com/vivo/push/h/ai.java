package com.vivo.push.h;

import java.util.List;

/* JADX INFO: compiled from: OnSetTagsReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class ai implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f16622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f16624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f16625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ah f16626e;

    public ai(ah ahVar, int i9, List list, List list2, String str) {
        this.f16626e = ahVar;
        this.f16622a = i9;
        this.f16623b = list;
        this.f16624c = list2;
        this.f16625d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f16626e;
        ((ag) ahVar).f16620b.onSetTags(((com.vivo.push.t) ahVar).f16804a, this.f16622a, this.f16623b, this.f16624c, this.f16625d);
    }
}
