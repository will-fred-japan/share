package com.vivo.push.h;

import java.util.List;

/* JADX INFO: compiled from: OnDelTagsReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f16642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f16644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f16645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f16646e;

    public m(l lVar, int i9, List list, List list2, String str) {
        this.f16646e = lVar;
        this.f16642a = i9;
        this.f16643b = list;
        this.f16644c = list2;
        this.f16645d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f16646e;
        ((ag) lVar).f16620b.onDelTags(((com.vivo.push.t) lVar).f16804a, this.f16642a, this.f16643b, this.f16644c, this.f16645d);
    }
}
