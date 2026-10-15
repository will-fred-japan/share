package com.huawei.hms.framework.common;

import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Surface e(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* bridge */ /* synthetic */ boolean m(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
