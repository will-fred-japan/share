package cn.jiguang.commons.a;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class by implements Callable<FutureTask<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FutureTask f9765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bw f9766c;

    public by(bw bwVar, int i9, FutureTask futureTask) {
        this.f9766c = bwVar;
        this.f9764a = i9;
        this.f9765b = futureTask;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ FutureTask<Object> call() {
        ee.a("DeviceDataCollector", "cc:new:" + this.f9764a);
        return this.f9765b;
    }
}
