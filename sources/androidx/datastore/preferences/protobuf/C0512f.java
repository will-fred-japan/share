package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0512f extends AbstractC0513g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7220a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0513g f7222c;

    public C0512f(AbstractC0513g abstractC0513g) {
        this.f7222c = abstractC0513g;
        this.f7221b = abstractC0513g.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7220a < this.f7221b;
    }
}
