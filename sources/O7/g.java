package O7;

import java.util.NoSuchElementException;
import y7.s;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3591d;

    public g(int i9, int i10, int i11) {
        this.f3588a = i11;
        this.f3589b = i10;
        boolean z8 = false;
        if (i11 <= 0 ? i9 >= i10 : i9 <= i10) {
            z8 = true;
        }
        this.f3590c = z8;
        this.f3591d = z8 ? i9 : i10;
    }

    @Override // y7.s
    public final int a() {
        int i9 = this.f3591d;
        if (i9 != this.f3589b) {
            this.f3591d = this.f3588a + i9;
            return i9;
        }
        if (!this.f3590c) {
            throw new NoSuchElementException();
        }
        this.f3590c = false;
        return i9;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3590c;
    }
}
