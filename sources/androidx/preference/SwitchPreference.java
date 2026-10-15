package androidx.preference;

import J.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(Context context, AttributeSet attributeSet) {
        int iA = k.a(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle);
        super(context, attributeSet, iA);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j, iA, 0);
        if (typedArrayObtainStyledAttributes.getString(7) == null) {
            typedArrayObtainStyledAttributes.getString(0);
        }
        if (typedArrayObtainStyledAttributes.getString(6) == null) {
            typedArrayObtainStyledAttributes.getString(1);
        }
        if (typedArrayObtainStyledAttributes.getString(9) == null) {
            typedArrayObtainStyledAttributes.getString(3);
        }
        if (typedArrayObtainStyledAttributes.getString(8) == null) {
            typedArrayObtainStyledAttributes.getString(4);
        }
        typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
