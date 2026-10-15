package p056h5;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C extends D {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f19048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f19049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ D f19050e;

    public C(D d9, int i9, int i10) {
        this.f19050e = d9;
        this.f19048c = i9;
        this.f19049d = i10;
    }

    @Override // p056h5.A
    public final Object[] g() {
        return this.f19050e.g();
    }

    @Override // java.util.List
    public final Object get(int i9) {
        y.a(i9, this.f19049d);
        return this.f19050e.get(i9 + this.f19048c);
    }

    @Override // p056h5.A
    public final int h() {
        return this.f19050e.h() + this.f19048c;
    }

    @Override // p056h5.A
    public final int i() {
        return this.f19050e.h() + this.f19048c + this.f19049d;
    }

    @Override // p056h5.A
    public final boolean l() {
        return true;
    }

    @Override // p056h5.D, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final D subList(int i9, int i10) {
        y.b(i9, i10, this.f19049d);
        int i11 = this.f19048c;
        return this.f19050e.subList(i9 + i11, i10 + i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19049d;
    }
}
