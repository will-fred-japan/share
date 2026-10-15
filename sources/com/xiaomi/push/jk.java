package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class jk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jp f18091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final jw f907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f908a;

    public jk() {
        this(new jl.a());
    }

    public byte[] a(jf jfVar) {
        this.f908a.reset();
        jfVar.b(this.f18091a);
        return this.f908a.toByteArray();
    }

    public jk(jr jrVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f908a = byteArrayOutputStream;
        jw jwVar = new jw(byteArrayOutputStream);
        this.f907a = jwVar;
        this.f18091a = jrVar.a(jwVar);
    }
}
