package H5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public A1.b f2459a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public A1.b f2460b = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public A1.b f2461c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public A1.b f2462d = new k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f2463e = new H5.a(0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f2464f = new H5.a(0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f2465g = new H5.a(0.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f2466h = new H5.a(0.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f2467i = new f();
    public f j = new f();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f2468k = new f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f2469l = new f();

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public A1.b f2470a = new k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public A1.b f2471b = new k();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public A1.b f2472c = new k();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public A1.b f2473d = new k();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f2474e = new H5.a(0.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f2475f = new H5.a(0.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f2476g = new H5.a(0.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f2477h = new H5.a(0.0f);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public f f2478i = new f();
        public f j = new f();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f f2479k = new f();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public f f2480l = new f();

        public static float b(A1.b bVar) {
            if (bVar instanceof k) {
                ((k) bVar).getClass();
                return -1.0f;
            }
            if (bVar instanceof e) {
                ((e) bVar).getClass();
            }
            return -1.0f;
        }

        public final l a() {
            l lVar = new l();
            lVar.f2459a = this.f2470a;
            lVar.f2460b = this.f2471b;
            lVar.f2461c = this.f2472c;
            lVar.f2462d = this.f2473d;
            lVar.f2463e = this.f2474e;
            lVar.f2464f = this.f2475f;
            lVar.f2465g = this.f2476g;
            lVar.f2466h = this.f2477h;
            lVar.f2467i = this.f2478i;
            lVar.j = this.j;
            lVar.f2468k = this.f2479k;
            lVar.f2469l = this.f2480l;
            return lVar;
        }
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public interface b {
        d a(d dVar);
    }

    public static a a(Context context, int i9, int i10, H5.a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i9);
        if (i10 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i10);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(p103n5.a.f20612z);
        try {
            int i11 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i12 = typedArrayObtainStyledAttributes.getInt(3, i11);
            int i13 = typedArrayObtainStyledAttributes.getInt(4, i11);
            int i14 = typedArrayObtainStyledAttributes.getInt(2, i11);
            int i15 = typedArrayObtainStyledAttributes.getInt(1, i11);
            d dVarC = c(typedArrayObtainStyledAttributes, 5, aVar);
            d dVarC2 = c(typedArrayObtainStyledAttributes, 8, dVarC);
            d dVarC3 = c(typedArrayObtainStyledAttributes, 9, dVarC);
            d dVarC4 = c(typedArrayObtainStyledAttributes, 7, dVarC);
            d dVarC5 = c(typedArrayObtainStyledAttributes, 6, dVarC);
            a aVar2 = new a();
            A1.b bVarT = p142s2.j.t(i12);
            aVar2.f2470a = bVarT;
            a.b(bVarT);
            aVar2.f2474e = dVarC2;
            A1.b bVarT2 = p142s2.j.t(i13);
            aVar2.f2471b = bVarT2;
            a.b(bVarT2);
            aVar2.f2475f = dVarC3;
            A1.b bVarT3 = p142s2.j.t(i14);
            aVar2.f2472c = bVarT3;
            a.b(bVarT3);
            aVar2.f2476g = dVarC4;
            A1.b bVarT4 = p142s2.j.t(i15);
            aVar2.f2473d = bVarT4;
            a.b(bVarT4);
            aVar2.f2477h = dVarC5;
            return aVar2;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static a b(Context context, AttributeSet attributeSet, int i9, int i10) {
        H5.a aVar = new H5.a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.t, i9, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i9, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i9);
        if (typedValuePeekValue != null) {
            int i10 = typedValuePeekValue.type;
            if (i10 == 5) {
                return new H5.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i10 == 6) {
                return new j(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean d(RectF rectF) {
        boolean z8 = this.f2469l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.f2467i.getClass().equals(f.class) && this.f2468k.getClass().equals(f.class);
        float fA = this.f2463e.a(rectF);
        return z8 && ((this.f2464f.a(rectF) > fA ? 1 : (this.f2464f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f2466h.a(rectF) > fA ? 1 : (this.f2466h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f2465g.a(rectF) > fA ? 1 : (this.f2465g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f2460b instanceof k) && (this.f2459a instanceof k) && (this.f2461c instanceof k) && (this.f2462d instanceof k));
    }

    public final a e() {
        a aVar = new a();
        aVar.f2470a = new k();
        aVar.f2471b = new k();
        aVar.f2472c = new k();
        aVar.f2473d = new k();
        aVar.f2474e = new H5.a(0.0f);
        aVar.f2475f = new H5.a(0.0f);
        aVar.f2476g = new H5.a(0.0f);
        aVar.f2477h = new H5.a(0.0f);
        aVar.f2478i = new f();
        aVar.j = new f();
        aVar.f2479k = new f();
        new f();
        aVar.f2470a = this.f2459a;
        aVar.f2471b = this.f2460b;
        aVar.f2472c = this.f2461c;
        aVar.f2473d = this.f2462d;
        aVar.f2474e = this.f2463e;
        aVar.f2475f = this.f2464f;
        aVar.f2476g = this.f2465g;
        aVar.f2477h = this.f2466h;
        aVar.f2478i = this.f2467i;
        aVar.j = this.j;
        aVar.f2479k = this.f2468k;
        aVar.f2480l = this.f2469l;
        return aVar;
    }

    public final l f(b bVar) {
        a aVarE = e();
        aVarE.f2474e = bVar.a(this.f2463e);
        aVarE.f2475f = bVar.a(this.f2464f);
        aVarE.f2477h = bVar.a(this.f2466h);
        aVarE.f2476g = bVar.a(this.f2465g);
        return aVarE.a();
    }
}
