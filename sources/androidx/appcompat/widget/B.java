package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import cn.ikaile.ruoshui.client.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static B f6375g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, p155u.h<ColorStateList>> f6377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Context, p155u.d<WeakReference<Drawable.ConstantState>>> f6378b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f6379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0495g.a f6381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f6374f = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f6376h = new a(6);

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public static class a extends p155u.f<Integer, PorterDuffColorFilter> {
    }

    public static synchronized B b() {
        try {
            if (f6375g == null) {
                f6375g = new B();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6375g;
    }

    public static synchronized PorterDuffColorFilter e(int i9, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        a aVar = f6376h;
        aVar.getClass();
        int i10 = (31 + i9) * 31;
        porterDuffColorFilterA = aVar.a(Integer.valueOf(mode.hashCode() + i10));
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i9, mode);
            aVar.b(Integer.valueOf(mode.hashCode() + i10), porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    public final Drawable a(Context context, int i9) {
        Drawable drawableNewDrawable;
        WeakReference<Drawable.ConstantState> weakReferenceB;
        if (this.f6379c == null) {
            this.f6379c = new TypedValue();
        }
        TypedValue typedValue = this.f6379c;
        context.getResources().getValue(i9, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            p155u.d<WeakReference<Drawable.ConstantState>> dVar = this.f6378b.get(context);
            drawableNewDrawable = null;
            if (dVar != null && (weakReferenceB = dVar.b(j)) != null) {
                Drawable.ConstantState constantState = weakReferenceB.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    int iB = p163v.a.b(dVar.f21648b, dVar.f21650d, j);
                    if (iB >= 0) {
                        Object[] objArr = dVar.f21649c;
                        Object obj = objArr[iB];
                        Object obj2 = p155u.e.f21651a;
                        if (obj != obj2) {
                            objArr[iB] = obj2;
                            dVar.f21647a = true;
                        }
                    }
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableC = null;
        if (this.f6381e != null) {
            if (i9 == R.drawable.abc_cab_background_top_material) {
                layerDrawableC = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i9 == R.drawable.abc_ratingbar_material) {
                layerDrawableC = C0495g.a.c(this, context, R.dimen.abc_star_big);
            } else if (i9 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableC = C0495g.a.c(this, context, R.dimen.abc_star_medium);
            } else if (i9 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableC = C0495g.a.c(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableC == null) {
            return layerDrawableC;
        }
        layerDrawableC.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableC.getConstantState();
                if (constantState2 != null) {
                    p155u.d<WeakReference<Drawable.ConstantState>> dVar2 = this.f6378b.get(context);
                    if (dVar2 == null) {
                        dVar2 = new p155u.d<>();
                        this.f6378b.put(context, dVar2);
                    }
                    dVar2.d(j, new WeakReference<>(constantState2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawableC;
    }

    public final synchronized Drawable c(Context context, int i9) {
        return d(context, i9, false);
    }

    public final synchronized Drawable d(Context context, int i9, boolean z8) {
        Drawable drawableA;
        try {
            if (!this.f6380d) {
                this.f6380d = true;
                Drawable drawableC = c(context, R.drawable.abc_vector_test);
                if (drawableC == null || (!(drawableC instanceof p172w0.f) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.f6380d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(context, i9);
            if (drawableA == null) {
                drawableA = context.getDrawable(i9);
            }
            if (drawableA != null) {
                drawableA = g(context, i9, z8, drawableA);
            }
            if (drawableA != null) {
                u.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(Context context, int i9) {
        ColorStateList colorStateListB;
        p155u.h<ColorStateList> hVar;
        WeakHashMap<Context, p155u.h<ColorStateList>> weakHashMap = this.f6377a;
        ColorStateList colorStateListD = null;
        colorStateListB = (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) ? null : hVar.b(i9);
        if (colorStateListB == null) {
            C0495g.a aVar = this.f6381e;
            if (aVar != null) {
                colorStateListD = aVar.d(context, i9);
            }
            if (colorStateListD != null) {
                if (this.f6377a == null) {
                    this.f6377a = new WeakHashMap<>();
                }
                p155u.h<ColorStateList> hVar2 = this.f6377a.get(context);
                if (hVar2 == null) {
                    hVar2 = new p155u.h<>();
                    this.f6377a.put(context, hVar2);
                }
                hVar2.a(i9, colorStateListD);
            }
            colorStateListB = colorStateListD;
        }
        return colorStateListB;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6  */
    public final Drawable g(Context context, int i9, boolean z8, Drawable drawable) {
        int i10;
        boolean z9;
        int iRound;
        Drawable drawableMutate;
        ColorStateList colorStateListF = f(context, i9);
        PorterDuff.Mode mode = null;
        if (colorStateListF != null) {
            Drawable drawableMutate2 = drawable.mutate();
            drawableMutate2.setTintList(colorStateListF);
            if (this.f6381e != null && i9 == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
            return drawableMutate2;
        }
        if (this.f6381e != null) {
            if (i9 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int iC = F.c(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = C0495g.f6610b;
                C0495g.a.e(drawableFindDrawableByLayerId, iC, mode2);
                C0495g.a.e(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), F.c(context, R.attr.colorControlNormal), mode2);
                C0495g.a.e(layerDrawable.findDrawableByLayerId(android.R.id.progress), F.c(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i9 == R.drawable.abc_ratingbar_material || i9 == R.drawable.abc_ratingbar_indicator_material || i9 == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int iB = F.b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = C0495g.f6610b;
                C0495g.a.e(drawableFindDrawableByLayerId2, iB, mode3);
                C0495g.a.e(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), F.c(context, R.attr.colorControlActivated), mode3);
                C0495g.a.e(layerDrawable2.findDrawableByLayerId(android.R.id.progress), F.c(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        C0495g.a aVar = this.f6381e;
        boolean z10 = false;
        if (aVar != null) {
            PorterDuff.Mode mode4 = C0495g.f6610b;
            if (C0495g.a.a(aVar.f6613a, i9)) {
                i10 = R.attr.colorControlNormal;
            } else if (C0495g.a.a(aVar.f6615c, i9)) {
                i10 = R.attr.colorControlActivated;
            } else {
                if (C0495g.a.a(aVar.f6616d, i9)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i9 == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i10 = 16842800;
                        z9 = true;
                    } else {
                        if (i9 != R.drawable.abc_dialog_material_background) {
                            i10 = 0;
                            z9 = false;
                        }
                        iRound = -1;
                    }
                    if (z9) {
                        drawableMutate = drawable.mutate();
                        drawableMutate.setColorFilter(C0495g.c(F.c(context, i10), mode4));
                        if (iRound != -1) {
                            drawableMutate.setAlpha(iRound);
                        }
                        z10 = true;
                    }
                }
                i10 = 16842801;
            }
            z9 = true;
            iRound = -1;
            if (z9) {
                drawableMutate = drawable.mutate();
                drawableMutate.setColorFilter(C0495g.c(F.c(context, i10), mode4));
                if (iRound != -1) {
                    drawableMutate.setAlpha(iRound);
                }
                z10 = true;
            }
        }
        if (z10 || !z8) {
            return drawable;
        }
        return null;
    }
}
