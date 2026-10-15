package cn.jiguang.commons.a;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class br implements Callable<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bq f9754b;

    public br(bq bqVar, int i9) {
        this.f9754b = bqVar;
        this.f9753a = i9;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ m call() {
        ee.a("DataCollectionController", "create control state:" + this.f9753a);
        m mVar = new m();
        mVar.f10390c = 0L;
        mVar.f10392e = 0;
        return mVar;
    }
}
