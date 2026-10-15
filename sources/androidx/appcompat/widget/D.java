package androidx.appcompat.widget;

/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6400h;

    public final void a(int i9, int i10) {
        this.f6395c = i9;
        this.f6396d = i10;
        this.f6400h = true;
        if (this.f6399g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f6393a = i10;
            }
            if (i9 != Integer.MIN_VALUE) {
                this.f6394b = i9;
                return;
            }
            return;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f6393a = i9;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f6394b = i10;
        }
    }
}
