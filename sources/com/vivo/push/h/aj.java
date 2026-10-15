package com.vivo.push.h;

import java.util.List;

/* JADX INFO: compiled from: OnSetTagsReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class aj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f16627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f16629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f16630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ah f16631e;

    public aj(ah ahVar, int i9, List list, List list2, String str) {
        this.f16631e = ahVar;
        this.f16627a = i9;
        this.f16628b = list;
        this.f16629c = list2;
        this.f16630d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f16631e;
        ((ag) ahVar).f16620b.onSetAlias(((com.vivo.push.t) ahVar).f16804a, this.f16627a, this.f16628b, this.f16629c, this.f16630d);
    }
}
