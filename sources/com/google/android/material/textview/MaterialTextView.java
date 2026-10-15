package com.google.android.material.textview;

import E5.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import cn.ikaile.ruoshui.client.R;
import p103n5.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public static int c(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i9 = 0; i9 < iArr.length && dimensionPixelSize < 0; i9++) {
            int i10 = iArr[i9];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i10, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        if (b.b(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i9, a.f20607u);
            int iC = c(getContext(), typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iC >= 0) {
                setLineHeight(iC);
            }
        }
    }
}
