package K5;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p089m.c;

/* JADX INFO: compiled from: MaterialThemeOverlay.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2824a = {R.attr.theme, cn.ikaile.ruoshui.client.R.attr.theme};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2825b = {cn.ikaile.ruoshui.client.R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i9, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2825b, i9, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z8 = (context instanceof c) && ((c) context).f20244a == resourceId;
        if (resourceId == 0 || z8) {
            return context;
        }
        c cVar = new c(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f2824a);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            cVar.getTheme().applyStyle(resourceId2, true);
        }
        return cVar;
    }
}
