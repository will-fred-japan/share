package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends CancellationToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f14657a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14658b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14659c = false;

    public final void a() {
        if (this.f14659c) {
            return;
        }
        synchronized (this.f14658b) {
            try {
                this.f14659c = true;
                Iterator<Runnable> it = this.f14657a.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public boolean isCancellationRequested() {
        return this.f14659c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public CancellationToken register(Runnable runnable) {
        synchronized (this.f14658b) {
            try {
                if (this.f14659c) {
                    runnable.run();
                } else {
                    this.f14657a.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }
}
