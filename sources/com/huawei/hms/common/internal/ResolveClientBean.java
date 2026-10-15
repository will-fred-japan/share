package com.huawei.hms.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class ResolveClientBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnyClient f14978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14979c;

    public ResolveClientBean(AnyClient anyClient, int i9) {
        this.f14978b = anyClient;
        this.f14977a = Objects.hashCode(anyClient);
        this.f14979c = i9;
    }

    public void clientReconnect() {
        this.f14978b.connect(this.f14979c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f14978b.equals(((ResolveClientBean) obj).f14978b);
    }

    public AnyClient getClient() {
        return this.f14978b;
    }

    public int hashCode() {
        return this.f14977a;
    }
}
