package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: renamed from: com.google.android.material.datepicker.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0554b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0553a f13288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0553a f13289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0553a f13290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0553a f13291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0553a f13292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0553a f13293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0553a f13294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f13295h;

    public C0554b(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(E5.b.c(R.attr.materialCalendarStyle, j.class.getCanonicalName(), context).data, p103n5.a.f20603p);
        this.f13288a = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        this.f13294g = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        this.f13289b = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        this.f13290c = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        ColorStateList colorStateListA = E5.c.a(context, typedArrayObtainStyledAttributes, 7);
        this.f13291d = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.f13292e = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        this.f13293f = C0553a.a(context, typedArrayObtainStyledAttributes.getResourceId(10, 0));
        Paint paint = new Paint();
        this.f13295h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
