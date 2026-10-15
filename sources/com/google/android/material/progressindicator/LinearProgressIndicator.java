package com.google.android.material.progressindicator;

import D5.b;
import D5.g;

/* JADX INFO: loaded from: classes.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<Object> {
    public int getIndeterminateAnimationType() {
        throw null;
    }

    public int getIndicatorDirection() {
        throw null;
    }

    public int getTrackStopIndicatorSize() {
        throw null;
    }

    @Override // android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        throw null;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        int paddingRight = i9 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i10 - (getPaddingBottom() + getPaddingTop());
        g<Object> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        b<Object> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i9) {
        throw null;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        throw null;
    }

    public void setIndicatorDirection(int i9) {
        throw null;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i9) {
        super.setTrackCornerRadius(i9);
        throw null;
    }

    public void setTrackStopIndicatorSize(int i9) {
        throw null;
    }
}
