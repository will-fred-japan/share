package com.vivo.push.h;

import java.util.List;

/* JADX INFO: compiled from: OnDelTagsReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f16647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f16649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f16650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f16651e;

    public n(l lVar, int i9, List list, List list2, String str) {
        this.f16651e = lVar;
        this.f16647a = i9;
        this.f16648b = list;
        this.f16649c = list2;
        this.f16650d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f16651e;
        ((ag) lVar).f16620b.onDelAlias(((com.vivo.push.t) lVar).f16804a, this.f16647a, this.f16648b, this.f16649c, this.f16650d);
    }
}
