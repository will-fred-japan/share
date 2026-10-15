package com.google.android.material.datepicker;

import T.L;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.google.android.material.datepicker.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0553a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f13282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f13283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f13284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f13285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final H5.l f13287f;

    public C0553a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i9, H5.l lVar, Rect rect) {
        A1.b.J0(rect.left);
        A1.b.J0(rect.top);
        A1.b.J0(rect.right);
        A1.b.J0(rect.bottom);
        this.f13282a = rect;
        this.f13283b = colorStateList2;
        this.f13284c = colorStateList;
        this.f13285d = colorStateList3;
        this.f13286e = i9;
        this.f13287f = lVar;
    }

    public static C0553a a(Context context, int i9) {
        A1.b.G0("Cannot create a CalendarItemStyle with a styleResId of 0", i9 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i9, p103n5.a.f20604q);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListA = E5.c.a(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListA2 = E5.c.a(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListA3 = E5.c.a(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        H5.l lVarA = H5.l.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new H5.a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new C0553a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, lVarA, rect);
    }

    public final void b(TextView textView) {
        H5.h hVar = new H5.h();
        H5.h hVar2 = new H5.h();
        H5.l lVar = this.f13287f;
        hVar.setShapeAppearanceModel(lVar);
        hVar2.setShapeAppearanceModel(lVar);
        hVar.k(this.f13284c);
        hVar.f2420a.j = this.f13286e;
        hVar.invalidateSelf();
        H5.h.b bVar = hVar.f2420a;
        ColorStateList colorStateList = bVar.f2445d;
        ColorStateList colorStateList2 = this.f13285d;
        if (colorStateList != colorStateList2) {
            bVar.f2445d = colorStateList2;
            hVar.onStateChange(hVar.getState());
        }
        ColorStateList colorStateList3 = this.f13283b;
        textView.setTextColor(colorStateList3);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3.withAlpha(30), hVar, hVar2);
        Rect rect = this.f13282a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap<View, L> weakHashMap = T.G.f4313a;
        textView.setBackground(insetDrawable);
    }
}
