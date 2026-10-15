package com.vivo.push.restructure.request;

import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: CommandRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<I, O> f16787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<O> f16788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16789c;

    private b(a<I, O> aVar) {
        this.f16789c = com.heytap.mcssdk.constant.a.f14256r;
        this.f16787a = aVar;
        if (aVar == null) {
            w.a(JosStatusCodes.RTN_CODE_PARAMS_ERROR, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.f16787a;
    }

    public final c b() {
        return this.f16788b;
    }

    public final long c() {
        return this.f16789c;
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.f16788b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, long j) {
        this(aVar, cVar);
        this.f16789c = j;
    }
}
