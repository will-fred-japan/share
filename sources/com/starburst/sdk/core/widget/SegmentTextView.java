package com.starburst.sdk.core.widget;

import G.RunnableC0310a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class SegmentTextView extends AppCompatTextView {
    private boolean mAutoScrollEnabled;
    private final SpannableStringBuilder mFinalText;
    private final Handler mHandler;
    private int mHighlightColor;
    private boolean mIsFirstCreate;
    private int mLastHeight;
    private int mLastWidth;
    private int mNormalColor;
    private ValueAnimator mScrollAnimator;
    private Runnable mScrollRunnable;
    private CharSequence mTempText;
    private static final int DEFAULT_NORMAL_COLOR = Color.parseColor("#CCCCCC");
    private static final int DEFAULT_HIGHLIGHT_COLOR = Color.parseColor("#FF4081");

    public SegmentTextView(Context context) {
        this(context, null);
    }

    private void autoScroll() {
        post(new D6.a(18, this));
    }

    private void initColors(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, F4.a.f2039a);
        this.mNormalColor = typedArrayObtainStyledAttributes.getColor(1, DEFAULT_NORMAL_COLOR);
        this.mHighlightColor = typedArrayObtainStyledAttributes.getColor(0, DEFAULT_HIGHLIGHT_COLOR);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initViewStyle() {
        setTextColor(this.mNormalColor);
        setLineSpacing(6.0f, 1.2f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$autoScroll$2() {
        int lineTop = getLayout().getLineTop(getLineCount()) - getHeight();
        if (lineTop > 0) {
            scrollTo(0, getPaddingBottom() + lineTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smoothScrollTo$1(int i9, ValueAnimator valueAnimator) {
        scrollTo(i9, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDisplay$0() {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.starburst.sdk.core.widget.SegmentTextView.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SegmentTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                SegmentTextView.this.scrollToBottomReal();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToBottomReal() {
        if (!isAttachedToWindow() || getLayout() == null || getLineCount() == 0) {
            return;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + getLayout().getHeight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (paddingBottom > height) {
            smoothScrollTo(0, paddingBottom - height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(final int i9, int i10) {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollY(), i10);
        this.mScrollAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.starburst.sdk.core.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f16437a.lambda$smoothScrollTo$1(i9, valueAnimator2);
            }
        });
        this.mScrollAnimator.setDuration(300L);
        this.mScrollAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay() {
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) this.mFinalText).append(this.mTempText);
        if (this.mTempText.length() > 0) {
            int length = this.mFinalText.length();
            spannableStringBuilderAppend.setSpan(new ForegroundColorSpan(this.mHighlightColor), length, this.mTempText.length() + length, 33);
        }
        setText(spannableStringBuilderAppend);
        if (this.mAutoScrollEnabled) {
            post(new RunnableC0310a(7, this));
        }
    }

    public void addFinalText(CharSequence charSequence) {
        this.mTempText = "";
        this.mFinalText.append(charSequence);
        updateDisplay();
    }

    public void clearAll() {
        this.mFinalText.clear();
        this.mTempText = "";
        setText("");
        if (this.mAutoScrollEnabled) {
            smoothScrollTo(0, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    public void scrollToBottom() {
        if (isAttachedToWindow()) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            Runnable runnable = new Runnable() { // from class: com.starburst.sdk.core.widget.SegmentTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!SegmentTextView.this.isAttachedToWindow() || SegmentTextView.this.getLayout() == null || SegmentTextView.this.getLineCount() == 0) {
                        return;
                    }
                    int paddingBottom = SegmentTextView.this.getPaddingBottom() + SegmentTextView.this.getPaddingTop() + SegmentTextView.this.getLayout().getLineTop(SegmentTextView.this.getLineCount());
                    int height = (SegmentTextView.this.getHeight() - SegmentTextView.this.getPaddingTop()) - SegmentTextView.this.getPaddingBottom();
                    if (paddingBottom > height) {
                        int i9 = paddingBottom - height;
                        if (SegmentTextView.this.getScrollY() < i9 - 5) {
                            SegmentTextView.this.smoothScrollTo(0, i9);
                        }
                    }
                }
            };
            this.mScrollRunnable = runnable;
            this.mHandler.postDelayed(runnable, 50L);
        }
    }

    public void setAutoScrollEnabled(boolean z8) {
        this.mAutoScrollEnabled = z8;
    }

    public void setColorConfig(int i9, int i10) {
        this.mNormalColor = i9;
        this.mHighlightColor = i10;
        updateDisplay();
    }

    public void setContent(CharSequence charSequence, CharSequence charSequence2) {
        this.mFinalText.clear();
        if (charSequence != null && charSequence.length() > 0) {
            this.mFinalText.append(charSequence);
        }
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        this.mTempText = charSequence2;
        updateDisplay();
    }

    @Override // android.widget.TextView
    public void setHighlightColor(int i9) {
        this.mHighlightColor = i9;
    }

    public void setNormalColor(int i9) {
        this.mNormalColor = i9;
        setTextColor(i9);
    }

    public void updateTemporaryText(CharSequence charSequence) {
        this.mTempText = charSequence;
        updateDisplay();
    }

    public SegmentTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegmentTextView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.mLastHeight = 0;
        this.mLastWidth = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.mFinalText = spannableStringBuilder;
        this.mTempText = "";
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mAutoScrollEnabled = true;
        this.mIsFirstCreate = true;
        initColors(context, attributeSet);
        initViewStyle();
        CharSequence text = getText();
        if (text != null && text.length() > 0) {
            spannableStringBuilder.append(text);
            super.setText("");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.starburst.sdk.core.widget.SegmentTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (SegmentTextView.this.mIsFirstCreate) {
                    SegmentTextView.this.updateDisplay();
                    SegmentTextView.this.mIsFirstCreate = false;
                }
                if (SegmentTextView.this.mLastHeight == SegmentTextView.this.getHeight() && SegmentTextView.this.mLastWidth == SegmentTextView.this.getWidth()) {
                    return;
                }
                SegmentTextView segmentTextView = SegmentTextView.this;
                segmentTextView.mLastHeight = segmentTextView.getHeight();
                SegmentTextView segmentTextView2 = SegmentTextView.this;
                segmentTextView2.mLastWidth = segmentTextView2.getWidth();
                SegmentTextView.this.scrollToBottom();
            }
        });
    }
}
