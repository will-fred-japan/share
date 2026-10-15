package p022d0;

import android.graphics.Typeface;
import android.util.SparseArray;
import p031e0.b;

/* JADX INFO: compiled from: MetadataRepo.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f18469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f18470c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f18471d;

    /* JADX INFO: compiled from: MetadataRepo.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f18472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k f18473b;

        public a() {
            this(1);
        }

        public final void a(k kVar, int i9, int i10) {
            int iA = kVar.a(i9);
            SparseArray<a> sparseArray = this.f18472a;
            a aVar = sparseArray == null ? null : sparseArray.get(iA);
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(kVar.a(i9), aVar);
            }
            if (i10 > i9) {
                aVar.a(kVar, i9 + 1, i10);
            } else {
                aVar.f18473b = kVar;
            }
        }

        public a(int i9) {
            this.f18472a = new SparseArray<>(i9);
        }
    }

    public i(Typeface typeface, b bVar) {
        int i9;
        int i10;
        int i11;
        int i12;
        this.f18471d = typeface;
        this.f18468a = bVar;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i13 = iA + bVar.f18588a;
            i9 = bVar.f18589b.getInt(bVar.f18589b.getInt(i13) + i13);
        } else {
            i9 = 0;
        }
        this.f18469b = new char[i9 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i14 = iA2 + bVar.f18588a;
            i10 = bVar.f18589b.getInt(bVar.f18589b.getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            k kVar = new k(this, i15);
            p031e0.a aVarB = kVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? aVarB.f18589b.getInt(iA3 + aVarB.f18588a) : 0, this.f18469b, i15 * 2);
            p031e0.a aVarB2 = kVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i16 = iA4 + aVarB2.f18588a;
                i11 = aVarB2.f18589b.getInt(aVarB2.f18589b.getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            A1.b.G0("invalid metadata codepoint length", i11 > 0);
            p031e0.a aVarB3 = kVar.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i17 = iA5 + aVarB3.f18588a;
                i12 = aVarB3.f18589b.getInt(aVarB3.f18589b.getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            this.f18470c.a(kVar, 0, i12 - 1);
        }
    }
}
