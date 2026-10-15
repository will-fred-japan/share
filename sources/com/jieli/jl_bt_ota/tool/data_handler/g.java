package com.jieli.jl_bt_ota.tool.data_handler;

import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.data.SendDataInfo;
import java.io.IOException;
import p096m7.k;
import p179w7.j;
import p179w7.l;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f16320e;

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, Object obj4, int i9) {
        this.f16316a = i9;
        this.f16317b = obj;
        this.f16318c = obj2;
        this.f16319d = obj3;
        this.f16320e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16316a) {
            case 0:
                ((RcspDataHandler) this.f16317b).a((CommandCallback) this.f16318c, (BaseError) this.f16319d, (SendDataInfo) this.f16320e);
                return;
            default:
                p179w7.b bVar = (p179w7.b) this.f16318c;
                String str = (String) this.f16319d;
                k kVar = (k) this.f16320e;
                p179w7.e eVar = p179w7.e.this;
                try {
                    byte[] bytes = str.getBytes();
                    w7.b.c cVar = bVar.f22149c;
                    if (cVar == null || cVar.f22160d) {
                        throw new IOException("not connected");
                    }
                    cVar.f22159c.write(bytes);
                    p179w7.e.d(eVar, new l(1, kVar));
                    return;
                } catch (Exception e9) {
                    p179w7.e.d(eVar, new j(kVar, e9, 2));
                    return;
                }
        }
    }
}
