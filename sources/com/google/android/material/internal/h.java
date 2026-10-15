package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: ThemeEnforcement.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13544a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13545b = {R.attr.colorPrimaryVariant};

    public static void a(Context context, AttributeSet attributeSet, int i9, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20588F, i9, i10);
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z8) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context, f13545b, "Theme.MaterialComponents");
            }
        }
        c(context, f13544a, "Theme.AppCompat");
    }

    public static void b(Context context, AttributeSet attributeSet, int[] iArr, int i9, int i10, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20588F, i9, i10);
        boolean z8 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i9, i10);
            int length = iArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    typedArrayObtainStyledAttributes2.recycle();
                    z8 = true;
                    break;
                } else {
                    if (typedArrayObtainStyledAttributes2.getResourceId(iArr2[i11], -1) == -1) {
                        typedArrayObtainStyledAttributes2.recycle();
                        break;
                    }
                    i11++;
                }
            }
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z8 = true;
            break;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z8) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i9 = 0; i9 < iArr.length; i9++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i9)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(A.a.i("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static TypedArray d(Context context, AttributeSet attributeSet, int[] iArr, int i9, int i10, int... iArr2) {
        a(context, attributeSet, i9, i10);
        b(context, attributeSet, iArr, i9, i10, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i9, i10);
    }
}
