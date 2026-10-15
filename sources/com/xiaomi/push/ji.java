package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jp f18090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final jy f906a;

    public ji() {
        this(new jl.a());
    }

    public void a(jf jfVar, byte[] bArr) {
        try {
            this.f906a.a(bArr);
            jfVar.a(this.f18090a);
        } finally {
            this.f18090a.k();
        }
    }

    public ji(jr jrVar) {
        jy jyVar = new jy();
        this.f906a = jyVar;
        this.f18090a = jrVar.a(jyVar);
    }
}
