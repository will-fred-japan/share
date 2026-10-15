package androidx.preference;

import J.k;
import android.content.Context;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, k.a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle));
    }
}
