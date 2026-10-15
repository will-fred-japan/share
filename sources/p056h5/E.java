package p056h5;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class E extends D {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final E f19052e = new E(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f19053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f19054d;

    public E(Object[] objArr, int i9) {
        this.f19053c = objArr;
        this.f19054d = i9;
    }

    @Override // p056h5.A
    public final Object[] g() {
        return this.f19053c;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        y.a(i9, this.f19054d);
        Object obj = this.f19053c[i9];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // p056h5.A
    public final int h() {
        return 0;
    }

    @Override // p056h5.A
    public final int i() {
        return this.f19054d;
    }

    @Override // p056h5.A
    public final boolean l() {
        return false;
    }

    @Override // p056h5.D, p056h5.A
    public final void m(Object[] objArr) {
        System.arraycopy(this.f19053c, 0, objArr, 0, this.f19054d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19054d;
    }
}
