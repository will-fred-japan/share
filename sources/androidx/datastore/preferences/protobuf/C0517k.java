package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedOutputStreamWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0517k implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0516j f7277a;

    public C0517k(AbstractC0516j abstractC0516j) {
        C0530y.a(abstractC0516j, "output");
        this.f7277a = abstractC0516j;
        abstractC0516j.f7269b = this;
    }

    public final void a(int i9, Object obj, f0 f0Var) {
        AbstractC0516j abstractC0516j = this.f7277a;
        abstractC0516j.X(i9, 3);
        f0Var.e((Q) obj, abstractC0516j.f7269b);
        abstractC0516j.X(i9, 4);
    }
}
