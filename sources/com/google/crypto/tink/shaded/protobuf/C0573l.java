package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedOutputStreamWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0573l implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0572k.a f14118a;

    public C0573l(AbstractC0572k.a aVar) {
        C0585y.a(aVar, "output");
        this.f14118a = aVar;
        aVar.f14114b = this;
    }

    public final void a(int i9, Object obj, e0 e0Var) throws AbstractC0572k.b {
        AbstractC0572k.a aVar = this.f14118a;
        aVar.Q(i9, 3);
        e0Var.e((Q) obj, aVar.f14114b);
        aVar.Q(i9, 4);
    }

    public final void b(int i9, Object obj, e0 e0Var) throws AbstractC0572k.b {
        AbstractC0562a abstractC0562a = (AbstractC0562a) obj;
        AbstractC0572k.a aVar = this.f14118a;
        aVar.Q(i9, 2);
        aVar.S(abstractC0562a.g(e0Var));
        e0Var.e(abstractC0562a, this);
    }
}
