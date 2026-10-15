package com.xiaomi.push;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class cc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f170a;

    public cc(String str, WeakReference<Context> weakReference) {
        this.f17128a = str;
        this.f170a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f170a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cn.a(this.f17128a) <= cb.f168a) {
            com.xiaomi.channel.commonutils.logger.c.b("=====> do not need clean db");
            return;
        }
        cf cfVarA = cf.a(this.f17128a);
        ce ceVarA = ce.a(this.f17128a);
        cfVarA.a(ceVarA);
        ceVarA.a(cd.a(context, this.f17128a, 1000));
        cj.a(context).a((cj.a) cfVarA);
    }
}
