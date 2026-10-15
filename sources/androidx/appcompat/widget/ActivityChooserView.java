package androidx.appcompat.widget;

import T.AbstractC0415b;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f6303a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            int resourceId;
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6303a);
            setBackgroundDrawable((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : C0598e.v(context, resourceId));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public C0491c getDataModel() {
        throw null;
    }

    public z getListPopupWindow() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        throw null;
    }

    public void setActivityChooserModel(C0491c c0491c) {
        throw null;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i9) {
        getContext().getString(i9);
        throw null;
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        throw null;
    }

    public void setDefaultActionButtonContentDescription(int i9) {
    }

    public void setInitialActivityCount(int i9) {
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
    }

    public void setProvider(AbstractC0415b abstractC0415b) {
    }
}
