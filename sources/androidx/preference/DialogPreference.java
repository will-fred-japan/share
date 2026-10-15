package androidx.preference;

import J.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public DialogPreference(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f7880b, i9, 0);
        if (typedArrayObtainStyledAttributes.getString(9) == null) {
            typedArrayObtainStyledAttributes.getString(0);
        }
        if (typedArrayObtainStyledAttributes.getString(8) == null) {
            typedArrayObtainStyledAttributes.getString(1);
        }
        if (typedArrayObtainStyledAttributes.getDrawable(6) == null) {
            typedArrayObtainStyledAttributes.getDrawable(2);
        }
        if (typedArrayObtainStyledAttributes.getString(11) == null) {
            typedArrayObtainStyledAttributes.getString(3);
        }
        if (typedArrayObtainStyledAttributes.getString(10) == null) {
            typedArrayObtainStyledAttributes.getString(4);
        }
        typedArrayObtainStyledAttributes.getResourceId(7, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
