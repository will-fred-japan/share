package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p145s5.g;

/* JADX INFO: compiled from: KeylineStateList.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f13129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f13130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f13131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f13132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f13133g;

    public c(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f13127a = bVar;
        this.f13128b = Collections.unmodifiableList(arrayList);
        this.f13129c = Collections.unmodifiableList(arrayList2);
        float f6 = ((b) arrayList.get(arrayList.size() - 1)).b().f13119a - bVar.b().f13119a;
        this.f13132f = f6;
        float f9 = bVar.d().f13119a - ((b) arrayList2.get(arrayList2.size() - 1)).d().f13119a;
        this.f13133g = f9;
        this.f13130d = d(f6, arrayList, true);
        this.f13131e = d(f9, arrayList2, false);
    }

    public static float[] d(float f6, ArrayList arrayList, boolean z8) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i9 = 1;
        while (i9 < size) {
            int i10 = i9 - 1;
            b bVar = (b) arrayList.get(i10);
            b bVar2 = (b) arrayList.get(i9);
            fArr[i9] = i9 == size + (-1) ? 1.0f : fArr[i10] + ((z8 ? bVar2.b().f13119a - bVar.b().f13119a : bVar.d().f13119a - bVar2.d().f13119a) / f6);
            i9++;
        }
        return fArr;
    }

    public static b e(b bVar, int i9, int i10, float f6, int i11, int i12, float f9) {
        ArrayList arrayList = new ArrayList(bVar.f13107b);
        arrayList.add(i10, (b.C0156b) arrayList.remove(i9));
        b.a aVar = new b.a(bVar.f13106a, f9);
        float f10 = f6;
        int i13 = 0;
        while (i13 < arrayList.size()) {
            b.C0156b c0156b = (b.C0156b) arrayList.get(i13);
            float f11 = c0156b.f13122d;
            aVar.b((f11 / 2.0f) + f10, c0156b.f13121c, f11, i13 >= i11 && i13 <= i12, c0156b.f13123e, c0156b.f13124f, 0.0f, 0.0f);
            f10 += c0156b.f13122d;
            i13++;
        }
        return aVar.d();
    }

    public static b f(b bVar, float f6, float f9, boolean z8, float f10) {
        int i9;
        List<b.C0156b> list = bVar.f13107b;
        ArrayList arrayList = new ArrayList(list);
        float f11 = bVar.f13106a;
        b.a aVar = new b.a(f11, f9);
        Iterator<b.C0156b> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().f13123e) {
                i10++;
            }
        }
        float size = f6 / (list.size() - i10);
        float f12 = z8 ? f6 : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            b.C0156b c0156b = (b.C0156b) arrayList.get(i11);
            if (c0156b.f13123e) {
                i9 = i11;
                aVar.b(c0156b.f13120b, c0156b.f13121c, c0156b.f13122d, false, true, c0156b.f13124f, 0.0f, 0.0f);
            } else {
                i9 = i11;
                boolean z9 = i9 >= bVar.f13108c && i9 <= bVar.f13109d;
                float f13 = c0156b.f13122d - size;
                float fA = g.a(f13, f11, f10);
                float f14 = (f13 / 2.0f) + f12;
                float f15 = f14 - c0156b.f13120b;
                float f16 = f15;
                if (!z8) {
                    f15 = 0.0f;
                }
                if (z8) {
                    f16 = 0.0f;
                }
                aVar.b(f14, fA, f13, z9, false, c0156b.f13124f, f15, f16);
                f12 += f13;
            }
            i11 = i9 + 1;
        }
        return aVar.d();
    }

    public final b a() {
        List<b> list = this.f13129c;
        return list.get(list.size() - 1);
    }

    public final b b(float f6, float f9, float f10) {
        float fB;
        List<b> list;
        float[] fArr;
        float[] fArr2;
        float f11 = this.f13132f;
        float f12 = f9 + f11;
        float f13 = this.f13133g;
        float f14 = f10 - f13;
        float f15 = c().a().f13125g;
        float f16 = a().c().f13126h;
        if (f11 == f15) {
            f12 += f15;
        }
        if (f13 == f16) {
            f14 -= f16;
        }
        if (f6 < f12) {
            fB = p110o5.a.b(1.0f, 0.0f, f9, f12, f6);
            list = this.f13128b;
            fArr = this.f13130d;
        } else {
            if (f6 <= f14) {
                return this.f13127a;
            }
            fB = p110o5.a.b(0.0f, 1.0f, f14, f10, f6);
            list = this.f13129c;
            fArr = this.f13131e;
        }
        int size = list.size();
        float f17 = fArr[0];
        int i9 = 1;
        while (true) {
            if (i9 >= size) {
                fArr2 = new float[]{0.0f, 0.0f, 0.0f};
                break;
            }
            float f18 = fArr[i9];
            if (fB <= f18) {
                fArr2 = new float[]{p110o5.a.b(0.0f, 1.0f, f17, f18, fB), i9 - 1, i9};
                break;
            }
            i9++;
            f17 = f18;
        }
        b bVar = list.get((int) fArr2[1]);
        b bVar2 = list.get((int) fArr2[2]);
        float f19 = fArr2[0];
        if (bVar.f13106a != bVar2.f13106a) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<b.C0156b> list2 = bVar.f13107b;
        int size2 = list2.size();
        List<b.C0156b> list3 = bVar2.f13107b;
        if (size2 != list3.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            b.C0156b c0156b = list2.get(i10);
            b.C0156b c0156b2 = list3.get(i10);
            arrayList.add(new b.C0156b(p110o5.a.a(c0156b.f13119a, c0156b2.f13119a, f19), p110o5.a.a(c0156b.f13120b, c0156b2.f13120b, f19), p110o5.a.a(c0156b.f13121c, c0156b2.f13121c, f19), p110o5.a.a(c0156b.f13122d, c0156b2.f13122d, f19), false, 0.0f, 0.0f, 0.0f));
        }
        return new b(bVar.f13106a, arrayList, p110o5.a.c(bVar.f13108c, bVar2.f13108c, f19), p110o5.a.c(bVar.f13109d, bVar2.f13109d, f19));
    }

    public final b c() {
        List<b> list = this.f13128b;
        return list.get(list.size() - 1);
    }
}
