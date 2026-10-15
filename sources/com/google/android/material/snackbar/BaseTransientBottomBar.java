package com.google.android.material.snackbar;

import E5.c;
import H5.l;
import T.G;
import T.L;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.WeakHashMap;
import p011b4.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f13699a = 0;

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final b f13700i;

        public Behavior() {
            b bVar = new b();
            this.f12912f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            this.f12913g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            this.f12910d = 0;
            this.f13700i = bVar;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f13700i.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    synchronized (J5.b.a().f2688a) {
                    }
                }
            } else if (coordinatorLayout.i(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                synchronized (J5.b.a().f2688a) {
                }
            }
            return super.g(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean s(View view) {
            this.f13700i.getClass();
            return view instanceof SnackbarBaseLayout;
        }
    }

    public static class SnackbarBaseLayout extends FrameLayout {
        public static final a j = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar<?> f13701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f13702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f13704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f13705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f13706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f13707g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ColorStateList f13708h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f13709i;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            Drawable drawable;
            super(K5.a.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, p103n5.a.f20584B);
            if (typedArrayObtainStyledAttributes.hasValue(6)) {
                float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                setElevation(dimensionPixelSize);
            }
            this.f13703c = typedArrayObtainStyledAttributes.getInt(2, 0);
            if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
                this.f13702b = l.b(context2, attributeSet, 0, 0).a();
            }
            this.f13704d = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
            setBackgroundTintList(c.a(context2, typedArrayObtainStyledAttributes, 4));
            setBackgroundTintMode(com.google.android.material.internal.l.d(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.f13705e = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
            this.f13706f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.f13707g = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(j);
            setFocusable(true);
            if (getBackground() == null) {
                int iD = h.D(h.y(this, R.attr.colorSurface), h.y(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
                l lVar = this.f13702b;
                if (lVar != null) {
                    int i9 = BaseTransientBottomBar.f13699a;
                    H5.h hVar = new H5.h(lVar);
                    hVar.k(ColorStateList.valueOf(iD));
                    drawable = hVar;
                } else {
                    Resources resources = getResources();
                    int i10 = BaseTransientBottomBar.f13699a;
                    float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(dimension);
                    gradientDrawable.setColor(iD);
                    drawable = gradientDrawable;
                }
                ColorStateList colorStateList = this.f13708h;
                if (colorStateList != null) {
                    drawable.setTintList(colorStateList);
                }
                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                setBackground(drawable);
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13701a = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.f13705e;
        }

        public int getAnimationMode() {
            return this.f13703c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f13704d;
        }

        public int getMaxInlineActionWidth() {
            return this.f13707g;
        }

        public int getMaxWidth() {
            return this.f13706f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f13701a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.getClass();
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
            }
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            requestApplyInsets();
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f13701a != null) {
                synchronized (J5.b.a().f2688a) {
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
            super.onLayout(z8, i9, i10, i11, i12);
            if (this.f13701a != null) {
                throw null;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i9, int i10) {
            super.onMeasure(i9, i10);
            int i11 = this.f13706f;
            if (i11 <= 0 || getMeasuredWidth() <= i11) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
        }

        public void setAnimationMode(int i9) {
            this.f13703c = i9;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f13708h != null) {
                drawable = drawable.mutate();
                drawable.setTintList(this.f13708h);
                drawable.setTintMode(this.f13709i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f13708h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintList(colorStateList);
                drawableMutate.setTintMode(this.f13709i);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f13709i = mode;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintMode(mode);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                if (this.f13701a == null) {
                    return;
                }
                int i9 = BaseTransientBottomBar.f13699a;
                throw null;
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : j);
            super.setOnClickListener(onClickListener);
        }
    }

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i9 = message.what;
            if (i9 == 0) {
                ((BaseTransientBottomBar) message.obj).getClass();
                throw null;
            }
            if (i9 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).getClass();
            throw null;
        }
    }

    public static class b {
    }

    static {
        LinearInterpolator linearInterpolator = p110o5.a.f20703a;
        new Handler(Looper.getMainLooper(), new a());
    }
}
