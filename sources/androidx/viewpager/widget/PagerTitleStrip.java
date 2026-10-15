package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.b
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f8408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<p190y0.a> f8410c;

    public static class a extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Locale f8411a;

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f8411a);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        a aVar = new a();
        aVar.f8411a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(aVar);
    }

    public void a(float f6) {
        throw null;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f8409b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ((ViewPager) parent).getAdapter();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f8408a;
        if (viewPager == null) {
            return;
        }
        p190y0.a adapter = viewPager.getAdapter();
        if (adapter != null) {
            adapter.f22365a.unregisterObserver(null);
            this.f8410c = null;
        }
        ViewPager viewPager2 = this.f8408a;
        if (viewPager2 != null) {
            viewPager2.getCurrentItem();
            throw null;
        }
        this.f8408a.getClass();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        if (this.f8408a != null) {
            a(0.0f);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        if (View.MeasureSpec.getMode(i9) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop(), -2);
        ViewGroup.getChildMeasureSpec(i9, (int) (View.MeasureSpec.getSize(i9) * 0.2f), -2);
        throw null;
    }

    public void setNonPrimaryAlpha(float f6) {
        throw null;
    }

    public void setTextColor(int i9) {
        throw null;
    }

    public void setTextSpacing(int i9) {
        this.f8409b = i9;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }

    public void setGravity(int i9) {
    }
}
