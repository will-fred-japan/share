package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    private final C0492d mBackgroundTintHelper;
    private C0496h mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<R.b> mPrecomputedTextFuture;
    private a mSuperCaller;
    private final C0503o mTextClassifierHelper;
    private final C0504p mTextHelper;

    public interface a {
        void a(int i9);

        void b(int i9);

        void c(int i9, float f6);
    }

    public class c extends b {
        public c() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public final void a(int i9) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i9);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public final void b(int i9) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i9);
        }
    }

    public class d extends c {
        public d() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public final void c(int i9, float f6) {
            AppCompatTextView.super.setLineHeight(i9, f6);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<R.b> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                androidx.core.widget.d.e(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    private C0496h getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new C0496h(this);
        }
        return this.mEmojiTextViewHelper;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            c0492d.a();
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (Q.f6466c) {
            return super.getAutoSizeMaxTextSize();
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6661e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (Q.f6466c) {
            return super.getAutoSizeMinTextSize();
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6660d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (Q.f6466c) {
            return super.getAutoSizeStepGranularity();
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6659c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (Q.f6466c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0504p c0504p = this.mTextHelper;
        return c0504p != null ? c0504p.f6644i.f6662f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (Q.f6466c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            return c0504p.f6644i.f6657a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.d.f(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public a getSuperCaller() {
        if (this.mSuperCaller == null) {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 34) {
                this.mSuperCaller = new d();
            } else if (i9 >= 28) {
                this.mSuperCaller = new c();
            } else {
                this.mSuperCaller = new b();
            }
        }
        return this.mSuperCaller;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0503o c0503o;
        if (Build.VERSION.SDK_INT >= 28 || (c0503o = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = c0503o.f6635b;
        return textClassifier == null ? C0503o.a.a(c0503o.f6634a) : textClassifier;
    }

    public R.b.a getTextMetricsParamsCompat() {
        return androidx.core.widget.d.a(this);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().f6620b.f18658a.b();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        C0504p.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        A1.b.k1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 30 || i9 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        C0504p c0504p = this.mTextHelper;
        if (c0504p == null || Q.f6466c) {
            return;
        }
        c0504p.f6644i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i9, int i10) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i9, i10);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        super.onTextChanged(charSequence, i9, i10, i11);
        C0504p c0504p = this.mTextHelper;
        if (c0504p == null || Q.f6466c || !c0504p.f6644i.f()) {
            return;
        }
        this.mTextHelper.f6644i.a();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i9, int i10, int i11, int i12) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i9, i10, i11, i12);
            return;
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.i(i9, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i9) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i9);
            return;
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.j(iArr, i9);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i9) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeWithDefaults(i9);
            return;
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.k(i9);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.d.g(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i9) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i9);
        } else {
            androidx.core.widget.d.b(this, i9);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i9) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().a(i9);
        } else {
            androidx.core.widget.d.c(this, i9);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i9) {
        androidx.core.widget.d.d(this, i9);
    }

    public void setPrecomputedText(R.b bVar) {
        androidx.core.widget.d.e(this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.mBackgroundTintHelper;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.l(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.m(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.g(context, i9);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0503o c0503o;
        if (Build.VERSION.SDK_INT >= 28 || (c0503o = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0503o.f6635b = textClassifier;
        }
    }

    public void setTextFuture(Future<R.b> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(R.b.a aVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = aVar.f3902b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i9 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i9 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i9 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i9 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i9 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i9 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i9 = 7;
            }
        }
        setTextDirection(i9);
        getPaint().set(aVar.f3901a);
        setBreakStrategy(aVar.f3903c);
        setHyphenationFrequency(aVar.f3904d);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i9, float f6) {
        boolean z8 = Q.f6466c;
        if (z8) {
            super.setTextSize(i9, f6);
            return;
        }
        C0504p c0504p = this.mTextHelper;
        if (c0504p == null || z8) {
            return;
        }
        r rVar = c0504p.f6644i;
        if (rVar.f()) {
            return;
        }
        rVar.g(i9, f6);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i9) {
        Typeface typefaceCreate;
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        if (typeface == null || i9 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            K.j jVar = K.d.f2750a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i9);
        }
        this.mIsSetTypefaceProcessing = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i9);
        } finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i9, float f6) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            getSuperCaller().c(i9, f6);
        } else if (i10 >= 34) {
            androidx.core.widget.d.b.a(this, i9, f6);
        } else {
            androidx.core.widget.d.d(this, Math.round(TypedValue.applyDimension(i9, f6, getResources().getDisplayMetrics())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        H.a(context);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        F.a(getContext(), this);
        C0492d c0492d = new C0492d(this);
        this.mBackgroundTintHelper = c0492d;
        c0492d.d(attributeSet, i9);
        C0504p c0504p = new C0504p(this);
        this.mTextHelper = c0504p;
        c0504p.f(attributeSet, i9);
        c0504p.b();
        C0503o c0503o = new C0503o();
        c0503o.f6634a = this;
        this.mTextClassifierHelper = c0503o;
        getEmojiTextViewHelper().b(attributeSet, i9);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i9 != 0 ? C0598e.v(context, i9) : null, i10 != 0 ? C0598e.v(context, i10) : null, i11 != 0 ? C0598e.v(context, i11) : null, i12 != 0 ? C0598e.v(context, i12) : null);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i9 != 0 ? C0598e.v(context, i9) : null, i10 != 0 ? C0598e.v(context, i10) : null, i11 != 0 ? C0598e.v(context, i11) : null, i12 != 0 ? C0598e.v(context, i12) : null);
        C0504p c0504p = this.mTextHelper;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    public class b implements a {
        public b() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(int i9) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void b(int i9) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void c(int i9, float f6) {
        }
    }
}
