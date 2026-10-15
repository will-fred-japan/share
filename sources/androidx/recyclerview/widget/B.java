package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7913b;

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7918e;

        public final boolean a() {
            int i9;
            int i10;
            int i11;
            int i12 = this.f7914a;
            int i13 = 2;
            if ((i12 & 7) != 0) {
                int i14 = this.f7917d;
                int i15 = this.f7915b;
                if (i14 > i15) {
                    i11 = 1;
                } else {
                    i11 = i14 == i15 ? 2 : 4;
                }
                if ((i11 & i12) == 0) {
                    return false;
                }
            }
            if ((i12 & 112) != 0) {
                int i16 = this.f7917d;
                int i17 = this.f7916c;
                if (i16 > i17) {
                    i10 = 1;
                } else {
                    i10 = i16 == i17 ? 2 : 4;
                }
                if (((i10 << 4) & i12) == 0) {
                    return false;
                }
            }
            if ((i12 & 1792) != 0) {
                int i18 = this.f7918e;
                int i19 = this.f7915b;
                if (i18 > i19) {
                    i9 = 1;
                } else {
                    i9 = i18 == i19 ? 2 : 4;
                }
                if (((i9 << 8) & i12) == 0) {
                    return false;
                }
            }
            if ((i12 & 28672) != 0) {
                int i20 = this.f7918e;
                int i21 = this.f7916c;
                if (i20 > i21) {
                    i13 = 1;
                } else if (i20 != i21) {
                    i13 = 4;
                }
                if ((i12 & (i13 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    public interface b {
        int a();

        int b(View view);

        View c(int i9);

        int d();

        int e(View view);
    }

    public B(b bVar) {
        this.f7912a = bVar;
        a aVar = new a();
        aVar.f7914a = 0;
        this.f7913b = aVar;
    }

    public final View a(int i9, int i10, int i11, int i12) {
        b bVar = this.f7912a;
        int iD = bVar.d();
        int iA = bVar.a();
        int i13 = i10 > i9 ? 1 : -1;
        View view = null;
        while (i9 != i10) {
            View viewC = bVar.c(i9);
            int iB = bVar.b(viewC);
            int iE = bVar.e(viewC);
            a aVar = this.f7913b;
            aVar.f7915b = iD;
            aVar.f7916c = iA;
            aVar.f7917d = iB;
            aVar.f7918e = iE;
            if (i11 != 0) {
                aVar.f7914a = i11;
                if (aVar.a()) {
                    return viewC;
                }
            }
            if (i12 != 0) {
                aVar.f7914a = i12;
                if (aVar.a()) {
                    view = viewC;
                }
            }
            i9 += i13;
        }
        return view;
    }

    public final boolean b(View view) {
        b bVar = this.f7912a;
        int iD = bVar.d();
        int iA = bVar.a();
        int iB = bVar.b(view);
        int iE = bVar.e(view);
        a aVar = this.f7913b;
        aVar.f7915b = iD;
        aVar.f7916c = iA;
        aVar.f7917d = iB;
        aVar.f7918e = iE;
        aVar.f7914a = 24579;
        return aVar.a();
    }
}
