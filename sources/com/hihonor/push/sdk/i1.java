package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.RequestHeader;

/* JADX INFO: loaded from: classes.dex */
public abstract class i1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u0<TResult> f14497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f14499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f14500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RequestHeader f14501e;

    public i1(String str, e eVar) {
        this.f14498b = str;
        this.f14499c = eVar;
        this.f14500d = g0.b(str);
    }

    public abstract void a(j jVar, Object obj);

    public final void b(j jVar, Object obj) {
        if (this.f14497a != null) {
            a(jVar, obj);
        } else {
            W5.f.n(new StringBuilder("This Task has been canceled, uri:"), this.f14498b, "TaskApiCall");
        }
    }
}
