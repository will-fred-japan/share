package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: KeylineState.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C0156b> f13107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13109d;

    /* JADX INFO: compiled from: KeylineState.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f13110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f13111b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0156b f13113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0156b f13114e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f13112c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13115f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13116g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f13117h = 0.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13118i = -1;

        public a(float f6, float f9) {
            this.f13110a = f6;
            this.f13111b = f9;
        }

        public final void a(float f6, float f9, float f10, boolean z8, boolean z9) {
            float fAbs;
            float f11 = f10 / 2.0f;
            float f12 = f6 - f11;
            float f13 = f11 + f6;
            float f14 = this.f13111b;
            if (f13 > f14) {
                fAbs = Math.abs(f13 - Math.max(f13 - f10, f14));
            } else {
                fAbs = 0.0f;
                if (f12 < 0.0f) {
                    fAbs = Math.abs(f12 - Math.min(f12 + f10, 0.0f));
                }
            }
            b(f6, f9, f10, z8, z9, fAbs, 0.0f, 0.0f);
        }

        public final void b(float f6, float f9, float f10, boolean z8, boolean z9, float f11, float f12, float f13) {
            if (f10 <= 0.0f) {
                return;
            }
            ArrayList arrayList = this.f13112c;
            if (z9) {
                if (z8) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i9 = this.f13118i;
                if (i9 != -1 && i9 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f13118i = arrayList.size();
            }
            C0156b c0156b = new C0156b(Float.MIN_VALUE, f6, f9, f10, z9, f11, f12, f13);
            if (z8) {
                if (this.f13113d == null) {
                    this.f13113d = c0156b;
                    this.f13115f = arrayList.size();
                }
                if (this.f13116g != -1 && arrayList.size() - this.f13116g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f10 != this.f13113d.f13122d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f13114e = c0156b;
                this.f13116g = arrayList.size();
            } else {
                if (this.f13113d == null && f10 < this.f13117h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f13114e != null && f10 > this.f13117h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f13117h = f10;
            arrayList.add(c0156b);
        }

        public final void c(float f6, float f9, float f10, int i9, boolean z8) {
            if (i9 <= 0 || f10 <= 0.0f) {
                return;
            }
            int i10 = 0;
            while (i10 < i9) {
                float f11 = f9;
                float f12 = f10;
                boolean z9 = z8;
                a((i10 * f10) + f6, f11, f12, z9, false);
                i10++;
                f9 = f11;
                f10 = f12;
                z8 = z9;
            }
        }

        public final b d() {
            if (this.f13113d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            int i9 = 0;
            while (true) {
                ArrayList arrayList2 = this.f13112c;
                int size = arrayList2.size();
                float f6 = this.f13110a;
                if (i9 >= size) {
                    return new b(f6, arrayList, this.f13115f, this.f13116g);
                }
                C0156b c0156b = (C0156b) arrayList2.get(i9);
                arrayList.add(new C0156b((i9 * f6) + (this.f13113d.f13120b - (this.f13115f * f6)), c0156b.f13120b, c0156b.f13121c, c0156b.f13122d, c0156b.f13123e, c0156b.f13124f, c0156b.f13125g, c0156b.f13126h));
                i9++;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KeylineState.java */
    public static final class C0156b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f13119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f13120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f13121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f13122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f13123e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f13124f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f13125g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f13126h;

        public C0156b(float f6, float f9, float f10, float f11, boolean z8, float f12, float f13, float f14) {
            this.f13119a = f6;
            this.f13120b = f9;
            this.f13121c = f10;
            this.f13122d = f11;
            this.f13123e = z8;
            this.f13124f = f12;
            this.f13125g = f13;
            this.f13126h = f14;
        }
    }

    public b(float f6, ArrayList arrayList, int i9, int i10) {
        this.f13106a = f6;
        this.f13107b = Collections.unmodifiableList(arrayList);
        this.f13108c = i9;
        this.f13109d = i10;
    }

    public final C0156b a() {
        return this.f13107b.get(this.f13108c);
    }

    public final C0156b b() {
        return this.f13107b.get(0);
    }

    public final C0156b c() {
        return this.f13107b.get(this.f13109d);
    }

    public final C0156b d() {
        List<C0156b> list = this.f13107b;
        return list.get(list.size() - 1);
    }
}
