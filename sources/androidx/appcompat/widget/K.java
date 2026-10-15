package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import p056h5.C0598e;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f6420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f6421c;

    public K(Context context, TypedArray typedArray) {
        this.f6419a = context;
        this.f6420b = typedArray;
    }

    public static K e(Context context, AttributeSet attributeSet, int[] iArr, int i9) {
        return new K(context, context.obtainStyledAttributes(attributeSet, iArr, i9, 0));
    }

    public final ColorStateList a(int i9) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = this.f6420b;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (colorStateListB = I.a.b(this.f6419a, resourceId)) == null) ? typedArray.getColorStateList(i9) : colorStateListB;
    }

    public final Drawable b(int i9) {
        int resourceId;
        TypedArray typedArray = this.f6420b;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0) ? typedArray.getDrawable(i9) : C0598e.v(this.f6419a, resourceId);
    }

    public final Drawable c(int i9) {
        int resourceId;
        Drawable drawableD;
        if (!this.f6420b.hasValue(i9) || (resourceId = this.f6420b.getResourceId(i9, 0)) == 0) {
            return null;
        }
        C0495g c0495gA = C0495g.a();
        Context context = this.f6419a;
        synchronized (c0495gA) {
            drawableD = c0495gA.f6612a.d(context, resourceId, true);
        }
        return drawableD;
    }

    public final Typeface d(int i9, int i10, C0504p.a aVar) {
        int resourceId = this.f6420b.getResourceId(i9, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f6421c == null) {
            this.f6421c = new TypedValue();
        }
        TypedValue typedValue = this.f6421c;
        ThreadLocal<TypedValue> threadLocal = J.g.f2623a;
        Context context = this.f6419a;
        if (context.isRestricted()) {
            return null;
        }
        return J.g.b(context, resourceId, typedValue, i10, aVar, true, false);
    }

    public final void f() {
        this.f6420b.recycle();
    }
}
